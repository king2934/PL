#	Socket 三种方式通信  
##	socket1单进程 
##	socket2多进程 
##	socket3多线程

#	一、Server 流程
	socket -> bind -> listen -> accept -> read -> write	-> read -> close
	
#	二、Client 流程
	socket -> connect -> write -> read -> close
	
#	（一） Server 流程 - 函数

	1. int socket(int domain, int type, int protocol);
	2. int bind(SOCKET socket, const struct sockaddr* address, socklen_t address_len);
	3. int listen(int sockfd, int backlog);
	
	4. int accept(int sockfd, struct sockaddr *addr, socklen_t *addrlen);
	5. int I/O //接收客户端连接上后做的操作
	6. int close(int sockfd)
	
#	（二） Client 流程 - 函数

	1. int socket(int domain, int type, int protocol);
	2. int connect (int sockfd, struct sockaddr * serv_addr, int addrlen);
	3. I/O //连接上服务端后做的操作
	4. int close(int sockfd)
	

#	函数列表

###	1、创建套接字——socket()系统调用

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
		
	注意:并不是上面的type和protocol可以随意组合的，如SOCK_STREAM不可以跟IPPROTO_UDP组合。
	当protocol为0时，会自动选择type类型对应的默认协议。

###	2、命名（绑定）套接字——bind()系统调用

	int bind( int socket, const struct sockaddr *address, size_t address_len);
	
###	3、创建套接字队列（监听）——listen()系统调用
	
	int listen(int socket, int backlog);

###	4、接受连接——accept()系统调用

	int accept(int socket, struct sockaddr *address, size_t *address_len);
	
###	5、请求连接——connect()系统调用

	int connect(int socket, const struct sockaddr *address, size_t address_len);

###	6、关闭socket——close()系统调用

	int close(sockfd);
	