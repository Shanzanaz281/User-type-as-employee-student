import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import com.sun.xml.internal.ws.policy.spi.AssertionCreationException;

public class Test_Details extends JFrame implements ActionListener,ItemListener,KeyListener {
    Connection cn;
    Statement stmt;
    ResultSet rs;
    String sql = "";
    JTextField txtname,txtcourse_name,txtbatch_name,txtroll;
    JTextField txt1,txt2,txt3,txt4,txt5,txt6;
    JButton btnreset, btnsave, btnexit,btnpre,btnfind,but1,btnnext;
    JLabel lblhead,lblstudent_name,lblid, lblline,lblcourse_name,lblbatch_name,lbl1,lbl2,lbl3,lbl4;
    JCheckBox chkdo;
    JComboBox cmbsid;
    JComboBox cmbsem_no;
    JPanel panel;
    Container c;
    ImageIcon img;
    List lstsub,lstteacher,lstfm1,lstfm2,lstom2,lstom1,lstfm3,lstom3,lstavg;
    public Test_Details() {
        img = new ImageIcon("images/2jb0c3d.jpg", null);
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
        lblhead = new JLabel("TEST DETAILS");
        lblhead.setFont(new Font("COPPERPLATE GOTHIC LIGHT", Font.CENTER_BASELINE, 25));
                
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
                lstsub=new List();
                lstteacher=new List();
                lstfm1=new List();
                lstfm2=new List();
                lstom2=new List();
                lstom1=new List();
                lstom3=new List();
                lstfm3=new List();
                lstavg=new List();
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
		        btnnext = new JButton("Next", new ImageIcon("images/next2.png"));
		        btnnext.addActionListener(this);
		        btnfind=new JButton("Find",new ImageIcon("images/search.png"));
		        btnfind.addActionListener(this);
		        but1=new JButton("Cal.",new ImageIcon("images/CMS-calc1.png"));
		        but1.addActionListener(this);
		        addcomp(220, 0, 400, 50, lblhead);
		        addcomp(1025, 10, 250, 65, new JLabel(new ImageIcon("images/cim_lbl1_1.jpg")));
		        addcomp(220, 90, 70, 30, lblid);
		        addcomp(350, 90, 100, 30, cmbsid);
		        addcomp(460, 90, 250, 30, chkdo);chkdo.addItemListener(this);
		        addcomp(725,90,100,30,new JLabel("Semester no."));
		        addcomp(855,90,100,30,cmbsem_no);
		        addcomp(960,90,90,30,btnfind);
		        cmbsem_no.addItemListener(this);
		        
		        addcomp(220, 120, 1200, 25, lblline);
		        

		        addcomp(220, 160, 100, 30, lblstudent_name);
		        addcomp(350, 160, 200, 30, txtname);

		        addcomp(725,160,100,30,new JLabel("Class Roll no"));
		        addcomp(855,160,100,30,txtroll);
		        
		        addcomp(220, 210, 100, 30, lblcourse_name);
		        addcomp(350, 210, 200, 30, txtcourse_name);

		        addcomp(725, 210, 100, 30, lblbatch_name);
		        addcomp(855, 210, 200, 30, txtbatch_name);
		        
		        addcomp(220, 280, 1200, 15, new JLabel("___________________________________________________________________________________________________________________________________________"));
		        addcomp(300,303,100,30,lbl1);
		        addcomp(310,333,100,30,lbl3);
		        addcomp(530,303,100,30,lbl2);
		        addcomp(550,333,100,30,lbl4);
		        
		        addcomp(720,295,100,20,new JLabel("UNIT TEST I"));
		        addcomp(710,315,75,20,new JLabel("F.M"));
		        addcomp(690,345,60,30,txt1);
		        
		        addcomp(755,313,1,220,new JLabel(new ImageIcon("images/line.jpg")));
		        
		        addcomp(777,315,75,20,new JLabel("O.M"));
		        addcomp(760,345,60,30,txt2);
		        
		        addcomp(825,294,1,239,new JLabel(new ImageIcon("images/line.jpg")));
		        
		        addcomp(857,295,100,20,new JLabel("UNIT TEST II"));
		        addcomp(847,315,75,20,new JLabel("F.M"));
		        addcomp(830,345,60,30,txt3);
		        
		        addcomp(895,313,1,220,new JLabel(new ImageIcon("images/line.jpg")));
		        
		        addcomp(917,315,75,20,new JLabel("O.M"));
		        addcomp(900,345,60,30,txt4);
		        
		        addcomp(965,294,1,239,new JLabel(new ImageIcon("images/line.jpg")));
		        
		        addcomp(997,295,100,20,new JLabel("UNIT TEST III"));
		        addcomp(987,315,85,20,new JLabel("F.M"));
		        addcomp(970,345,60,30,txt5);
		        
		        addcomp(1035,313,1,220,new JLabel(new ImageIcon("images/line.jpg")));
		        
		        addcomp(1057,315,75,20,new JLabel("O.M"));
		        addcomp(1040,345,60,30,txt6);
		        
		        addcomp(1105,294,1,239,new JLabel(new ImageIcon("images/line.jpg")));
		        
		        addcomp(684, 300, 430, 15, new JLabel("____________________________________________________________"));
		        
		        addcomp(1113,295,100,20,new JLabel("PERCENTAGE"));
		        addcomp(1113,315,100,20,new JLabel("TEST MARKS"));
		        
		        addcomp(220,363,1200,15,new JLabel("___________________________________________________________________________________________________________________________________________"));
		        
		        addcomp(684, 325, 516, 15, new JLabel("_________________________________________________________________________")); 
		        addcomp(220, 294, 1, 239, new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(225,380,245,150,lstsub);
		        addcomp(474, 294, 1, 239, new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(480,380,200,150,lstteacher);
		        addcomp(684, 294, 1, 239, new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(690,380,60,150,lstfm1);
		        addcomp(830,380,60,150,lstfm2);
		        addcomp(900,380,60,150,lstom2);
		        addcomp(760,380,60,150,lstom1);
		        addcomp(970,380,60,150,lstfm3);
		        addcomp(1040,380,60,150,lstom3);
		        addcomp(1193, 294, 1, 239, new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(1110,380,80,150,lstavg);
		        addcomp(1110,345,80,30,but1);
		        addcomp(220, 520, 1200, 15, new JLabel("___________________________________________________________________________________________________________________________________________"));
		        addcomp(220, 555, 1200, 15, new JLabel("___________________________________________________________________________________________________________________________________________"));
		        addcomp(700, 590, 90, 30, btnreset);
		        addcomp(800, 590, 90, 30, btnsave);
		        addcomp(900, 590, 90, 30, btnpre);
		        addcomp(1000, 590, 90, 30, btnnext);
		        addcomp(1100, 590, 90, 30, btnexit);
		        addcomp(00, 00, 200, 640, new JLabel(new ImageIcon("images/test_side.jpg")));
		       

        setBounds(0, 0, 1317, 670);
        setTitle("Test Details Form");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
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
            if(cmbsem_no.getItemAt(1).equals("1")) {
            	lstsub.removeAll();
            	lstteacher.removeAll();
                try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select paper_details.Paper_Name,teacher_details.Teacher_Name from paper_details,course_details,teacher_details,paper_assign_details,batch_details where paper_details.Paper_Code=paper_assign_details.Paper_Code and paper_details.Course_Code=course_details.Course_Code and course_details.Course_Name='"+txtcourse_name.getText()+"' and teacher_details.Teacher_ID=paper_assign_details.Teacher_ID and paper_details.Sem_no='"+cmbsem_no.getSelectedItem()+"' and batch_details.Batch_Code=paper_assign_details.Batch_Code and batch_details.Batch_Name='"+txtbatch_name.getText()+"'");
                	//rs=stmt.executeQuery("select paper_details.Paper_Name,teacher_details.Teacher_Name from paper_details,teacher_details,paper_assign_details where paper_details.Paper_Code=paper_assign_details.Paper_Code and teacher_details.Teacher_ID=paper_assign_details.Teacher_ID and paper_details.Sem_no='"+cmbsem_no.getSelectedItem()+"'");
                	while(rs.next()){
                		lstsub.addItem(rs.getString("Paper_Name"));
                		lstteacher.addItem(rs.getString("Teacher_Name"));                		
                	}                	
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
            }
            else if(cmbsem_no.getItemAt(2).equals("2")) {
            	lstsub.removeAll();
            	lstteacher.removeAll();
                try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select paper_details.Paper_Name,teacher_details.Teacher_Name from paper_details,course_details,teacher_details,paper_assign_details,batch_details where paper_details.Paper_Code=paper_assign_details.Paper_Code and paper_details.Course_Code=course_details.Course_Code and course_details.Course_Name='"+txtcourse_name.getText()+"' and teacher_details.Teacher_ID=paper_assign_details.Teacher_ID and paper_details.Sem_no='"+cmbsem_no.getSelectedItem()+"' and batch_details.Batch_Code=paper_assign_details.Batch_Code and batch_details.Batch_Name='"+txtbatch_name.getText()+"'");
                	while(rs.next()){
                		lstsub.addItem(rs.getString("Paper_Name"));                		
                		lstteacher.addItem(rs.getString("Teacher_Name"));
                	}
                	
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
            }
            else if(cmbsem_no.getItemAt(3).equals("3")) {
            	lstsub.removeAll();
            	lstteacher.removeAll();
                try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select paper_details.Paper_Name,teacher_details.Teacher_Name from paper_details,course_details,teacher_details,paper_assign_details,batch_details where paper_details.Paper_Code=paper_assign_details.Paper_Code and paper_details.Course_Code=course_details.Course_Code and course_details.Course_Name='"+txtcourse_name.getText()+"' and teacher_details.Teacher_ID=paper_assign_details.Teacher_ID and paper_details.Sem_no='"+cmbsem_no.getSelectedItem()+"' and batch_details.Batch_Code=paper_assign_details.Batch_Code and batch_details.Batch_Name='"+txtbatch_name.getText()+"'");
                	while(rs.next()){
                		lstsub.addItem(rs.getString("Paper_Name"));                		
                		lstteacher.addItem(rs.getString("Teacher_Name"));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
              
                
            }
            else if(cmbsem_no.getItemAt(4).equals("4")) {
            	lstsub.removeAll();
            	lstteacher.removeAll();
                try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select paper_details.Paper_Name,teacher_details.Teacher_Name from paper_details,course_details,teacher_details,paper_assign_details,batch_details where paper_details.Paper_Code=paper_assign_details.Paper_Code and paper_details.Course_Code=course_details.Course_Code and course_details.Course_Name='"+txtcourse_name.getText()+"' and teacher_details.Teacher_ID=paper_assign_details.Teacher_ID and paper_details.Sem_no='"+cmbsem_no.getSelectedItem()+"' and batch_details.Batch_Code=paper_assign_details.Batch_Code and batch_details.Batch_Name='"+txtbatch_name.getText()+"'");
                	while(rs.next()){
                		lstsub.addItem(rs.getString("Paper_Name"));                		
                		lstteacher.addItem(rs.getString("Teacher_Name"));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
            }
            else if(cmbsem_no.getItemAt(5).equals("5")) {
            	lstsub.removeAll();
            	lstteacher.removeAll();
                try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select paper_details.Paper_Name,teacher_details.Teacher_Name from paper_details,course_details,teacher_details,paper_assign_details,batch_details where paper_details.Paper_Code=paper_assign_details.Paper_Code and paper_details.Course_Code=course_details.Course_Code and course_details.Course_Name='"+txtcourse_name.getText()+"' and teacher_details.Teacher_ID=paper_assign_details.Teacher_ID and paper_details.Sem_no='"+cmbsem_no.getSelectedItem()+"' and batch_details.Batch_Code=paper_assign_details.Batch_Code and batch_details.Batch_Name='"+txtbatch_name.getText()+"'");
                	while(rs.next()){
                		lstsub.addItem(rs.getString("Paper_Name"));                		
                		lstteacher.addItem(rs.getString("Teacher_Name"));
                	}
                }catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	}
            }
            else if(cmbsem_no.getItemAt(6).equals("6")) {
            	lstsub.removeAll();
            	lstteacher.removeAll();
                try{
                	stmt=cn.createStatement();
                	rs=stmt.executeQuery("select paper_details.Paper_Name,teacher_details.Teacher_Name from paper_details,course_details,teacher_details,paper_assign_details,batch_details where paper_details.Paper_Code=paper_assign_details.Paper_Code and paper_details.Course_Code=course_details.Course_Code and course_details.Course_Name='"+txtcourse_name.getText()+"' and teacher_details.Teacher_ID=paper_assign_details.Teacher_ID and paper_details.Sem_no='"+cmbsem_no.getSelectedItem()+"' and batch_details.Batch_Code=paper_assign_details.Batch_Code and batch_details.Batch_Name='"+txtbatch_name.getText()+"'");
                	while(rs.next()){
                		lstsub.addItem(rs.getString("Paper_Name"));               		
                		lstteacher.addItem(rs.getString("Teacher_Name"));
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
            txtroll.setText("");
            cmbsem_no.setSelectedIndex(0);
            lstsub.removeAll();
            lstteacher.removeAll();
            lstfm1.removeAll();
            lstom1.removeAll();
            lstfm2.removeAll();
            lstom2.removeAll();
            lstfm3.removeAll();
            lstom3.removeAll();
            lstavg.removeAll();
        }
        if (ae.getSource() == btnexit) {
            dispose();
        }
        if(ae.getSource()==btnfind){
        	lstfm1.removeAll();
        	lstom1.removeAll();
        	lstfm2.removeAll();
        	lstom2.removeAll();
        	lstfm3.removeAll();
        	lstom3.removeAll();
        	lstavg.removeAll();
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
        		rs=stmt.executeQuery("select test_details.Fm1,test_details.Om1,test_details.Fm2,test_details.Om2,test_details.Fm3,test_details.Om3,test_details.Avg from test_details where Sid='"+cmbsid.getSelectedItem()+"' and Sem_no='"+cmbsem_no.getSelectedItem()+"' and Paper_Name='"+lstsub.getItem(i)+"'");
        		while(rs.next()){
        			lstfm1.add(rs.getString("Fm1"));
        			lstom1.add(rs.getString("Om1"));
        			lstfm2.add(rs.getString("Fm2"));
        			lstom2.add(rs.getString("Om2"));
        			lstfm3.add(rs.getString("Fm3"));
        			lstom3.add(rs.getString("Om3"));
        			lstavg.add(rs.getString("Avg"));
        		}
        		        		
        	}catch(Exception ex){
        		JOptionPane.showMessageDialog(this,ex.toString());
        	}
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
			 if(lstavg.getItemCount()!=0){
	        	for(int i=0;i<lstsub.getItemCount();i++){
	            sql ="insert into test_details values('" + cmbsid.getSelectedItem() +/* "','"+txtname.getText()+"','" +txtroll.getText()+"','"+txtcourse_name.getText()+"','"+txtbatch_name.getText()+*/"','"+cmbsem_no.getSelectedItem()+"','"+lstsub.getItem(i)+"','"+lstteacher.getItem(i)+"','"+lstfm1.getItem(i)+"','"+lstom1.getItem(i)+"','"+lstfm2.getItem(i)+"','"+lstom2.getItem(i)+"','"+lstfm3.getItem(i)+"','"+lstom3.getItem(i)+"','"+lstavg.getItem(i)+"')";
	            try {
	                stmt = cn.createStatement();
	                stmt.executeUpdate(sql);
	            } catch (SQLException sqex) {
	                JOptionPane.showMessageDialog(this, sqex.getMessage().toString(), "Error in SQL Insertion",
	                                              JOptionPane.ERROR_MESSAGE);
	            }
	        	}
	        	JOptionPane.showMessageDialog(this, "Test Details Stored");
	            /*this.dispose();
	            new Assign_Details();*/
	        	int t=JOptionPane.showConfirmDialog(this, "Do You Want To Enter More Values?");
	            if(t==0){
	          	  reset();
	            }
	            else if(t==1){
	          	  this.dispose();
	          	  new Assign_Details(); 
	            }
			 }else{
				 JOptionPane.showMessageDialog(this,"Please Calculate Average Test Marks");
					 but1.grabFocus();
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
    	   new Attendence_Details();
       }
       if(ae.getSource()==btnnext){
    	   this.dispose();
    	   new Assign_Details();
       }
       if(ae.getSource()==but1){
    	   lstavg.removeAll();
    	   float j;
    	   if(lstfm1.getItemCount()!=0&&lstfm2.getItemCount()!=0&&lstfm3.getItemCount()!=0&&lstom1.getItemCount()!=0&&lstom2.getItemCount()!=0&&lstom3.getItemCount()!=0){
    	   if(lstfm1.getItemCount()==lstom1.getItemCount()&&lstfm2.getItemCount()==lstom2.getItemCount()&&lstfm3.getItemCount()==lstom3.getItemCount()){
    	   for(int i=0;i<lstfm1.getItemCount();i++){
    		   if(Integer.valueOf(lstfm1.getItem(i))>=Integer.valueOf(lstom1.getItem(i))&& Integer.valueOf(lstfm2.getItem(i))>=Integer.valueOf(lstom2.getItem(i))&& Integer.valueOf(lstfm3.getItem(i))>=Integer.valueOf(lstom3.getItem(i))){   		 
    			   j=Math.round(100*(Float.valueOf(lstom1.getItem(i))+Float.valueOf(lstom2.getItem(i))+Float.valueOf(lstom3.getItem(i)))/(Float.valueOf(lstfm1.getItem(i))+Float.valueOf(lstfm2.getItem(i))+Float.valueOf(lstfm3.getItem(i))));
    		   lstavg.add(String.valueOf(j), i);
    		   }
    		   else{
    			   JOptionPane.showMessageDialog(this,"Error In Insertion Of Obtained Marks");
    			   lstom1.removeAll();
    			   lstom2.removeAll();
    			   lstom3.removeAll();
    			   lstavg.removeAll();
    		   }
    	   }
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
        txtroll.setText("");
        cmbsem_no.setSelectedIndex(0);
        lstsub.removeAll();
        lstteacher.removeAll();
        lstfm1.removeAll();
        lstom1.removeAll();
        lstfm2.removeAll();
        lstom2.removeAll();
        lstfm3.removeAll();
        lstom3.removeAll();
        lstavg.removeAll();
    }
    public static void main(String[] args) {
        new Test_Details();
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
						JOptionPane.showMessageDialog(this,"Please Enter Valid Test Full Marks");
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
					if(lstom1.getItemCount()!=lstsub.getItemCount()){
						if(txt2.getText().trim().length()<=2){
							lstom1.add(txt2.getText());
							txt2.setText("");
						}else{
							JOptionPane.showMessageDialog(this,"Please Enter Valid Test Obtained Marks");
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
							JOptionPane.showMessageDialog(this,"Please Enter Valid Test Full Marks");
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
					if(lstom2.getItemCount()!=lstsub.getItemCount()){
						if(txt4.getText().trim().length()<=2){
							lstom2.add(txt4.getText());
							txt4.setText("");
						}else{
							JOptionPane.showMessageDialog(this,"Please Enter Valid Test Obtained Marks");
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
						if(txt5.getText().trim().length()<=2){
							lstfm3.add(txt5.getText());
							txt5.setText("");
						}else{
							JOptionPane.showMessageDialog(this,"Please Enter Valid Test Full Marks");
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
					if(lstom3.getItemCount()!=lstsub.getItemCount()){
						if(txt6.getText().trim().length()<=2){
							lstom3.add(txt6.getText());
							txt6.setText("");
						}else{
							JOptionPane.showMessageDialog(this,"Please Enter Valid Test Obtained Marks");
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
		
	}
}
