#!/usr/bin/python3
#coding=utf-8
#
#	更多参考
#	https://docs.python.org/3/library/json.html

import json

# Python 字典类型转换为 JSON 对象
data = {
    'no' : 1,
    'name' : '蓝徽',
    'url' : 'https://www.lanhuispace.com'
}
 
json_str = json.dumps(data)
print ("Python 原始数据：", repr(data))
print ("JSON 对象：", json_str)

# 将 JSON 对象转换为 Python 字典
data2 = json.loads(json_str)
print ("data2['name']: ", data2['name'])
print ("data2['url']: ", data2['url'])

with open('data.json', 'w') as f:
	json.dump(data, f)
 
# 读取数据
with open('data.json', 'r') as f:
	data = json.load(f)