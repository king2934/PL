import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.event.MouseAdapter;  
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Btn extends JButton
{
	public Btn(MyAlert alert)
	{
		setName("btn");
		setText("弹出");
		setVisible(true);
		setBounds(20, 20, 80, 30);
		setForeground(Color.RED);//字体颜色 DARK_GRAY		
		addActionListener(new BtnListener(alert));
	}	
	
}