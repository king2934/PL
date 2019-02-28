#include <stdio.h>

#ifdef _WIN64
/* windows 64 bit */
#define SYSTEM_NAME "Win64"
/* End windows 64 bit */
#elif _WIN32
/* windows 32 bit */
#define SYSTEM_NAME "Win32"
/* End windows 32 bit */
#elif __linux__
/* linux */
#define SYSTEM_NAME "Linux"
/* End linux */
#endif

int main(int argc,char* argv[])
{
	printf("system %s \n",SYSTEM_NAME);
	return 0;
}