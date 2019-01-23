#
#CC = C:\msys64\mingw64\bin\gcc.exe
#
CC = gcc
RM = rm -rf 
PKG = $(shell pkg-config --cflags gtk+-3.0)
PKLIB = $(shell pkg-config --libs gtk+-3.0)
DIR = dir
m:
	$(CC) -mwindows $(PKG) m.c -o m.exe $(PKLIB)  
all:
	$(CC) -mwindows $(PKG) wingtk.c -o wingtk.exe $(PKLIB)  
clean:
	$(RM) *.exe *.o *.so