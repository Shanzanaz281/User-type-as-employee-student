import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Exam_Details extends JFrame implements ActionListener,ItemListener,KeyListener {
    Connection cn,cn1;
    Statement stmt,stmt1;
    ResultSet rs,rs1;
    String sql = "";
    JTextField txtname,txtcourse_name,txtbatch_name,txtroll,txtuniv_name;
    JTextField txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10,txtgt,txtp,txtr,txtd1,txtd2,txtd3,txtd4,txtd5,txtd6,txtd7,txtd8,txtd9,txtd10;
    JButton btnreset, btnsave, btnexit,btnpre,btnfind,but1,but2,btnnext;
    JLabel lblhead,lblstudent_name,lblid, lblline,lblcourse_name,lblbatch_name,lbl1,lbl2,lbl3,lbl4,lbldown,lbld1,lbld2;
    JCheckBox chkdo;
    JComboBox cmbsid,cmbsem_no;
    JPanel panel;
    Container c;
    ImageIcon img;
    List lstsub,lstteacher,lstfm1,lstfm2,lstom2,lstom1,lstfm3,lstom3,lstavg,lstfm4,lstom4,lstfm5,lstom5,lstsubd,lstd1,lstd2,lstd3,lstd4,lstd5,lstd6,lstd7,lstd8,lstd9,lstd10,lstd11;
    public Exam_Details() {
        img = new ImageIcon("images/2jb0c3d.jpg", null);
        panel = new JPanel() {
                protected void paintComponent(Graphics g) {
                    g.drawImage(img.getImage(), 0, 0, 1400, 700, null);
                    super.paintComponent(g);
                }
            };
        panel.setOpaque(false);
        panel.setPreferredSize(new Dimension(1400, 700));
        c = getContentPane();
        panel.setLayout(null);
        c.add(panel);
        lblhead = new JLabel("INTERNAL EXAMS DETAILS");
        lblhead.setFont(new Font("COPPERPLATE GOTHIC LIGHT", Font.CENTER_BASELINE, 25));
                
                lblline = new JLabel("_____________________________________________________________________________________________________________________________________________________");
                lbldown=new JLabel("ASSESSMENT REPORT OF ADD-ON COURSE CONDUCTED");
                lblid = new JLabel("ID No.");
                lblstudent_name = new JLabel("Student's Name");
                lblcourse_name=new JLabel("Course Name");
                lblbatch_name=new JLabel("Batch Name");
                lbl1=new JLabel("Paper's");
                lbl3=new JLabel("Name");
                lbl1.setFont(new Font("COPPERPLATE GOTHIC LIGHT", Font.CENTER_BASELINE, 15));
                lbl3.setFont(new Font("COPPERPLATE GOTHIC LIGHT", Font.CENTER_BASELINE, 15));
                
                lbld1=new JLabel("Paper's");
                lbld2=new JLabel("Name");
                lbld1.setFont(new Font("COPPERPLATE GOTHIC LIGHT", Font.CENTER_BASELINE, 15));
                lbld2.setFont(new Font("COPPERPLATE GOTHIC LIGHT", Font.CENTER_BASELINE, 15));
                lbl2=new JLabel("Teacher's");
                lbl4=new JLabel("Name");
                lbl2.setFont(new Font("COPPERPLATE GOTHIC LIGHT", Font.CENTER_BASELINE, 15));
                lbl4.setFont(new Font("COPPERPLATE GOTHIC LIGHT", Font.CENTER_BASELINE, 15));
                lbldown.setFont(new Font("COPPERPLATE GOTHIC LIGHT", Font.CENTER_BASELINE, 15));
                chkdo = new JCheckBox("Check it for getting Student Details");
                chkdo.setOpaque(false);
                
                cmbsid =new JComboBox();
                cmbsid.addItem("--Select--");
                btnfind=new JButton();
                txtname=new JTextField();
                txtcourse_name=new JTextField();
                txtbatch_name=new JTextField();
                txtroll=new JTextField();
                txtuniv_name=new JTextField();
                txtgt=new JTextField();
                txtp=new JTextField();
                txtr=new JTextField();
                cmbsem_no=new JComboBox();
                cmbsem_no.addItem("--Select--");
                cmbsem_no.addItem("1");
                cmbsem_no.addItem("2");
                cmbsem_no.addItem("3");
                cmbsem_no.addItem("4");
                cmbsem_no.addItem("5");
                cmbsem_no.addItem("6");
                lstsub=new List();
                lstteacher=new List();
                lstfm1=new List();
                lstfm2=new List();
                lstom2=new List();
                lstom1=new List();
                lstom3=new List();
                lstfm3=new List();
                lstfm4=new List();
                lstfm5=new List();
                lstom4=new List();
                lstom5=new List();
                lstavg=new List();
                lstsubd=new List();
                lstd1=new List();
                lstd2=new List();
                lstd3=new List();
                lstd4=new List();
                lstd5=new List();
                lstd6=new List();
                lstd7=new List();
                lstd8=new List();
                lstd9=new List();
                lstd10=new List();
                lstd11=new List();
                txt1=new JTextField();
                txt1.addKeyListener(this);
                txt2=new JTextField();
                txt2.addKeyListener(this);
                txt3=new JTextField();
                txt3.addKeyListener(this);
                txt4=new JTextField();
                txt4.addKeyListener(this);
                txt5=new JTextField();
                txt5.addKeyListener(this);
                txt6=new JTextField();
                txt6.addKeyListener(this);
                txt7=new JTextField();
                txt7.addKeyListener(this);
                txt8=new JTextField();
                txt8.addKeyListener(this);
                txt9=new JTextField();
                txt9.addKeyListener(this);
                txt10=new JTextField();
                txt10.addKeyListener(this);
                
                txtd1=new JTextField();
                txtd1.addKeyListener(this);
                txtd2=new JTextField();
                txtd2.addKeyListener(this);
                txtd3=new JTextField();
                txtd3.addKeyListener(this);
                txtd4=new JTextField();
                txtd4.addKeyListener(this);
                txtd5=new JTextField();
                txtd5.addKeyListener(this);
                txtd6=new JTextField();
                txtd6.addKeyListener(this);
                txtd7=new JTextField();
                txtd7.addKeyListener(this);
                txtd8=new JTextField();
                txtd8.addKeyListener(this);
                txtd9=new JTextField();
                txtd9.addKeyListener(this);
                txtd10=new JTextField();
                txtd10.addKeyListener(this);
                
                try{
		        	Class.forName("com.mysql.jdbc.Driver");
		    	    cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_final?characterEncoding=UTF-8","root","");
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(this, ex.toString());
		        }
		        try{
		        	stmt = cn.createStatement();
		        	rs=stmt.executeQuery("select Sid from student_details order by Sid asc");
		            while(rs.next()){
		            cmbsid.addItem(rs.getString("Sid"));
		            }
		        }catch(Exception ex){            
		            JOptionPane.showMessageDialog(this,ex.toString());
		        }
		    
		        btnreset = new JButton("Reset", new ImageIcon("images/ico1_1.png"));
		        btnreset.addActionListener(this); 
		        btnsave = new JButton("Save", new ImageIcon("images/save3.png"));
		        btnsave.addActionListener(this);
		        btnexit = new JButton("Exit", new ImageIcon("images/KREST.png"));
		        btnexit.addActionListener(this);
		        btnpre=new JButton("Back",new ImageIcon("images/pre2.png"));
		        btnpre.addActionListener(this);
		        btnfind=new JButton("Find",new ImageIcon("images/search.png"));
		        btnfind.addActionListener(this);
		        but1=new JButton("Cal.",new ImageIcon("images/CMS-calc1.png"));
		        but1.addActionListener(this);
		        but2=new JButton("Cal.",new ImageIcon("images/CMS-calc1.png"));
		        but2.addActionListener(this);
		        btnnext = new JButton("Next", new ImageIcon("images/next2.png"));
		        btnnext.addActionListener(this);
		        addcomp(220, 0, 400, 50, lblhead);
		        addcomp(1075, 10, 250, 65, new JLabel(new ImageIcon("images/cim_lbl1_1.jpg")));
		        addcomp(220, 90, 70, 30, lblid);
		        addcomp(350, 90, 100, 30, cmbsid);
		        addcomp(460, 90, 250, 30, chkdo);chkdo.addItemListener(this);
		        addcomp(725,90,100,30,new JLabel("Semester no."));
		        addcomp(855,90,100,30,cmbsem_no);
		        addcomp(960,90,90,30,btnfind);
		        cmbsem_no.addItemListener(this);
		        
		        addcomp(220, 120, 1250, 15, lblline);
		        

		        addcomp(220, 145, 100, 30, lblstudent_name);
		        addcomp(350, 145, 200, 30, txtname);

		        /*addcomp(725,145,100,30,new JLabel("Class Roll no"));
		        addcomp(855,145,100,30,txtroll);*/
		        
		        addcomp(725,145,100,30,lblbatch_name);
		        addcomp(855,145,200,30,txtbatch_name);
		        
		        addcomp(220, 185, 100, 30, lblcourse_name);
		        addcomp(350, 185, 200, 30, txtcourse_name);

		        addcomp(725, 185, 100, 30, new JLabel("University"));
		        addcomp(855, 185, 200, 30, txtuniv_name);
		        
		        addcomp(220, 225, 1250, 15, new JLabel("_____________________________________________________________________________________________________________________________________________________"));
		        addcomp(300,248,100,30,lbl1);
		        addcomp(310,278,100,30,lbl3);
		        /*addcomp(530,248,100,30,lbl2);
		        addcomp(550,278,100,30,lbl4);*/
		        
		        addcomp(520,240,100,20,new JLabel("THEORY"));
		        addcomp(500,260,75,20,new JLabel("F.M"));
		        addcomp(480,290,60,30,txt1);
		        
		        addcomp(520,440,75,20,new JLabel("REMARKS"));
		        addcomp(620,435,60,30,txtr);
		        
		        addcomp(545,258,1,170,new JLabel(new ImageIcon("images/line.jpg")));
		        
		        addcomp(567,260,75,20,new JLabel("O.M"));
		        addcomp(550,290,60,30,txt2);
		        
		        addcomp(615,239,1,189,new JLabel(new ImageIcon("images/line.jpg")));
		        
		        addcomp(625,240,130,20,new JLabel("PRAC./VIVA/PROJECT"));
		        addcomp(637,260,75,20,new JLabel("F.M"));
		        addcomp(620,290,60,30,txt3);
		        
		        addcomp(685,258,1,170,new JLabel(new ImageIcon("images/line.jpg")));
		        
		        addcomp(707,260,75,20,new JLabel("O.M"));
		        addcomp(690,290,60,30,txt4);
		        
		        addcomp(755,239,1,189,new JLabel(new ImageIcon("images/line.jpg")));
		        
		        addcomp(787,240,100,20,new JLabel("ATTENDANCE"));
		        addcomp(777,260,85,20,new JLabel("F.M"));
		        addcomp(760,290,60,30,txt5);
		        
		        addcomp(787,440,120,20,new JLabel("PERCENTAGE"));
		        addcomp(900,435,60,30,txtp);
		        
		        addcomp(825,258,1,170,new JLabel(new ImageIcon("images/line.jpg")));
		        
		        addcomp(847,260,75,20,new JLabel("O.M"));
		        addcomp(830,290,60,30,txt6);
		        
		        addcomp(895,239,1,189,new JLabel(new ImageIcon("images/line.jpg")));
		        
		        addcomp(927,240,100,20,new JLabel("ASSIGNMENT"));
		        addcomp(917,260,85,20,new JLabel("F.M"));
		        addcomp(900,290,60,30,txt7);
		        addcomp(965,258,1,170,new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(987,260,85,20,new JLabel("O.M"));
		        addcomp(970,290,60,30,txt8);
		        addcomp(1035,239,1,189,new JLabel(new ImageIcon("images/line.jpg")));
		        
		        addcomp(1067,240,100,20,new JLabel("UNIT TEST"));
		        addcomp(1057,260,85,20,new JLabel("F.M"));		        
		        addcomp(1040,290,60,30,txt9);
		        addcomp(1127,260,85,20,new JLabel("O.M"));
		        addcomp(1110,290,60,30,txt10);
		        
		        addcomp(1060,440,120,20,new JLabel("GRAND TOTAL")); 
		        addcomp(1182,435,75,30,txtgt);
		        addcomp(220, 465, 1250, 15, new JLabel("_____________________________________________________________________________________________________________________________________________________"));
		        addcomp(480, 485, 520, 20,lbldown);
		        addcomp(220, 500, 1250, 15, new JLabel("_____________________________________________________________________________________________________________________________________________________"));
		        //addcomp(220, 630, 1250, 15, new JLabel("_____________________________________________________________________________________________________________________________________________________"));
		        addcomp(220,512,1,140,new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(300,520,100,30,lbld1);
		        addcomp(310,550,100,30,lbld2);
		        addcomp(1262,512,1,140,new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(474, 514, 1, 140, new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(474, 520, 776, 15, new JLabel("____________________________________________________________________________________________________"));
		        addcomp(474, 540, 996, 15, new JLabel("_________________________________________________________________________________________________________________")); 
		        addcomp(220, 575, 1250, 15, new JLabel("_____________________________________________________________________________________________________________________________________________________"));
		        addcomp(225,590,245,60,lstsubd);
		        addcomp(516,514,100,20,new JLabel("THEORY"));
		        addcomp(496,534,85,20,new JLabel("F.M"));
		        addcomp(479,556,60,30,txtd1);
		        addcomp(479,590,60,60,lstd1);
		        addcomp(544, 534, 1, 120, new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(566,534,85,20,new JLabel("O.M"));
		        addcomp(549,556,60,30,txtd2);
		        addcomp(549,590,60,60,lstd2);
		        addcomp(614, 514, 1, 140, new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(624,514,125,20,new JLabel("PRAC./VIVA/PROJECT"));
		        addcomp(636,534,85,20,new JLabel("F.M"));
		        addcomp(619,556,60,30,txtd3);
		        addcomp(619,590,60,60,lstd3);
		        addcomp(684, 534, 1, 120, new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(706,534,85,20,new JLabel("O.M"));
		        addcomp(689,556,60,30,txtd4);
		        addcomp(689,590,60,60,lstd4);
		        addcomp(754, 514, 1, 140, new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(786,514,125,20,new JLabel("ATTENDANCE"));
		        addcomp(776,534,85,20,new JLabel("F.M"));
		        addcomp(759,556,60,30,txtd5);
		        addcomp(759,590,60,60,lstd5);
		        addcomp(824, 534, 1, 120, new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(846,534,85,20,new JLabel("O.M"));
		        addcomp(829,556,60,30,txtd6);
		        addcomp(829,590,60,60,lstd6);
		        addcomp(894, 514, 1, 140, new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(926,514,125,20,new JLabel("ASSIGNMENT"));
		        addcomp(916,534,85,20,new JLabel("F.M"));
		        addcomp(899,556,60,30,txtd7);
		        addcomp(899,590,60,60,lstd7);
		        addcomp(964, 534, 1, 120, new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(986,534,85,20,new JLabel("O.M"));
		        addcomp(969,556,60,30,txtd8);
		        addcomp(969,590,60,60,lstd8);
		        addcomp(1034, 514, 1, 140, new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(1066,514,125,20,new JLabel("UNIT TEST"));
		        addcomp(1056,534,85,20,new JLabel("F.M"));
		        addcomp(1039,556,60,30,txtd9);
		        addcomp(1039,590,60,60,lstd9);
		        addcomp(1104, 534, 1, 120, new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(1126,534,85,20,new JLabel("O.M"));
		        addcomp(1109,556,60,30,txtd10);
		        addcomp(1109,590,60,60,lstd10);
		        addcomp(1174, 514, 1, 140, new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(1197,514,125,20,new JLabel("TOTAL"));
		        addcomp(1202,530,75,20,new JLabel("(100)"));
		        addcomp(1182,556,75,30,but2);
		        addcomp(1182,590,75,60,lstd11);
		        
		        
		        addcomp(1197,240,75,20,new JLabel("TOTAL"));
		        addcomp(1202,260,75,20,new JLabel("(100)"));
		        
		        addcomp(1105,258,1,170,new JLabel(new ImageIcon("images/line.jpg")));
		        
		        addcomp(474, 245, 776, 15, new JLabel("____________________________________________________________________________________________________"));
		        
		        /*addcomp(1113,240,100,20,new JLabel("PERCENTAGE"));
		        addcomp(1113,260,100,20,new JLabel("TEST MARKS"));*/
		        
		        addcomp(220,308,1250,15,new JLabel("_____________________________________________________________________________________________________________________________________________________"));
		        
		        addcomp(474, 270, 996, 15, new JLabel("_________________________________________________________________________________________________________________")); 
		        addcomp(1262, 239, 1, 189, new JLabel(new ImageIcon("images/line.jpg")));
		        
		        addcomp(220, 239, 1, 189, new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(225,325,245,100,lstsub);
		        addcomp(474, 239, 1, 189, new JLabel(new ImageIcon("images/line.jpg")));
		        /*addcomp(480,325,200,150,lstteacher);
		        addcomp(684, 239, 1, 239, new JLabel(new ImageIcon("images/line.jpg")));*/
		        addcomp(480,325,60,100,lstfm1);
		        addcomp(620,325,60,100,lstfm2);
		        addcomp(690,325,60,100,lstom2);
		        addcomp(550,325,60,100,lstom1);
		        addcomp(760,325,60,100,lstfm3);
		        addcomp(830,325,60,100,lstom3);
		        
		        addcomp(900,325,60,100,lstfm4);
		        addcomp(970,325,60,100,lstom4);
		        addcomp(1040,325,60,100,lstfm5);
		        addcomp(1110,325,60,100,lstom5);
		        
		        addcomp(1175, 239, 1, 189, new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(1182,325,75,100,lstavg);
		        addcomp(1182,290,75,30,but1);
		        addcomp(220, 415, 1250, 15, new JLabel("_____________________________________________________________________________________________________________________________________________________"));
		        addcomp(220, 640, 1250, 15, new JLabel("_____________________________________________________________________________________________________________________________________________________"));
		        addcomp(775, 665, 90, 30, btnreset);
		        addcomp(875, 665, 90, 30, btnsave);
		        addcomp(975, 665, 90, 30, btnpre);
		        addcomp(1075, 665, 90, 30, btnnext);
		        addcomp(1175, 665 ,90, 30, btnexit);
		        addcomp(00, 00, 204,702, new JLabel(new ImageIcon("images/exam_side.jpg")));
		       

        setBounds(0, 0, 1367, 730);
        setTitle("Exam Details Form");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        //setIconImage(Toolkit.getDefaultToolkit().getImage("images/catchpoint.jpg"));
        setIconImage(Toolkit.getDefaultToolkit().getImage("images/catchpoint1.png"));
    }

    public void itemStateChanged(ItemEvent ie) {
    	if(ie.getSource()==chkdo){
    		if(chkdo.isSelected()) {
    			try{
            		stmt=cn.createStatement();
            		rs=stmt.executeQuery("select student_details.Student_Name,university_details.Univ_Name,course_details.Course_Name,batch_details.Batch_Name from student_details,university_details,course_details,batch_details where Sid='"+cmbsid.getSelectedItem()+"' and university_details.Univ_no=student_details.Univ_no and course_details.Course_Code=student_details.Course_Code and batch_details.Batch_Code=student_details.Batch_Code");
            		if(rs.next()){            			
            			txtname.setText(rs.getString("Student_Name"));
            			txtuniv_name.setText(rs.getString("Univ_Name"));        			
            			txtcourse_name.setText(rs.getString("Course_Name"));
            			txtbatch_name.setText(rs.getString("Batch_Name"));
                      //JOptionPane.showMessageDialog(this,"Student Details Found,Please Proceed");
            		}/*else
                	  JOptionPane.showMessageDialog(this,"Record Not Found,Please Insert Values");*/
                	}catch(Exception ex){            
                	  JOptionPane.showMessageDialog(this,ex.toString());
                	}
    		}
    		if(chkdo.isSelected()==false) {
    			cmbsid.setSelectedIndex(0);
    			txtname.setText("");
    			txtuniv_name.setText("");
    			txtcourse_name.setText("");
    			txtbatch_name.setText("");
    			lstom3.removeAll();
    			lstom4.removeAll();
    			lstom5.removeAll();
    			lstd6.removeAll();
    			lstd8.removeAll();
    			lstd10.removeAll();
    		}
    	}
        if(ie.getSource()==cmbsem_no) {
        	lstsub.removeAll();
        	lstsubd.removeAll();
        	lstfm1.removeAll();
        	lstfm2.removeAll();
        	lstd1.removeAll();
        	lstd3.removeAll();
        	lstom3.removeAll();
        	lstd6.removeAll();
        	lstfm3.removeAll();
        	lstfm4.removeAll();
        	lstfm5.removeAll();
        	lstd5.removeAll();
        	lstd7.removeAll();
        	lstd9.removeAll();
        	lstom4.removeAll();
        	lstom5.removeAll();
        	lstd8.removeAll();
        	lstd10.removeAll();
        	String str="";
        	String str1="";
        	Float f,f1;
        	int t,t1;
            if(cmbsem_no.getItemAt(1).equals("1")) {

            	try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select paper_details.Paper_Name,paper_details.PaperTh_Marks,paper_details.PaperPrac_Marks from paper_details,student_details where paper_details.Course_Code=student_details.Course_Code and paper_details.Univ_no=student_details.Univ_no and paper_details.Paper_Type='COURSEWARE' and paper_details.Sem_no='"+cmbsem_no.getSelectedItem()+"' and student_details.Sid='"+cmbsid.getSelectedItem()+"'");
                	while(rs.next()){
                		lstsub.addItem(rs.getString("Paper_Name")); 
                		lstfm1.add(rs.getString("PaperTh_Marks"));
                		lstfm2.add(rs.getString("PaperPrac_Marks"));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
                }
            	try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select paper_details.Paper_Name,paper_details.PaperTh_Marks,paper_details.PaperPrac_Marks from paper_details,student_details where paper_details.Course_Code=student_details.Course_Code and paper_details.Univ_no=student_details.Univ_no and paper_details.Paper_Type='ADD-ON' and paper_details.Sem_no='"+cmbsem_no.getSelectedItem()+"' and student_details.Sid='"+cmbsid.getSelectedItem()+"'");
                	while(rs.next()){
                		lstsubd.addItem(rs.getString("Paper_Name"));
                		lstd1.add(rs.getString("PaperTh_Marks"));
                		lstd3.add(rs.getString("PaperPrac_Marks"));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
                try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select attendance_details.A_Percentage from attendance_details,paper_details where attendance_details.Paper_Name=paper_details.Paper_Name and paper_details.Paper_Type='COURSEWARE' and attendance_details.Sid='"+cmbsid.getSelectedItem()+"' and attendance_details.Sem_no='"+cmbsem_no.getSelectedItem()+"'");
                	while(rs.next()){
                		str=rs.getString("A_Percentage");
                		f=(10*(Float.valueOf(str)/100));
                		t=Integer.valueOf(Math.round(f));
                		lstom3.add(String.valueOf(t));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
                try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select attendance_details.A_Percentage from attendance_details,paper_details where attendance_details.Paper_Name=paper_details.Paper_Name and paper_details.Paper_Type='ADD-ON' and attendance_details.Sid='"+cmbsid.getSelectedItem()+"' and attendance_details.Sem_no='"+cmbsem_no.getSelectedItem()+"'");
                	while(rs.next()){
                		str=rs.getString("A_Percentage");
                		f=(10*(Float.valueOf(str)/100));
                		t=Integer.valueOf(Math.round(f));
                		lstd6.add(String.valueOf(t));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
                
                try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select assign_details.Avge,test_details.Avg from assign_details,test_details,paper_details where assign_details.Paper_Name=paper_details.Paper_Name and paper_details.Paper_Type='COURSEWARE' and assign_details.Sid='"+cmbsid.getSelectedItem()+"' and assign_details.Sem_no='"+cmbsem_no.getSelectedItem()+"' and test_details.Paper_Name=paper_details.Paper_Name and paper_details.Paper_Type='COURSEWARE' and test_details.Sid='"+cmbsid.getSelectedItem()+"' and test_details.Sem_no='"+cmbsem_no.getSelectedItem()+"'");
                	while(rs.next()){
                		str=rs.getString("Avge");
                		str1=rs.getString("Avg");
                		f=(10*(Float.valueOf(str)/100));
                		t=Integer.valueOf(Math.round(f));
                		
                		f1=(10*(Float.valueOf(str1)/100));
                		t1=Integer.valueOf(Math.round(f1));
                		
                		lstom4.add(String.valueOf(t));
                		lstom5.add(String.valueOf(t1));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
                try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select assign_details.Avge,test_details.Avg from assign_details,test_details,paper_details where assign_details.Paper_Name=paper_details.Paper_Name and paper_details.Paper_Type='ADD-ON' and assign_details.Sid='"+cmbsid.getSelectedItem()+"' and assign_details.Sem_no='"+cmbsem_no.getSelectedItem()+"' and test_details.Paper_Name=paper_details.Paper_Name and paper_details.Paper_Type='ADD-ON' and test_details.Sid='"+cmbsid.getSelectedItem()+"' and test_details.Sem_no='"+cmbsem_no.getSelectedItem()+"'");
                	while(rs.next()){
                		str=rs.getString("Avge");
                		str1=rs.getString("Avg");
                		f=(10*(Float.valueOf(str)/100));
                		t=Integer.valueOf(Math.round(f));
                		
                		f1=(10*(Float.valueOf(str1)/100));
                		t1=Integer.valueOf(Math.round(f1));
                		
                		lstd8.add(String.valueOf(t));
                		lstd10.add(String.valueOf(t1));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
                
                for(int i=0;i<lstsub.getItemCount();i++){
                	lstfm3.add("10", i);
                	lstfm4.add("10", i);
                	lstfm5.add("10", i);
                }
                for(int j=0;j<lstsubd.getItemCount();j++){
                	lstd5.add("10", j);
                	lstd7.add("10", j);
                	lstd9.add("10", j);
                }
            }
            else if(cmbsem_no.getItemAt(2).equals("2")) {

            	try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select paper_details.Paper_Name,paper_details.PaperTh_Marks,paper_details.PaperPrac_Marks from paper_details,student_details where paper_details.Course_Code=student_details.Course_Code and paper_details.Univ_no=student_details.Univ_no and paper_details.Paper_Type='COURSEWARE' and paper_details.Sem_no='"+cmbsem_no.getSelectedItem()+"' and student_details.Sid='"+cmbsid.getSelectedItem()+"'");
                	while(rs.next()){
                		lstsub.addItem(rs.getString("Paper_Name")); 
                		lstfm1.add(rs.getString("PaperTh_Marks"));
                		lstfm2.add(rs.getString("PaperPrac_Marks"));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
                }
            	try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select paper_details.Paper_Name,paper_details.PaperTh_Marks,paper_details.PaperPrac_Marks from paper_details,student_details where paper_details.Course_Code=student_details.Course_Code and paper_details.Univ_no=student_details.Univ_no and paper_details.Paper_Type='ADD-ON' and paper_details.Sem_no='"+cmbsem_no.getSelectedItem()+"' and student_details.Sid='"+cmbsid.getSelectedItem()+"'");
                	while(rs.next()){
                		lstsubd.addItem(rs.getString("Paper_Name"));
                		lstd1.add(rs.getString("PaperTh_Marks"));
                		lstd3.add(rs.getString("PaperPrac_Marks"));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
                try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select attendance_details.A_Percentage from attendance_details,paper_details where attendance_details.Paper_Name=paper_details.Paper_Name and paper_details.Paper_Type='COURSEWARE' and attendance_details.Sid='"+cmbsid.getSelectedItem()+"' and attendance_details.Sem_no='"+cmbsem_no.getSelectedItem()+"'");
                	while(rs.next()){
                		str=rs.getString("A_Percentage");
                		f=(10*(Float.valueOf(str)/100));
                		t=Integer.valueOf(Math.round(f));
                		lstom3.add(String.valueOf(t));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
                try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select attendance_details.A_Percentage from attendance_details,paper_details where attendance_details.Paper_Name=paper_details.Paper_Name and paper_details.Paper_Type='ADD-ON' and attendance_details.Sid='"+cmbsid.getSelectedItem()+"' and attendance_details.Sem_no='"+cmbsem_no.getSelectedItem()+"'");
                	while(rs.next()){
                		str=rs.getString("A_Percentage");
                		f=(10*(Float.valueOf(str)/100));
                		t=Integer.valueOf(Math.round(f));
                		lstd6.add(String.valueOf(t));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
                try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select assign_details.Avge,test_details.Avg from assign_details,test_details,paper_details where assign_details.Paper_Name=paper_details.Paper_Name and paper_details.Paper_Type='COURSEWARE' and assign_details.Sid='"+cmbsid.getSelectedItem()+"' and assign_details.Sem_no='"+cmbsem_no.getSelectedItem()+"' and test_details.Paper_Name=paper_details.Paper_Name and paper_details.Paper_Type='COURSEWARE' and test_details.Sid='"+cmbsid.getSelectedItem()+"' and test_details.Sem_no='"+cmbsem_no.getSelectedItem()+"'");
                	while(rs.next()){
                		str=rs.getString("Avge");
                		str1=rs.getString("Avg");
                		f=(10*(Float.valueOf(str)/100));
                		t=Integer.valueOf(Math.round(f));
                		
                		f1=(10*(Float.valueOf(str1)/100));
                		t1=Integer.valueOf(Math.round(f1));
                		
                		lstom4.add(String.valueOf(t));
                		lstom5.add(String.valueOf(t1));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
                try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select assign_details.Avge,test_details.Avg from assign_details,test_details,paper_details where assign_details.Paper_Name=paper_details.Paper_Name and paper_details.Paper_Type='ADD-ON' and assign_details.Sid='"+cmbsid.getSelectedItem()+"' and assign_details.Sem_no='"+cmbsem_no.getSelectedItem()+"' and test_details.Paper_Name=paper_details.Paper_Name and paper_details.Paper_Type='ADD-ON' and test_details.Sid='"+cmbsid.getSelectedItem()+"' and test_details.Sem_no='"+cmbsem_no.getSelectedItem()+"'");
                	while(rs.next()){
                		str=rs.getString("Avge");
                		str1=rs.getString("Avg");
                		f=(10*(Float.valueOf(str)/100));
                		t=Integer.valueOf(Math.round(f));
                		
                		f1=(10*(Float.valueOf(str1)/100));
                		t1=Integer.valueOf(Math.round(f1));
                		
                		lstd8.add(String.valueOf(t));
                		lstd10.add(String.valueOf(t1));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
                
                for(int i=0;i<lstsub.getItemCount();i++){
                	lstfm3.add("10", i);
                	lstfm4.add("10", i);
                	lstfm5.add("10", i);
                }
                for(int j=0;j<lstsubd.getItemCount();j++){
                	lstd5.add("10", j);
                	lstd7.add("10", j);
                	lstd9.add("10", j);
                }
            }
            else if(cmbsem_no.getItemAt(3).equals("3")) {
            	try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select paper_details.Paper_Name,paper_details.PaperTh_Marks,paper_details.PaperPrac_Marks from paper_details,student_details where paper_details.Course_Code=student_details.Course_Code and paper_details.Univ_no=student_details.Univ_no and paper_details.Paper_Type='COURSEWARE' and paper_details.Sem_no='"+cmbsem_no.getSelectedItem()+"' and student_details.Sid='"+cmbsid.getSelectedItem()+"'");
                	while(rs.next()){
                		lstsub.addItem(rs.getString("Paper_Name")); 
                		lstfm1.add(rs.getString("PaperTh_Marks"));
                		lstfm2.add(rs.getString("PaperPrac_Marks"));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
                }

            	try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select paper_details.Paper_Name,paper_details.PaperTh_Marks,paper_details.PaperPrac_Marks from paper_details,student_details where paper_details.Course_Code=student_details.Course_Code and paper_details.Univ_no=student_details.Univ_no and paper_details.Paper_Type='ADD-ON' and paper_details.Sem_no='"+cmbsem_no.getSelectedItem()+"' and student_details.Sid='"+cmbsid.getSelectedItem()+"'");
                	while(rs.next()){
                		lstsubd.addItem(rs.getString("Paper_Name"));
                		lstd1.add(rs.getString("PaperTh_Marks"));
                		lstd3.add(rs.getString("PaperPrac_Marks"));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
                
                
                try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select attendance_details.A_Percentage from attendance_details,paper_details where attendance_details.Paper_Name=paper_details.Paper_Name and paper_details.Paper_Type='COURSEWARE' and attendance_details.Sid='"+cmbsid.getSelectedItem()+"' and attendance_details.Sem_no='"+cmbsem_no.getSelectedItem()+"'");
                	while(rs.next()){
                		str=rs.getString("A_Percentage");
                		f=(10*(Float.valueOf(str)/100));
                		t=Integer.valueOf(Math.round(f));
                		lstom3.add(String.valueOf(t));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
                try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select attendance_details.A_Percentage from attendance_details,paper_details where attendance_details.Paper_Name=paper_details.Paper_Name and paper_details.Paper_Type='ADD-ON' and attendance_details.Sid='"+cmbsid.getSelectedItem()+"' and attendance_details.Sem_no='"+cmbsem_no.getSelectedItem()+"'");
                	while(rs.next()){
                		str=rs.getString("A_Percentage");
                		f=(10*(Float.valueOf(str)/100));
                		t=Integer.valueOf(Math.round(f));
                		lstd6.add(String.valueOf(t));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
                try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select assign_details.Avge,test_details.Avg from assign_details,test_details,paper_details where assign_details.Paper_Name=paper_details.Paper_Name and paper_details.Paper_Type='COURSEWARE' and assign_details.Sid='"+cmbsid.getSelectedItem()+"' and assign_details.Sem_no='"+cmbsem_no.getSelectedItem()+"' and test_details.Paper_Name=paper_details.Paper_Name and paper_details.Paper_Type='COURSEWARE' and test_details.Sid='"+cmbsid.getSelectedItem()+"' and test_details.Sem_no='"+cmbsem_no.getSelectedItem()+"'");
                	while(rs.next()){
                		str=rs.getString("Avge");
                		str1=rs.getString("Avg");
                		f=(10*(Float.valueOf(str)/100));
                		t=Integer.valueOf(Math.round(f));
                		
                		f1=(10*(Float.valueOf(str1)/100));
                		t1=Integer.valueOf(Math.round(f1));
                		
                		lstom4.add(String.valueOf(t));
                		lstom5.add(String.valueOf(t1));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
                try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select assign_details.Avge,test_details.Avg from assign_details,test_details,paper_details where assign_details.Paper_Name=paper_details.Paper_Name and paper_details.Paper_Type='ADD-ON' and assign_details.Sid='"+cmbsid.getSelectedItem()+"' and assign_details.Sem_no='"+cmbsem_no.getSelectedItem()+"' and test_details.Paper_Name=paper_details.Paper_Name and paper_details.Paper_Type='ADD-ON' and test_details.Sid='"+cmbsid.getSelectedItem()+"' and test_details.Sem_no='"+cmbsem_no.getSelectedItem()+"'");
                	while(rs.next()){
                		str=rs.getString("Avge");
                		str1=rs.getString("Avg");
                		f=(10*(Float.valueOf(str)/100));
                		t=Integer.valueOf(Math.round(f));
                		
                		f1=(10*(Float.valueOf(str1)/100));
                		t1=Integer.valueOf(Math.round(f1));
                		
                		lstd8.add(String.valueOf(t));
                		lstd10.add(String.valueOf(t1));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
                for(int i=0;i<lstsub.getItemCount();i++){
                	lstfm3.add("10", i);
                	lstfm4.add("10", i);
                	lstfm5.add("10", i);
                }
                for(int j=0;j<lstsubd.getItemCount();j++){
                	lstd5.add("10", j);
                	lstd7.add("10", j);
                	lstd9.add("10", j);
                }
                
            }
            else if(cmbsem_no.getItemAt(4).equals("4")) {

            	try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select paper_details.Paper_Name,paper_details.PaperTh_Marks,paper_details.PaperPrac_Marks from paper_details,student_details where paper_details.Course_Code=student_details.Course_Code and paper_details.Univ_no=student_details.Univ_no and paper_details.Paper_Type='COURSEWARE' and paper_details.Sem_no='"+cmbsem_no.getSelectedItem()+"' and student_details.Sid='"+cmbsid.getSelectedItem()+"'");
                	while(rs.next()){
                		lstsub.addItem(rs.getString("Paper_Name")); 
                		lstfm1.add(rs.getString("PaperTh_Marks"));
                		lstfm2.add(rs.getString("PaperPrac_Marks"));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
                }
            	try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select paper_details.Paper_Name,paper_details.PaperTh_Marks,paper_details.PaperPrac_Marks from paper_details,student_details where paper_details.Course_Code=student_details.Course_Code and paper_details.Univ_no=student_details.Univ_no and paper_details.Paper_Type='ADD-ON' and paper_details.Sem_no='"+cmbsem_no.getSelectedItem()+"' and student_details.Sid='"+cmbsid.getSelectedItem()+"'");
                	while(rs.next()){
                		lstsubd.addItem(rs.getString("Paper_Name"));
                		lstd1.add(rs.getString("PaperTh_Marks"));
                		lstd3.add(rs.getString("PaperPrac_Marks"));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
                
                try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select attendance_details.A_Percentage from attendance_details,paper_details where attendance_details.Paper_Name=paper_details.Paper_Name and paper_details.Paper_Type='COURSEWARE' and attendance_details.Sid='"+cmbsid.getSelectedItem()+"' and attendance_details.Sem_no='"+cmbsem_no.getSelectedItem()+"'");
                	while(rs.next()){
                		str=rs.getString("A_Percentage");
                		f=(10*(Float.valueOf(str)/100));
                		t=Integer.valueOf(Math.round(f));
                		lstom3.add(String.valueOf(t));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
                try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select attendance_details.A_Percentage from attendance_details,paper_details,course_details where attendance_details.Paper_Name=paper_details.Paper_Name and paper_details.Paper_Type='ADD-ON' and attendance_details.Sid='"+cmbsid.getSelectedItem()+"' and attendance_details.Sem_no='"+cmbsem_no.getSelectedItem()+"' and attendance_details.Course_Name=course_details.Course_Name");
                	while(rs.next()){
                		str=rs.getString("A_Percentage");
                		f=(10*(Float.valueOf(str)/100));
                		t=Integer.valueOf(Math.round(f));
                		lstd6.add(String.valueOf(t));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
                try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select assign_details.Avge,test_details.Avg from assign_details,test_details,paper_details where assign_details.Paper_Name=paper_details.Paper_Name and paper_details.Paper_Type='COURSEWARE' and assign_details.Sid='"+cmbsid.getSelectedItem()+"' and assign_details.Sem_no='"+cmbsem_no.getSelectedItem()+"' and test_details.Paper_Name=paper_details.Paper_Name and paper_details.Paper_Type='COURSEWARE' and test_details.Sid='"+cmbsid.getSelectedItem()+"' and test_details.Sem_no='"+cmbsem_no.getSelectedItem()+"'");
                	while(rs.next()){
                		str=rs.getString("Avge");
                		str1=rs.getString("Avg");
                		f=(10*(Float.valueOf(str)/100));
                		t=Integer.valueOf(Math.round(f));
                		
                		f1=(10*(Float.valueOf(str1)/100));
                		t1=Integer.valueOf(Math.round(f1));
                		
                		lstom4.add(String.valueOf(t));
                		lstom5.add(String.valueOf(t1));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
                try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select assign_details.Avge,test_details.Avg from assign_details,test_details,paper_details where assign_details.Paper_Name=paper_details.Paper_Name and paper_details.Paper_Type='ADD-ON' and assign_details.Sid='"+cmbsid.getSelectedItem()+"' and assign_details.Sem_no='"+cmbsem_no.getSelectedItem()+"' and test_details.Paper_Name=paper_details.Paper_Name and paper_details.Paper_Type='ADD-ON' and test_details.Sid='"+cmbsid.getSelectedItem()+"' and test_details.Sem_no='"+cmbsem_no.getSelectedItem()+"'");
                	while(rs.next()){
                		str=rs.getString("Avge");
                		str1=rs.getString("Avg");
                		f=(10*(Float.valueOf(str)/100));
                		t=Integer.valueOf(Math.round(f));
                		
                		f1=(10*(Float.valueOf(str1)/100));
                		t1=Integer.valueOf(Math.round(f1));
                		
                		lstd8.add(String.valueOf(t));
                		lstd10.add(String.valueOf(t1));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
                for(int i=0;i<lstsub.getItemCount();i++){
                	lstfm3.add("10", i);
                	lstfm4.add("10", i);
                	lstfm5.add("10", i);
                }
                for(int j=0;j<lstsubd.getItemCount();j++){
                	lstd5.add("10", j);
                	lstd7.add("10", j);
                	lstd9.add("10", j);
                }
            }
            else if(cmbsem_no.getItemAt(5).equals("5")) {

            	try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select paper_details.Paper_Name,paper_details.PaperTh_Marks,paper_details.PaperPrac_Marks from paper_details,student_details where paper_details.Course_Code=student_details.Course_Code and paper_details.Univ_no=student_details.Univ_no and paper_details.Paper_Type='COURSEWARE' and paper_details.Sem_no='"+cmbsem_no.getSelectedItem()+"' and student_details.Sid='"+cmbsid.getSelectedItem()+"'");
                	while(rs.next()){
                		lstsub.addItem(rs.getString("Paper_Name")); 
                		lstfm1.add(rs.getString("PaperTh_Marks"));
                		lstfm2.add(rs.getString("PaperPrac_Marks"));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
                }
            	try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select paper_details.Paper_Name,paper_details.PaperTh_Marks,paper_details.PaperPrac_Marks from paper_details,student_details where paper_details.Course_Code=student_details.Course_Code and paper_details.Univ_no=student_details.Univ_no and paper_details.Paper_Type='ADD-ON' and paper_details.Sem_no='"+cmbsem_no.getSelectedItem()+"' and student_details.Sid='"+cmbsid.getSelectedItem()+"'");
                	while(rs.next()){
                		lstsubd.addItem(rs.getString("Paper_Name"));
                		lstd1.add(rs.getString("PaperTh_Marks"));
                		lstd3.add(rs.getString("PaperPrac_Marks"));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
                try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select attendance_details.A_Percentage from attendance_details,paper_details where attendance_details.Paper_Name=paper_details.Paper_Name and paper_details.Paper_Type='COURSEWARE' and attendance_details.Sid='"+cmbsid.getSelectedItem()+"' and attendance_details.Sem_no='"+cmbsem_no.getSelectedItem()+"'");
                	while(rs.next()){
                		str=rs.getString("A_Percentage");
                		f=(10*(Float.valueOf(str)/100));
                		t=Integer.valueOf(Math.round(f));
                		lstom3.add(String.valueOf(t));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
                try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select attendance_details.A_Percentage from attendance_details,paper_details where attendance_details.Paper_Name=paper_details.Paper_Name and paper_details.Paper_Type='ADD-ON' and attendance_details.Sid='"+cmbsid.getSelectedItem()+"' and attendance_details.Sem_no='"+cmbsem_no.getSelectedItem()+"'");
                	while(rs.next()){
                		str=rs.getString("A_Percentage");
                		f=(10*(Float.valueOf(str)/100));
                		t=Integer.valueOf(Math.round(f));
                		lstd6.add(String.valueOf(t));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
                try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select assign_details.Avge,test_details.Avg from assign_details,test_details,paper_details where assign_details.Paper_Name=paper_details.Paper_Name and paper_details.Paper_Type='COURSEWARE' and assign_details.Sid='"+cmbsid.getSelectedItem()+"' and assign_details.Sem_no='"+cmbsem_no.getSelectedItem()+"' and test_details.Paper_Name=paper_details.Paper_Name and paper_details.Paper_Type='COURSEWARE' and test_details.Sid='"+cmbsid.getSelectedItem()+"' and test_details.Sem_no='"+cmbsem_no.getSelectedItem()+"'");
                	while(rs.next()){
                		str=rs.getString("Avge");
                		str1=rs.getString("Avg");
                		f=(10*(Float.valueOf(str)/100));
                		t=Integer.valueOf(Math.round(f));
                		
                		f1=(10*(Float.valueOf(str1)/100));
                		t1=Integer.valueOf(Math.round(f1));
                		
                		lstom4.add(String.valueOf(t));
                		lstom5.add(String.valueOf(t1));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
                try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select assign_details.Avge,test_details.Avg from assign_details,test_details,paper_details where assign_details.Paper_Name=paper_details.Paper_Name and paper_details.Paper_Type='ADD-ON' and assign_details.Sid='"+cmbsid.getSelectedItem()+"' and assign_details.Sem_no='"+cmbsem_no.getSelectedItem()+"' and test_details.Paper_Name=paper_details.Paper_Name and paper_details.Paper_Type='ADD-ON' and test_details.Sid='"+cmbsid.getSelectedItem()+"' and test_details.Sem_no='"+cmbsem_no.getSelectedItem()+"'");
                	while(rs.next()){
                		str=rs.getString("Avge");
                		str1=rs.getString("Avg");
                		f=(10*(Float.valueOf(str)/100));
                		t=Integer.valueOf(Math.round(f));
                		
                		f1=(10*(Float.valueOf(str1)/100));
                		t1=Integer.valueOf(Math.round(f1));
                		
                		lstd8.add(String.valueOf(t));
                		lstd10.add(String.valueOf(t1));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
                for(int i=0;i<lstsub.getItemCount();i++){
                	lstfm3.add("10", i);
                	lstfm4.add("10", i);
                	lstfm5.add("10", i);
                }
                for(int j=0;j<lstsubd.getItemCount();j++){
                	lstd5.add("10", j);
                	lstd7.add("10", j);
                	lstd9.add("10", j);
                }
            }
            else if(cmbsem_no.getItemAt(6).equals("6")) {

            	try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select paper_details.Paper_Name,paper_details.PaperTh_Marks,paper_details.PaperPrac_Marks from paper_details,student_details where paper_details.Course_Code=student_details.Course_Code and paper_details.Univ_no=student_details.Univ_no and paper_details.Paper_Type='COURSEWARE' and paper_details.Sem_no='"+cmbsem_no.getSelectedItem()+"' and student_details.Sid='"+cmbsid.getSelectedItem()+"'");
                	while(rs.next()){
                		lstsub.addItem(rs.getString("Paper_Name")); 
                		lstfm1.add(rs.getString("PaperTh_Marks"));
                		lstfm2.add(rs.getString("PaperPrac_Marks"));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
                }
            	try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select paper_details.Paper_Name,paper_details.PaperTh_Marks,paper_details.PaperPrac_Marks from paper_details,student_details where paper_details.Course_Code=student_details.Course_Code and paper_details.Univ_no=student_details.Univ_no and paper_details.Paper_Type='ADD-ON' and paper_details.Sem_no='"+cmbsem_no.getSelectedItem()+"' and student_details.Sid='"+cmbsid.getSelectedItem()+"'");
                	while(rs.next()){
                		lstsubd.addItem(rs.getString("Paper_Name"));
                		lstd1.add(rs.getString("PaperTh_Marks"));
                		lstd3.add(rs.getString("PaperPrac_Marks"));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
                
                try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select attendance_details.A_Percentage from attendance_details,paper_details where attendance_details.Paper_Name=paper_details.Paper_Name and paper_details.Paper_Type='COURSEWARE' and attendance_details.Sid='"+cmbsid.getSelectedItem()+"' and attendance_details.Sem_no='"+cmbsem_no.getSelectedItem()+"'");
                	while(rs.next()){
                		str=rs.getString("A_Percentage");
                		f=(10*(Float.valueOf(str)/100));
                		t=Integer.valueOf(Math.round(f));
                		lstom3.add(String.valueOf(t));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
                try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select attendance_details.A_Percentage from attendance_details,paper_details where attendance_details.Paper_Name=paper_details.Paper_Name and paper_details.Paper_Type='ADD-ON' and attendance_details.Sid='"+cmbsid.getSelectedItem()+"' and attendance_details.Sem_no='"+cmbsem_no.getSelectedItem()+"'");
                	while(rs.next()){
                		str=rs.getString("A_Percentage");
                		f=(10*(Float.valueOf(str)/100));
                		t=Integer.valueOf(Math.round(f));
                		lstd6.add(String.valueOf(t));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
                try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select assign_details.Avge,test_details.Avg from assign_details,test_details,paper_details where assign_details.Paper_Name=paper_details.Paper_Name and paper_details.Paper_Type='COURSEWARE' and assign_details.Sid='"+cmbsid.getSelectedItem()+"' and assign_details.Sem_no='"+cmbsem_no.getSelectedItem()+"' and test_details.Paper_Name=paper_details.Paper_Name and paper_details.Paper_Type='COURSEWARE' and test_details.Sid='"+cmbsid.getSelectedItem()+"' and test_details.Sem_no='"+cmbsem_no.getSelectedItem()+"'");
                	while(rs.next()){
                		str=rs.getString("Avge");
                		str1=rs.getString("Avg");
                		f=(10*(Float.valueOf(str)/100));
                		t=Integer.valueOf(Math.round(f));
                		
                		f1=(10*(Float.valueOf(str1)/100));
                		t1=Integer.valueOf(Math.round(f1));
                		
                		lstom4.add(String.valueOf(t));
                		lstom5.add(String.valueOf(t1));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
                try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select assign_details.Avge,test_details.Avg from assign_details,test_details,paper_details where assign_details.Paper_Name=paper_details.Paper_Name and paper_details.Paper_Type='ADD-ON' and assign_details.Sid='"+cmbsid.getSelectedItem()+"' and assign_details.Sem_no='"+cmbsem_no.getSelectedItem()+"' and test_details.Paper_Name=paper_details.Paper_Name and paper_details.Paper_Type='ADD-ON' and test_details.Sid='"+cmbsid.getSelectedItem()+"' and test_details.Sem_no='"+cmbsem_no.getSelectedItem()+"'");
                	while(rs.next()){
                		str=rs.getString("Avge");
                		str1=rs.getString("Avg");
                		f=(10*(Float.valueOf(str)/100));
                		t=Integer.valueOf(Math.round(f));
                		
                		f1=(10*(Float.valueOf(str1)/100));
                		t1=Integer.valueOf(Math.round(f1));
                		
                		lstd8.add(String.valueOf(t));
                		lstd10.add(String.valueOf(t1));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
                for(int i=0;i<lstsub.getItemCount();i++){
                	lstfm3.add("10", i);
                	lstfm4.add("10", i);
                	lstfm5.add("10", i);
                }
                for(int j=0;j<lstsubd.getItemCount();j++){
                	lstd5.add("10", j);
                	lstd7.add("10", j);
                	lstd9.add("10", j);
                }
            }
        }
    }
    public void addcomp(int x, int y, int w, int h, Component com) {
        com.setBounds(x, y, w, h);
        panel.add(com);
        if (com instanceof JLabel) {
            ((JLabel)com).setForeground(Color.black);
        }
        if (com instanceof JComboBox) {
            ((JComboBox)com).setForeground(Color.black);
        }
        if (com instanceof JCheckBox)
        {
            ((JCheckBox)com).setForeground(Color.black);
        }
        if (com instanceof JTextField)
        {
            ((JTextField)com).setFont(new Font("Arial", Font.BOLD,12));
        }
        /*if (com instanceof JTextArea)
        {
            ((JTextArea)com).setFont(new Font("Arial", Font.BOLD,12));
        }*/
        if(com instanceof List){
        	((List)com).setFont(new Font("Castellar",Font.ROMAN_BASELINE,15));
        }
    }


    public void actionPerformed(ActionEvent ae){
       
        if (ae.getSource() == btnreset) {
        	cmbsid.setSelectedIndex(0);
        	if(chkdo.isSelected()==true){
        		chkdo.setSelected(false);
        	}
            txtname.setText("");
            txtcourse_name.setText("");
            txtbatch_name.setText("");
            txtuniv_name.setText("");
            cmbsem_no.setSelectedIndex(0);
            lstsub.removeAll();
            //lstteacher.removeAll();
            txt1.setText("");
            txt2.setText("");
            txt3.setText("");
            txt4.setText("");
            txt5.setText("");
            txt6.setText("");
            txt7.setText("");
            txt8.setText("");
            txt9.setText("");
            txt10.setText("");
            
            txtd1.setText("");
            txtd2.setText("");
            txtd3.setText("");
            txtd4.setText("");
            txtd5.setText("");
            txtd6.setText("");
            txtd7.setText("");
            txtd8.setText("");
            txtd9.setText("");
            txtd10.setText("");
            lstfm1.removeAll();
            lstom1.removeAll();
            lstfm2.removeAll();
            lstom2.removeAll();
            lstfm3.removeAll();
            lstom3.removeAll();
            lstfm4.removeAll();
            lstom4.removeAll();
            lstfm5.removeAll();
            lstom5.removeAll();
            lstavg.removeAll();
            txtr.setText("");
            txtp.setText("");
            txtgt.setText("");
            lstsubd.removeAll();
            lstd1.removeAll();
            lstd2.removeAll();
            lstd3.removeAll();
            lstd4.removeAll();
            lstd5.removeAll();
            lstd6.removeAll();
            lstd7.removeAll();
            lstd8.removeAll();
            lstd9.removeAll();
            lstd10.removeAll();
            lstd11.removeAll();
        }
        if (ae.getSource() == btnexit) {
            dispose();
        }
        if(ae.getSource()==btnfind){
        	//lstfm1.removeAll();
        	lstom1.removeAll();
        	//lstfm2.removeAll();
        	lstom2.removeAll();
        	//lstfm3.removeAll();
        	lstom3.removeAll();
        	//lstfm4.removeAll();
        	lstom4.removeAll();
        	//lstfm5.removeAll();
        	lstom5.removeAll();
        	lstavg.removeAll();
        	//lstd1.removeAll();
        	lstd2.removeAll();
        	//lstd3.removeAll();
        	lstd4.removeAll();
        	//lstd5.removeAll();
        	lstd6.removeAll();
        	//lstd7.removeAll();
        	lstd8.removeAll();
        	//lstd9.removeAll();
        	lstd10.removeAll();
        	lstd11.removeAll();
        	txtgt.setText("");
        	txtp.setText("");
        	txtr.setText("");
        	/*try{
        		stmt=cn.createStatement();
        		rs=stmt.executeQuery("select attendance_details.Sid,attendance_details.Student_Name,attendance_details.Course_Name,attendance_details.roll,attendance_details.Batch_Name,attendance_details.Sem_no from attendance_details where Sid='"+cmbsid.getSelectedItem()+"' and Sem_no='"+cmbsem_no.getSelectedItem()+"'");
        		cmbsid.setSelectedItem(rs.getString("Sid"));
        		txtname.setText(rs.getString("Student_Name"));
        		txtcourse_name.setText(rs.getString("Course_Name"));
        		txtroll.setText(rs.getString("roll"));
        		txtbatch_name.setText(rs.getString("Batch_Name"));
        		cmbsem_no.setSelectedItem(rs.getString("Sem_no"));
        	}catch(Exception ex){
        		JOptionPane.showMessageDialog(this,ex.toString());
        	}*/
        	for(int i=0;i<lstsub.getItemCount();i++){
        	try{
        		stmt=cn.createStatement();
        		rs=stmt.executeQuery("select * from course_exam_details where Sid='"+cmbsid.getSelectedItem()+"'  and Sem_no='"+cmbsem_no.getSelectedItem()+"' and Paper_Name1='"+lstsub.getItem(i)+"'");
        		while(rs.next()){
        			lstom1.add(rs.getString("E_om1"));
        			lstom2.add(rs.getString("E_om2"));
        			lstom3.add(rs.getString("E_om3"));
        			lstom4.add(rs.getString("E_om4"));
        			lstom5.add(rs.getString("E_om5"));
        			lstavg.add(rs.getString("E_Total1"));
        		}
        		        		
        	}catch(Exception ex){
        		JOptionPane.showMessageDialog(this,ex.toString());
        	}
        	}
        	for(int i=0;i<lstsubd.getItemCount();i++){
        	try{
        		stmt=cn.createStatement();
        		rs=stmt.executeQuery("select * from addon_exam_details where Sid='"+cmbsid.getSelectedItem()+"'  and Sem_no='"+cmbsem_no.getSelectedItem()+"' and Paper_Name2='"+lstsubd.getItem(i)+"'");
        		while(rs.next()){
        			lstd2.add(rs.getString("E_om6"));
        			lstd4.add(rs.getString("E_om7"));
        			lstd6.add(rs.getString("E_om8"));
        			lstd8.add(rs.getString("E_om9"));
        			lstd10.add(rs.getString("E_om10"));
        			lstd11.add(rs.getString("E_Total2"));
        		}
        		        		
        	}catch(Exception ex){
        		JOptionPane.showMessageDialog(this,ex.toString());
        	}
        	}
        	
        	try{
        		stmt=cn.createStatement();
        		rs=stmt.executeQuery("select result_details.Grand_Total,result_details.Percentage_Marks,result_details.Exam_Remark from result_details where Sid='"+cmbsid.getSelectedItem()+"' and Sem_no='"+cmbsem_no.getSelectedItem()+"' and Course_Name='"+txtcourse_name.getText()+"' and Batch_Name='"+txtbatch_name.getText()+"' and Univ_Name='"+txtuniv_name.getText()+"'");
        		if(rs.next()){
        			txtgt.setText(rs.getString("Grand_Total"));
        			txtp.setText(rs.getString("Percentage_Marks"));
        			txtr.setText(rs.getString("Exam_Remark"));
        		}
        	}catch(Exception ex){
        		JOptionPane.showMessageDialog(this,ex.toString());
        	
    }
        }
        if (ae.getSource() == btnsave) {
        	ImageIcon iconic=new ImageIcon("images/stat_sys_warning.png");
			int  x=  JOptionPane.showConfirmDialog(this,"Are You Sure With Your Filled Information?","User Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,iconic);
			if(x==0){
				if(cmbsid.getSelectedIndex()!=0){
				if(chkdo.isSelected()==true){
				if(cmbsem_no.getSelectedIndex()!=0){
				if(lstfm1.getItemCount()!=0&&lstfm1.getItemCount()==lstsub.getItemCount()){
				if(lstom1.getItemCount()!=0&&lstom1.getItemCount()==lstfm1.getItemCount()){
				if(lstfm2.getItemCount()!=0&&lstfm2.getItemCount()==lstsub.getItemCount()){
				if(lstom2.getItemCount()!=0&&lstom2.getItemCount()==lstfm2.getItemCount()){
				if(lstfm3.getItemCount()!=0&&lstfm3.getItemCount()==lstsub.getItemCount()){
				if(lstom3.getItemCount()!=0&&lstom3.getItemCount()==lstfm3.getItemCount()){
				if(lstfm4.getItemCount()!=0&&lstfm4.getItemCount()==lstsub.getItemCount()){
	   			if(lstom4.getItemCount()!=0&&lstom4.getItemCount()==lstfm4.getItemCount()){
	   			if(lstfm5.getItemCount()!=0&&lstfm5.getItemCount()==lstsub.getItemCount()){
	    		if(lstom5.getItemCount()!=0&&lstom5.getItemCount()==lstfm5.getItemCount()){
				if(lstavg.getItemCount()!=0){
   				if(lstd1.getItemCount()!=0&&lstd1.getItemCount()==lstsubd.getItemCount()){
   				if(lstd2.getItemCount()!=0&&lstd2.getItemCount()==lstd1.getItemCount()){
   			    if(lstd3.getItemCount()!=0&&lstd3.getItemCount()==lstsubd.getItemCount()){
   		   		if(lstd4.getItemCount()!=0&&lstd4.getItemCount()==lstd3.getItemCount()){
   		   		if(lstd5.getItemCount()!=0&&lstd5.getItemCount()==lstsubd.getItemCount()){
   		    	if(lstd6.getItemCount()!=0&&lstd6.getItemCount()==lstd5.getItemCount()){
   		    	if(lstd7.getItemCount()!=0&&lstd7.getItemCount()==lstsubd.getItemCount()){
   		    	if(lstd8.getItemCount()!=0&&lstd8.getItemCount()==lstd7.getItemCount()){
				if(lstd9.getItemCount()!=0&&lstd9.getItemCount()==lstsubd.getItemCount()){
				if(lstd10.getItemCount()!=0&&lstd10.getItemCount()==lstd9.getItemCount()){
				if(lstd11.getItemCount()!=0){
   		    		  for(int i=0;i<lstsub.getItemCount();i++){
            sql ="insert into course_exam_details(Sid,Sem_no,Paper_Name1,E_om1,E_om2,E_om3,E_om4,E_om5,E_Total1) values('" + cmbsid.getSelectedItem() +"','"+cmbsem_no.getSelectedItem()+"','"+lstsub.getItem(i)+"','"+lstom1.getItem(i)+"','"+lstom2.getItem(i)+"','"+lstom3.getItem(i)+"','"+lstom4.getItem(i)+"','"+lstom5.getItem(i)+"','"+lstavg.getItem(i)+"')";
            try {
                stmt = cn.createStatement();
                stmt.executeUpdate(sql);
            } catch (SQLException sqex) {
                JOptionPane.showMessageDialog(this, sqex.getMessage().toString(), "Error in SQL Insertion",
                                              JOptionPane.ERROR_MESSAGE);
            }
        }
  		sql="insert into result_details values('"+cmbsid.getSelectedItem()+"','"+cmbsem_no.getSelectedItem()+"','"+txtcourse_name.getText()+"','"+txtbatch_name.getText()+"','"+txtuniv_name.getText()+"','"+txtgt.getText()+"','"+txtp.getText()+"','"+txtr.getText()+"')";
        	try{
        		stmt=cn.createStatement();
        		stmt.executeUpdate(sql);
        	}catch (SQLException sqex) {
                JOptionPane.showMessageDialog(this, sqex.getMessage().toString(), "Error in SQL Insertion",
                        JOptionPane.ERROR_MESSAGE);
        	}	
        
        for(int j=0;j<lstsubd.getItemCount();j++){
        	sql="insert into addon_exam_details(Sid,Sem_no,Paper_Name2,E_om6,E_om7,E_om8,E_om9,E_om10,E_Total2)values('"+cmbsid.getSelectedItem()+"','"+cmbsem_no.getSelectedItem()+"','"+lstsubd.getItem(j)+"','"+lstd2.getItem(j)+"','"+lstd4.getItem(j)+"','"+lstd6.getItem(j)+"','"+lstd8.getItem(j)+"','"+lstd10.getItem(j)+"','"+lstd11.getItem(j)+"')";
        try{
        	stmt=cn.createStatement();
    		stmt.executeUpdate(sql);
        }catch (SQLException sqex) {
            JOptionPane.showMessageDialog(this, sqex.getMessage().toString(), "Error in SQL Insertion",
                    JOptionPane.ERROR_MESSAGE);
    		}
        
        }
        	JOptionPane.showMessageDialog(this, "Exam Details Stored");
            /*this.dispose();
            new Assign_Details();*/
        	int t=JOptionPane.showConfirmDialog(this, "Do You Want To Enter More Values?");
            if(t==0){
          	  reset();
            }
            else if(t==1){
          	  this.dispose();
          	  new Discipline_Details(); 
            }
            
			}else{
				JOptionPane.showMessageDialog(this,"Please Calculate Total Marks");
					but2.grabFocus();
				}
			}else{
				JOptionPane.showMessageDialog(this,"Please Insert Respective Obtained Marks");
					txtd10.grabFocus();
					}
			}else{
				JOptionPane.showMessageDialog(this,"Please Insert Respective Full Marks");
				txtd9.grabFocus();
			}
			}else{
				JOptionPane.showMessageDialog(this,"Please Insert Respective Obtained Marks");
					txtd8.grabFocus();
				}
			}else{
				JOptionPane.showMessageDialog(this,"Please Insert Respective Full Marks");
					txtd7.grabFocus();
				}
			}else{
				JOptionPane.showMessageDialog(this,"Please Insert Respective Obtained Marks");
					txtd6.grabFocus();
				}
			}else{
				JOptionPane.showMessageDialog(this,"Please Insert Respective Full Marks");
				txtd5.grabFocus();
			}
			}else{
				JOptionPane.showMessageDialog(this,"Please Insert Respective Obtained Marks");
					txtd4.grabFocus();
				}
			}else{
				JOptionPane.showMessageDialog(this,"Please Insert Respective Full Marks");
						txtd3.grabFocus();
				}
			}else{
				JOptionPane.showMessageDialog(this,"Please Insert Respective Obtained Marks");
						txtd2.grabFocus();
				}
			}else{
				JOptionPane.showMessageDialog(this,"Please Insert Respective Full Marks");
						txtd1.grabFocus();
				}
			}else{
				JOptionPane.showMessageDialog(this,"Please Calculate Total Marks");
					but1.grabFocus();
			}
					}else{
						JOptionPane.showMessageDialog(this,"Please Insert Respective Obtained Marks");
				txt10.grabFocus();
				}
			}else{
				JOptionPane.showMessageDialog(this,"Please Insert Respective Full Marks");
				txt9.grabFocus();
			}
			}else{
				JOptionPane.showMessageDialog(this,"Please Insert Respective Obtained Marks");
				txt8.grabFocus();
				}
			}else{
				JOptionPane.showMessageDialog(this,"Please Insert Respective Full Marks");
					txt7.grabFocus();
				}
			}else{
				JOptionPane.showMessageDialog(this,"Please Insert Respective Obtained Marks");
			txt6.grabFocus();
			}
			}else{
				JOptionPane.showMessageDialog(this,"Please Insert Respective Full Marks");
				txt5.grabFocus();
			}
			}else{
				JOptionPane.showMessageDialog(this,"Please Insert Respective Obtained Marks");
						txt4.grabFocus();
					}
			}else{
				JOptionPane.showMessageDialog(this,"Please Insert Respective Full Marks");
						txt3.grabFocus();
				}
			}else{
				JOptionPane.showMessageDialog(this,"Please Insert Respective Obtained Marks");
						txt2.grabFocus();
				}
			}else{
				JOptionPane.showMessageDialog(this,"Please Insert Respective Full Marks");
										txt1.grabFocus();
									}		
			}else{
			 JOptionPane.showMessageDialog(this,"Please Select Semester Number");
					 cmbsem_no.grabFocus();
				 }
			 }else{
				 JOptionPane.showMessageDialog(this, "Please Check The Checkbox For Getting Details");
				 }
			 }else{
				 JOptionPane.showMessageDialog(this, "Please Select Student's ID");
				 cmbsid.grabFocus();
			 }
               
		}else{}
     }
       if(ae.getSource()==btnpre){
    	   this.dispose();
    	   new Assign_Details();
       }
       if(ae.getSource()==btnnext){
    	   this.dispose();
    	   new Discipline_Details();
       }
       if(ae.getSource()==but2){
    	   lstd11.removeAll();
    	   int s;
    	   if(lstd1.getItemCount()!=0&&lstd2.getItemCount()!=0&&lstd3.getItemCount()!=0&&lstd4.getItemCount()!=0&&lstd5.getItemCount()!=0&&lstd6.getItemCount()!=0&&lstd7.getItemCount()!=0&&lstd8.getItemCount()!=0&&lstd9.getItemCount()!=0&&lstd10.getItemCount()!=0){
        	   if(lstd1.getItemCount()==lstsubd.getItemCount()&&lstd3.getItemCount()==lstsubd.getItemCount()&&lstd5.getItemCount()==lstsubd.getItemCount()&&lstd7.getItemCount()==lstsubd.getItemCount()&&lstd9.getItemCount()==lstsubd.getItemCount()&&lstd1.getItemCount()==lstd2.getItemCount()&&lstd3.getItemCount()==lstd4.getItemCount()&&lstd5.getItemCount()==lstd6.getItemCount()&&lstd7.getItemCount()==lstd8.getItemCount()&&lstd9.getItemCount()==lstd10.getItemCount()){
    	   for(int i=0;i<lstsubd.getItemCount();i++){
    		   if(Integer.valueOf(lstd1.getItem(i))>=Integer.valueOf(lstd2.getItem(i))&& Integer.valueOf(lstd3.getItem(i))>=Integer.valueOf(lstd4.getItem(i))&& Integer.valueOf(lstd5.getItem(i))>=Integer.valueOf(lstd6.getItem(i))&&Integer.valueOf(lstd7.getItem(i))>=Integer.valueOf(lstd8.getItem(i))&&Integer.valueOf(lstd9.getItem(i))>=Integer.valueOf(lstd10.getItem(i))){
    			 s=Integer.valueOf(lstd2.getItem(i))+Integer.valueOf(lstd4.getItem(i))+Integer.valueOf(lstd6.getItem(i))+Integer.valueOf(lstd8.getItem(i))+Integer.valueOf(lstd10.getItem(i));
    			 lstd11.add(String.valueOf(s),i);
    		   }else{
    			   JOptionPane.showMessageDialog(this,"Error In Insertion Of Obtained Marks");
    			   lstd2.removeAll();
    			   lstd4.removeAll();
    			   lstd6.removeAll();
    			   lstd8.removeAll();
    			   lstd10.removeAll();
    			   lstd11.removeAll();
    		   }
    	   }
        	   }else{
        		   JOptionPane.showMessageDialog(this,"Error In Insertion Of Marks"); 
        	   }
        	   }else{
        		   JOptionPane.showMessageDialog(this,"One Of Your Marks List Is Empty,Please Check Appropriately");
        	   }
       }
       if(ae.getSource()==but1){
    	   lstavg.removeAll();
    	   txtr.setText("");
    	   txtp.setText("");
    	   txtgt.setText("");
    	   int s,k=0;
    	   float j;
    	   if(lstfm1.getItemCount()!=0&&lstfm2.getItemCount()!=0&&lstfm3.getItemCount()!=0&&lstfm4.getItemCount()!=0&&lstfm5.getItemCount()!=0&&lstom1.getItemCount()!=0&&lstom2.getItemCount()!=0&&lstom3.getItemCount()!=0&&lstom4.getItemCount()!=0&&lstom5.getItemCount()!=0){
        	   if(lstfm1.getItemCount()==lstsub.getItemCount()&&lstfm2.getItemCount()==lstsub.getItemCount()&&lstfm3.getItemCount()==lstsub.getItemCount()&&lstfm4.getItemCount()==lstsub.getItemCount()&&lstfm5.getItemCount()==lstsub.getItemCount()&&lstfm1.getItemCount()==lstom1.getItemCount()&&lstfm2.getItemCount()==lstom2.getItemCount()&&lstfm3.getItemCount()==lstom3.getItemCount()&&lstfm4.getItemCount()==lstom4.getItemCount()&&lstfm5.getItemCount()==lstom5.getItemCount()){
    	   /*for(int i=0;i<lstfm1.getItemCount();i++){
    		   if(Integer.valueOf(lstfm1.getItem(i))>=Integer.valueOf(lstom1.getItem(i))&& Integer.valueOf(lstfm2.getItem(i))>=Integer.valueOf(lstom2.getItem(i))&& Integer.valueOf(lstfm3.getItem(i))>=Integer.valueOf(lstom3.getItem(i))){   		 
    			   j=Math.round(100*(Float.valueOf(lstom1.getItem(i))+Float.valueOf(lstom2.getItem(i))+Float.valueOf(lstom3.getItem(i)))/(Float.valueOf(lstfm1.getItem(i))+Float.valueOf(lstfm2.getItem(i))+Float.valueOf(lstfm3.getItem(i))));
    		   lstavg.add(String.valueOf(j), i);
    		   }
    		   else{
    			   JOptionPane.showMessageDialog(this,"Error In Insertion Of Obtained Marks");
    			   lstom1.removeAll();
    			   lstom2.removeAll();
    			   lstom3.removeAll();
    		   }
    	   }*/
    	   for(int i=0;i<lstsub.getItemCount();i++){
    		   if(Integer.valueOf(lstfm1.getItem(i))>=Integer.valueOf(lstom1.getItem(i))&& Integer.valueOf(lstfm2.getItem(i))>=Integer.valueOf(lstom2.getItem(i))&& Integer.valueOf(lstfm3.getItem(i))>=Integer.valueOf(lstom3.getItem(i))&&Integer.valueOf(lstfm4.getItem(i))>=Integer.valueOf(lstom4.getItem(i))&&Integer.valueOf(lstfm5.getItem(i))>=Integer.valueOf(lstom5.getItem(i))){
    			 s=Integer.valueOf(lstom1.getItem(i))+Integer.valueOf(lstom2.getItem(i))+Integer.valueOf(lstom3.getItem(i))+Integer.valueOf(lstom4.getItem(i))+Integer.valueOf(lstom5.getItem(i));
    			 lstavg.add(String.valueOf(s),i);
    			 k=k+Integer.valueOf(lstavg.getItem(i));
    			 txtgt.setText(String.valueOf(k));
    		   }else{
    			   JOptionPane.showMessageDialog(this,"Error In Insertion Of Obtained Marks");
    			   lstom1.removeAll();
    			   lstom2.removeAll();
    			   lstom3.removeAll();
    			   lstom4.removeAll();
    			   lstom5.removeAll();
    			   lstavg.removeAll();
    			   txtgt.setText("");
    			   txtp.setText("");
    			   txtr.setText("");
    		   }
    	   }
    	   j=Math.round(Float.valueOf(txtgt.getText())/ lstsub.getItemCount());
    	   txtp.setText(String.valueOf(j));
    	   if(j<40.00){
    		   txtr.setText("FAIL");
    	   }
    	   else
    		   txtr.setText("PASS");
        	   }else{
        		   JOptionPane.showMessageDialog(this,"Error In Insertion Of Marks"); 
        	   }
        	   }else{
        		   JOptionPane.showMessageDialog(this,"One Of Your Marks List Is Empty,Please Check Appropriately");
        	   }
       }      
    }
    public void reset(){
    	cmbsid.setSelectedIndex(0);
    	if(chkdo.isSelected()==true){
    		chkdo.setSelected(false);
    	}
        txtname.setText("");
        txtcourse_name.setText("");
        txtbatch_name.setText("");
        txtuniv_name.setText("");
        cmbsem_no.setSelectedIndex(0);
        lstsub.removeAll();
        //lstteacher.removeAll();
        txt1.setText("");
        txt2.setText("");
        txt3.setText("");
        txt4.setText("");
        txt5.setText("");
        txt6.setText("");
        txt7.setText("");
        txt8.setText("");
        txt9.setText("");
        txt10.setText("");
        
        txtd1.setText("");
        txtd2.setText("");
        txtd3.setText("");
        txtd4.setText("");
        txtd5.setText("");
        txtd6.setText("");
        txtd7.setText("");
        txtd8.setText("");
        txtd9.setText("");
        txtd10.setText("");
        lstfm1.removeAll();
        lstom1.removeAll();
        lstfm2.removeAll();
        lstom2.removeAll();
        lstfm3.removeAll();
        lstom3.removeAll();
        lstfm4.removeAll();
        lstom4.removeAll();
        lstfm5.removeAll();
        lstom5.removeAll();
        lstavg.removeAll();
        txtr.setText("");
        txtp.setText("");
        txtgt.setText("");
        lstsubd.removeAll();
        lstd1.removeAll();
        lstd2.removeAll();
        lstd3.removeAll();
        lstd4.removeAll();
        lstd5.removeAll();
        lstd6.removeAll();
        lstd7.removeAll();
        lstd8.removeAll();
        lstd9.removeAll();
        lstd10.removeAll();
        lstd11.removeAll();
    }
    public static void main(String[] args) {
        new Exam_Details();
    }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getSource()==txt1){
			if(e.getKeyCode()==e.VK_ENTER){
				if(txt1.getText().trim().length()!=0){
					if(lstfm1.getItemCount()!=lstsub.getItemCount()){
						if(txt1.getText().trim().length()<=2){
							lstfm1.add(txt1.getText());
							txt1.setText("");
						}else{
							JOptionPane.showMessageDialog(this,"Please Enter Valid Theory Full Marks");
							txt1.setText("");
							txt1.grabFocus();
						}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Enter More Value(s)");
						txt1.setText("");
					}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Fill Whitespace As Full Marks");
						txt1.grabFocus();
					}
			}
		}
		if(e.getSource()==txt2){
			if(e.getKeyCode()==e.VK_ENTER){
				if(txt2.getText().trim().length()!=0){
					if(lstom1.getItemCount()!=lstfm1.getItemCount()){
						if(txt2.getText().trim().length()<=2){
							lstom1.add(txt2.getText());
							txt2.setText("");
						}else{
							JOptionPane.showMessageDialog(this,"Please Enter Valid Theory Obtained Marks");
							txt2.setText("");
							txt2.grabFocus();
						}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Enter More Value(s)");
						txt2.setText("");
					}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Fill Whitespace As Obtained Marks");
						txt2.grabFocus();
					}
			}
		}
		if(e.getSource()==txt3){
			if(e.getKeyCode()==e.VK_ENTER){
				if(txt3.getText().trim().length()!=0){
					if(lstfm2.getItemCount()!=lstsub.getItemCount()){
						if(txt3.getText().trim().length()<=2){
							lstfm2.add(txt3.getText());
							txt3.setText("");
						}else{
							JOptionPane.showMessageDialog(this,"Please Enter Valid Practical Full Marks");
							txt3.setText("");
							txt3.grabFocus();
						}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Enter More Value(s)");
						txt3.setText("");
					}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Fill Whitespace As Full Marks");
						txt3.grabFocus();
					}
			}
		}
		if(e.getSource()==txt4){
			if(e.getKeyCode()==e.VK_ENTER){
				if(txt4.getText().trim().length()!=0){
					if(lstom2.getItemCount()!=lstfm2.getItemCount()){
						if(txt4.getText().trim().length()<=2){
							lstom2.add(txt4.getText());
							txt4.setText("");
						}else{
							JOptionPane.showMessageDialog(this,"Please Enter Valid Practical Obtained Marks");
							txt4.setText("");
							txt4.grabFocus();
						}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Enter More Value(s)");
						txt4.setText("");
					}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Fill Whitespace As Obtained Marks");
						txt4.grabFocus();
					}
			}
		}
		if(e.getSource()==txt5){
			if(e.getKeyCode()==e.VK_ENTER){
				if(txt5.getText().trim().length()!=0){
					if(lstfm3.getItemCount()!=lstsub.getItemCount()){
						if(txt5.getText().trim().equals("10")){
							lstfm3.add(txt5.getText());
							txt5.setText("");
						}else{
							JOptionPane.showMessageDialog(this,"You Should Only Enter 10 Marks As Attendance Full Marks");
							txt5.setText("");
							txt5.grabFocus();
						}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Enter More Value(s)");
						txt5.setText("");
					}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Fill Whitespace As Full Marks");
						txt5.grabFocus();
					}
			}
		}
		if(e.getSource()==txt6){
			if(e.getKeyCode()==e.VK_ENTER){
				if(txt6.getText().trim().length()!=0){
					if(lstom3.getItemCount()!=lstfm3.getItemCount()){
						if(Integer.parseInt(txt6.getText().trim())>=0&&Integer.parseInt(txt6.getText().trim())<=10){
							lstom3.add(txt6.getText());
							txt6.setText("");
						}else{
							JOptionPane.showMessageDialog(this,"Please Enter Valid Attendance Obtained Marks");
							txt6.setText("");
							txt6.grabFocus();
						}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Enter More Value(s)");
						txt6.setText("");
					}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Fill Whitespace As Obtained Marks");
						txt6.grabFocus();
					}
			}
		}
		if(e.getSource()==txt7){
			if(e.getKeyCode()==e.VK_ENTER){
				if(txt7.getText().trim().length()!=0){
					if(lstfm4.getItemCount()!=lstsub.getItemCount()){
						if(txt7.getText().trim().equals("10")){
							lstfm4.add(txt7.getText());
							txt7.setText("");
						}else{
							JOptionPane.showMessageDialog(this,"You Should Only Enter 10 Marks As Assignment Full Marks");
							txt7.setText("");
							txt7.grabFocus();
						}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Enter More Value(s)");
						txt7.setText("");
					}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Fill Whitespace As Full Marks");
						txt7.grabFocus();
					}
			}
		}
		if(e.getSource()==txt8){
			if(e.getKeyCode()==e.VK_ENTER){
				if(txt8.getText().trim().length()!=0){
					if(lstom4.getItemCount()!=lstfm4.getItemCount()){
						if(Integer.parseInt(txt8.getText().trim())>=0&&Integer.parseInt(txt8.getText().trim())<=10){
							lstom4.add(txt8.getText());
							txt8.setText("");
						}else{
							JOptionPane.showMessageDialog(this,"Please Enter Valid Assignment Obtained Marks");
							txt8.setText("");
							txt8.grabFocus();
						}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Enter More Value(s)");
						txt8.setText("");
					}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Fill Whitespace As Obtained Marks");
						txt8.grabFocus();
					}
			}
		}
		if(e.getSource()==txt9){
			if(e.getKeyCode()==e.VK_ENTER){
				if(txt9.getText().trim().length()!=0){
					if(lstfm5.getItemCount()!=lstsub.getItemCount()){
						if(txt9.getText().trim().equals("10")){
							lstfm5.add(txt9.getText());
							txt9.setText("");
						}else{
							JOptionPane.showMessageDialog(this,"You Should Only Enter 10 Marks As Unit Test Full Marks");
							txt9.setText("");
							txt9.grabFocus();
						}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Enter More Value(s)");
						txt9.setText("");
					}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Fill Whitespace As Full Marks");
						txt9.grabFocus();
					}
			}
		}
		if(e.getSource()==txt10){
			if(e.getKeyCode()==e.VK_ENTER){
				if(txt10.getText().trim().length()!=0){
					if(lstom5.getItemCount()!=lstfm5.getItemCount()){
						if(Integer.parseInt(txt10.getText().trim())>=0&&Integer.parseInt(txt10.getText().trim())<=10){
							lstom5.add(txt10.getText());
							txt10.setText("");
						}else{
							JOptionPane.showMessageDialog(this,"Please Enter Valid Unit Test Obtained Marks");
							txt10.setText("");
							txt10.grabFocus();
						}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Enter More Value(s)");
						txt10.setText("");
					}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Fill Whitespace As Obtained Marks");
						txt10.grabFocus();
					}
			}
		}
		if(e.getSource()==txtd1){
			if(e.getKeyCode()==e.VK_ENTER){
				if(txtd1.getText().trim().length()!=0){
					if(lstd1.getItemCount()!=lstsubd.getItemCount()){
						if(txtd1.getText().trim().length()<=2){
							lstd1.add(txtd1.getText());
							txtd1.setText("");
						}else{
							JOptionPane.showMessageDialog(this,"Please Enter Valid Theory Full Marks");
							txtd1.setText("");
							txtd1.grabFocus();
						}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Enter More Value(s)");
						txtd1.setText("");
					}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Fill Whitespace As Full Marks");
						txtd1.grabFocus();
					}
			}
		}
		if(e.getSource()==txtd2){
			if(e.getKeyCode()==e.VK_ENTER){
				if(txtd2.getText().trim().length()!=0){
					if(lstd2.getItemCount()!=lstd1.getItemCount()){
						if(txtd2.getText().trim().length()<=2){
							lstd2.add(txtd2.getText());
							txtd2.setText("");
						}else{
							JOptionPane.showMessageDialog(this,"Please Enter Valid Theory Obtained Marks");
							txtd2.setText("");
							txtd2.grabFocus();
						}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Enter More Value(s)");
						txtd2.setText("");
					}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Fill Whitespace As Obtained Marks");
						txtd2.grabFocus();
					}
			}
		}
		if(e.getSource()==txtd3){
			if(e.getKeyCode()==e.VK_ENTER){
				if(txtd3.getText().trim().length()!=0){
					if(lstd3.getItemCount()!=lstsubd.getItemCount()){
						if(txtd3.getText().trim().length()<=2){
							lstd3.add(txtd3.getText());
							txtd3.setText("");
						}else{
							JOptionPane.showMessageDialog(this,"Please Enter Valid Practical Full Marks");
							txtd3.setText("");
							txtd3.grabFocus();
						}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Enter More Value(s)");
						txtd3.setText("");
					}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Fill Whitespace As Full Marks");
						txtd3.grabFocus();
					}
			}
		}
		if(e.getSource()==txtd4){
			if(e.getKeyCode()==e.VK_ENTER){
				if(txtd4.getText().trim().length()!=0){
					if(lstd4.getItemCount()!=lstd3.getItemCount()){
						if(txtd4.getText().trim().length()<=2){
							lstd4.add(txtd4.getText());
							txtd4.setText("");
						}else{
							JOptionPane.showMessageDialog(this,"Please Enter Valid Practical Obtained Marks");
							txtd4.setText("");
							txtd4.grabFocus();
						}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Enter More Value(s)");
						txtd4.setText("");
					}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Fill Whitespace As Obtained Marks");
						txtd4.grabFocus();
					}
			}
		}
		if(e.getSource()==txtd5){
			if(e.getKeyCode()==e.VK_ENTER){
				if(txtd5.getText().trim().length()!=0){
					if(lstd5.getItemCount()!=lstsubd.getItemCount()){
						if(txtd5.getText().trim().equals("10")){
							lstd5.add(txtd5.getText());
							txtd5.setText("");
						}else{
							JOptionPane.showMessageDialog(this,"You Should Only Enter 10 Marks As Attendance Full Marks");
							txtd5.setText("");
							txtd5.grabFocus();
						}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Enter More Value(s)");
						txtd5.setText("");
					}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Fill Whitespace As Full Marks");
						txtd5.grabFocus();
					}
			}
		}
		if(e.getSource()==txtd6){
			if(e.getKeyCode()==e.VK_ENTER){
				if(txtd6.getText().trim().length()!=0){
					if(lstd6.getItemCount()!=lstd5.getItemCount()){
						if(Integer.parseInt(txtd6.getText().trim())>=0&&Integer.parseInt(txtd6.getText().trim())<=10){
							lstd6.add(txtd6.getText());
							txtd6.setText("");
						}else{
							JOptionPane.showMessageDialog(this,"Please Enter Valid Attendance Obtained Marks");
							txtd6.setText("");
							txtd6.grabFocus();
						}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Enter More Value(s)");
						txtd6.setText("");
					}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Fill Whitespace As Obtained Marks");
						txtd6.grabFocus();
					}
			}
		}
		if(e.getSource()==txtd7){
			if(e.getKeyCode()==e.VK_ENTER){
				if(txtd7.getText().trim().length()!=0){
					if(lstd7.getItemCount()!=lstsubd.getItemCount()){
						if(txtd7.getText().trim().equals("10")){
							lstd7.add(txtd7.getText());
							txtd7.setText("");
						}else{
							JOptionPane.showMessageDialog(this,"You Should Only Enter 10 Marks As Assignment Full Marks");
							txtd7.setText("");
							txtd7.grabFocus();
						}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Enter More Value(s)");
						txtd7.setText("");
					}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Fill Whitespace As Full Marks");
						txtd7.grabFocus();
					}
			}
		}
		if(e.getSource()==txtd8){
			if(e.getKeyCode()==e.VK_ENTER){
				if(txtd8.getText().trim().length()!=0){
					if(lstd8.getItemCount()!=lstd7.getItemCount()){
						if(Integer.parseInt(txtd8.getText().trim())>=0&&Integer.parseInt(txtd8.getText().trim())<=10){
							lstd8.add(txtd8.getText());
							txtd8.setText("");
						}else{
							JOptionPane.showMessageDialog(this,"Please Enter Valid Assignment Obtained Marks");
							txtd8.setText("");
							txtd8.grabFocus();
						}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Enter More Value(s)");
						txtd8.setText("");
					}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Fill Whitespace As Obtained Marks");
						txtd8.grabFocus();
					}
			}
		}
		if(e.getSource()==txtd9){
			if(e.getKeyCode()==e.VK_ENTER){
				if(txtd9.getText().trim().length()!=0){
					if(lstd9.getItemCount()!=lstsubd.getItemCount()){
						if(txtd9.getText().trim().equals("10")){
							lstd9.add(txtd9.getText());
							txtd9.setText("");
						}else{
							JOptionPane.showMessageDialog(this,"You Should Only Enter 10 Marks As Unit Test Full Marks");
							txtd9.setText("");
							txtd9.grabFocus();
						}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Enter More Value(s)");
						txtd9.setText("");
					}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Fill Whitespace As Full Marks");
						txtd9.grabFocus();
					}
			}
		}
		if(e.getSource()==txtd10){
			if(e.getKeyCode()==e.VK_ENTER){
				if(txtd10.getText().trim().length()!=0){
					if(lstd10.getItemCount()!=lstd9.getItemCount()){
						if(Integer.parseInt(txtd10.getText().trim())>=0&&Integer.parseInt(txtd10.getText().trim())<=10){
							lstd10.add(txtd10.getText());
							txtd10.setText("");
						}else{
							JOptionPane.showMessageDialog(this,"Please Enter Valid Unit Test Obtained Marks");
							txtd10.setText("");
							txtd10.grabFocus();
						}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Enter More Value(s)");
						txtd10.setText("");
					}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Fill Whitespace As Obtained Marks");
						txtd10.grabFocus();
					}
			}
		}
	}
}
