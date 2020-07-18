import java.awt.*;
import javax.swing.*;
import java.net.URL;

public class JFrameGetResource extends JFrame
{
	private URL imgURL;
	private Image ImageTitle;
	public static void main(String[] args)
	{
		try {
			new JFrameGetResource().setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public JFrameGetResource()
	{
		initialize();
	}
	
	private void initialize()
	{
		//关闭窗体时 退出窗体
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.imgURL = JFrameGetResource.class.getResource("/images/image_title.png");
		this.ImageTitle = Toolkit.getDefaultToolkit().getImage(imgURL);
		this.setIconImage(this.ImageTitle);
		
		//setSize(int width, int height)
		this.setSize(800,600);
		this.setLayout(null);
		this.setTitle("Java 窗体程序 标题");
		this.setLocationRelativeTo(null);
	}
}