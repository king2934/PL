import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;

public class MyJFrameJDialog extends JFrame
{
	public String title = "JDialog窗体 - 这是一个窗体";
	public static void main(String[] args) 
	{
		new MyJFrameJDialog();
	}
	
	//
	public MyJFrameJDialog()
	{
		
		JFrame window = new JFrame(this.title);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//退出应用程序
		window.setLayout(null);//布局
		window.setVisible(true);// 设置窗体可视
		window.setSize(600, 480);// 设置窗体大小
		window.setLocationRelativeTo(null);//居中
		
		ImageIcon icon = new ImageIcon("images/ico.png");  //xxx代表图片存放路径，2.png图片名称及格式
		window.setIconImage(icon.getImage());
		
		
		JButton btn = new JButton("弹出对话框");
		btn.setBounds(20, 20, 80, 30);//int x,int y,int width,int height
		btn.setVisible(true);
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				new MyJDialog(MyJFrameJDialog.this).setVisible(true); //使MyDialog窗体可见
			}
		});
		
		//添加
		window.add(btn);
	}
}
 class MyJDialog extends JDialog
{
	public MyJDialog(MyJFrameJDialog frame)
	{
		//实例化一个JDialog类对象，指定对话框的父窗体、窗体标题和类型
		super(frame,"第一个JDialog窗体",true);
		setBounds(120,120,300,200);//设置对话框窗体大小
		setLocationRelativeTo(null);//居中
	}
}