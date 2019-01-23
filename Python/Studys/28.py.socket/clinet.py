#!/usr/bin/python3
#coding=utf-8
#
# 文件名：client.py
#
#	更多网络编程 https://docs.python.org/3.0/library/socket.html

# 导入 socket、sys 模块
import socket
import sys

# 创建 socket 对象
clientsocket = socket.socket(socket.AF_INET,socket.SOCK_STREAM)

# 获取本地主机名
host = socket.gethostname()
ip = socket.gethostbyname(host)
#端口
port = 9999

print("\t本机使用的主机名：%s" % host)
print("\t本机使用的IP地址：%s" % ip)

# 连接服务，指定主机和端口
clientsocket.connect((ip, port))

# 接收小于 1024 字节的数据
msg = clientsocket.recv(1024)

clientsocket.close()

print ("\t",msg.decode('utf-8'))