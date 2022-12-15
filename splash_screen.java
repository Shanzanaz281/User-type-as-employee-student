import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

public class splash_screen extends JWindow implements Runnable {
	JProgressBar pb;
	Thread thread;
	ImageIcon img;
	JPanel panel;

	public splash_screen()
	{
		setLayout(null);
		pb=new JProgressBar();
		img = new ImageIcon("images/splash1_modified1.JPG",null);
		panel = new JPanel(){
			protected void paintComponent(Graphics g) {
				g.drawImage(img.getImage(), 0, 0, 540, 385, null);
				super.paintComponent(g);
			}
		};
		panel.setOpaque(false);
		panel.setPreferredSize(new Dimension(540, 385));
		addcomp(0,0,540,385,panel);
		addcomp(90,295,360,15,pb);
		pb.setForeground(Color.BLUE);
		thread=new Thread(this);
		pb.setValue(0);
		thread.start();
		setBounds(400,250,540,385);
		setVisible(true);
	}
	public void addcomp(int x,int y,int w,int h,Component cn)
	{
		cn.setBounds(x,y,w,h);
		add(cn);
	}
	public void addComp(int x, int y, int w, int h, Component com)
	{
		com.setBounds(x, y, w, h);
		panel.add(com);
	}
	public void run()
	{
		try
		{
			while(true)
			{
				if(pb.getValue()<100)
				{
					pb.setValue(pb.getValue()+2);
					// tst.setText(tst.getText()+"...");
					Thread.sleep(200);
					if(pb.getValue()>=100)
					{
						dispose();
						new login();
	
					}
				}
				else
					break;
			}
		}
		catch(InterruptedException ex){}
	}
	public static void main(String[] args) {
		new splash_screen();
	}
}
