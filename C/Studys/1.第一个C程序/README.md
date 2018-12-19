# C
###	代码

	/* 包含标准输入输出头文件 */
	#include <stdio.h>
	
	/* 主函数(入口函数) */
	int main(int argc,char* argv[])
	{
		/*输出显示字符 经典的"你好，世界!"*/
		printf("Hello World!\n");
		
		/* 返回0 */
		return 0;
	}
	
*	#include 包含的意思 后面跟上文件 
* 	<stdio.h> 为标准库文件 gcc 编译库

*	int main /* int 为数据类型 整型 ， 
*	main 主函数必须是main C语文规定的 */

*	printf C语言内置的输出函数 \n 为回车换行
*	函数为整型 必然返回整数 return 0 返回为0的整数

### Makefile 编译参数配置文件 
	如果你环境配置好 可以直接运行make命令
	make 
End