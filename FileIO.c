//#include "include.h"
#include <stdio.h>
#include <stdlib.h>

char * getExpression(char* filename)
/*
	getExpression char* -> char*
takes a filename as argument and reads the regualr expression in post fix notaion and returns the post fix expression.
*/
{
	char* stringBuffer;
	FILE fp* = fopen(filename, r+);

	fscanf(fp, "%s", stringBuffer);
}