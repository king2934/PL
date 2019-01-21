public class MyRunnable implements Runnable
{
	private Thread t;
	private String threadName;
   
	public static void main(String[] args)
	{
		MyRunnable mr = new MyRunnable();
		mr.start();
	}
	
	public MyRunnable()
	{
		this.threadName = " Runnable - 0";
	}
	
	public void run() 
	{
	}
	
	public void start () 
	{
      System.out.println("Starting " +  threadName );
      if (t == null) {
        t = new Thread (this, threadName);
        t.start ();
      }
   }
}