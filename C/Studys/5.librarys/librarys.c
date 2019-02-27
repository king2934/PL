#include <assert.h>
#include <complex.h>
#include <ctype.h>
#include <errno.h>
#include <fenv.h>
#include <float.h>
#include <inttypes.h>
#include <iso646.h>
#include <limits.h>
#include <locale.h>
#include <math.h>
#include <setjmp.h>
#include <signal.h>
#include <stdalign.h>
#include <stdarg.h>
#include <stdbool.h>
#include <stddef.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdnoreturn.h>
#include <string.h>
#include <tgmath.h>
#include <time.h>
#include <uchar.h>
#include <wchar.h>
#include <wctype.h>

/*#include <threads.h> windows 和 linux 提示找不到文件*/

#ifdef _WIN64
#include <stdatomic.h>
#define SNMAE "Win64"
#elif _WIN32
#include <stdatomic.h>
#define SNMAE "Win32"
#elif __linux__
#define SNMAE "Linux"
#endif

int main(int argc,char* argv[])
{
	printf("librarys %s \n",SNMAE);
	return 0;
}