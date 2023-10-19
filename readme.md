Ryan Majd & Maulik Durani | <rm97798@uga.edu> & <md00211@uga.edu>

    # doubly-linked-list assignment

    cs2720
    Dr. Jin Lu (Data Structures)

    # doubly Linked List Program

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

### Complicated Compile Code

```bash
/usr/bin/env /Library/Java/JavaVirtualMachines/jdk-18.0.2.1.jdk/Contents/Home/bin/java -cp /Users/USERNAME/Library/Application\ Support/Code/User/workspaceStorage/hash/redhat.java/jdt_ws/cs2720-pa2_cd3e92c2/bin cs2720.p1.LinkedListDriver
```

/usr/bin/env: This is the shebang line that is used to locate the java executable in your system's environment.

/Library/Java/JavaVirtualMachines/jdk-18.0.2.1.jdk/Contents/Home/bin/java: This is the path to the java executable. It specifies the Java Virtual Machine (JVM) that should be used to run the Java program.

-cp: This option specifies the classpath, which is a list of directories and JAR files that contain the Java classes required to run the program.

/Users/`USERNAME`/Library/Application\ Support/Code/User/workspaceStorage/`hash`/redhat.java/jdt_ws/cs2720-pa2_cd3e92c2/bin: This is the path to the directory containing the compiled Java classes and resources necessary for execution.

cs2720.p1.LinkedListDriver: This is the fully qualified class name of the Java program that you want to execute.

## Available Commands

The program supports the following commands:
(i) - Insert value
(d) - Delete value
(p) - Print list
(l) - Length
(t) - Print reverse
(r) - Reverse list
(b) - Delete Subsection
(s) - Swap Alternate
(q) - Quit program

## Contributions

Ryan worked on the `LinkedListDriver.java`, UML Diagram, `readme.md` mostely and methods: Insert(), Delete(), Print(), Length()

Maulik worked on printReverse(), Delete Subsection(), Reverse List(), Swap Alternate().
