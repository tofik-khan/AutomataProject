//#include "include.h"
#include <stdio.h>
#include <stdlib.h>
void getExpression(char*, char*);


int main (void)
{
	char stringBuffer[255];
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

	fscanf(fp, "%s", stringBuffer);

}