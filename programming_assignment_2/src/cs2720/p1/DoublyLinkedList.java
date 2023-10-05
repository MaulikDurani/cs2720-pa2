package cs2720.p1;

public class DoublyLinkedList<T extends Comparable<T>> {
    private Nodetype<T> head;
    private int length;
    
    public DoublyLinkedList() {
	head = new Nodetype<T>();
	length = 0;
    }

    public void insertItem(T item) {
	Nodetype<T> newNode = new Nodetype<T>();
	newNode.info = item;
	Nodetype<T> temp = head;
	System.out.println("newNode: " + newNode.info);
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
	    if (temp.getInfo().compareTo(item) < 0){
		newNode.next = temp.next;
		newNode.back = temp;
		return;
	    }
	    temp = temp.next;
	    
	}
	
    }

    public void deleteItem(T item) {

    }

    public int length() {
	return this.length;
    }

    public void print() {
	String list = "";
	Nodetype temp = head;
	while (temp != null) {
	    list += temp.getInfo() + " ";
	}
	System.out.println(list);
    }

    public void printReverse() {

    }

    

			    
}
