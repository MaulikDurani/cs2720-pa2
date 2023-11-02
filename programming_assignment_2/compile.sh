#!/bin/bash

javac -d bin -cp bin -Xlint:unchecked src/cs2720/p1/Nodetype.java
javac -d bin -cp bin -Xlint:unchecked src/cs2720/p1/DoublyLinkedList.java
javac -d bin -cp bin -Xlint:unchecked Src/cs2720/p1/LinkedListDriver.java
java -cp bin cs2720.p1.LinkedListDriver

