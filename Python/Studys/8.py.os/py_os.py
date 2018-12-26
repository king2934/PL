#!/usr/bin/python3
#coding=utf-8
import os, sys

# 假定 f.txt 文件存在，并有读写权限

ret = os.access("f.txt", os.F_OK)
print ("F_OK - 返回值 %s"% ret)

ret = os.access("f.txt", os.R_OK)
print ("R_OK - 返回值 %s"% ret)

ret = os.access("f.txt", os.W_OK)
print ("W_OK - 返回值 %s"% ret)

ret = os.access("f.txt", os.X_OK)
print ("X_OK - 返回值 %s"% ret)