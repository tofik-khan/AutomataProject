Name of Authors: Tofik Khan

Submitting the source code for the Automata project. The program asks the user for a file as input and refers to the contents of the file to establish a state transition table for the regular expressions provided within the file. 

How to build the program:
1. Copy the .java files, Makefile and run.sh file to a folder in the Ubuntu computers in the lab
2. Compile the .java files into .class files using the command: make
	Note: This will only work if your current directory contains the above mentioned files
3. Copy/Create a file with the regular expressions
	Note: The file containing the regular expression must be in the same directory as the other programs
4. Change executable permissions of "run.sh" using the command: chmod 777 run.sh
5. Run the program using the command: ./run.sh
	Note: The prompt will as for a file name, this is the file containing regular expressions and is case sensitive. Also make sure to enter the file extension (.txt, .file, etc)
	
Included Files:
Main.java
	Runs the main program. Handles FileIO, stack management and parses the regEx forming appropriate NFAs.
	
MyStack.java
	Creates a stack to store NFAs while parsing regEx and after performing an operation. Uses Java's default stack class.

Nfa.java
	Creates an NFA which keeps track of the start and end (accept) states and a list of transitions within that NFA.

Transition.java
	Creates a single transition between two states as a result of a specific input (symbol)

TransitionList.java
	Linked list that creates a dynamic array of transitions. 

run.sh
	Bash script to make program execution easier

Makefile
	Compiles program to form executable classes. 

