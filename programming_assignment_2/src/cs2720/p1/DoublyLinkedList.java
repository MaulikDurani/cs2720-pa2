package cs2720.p1;

public class DoublyLinkedList<T extends Comparable<T>> {
	private Nodetype<T> head;
	private int length;

	/**
	 * Creates a new DoublyLinkedList
	 * Post-Condition: the list is created.
	 */
	public DoublyLinkedList() {
		head = new Nodetype<T>(null);
		length = 0;
	}

	public void insertItem(T item) {
		Nodetype<T> newNode = new Nodetype<T>(item);
		newNode.info = item;
		Nodetype<T> temp = head;
		System.out.println("newNode: " + newNode.info); // remove later
		// insert first item
		if (head == null) {
			head = newNode;
			return;
		}

		// insert item at the beginnning of the list;
		if (newNode.info.compareTo(head.info) < 0) {
			head = newNode;
			newNode.next = temp;
			temp.next.back = newNode;
			return;
		}

		while (temp != null && temp.getInfo().compareTo(item) < 0) {
			if (temp.getInfo().compareTo(item) == 0) {
				System.out.println("Item already exists");
				return;
			}
			if (temp.getInfo().compareTo(item) < 0) {
				newNode.next = temp.next;
				newNode.back = temp;
				return;
			}
			temp = temp.next;

		}

	}

	public void deleteItem(T item) {
		throw new UnsupportedOperationException();
	}

	public int length() {
		return this.length;
	}

	public void print() {
		String list = "";
		Nodetype<T> temp = head;
		while (temp != null) {
			list += temp.getInfo() + " ";
		}
		System.out.println(list);
	}

	public void printReverse() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Created by Ryan
	 * 
	 */
	public void deleteSubsection() {
		throw new UnsupportedOperationException();
	}

	/* Helper Methods */

	/**
	 * Initializes the specified {@link inputString} with the current Object.
	 * Created by Ryan
	 * 
	 * @param inputString
	 */

	public void initialize(T[] Arr) {
		// Convert generic to NodeType objects
		this.head = new Nodetype<T>((T) Arr[0]);
		Nodetype<T> current = head;

		for (int i = 1; i < Arr.length; i++) {
			Nodetype<T> newNode = new Nodetype<T>((T) Arr[i]);
			current.setNext(newNode);
			newNode.setPrev(current);
			current = newNode;
		}

		length = Arr.length;
	} // initialize

	public void initialize(Double[] doubleArray) {
		if (doubleArray.length == 0) {
			return;
		}

		// Convert Double array to NodeType objects
		this.head = new Nodetype<T>((T) doubleArray[0]);
		Nodetype<T> current = head;

		for (int i = 1; i < doubleArray.length; i++) {
			Nodetype<T> newNode = new Nodetype<T>((T) doubleArray[i]);
			current.setNext(newNode);
			newNode.setPrev(current);
			current = newNode;
		}
		length = doubleArray.length;
	} // init double array

	public void initialize(Integer[] integerArray) {
		if (integerArray.length == 0) {
			return;
		}

		// Convert Integer array to NodeType objects
		this.head = new Nodetype<T>((T) integerArray[0]);
		Nodetype<T> current = head;

		for (int i = 1; i < integerArray.length; i++) {
			Nodetype<T> newNode = new Nodetype<T>((T) integerArray[i]);
			current.setNext(newNode);
			newNode.setPrev(current);
			current = newNode;
		}
		length = integerArray.length;
	}

	public void initialize(String string) {
		String[] stringArray = string.split(" ");
		if (stringArray.length == 0) {
			return;
		}

		// Convert String array to NodeType objects
		this.head = new Nodetype<T>((T) stringArray[0]);
		Nodetype<T> current = head;

		for (int i = 1; i < stringArray.length; i++) {
			Nodetype<T> newNode = new Nodetype<T>((T) stringArray[i]);
			current.setNext(newNode);
			newNode.setPrev(current);
			current = newNode;
		}

		length = stringArray.length;
	}

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
		String str = "Length: " + this.length + "\n";
		Nodetype<T> current = this.head;
		for (int i = 0; i < this.length; i++) {
			str += current.getInfo() + "\n";
			current = current.getNext();
		} // for loop iteration

		return str;
	}

}
