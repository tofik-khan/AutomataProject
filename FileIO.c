#include "include.h"


void getExpression(char* filename, char* stringBuffer)
/*
	getExpression char* -> void
takes a filename as argument and reads the regualr expression in post fix notaion and returns the post fix expression.
*/
{

	FILE* fp = fopen(filename, "r+");

	fgets(stringBuffer, MAX_LENGTH, fp);
}