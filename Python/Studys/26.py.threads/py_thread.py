#!/usr/bin/python3
#coding=utf-8

import _thread
import time

# 为线程定义一个函数
def print_time( threadName, delay):
   for i in range(0,10):
      time.sleep(delay)
      print ("%s: %s" % ( threadName, time.ctime(time.time()) ))

# 创建两个线程
try:
   _thread.start_new_thread( print_time, ("Thread-1", 0.1, ) )
   _thread.start_new_thread( print_time, ("Thread-2", 1, ) )
except:
   print ("Error: 无法启动线程")
   
while 1:
	pass