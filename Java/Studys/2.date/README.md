# JAVA 编程语言 自学习过程
###	时间
####	MyDate 类
#####	main 入口函数 在运行java MyDate时 java自动找到main运行
#####	有此可见 main 与类无关。因为你在使用类的时候无法用到main
	
	public class MyDate
	{
		public static void main(String args[])
		{
			MyDate md = new MyDate();
			String d = md.strDate();
			String df = md.strDateFormat();
			System.out.println(" main date : "+d);
			System.out.println(" main date : "+df);
		}
		
		public String strDate()
		{
			Date d = new Date();
			String dstr = d.toString();
			System.out.println(dstr);
			return dstr;
		}
		
		//
		public String strDateFormat()
		{
			//TimeZone.setDefault(TimeZone.getTimeZone("UTC"));//PRC
			SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
			Date d = new Date();
			String dstr = sdf.format(d);
			System.out.println(dstr);
			return dstr;
		}
	}
	
	
	
	new MyDate() //实例化类的时候并不会执行main函数