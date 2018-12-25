#!/usr/bin/python3
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
	
print("\t键 "+ckey+" = "+str(rs.get(ckey)))