#!/usr/bin/python3
#coding=utf-8
#
# 文件名：server.py

# 导入 socket、sys 模块
import socket
import sys
import os

# 创建 socket 对象
serversocket = socket.socket(socket.AF_INET,socket.SOCK_STREAM)

# 获取本地主机名
host = socket.gethostname()
#端口
port = 9999
#最大连接数
MaxRequest=5

# 绑定端口号
serversocket.bind((host, port))

# 设置最大连接数，超过后排队
serversocket.listen(MaxRequest)

print("\nhost=%s,port=%s,正在等待客户端连接..."%(host,port))

#无限循环
while True:
	# 建立客户端连接 被动接受TCP客户端连接,(阻塞式)等待连接的到来
	clientsocket,addr = serversocket.accept()
	
	print("连接地址: %s" % str(addr))
	
	msg = "Welcome to Python Socket Network Programming World. 欢迎来到Python Socket网络编程世界。"
	fname="message.txt"
	if os.access(fname, os.F_OK):
		fp = open("message.txt", "r")
		msg = fp.read()
		fp.close()
	else:
		fp = open("message.txt", "w+")
		fp.write(msg)
		fp.close()
	
	#发送消息给连接上来的客户端
	clientsocket.send(msg.encode('utf-8'))
	clientsocket.close()
	