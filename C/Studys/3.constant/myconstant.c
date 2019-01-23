#include <stdio.h>

/*
** 定义常量
** 常量大写
** 本程序有中文输出
** 源文件编码修改成 ANSI 编码
*/

#define NAME "my name is king"
#define AGE  18

int main()
{
	printf("%s \n", NAME);
	printf("%d 年龄是 ", AGE);
	return 0;
}