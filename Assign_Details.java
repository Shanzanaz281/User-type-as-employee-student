import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Assign_Details extends JFrame implements ActionListener,ItemListener,KeyListener {
    Connection cn;
    Statement stmt;
    ResultSet rs;
    String sql = "";
    JTextField txtname,txtcourse_name,txtbatch_name,txtroll;
    JTextField txt1,txt2,txt3,txt4,txt5,txt6,txtt1,txtt2,txtt3;
    JButton btnreset, btnsave, btnexit,btnpre,btnfind,but1,btnnext;
    JLabel lblhead,lblstudent_name,lblid, lblline,lblcourse_name,lblbatch_name,lbl1,lbl2,lbl3,lbl4;
    JCheckBox chkdo;
    JComboBox cmbsid,cmbsem_no;
    JPanel panel;
    Container c;
    ImageIcon img;
    List lstsub,lstteacher,lstfm1,lstfm2,lstom2,lstom1,lstfm3,lstom3,lstavg,lstt1,lstt2,lstt3;
    public Assign_Details() {
        img = new ImageIcon("images/2jb0c3d.jpg", null);
        panel = new JPanel() {
                protected void paintComponent(Graphics g) {
                    g.drawImage(img.getImage(), 0, 0, 1390, 640, null);
                    super.paintComponent(g);
                }
            };
        panel.setOpaque(false);
        panel.setPreferredSize(new Dimension(1390, 640));
        c = getContentPane();
        panel.setLayout(null);
        c.add(panel);
        lblhead = new JLabel("ASSIGNMENT DETAILS");
        lblhead.setFont(new Font("COPPERPLATE GOTHIC LIGHT", Font.CENTER_BASELINE, 25));
                
                lblline = new JLabel("_____________________________________________________________________________________________________________________________________________________________________________________________");
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
                lstt1=new List();
                lstt2=new List();
                lstt3=new List();
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
                txtt1=new JTextField();
                txtt1.addKeyListener(this);
                txtt2=new JTextField();
                txtt2.addKeyListener(this);
                txtt3=new JTextField();
                txtt3.addKeyListener(this);
                
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
		        btnnext = new JButton("Next", new ImageIcon("images/next2.png"));
		        btnnext.addActionListener(this);
		        but1=new JButton("Cal.",new ImageIcon("images/CMS-calc1.png"));
		        but1.addActionListener(this);
		        addcomp(10, 0, 400, 50, lblhead);
		        addcomp(1050, 10, 250, 65, new JLabel(new ImageIcon("images/cim_lbl1_1.jpg")));
		        addcomp(10, 90, 70, 30, lblid);
		        addcomp(140, 90, 100, 30, cmbsid);
		        addcomp(250, 90, 250, 30, chkdo);chkdo.addItemListener(this);
		        addcomp(615,90,100,30,new JLabel("Semester no."));
		        addcomp(745,90,100,30,cmbsem_no);
		        addcomp(850,90,90,30,btnfind);
		        cmbsem_no.addItemListener(this);
		        
		        addcomp(10, 120, 1335, 25, lblline);
		        

		        addcomp(10, 160, 100, 30, lblstudent_name);
		        addcomp(140, 160, 200, 30, txtname);

		        addcomp(615,160,100,30,new JLabel("Class Roll no"));
		        addcomp(745,160,100,30,txtroll);
		        
		        addcomp(10, 210, 100, 30, lblcourse_name);
		        addcomp(140, 210, 200, 30, txtcourse_name);

		        addcomp(615, 210, 100, 30, lblbatch_name);
		        addcomp(745, 210, 200, 30, txtbatch_name);
		        
		        addcomp(10, 280, 1335, 15, new JLabel("_____________________________________________________________________________________________________________________________________________________________________________________________"));
		        addcomp(90,303,100,30,lbl1);
		        addcomp(100,333,100,30,lbl3);
		        addcomp(290,303,100,30,lbl2);
		        addcomp(310,333,100,30,lbl4);
		        
		        addcomp(527,295,100,20,new JLabel("ASSIGNMENT I"));
		        addcomp(477,315,85,20,new JLabel("TOPIC"));
		        addcomp(440,345,120,30,txtt1);
		        addcomp(587,315,75,20,new JLabel("F.M"));
		        addcomp(570,345,60,30,txt1);
		        
		        addcomp(565,313,1,220,new JLabel(new ImageIcon("images/line.jpg")));
		        
		        addcomp(657,315,75,20,new JLabel("O.M"));
		        addcomp(640,345,60,30,txt2);
		        
		        addcomp(705,294,1,239,new JLabel(new ImageIcon("images/line.jpg")));
		        
		        addcomp(800,295,100,20,new JLabel("ASSIGNMENT II"));
		        addcomp(750,315,85,20,new JLabel("TOPIC"));
		        addcomp(710,345,120,30,txtt2);
		        addcomp(857,315,75,20,new JLabel("F.M"));
		        addcomp(840,345,60,30,txt3);
		        
		        addcomp(635,313,1,220,new JLabel(new ImageIcon("images/line.jpg")));
		        
		        addcomp(927,315,75,20,new JLabel("O.M"));
		        addcomp(910,345,60,30,txt4);
		        
		        //addcomp(755,294,1,239,new JLabel(new ImageIcon("images/line.jpg")));
		        
		        addcomp(1070,295,100,20,new JLabel("ASSIGNMENT III"));
		        addcomp(1020,315,85,20,new JLabel("TOPIC"));		        
		        addcomp(980,345,120,30,txtt3);
		        addcomp(1105,313,1,220,new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(1127,315,85,20,new JLabel("F.M"));	        
		        addcomp(1110,345,60,30,txt5);
		        addcomp(1175,313,1,220,new JLabel(new ImageIcon("images/line.jpg")));
		        
		        addcomp(835,313,1,220,new JLabel(new ImageIcon("images/line.jpg")));
		        
		        addcomp(1197,315,75,20,new JLabel("O.M"));
		        addcomp(1180,345,60,30,txt6);
		        addcomp(1245,294,1,239,new JLabel(new ImageIcon("images/line.jpg")));
		        
		        addcomp(905,313,1,220,new JLabel(new ImageIcon("images/line.jpg")));
		        
		        addcomp(975,294,1,239,new JLabel(new ImageIcon("images/line.jpg")));
		        
		        addcomp(435, 300, 850, 15, new JLabel("____________________________________________________________________________________________________________________"));
		        
		        addcomp(1253,295,100,20,new JLabel("ASSIGNMENT"));
		        addcomp(1253,315,100,20,new JLabel("MARKS IN (%)"));
		        addcomp(1333,294,1,239,new JLabel(new ImageIcon("images/line.jpg")));
		        
		        addcomp(10,363,1335,15,new JLabel("_____________________________________________________________________________________________________________________________________________________________________________________________"));
		        
		        addcomp(435, 325, 910, 15, new JLabel("________________________________________________________________________________________________________________________________")); 
		        addcomp(10, 294, 1, 239, new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(15,380,215,150,lstsub);
		        addcomp(235, 294, 1, 239, new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(240,380,190,150,lstteacher);
		        addcomp(435, 294, 1, 239, new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(440,380,120,150,lstt1);
		        addcomp(570,380,60,150,lstfm1);
		        addcomp(710,380,120,150,lstt2);
		        addcomp(840,380,60,150,lstfm2);
		        addcomp(910,380,60,150,lstom2);
		        addcomp(640,380,60,150,lstom1);
		        addcomp(980,380,120,150,lstt3);
		        addcomp(1110,380,60,150,lstfm3);
		        addcomp(1180,380,60,150,lstom3);
		        //addcomp(983, 294, 1, 239, new JLabel(new ImageIcon("images/line.jpg")));
		        addcomp(1250,380,80,150,lstavg);
		        addcomp(1250,345,80,30,but1);
		        addcomp(10, 520, 1335, 15, new JLabel("_____________________________________________________________________________________________________________________________________________________________________________________________"));
		        addcomp(10, 555, 1335, 15, new JLabel("_____________________________________________________________________________________________________________________________________________________________________________________________"));
		        addcomp(840, 590, 90, 30, btnreset);
		        addcomp(940, 590, 90, 30, btnsave);
		        addcomp(1040, 590, 90, 30, btnpre);
		        addcomp(1140, 590, 90, 30, btnnext);
		        addcomp(1240, 590, 90, 30, btnexit);
		       

        setBounds(0, 0, 1357, 670);
        setTitle("Assignment Details Form");
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
            if(cmbsem_no.getItemAt(1).equals("1")) {
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
            else if(cmbsem_no.getItemAt(2).equals("2")) {
            	lstsub.removeAll();
            	lstteacher.removeAll();
                try{
                	stmt=cn.createStatement();
                	//rs=stmt.executeQuery("select paper_details.Paper_Name,teacher_details.Teacher_Name from paper_details,teacher_details,paper_assign_details where paper_details.Paper_Code=paper_assign_details.Paper_Code and teacher_details.Teacher_ID=paper_assign_details.Teacher_ID and paper_details.Sem_no='"+cmbsem_no.getSelectedItem()+"'");
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
            txtt1.setText("");
            txtt2.setText("");
            txtt3.setText("");
            txt1.setText("");
            txt2.setText("");
            txt3.setText("");
            txt4.setText("");
            txt5.setText("");
            txt6.setText("");
            lstfm1.removeAll();
            lstom1.removeAll();
            lstfm2.removeAll();
            lstom2.removeAll();
            lstfm3.removeAll();
            lstom3.removeAll();
            lstt1.removeAll();
            lstt2.removeAll();
            lstt3.removeAll();
            lstavg.removeAll();
        }
        if (ae.getSource() == btnexit) {
            dispose();
        }
        if(ae.getSource()==btnfind){
        	lstt1.removeAll();
        	lstt2.removeAll();
        	lstt3.removeAll();
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
        		rs=stmt.executeQuery("select assign_details.Topic1,assign_details.Full_m1,assign_details.Obtained_m1,assign_details.Topic2,assign_details.Full_m2,assign_details.Obtained_m2,assign_details.Topic3,assign_details.Full_m3,assign_details.Obtained_m3,assign_details.Avge from assign_details where Sid='"+cmbsid.getSelectedItem()+"' and Sem_no='"+cmbsem_no.getSelectedItem()+"' and Paper_Name='"+lstsub.getItem(i)+"'");
        		while(rs.next()){
        			lstt1.add(rs.getString("Topic1"));
        			lstfm1.add(rs.getString("Full_m1"));
        			lstom1.add(rs.getString("Obtained_m1"));
        			lstt2.add(rs.getString("Topic2"));
        			lstfm2.add(rs.getString("Full_m2"));
        			lstom2.add(rs.getString("Obtained_m2"));
        			lstt3.add(rs.getString("Topic3"));
        			lstfm3.add(rs.getString("Full_m3"));
        			lstom3.add(rs.getString("Obtained_m3"));
        			lstavg.add(rs.getString("Avge"));
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
   				if(lstt1.getItemCount()!=0&&lstt1.getItemCount()==lstsub.getItemCount()){
   				if(lstfm1.getItemCount()!=0&&lstfm1.getItemCount()==lstsub.getItemCount()){
   				if(lstom1.getItemCount()!=0&&lstom1.getItemCount()==lstfm1.getItemCount()){
   				if(lstt2.getItemCount()!=0&&lstt2.getItemCount()==lstsub.getItemCount()){
   				if(lstfm2.getItemCount()!=0&&lstfm2.getItemCount()==lstsub.getItemCount()){
   				if(lstom2.getItemCount()!=0&&lstom2.getItemCount()==lstfm2.getItemCount()){
   				if(lstt3.getItemCount()!=0&&lstt3.getItemCount()==lstsub.getItemCount()){
   				if(lstfm3.getItemCount()!=0&&lstfm3.getItemCount()==lstsub.getItemCount()){
   				if(lstom3.getItemCount()!=0&&lstom3.getItemCount()==lstfm3.getItemCount()){
   				if(lstavg.getItemCount()!=0){
		        	for(int i=0;i<lstsub.getItemCount();i++){
		            sql ="insert into assign_details values('" + cmbsid.getSelectedItem() +/* "','"+txtname.getText()+"','" +txtroll.getText()+"','"+txtcourse_name.getText()+"','"+txtbatch_name.getText()+*/"','"+cmbsem_no.getSelectedItem()+"','"+lstsub.getItem(i)+"','"+lstteacher.getItem(i)+"','"+lstt1.getItem(i)+"','"+lstfm1.getItem(i)+"','"+lstom1.getItem(i)+"','"+lstt2.getItem(i)+"','"+lstfm2.getItem(i)+"','"+lstom2.getItem(i)+"','"+lstt3.getItem(i)+"','"+lstfm3.getItem(i)+"','"+lstom3.getItem(i)+"','"+lstavg.getItem(i)+"')";
		            try {
		                stmt = cn.createStatement();
		                stmt.executeUpdate(sql);
		            } catch (SQLException sqex) {
		                JOptionPane.showMessageDialog(this, sqex.getMessage().toString(), "Error in SQL Insertion",
		                                              JOptionPane.ERROR_MESSAGE);
		            }
		        	}
		        	JOptionPane.showMessageDialog(this, "Assignment Details Stored");
		            /*this.dispose();
		            new Exam_Details();*/
		        	int t=JOptionPane.showConfirmDialog(this, "Do You Want To Enter More Values?");
		            if(t==0){
		          	  reset();
		            }
		            else if(t==1){
		          	  this.dispose();
		          	  new Exam_Details(); 
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
					JOptionPane.showMessageDialog(this,"Please Insert Respective Topic Name");
						txtt3.grabFocus();
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
					JOptionPane.showMessageDialog(this,"Please Insert Respective Topic Name");
						txtt2.grabFocus();
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
					JOptionPane.showMessageDialog(this,"Please Insert Respective Topic Name");
							txtt1.grabFocus();
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
    	   new Test_Details();
       }
       if(ae.getSource()==btnnext){
    	   this.dispose();
    	   new Exam_Details();
       }
       if(ae.getSource()==but1){
    	   lstavg.removeAll();
    	   float j;
    	   if(lstt1.getItemCount()!=0&&lstt2.getItemCount()!=0&&lstt3.getItemCount()!=0&&lstfm1.getItemCount()!=0&&lstfm2.getItemCount()!=0&&lstfm3.getItemCount()!=0&&lstom1.getItemCount()!=0&&lstom2.getItemCount()!=0&&lstom3.getItemCount()!=0){
        	   if(lstt1.getItemCount()==lstsub.getItemCount()&&lstt2.getItemCount()==lstsub.getItemCount()&&lstt3.getItemCount()==lstsub.getItemCount()&&lstt1.getItemCount()==lstfm1.getItemCount()&&lstt2.getItemCount()==lstfm2.getItemCount()&&lstt3.getItemCount()==lstfm3.getItemCount()&&lstfm1.getItemCount()==lstom1.getItemCount()&&lstfm2.getItemCount()==lstom2.getItemCount()&&lstfm3.getItemCount()==lstom3.getItemCount()){
    	   for(int i=0;i<lstsub.getItemCount();i++){
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
        		   JOptionPane.showMessageDialog(this,"Error In Insertion Of Marks Or Topic Name(s)"); 
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
        txtt1.setText("");
        txtt2.setText("");
        txtt3.setText("");
        txt1.setText("");
        txt2.setText("");
        txt3.setText("");
        txt4.setText("");
        txt5.setText("");
        txt6.setText("");
        lstfm1.removeAll();
        lstom1.removeAll();
        lstfm2.removeAll();
        lstom2.removeAll();
        lstfm3.removeAll();
        lstom3.removeAll();
        lstt1.removeAll();
        lstt2.removeAll();
        lstt3.removeAll();
        lstavg.removeAll();
    }
    public static void main(String[] args) {
        new Assign_Details();
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
							JOptionPane.showMessageDialog(this,"Please Enter Valid Assignment Full Marks");
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
							JOptionPane.showMessageDialog(this,"Please Enter Valid Assignment Obtained Marks");
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
							JOptionPane.showMessageDialog(this,"Please Enter Valid Assignment Full Marks");
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
							JOptionPane.showMessageDialog(this,"Please Enter Valid Assignment Obtained Marks");
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
							JOptionPane.showMessageDialog(this,"Please Enter Valid Assignment Full Marks");
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
							JOptionPane.showMessageDialog(this,"Please Enter Valid Assignment Obtained Marks");
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
		if(e.getSource()==txtt1){
			if(e.getKeyCode()==e.VK_ENTER){
				if(txtt1.getText().trim().length()!=0){
				if(lstt1.getItemCount()!=lstsub.getItemCount()){
					lstt1.add(txtt1.getText());
					txtt1.setText("");
				}else{
					JOptionPane.showMessageDialog(this,"You Can't Enter More Value(s)");
					txtt1.setText("");
				}
				}else{
					JOptionPane.showMessageDialog(this,"You Can't Fill Whitespace As Topic Name");
					txtt1.grabFocus();
				}
			}
		}
		if(e.getSource()==txtt2){
			if(e.getKeyCode()==e.VK_ENTER){
				if(txtt2.getText().trim().length()!=0){
					if(lstt2.getItemCount()!=lstsub.getItemCount()){
						lstt2.add(txtt2.getText());
						txtt2.setText("");
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Enter More Value(s)");
						txtt2.setText("");
					}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Fill Whitespace As Topic Name");
						txtt2.grabFocus();
					}
			}
		}
		if(e.getSource()==txtt3){
			if(e.getKeyCode()==e.VK_ENTER){
				if(txtt3.getText().trim().length()!=0){
					if(lstt3.getItemCount()!=lstsub.getItemCount()){
						lstt3.add(txtt3.getText());
						txtt3.setText("");
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Enter More Value(s)");
						txtt3.setText("");
					}
					}else{
						JOptionPane.showMessageDialog(this,"You Can't Fill Whitespace As Topic Name");
						txtt3.grabFocus();
					}
			}
		}
		
	}
}
