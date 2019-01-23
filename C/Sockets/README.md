# Socket 三种方式通信  
## socket1单进程 
## socket2多进程 
## socket3多线程

# 函数

## socket()
	int socket(int domain, int type, int protocol);  //返回sockfd(描述符)
	
	### domain:即协议域，又称为协议族（family）
	###	family		说明
		AF_INET		IPv4协议
		AF_INET6	IPv6协议
		AF_LOCAL	Unix域协议
		AF_ROUTE	路由套接字
		AF_KEY		密钥套接字
		
	###	type: 指定socket类型
	###	type			说明
		SOCK_STREAM		字节流套接字(常用)
		SOCK_DGRAM		数据报套接字
		SOCK_SEQPACKET		有序分组套接字
		SOCK_RAW		原始套接字
		
	### protocol：指定协议
	###	protocol		说明
		IPPROTO_TCP		TCP传输协议
		IPPROTO_UDP		UDP传输协议
		IPPROTO_SCTP		SCTP传输协议
		IPPROTO_TIPC		TIPC传输协议

注意:并不是上面的type和protocol可以随意组合的，如SOCK_STREAM不可以跟IPPROTO_UDP组合。当protocol为0时，会自动选择type类型对应的默认协议。