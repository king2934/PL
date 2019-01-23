#!/usr/bin/python3
#coding=utf-8
 
class Complex:
    def __init__(self, realpart, imagpart):
        self.r = realpart
        self.i = imagpart
	
	def __del__():
		print("class the end\n") #类结束时运行
	
x = Complex(3.0, -4.5)
print(x.r, x.i)   # 输出结果：3.0 -4.5