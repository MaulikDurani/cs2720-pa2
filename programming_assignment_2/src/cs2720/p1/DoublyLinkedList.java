package cs2720.p1;

public class DoublyLinkedList<T extends Comparable<T>> {
	private Nodetype<T> head;
	public Nodetype<T> tail = null;
	private int length;
	public String elementType = "String";
	private boolean isAscending = true; // Default is true

	/**
	 * Creates a new DoublyLinkedList
	 * Post-Condition: the list is created.
	 */
	public DoublyLinkedList() {
		head = new Nodetype<T>(null);
		length = 0;
	}

	public void insertItem(String str) {
		checkOrder();
		System.out.println(this.isAscending);
	}

	public void deleteItem(String str) {
		checkOrder();
		T temp = (T) str;

	}

	/**
	 * Inserts the specified item into the doubly linked list.
	 * 
	 * @param item
	 */
	public void insertItem(T item) {
		// List should already exist before inserting - no need for exceptions.
		Nodetype<T> newNode = new Nodetype<T>(item);
		Nodetype<T> temp = head;
		System.out.println("newNode: " + newNode.info); // remove later
		// insert first item
		if (head == null) {
			this.head = newNode;
			return;
		}
		// insert item at the beginnning of the list;
		if (newNode.info.compareTo(head.info) < 0) {
			head = newNode;
			newNode.next = temp;
			temp.next.back = newNode;
			return;
		}

		// while (temp != null && temp.getInfo().compareTo(item) < 0) {
		// if (temp.getInfo().compareTo(item) == 0) {
		// System.out.println("Item already exists");
		// return;
		// }
		// if (temp.getInfo().compareTo(item) < 0) {
		// newNode.next = temp.next;
		// newNode.back = temp;
		// return;
		// }
		temp = temp.next;
	}

	public void deleteItem(T item) {
		throw new UnsupportedOperationException();
	}

	public int length() {
		return this.length;
	}

	// public void print() {
	// String list = "";
	// Nodetype<T> temp = this.head;
	// while (temp != null) {
	// list += temp.getInfo() + "";
	// }
	// System.out.println(list);
	// }
	/**
	 * Reverses the doubly linked list.
	 *
	 */
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

	/* Helper Methods */

	/**
	 * Alters boolean of isAscending to assist insert and delete operations.
	 * 
	 * By Ryan Majd
	 */
	private void checkOrder() {
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
	 * Initializes the specified {@link inputString} with the current Object.
	 * Created by Ryan
	 * 
	 * @param inputString
	 */

	public void initialize(T[] Arr) {
		// Convert generic to NodeType objects
		this.head = new Nodetype<T>((T) Arr[0]);
		this.tail = new Nodetype<T>((T) Arr[Arr.length - 1]);
		Nodetype<T> current = head;

		for (int i = 1; i < Arr.length; i++) {
			Nodetype<T> newNode = new Nodetype<T>((T) Arr[i]);
			current.setNext(newNode);
			newNode.setPrev(current);
			current = newNode;
		}

		length = Arr.length;
	} // initialize

	/**
	 * 
	 * @param doubleArray
	 */
	public void initialize(Double[] doubleArray) {
		if (doubleArray.length == 0) {
			return;
		}

		// Convert Double array to NodeType objects using Casting to NodeType
		// Due to previous methods and implementation, there should not be an error
		// here.
		this.head = new Nodetype<T>((T) doubleArray[0]);
		this.tail = new Nodetype<T>((T) doubleArray[doubleArray.length - 1]);
		Nodetype<T> current = head;

		for (int i = 1; i < doubleArray.length; i++) {
			Nodetype<T> newNode = new Nodetype<T>((T) doubleArray[i]);
			current.setNext(newNode);
			newNode.setPrev(current);
			current = newNode;
		}
		length = doubleArray.length;
	} // init double array

	/**
	 * Initialization of the array to a Doubly Linked List.
	 * By Ryan Majd
	 * 
	 * @param integerArray
	 */
	public void initialize(Integer[] integerArray) {
		if (integerArray.length == 0) {
			return;
		}

		// Convert Integer array to NodeType objects
		this.head = new Nodetype<T>((T) integerArray[0]);
		this.tail = new Nodetype<T>((T) integerArray[integerArray.length - 1]);
		Nodetype<T> current = head;

		for (int i = 1; i < integerArray.length; i++) {
			Nodetype<T> newNode = new Nodetype<T>((T) integerArray[i]);
			current.setNext(newNode);
			newNode.setPrev(current);
			current = newNode;
		}
		length = integerArray.length;
	}

	/**
	 * Initializes the beginning string to create an array for easier ingestion into
	 * the ADT.
	 * 
	 * By Ryan Majd
	 * 
	 * @param string
	 */
	public void initialize(String string) {
		String[] stringArray = string.split(" ");
		if (stringArray.length == 0) {
			return;
		}

		// Convert String array to NodeType objects
		this.head = new Nodetype<T>((T) stringArray[0]);
		this.tail = new Nodetype<T>((T) stringArray[stringArray.length - 1]);
		Nodetype<T> current = head;

		for (int i = 1; i < stringArray.length; i++) {
			Nodetype<T> newNode = new Nodetype<T>((T) stringArray[i]);
			current.setNext(newNode);
			newNode.setPrev(current);
			current = newNode;
		}

		length = stringArray.length;
	} // init String string

	/**
	 * Helper method to check the type of List.
	 * By Ryan Majd
	 * 
	 * 
	 * @param elements
	 * @return
	 */
	private boolean isDoubleArray(String[] elements) {
		for (String element : elements) {
			try {
				Double.parseDouble(element);
			} catch (NumberFormatException e) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Boolean method checks if the array provided is an Integer array.
	 * Created by Ryan Majd
	 * 
	 * @param elements
	 * @return
	 */
	private boolean isIntArray(String[] elements) {
		for (String element : elements) {
			try {
				Integer.parseInt(element);
			} catch (NumberFormatException e) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns the number of elements in the given DoublyLinkedList
	 * By Ryan Majd
	 */
	public String toString() {
		String list = "";
		Nodetype<T> current = this.head;
		for (int i = 0; i < this.length; i++) {
			if (i < this.length - 1) {
				list += current.getInfo() + " ";
			} else {
				list += current.getInfo() + "";
			}
			current = current.getNext();
		} // for loop iteration
		list = list.replaceAll("\n", "");
		return list;

	} // toString()

}
