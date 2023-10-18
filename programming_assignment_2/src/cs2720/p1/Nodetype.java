package cs2720.p1;

public class Nodetype<T extends Comparable<T>> {
    public T info;
    public Nodetype<T> next;
    public Nodetype<T> back;

    /**
     * Constructs a new instance of Nodetype from the given info
     * By Ryan Majd
     * 
     * @param info
     */
    public Nodetype(T info) {
        this.info = info;
        this.next = null;
        this.back = null;
    }

    // Returns the info of this NodeType object
    public T getInfo() {
        return this.info;
    }

    public String getInfoToString() {
        String ans = this.info.toString().trim();
        ans = ans.replaceAll("\n", "");
        return ans;
    }

    // Returns the next node of this NodeType object
    public Nodetype<T> getNext() {
        return this.next;
    }

    // Returns the previous node of this NodeType object
    public Nodetype<T> getBack() {
        return this.back;
    }

    /**
     * Setter method for this NodeType object
     * By Ryan Majd
     * 
     * @param next
     */
    public void setNext(Nodetype<T> next) {
        this.next = next;
    }

    /**
     * setter method for previous node of this NodeType object
     * by Ryan Majd
     * 
     * @param back
     */
    public void setPrev(Nodetype<T> back) {
        this.back = back;
    }

} // NodeType class
