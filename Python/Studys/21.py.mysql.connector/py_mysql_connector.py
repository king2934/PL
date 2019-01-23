#!/usr/bin/python3
#coding=utf-8
# 查询你数据库用户 plugin（caching_sha2_password，mysql_native_password）
# 使用的是什么验证插件
#	select host,user,plugin from mysql.user;
# 修改你用户密码验证插件
#	alter user 'db_user'@'%' identified with mysql_native_password by 'newpassword'; 
# 连接数据库密码验证插件配置成 'auth_plugin':'mysql_native_password'

import mysql.connector

ConfigDB = {
    'host': '192.168.1.17',
    'user': 'king',
    'password': 'king',
    'port': 3306,
    'database': 'medicaldatacenter',
	'auth_plugin':'mysql_native_password',# 如果你的Mysql 是8.X 请加上这个
    'charset': 'utf8'
}

try:
	conn = mysql.connector.connect(**ConfigDB)
	print("connection is successful（连接数据库成功）")
except  mysql.connector.Error as e:
	print('connect fails!{}'.format(e))
	
#关闭数据库连接	
conn.close()