#include <stdio.h>
#include <stdlib.h>
#include "FileIO.c"

#define MAX_LENGTH 255

void getExpression(char*, char*);


struct Stack
{
	char * value;
	struct Stack* next;
};

typedef struct Stack Stack;

char stringBuffer[MAX_LENGTH];
void fillStack(char*, Stack*);