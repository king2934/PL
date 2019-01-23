#!/usr/bin/python3
#coding=utf-8

import smtplib
from email.mime.text import MIMEText
from email.mime.multipart import MIMEMultipart
from email.header import Header
from email.mime.image import MIMEImage

# 第三方 SMTP 服务
mail_host = "smtp.126.com"  #设置服务器
mail_user = "king2934"    #用户名
mail_pass = "********************"   #口令 客户端授权码

#	发送人 接收人
sender = 'king2934@126.com' 
receivers = ['king2934@126.com']

#	发送的主题 （标题）
message_title = '蓝徽 Python SMTP 邮件测试'

#	发送的内容
message_body = """
<table align="center" border="0">
	<tr>
		<td>
<p>蓝徽 Python 邮件发送测试...</p>
<p><a href="https://www.lanhuispace.com">这是一个链接【蓝徽】</a></p>
<p>以下是图片</p>
<p><img src="cid:image1" width="500" /></p>
		</td>
	</tr>
	<tr>
		<td> The End !</td>
	</tr>
</table>
"""

# 三个参数：文本内容，文本格式，设置编码
message = MIMEMultipart()
message['Subject'] = Header(message_title, 'utf-8')

message['From'] = sender
message['To'] =  ",".join(receivers)
message['Cc'] =  ",".join(receivers) # 抄送


message_subs = MIMEMultipart('alternative')
message_subs.attach(MIMEText(message_body, 'html', 'utf-8')) # plain|html
message.attach(message_subs)

# 指定图片为当前目录
fp_img = open('风景.jpg', 'rb')
msgImage = MIMEImage(fp_img.read())
fp_img.close()

# 定义图片 ID，在 HTML 文本中引用
msgImage.add_header('Content-ID', '<image1>')
message.attach(msgImage)

# 构造附件1，传送当前目录下的 test1.txt 文件
att1 = MIMEText(open('test1.txt', 'rb').read(), 'base64', 'utf-8')
att1["Content-Type"] = 'application/octet-stream'
# 这里的filename可以任意写，写什么名字，邮件中显示什么名字
att1["Content-Disposition"] = 'attachment; filename="test1.txt"'
message.attach(att1)

# 构造附件2，传送当前目录下的 test2.txt 文件
att2 = MIMEText(open('test2.txt', 'rb').read(), 'base64', 'utf-8')
att2["Content-Type"] = 'application/octet-stream'
att2["Content-Disposition"] = 'attachment; filename="test2.txt"'
message.attach(att2)

# 构造附件3，传送当前目录下的 fujian.zip 文件
att3 = MIMEText(open('fujian.zip', 'rb').read(), 'base64', 'utf-8')
att3["Content-Type"] = 'application/octet-stream'
att3["Content-Disposition"] = 'attachment; filename="fujian.zip"'
message.attach(att3)


try:
    #smtpServer = smtplib.SMTP() 
    #smtpServer.connect(mail_host, 25)    # 25 为 SMTP 端口号
	smtpServer = smtplib.SMTP_SSL(mail_host, 465)
	smtpServer.login(mail_user, mail_pass)
	smtpServer.sendmail(sender, receivers, message.as_string())
	smtpServer.quit()  # 关闭连接
	print ("邮件发送成功")
except smtplib.SMTPException as e:
    print ("Error: 无法发送邮件{}",format(e) )