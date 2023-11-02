Ryan Majd & Maulik Durani | <rm97798@uga.edu> & <md00211@uga.edu>

# Doubly-Linked-List Assignment (CS2720)

    Dr. Jin Lu (Data Structures)

This Java program demonstrates the creation and manipulation of a generic doubly linked list, providing various operations on the list, including insertion, deletion, search, merging, finding intersections, and more.

## Table of Contents

- [Overview](#overview)
- [How To Compile](#compile)
- [Available Commands](#available-commands)
- [Contributions](#Contributions)

## Overview

This class represents a Doubly Linked List that can store elements of type T.
It provides methods to insert and delete elements, check if an element is in the list, print the list in reverse order, delete a subsection of the list, and swap adjacent nodes. The list can be sorted in ascending or descending order based on the order of the elements.

### UML Diagram

![UML Diagram of the project's Classes and Objects relevant for interpretation](./resources/umlDiagram.drawio.svg)

## Compile

This `readme.md` provides an explanation of the code used to compile a Java program. The code includes the `java` command with various arguments and options.

The "compile.sh" script should work correctly now. Alternatively, use:

```
java -cp programming_assignment_2/bin/ programming_assignment_2/src/cs2720/p1/LinkedListDriver.java  resources/
```

## Available Commands

```The program supports the following commands:
(i) - Insert value
(d) - Delete value
(p) - Print list
(l) - Length
(t) - Print reverse
(r) - Reverse list
(b) - Delete Subsection
(s) - Swap Alternate
(q) - Quit program
```

## Contributions

Ryan worked on the `LinkedListDriver.java`, UML Diagram, `readme.md` mostly and methods: Insert(), Delete(), Print(), Length()

Maulik worked on printReverse(), Delete Subsection(), Reverse List(), Swap Alternate().
