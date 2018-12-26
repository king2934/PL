#!/usr/bin/python3
#coding=utf-8

"""错误和异常：
    错误：
        nameerror           未声明、初始化对象
        indexerror          序列中没有此索引
        syntaxerror         语法错误
        keyboardinterrupt   用户中端执行
        EOFEror             没有内建输入，到达EOF标记
        IOErrot             输入/输出操作失败
"""
import time

for i in range(1,11):
	print(i)
	try:                        #把可能发生错误的代码放入try里面，
		time.sleep(1)
	except KeyboardInterrupt:   #当产生KeyboardInterrupt
		print('Bey-Bey')

#事后申请原谅比事前申请权限容易
try:
	number = int(input('number:'))
	result = 100 / number

except (ValueError, ZeroDivisionError) as e:
	print('errot', e)
except (KeyboardInterrupt, EOFError):
	print('\nBey-Bey')
else:                   #没有异常时执行的语句
	print(result)
finally:                #不论有没有异常都会执行的语句
	print('done')