package cs2720.p1;

import java.io.*;
import java.util.*;

public class LinkedListDriver<T extends Comparable<T>> {
	/**
	 * Main method of Driver to run program.
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		File file = null;
		Scanner sc = new Scanner(System.in);
		// Scanner scan;
		boolean quit = false;
		boolean badPrevAns = false;
		System.out.print("Enter list type (i - int, d - double, s - std:string): ");
		String choice = sc.nextLine();
		DoublyLinkedList dll;
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
			default: {
				System.err.println("Invalid file format");
				return;
			}

		} // end of switch statement
		switch (choice) {
			case "d": {
				dll = new DoublyLinkedList<Double>(); // DoublyLinkedList<Double>
				break;
			}
			case "s": {
				dll = new DoublyLinkedList<String>(); // dll = new DoublyLinkedList<String>(); //
				break;
			}
			default: {
				dll = new DoublyLinkedList<Integer>(); // DoublyLinkedList<Integer>
			}
		}
		String commands = "Commands: \n" +
				"(i) - Insert value\n" +
				"(d) - Delete value\n" +
				"(p) - Print list\n" +
				"(l) - Length\n" +
				"(t) - Print reverse\n" +
				"(r) - Reverse list\n" +
				"(b) - Delete Subsection\n" +
				"(s) - Swap Alternate\n" +
				"(q) - Quit program\n";
		System.out.print(commands);
		String list = readData(file);
		dll.initialize(list);
		while (!quit) {
			if (!badPrevAns) {
				System.out.print("Enter a Command: ");
			}
			String cmd = sc.nextLine();
			cmd = cmd.toLowerCase();

			switch (cmd) {
				case "i":
					badPrevAns = false;
					System.out.println("Enter a " + dll.elementType + " to insert: ");
					// need to figure a way to save the input text
					String inputText = sc.nextLine();
					dll.insertItem(inputText);
					break;
				case "q":
					quit = true;
					System.out.println("Exiting the program...");
					sc.close();
					break;
				case "p":
					badPrevAns = false;
					System.out.println("The list is: " + dll.toString());
					break;
				case "d":
					badPrevAns = false;
					System.out.println("Enter a " + dll.elementType + " to delete: ");
					String newNum = sc.nextLine();
					dll.deleteItem(newNum);
					sc.nextLine();
					break;
				case "s":
					badPrevAns = false;
					System.out.println("Swap Alternate");
					break;
				case "r":
					badPrevAns = false;
					System.out.println("The list is: " + dll.toString());
					dll.printReverse();
					System.out.println("The reversed list: " + dll.toString());
					break;
				case "b":
					System.out.println("delete subsection");
					break;
				case "t":
					badPrevAns = false;
					dll.printReverse();
					System.out.println("The reverse list: " + dll.toString());
					break;
				case "l":
					badPrevAns = false;
					System.out.println("The length of the list is " + dll.length()); // FJX
					break;
				default:
					badPrevAns = true;
					System.out.println("Invalid command, try again: ");
					break;
			} // switch statement
		} // while loop

	} // main

	/**
	 * !File creation will be updated to create the dll objects later on!.
	 * 
	 * @param file
	 * @return String representing the dll object.
	 * @throws FileNotFoundException
	 */
	private static String readData(File file) throws FileNotFoundException {
		try (Scanner reader = new Scanner(file)) {
			StringBuilder dataset = new StringBuilder();

			while (reader.hasNextLine()) {
				dataset.append(reader.nextLine()).append("\n");
			}
			Scanner read = new Scanner(dataset.toString()); // gonna figure this out later
			return (dataset.toString());
		} catch (FileNotFoundException fnfe) {
			return "not a string";
		}

	} // readData()

}// Linked List driver class