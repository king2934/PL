#!/usr/bin/python3
#coding=utf-8

import mysql.connector

ConfigDB = {
    'host': 'localhost',
    'user': 'king',
    'password': 'king',
    'port': 3306,
    'database': 'medicaldatacenter',
	'auth_plugin':'mysql_native_password',# 如果你的Mysql 是8.X 请加上这个
    'charset': 'utf8'
}

try:
	conn = mysql.connector.connect(**ConfigDB)
	print("\tconnection is successful（连接数据库成功）")
	
	mycursor = conn.cursor()	
	mycursor.execute("show tables")

	for x in mycursor:
		print('\t',x)
	mycursor.close()
	
	cur = conn.cursor()
	print("\t清空一下表\n")
	sql = "truncate table patientbasicinformation"  # 清空数据表
	cur.execute(sql)
	cur.close()	
	
	print("\t插入单个记录\n")
	sql = "insert into patientbasicinformation (PatientName, SexCode) values (%s, %s)"
	val = ("Li Lei", "1")
	cur = conn.cursor()
	cur.execute(sql, val)
	conn.commit()    # 数据表内容有更新，必须使用到该语句
	print("\t",cur.rowcount, "\t记录插入成功。ID:",cur.lastrowid)
	cur.close()	
	
	print("\t插入批量记录\n")
	val = [
	  ('Jim', '1'),
	  ('Alice', '0'),
	  ('韩梅梅', '0'),
	  ('张三', '1'),
	  ('李四', '1'),
	  ('王五', '1')
	]
	
	curall = conn.cursor()
	curall.executemany(sql, val)
	conn.commit()    # 数据表内容有更新，必须使用到该语句
	print("\t",curall.rowcount, "\t记录插入成功\n")
	curall.close()
	
	print("\t查询数据\n")
	curselect = conn.cursor()
	curselect.execute("select ID,PatientName,SexCode from patientbasicinformation limit 0,50")
	myresult = curselect.fetchall() #fetchall() 获取所有记录
	for x in myresult:
		print("\t",x)
	
	print("\t更新和删除就不展示了，都是SQL语句而已...\n")
	
except  mysql.connector.Error as e:
	print('\tconnect fails!{}'.format(e))
	
#关闭数据库连接	
conn.close()
print("\tconn.close() 最后关闭数据库连接\n")