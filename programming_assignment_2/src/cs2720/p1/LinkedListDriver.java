package cs2720.p1;

import java.io.*;
import java.util.*;

public class LinkedListDriver<T extends Comparable<T>> {
	public static void main(String[] args) throws FileNotFoundException {
		DoublyLinkedList dll = new DoublyLinkedList();
		File file = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter list type (i - int, d - double, s - std:string): ");
		String choice = sc.nextLine();
		sc.close();
		// File "creation"
		switch (choice) {
			case ("i"): {
				file = new File("resources/int-input.txt");
				break;
			}
			case ("d"): {
				file = new File("resources/double-input.txt");
				break;
			}
			case ("s"): {
				file = new File("resources/string-input.txt");
				break;
			}
		} // end of switch statement

		System.out.print(readData(file));

	} // main

	/** file creation will be updated to create the dll objects later on */
	private static String readData(File file) throws FileNotFoundException {
		try (Scanner reader = new Scanner(file)) {
			StringBuilder dataset = new StringBuilder();

			while (reader.hasNextLine()) {
				dataset.append(reader.nextLine()).append("\n");
			}

			Scanner read = new Scanner(dataset.toString()); // gonna figure this out later
			// String str = ;
			return (dataset.toString());
		} catch (FileNotFoundException fnfe) {
			return "not a string";
		}

	} // readData()

}// Linked List driver class
