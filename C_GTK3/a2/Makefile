#
#CC = C:\msys64\mingw64\bin\gcc.exe
#
CC = gcc
RM = rm -rf 
PKG = $(shell pkg-config --cflags gtk+-3.0)
PKLIB = $(shell pkg-config --libs gtk+-3.0)
all:
	$(CC) -mwindows $(PKG) window.c -o window.exe $(PKLIB)  
clean:
	$(RM) *.exe *.o *.so