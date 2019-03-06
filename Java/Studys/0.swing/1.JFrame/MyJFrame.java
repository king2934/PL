import javax.swing.JFrame;
//import javax.swing.WindowConstants;

public class MyJFrame extends JFrame
{
	public String title = "这是一个窗体";
	public static void main(String[] args) 
	{
		new MyJFrame();
	}
	
	public MyJFrame()
	{
		
		JFrame window = new JFrame(this.title);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//退出应用程序
		window.setVisible(true);// 设置窗体可视
		window.setSize(600, 480);// 设置窗体大小
		window.setLocationRelativeTo(null);//居中
	}
}