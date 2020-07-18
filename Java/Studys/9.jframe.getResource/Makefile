#
#CC = D:\mingw_w64\mingw64\bin\gcc.exe
#
CC = javac 
RM = rm -rf
JAR= jar 

all: 
	$(CC)  -encoding utf8 *.java
jar:
	$(JAR) cvfm JFrameGetResource.jar META-INF/MANIFEST.MF *.class images 
clean:
	$(RM) *.exe *.o *.so *.class