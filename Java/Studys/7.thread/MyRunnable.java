public class MyRunnable implements Runnable
{
	private Thread t;
	private String threadName;
	
	//
	public static void main(String[] args)
	{
		MyRunnable mr1 = new MyRunnable(" Runnable - 1");
		mr1.start();
		System.out.println("R1 End ");
		
		MyRunnable mr2 = new MyRunnable(" Runnable - 2");
		mr2.start();
		System.out.println("R2 End ");
	}
	
	//
	public MyRunnable()
	{
		this.threadName = " Runnable - 0";
	}
	
	//
	public MyRunnable(String name)
	{
		this.threadName = name;
	}
	
	//
	public void run() 
	{
		System.out.println("Runing " +  threadName );
	}
	
	//
	public void start () 
	{
      System.out.println("Starting " +  threadName );
      if (t == null) {
        t = new Thread (this, threadName);
        t.start ();
      }
   }
}