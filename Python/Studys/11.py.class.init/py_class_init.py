#!/usr/bin/python3
 
class Complex:
    def __init__(self, realpart, imagpart):
        self.r = realpart
        self.i = imagpart
	
	def __del__():
		print("class the end\n")
	
x = Complex(3.0, -4.5)
print(x.r, x.i)   # 输出结果：3.0 -4.5