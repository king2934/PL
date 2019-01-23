#!/usr/bin/python3
#coding=utf-8
import redis

rs = redis.Redis(host='127.0.0.1', port=6379,decode_responses=True)

ckey = 'countkey'
count=0
if rs.exists(ckey):	
	"""for i in range(0,10,1):
		print(i)
		count = rs.get(ckey)
	"""
	rs.set(ckey,int(rs.get(ckey))+1)
else:
	rs.set(ckey,1)
	
print("\t"+ckey+" = ",rs.get(ckey))