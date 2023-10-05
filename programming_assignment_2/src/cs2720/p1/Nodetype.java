package cs2720.p1;

public class Nodetype<T extends Comparable<T>> {
    public T info;
    public Nodetype<T> next;
    public Nodetype<T> back;

    // Returns the info of this NodeType object
    public T getInfo() {
	return this.info;
    }

    // Returns the next node of this NodeType object
    public Nodetype<T> getNext() {
	return this.next;
    }

    // Returns the previous node of this NodeType object
    public Nodetype<T> getBack() {
	return this.back;
    }
}
