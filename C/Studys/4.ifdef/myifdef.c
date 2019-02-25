#include <stdio.h>

#ifdef _WIN64
#define SNMAE "win64"
#elif _WIN32
#define SNMAE "win32"
#elif __linux__
#define SNMAE "linux"
#endif
int main()
{
	
	printf("%s \n", SNMAE);
	//printf("%s linux ", __linux__);
	return 0;
}