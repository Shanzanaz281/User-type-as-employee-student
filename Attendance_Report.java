import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.print.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.print.PrintService;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class Attendance_Report extends JFrame implements ActionListener,Printable,MouseListener
{    
    Connection con;
    Statement stmt;
    ResultSet rs;
    Container cn;
    JPanel pnl1;
    JLabel lblpic;
    JPopupMenu File=new JPopupMenu("File");
    JMenuItem Print=new JMenuItem("Print");
    JMenuItem PageSetup=new JMenuItem("Page Setup");
    JMenuItem Exit=new JMenuItem("Exit");
    PrintManager pm=new PrintManager(this.getRootPane(),"Report Printing");
    transient PrinterJob printerJob = PrinterJob.getPrinterJob();
    transient PageFormat pageFormat = printerJob.defaultPage();
    transient PrintService printer = printerJob.getPrintService();
    JLabel lblhead=new JLabel("STUDENT ASSESSMENT SYSTEM ",JLabel.CENTER);
    JLabel lblcp=new JLabel("STUDENT's ATTENDANCE REPORT",JLabel.CENTER);
    ImageIcon icon;
    int r,c,t1,t2,t3,t4,sl=1;
    float f1;
    public Attendance_Report() 
    {
        String dno=JOptionPane.showInputDialog(this,"ENTER STUDENT's ID");
        String dno1=JOptionPane.showInputDialog(this,"ENTER SEMESTER NUMBER");
        cn=getContentPane();
        icon=new ImageIcon(".jpg");
        pnl1 = new JPanel()
        {
        protected void paintComponent(Graphics g)
        {
        g.drawImage(icon.getImage(),0,0, 850,680, null);
        g.drawRoundRect(5,120,850,30,20,20);
        g.drawRoundRect(5,155,850,180,20,20);
        g.drawRoundRect(6,340,850,200,20,20);
        g.drawLine(6,380, 855, 380);
        g.drawLine(55,340, 55, 540);
        g.drawLine(270,340,270, 540);
        g.drawLine(480,340, 480, 540);      
        g.drawLine(540,340, 540, 540);
        g.drawLine(605,340, 605, 540);
        g.drawLine(665,340, 665, 540);
        g.drawLine(725,340, 725, 540);
        g.drawLine(798,340, 798, 540);        
        g.drawLine(55,575, 205, 575);
        g.drawLine(55,580, 205, 580);
            
        super.paintComponent(g);
        }
        };
        pnl1.setOpaque( false );
        pnl1.setPreferredSize( new Dimension(890,740) );
        add(pnl1);
        pnl1.setLayout(null);
        pnl1.addMouseListener(this);
        cn.setBackground(Color.white);
        File.add(Print);
        File.addSeparator();
        File.add(PageSetup);
        File.addSeparator();
        File.add(Exit);
        Print.addActionListener(this);
        PageSetup.addActionListener(this);
        Exit.addActionListener(this);
        lblpic = new JLabel("");
        lblpic.setOpaque(true);
        lblpic.setBackground(Color.BLACK);
     
    addcomp(275,10,300,60,new JLabel(new ImageIcon("images/cim_lbl.jpg")));
    addcomp(0,70,850,50,lblhead);lblhead.setFont(new Font("Algerian",Font.BOLD,30));
    addcomp(0,110,850,50,lblcp);lblcp.setFont(new Font("Bookman Old Style",Font.BOLD,20));
    addcomp(30,160,100,25,new JLabel("Student ID"));
    addcomp(145,160,100,25,new JLabel(":"));
    addcomp(30,190,100,25,new JLabel("Student's Name"));
    addcomp(145,190,100,25,new JLabel(":"));
    addcomp(30,220,100,25,new JLabel("Programme"));
    addcomp(145,220,100,25,new JLabel(":"));
    addcomp(30,250,100,25,new JLabel("Batch Name"));
    addcomp(145,250,100,25,new JLabel(":"));
    addcomp(30,280,100,25,new JLabel("Semester"));
    addcomp(145,280,100,25,new JLabel(":"));
    addcomp(30,310,100,25,new JLabel("University"));
    addcomp(145,310,100,25,new JLabel(":"));
    addcomp(680, 170, 150, 150,lblpic);
    
    String str="profile_pic\\"+dno+"img.jpg";
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Image image = toolkit.getImage(str);
    Image scaledImage = image.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
    ImageIcon icon=new ImageIcon(scaledImage); 
    lblpic.setIcon(icon);
    
    addcomp(10,345,49,25,new JLabel("Sl.No.",JLabel.CENTER));
    addcomp(55,345,215,25,new JLabel("Name Of The Paper",JLabel.CENTER));
    addcomp(270,345,215,25,new JLabel("Name Of The Faculty",JLabel.CENTER));
    addcomp(480,345,60,25,new JLabel("Total",JLabel.CENTER));
    addcomp(540,345,65,25,new JLabel("Mandetory",JLabel.CENTER));
    addcomp(605,345,60,25,new JLabel("Present",JLabel.CENTER));
    addcomp(665,345,60,25,new JLabel("Absent",JLabel.CENTER));
    addcomp(725,345,73,25,new JLabel("Percent(%)",JLabel.CENTER));
    addcomp(798,345,47,25,new JLabel("Fine",JLabel.CENTER));
    
    addcomp(55,550,250,25,new JLabel("ATTENDANCE SUMMARY"));
    addcomp(55,590,200,25,new JLabel("Number Of Classes Conducted"));
    addcomp(275,590,5,25,new JLabel(":"));
    addcomp(485,590,100,25,new JLabel("Presence(%)"));
	  addcomp(585,590,5,25,new JLabel(":"));
    addcomp(55,615,200,25,new JLabel("Total Classes Attended"));
    addcomp(275,615,5,25,new JLabel(":"));
    addcomp(485,615,100,25,new JLabel("Absence(%)"));
	 addcomp(585,615,5,25,new JLabel(":"));
    addcomp(55,640,200,25,new JLabel("Total Class Absented"));
    addcomp(275,640,5,25,new JLabel(":"));
    addcomp(485,640,200,25,new JLabel("Total Fine"));
	addcomp(585,640,5,25,new JLabel(":"));
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
	    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_final?characterEncoding=UTF-8","root","");
        stmt=con.createStatement();
        rs=stmt.executeQuery("select student_details.Sid,student_details.Student_Name,course_details.Course_Name,batch_details.Batch_Name,attendance_details.Sem_no,university_details.Univ_Name from student_details,course_details,batch_details,attendance_details,university_details where student_details.Sid='"+dno+"' and student_details.Sid=attendance_details.Sid and course_details.Course_Code=student_details.Course_Code and Course_details.Course_Name=attendance_details.Course_Name and batch_details.Batch_Code=student_details.Batch_Code and batch_details.Batch_Name=attendance_details.Batch_Name and attendance_details.Sem_no='"+dno1+"' and university_details.Univ_no=student_details.Univ_no");
        while(rs.next())
        {
        addcomp(200,160,100,30,new JLabel(rs.getString("Sid")));
        addcomp(200,190,200,25,new JLabel(rs.getString("Student_Name")));
        addcomp(200,220,200,25,new JLabel(rs.getString("Course_Name")));
        addcomp(200,250,200,25,new JLabel(rs.getString("Batch_Name")));
        addcomp(200,280,100,25,new JLabel(rs.getString("Sem_no")));
        addcomp(200,310,200,25,new JLabel(rs.getString("Univ_Name")));
        }
        }
        catch(Exception ex) {
        JOptionPane.showMessageDialog(this,ex.getMessage());
        }
        r=380;
        t1=0;
        t2=0;
        t3=0;
        t4=0;
        f1=0;
        c=0;
        try {
        stmt=con.createStatement();
        rs=stmt.executeQuery("select attendance_details.Paper_Name,attendance_details.Teacher_Name,attendance_details.Class_Conducted,attendance_details.M_Class,attendance_details.A_Class,attendance_details.Ab_Class,attendance_details.A_Percentage,attendance_details.Fine from attendance_details,student_details,course_details,batch_details where attendance_details.Sid='"+dno+"' and attendance_details.Sid=student_details.Sid and attendance_details.Course_Name=course_details.Course_Name and course_details.Course_Code=student_details.Course_Code and attendance_details.Batch_Name=batch_details.Batch_Name and batch_details.Batch_Code=student_details.Batch_Code and attendance_details.Sem_no='"+dno1+"'");
        while(rs.next())
        {
        addcomp(25,r,100,25,new JLabel(String.valueOf(sl++)));
        addcomp(70,r,200,25,new JLabel(rs.getString("Paper_Name")));
        addcomp(286,r,200,25,new JLabel(rs.getString("Teacher_Name")));
        addcomp(480,r,60,25,new JLabel(rs.getString("Class_Conducted"),JLabel.CENTER));
        t1=t1+Integer.valueOf(rs.getString("Class_Conducted"));
        addcomp(540,r,65,25,new JLabel(rs.getString("M_Class"),JLabel.CENTER));
        addcomp(605,r,60,25,new JLabel(rs.getString("A_Class"),JLabel.CENTER));
        t2=t2+Integer.valueOf(rs.getString("A_Class"));
        addcomp(665,r,60,25,new JLabel(rs.getString("Ab_Class"),JLabel.CENTER));
        t3=t3+Integer.valueOf(rs.getString("Ab_Class"));
        addcomp(725,r,73,25,new JLabel(rs.getString("A_Percentage")+"%",JLabel.CENTER));
        f1=f1+Float.valueOf(rs.getString("A_Percentage"));
        addcomp(798,r,47,25,new JLabel(rs.getString("Fine"),JLabel.CENTER));
        t4=t4+Integer.valueOf(rs.getString("Fine"));
        r+=25;
        c++;
        }
        }
        catch(Exception ex) {
        JOptionPane.showMessageDialog(this,ex.getMessage());
        }   
        addcomp(290,590,100,25,new JLabel(String.valueOf(t1)));
        addcomp(600,590,100,25,new JLabel(String.valueOf(Float.valueOf(Math.round(f1/c)))+"%"));
        addcomp(290,615,100,25,new JLabel(String.valueOf(t2)));
        if((Float.valueOf(Math.round(f1/c)))!=0)
        	addcomp(600,615,100,25,new JLabel(String.valueOf(100.0-Math.round(f1/c))+"%"));
        else if((Float.valueOf(Math.round(f1/c)))==0)
        	addcomp(600,615,100,25,new JLabel("0.0%"));
        addcomp(290,640,100,25,new JLabel(String.valueOf(t3)));
        addcomp(600,640,100,25,new JLabel("Rs."+String.valueOf(t4)));
        setBounds(250,20,870,740);
        setTitle("Print Student's Attendance Details");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);   
        setResizable(false);
        setLocationRelativeTo(null);
        //setIconImage(Toolkit.getDefaultToolkit().getImage("images/catchpoint.jpg"));
        setIconImage(Toolkit.getDefaultToolkit().getImage("images/catchpoint1.png"));
    }
    public int print(Graphics g,PageFormat pageFormat,int pageIndex)
    {
    if(pageIndex>0)
    return NO_SUCH_PAGE;
    Graphics2D g2D=(Graphics2D)g;
    double scalex=pageFormat.getImageableWidth()/getWidth();
    double scaley=pageFormat.getImageableHeight()/getHeight();
    double scale=Math.min(scalex,scaley);
    g2D.translate(pageFormat.getImageableX(),pageFormat.getImageableY());
    g2D.scale(scale,scale);
    print(g2D);
    return PAGE_EXISTS;
    }
    public void mousePressed(MouseEvent e)
    {
    if(e.getButton()==MouseEvent.BUTTON3)
    {
    if(e.getModifiers()!=0)
    {
    File.show(this,e.getX(),e.getY());
    }
    }
    }
    public void actionPerformed(ActionEvent ae) {
    	String com=ae.getActionCommand();
    	if(com.equals("Exit"))
    	dispose();
    	else if(com.equals("Page Setup")){
    	pm.showPageSetup();
    	}
    	else if(com.equals("Print")){
    	pm.doPrint();
    	}
    }
    public void keyTyped(KeyEvent ke){}
    public void keyPressed(KeyEvent ke){}
    public void keyReleased(KeyEvent ke){}
    public void itemStateChanged(ItemEvent ie){}
    public void mouseClicked(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void windowClosed(WindowEvent we){}
    public void addcomp(int x,int y,int w,int h,Component com)
    {
    com.setBounds(x, y, w, h);
    pnl1.add(com);
       
    }
    public static void main(String[] args) {
        new Attendance_Report();
    }
}
