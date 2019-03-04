import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public class BtnListener implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	public MyAlert alert = null;
	
	public BtnListener(MyAlert alert)
	{
		this.alert = alert;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		JButton jbtn = (JButton) e.getSource();
		String name = jbtn.getName();
		
		//this.label.setText("按钮名："+name);
		this.alert.label.setText("MyAlert下的按钮名："+name);
	}	
}