public class MyTest
{
	public static void main(String[] args)
	{
		System.out.println("调用线程类MyThreadTest：");
		MyThreadTest mtt = new MyThreadTest("第一次");
		mtt.start();
		System.out.println("调用End");
		
		System.out.println("第二次调用线程类MyThreadTest：");
		MyThreadTest mtt2 = new MyThreadTest("第二次");
		mtt2.start();
		System.out.println("第二次调用End");
	}
}