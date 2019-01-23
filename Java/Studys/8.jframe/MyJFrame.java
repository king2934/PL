import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class MyJFrame extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	//
	JLabel label;
	//
	public static void main(String[] args) 
	{
		//EventQueue.invokeLater(new Runnable(){
			//public void run() {
				try {
					new MyJFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			//}
		//}); 
	}
	
	//
	public MyJFrame() {
		//关闭窗体时 退出窗体
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//setSize(int width, int height)
		setSize(800,600);
		setLayout(null);
		setTitle("Java 窗体程序 标题");
		setLocationRelativeTo(null);
		
		//添加按钮
		JButton btn1 = new JButton("浏览");
		btn1.setName("btn1");
		btn1.setBounds(80, 70, 60, 25);//大小位置
		btn1.setVisible(true);
		
		label = new JLabel("Hello world!");
		label.setBounds(30, 20, 400, 20);
		
		//设置字体
		Font font = new Font("微软雅黑", Font.BOLD, 12);
		btn1.setFont(font);
		
		
		btn1.addActionListener(this);
		
		add(btn1);
		add(label);
	}
	
	//
	public void actionPerformed(ActionEvent e) 
	{
		//e.getActionCommand().equals("按钮1")
		JButton jbtn = (JButton) e.getSource();
		String name = jbtn.getName();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = new Date();
		label.setText("按钮名："+name+" 现在时间："+sdf.format(d));
	}
	
}