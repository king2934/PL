import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;

public class MyFile
{
	public static void main(String[] args)
	{
		MyFile mf = new MyFile();
		mf.newFile();
		mf.newDir();
		mf.check();
		
		mf.readFileS();
		mf.bufReadFile();
		
		mf.writeFile();
	}
	
	//写文件
	public void writeFile()
	{
		String data = "我是等待被写入文件的数据";
		File file = new File("nwf.txt");
		
		try{
			FileOutputStream fos = new FileOutputStream(file);
			OutputStreamWriter osw = new OutputStreamWriter(fos,"utf-8");
			osw.append(data);
			osw.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		System.out.println("写文件 nwf.txt ");
	}
	
	//读取文件 按流
	public void readFileS()
	{
		File file = new File("srfile.txt");
		if( file.exists() ){
			Long len = file.length();
			byte[] content = new byte[len.intValue()];
			
			try
			{
				FileInputStream fin = new FileInputStream(file);
				fin.read(content);  
				fin.close();
			}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch(IOException e)
			{
				//e.printStackTrace();
				System.out.println("错误FileInputStream");
			}
			
			try{
				String result = new String(content, "UTF-8");
				System.out.println(" result : " + result);
			}
			catch(UnsupportedEncodingException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	//读取文件 按行读取
	public void bufReadFile()
	{
		File file = new File("brfile.txt");
		if( file.exists() ){
			BufferedReader br = null;
			System.out.println("以行为单位读取文件内容，一次读一整行：");
			
			FileInputStream fis = null;
			try
			{
				fis = new FileInputStream(file);
				InputStreamReader isr = new InputStreamReader(fis);
				br = new BufferedReader(isr);
				
				String result="";
				String line;
				while( (line = br.readLine()) != null )
				{
					result += line;
					System.out.println(" 一行的内容 : "+line);
				}
				br.close();
				System.out.println(" 所有行的内容拼在一起 : " + result);
			}
			catch(FileNotFoundException e)
			{
				//fis = new FileInputStream(file);
				System.out.println("错误可能找不到文件吧");
			}
			catch(IOException e){
				//BufferedReader
				System.out.println("错误信息");
			}			
		}
	}
	
	//新建立目录
	public void newDir()
	{
		File f = new File("dirName");
		if( !f.exists() ){
			f.mkdirs();
		}
		
		//删除文件或目录
		f.delete();
	}
	
	//新建立空文件
	public void newFile()
	{
		File f = new File("new.txt");
		if( !f.exists() ){
			try{
				f.createNewFile();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
		//删除文件或目录
		f.delete();
	}
	
	//检查文件或目录是否存在 判断是文件还是目录
	public void check()
	{
		String df = "dir";
		File f = new File(df);
		
		if(f.exists()){
			System.out.println("文件或者目录存在 exists() ");
		}else{
			System.out.println("找不到文件或目录，不存在 exists() ");
		}
		
		if( f.isDirectory() ){
			System.out.println("是一个目录 isDirectory() ");
		}
		
		if(f.isFile()){
			System.out.println("是一个文件 isFile() ");
		}
		
		//删除文件或目录
		f.delete();
	}
}