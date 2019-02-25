#include <stdio.h>

#ifdef _WIN64
#define SNMAE "Win64"
#elif _WIN32
#define SNMAE "Win32"
#elif __linux__
#define SNMAE "Linux"
#endif

int main()
{
	printf("%s \n", SNMAE);
	return 0;
}