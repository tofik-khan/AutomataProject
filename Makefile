prog.out : FileIO.o Stack.o include.h
	gcc -o prog.out FileIO.o Stack.o include.h

FileIO.o : FileIO.c
	gcc -c FileIO.c

Stack.o : Stack.c
	gcc -c Stack.c