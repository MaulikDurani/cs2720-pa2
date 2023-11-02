package cs2720.p1;

/**
 * This class represents a Doubly Linked List that can store elements of type T.
 * It provides methods to insert and delete elements, check if an element is in
 * the list,
 * print the list in reverse order, delete a subsection of the list, and swap
 * adjacent nodes.
 * The list can be sorted in ascending or descending order based on the order of
 * the elements.
 * 
 * @param <T> the type of elements that can be stored in the list, must
 *            implement Comparable interface.
 * 
 * 
 */
public class DoublyLinkedList<T extends Comparable<T>> {
	private Nodetype<T> head, tail;
	private int length = 0;
	@SuppressWarnings("unused")
	private boolean isAscending = true; // Default is true

	/**
	 * Creates a new DoublyLinkedList
	 * Post-Condition: the list is created.
	 */
	public DoublyLinkedList() {
		head = (null);
		tail = (null);
		length = 0;
	}

	@SuppressWarnings("unchecked")
	public T convertToType(String input) {
		String lInput = input.toLowerCase();
		if (input.contains(".")) {
			double d = Double.parseDouble(input);
			return (T) (Comparable) d;
		} else if (lInput.matches("[0-9]+")) {
			Integer i = Integer.parseInt(input);
			return (T) i;
		}
		return (T) input;
	}

	public void deleteItem(String str) {
		checkOrder();
		T dt = convertToType(str);
		deleteItem(dt);
	}

	public void convertAndInsert(String input) {
		T dt = convertToType(input);
		insertItem(dt);
	}

	public void initAndInsert(String input) {
		T dt = convertToType(input);
		insertItem(dt, true);
	}

	/**
	 * Inserts an item into the doubly linked list in ascending or descending order
	 * based on the isAscending flag.
	 * If the item already exists in the list, it will not be inserted.
	 * 
	 * @param item        the item to be inserted into the list
	 * @param isAscending a boolean flag indicating whether the list should be
	 *                    sorted in ascending or descending order
	 * @throws NullPointerException if the item is null
	 * 
	 *                              By Ryan Majd
	 * 
	 */
	public void insertItem(T item) {
		if (item == null) {
			throw new NullPointerException("item to be inserted is null or empty");
		}
		if (itemIsInList(item)) {
			System.out.println("Item already exists");
			return;
		}
		Nodetype<T> newNode = new Nodetype<T>(item);
		if (this.head == null) {
			this.head = newNode;
			this.tail = newNode;
			this.length = 1;
			return;
		} // Inserting into an empty list
		if (item.compareTo(this.head.getInfo()) < 0) {
			newNode.setNext(this.head);
			this.head.setPrev(newNode);
			this.head = newNode;
			this.length++;
			return;
		}
		Nodetype<T> current = this.head;
		Nodetype<T> prev = this.head;
		// Traverse the list and find index to place item
		while (current != null && (current.getInfo().compareTo(item) < 0)) {
			prev = current;
			current = current.getNext();
		} // while loop
		if (current == null) { // newNode should go to the end of the list
			prev.setNext(newNode); // set the tail to -> newNode
			this.tail = newNode;
			newNode.setPrev(prev);
			this.length++;
			return;
		} else {
			prev.setNext(newNode);
			current.setPrev(newNode);
			newNode.setNext(current);
			newNode.setPrev(prev);
			this.length++;
			return;
		}
	} // insert item

	public void insertItem(T item, boolean isInit) {
		Nodetype<T> newNode = new Nodetype<T>(item);
		if (this.head == null) {
			this.head = newNode;
			this.tail = newNode;
			this.length = 1;
		} else {
			newNode.setPrev(this.tail);
			this.tail.setNext(newNode);
			this.tail = newNode;
			this.length++;
		}
	} // insert

	public void deleteItem(T item) {
		if (length == 0) {
			System.out.println("You cannot delete from an empty list");
			return;
		}
		if (item == null) {
			throw new NullPointerException("Not a valid item to delete.");
		} else if (!itemIsInList(item)) {
			System.out.println("The item is not present in the list");
			return;
		}
		Nodetype<T> current = this.head;
		while (current != null) {
			if (current.getInfo().compareTo(item) == 0) {
				// If the item is in the current place, remove it
				Nodetype<T> prev = current.getBack();
				Nodetype<T> next = current.getNext();

				if (prev != null) {
					prev.setNext(next);
				} else {
					// If it's the head, update the head
					head = next;
					if (head != null) {
						head.setPrev(null); // Set the previous of the new head to null
					}
				}

				if (next != null) {
					next.setPrev(prev);
				} else {
					// If it's the tail, update the tail
					tail = prev;
				}

				// Nullify the item and references
				current.setNext(null);
				current.setPrev(null);
				current.info = null;

				// Break out of the loop after deleting the item
				break;
			}
			current = current.getNext();
		}

		this.length--;
	} // delete items

	/**
	 * Returns length of list as an int.
	 * 
	 * @return int length of list.
	 *         By : Ryan Majd
	 */
	public int length() {
		return this.length;
	}

	public void printReverse() {
		Nodetype<T> temp = head;
		Nodetype<T> revNode = null;
		Nodetype<T> revHead = null;

		while (temp != null) {
			revHead = revNode;
			revNode = temp;
			temp = temp.getNext();
			revNode.setNext(revHead);
			revNode.setPrev(temp);
		}

		this.head = revNode;
		this.tail = revHead;
	}

	/**
	 * Deletes any value within the range a and b (inclusive)
	 *
	 * @param a the lower bound (inclusive)
	 * @param b the upper bound (inclusive)
	 */
	public void deleteSubsection(T a, T b) {
		if (this.length() == 0) {
			return;
		}
		T x = convertToType(a + "");
		T y = convertToType(b + "");
		Nodetype<T> current = this.head;
		Nodetype<T> currentNext = current.getNext();
		while (current != null) {
			currentNext = current.getNext();
			if (current.getInfo().compareTo(x) >= 0 &&
					current.getInfo().compareTo(y) <= 0) {
				deleteItem(current.getInfo());
			}
			current = currentNext;
			if (current == null) {
				return;
			}
		}
	}

	public void deleteSubsection(String one, String two) {
		T a = convertToType(one);
		T b = convertToType(two);
		deleteSubsection(a, b);
	}

	/**
	 * Swaps adjacent nodes.
	 *
	 */
	public void swapAlternate() {
		if (head == null || head.getNext() == null) {
			return;
		}

		Nodetype<T> current = head;
		Nodetype<T> newHead = head.getNext();
		while (current != null && current.getNext() != null) {
			Nodetype<T> temp = current.getNext();
			current.setNext(current.getNext().getNext());
			temp.setNext(current);
			current = current.getNext();
			if (current != null && current.getNext() != null) {
				temp.getNext().setNext(current.getNext());
			}
		}
		head = newHead;
	}

	/**
	 * Returns the number of elements in the given DoublyLinkedList
	 * By Ryan Majd
	 */
	public String toString() {
		String list = "";
		Nodetype<T> current = this.head;
		for (int i = 0; i < this.length; i++) {
			list += current.getInfo() + " ";
			current = current.getNext();
		} // for loop iteration
		list = list.replaceAll("\n", "");
		return list.trim();

	} // toString()

	/***************************** Helper Methods ****************************/

	/**
	 * Alters boolean of isAscending to assist insert and delete operations.
	 * 
	 * By Ryan Majd
	 */
	private void checkOrder() {
		if (this.head == null) {
			this.isAscending = true;
			return;
		} // if
		try {
			int ans = this.head.getInfo().compareTo(this.tail.getInfo());
			if (ans < 0) {
				this.isAscending = true;
				return;
			} else if (ans > 0) {
				this.isAscending = false;
				return;
			}
		} catch (NullPointerException npe) {
			System.out.print("");
		}

	} // check order

	/**
	 * Initializes the doubly linked list with the elements of the given array.
	 * If the array is empty, the list remains empty.
	 * The first element of the array becomes the head of the list and the last
	 * element becomes the tail.
	 * Each element of the array is added to the list in the order they appear in
	 * the array.
	 * 
	 * By : Ryan Majd
	 * 
	 * @param array the array of elements to initialize the list with
	 */
	public void initializeFromArray(T[] array) {
		if (array.length == 0) {
			return;
		}

		this.head = new Nodetype<>(array[0]);
		this.tail = new Nodetype<>(array[array.length - 1]);
		Nodetype<T> current = head;

		for (int i = 1; i < array.length; i++) {
			Nodetype<T> newNode = new Nodetype<>(array[i]);
			current.setNext(newNode);
			newNode.setPrev(current);
			current = newNode;
		}

		length = array.length;
	} // init from Arr

	/**
	 * Initializes the doubly linked list from a string by splitting it into an
	 * array of strings and creating a new node for each string.
	 * The first node is set as the head and the last node is set as the tail.
	 * Each node is linked to the previous and next nodes to form a doubly linked
	 * list.
	 * 
	 * By: Ryan Majd
	 * 
	 * @param string the string to initialize the doubly linked list from
	 * @param <T>    the type of the elements in the doubly linked list
	 */
	public void initializeFromString(String string) {
		String[] stringArray = string.split(" ");
		if (stringArray.length == 0) {
			return;
		}
		for (int i = 0; i < stringArray.length; i++) {
			stringArray[i] = stringArray[i].trim();
			initAndInsert(stringArray[i]);
		}
		length = stringArray.length;
	} // init from string

	/**
	 * Checks if the given item is in the list.
	 * 
	 * @param item the item to check for in the list
	 * @return true if the item is in the list, false otherwise
	 *         By Ryan Majd
	 * 
	 */
	private boolean itemIsInList(T item) {
		T cast = convertToType(item + "");
		Nodetype<T> checker = this.head;
		while (checker != null) {
			if (checker.getInfo().compareTo(cast) == 0) {
				return true;
			}
			checker = checker.getNext();
		}
		return false;
	} // itemIsInList
}
// DLL.java
