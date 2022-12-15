import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Attendance_Updation extends JFrame implements ActionListener,ItemListener {
    Connection cn;
    Statement stmt;
    ResultSet rs;
    String sql = "";
    JTextField txtname,txtcourse_name,txtbatch_name,txtroll;
    JTextField txt1,txt2,txt3;
    JButton btnexit,btndelete,btnfind,but1,but2,but3,btnupdate;
    JLabel lblhead,lblstudent_name,lblid, lblline,lblcourse_name,lblbatch_name,lbl1,lbl2,lbl3,lbl4;
    JCheckBox chkdo;
    JComboBox cmbsid;
    JComboBox cmbsem_no;
    JPanel panel;
    Container c;
    ImageIcon img;
    List lstsub,lstteacher,lsttotal,lstpresent,lstabsent,lstmandet,lstpercent,lstfine;
    public Attendance_Updation() {
        img = new ImageIcon("images/back_3.jpg", null);
        panel = new JPanel() {
                protected void paintComponent(Graphics g) {
                    g.drawImage(img.getImage(), 0, 0, 1350, 640, null);
                    super.paintComponent(g);
                }
            };
        panel.setOpaque(false);
        panel.setPreferredSize(new Dimension(1350, 640));
        c = getContentPane();
        panel.setLayout(null);
        c.add(panel);
        lblhead = new JLabel("MODIFY ATTENDANCE DETAILS");
        lblhead.setFont(new Font("COPPERPLATE GOTHIC LIGHT", Font.CENTER_BASELINE, 23));
                
                lblline = new JLabel("____________________________________________________________________________________________________________________________________________");
                lblid = new JLabel("ID No.");
                lblstudent_name = new JLabel("Student's Name");
                lblcourse_name=new JLabel("Course Name");
                lblbatch_name=new JLabel("Batch Name");
                lbl1=new JLabel("Paper's");
                lbl3=new JLabel("Name");
                lbl1.setFont(new Font("COPPERPLATE GOTHIC LIGHT", Font.CENTER_BASELINE, 15));
                lbl3.setFont(new Font("COPPERPLATE GOTHIC LIGHT", Font.CENTER_BASELINE, 15));
                lbl2=new JLabel("Teacher's");
                lbl4=new JLabel("Name");
                lbl2.setFont(new Font("COPPERPLATE GOTHIC LIGHT", Font.CENTER_BASELINE, 15));
                lbl4.setFont(new Font("COPPERPLATE GOTHIC LIGHT", Font.CENTER_BASELINE, 15));
                chkdo = new JCheckBox("Check it for getting Student Details");
                chkdo.setOpaque(false);
                cmbsid =new JComboBox();
                cmbsid.addItem("--Select--");
                btnfind=new JButton();
                txtname=new JTextField();
                txtcourse_name=new JTextField();
                txtbatch_name=new JTextField();
                txtroll=new JTextField();
                cmbsem_no=new JComboBox();
                cmbsem_no.addItem("--Select--");
                cmbsem_no.addItem("1");
                cmbsem_no.addItem("2");
                cmbsem_no.addItem("3");
                cmbsem_no.addItem("4");
                cmbsem_no.addItem("5");
                cmbsem_no.addItem("6");
                txtname= new JTextField();
                lstsub=new List();
                lstteacher=new List();
                lsttotal=new List();
                lstpresent=new List();
                lstabsent=new List();
                lstmandet=new List();
                lstfine=new List();
                lstpercent=new List();
                txt1=new JTextField();
                txt1.setEnabled(false);
                txt2=new JTextField();
                txt2.setEnabled(false);
                txt3=new JTextField();

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
		        btnupdate = new JButton("Update", new ImageIcon("images/info1.png"));
		        btnupdate.addActionListener(this);
		        but1=new JButton("Cal.",new ImageIcon("images/CMS-calc1.png"));
		        but1.addActionListener(this);
		        but2=new JButton("Cal.",new ImageIcon("images/CMS-calc1.png"));
		        but2.addActionListener(this);
		        but3=new JButton("Cal.",new ImageIcon("images/CMS-calc1.png"));
		        but3.addActionListener(this);

		        addcomp(220, 0, 450, 50, lblhead);
		        addcomp(1025, 10, 250, 65, new JLabel(new ImageIcon("images/cim_lbl1_1.jpg")));
		        addcomp(220, 90, 70, 30, lblid);
		        addcomp(350, 90, 100, 30, cmbsid);
		        addcomp(460, 90, 250, 30, chkdo);chkdo.addItemListener(this);
		        addcomp(220, 120, 1200, 25, lblline);
		        addcomp(220, 160, 100, 30, lblstudent_name);
		        addcomp(350, 160, 200, 30, txtname);
		        addcomp(725,160,100,30,new JLabel("Class Roll no"));addcomp(855,160,100,30,txtroll);
		        addcomp(220, 210, 100, 30, lblcourse_name);
		        addcomp(350, 210, 200, 30, txtcourse_name);
		        addcomp(725, 210, 100, 30, lblbatch_name);
		        addcomp(855, 210, 200, 30, txtbatch_name);
		        addcomp(220, 280, 1200, 15, new JLabel("___________________________________________________________________________________________________________________________________________"));
		        addcomp(300,303,100,30,lbl1);
		        addcomp(310,333,100,30,lbl3);
		        addcomp(530,303,100,30,lbl2);
		        addcomp(550,333,100,30,lbl4);
		        
		        addcomp(710,295,75,20,new JLabel("Total"));
		        addcomp(709,315,75,20,new JLabel("Class"));
		        addcomp(690,345,75,30,txt1);
		        
		        addcomp(795,295,75,20,new JLabel("Class"));
		        addcomp(785,315,75,20,new JLabel("Mandetory"));
		        addcomp(775,345,75,30,txt2);
		        
		        addcomp(880,295,75,20,new JLabel("Class"));
		        addcomp(870,315,75,20,new JLabel("Attended *"));
		        addcomp(860,345,75,30,txt3);
		        
		        addcomp(965,295,75,20,new JLabel("Class"));
		        addcomp(955,315,75,20,new JLabel("Absented"));
		        addcomp(945,345,75,30,but1);
		        
		        addcomp(1035,295,75,20,new JLabel("Attendence"));
		        addcomp(1030,315,85,20,new JLabel("Percentage(%)"));
		        addcomp(1030,345,75,30,but2);
		        
		        addcomp(1135,295,75,20,new JLabel("Total"));
		        addcomp(1140,315,75,20,new JLabel("Fine"));
		        addcomp(1115,345,75,30,but3);
		        addcomp(220,363,1200,15,new JLabel("___________________________________________________________________________________________________________________________________________"));
		        addcomp(725,90,100,30,new JLabel("Semester no."));
		        addcomp(855,90,100,30,cmbsem_no);
		        addcomp(960,90,90,30,btnfind);
		        cmbsem_no.addItemListener(this);
		        addcomp(684, 325, 516, 15, new JLabel("_________________________________________________________________________")); 
		        addcomp(220, 294, 1, 239, new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(225,380,245,150,lstsub);
		        addcomp(474, 294, 1, 239, new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(480,380,200,150,lstteacher);
		        addcomp(684, 294, 1, 239, new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(690,380,75,150,lsttotal);
		        addcomp(769, 339, 1, 194, new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(860,380,75,150,lstpresent);
		        addcomp(854, 339, 1, 194, new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(945,380,75,150,lstabsent);
		        addcomp(939, 294, 1, 239, new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(775,380,75,150,lstmandet);
		        addcomp(1024, 339, 1, 194, new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(1030,380,75,150,lstpercent);
		        addcomp(1109, 339, 1, 194, new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(1115,380,75,150,lstfine);
		        addcomp(1193, 294, 1, 239, new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(220, 520, 1200, 15, new JLabel("___________________________________________________________________________________________________________________________________________"));
		        addcomp(220,540,250,20,new JLabel("Note:- * You Can Only Modify This Field."));
		        addcomp(220, 555, 1200, 15, new JLabel("___________________________________________________________________________________________________________________________________________"));
		        
		        addcomp(220,570,250,20,new JLabel("Steps For Modifying Attended Classes:-"));
		        addcomp(220,590,350,20,new JLabel("Step 1: Select Particular Value In Attended Class List."));
		        addcomp(220,605,350,20,new JLabel("Step 2: Insert The New Value In Corresponding TextField."));
		        addcomp(220,620,500,20,new JLabel("Step 3: Click On Delete Button To Replace The Value In The List With The New One."));
		        addcomp(880, 590, 100, 30, btndelete);
		        addcomp(990, 590, 100, 30, btnupdate);
		        addcomp(1100, 590, 100, 30, btnexit);
		        addcomp(00, 00, 200, 640, new JLabel(new ImageIcon("images/atten4.jpg")));
		       

        setBounds(0, 0, 1317, 670);
        setTitle("Attendance Details Updation Form");
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
            		rs=stmt.executeQuery("select student_details.Student_Name,student_details.roll,course_details.Course_Name,batch_details.Batch_Name from student_details,course_details,batch_details where Sid='"+cmbsid.getSelectedItem()+"' and course_details.Course_Code=student_details.Course_Code and batch_details.Batch_Code=student_details.Batch_Code");
            		if(rs.next()){            			
            			txtname.setText(rs.getString("Student_Name"));
            			txtroll.setText(rs.getString("roll"));        			
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
    			txtroll.setText("");
    			txtcourse_name.setText("");
    			txtbatch_name.setText("");
    		}
    	}
        if(ie.getSource()==cmbsem_no) {
        	lstsub.removeAll();
        	lstteacher.removeAll();
        	lsttotal.removeAll();
        	lstmandet.removeAll();
        	lstpresent.removeAll();
        	lstabsent.removeAll();
        	lstpercent.removeAll();
        	lstfine.removeAll();
        	String str="";
        	float f;
        	int t;
            if(cmbsem_no.getItemAt(1).equals("1")) {
            	lstsub.removeAll();
            	lstteacher.removeAll();
            	lsttotal.removeAll();
            	lstmandet.removeAll();
                try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select paper_details.Paper_Name,teacher_details.Teacher_Name,paper_assign_details.Class_Conducted from paper_details,course_details,teacher_details,paper_assign_details,batch_details where paper_details.Paper_Code=paper_assign_details.Paper_Code and paper_details.Course_Code=course_details.Course_Code and course_details.Course_Name='"+txtcourse_name.getText()+"' and teacher_details.Teacher_ID=paper_assign_details.Teacher_ID and paper_details.Sem_no='"+cmbsem_no.getSelectedItem()+"' and batch_details.Batch_Code=paper_assign_details.Batch_Code and batch_details.Batch_Name='"+txtbatch_name.getText()+"'");
                	while(rs.next()){
                		lstsub.addItem(rs.getString("Paper_Name"));               		
                		lstteacher.addItem(rs.getString("Teacher_Name"));  
                		lsttotal.add(rs.getString("Class_Conducted"));
                		str=rs.getString("Class_Conducted");
                		f=Math.round(0.75*(Float.valueOf(str)));
                		t=Integer.valueOf(Math.round(f));
                		lstmandet.add(String.valueOf(t));
                		
                	}
                	
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
            }
            else if(cmbsem_no.getItemAt(2).equals("2")) {
            	lstsub.removeAll();
            	lstteacher.removeAll();
            	lsttotal.removeAll();
            	lstmandet.removeAll();
                try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select paper_details.Paper_Name,teacher_details.Teacher_Name,paper_assign_details.Class_Conducted from paper_details,course_details,teacher_details,paper_assign_details,batch_details where paper_details.Paper_Code=paper_assign_details.Paper_Code and paper_details.Course_Code=course_details.Course_Code and course_details.Course_Name='"+txtcourse_name.getText()+"' and teacher_details.Teacher_ID=paper_assign_details.Teacher_ID and paper_details.Sem_no='"+cmbsem_no.getSelectedItem()+"' and batch_details.Batch_Code=paper_assign_details.Batch_Code and batch_details.Batch_Name='"+txtbatch_name.getText()+"'");                	            	
                	while(rs.next()){
                		lstsub.addItem(rs.getString("Paper_Name"));                		
                		lstteacher.addItem(rs.getString("Teacher_Name"));
                		lsttotal.add(rs.getString("Class_Conducted"));
                		str=rs.getString("Class_Conducted");
                		f=Math.round(0.75*(Float.valueOf(str)));
                		t=Integer.valueOf(Math.round(f));
                		lstmandet.add(String.valueOf(t));
                	}
                	
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
            }
            else if(cmbsem_no.getItemAt(3).equals("3")) {
            	lstsub.removeAll();
            	lstteacher.removeAll();
            	lsttotal.removeAll();
            	lstmandet.removeAll();
                try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select paper_details.Paper_Name,teacher_details.Teacher_Name,paper_assign_details.Class_Conducted from paper_details,course_details,teacher_details,paper_assign_details,batch_details where paper_details.Paper_Code=paper_assign_details.Paper_Code and paper_details.Course_Code=course_details.Course_Code and course_details.Course_Name='"+txtcourse_name.getText()+"' and teacher_details.Teacher_ID=paper_assign_details.Teacher_ID and paper_details.Sem_no='"+cmbsem_no.getSelectedItem()+"' and batch_details.Batch_Code=paper_assign_details.Batch_Code and batch_details.Batch_Name='"+txtbatch_name.getText()+"'");
                	while(rs.next()){
                		lstsub.addItem(rs.getString("Paper_Name"));                		
                		lstteacher.addItem(rs.getString("Teacher_Name"));
                		lsttotal.add(rs.getString("Class_Conducted"));
                		str=rs.getString("Class_Conducted");
                		f=Math.round(0.75*(Float.valueOf(str)));
                		t=Integer.valueOf(Math.round(f));
                		lstmandet.add(String.valueOf(t));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
            }
            else if(cmbsem_no.getItemAt(4).equals("4")) {
            	lstsub.removeAll();
            	lstteacher.removeAll();
            	lsttotal.removeAll();
            	lstmandet.removeAll();
                try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select paper_details.Paper_Name,teacher_details.Teacher_Name,paper_assign_details.Class_Conducted from paper_details,course_details,teacher_details,paper_assign_details,batch_details where paper_details.Paper_Code=paper_assign_details.Paper_Code and paper_details.Course_Code=course_details.Course_Code and course_details.Course_Name='"+txtcourse_name.getText()+"' and teacher_details.Teacher_ID=paper_assign_details.Teacher_ID and paper_details.Sem_no='"+cmbsem_no.getSelectedItem()+"' and batch_details.Batch_Code=paper_assign_details.Batch_Code and batch_details.Batch_Name='"+txtbatch_name.getText()+"'");
                	while(rs.next()){
                		lstsub.addItem(rs.getString("Paper_Name"));               		
                		lstteacher.addItem(rs.getString("Teacher_Name"));
                		lsttotal.add(rs.getString("Class_Conducted"));
                		str=rs.getString("Class_Conducted");
                		f=Math.round(0.75*(Float.valueOf(str)));
                		t=Integer.valueOf(Math.round(f));
                		lstmandet.add(String.valueOf(t));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
            }
            else if(cmbsem_no.getItemAt(5).equals("5")) {
            	lstsub.removeAll();
            	lstteacher.removeAll();
            	lsttotal.removeAll();
            	lstmandet.removeAll();
                try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select paper_details.Paper_Name,teacher_details.Teacher_Name,paper_assign_details.Class_Conducted from paper_details,course_details,teacher_details,paper_assign_details,batch_details where paper_details.Paper_Code=paper_assign_details.Paper_Code and paper_details.Course_Code=course_details.Course_Code and course_details.Course_Name='"+txtcourse_name.getText()+"' and teacher_details.Teacher_ID=paper_assign_details.Teacher_ID and paper_details.Sem_no='"+cmbsem_no.getSelectedItem()+"' and batch_details.Batch_Code=paper_assign_details.Batch_Code and batch_details.Batch_Name='"+txtbatch_name.getText()+"'");
                	while(rs.next()){
                		lstsub.addItem(rs.getString("Paper_Name"));
                		lstteacher.addItem(rs.getString("Teacher_Name"));
                		lsttotal.add(rs.getString("Class_Conducted"));
                		str=rs.getString("Class_Conducted");
                		f=Math.round(0.75*(Float.valueOf(str)));
                		t=Integer.valueOf(Math.round(f));
                		lstmandet.add(String.valueOf(t));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
            }
            else if(cmbsem_no.getItemAt(6).equals("6")) {
            	lstsub.removeAll();
            	lstteacher.removeAll();
            	lsttotal.removeAll();
            	lstmandet.removeAll();
                try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select paper_details.Paper_Name,teacher_details.Teacher_Name,paper_assign_details.Class_Conducted from paper_details,course_details,teacher_details,paper_assign_details,batch_details where paper_details.Paper_Code=paper_assign_details.Paper_Code and paper_details.Course_Code=course_details.Course_Code and course_details.Course_Name='"+txtcourse_name.getText()+"' and teacher_details.Teacher_ID=paper_assign_details.Teacher_ID and paper_details.Sem_no='"+cmbsem_no.getSelectedItem()+"' and batch_details.Batch_Code=paper_assign_details.Batch_Code and batch_details.Batch_Name='"+txtbatch_name.getText()+"'");
                	while(rs.next()){
                		lstsub.addItem(rs.getString("Paper_Name"));
                		lstteacher.addItem(rs.getString("Teacher_Name"));
                		lsttotal.add(rs.getString("Class_Conducted"));
                		str=rs.getString("Class_Conducted");
                		f=Math.round(0.75*(Float.valueOf(str)));
                		t=Integer.valueOf(Math.round(f));
                		lstmandet.add(String.valueOf(t));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
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
       /* if (com instanceof JRadioButton) {
            ((JRadioButton)com).setForeground(Color.black);
        }*/
      
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
        	//lstmandet.removeAll();
        	lstpresent.removeAll();
        	lstabsent.removeAll();
        	lstpercent.removeAll();
        	lstfine.removeAll();
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
        		rs=stmt.executeQuery("select attendance_details.A_Class,attendance_details.Ab_Class,attendance_details.A_Percentage,attendance_details.Fine from attendance_details where Sid='"+cmbsid.getSelectedItem()+"' and Course_Name='"+txtcourse_name.getText()+"' and Batch_Name='"+txtbatch_name.getText()+"' and Sem_no='"+cmbsem_no.getSelectedItem()+"' and Paper_Name='"+lstsub.getItem(i)+"'");
        		while(rs.next()){
        			//lstmandet.add(rs.getString("M_Class"));
        			lstpresent.add(rs.getString("A_Class"));
        			lstabsent.add(rs.getString("Ab_Class"));
        			lstpercent.add(rs.getString("A_Percentage"));
        			lstfine.add(rs.getString("Fine"));
        		}
        		        		
        	}catch(Exception ex){
        		JOptionPane.showMessageDialog(this,ex.toString());
        	}
        	}
    }

       if(ae.getSource()==btndelete){
    	   if(txt3.getText().trim().length()!=0){
    	   lstabsent.removeAll();
    	   lstpercent.removeAll();
    	   lstfine.removeAll();
    	   int i=lstpresent.getSelectedIndex();
    	   ImageIcon iconic=new ImageIcon("images/stat_sys_warning.png");
			 int  x=  JOptionPane.showConfirmDialog(this,"Do you really want to replace the selected one with the item in the textfield?","User Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,iconic);
			 if(x==0){
				 if(txt3.getText().trim().length()<=3){
				 	lstpresent.delItem(i); 
				 	lstpresent.addItem(txt3.getText(),i);
				 	txt3.setText("");
				 }else{
					JOptionPane.showMessageDialog(this,"Please Insert Valid Attended Class");
					txt3.setText("");
					txt3.grabFocus();
				 }
			 }else{
				 txt3.setText("");
			 }
    	   }else{
    		   JOptionPane.showMessageDialog(this,"Please Insert Attended Class in Corresponding Textfield");
    	   }
       }
       if(ae.getSource()==btnupdate){
    	   if(cmbsid.getSelectedIndex()!=0){
		   if(chkdo.isSelected()==true){
		   if(cmbsem_no.getSelectedIndex()!=0){
		   if(lstpresent.getItemCount()!=0&&lstpresent.getItemCount()==lsttotal.getItemCount()){
	       if(lstabsent.getItemCount()!=0){
		   if(lstpercent.getItemCount()!=0){
		   if(lstfine.getItemCount()!=0){
	    	   for(int i=0;i<lsttotal.getItemCount();i++){
	    	   try{
	    		   stmt=cn.createStatement();
	    		   stmt.executeUpdate("update attendance_details set A_Class='"+lstpresent.getItem(i)+"',Ab_Class='"+lstabsent.getItem(i)+"',A_Percentage='"+lstpercent.getItem(i)+"',Fine='"+lstfine.getItem(i)+"' where Sid='"+cmbsid.getSelectedItem()+"' and Course_Name='"+txtcourse_name.getText()+"' and Batch_Name='"+txtbatch_name.getText()+"' and Sem_no='"+cmbsem_no.getSelectedItem()+"' and Paper_Name='"+lstsub.getItem(i)+"'");
	    		   
	    	   }catch(Exception ex){
	               JOptionPane.showMessageDialog(this,ex.toString());
	    	   } 
	    	  }
	    	   
	    	   JOptionPane.showMessageDialog(this, "Data Updated Successfully");
	    	   JOptionPane.showMessageDialog(this,"Internal Exam Details For Attendance Marks Must Be Modified For Particular ID Number");
	    	   ImageIcon iconica=new ImageIcon("images/stat_sys_warning.png");
				int  x1=  JOptionPane.showConfirmDialog(this,"Do you want to update Internal Exam Details Right Now?","User Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,iconica);
				if(x1==0){
					new Exam_Updation();
				}
				else{
					
	             }

	    	   ImageIcon iconic=new ImageIcon("images/stat_sys_warning.png");
				int  x=  JOptionPane.showConfirmDialog(this,"Do you want to update more record?","User Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,iconic);
				if(x==0){
					reset();
				}
				else{
					dispose();
	             }
			 }else{
				 JOptionPane.showMessageDialog(this, "Please Calculate Total Fine");
					 but3.grabFocus();
				 }
			 }else{
				 JOptionPane.showMessageDialog(this, "Please Calculate Attendance Percent");
					 but2.grabFocus();
				 }
			 }else{
				 JOptionPane.showMessageDialog(this, "Please Calculate Absented Classes");
					 but1.grabFocus();
				 }
			 }else{
				 JOptionPane.showMessageDialog(this, "Please Insert Respective Values For Attended Classes");
					 txt3.grabFocus();
				 }
			 }else{
				 JOptionPane.showMessageDialog(this, "Please Select The Semester Number");
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
       if(ae.getSource()==but1){
    	   lstabsent.removeAll();
    	   lstpercent.removeAll();
    	   lstfine.removeAll();
    	   int j;
    	   if(lsttotal.getItemCount()==lstpresent.getItemCount()){
    	   for(int i=0;i<lsttotal.getItemCount();i++){
    		   if(Integer.valueOf(lsttotal.getItem(i))>=Integer.valueOf(lstpresent.getItem(i))){
    		  j= Integer.valueOf(lsttotal.getItem(i))-Integer.valueOf(lstpresent.getItem(i));
    		   lstabsent.add(String.valueOf(j), i);
    		   }
    		   else{
    			   JOptionPane.showMessageDialog(this,"Error In Insertion Of Attended Class");
    			   lstpresent.removeAll();
    			   lstabsent.removeAll();
    		   }
    	   }
    	   } else{
    		   JOptionPane.showMessageDialog(this,"Please Insert Attended Classes First");
    	   }
       }
       if(ae.getSource()==but2){
    	   lstpercent.removeAll();
    	   float j;
    	   if(lsttotal.getItemCount()==lstpresent.getItemCount()){
    	   for(int i=0;i<lsttotal.getItemCount();i++){
    		   if(Integer.valueOf(lsttotal.getItem(i))>=Integer.valueOf(lstpresent.getItem(i))){
    			   j=Math.round(100*(Float.valueOf(lstpresent.getItem(i))/Float.valueOf(lsttotal.getItem(i))));
    		   lstpercent.add(String.valueOf(j), i);
    		   }
    		   else{
    			   JOptionPane.showMessageDialog(this,"Error In Insertion Of Attended Class");
    			   lstpresent.removeAll();
    			   lstpercent.removeAll();
    		   }
    	   }
    	   }else{
    		   JOptionPane.showMessageDialog(this,"Please Insert Attended Classes First");
    	   }
       }
       if(ae.getSource()==but3){
    	   lstfine.removeAll();
    	   int j;
    	   if(lsttotal.getItemCount()==lstpresent.getItemCount()){
    	   for(int i=0;i<lsttotal.getItemCount();i++){
    		   if(Integer.valueOf(lstmandet.getItem(i))>=Integer.valueOf(lstpresent.getItem(i))){
    			   j=(Integer.valueOf(lstmandet.getItem(i))-Integer.valueOf(lstpresent.getItem(i)))*5;
    		   lstfine.add(String.valueOf(j), i);
    		   }
    		   else{
    			   lstfine.add(String.valueOf(0),i);
    		   }
    	   }
    	   }else{
    		   JOptionPane.showMessageDialog(this,"Please Insert Attended Classes First");
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
        txtroll.setText("");
        cmbsem_no.setSelectedIndex(0);
        lstsub.removeAll();
        lstteacher.removeAll();
        lsttotal.removeAll();
        lstmandet.removeAll();
        lstpresent.removeAll();
        lstabsent.removeAll();
        lstpercent.removeAll();
        lstfine.removeAll();
    }
    public static void main(String[] args) {
        new Attendance_Updation();
    }
}
