import java.util.Properties;
import java.util.Iterator;

import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.InputStream;

public class MyProperties
{
	private String conf;
	
	public static void main(String[] args)
	{
		System.out.println("MyProperties 读写配置文件（config.properties");
		
		MyProperties my = new MyProperties();
		my.read();
	}
	
	//构造方法
	public MyProperties()
	{
		System.out.println("构造方法");
		this.conf = "config.properties";
		this.init();
	}
	
	//读取
	public void read()
	{
		System.out.println("开始读取配置文件...");
		Properties prop = new Properties();
		try{
			FileInputStream fis = new FileInputStream(this.conf);
			InputStream is = new BufferedInputStream(fis);
			prop.load(is);
			String host = prop.getProperty("host");
			is.close();
			System.out.println("\t手动读取");
			System.out.println("\thost=" + host);
			
			String str = prop.stringPropertyNames().toString();
			System.out.println("\t数组Key" + str);
			
			Iterator<String> it = prop.stringPropertyNames().iterator();
			System.out.println();
			System.out.println("\t以下遍历出的结果");
			while(it.hasNext()){
				String key = it.next();
				System.out.println("\t"+key+" = "+prop.getProperty(key));
			}
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	//
	private void init()
	{
		File cf = new File(this.conf);
		if ( cf.exists() ){
			if( cf.length() <= 0 ){
				this.initConfig();
			}
		}else{
			try{
				cf.createNewFile();
				this.initConfig();
			}catch(IOException e){
				//e.printStackTrace();
				System.out.println("创建新配置文件出错。");
			}
		}
	}
	
	//
	private void initConfig()
	{
		Properties prop = new Properties();
		try
		{
			FileOutputStream fos = new FileOutputStream(this.conf);
			prop.setProperty("host", "localhost");
			prop.store(fos, "The Properties file "+this.conf+" configure.");
			fos.close();
		}
		catch(FileNotFoundException e)
		{
			//e.printStackTrace();
		}
		catch(IOException e)
		{
			//e.printStackTrace();
		}
		
	}
}