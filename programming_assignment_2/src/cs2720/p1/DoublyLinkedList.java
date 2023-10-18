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
	private int length;
	public String elementType = "String";
	private boolean isAscending = true; // Default is true

	/**
	 * Creates a new DoublyLinkedList
	 * Post-Condition: the list is created.
	 */
	public DoublyLinkedList() {
		head = new Nodetype<T>(null);
		tail = new Nodetype<T>(null);
		length = 0;
	}

	public void insertItem(String str) {
		checkOrder(); // will check list and set isAscending to true or false
		// cast string to T
		T cast = (T) str;
		insertItem(cast);
	}

	public void deleteItem(String str) {
		checkOrder();
		T cast = (T) str;
		deleteItem(cast);
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
		// List should already exist before inserting - no need for exceptions.
		Nodetype<T> newNode = new Nodetype<T>(item);
		if (this.head == null) {
			this.head = newNode;
			this.tail = newNode;
			length++;
			return;
		} // Inserting into an empty list
		int compareResult;
		Nodetype<T> current = head;
		Nodetype<T> prev = null;

		// Traverse the list and find index to place item
		while (current != null) {
			compareResult = item.compareTo(current.getInfo());

			if (isAscending && compareResult <= 0) {
				break;
			}
			if (!isAscending && compareResult >= 0) {
				break;
			}
			prev = current;
			current = current.getNext();
		} // while loop

		// Inserting before or after the curr node
		newNode.setNext(current);
		if (current != null) {
			current.setPrev(newNode);
		} // if
		if (prev != null) {
			prev.setNext(newNode);
		} else {
			this.head = newNode;
		} // if else
		newNode.setPrev(prev);
		if (current == null) {
			this.tail = newNode;
		}
		this.length++;
	} // insert item

	public void deleteItem(T item) {
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

		Nodetype<T> current = head;

		while (current.getNext() != null) {
			if (current.getInfo().compareTo(a) >= 0 &&
					current.getInfo().compareTo(b) <= 0) {
				this.deleteItem(current.getInfo());
			}
			current = current.getNext();
		}

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

		while (current != null && current.getNext() != null) {
			Nodetype<T> temp = current.getNext();
			current.setNext(current.getNext().getNext());
			temp.setNext(current);
			current = current.getNext();
			if (current != null && current.getNext() != null) {
				temp.getNext().setNext(current.getNext());
			}
		}
	}

	/**
	 * Returns the number of elements in the given DoublyLinkedList
	 * By Ryan Majd
	 */
	public String toString() {
		String list = "";
		Nodetype<T> current = this.head;
		for (int i = 0; i < this.length; i++) {
			list += current.getInfoToString() + " ";
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
		int ans = this.head.getInfo().compareTo(this.tail.getInfo());
		if (ans < 0) {
			this.isAscending = true;
			return;
		} else if (ans > 0) {
			this.isAscending = false;
			return;
		} else {
			throw new IllegalArgumentException("Invalid list");
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

		this.head = new Nodetype((T) stringArray[0]);
		this.tail = new Nodetype((T) stringArray[stringArray.length - 1]);
		Nodetype<T> current = head;

		for (int i = 1; i < stringArray.length; i++) {
			Nodetype<T> newNode = new Nodetype((T) stringArray[i]);
			current.setNext(newNode);
			newNode.setPrev(current);
			current = newNode;
		}

		length = stringArray.length;
	} // init from string

	/**
	 * Checks if the given item is in the list.
	 * 
	 * @param item the item to check for in the list
	 * @return true if the item is in the list, false otherwise
	 *         By Ryan Majd
	 * @deprecated Problem with this method that won't read the last elemenet in the
	 *             dll.
	 * 
	 */
	private boolean itemIsInList(T item) {
		// if (item.toString().equals("Macy")) {
		// return true;
		// }
		Nodetype<T> checker = this.head;
		while (checker != null) {
			if (checker.getInfo().compareTo(item) == 0) {
				return true;
			} else if (checker.getInfoToString().equals(item.toString())) {
				return true;
			}
			checker = checker.getNext();
		}
		return false;
	} // itemIsInList

}
// DLL.java
