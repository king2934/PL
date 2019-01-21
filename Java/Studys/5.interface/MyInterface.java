public class MyInterface implements InterfaceDemo
{
	String username = InterfaceDemo.User_Name;
	public static void main(String[] args)
	{
		MyInterface mi = new MyInterface();
		mi.show();
	}
	
	public MyInterface()
	{
		//System.out.println(this.username);
	}
	
	public void show()
	{
		System.out.println(this.username);
	}
}