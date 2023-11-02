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
		boolean quit = false;
		boolean badPrevAns = false;
		Scanner sc = new Scanner(System.in);
		// Scanner scan;
		System.out.print("Enter list type (i - int, d - double, s - std:string): ");

		String choice = sc.nextLine();
		DoublyLinkedList<?> dll = null;
		// File "creation"
		switch (choice) {
			case ("i"): {
				file = new File("resources/int-input.txt");
				dll = new DoublyLinkedList<Integer>();
				break;
			}
			case ("d"): {
				file = new File("resources/double-input.txt");
				dll = new DoublyLinkedList<Double>();
				break;
			}
			case ("s"): {
				file = new File("resources/string-input.txt");
				dll = new DoublyLinkedList<String>();
				break;
			}
			default: {
				System.err.println("Invalid file format");
				sc.close();
				throw new FileNotFoundException("FnFE");

			}

		} // end of switch statement

		// define dll here

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
		dll.initializeFromString(list);

		while (!quit) {
			if (!badPrevAns) {
				System.out.print("Enter a Command: ");
			}
			String cmd = sc.nextLine();
			cmd = cmd.toLowerCase();

			// String inputText = sc.nextInt();
			switch (cmd) {
				case "i":
					badPrevAns = false;
					System.out.print("Enter a item to insert: ");
					// need to figure a way to save the input text
					String input = sc.nextLine();
					dll.convertAndInsert(input);
					System.out.println("The list is: " + dll.toString());
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
					System.out.print("Enter an item to delete: ");
					String newNum = sc.nextLine();
					dll.deleteItem(newNum);
					System.out.println("The list is: " + dll.toString());
					break;
				case "s":
					badPrevAns = false;
					System.out.println("Original List: " + dll.toString());
					dll.swapAlternate();
					System.out.println("Modified List: " + dll.toString());
					dll.printReverse();
					System.out.println("Reversed List: " + dll.toString());
					break;
				case "r":
					badPrevAns = false;
					System.out.println("The list is: " + dll.toString());
					dll.printReverse();
					System.out.println("The reversed list: " + dll.toString());
					break;
				case "b":
					System.out.print("Enter lower bound: ");
					String lowerBound = sc.nextLine();
					System.out.print("Enter upper bound: ");
					String upperBound = sc.nextLine();
					System.out.println("Original List: " + dll.toString());
					dll.deleteSubsection(lowerBound, upperBound);
					System.out.println("Modified List: " + dll.toString());
					dll.printReverse();
					System.out.println("Reversed List: " + dll.toString());
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
			return (dataset.toString());
		} catch (FileNotFoundException fnfe) {
			return "not a string";
		}

	} // readData()

}// Linked List driver class
