#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
int run_log()
{
	FILE *fp = NULL;
	fp = fopen("/data/local/apache/htdocs/www/webvpn/logs/run.log", "a+");
	fprintf(fp, "This is testing for fprintf...\n");
	fputs("This is testing for fputs...\n", fp);
	fclose(fp);
	return 0;
}

int main(int argc,char* argv[])
{
	//printf("Hello World!\n");
	while(1)
	{
		//run_log();
		system("php ping178.php");
		sleep(600);
		//printf("Hello World ! sleep 8 ...\n");
	}
	return 0;
}