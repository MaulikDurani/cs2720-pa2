package cs2720.p1;

import java.io.*;
import java.util.*;

public class LinkedListDriver<T extends Comparable<T>> {
    public static void main(String[] args) {
	try {
	    
	    DoublyLinkedList dll = new DoublyLinkedList();
	    
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter list type (i - int, d - double, s - std:string): ");
	    String choice = sc.nextLine();
	    sc.close();
	    File file = null;
	    // File "creation"
	    if (choice.equals("i")) {
		file = new File("int-input.txt");
	    } else if (choice.equals("d")) {
		file = new File("double-input.txt");
	    } else if (choice.equals("s")) {
		file = new File("string-input.txt");
	    }
	    
	    // Copying contents of file into String dataset
	    Scanner reader = new Scanner(file);
	    String dataset = reader.nextLine();
	    reader.close();
	    
	    Scanner read = new Scanner(dataset);
	    
	    while (read.hasNext()) {
		dll.insertItem(read.next());
	    }
	    read.close();
	    
	    dll.print();
	    
	} catch (FileNotFoundException fnfe) {
	    System.err.println("FileNotFound");
	}
	
    }
}
