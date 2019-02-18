#
#CC = C:\Windows\Microsoft.NET\Framework\v4.0.30319\csc.exe
#
CC = csc
RM = rm -rf 

all:
	$(CC) /t:winexe /out:hello.exe Program.cs WinForm.cs WinForm.Designer.cs
	#$(CC) main.c -fPIC -shared -o main.dll
	#$(CC) main.c -fPIC -shared -o main.so
	
clean:
	$(RM) *.exe *.o *.so