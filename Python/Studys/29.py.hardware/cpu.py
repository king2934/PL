#!/usr/bin/python3
#coding=utf-8

import psutil

cpu_info = psutil.cpu_times()

#CPU核心数
uh = psutil.cpu_count(logical=False)

#CPU线程数
ux = psutil.cpu_count()

uxarr = len(psutil.Process().cpu_affinity())

s = "".join(str(cpu_info))

print("psutil :(CPU核心数=%s，CPU线程数=%s，CPU线程数组长度（线程数）=%s，)\n" % (uh,ux,uxarr) )
print(s)