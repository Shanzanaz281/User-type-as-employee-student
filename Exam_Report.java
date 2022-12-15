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

public class Exam_Report extends JFrame implements ActionListener,Printable,MouseListener
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
    JLabel lblcp=new JLabel("STUDENT's PERFORMANCE REPORT",JLabel.CENTER);
    ImageIcon icon;
    int r,sl=1;
    public Exam_Report() 
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
        g.drawRoundRect(5,120,770,30,20,20);
        g.drawRoundRect(5,155,770,180,20,20);
        g.drawRoundRect(6,340,770,215,20,20);
        g.drawRoundRect(6,565,770,30,20,20);
        g.drawLine(6,380, 775, 380);
        g.drawLine(6,405, 775, 405);
        g.drawLine(55,340, 55, 380);
        g.drawLine(55,405, 55, 555);
        g.drawLine(270,340,270, 555);
        g.drawLine(330,380,330, 380);
        g.drawLine(330,380, 330, 555);
        g.drawLine(390,340, 390, 555);
        g.drawLine(450,380, 450, 555);
        g.drawLine(510,340, 510, 555);
        g.drawLine(580,340, 580, 555);
        g.drawLine(650,340, 650, 555);
        g.drawLine(710,340, 710, 555);            
        g.drawLine(30,625, 263, 625);
        g.drawLine(30,627, 263,627 );
            
        super.paintComponent(g);
        }
      };
        pnl1.setOpaque( false );
        pnl1.setPreferredSize( new Dimension(810,740) );
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
     
    addcomp(240,10,300,60,new JLabel(new ImageIcon("images/cim_lbl.jpg")));
    addcomp(0,70,770,50,lblhead);lblhead.setFont(new Font("Algerian",Font.BOLD,30));
    addcomp(0,110,770,50,lblcp);lblcp.setFont(new Font("Bookman Old Style",Font.BOLD,20));
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
    addcomp(600, 170, 150, 150,lblpic);
    
    String str="profile_pic\\"+dno+"img.jpg";
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Image image = toolkit.getImage(str);
    Image scaledImage = image.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
    ImageIcon icon=new ImageIcon(scaledImage); 
    lblpic.setIcon(icon);
    
    addcomp(10,345,49,25,new JLabel("Sl.No.",JLabel.CENTER));
    addcomp(55,345,215,25,new JLabel("Name Of The Paper",JLabel.CENTER));
    addcomp(270,345,120,25,new JLabel("Theory",JLabel.CENTER));
    addcomp(390,345,120,25,new JLabel("Practical/Viva/PPT",JLabel.CENTER));
    addcomp(510,345,70,25,new JLabel("Attendance",JLabel.CENTER));
    addcomp(580,345,70,25,new JLabel("Assignment",JLabel.CENTER));
    addcomp(650,345,60,25,new JLabel("Unit Test",JLabel.CENTER));
    addcomp(710,345,60,25,new JLabel("Total",JLabel.CENTER));
    
    addcomp(270,380,60,25,new JLabel("MM",JLabel.CENTER));
    addcomp(330,380,60,25,new JLabel("OM",JLabel.CENTER));
    
    addcomp(390,380,60,25,new JLabel("MM",JLabel.CENTER));
    addcomp(450,380,60,25,new JLabel("OM",JLabel.CENTER));
    
    addcomp(510,380,70,25,new JLabel("10",JLabel.CENTER));
    addcomp(580,380,70,25,new JLabel("10",JLabel.CENTER));
    addcomp(650,380,60,25,new JLabel("10",JLabel.CENTER));
    addcomp(710,380,60,25,new JLabel("100",JLabel.CENTER));
        
    addcomp(645,565,90,30,new JLabel("Grand Total  :"));
    addcomp(20,565,90,30,new JLabel("Remarks  :"));
    addcomp(310,565,100,30,new JLabel("Percentage(%)  :"));
    
	addcomp(30,600,250,25,new JLabel("Marks Obtained In Add-On Papers(If Any):"));
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
        r=410;
        try {
        stmt=con.createStatement();
        rs=stmt.executeQuery("select course_exam_details.Paper_Name1,paper_details.PaperTh_Marks,paper_details.PaperPrac_Marks,course_exam_details.E_om1,course_exam_details.E_om2,course_exam_details.E_om3,course_exam_details.E_om4,course_exam_details.E_om5,course_exam_details.E_Total1 from course_exam_details,student_details,paper_details,course_details where course_exam_details.Sid='"+dno+"' and course_exam_details.Sid=student_details.Sid and course_details.Course_Code=paper_details.Course_Code and paper_details.Paper_Name=course_exam_details.Paper_Name1 and paper_details.Paper_Type='COURSEWARE' and course_exam_details.Sem_no='"+dno1+"'");
        while(rs.next())
        {
        addcomp(25,r,100,25,new JLabel(String.valueOf(sl++)));
        addcomp(70,r,200,25,new JLabel(rs.getString("Paper_Name1")));
        if(rs.getString("PaperTh_Marks").equals("0")){
        	addcomp(270,r,60,25,new JLabel("N/A",JLabel.CENTER));
        }
        else{
        	addcomp(270,r,60,25,new JLabel(rs.getString("PaperTh_Marks"),JLabel.CENTER));
        }
        if(rs.getString("E_om1").equals("0")){
        	addcomp(330,r,60,25,new JLabel("N/A",JLabel.CENTER));
        }
        else{
        	addcomp(330,r,60,25,new JLabel(rs.getString("E_om1"),JLabel.CENTER));
        }
        if(rs.getString("PaperPrac_Marks").equals("0")){
        	addcomp(390,r,60,25,new JLabel("N/A",JLabel.CENTER));
        }
        else{
        	addcomp(390,r,60,25,new JLabel(rs.getString("PaperPrac_Marks"),JLabel.CENTER));
        }
        if(rs.getString("E_om2").equals("0")){
        	addcomp(450,r,60,25,new JLabel("N/A",JLabel.CENTER));
        }
        else{
        	addcomp(450,r,60,25,new JLabel(rs.getString("E_om2"),JLabel.CENTER));
        }
        addcomp(510,r,70,25,new JLabel(rs.getString("E_om3"),JLabel.CENTER));
        addcomp(580,r,70,25,new JLabel(rs.getString("E_om4"),JLabel.CENTER));
        addcomp(650,r,60,25,new JLabel(rs.getString("E_om5"),JLabel.CENTER));
        addcomp(710,r,60,25,new JLabel(rs.getString("E_Total1"),JLabel.CENTER));
        r+=25;
        }
        }
        catch(Exception ex) {
        JOptionPane.showMessageDialog(this,ex.getMessage());
        } 
        try{
        	stmt=con.createStatement();
        	rs=stmt.executeQuery("select result_details.Grand_Total,result_details.Percentage_Marks,result_details.Exam_Remark from result_details,student_details,course_details,batch_details,university_details where result_details.Sid='"+dno+"' and result_details.Sid=student_details.Sid and result_details.Course_Name=course_details.Course_Name and course_details.Course_Code=student_details.Course_Code and result_details.Batch_Name=batch_details.Batch_Name and batch_details.Batch_Code=student_details.Batch_Code and result_details.Univ_Name=university_details.Univ_Name and university_details.Univ_no=student_details.Univ_no and result_details.Sem_no='"+dno1+"'");
        	if(rs.next()){
        		addcomp(730,565,100,30,new JLabel(rs.getString("Grand_Total")));
        		addcomp(415,565,100,30,new JLabel(rs.getString("Percentage_Marks")+"%"));
        		addcomp(105,565,100,30,new JLabel(rs.getString("Exam_Remark")));
        	}
        }catch(Exception ex) {
        JOptionPane.showMessageDialog(this,ex.getMessage());
        }
        r=635;
        try{
        	stmt=con.createStatement();
        	rs=stmt.executeQuery("select addon_exam_details.Paper_Name2,addon_exam_details.E_Total2 from addon_exam_details,student_details,paper_details,course_details where addon_exam_details.Sid='"+dno+"' and addon_exam_details.Sid=student_details.Sid and course_details.Course_Code=paper_details.Course_Code and paper_details.Paper_Name=addon_exam_details.Paper_Name2 and paper_details.Paper_Type='ADD-ON' and addon_exam_details.Sem_no='"+dno1+"'");
        	while(rs.next()){
        		 addcomp(30,r,100,25,new JLabel(rs.getString("Paper_Name2")+" :"));
        		 addcomp(130,r,100,25,new JLabel(rs.getString("E_Total2")));
        		 r=r+25;
        	}
        }catch(Exception ex){
        	JOptionPane.showMessageDialog(this,ex.getMessage());
        }
       setBounds(250,20,790,740);
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
        new Exam_Report();
    }
}
