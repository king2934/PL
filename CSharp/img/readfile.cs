using System;
using System.IO;
public class rf
{
	static void Main(string[] args)
	{
		Console.WriteLine("Hello World!");
		rf r = new rf();
		byte[] b = r.read();
		Console.WriteLine("byte:"+b.Length);
	}
	
	public rf()
	{
	}
	
	public byte[] read()
	{
		string filePath = "img.jpg";
		//通过流打开文件
        FileStream fs = File.OpenRead(filePath);
        //获取文件二进制字符
        byte[] inputByteArray = new byte[fs.Length];
        //读流文件
        fs.Read(inputByteArray, 0, (int)fs.Length);
        //关闭流
        fs.Close();
		
		return inputByteArray;
	}
}