import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Dimension;

public class MyAlert extends JFrame
{
	public JLabel label;
	public static void main(String[] args)
	{
		new MyAlert();
	}
	
	public MyAlert()
	{
		setTitle("弹出 - window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//退出应用程序
		setLayout(null);//布局
		setVisible(true);// 设置窗体可视
		setSize(600, 480);// 设置窗体大小
		setMinimumSize(new Dimension(600,480));//最小尺寸
		setLocationRelativeTo(null);//居中
		
		label = new JLabel("Hello world!");
		label.setBounds(20, 100, 400, 20);
		
		JButton btn = new Btn(this);
		/*
		btn.setBounds(20, 20, 80, 30);//int x,int y,int width,int height
		btn.setVisible(true);
		*/
		
		//添加
		add(label);
		add(btn);
	}
}