#!/usr/bin/python3
#coding=utf-8
# 打开一个文件
f = open("f.txt", "r")

str = f.read()
print(str)

# 关闭打开的文件
f.close()