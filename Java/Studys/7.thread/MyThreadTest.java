public class MyThreadTest implements Runnable
{
	private Thread t;
	private String threadName;
	
	//
	public MyThreadTest()
	{
		this.threadName = "null";
	}
	
	//
	public MyThreadTest(String name)
	{
		this.threadName = name;
	}
	
	//
	public void run()
	{
		System.out.println(" Runing... " + this.threadName);
		try
		{
			for(int i = 1; i <= 5; i++)
			{
				System.out.println("Thread: " + this.threadName + ", " + i);
				// 让线程睡眠一会
				Thread.sleep(500);
			}
		}
		catch(InterruptedException e)
		{
			System.out.println("Thread " + this.threadName + " interrupted.");
		}
		System.out.println("Thread " +  this.threadName + " exiting.");		
	}
	
	//
	public void start()
	{
		if( this.t == null ){
			System.out.println(" Starting ... " + this.threadName);
			this.t = new Thread(this,this.threadName);
			this.t.start();
		}
		
	}
}