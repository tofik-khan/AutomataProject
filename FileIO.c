//#include "include.h"
#include <stdio.h>
#include <stdlib.h>
#define MAX_LENGTH 255


void getExpression(char*, char*);


int main (void)
{
	char stringBuffer[MAX_LENGTH];
	printf("test");
	getExpression("Test.txt", stringBuffer);

	printf("%s",stringBuffer);

	return 0;
}

void getExpression(char* filename, char* stringBuffer)
/*
	getExpression char* -> void
takes a filename as argument and reads the regualr expression in post fix notaion and returns the post fix expression.
*/
{

	FILE* fp = fopen(filename, "r+");

	fgets(stringBuffer, MAX_LENGTH, fp);
	printf("Contents of the file: %s", stringBuffer);
}