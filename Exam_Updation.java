import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Exam_Updation extends JFrame implements ActionListener,ItemListener {
    Connection cn,cn1;
    Statement stmt,stmt1;
    ResultSet rs,rs1;
    String sql = "";
    JTextField txtname,txtcourse_name,txtbatch_name,txtroll,txtuniv_name;
    JTextField txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10,txtgt,txtp,txtr,txtd1,txtd2,txtd3,txtd4,txtd5,txtd6,txtd7,txtd8,txtd9,txtd10;
    JButton btnexit,btndelete,btnfind,but1,but2,btnupdate;
    JLabel lblhead,lblstudent_name,lblid, lblline,lblcourse_name,lblbatch_name,lbl1,lbl2,lbl3,lbl4,lbldown,lbld1,lbld2;
    JCheckBox chkdo;
    JComboBox cmbsid,cmbsem_no;
    JPanel panel;
    Container c;
    ImageIcon img;
    List lstsub,lstteacher,lstfm1,lstfm2,lstom2,lstom1,lstfm3,lstom3,lstavg,lstfm4,lstom4,lstfm5,lstom5,lstsubd,lstd1,lstd2,lstd3,lstd4,lstd5,lstd6,lstd7,lstd8,lstd9,lstd10,lstd11;
    public Exam_Updation() {
        img = new ImageIcon("images/back_3.jpg", null);
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
        lblhead = new JLabel("MODIFY INTERNAL EXAMS DETAILS");
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
                txt1.setEnabled(false);
                txt2=new JTextField();
                txt3=new JTextField();
                txt3.setEnabled(false);
                txt4=new JTextField();
                txt5=new JTextField();
                txt5.setEnabled(false);
                txt6=new JTextField();
                txt6.setEnabled(false);
                txt7=new JTextField();
                txt7.setEnabled(false);
                txt8=new JTextField();
                txt8.setEnabled(false);
                txt9=new JTextField();
                txt9.setEnabled(false);
                txt10=new JTextField();
                txt10.setEnabled(false);
                txtd1=new JTextField();
                txtd1.setEnabled(false);
                txtd2=new JTextField();
                txtd3=new JTextField();
                txtd3.setEnabled(false);
                txtd4=new JTextField();
                txtd5=new JTextField();
                txtd5.setEnabled(false);
                txtd6=new JTextField();
                txtd6.setEnabled(false);
                txtd7=new JTextField();
                txtd7.setEnabled(false);
                txtd8=new JTextField();
                txtd8.setEnabled(false);
                txtd9=new JTextField();
                txtd9.setEnabled(false);
                txtd10=new JTextField();
                txtd10.setEnabled(false);
                
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
		    
		        btnexit = new JButton("Exit", new ImageIcon("images/KREST.png"));
		        btnexit.addActionListener(this);
		        btndelete=new JButton("Delete",new ImageIcon("images/001_49.png"));
		        btndelete.addActionListener(this);
		        btnfind=new JButton("Find",new ImageIcon("images/search.png"));
		        btnfind.addActionListener(this);
		        but1=new JButton("Cal.",new ImageIcon("images/CMS-calc1.png"));
		        but1.addActionListener(this);
		        but2=new JButton("Cal.",new ImageIcon("images/CMS-calc1.png"));
		        but2.addActionListener(this);
		        btnupdate = new JButton("Update", new ImageIcon("images/info1.png"));
		        btnupdate.addActionListener(this);
		        addcomp(220, 0, 520, 50, lblhead);
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
		        
		        addcomp(567,260,75,20,new JLabel("O.M *"));
		        addcomp(550,290,60,30,txt2);
		        
		        addcomp(615,239,1,189,new JLabel(new ImageIcon("images/line.jpg")));
		        
		        addcomp(625,240,130,20,new JLabel("PRAC./VIVA/PROJECT"));
		        addcomp(637,260,75,20,new JLabel("F.M"));
		        addcomp(620,290,60,30,txt3);
		        
		        addcomp(685,258,1,170,new JLabel(new ImageIcon("images/line.jpg")));
		        
		        addcomp(707,260,75,20,new JLabel("O.M *"));
		        addcomp(690,290,60,30,txt4);
		        
		        addcomp(755,239,1,189,new JLabel(new ImageIcon("images/line.jpg")));
		        
		        addcomp(787,240,100,20,new JLabel("ATTENDANCE"));
		        addcomp(777,260,85,20,new JLabel("F.M"));
		        addcomp(760,290,60,30,txt5);
		        
		        addcomp(787,440,120,20,new JLabel("PERCENTAGE"));
		        addcomp(900,435,60,30,txtp);
		        
		        addcomp(825,258,1,170,new JLabel(new ImageIcon("images/line.jpg")));
		        
		        addcomp(847,260,75,20,new JLabel("O.M **"));
		        addcomp(830,290,60,30,txt6);
		        
		        addcomp(895,239,1,189,new JLabel(new ImageIcon("images/line.jpg")));
		        
		        addcomp(927,240,100,20,new JLabel("ASSIGNMENT"));
		        addcomp(917,260,85,20,new JLabel("F.M"));
		        addcomp(900,290,60,30,txt7);
		        addcomp(965,258,1,170,new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(987,260,85,20,new JLabel("O.M **"));
		        addcomp(970,290,60,30,txt8);
		        addcomp(1035,239,1,189,new JLabel(new ImageIcon("images/line.jpg")));
		        
		        addcomp(1067,240,100,20,new JLabel("UNIT TEST"));
		        addcomp(1057,260,85,20,new JLabel("F.M"));		        
		        addcomp(1040,290,60,30,txt9);
		        addcomp(1127,260,85,20,new JLabel("O.M **"));
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
		        addcomp(566,534,85,20,new JLabel("O.M *"));
		        addcomp(549,556,60,30,txtd2);
		        addcomp(549,590,60,60,lstd2);
		        addcomp(614, 514, 1, 140, new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(624,514,125,20,new JLabel("PRAC./VIVA/PROJECT"));
		        addcomp(636,534,85,20,new JLabel("F.M"));
		        addcomp(619,556,60,30,txtd3);
		        addcomp(619,590,60,60,lstd3);
		        addcomp(684, 534, 1, 120, new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(706,534,85,20,new JLabel("O.M *"));
		        addcomp(689,556,60,30,txtd4);
		        addcomp(689,590,60,60,lstd4);
		        addcomp(754, 514, 1, 140, new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(786,514,125,20,new JLabel("ATTENDANCE"));
		        addcomp(776,534,85,20,new JLabel("F.M"));
		        addcomp(759,556,60,30,txtd5);
		        addcomp(759,590,60,60,lstd5);
		        addcomp(824, 534, 1, 120, new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(846,534,85,20,new JLabel("O.M **"));
		        addcomp(829,556,60,30,txtd6);
		        addcomp(829,590,60,60,lstd6);
		        addcomp(894, 514, 1, 140, new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(926,514,125,20,new JLabel("ASSIGNMENT"));
		        addcomp(916,534,85,20,new JLabel("F.M"));
		        addcomp(899,556,60,30,txtd7);
		        addcomp(899,590,60,60,lstd7);
		        addcomp(964, 534, 1, 120, new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(986,534,85,20,new JLabel("O.M **"));
		        addcomp(969,556,60,30,txtd8);
		        addcomp(969,590,60,60,lstd8);
		        addcomp(1034, 514, 1, 140, new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(1066,514,125,20,new JLabel("UNIT TEST"));
		        addcomp(1056,534,85,20,new JLabel("F.M"));
		        addcomp(1039,556,60,30,txtd9);
		        addcomp(1039,590,60,60,lstd9);
		        addcomp(1104, 534, 1, 120, new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(1126,534,85,20,new JLabel("O.M **"));
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
		        /*addcomp(775, 665, 90, 30, btnreset);
		        addcomp(875, 665, 90, 30, btnsave);*/
		        addcomp(220,655,350,20,new JLabel("Note 1:- * You Can Only Modify These Fields."));
		        addcomp(220,675,400,20,new JLabel("          2:- ** These Fields Will Be Automatically Modified Or Updated."));
		        addcomp(945, 665, 100, 30, btndelete);
		        addcomp(1055, 665, 100, 30, btnupdate);
		        addcomp(1165, 665 ,100, 30, btnexit);
		        addcomp(00, 00, 204,702, new JLabel(new ImageIcon("images/exam_updation.jpg")));
		       

        setBounds(0, 0, 1367, 730);
        setTitle("Exam Details Updation Form");
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
            		}else
                	  JOptionPane.showMessageDialog(this,"Record Not Found,Please Insert Values");
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
        	lstd2.removeAll();
        	lstd3.removeAll();
        	lstd4.removeAll();
        	lstom1.removeAll();
        	lstom2.removeAll();
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
        	lstavg.removeAll();
        	lstd11.removeAll();
        	txtgt.setText("");
        	txtr.setText("");
        	txtp.setText("");
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
        if (ae.getSource() == btnexit) {
            dispose();
        }
        if(ae.getSource()==btnfind){
        	//lstfm1.removeAll();
        	lstom1.removeAll();
        	//lstfm2.removeAll();
        	lstom2.removeAll();
        	//lstfm3.removeAll();
        	//lstom3.removeAll();
        	//lstfm4.removeAll();
        	//lstom4.removeAll();
        	//lstfm5.removeAll();
        	//lstom5.removeAll();
        	lstavg.removeAll();
        	//lstd1.removeAll();
        	lstd2.removeAll();
        	//lstd3.removeAll();
        	lstd4.removeAll();
        	//lstd5.removeAll();
        	//lstd6.removeAll();
        	//lstd7.removeAll();
        	//lstd8.removeAll();
        	//lstd9.removeAll();
        	//lstd10.removeAll();
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
        		rs=stmt.executeQuery("select * from course_exam_details where Sid='"+cmbsid.getSelectedItem()+"' and Sem_no='"+cmbsem_no.getSelectedItem()+"' and Paper_Name1='"+lstsub.getItem(i)+"'");
        		while(rs.next()){
        			lstom1.add(rs.getString("E_om1"));
        			lstom2.add(rs.getString("E_om2"));
        			/*lstom3.add(rs.getString("E_om3"));
        			lstom4.add(rs.getString("E_om4"));
        			lstom5.add(rs.getString("E_om5"));*/
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
        			/*lstd6.add(rs.getString("E_om8"));
        			lstd8.add(rs.getString("E_om9"));
        			lstd10.add(rs.getString("E_om10"));*/
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
       if(ae.getSource()==btndelete){
    	   
    	   lstavg.removeAll();
    	   txtgt.setText("");
    	   txtp.setText("");
    	   txtr.setText("");
    	   lstd11.removeAll();
    	   ImageIcon iconic=new ImageIcon("images/stat_sys_warning.png");
			 int  x=  JOptionPane.showConfirmDialog(this,"Do you really want to replace the selected item(s) with the item(s) in the textfield(s)?","User Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,iconic);
			 if(x==0){
    	   for(int a=0;a<lstsub.getItemCount();a++){
    		   if(lstom1.isIndexSelected(a)){
    			   int i=lstom1.getSelectedIndex();
    			   if(txt2.getText().trim().length()!=0){
    				   if(txt2.getText().trim().length()<=2){
    					   lstom1.delItem(i);
    					   lstom1.addItem(txt2.getText(),i);
    					   txt2.setText("");
    				   }else{
    					   JOptionPane.showMessageDialog(this,"Please Enter Valid Obtained Marks As Theory Marks");
    					   txt2.setText("");
    					   txt2.grabFocus();
    				   }
    			   }else{
    				   JOptionPane.showMessageDialog(this,"Please Insert New Obtained Marks For Theory in Corresponding Textfield");
    				   txt2.grabFocus();
    			   }
    		   }
    		   if(lstom2.isIndexSelected(a)){
    			   int j=lstom2.getSelectedIndex();
    			   if(txt4.getText().trim().length()!=0){
    				   if(txt4.getText().trim().length()<=2){
		    			   lstom2.delItem(j);
		    			   lstom2.addItem(txt4.getText(),j);
		    			   txt4.setText("");
    				   }else{
    					   JOptionPane.showMessageDialog(this,"Please Enter Valid Obtained Marks As Practical Marks");
    					   txt4.setText("");
    					   txt4.grabFocus();
    				   }
    			   }else{
    				   JOptionPane.showMessageDialog(this,"Please Insert New Obtained Marks For Practical in Corresponding Textfield");
    				   txt4.grabFocus();
    			   }
    		   }
    	   }
    	   for(int b=0;b<lstsubd.getItemCount();b++){
    		   
    		   if(lstd2.isIndexSelected(b)){
    			   int i=lstd2.getSelectedIndex();
    			   if(txtd2.getText().trim().length()!=0){
    				   if(txtd2.getText().trim().length()<=2){
		    			   lstd2.delItem(i);
		    			   lstd2.addItem(txtd2.getText(),i);
		    			   txtd2.setText("");
    				   }else{
    					   JOptionPane.showMessageDialog(this,"Please Enter Valid Obtained Marks As Theory Marks");
    					   txtd2.setText("");
    					   txtd2.grabFocus();
    				   }
    			   }else{
    				   JOptionPane.showMessageDialog(this,"Please Insert New Obtained Marks For Theory in Corresponding Textfield");
    				   txtd2.grabFocus();
    			   }
    		   }
    		   if(lstd4.isIndexSelected(b)){
    			   int j=lstd4.getSelectedIndex();
    			   if(txtd4.getText().trim().length()!=0){
    				   if(txtd4.getText().trim().length()<=2){
		    			   lstd4.delItem(j);
		    			   lstd4.addItem(txtd4.getText(),j);
		    			   txtd4.setText("");
    				   }else{
    					   JOptionPane.showMessageDialog(this,"Please Enter Valid Obtained Marks As Practical Marks");
    					   txtd4.setText("");
    					   txtd4.grabFocus();
    				   }
    			   }else{
    				   JOptionPane.showMessageDialog(this,"Please Insert New Obtained Marks For Practical in Corresponding Textfield");
    				   txtd4.grabFocus();
    			   }
    		   }
    		   
    	   }
			 }else{
				 txt2.setText("");
				 txt4.setText("");
				 txtd2.setText("");
				 txtd4.setText("");
			 }   
       }
       if(ae.getSource()==btnupdate){
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
        	   try{
        		   stmt=cn.createStatement();
        		   stmt.executeUpdate("update course_exam_details set E_om1='"+lstom1.getItem(i)+"',E_om2='"+lstom2.getItem(i)+"',E_om3='"+lstom3.getItem(i)+"',E_om4='"+lstom4.getItem(i)+"',E_om5='"+lstom5.getItem(i)+"',E_Total1='"+lstavg.getItem(i)+"' where Sid='"+cmbsid.getSelectedItem()+"' and Sem_no='"+cmbsem_no.getSelectedItem()+"' and Paper_Name1='"+lstsub.getItem(i)+"'");
        		   
        	   }catch(Exception ex){
                   JOptionPane.showMessageDialog(this,ex.toString());
        	   } 
        	  }
    	   
    	   for(int i=0;i<lstsubd.getItemCount();i++){
        	   try{
        		   stmt=cn.createStatement();
        		   stmt.executeUpdate("update addon_exam_details set E_om6='"+lstd2.getItem(i)+"',E_om7='"+lstd4.getItem(i)+"',E_om8='"+lstd6.getItem(i)+"',E_om9='"+lstd8.getItem(i)+"',E_om10='"+lstd10.getItem(i)+"',E_Total2='"+lstd11.getItem(i)+"' where Sid='"+cmbsid.getSelectedItem()+"' and Sem_no='"+cmbsem_no.getSelectedItem()+"' and Paper_Name2='"+lstsubd.getItem(i)+"'");
        		   
        	   }catch(Exception ex){
                   JOptionPane.showMessageDialog(this,ex.toString());
        	   } 
        	  }
    	   
        	   try{
        		   stmt=cn.createStatement();
        		   stmt.executeUpdate("update result_details set Grand_Total='"+txtgt.getText()+"',Percentage_Marks='"+txtp.getText()+"',Exam_Remark='"+txtr.getText()+"' where Sid='"+cmbsid.getSelectedItem()+"' and Sem_no='"+cmbsem_no.getSelectedItem()+"' and Course_Name='"+txtcourse_name.getText()+"' and Batch_Name='"+txtbatch_name.getText()+"' and Univ_Name='"+txtuniv_name.getText()+"'");
        		   
        	   }catch(Exception ex){
                   JOptionPane.showMessageDialog(this,ex.toString());
        	   } 

        	   JOptionPane.showMessageDialog(this, "Data Updated Successfully");
        	   ImageIcon iconic=new ImageIcon("images/stat_sys_warning.png");
    			int  x=  JOptionPane.showConfirmDialog(this,"Do you want to update more record?","User Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,iconic);
    			if(x==0){
    				reset();
    			}
    			else{
    				dispose();
                 }
			}else{
				JOptionPane.showMessageDialog(this,"Please Calculate Total Marks Of Add-On Subject(s)");
					but2.grabFocus();
				}
			}else{
				JOptionPane.showMessageDialog(this,"Please Check The List For Obtained Marks Of Unit Test");
					txtd10.grabFocus();
					}
			}else{
				JOptionPane.showMessageDialog(this,"Please Check The List For Full Marks Of Unit Test");
				txtd9.grabFocus();
			}
			}else{
				JOptionPane.showMessageDialog(this,"Please Check The List For Obtained Marks Of Assignment");
					txtd8.grabFocus();
				}
			}else{
				JOptionPane.showMessageDialog(this,"Please Check The List For Full Marks Of Assignment");
					txtd7.grabFocus();
				}
			}else{
				JOptionPane.showMessageDialog(this,"Please Check The List For Obtained Marks Of Attendance");
					txtd6.grabFocus();
				}
			}else{
				JOptionPane.showMessageDialog(this,"Please Check The List For Full Marks Of Attendance");
				txtd5.grabFocus();
			}
			}else{
				JOptionPane.showMessageDialog(this,"Please Check The List For Obtained Marks In Practical Of Add-On Subject(s)");
					txtd4.grabFocus();
				}
			}else{
				JOptionPane.showMessageDialog(this,"Please Check The List For Full Marks In Practical Of Add-On Subject(s)");
						txtd3.grabFocus();
				}
			}else{
				JOptionPane.showMessageDialog(this,"Please Check The List For Obtained Marks In Theory Of Add-On Subject(s)");
						txtd2.grabFocus();
				}
			}else{
				JOptionPane.showMessageDialog(this,"Please Check The List For Full Marks In Theory Of Add-On Subject(s)");
						txtd1.grabFocus();
				}
			}else{
				JOptionPane.showMessageDialog(this,"Please Calculate Total Marks For Course Subject(s)");
					but1.grabFocus();
			}
					}else{
						JOptionPane.showMessageDialog(this,"Please Check The List For Obtained Marks Of Unit Test");
				txt10.grabFocus();
				}
			}else{
				JOptionPane.showMessageDialog(this,"Please Check The List For Full Marks Of Unit Test");
				txt9.grabFocus();
			}
			}else{
				JOptionPane.showMessageDialog(this,"Please Check The List For Obtained Marks Of Assignment");
				txt8.grabFocus();
				}
			}else{
				JOptionPane.showMessageDialog(this,"Please Check The List For Full Marks Of Assignment");
					txt7.grabFocus();
				}
			}else{
				JOptionPane.showMessageDialog(this,"Please Check The List For Obtained Marks Of Attendance");
			txt6.grabFocus();
			}
			}else{
				JOptionPane.showMessageDialog(this,"Please Check The List For Full Marks Of Attendance");
				txt5.grabFocus();
			}
			}else{
				JOptionPane.showMessageDialog(this,"Please Check The List For Obtained Marks In Practical Of Course Subject(s)");
						txt4.grabFocus();
					}
			}else{
				JOptionPane.showMessageDialog(this,"Please Check The List For Full Marks In Practical Of Course Subject(s)");
						txt3.grabFocus();
				}
			}else{
				JOptionPane.showMessageDialog(this,"Please Check The List For Obtained Marks In Theory Of Course Subject(s)");
						txt2.grabFocus();
				}
			}else{
				JOptionPane.showMessageDialog(this,"Please Check The List For Full Marks In Theory Of Course Subject(s)");
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
    	   if(lstfm1.getItemCount()!=0&&lstfm2.getItemCount()!=0&&lstfm3.getItemCount()!=0&&lstfm4.getItemCount()!=0&&lstfm5.getItemCount()!=0&&lstom1.getItemCount()!=0&&lstom2.getItemCount()!=0&&lstom3.getItemCount()!=0&&lstom4.getItemCount()!=0&&lstom5.getItemCount()!=0){
        	   if(lstfm1.getItemCount()==lstsub.getItemCount()&&lstfm2.getItemCount()==lstsub.getItemCount()&&lstfm3.getItemCount()==lstsub.getItemCount()&&lstfm4.getItemCount()==lstsub.getItemCount()&&lstfm5.getItemCount()==lstsub.getItemCount()&&lstfm1.getItemCount()==lstom1.getItemCount()&&lstfm2.getItemCount()==lstom2.getItemCount()&&lstfm3.getItemCount()==lstom3.getItemCount()&&lstfm4.getItemCount()==lstom4.getItemCount()&&lstfm5.getItemCount()==lstom5.getItemCount()){
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
        new Exam_Updation();
    }
}
