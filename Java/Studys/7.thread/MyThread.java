public class MyThread extends Thread
{
	private Thread t;
	private String threadName;
	
	public static void main(String[] args)
	{
		MyThread mt1 = new MyThread("Thread - 1");
		mt1.start();
		
		MyThread mt2 = new MyThread("Thread - 2");
		mt2.start();
	}
	
	//
	public MyThread()
	{
		this.threadName = "Thread - 0";
	}
	
	//
	public MyThread(String name)
	{
		this.threadName = name;
	}
	
	//线程运行
	public void run()
	{
		System.out.println(" Running " +  threadName );
	}
	
	//启动线程
	public void start()
	{
		System.out.println(" Starting " +  this.threadName );
		if (t == null) {
			t = new Thread (this, this.threadName);
			t.start ();
		}
	}
}