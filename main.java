import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class main extends JFrame implements ActionListener,MouseListener{
    JLabel lblacc,lblmm,lblbck,lblmodify,lblmenu,lblreport,lblreport1,lblexit,lbllogo;
    JPanel panel,pnl;
    Container c,c1;
    ImageIcon img,img1;
    JButton btncreate,btnmodify,btnreport,btnexit,btncracc,btnmodper,btnmodnom,btnmodreq,btnreprt,btnreprt1;
    public main()   
    {   
        lbllogo =  new  JLabel(new ImageIcon("images/cim.jpg"));
        lblmm =  new  JLabel(new ImageIcon("images/tree-book.jpg"));
        lblbck =  new  JLabel(new ImageIcon("images/sas.jpg"));
        lblreport= new  JLabel(new ImageIcon("images/bb1.jpg"));
        lblreport1= new  JLabel(new ImageIcon("images/bb.jpg"));
        lblmenu = new  JLabel(new ImageIcon("images/menu1.jpg"));
        lblmodify = new JLabel(new ImageIcon("images/s2_3.jpg"));
        lblacc = new JLabel(new ImageIcon("images/f3_1.jpg"));
        btncreate = new JButton("");
        btncreate.addActionListener(this);
        btnmodify = new JButton("");
        btnmodify.addActionListener(this);
        btnreport = new JButton("");
        btnreport.addActionListener(this);
        btnexit = new JButton("");
        btnexit.addActionListener(this);
        btncracc= new JButton("");
        btncracc.addActionListener(this);
        btnmodper = new JButton("");
        btnmodper.addActionListener(this);
        btnmodnom = new JButton("");
        btnmodnom.addActionListener(this);
        btnmodreq = new JButton("");
        btnmodreq.addActionListener(this);
        btnreprt = new JButton("");
        btnreprt.addActionListener(this);
        btnreprt1 = new JButton("");
        btnreprt1.addActionListener(this);
        img = new ImageIcon("images/Professional.jpg", null);
        panel = new JPanel() {
                protected void paintComponent(Graphics g) {
                    //g.drawImage(img.getImage(), 0, 0, 1280,850,null);
                    super.paintComponent(g);
                }
            };
        panel.setOpaque(false);
        panel.addMouseListener(this);
        pnl=new JPanel() {
                Image img=new ImageIcon("images/man-working-on-computer-laptop.jpg").getImage();
                public void paintComponent(Graphics g)
                {
                    g.drawImage(img,0,170,1275,600,null);
                    super.paintComponent(g);
                }
            };
        pnl.setOpaque(false);
        pnl.setLayout(null);
        panel.setPreferredSize(new Dimension(1280, 850));
        c = getContentPane();//c.setLayout(null);
        c.setBackground(Color.white);
        /**/
                           /* c.add(pnl);pnl.setLayout(null);
                            lblbck.setBounds(160,170,1330,700);
                            pnl.add(lblbck);*/
                c.add(pnl);
                
        /**/
        setResizable(false);
        panel.setBounds(0,0,1280,850);
        panel.setLayout(null);
        pnl.add(panel);
        addcomp(20,30,200,130,lbllogo);
        addcomp(1020,10,280,160,lblmm);
        addcomp(00,130,1330,50,lblmenu);
        addcomp(390,10,550,100,lblbck);
       
        addcomp(300,135,170,43,btncreate);
        addcomp(490,135,165,43,btnmodify);
        addcomp(673,135,165,43,btnreport);
        addcomp(855,135,165,43,btnexit);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(45, 5, 1280, 750);
        setVisible(true);
        setTitle("Student Assessment System");
        setLocationRelativeTo(null);
        //setIconImage(Toolkit.getDefaultToolkit().getImage("images/catchpoint.jpg"));
        setIconImage(Toolkit.getDefaultToolkit().getImage("images/catchpoint1.png"));
    }
    public void mouseReleased(MouseEvent me){}
    public void mouseEntered(MouseEvent me){}
    public void mouseExited(MouseEvent me){}
    public void mouseClicked(MouseEvent me){
            panel.remove(btnmodper);
            panel.remove(btnmodnom);
            panel.remove(btnmodreq);
            panel.remove(lblmodify);
            panel.remove(btnreprt);
            panel.remove(lblreport);
            panel.remove(btnreprt1);
            panel.remove(lblreport1);
            panel.remove(btncracc);
            panel.remove(lblacc);
            panel.revalidate();
            panel.repaint();
        }
    public void mousePressed(MouseEvent me){}
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()== btncreate) {
            panel.remove(btnmodper);
            panel.remove(btnmodnom);
            panel.remove(btnmodreq);
            panel.remove(lblmodify);
            panel.remove(btnreprt);
            panel.remove(lblreport);
            panel.remove(btnreprt1);
            panel.remove(lblreport1);
            panel.revalidate();
            panel.repaint();
            addcomp(288,183,200,35,btncracc);
            addcomp(288,183,200,35,lblacc);          
        }
        if(ae.getSource()== btncracc) {           
          University_Details ad =  new University_Details();
            panel.add(ad);    
        }
        if (ae.getSource()== btnmodify) {           
            panel.remove(btncracc);
            panel.remove(btnreprt);
            panel.remove(lblacc);
            panel.remove(lblreport);
            panel.remove(btnreprt1);
            panel.remove(lblreport1);
            panel.revalidate();
            panel.repaint();
          
            addcomp(475,179,200,30,btnmodper);
            addcomp(475,213,200,28,btnmodnom);
            addcomp(475,250,200,30,btnmodreq);
            addcomp(475,175,200,110,lblmodify);  
        }
        if (ae.getSource() == btnmodper){
            new Personal_Updation();
        }
        if (ae.getSource() == btnmodnom){
            new Attendance_Updation();
        }
        if (ae.getSource() == btnmodreq){
            
        	ImageIcon iconic=new ImageIcon("images/stat_sys_warning.png");
			int  x=  JOptionPane.showConfirmDialog(this,"Do you want to modify Test Details?","User Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,iconic);
			if(x==0){
				new Test_Updation();
			}
			else{
				ImageIcon iconic1=new ImageIcon("images/stat_sys_warning.png");
				int  a=  JOptionPane.showConfirmDialog(this,"Do you want to modify Assignment Details?","User Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,iconic1);
				if(a==0){
					new Assign_Updation();
				}
				else{
					ImageIcon iconic2=new ImageIcon("images/stat_sys_warning.png");
					int  b=  JOptionPane.showConfirmDialog(this,"Do you want to modify Internal Exam Details?","User Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,iconic2);
					if(b==0){
						new Exam_Updation();
					}
					else{
						//dispose();
					}
				}
             }
        }       
        if (ae.getSource() == btnreport) {
            panel.remove(btncracc);
            panel.remove(lblacc);
            panel.remove(btnmodper);
            panel.remove(btnmodnom);
            panel.remove(btnmodreq);
            panel.remove(lblmodify);
            panel.revalidate();
            panel.repaint();
            
            addcomp(658,184,200,30,btnreprt);
            addcomp(658,184,200,30,lblreport);
            addcomp(659,214,200,30,btnreprt1);
            addcomp(659,214,200,30,lblreport1);
        }
        if (ae.getSource() == btnreprt){
            new Attendance_Report();
        }
        if (ae.getSource() == btnreprt1){
            new Exam_Report();
        }
        if (ae.getSource() == btnexit) {
            panel.remove(btnreprt);
            panel.remove(btnreprt1);
            panel.remove(lblreport);
            panel.remove(lblreport1);
            panel.remove(btncracc);
            panel.remove(lblacc);
            panel.remove(btnmodper);
            panel.remove(btnmodnom);
            panel.remove(btnmodreq);
            panel.remove(lblmodify);
            panel.revalidate();
            panel.repaint();
            dispose();
      }
    }

    public void addcomp(int x, int y, int w, int h, Component com) {
        com.setBounds(x, y, w, h);
        panel.add(com);
    if(com instanceof JButton) {
                ((JButton)com).setBorder(null);
                ((JButton)com).setBorderPainted(false);
                ((JButton)com).setContentAreaFilled(false);
                ((JButton)com).setOpaque(false);
                ((JButton)com).setForeground(Color.black);
                ((JButton)com).setBackground(Color.black);
            }       
    }
    public static void main(String[] args) {
        new main();
    }
}
