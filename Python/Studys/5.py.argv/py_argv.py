#!/usr/bin/python3
#coding=utf-8
import sys
print('带参数运行:python py_argv.py 11 22 33 44 55')
print('命令行参数如下:')
for i in sys.argv:
   print(i)
 
#print('\n\nPython 路径为：', sys.path, '\n')