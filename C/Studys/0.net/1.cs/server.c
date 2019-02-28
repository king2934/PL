#include <stdio.h>

#ifdef _WIN64
/* windows 64 bit */
#define SYSTEM_NAME "Win64"

#include <winsock2.h>

/* End windows 64 bit */
#elif _WIN32
/* windows 32 bit */
#define SYSTEM_NAME "Win32"

#include <winsock2.h>

/* End windows 32 bit */
#elif __linux__
/* linux */
#define SYSTEM_NAME "Linux"

#include<sys/socket.h>

/* End linux */
#endif

int main(int argc,char* argv[])
{
	printf("system %s \n",SYSTEM_NAME);
	
	int sock=socket(AF_INET,SOCK_STREAM,0);
	
	return 0;
}