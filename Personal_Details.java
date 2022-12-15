import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.font.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Personal_Details extends JFrame implements ActionListener,ItemListener {
    Connection cn;
    Statement stmt;
    ResultSet rs;
    String sql = "";
    JTextField txtid,txtroll,txtnem,txtcpin, txtccity, txtctel, txtcmob, txtcstate, txtppin, txtdet, txtpcity, txtpstate, txtptel, txtemail, txtphoto,txtsign,txtmocc,txtfocc,txtgnem, txtmnem;
    JButton btnbrows1, btnbrows2,btncalender,btndo, btnreset, btnsave, btnexit,btnpre,btnfind;
    JTextArea txtcaddr, txtpaddr;
    JLabel lblhead,lbluniv_no,lblcourse_code,lblbatch_code,lbltitle, lblnem,lblpic,lblsign, lblgnem, lblmnem, lbldob, lblgender,lblmstatus, lblrel,lblemail, lblid, lblline,lblfocc,lblmocc;
    JCheckBox chkdo;
    JComboBox cmbtitle, cmbrel, cmbmstatus,cmbuniv_no,cmbcourse_code,cmbbatch_code,cmbgender;
    JPanel panel;
    Container c;
    ImageIcon img;
    String oldfile; 
    JFileChooser flopen=new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images & PNG Images", "jpg", "gif","png");

    public Personal_Details() {
        img = new ImageIcon("images/2jb0c3d.jpg", null);
        panel = new JPanel() {
                protected void paintComponent(Graphics g) {
                    g.drawImage(img.getImage(), 0, 0, 1400, 750, null);
                    super.paintComponent(g);
                }
            };
        panel.setOpaque(false);
        panel.setPreferredSize(new Dimension(1400, 750));
        c = getContentPane();
        panel.setLayout(null);
        c.add(panel);
        lblhead = new JLabel("STUDENT's DETAILS");
        lblhead.setFont(new Font("COPPERPLATE GOTHIC LIGHT", Font.CENTER_BASELINE, 25));
                txtcpin = new JTextField();
                txtccity = new JTextField();
                txtctel = new JTextField();
                txtcmob = new JTextField();
                txtcstate = new JTextField();
                txtppin = new JTextField();
                txtpcity = new JTextField();
                txtpstate = new JTextField();
                txtptel = new JTextField();
                txtemail = new JTextField();
                txtphoto = new JTextField();
                txtsign = new JTextField();
                txtroll=new JTextField();
                chkdo = new JCheckBox("Permanent address is same as correspondence address");
                chkdo.setOpaque(false);
                lblpic = new JLabel("");
                lblpic.setOpaque(true);
                lblpic.setBackground(Color.WHITE);
                lblsign = new JLabel("");
                lblsign.setOpaque(true);
                lblsign.setBackground(Color.WHITE);
                txtcaddr = new JTextArea();
                txtpaddr = new JTextArea();
                txtcstate = new JTextField();
                lblline = new JLabel("____________________________________________________________________________________________________________________________________________");
                lblid = new JLabel("ID No.");
                lbluniv_no=new JLabel("University no.");
                lblcourse_code=new JLabel("Course code");
                lblbatch_code=new JLabel("Batch code");
                lbltitle = new JLabel("Title");
                lblnem = new JLabel("Name");
                lblgnem = new JLabel("Father's/Spouse name");
                lblrel = new JLabel("Relationship");
                lbldob = new JLabel("Date of birth");
                lblgender = new JLabel("Gender");
                lblmocc=new JLabel("Occupation");
                lblfocc=new JLabel("Occupation");
                lblmstatus = new JLabel("Marital status");
                lblemail = new JLabel("Email_id");
                lblmnem = new JLabel("Mother's name");
                txtid = new JTextField();
                txtnem = new JTextField();
                txtgnem = new JTextField();
                txtmnem = new JTextField();
                txtemail = new JTextField();
                txtdet = new JTextField();
                txtmocc=new JTextField();
                txtfocc=new JTextField();
                cmbgender=new JComboBox();
                cmbgender.addItem("--Select--");
                cmbgender.addItem("Male");
                cmbgender.addItem("Female");
                try{
		        	Class.forName("com.mysql.jdbc.Driver");
		    	    cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_final?characterEncoding=UTF-8","root","");
		    		stmt = cn.createStatement();
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(this, ex.toString());
		        }

                cmbuniv_no=new JComboBox();
                cmbuniv_no.addItem("--Select--");
                try{
	                rs=stmt.executeQuery("select Univ_no from university_details order by Univ_no asc");
	                while(rs.next()){
	                cmbuniv_no.addItem(rs.getString("Univ_no"));
                }
                }catch(Exception ex){            
                    JOptionPane.showMessageDialog(this,ex.toString());
            	} 
                cmbcourse_code=new JComboBox();
                cmbcourse_code.addItem("--Select--");
                try{
                	rs=stmt.executeQuery("select Course_Code from course_details order by Course_Code asc");
	                while(rs.next()){
	                cmbcourse_code.addItem(rs.getString("Course_Code"));          
	                }
	           }catch(Exception ex){            
                   JOptionPane.showMessageDialog(this,ex.toString());
	           }	
	                
                cmbbatch_code=new JComboBox();
                cmbbatch_code.addItem("--Select--");
                try{
                	rs=stmt.executeQuery("select Batch_Code from batch_details order by batch_Code asc");
                	while(rs.next()){
                		cmbbatch_code.addItem(rs.getString("Batch_Code"));
                	}
                }catch(Exception ex){            
                    JOptionPane.showMessageDialog(this,ex.toString());
 	            }
                cmbtitle = new JComboBox();
                cmbtitle.addItem("Mr.");
                cmbtitle.addItem("Mrs.");
		        cmbtitle.addItem("Miss.");
		        cmbmstatus = new JComboBox();
		        cmbmstatus.addItem("--Select--");
		        cmbmstatus.addItem("Married");
		        cmbmstatus.addItem("Unmarried");
		        cmbrel = new JComboBox();
		        cmbrel.addItem("--Select--");
		        cmbrel.addItem("Father");
		        cmbrel.addItem("Husband");
		        cmbrel.addItem("Guardian");
		        btnbrows1 = new JButton("Browse", new ImageIcon("images/search.png"));
		        btnbrows1.addActionListener(this);
		        btnbrows2 = new JButton("Browse", new ImageIcon("images/search.png"));
		        btnbrows2.addActionListener(this);
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
		        btncalender=new JButton("", new ImageIcon("images/Calendar.png"));
		        btncalender.addActionListener(this);      
		        txtid.setEditable(true);
		        
		        addcomp(220, 0, 350, 50, lblhead);
		        addcomp(360, 10, 1500, 65, new JLabel(new ImageIcon("images/cim_lbl1_1.jpg")));
		        addcomp(220, 70, 70, 30, lblid);
		        addcomp(350, 70, 150, 30, txtid);
		        addcomp(360, 70, 80, 30, btnfind);
		        addcomp(220, 100, 1200, 25, lblline);
		        addcomp(220, 130, 100, 25, lbluniv_no);
		        addcomp(350, 130, 100, 25, cmbuniv_no);
		        addcomp(220, 170, 100, 25, lblcourse_code);
		        addcomp(350, 170, 100, 25, cmbcourse_code);
		        addcomp(220, 210, 100, 25, lblbatch_code);
		        addcomp(350, 210, 100, 25, cmbbatch_code);
		        addcomp(220, 250, 100, 25, new JLabel("Class Roll"));
		        addcomp(350, 250, 75, 25, txtroll);		        
		        addcomp(220, 290, 100, 25, lblnem);
		        addcomp(350, 290, 60, 25, cmbtitle);
		        addcomp(415, 290, 135, 25, txtnem);
		        addcomp(220, 330, 100, 25, lblgnem);
		        addcomp(350, 330, 200, 25, txtgnem);
		        addcomp(220, 370, 100, 25, lblrel);
		        addcomp(350, 370, 100, 25, cmbrel);
		        addcomp(220, 450, 100, 25, lblmnem);
		        addcomp(350, 450, 200, 25, txtmnem);
		        addcomp(220,410,100,25,lblfocc);
		        addcomp(350,410,150,25,txtfocc);
		        addcomp(220,490,100,25,lblmocc);
		        addcomp(350,490,150,25,txtmocc);
		        addcomp(220,530,100,25,lbldob);
		        addcomp(350, 530, 130, 25, txtdet);
		        addcomp(500, 530, 30, 25, btncalender);
		        addcomp(220, 570, 100, 25, lblgender);
		        addcomp(350, 570, 100, 25, cmbgender);
		        addcomp(220, 610, 100, 25,lblmstatus);
		        addcomp(350, 610, 100, 25,cmbmstatus);
		        addcomp(220, 650, 100, 25, lblemail);
		        addcomp(350, 650, 200, 25, txtemail);
		        addcomp(670, 130, 200, 25, new JLabel("Correspondence Address"));
		        addcomp(670, 155, 530, 40, txtcaddr);
		        addcomp(670, 210, 100, 25, new JLabel("Pincode"));
		        addcomp(800, 210, 100, 25, txtcpin);
		        addcomp(670, 260, 100, 25, new JLabel("City"));
		        addcomp(800, 260, 100, 25, txtccity);
		        addcomp(930, 260, 100, 25, new JLabel("State"));
		        addcomp(1050, 260, 100, 25, txtcstate);
		        addcomp(670, 305, 100, 25, new JLabel("Telephone No."));
		        addcomp(800, 305, 100, 25, txtctel);
		        addcomp(930, 305, 100, 25, new JLabel("Mobile no."));
		        addcomp(1050, 305, 100, 25, txtcmob);
		        addcomp(670,350,350,25,chkdo);chkdo.addItemListener(this);
		        addcomp(670, 380, 200, 25, new JLabel("Permanent Address"));
		        addcomp(670, 405, 530, 40, txtpaddr);
		        addcomp(670, 465, 100, 25, new JLabel("Pincode"));
		        addcomp(800, 465, 100, 25, txtppin);
		        addcomp(670, 510, 100, 25, new JLabel("State"));
		        addcomp(800, 510, 100, 25, txtpstate);
		        addcomp(930, 465, 100, 25, new JLabel("City"));
		        addcomp(1050, 465, 100, 25, txtpcity);
		        addcomp(670, 555, 100, 25, new JLabel("Telephone no."));
		        addcomp(800, 555, 100, 25, txtptel);
		        addcomp(670, 620, 100, 25, new JLabel("Photo"));
		        addcomp(800, 620, 270, 25, txtphoto);
		        addcomp(1090, 620, 100, 25, btnbrows1);
		        addcomp(970, 510, 100, 100,lblpic);
		        addcomp(1090, 510, 100, 100,lblsign);
		        addcomp(670, 655, 100, 25, new JLabel("Signature"));
		        addcomp(800, 655, 270, 25, txtsign);
		        addcomp(1090, 655, 100, 25, btnbrows2);
		        addcomp(220, 680, 1200, 15, new JLabel("___________________________________________________________________________________________________________________________________________"));
		        addcomp(800, 705, 90, 30, btnreset);
		        addcomp(900, 705, 90, 30, btnsave);
		        addcomp(1000, 705, 90, 30, btnpre);
		        addcomp(1100, 705, 90, 30, btnexit);
		        addcomp(510, 70, 80, 30,btnfind);
		        addcomp(00, 00, 200, 740, new JLabel(new ImageIcon("images/stud_side.jpg")));
		       

        setBounds(0, 0, 1367, 780);
        setTitle("Student's Details Form");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        //setIconImage(Toolkit.getDefaultToolkit().getImage("images/catchpoint.jpg"));
        setIconImage(Toolkit.getDefaultToolkit().getImage("images/catchpoint1.png"));
    }

    public void itemStateChanged(ItemEvent ie) {
        if(ie.getSource()==chkdo) {
            if(chkdo.isSelected()) {
                txtpaddr.setText(txtcaddr.getText());
                txtpcity.setText(txtccity.getText());
                txtppin.setText(txtcpin.getText());
                txtpstate.setText(txtcstate.getText());
                txtptel.setText(txtctel.getText());
            }
            if(chkdo.isSelected()==false) {
            	txtpaddr.setText("");
                txtpcity.setText("");
                txtppin.setText("");
                txtpstate.setText("");
                txtptel.setText("");
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
        if (com instanceof JRadioButton) {
            ((JRadioButton)com).setForeground(Color.black);
        }
      
        if (com instanceof JCheckBox)
        {
            ((JCheckBox)com).setForeground(Color.black);
        }
        if (com instanceof JTextField)
        {
            ((JTextField)com).setFont(new Font("Arial", Font.BOLD,12));
        }
        if (com instanceof JTextArea)
        {
            ((JTextArea)com).setFont(new Font("Arial", Font.BOLD,12));
        }
    }


    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==btncalender){
            txtdet.setText(new DatePicker(this).setPickedDate());
        }
        if(ae.getSource()==btnbrows1){
            flopen.setFileFilter(filter);
            int returnVal = flopen.showOpenDialog(this);
               if(returnVal == JFileChooser.APPROVE_OPTION) {
                   oldfile = flopen.getSelectedFile().getAbsolutePath();
                   String oname=flopen.getName();
                   Toolkit toolkit = Toolkit.getDefaultToolkit();
                   Image image = toolkit.getImage(oldfile);
                   Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
                   ImageIcon icon=new ImageIcon(scaledImage); 
                   lblpic.setIcon(icon);
                   txtphoto.setText(oldfile);
                   //JOptionPane.showMessageDialog(this,"You chose to open this file: " +flopen.getSelectedFile());
                   
               }
        }
        if(ae.getSource()==btnbrows2){
            flopen.setFileFilter(filter);
            int returnVal = flopen.showOpenDialog(this);
               if(returnVal == JFileChooser.APPROVE_OPTION) {
                   oldfile = flopen.getSelectedFile().getAbsolutePath();
                   String oname=flopen.getName();
                   Toolkit toolkit = Toolkit.getDefaultToolkit();
                   Image image = toolkit.getImage(oldfile);
                   Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
                   ImageIcon icon=new ImageIcon(scaledImage);
                   lblsign.setIcon(icon);
                   txtsign.setText(oldfile);
              //   JOptionPane.showMessageDialog(this,"You chose to open this file: " +flopen.getSelectedFile());
               }
        }
       
        if (ae.getSource() == btnreset) {
            ImageIcon ico1=new ImageIcon(); 
            ImageIcon ico=new ImageIcon(); 
            txtcpin.setText("");
            txtccity.setText("");
            txtctel.setText("");
            txtcmob.setText("");
            txtcstate.setText("");
            txtppin.setText("");
            txtdet.setText("");
            txtpcity.setText("");
            txtpstate.setText("");
            txtptel.setText("");
            txtemail.setText("");
            txtphoto.setText("");
            txtsign.setText("");
            txtnem.setText("");
            txtgnem.setText("");
            txtmnem.setText("");
            txtmocc.setText("");
            txtemail.setText("");
            txtmocc.setText("");
            txtfocc.setText("");
            txtid.setText("");
            txtcaddr.setText("");
            txtpaddr.setText("");
            txtroll.setText("");
            cmbgender.setSelectedIndex(0);
            cmbuniv_no.setSelectedIndex(0);
            cmbcourse_code.setSelectedIndex(0);
            cmbbatch_code.setSelectedIndex(0);
            cmbtitle.setSelectedIndex(0);
            cmbrel.setSelectedIndex(0);
            cmbmstatus.setSelectedIndex(0);
            lblsign.setIcon(ico1);           
            lblpic.setIcon(ico);
        }
        if (ae.getSource() == btnexit) {
            dispose();
        }
       
        if(ae.getSource()==btnfind){
        	try{
        		stmt=cn.createStatement();
        		rs=stmt.executeQuery("select * from student_details where Sid='"+txtid.getText()+"'");
        		if(rs.next()){
        			txtid.setText(rs.getString("Sid"));
        			cmbuniv_no.setSelectedItem(rs.getString("Univ_no"));
        			cmbcourse_code.setSelectedItem(rs.getString("Course_Code"));
        			cmbbatch_code.setSelectedItem(rs.getString("Batch_Code"));
        			txtroll.setText(rs.getString("roll"));
        			txtnem.setText(rs.getString("Student_Name"));
        			txtgnem.setText(rs.getString("Guardian_Name"));
        			cmbrel.setSelectedItem(rs.getString("Relation"));
        			txtfocc.setText(rs.getString("Guardian_Occup"));
        			txtmnem.setText(rs.getString("Mother_Name"));
        			txtmocc.setText(rs.getString("Mother_Occup"));
        			txtdet.setText(rs.getString("Dob"));
        			cmbgender.setSelectedItem(rs.getString("Gender"));
        			cmbmstatus.setSelectedItem(rs.getString("M_Status"));

          		  if(rs.getString("Gender").equalsIgnoreCase("Male")){
            		  cmbtitle.setSelectedItem("Mr.");
            	  }
            	  else if(rs.getString("Gender").equalsIgnoreCase("Female")&&rs.getString("M_Status").equalsIgnoreCase("Unmarried")){
            		  cmbtitle.setSelectedItem("Miss.");
            	  }
            	  else if(rs.getString("Gender").equalsIgnoreCase("Female")&&rs.getString("M_Status").equalsIgnoreCase("Married")){
            		  cmbtitle.setSelectedItem("Mrs.");
            	  }
          		  	
          		  	txtemail.setText(rs.getString("Email"));
          		  	txtcaddr.setText(rs.getString("Caddress"));
          		  	txtcpin.setText(rs.getString("Cpin"));
          		  	txtccity.setText(rs.getString("Ccity"));
          		  	txtcstate.setText(rs.getString("Cstate"));
          		  	txtctel.setText(rs.getString("Ctelno"));
          		  	txtcmob.setText(rs.getString("Cmobno"));          		  	
          		  	txtpaddr.setText(rs.getString("Paddress"));
        		  	txtppin.setText(rs.getString("Ppin"));
        		  	txtpcity.setText(rs.getString("Pcity"));
        		  	txtpstate.setText(rs.getString("Pstate"));
        		  	txtptel.setText(rs.getString("Ptelno"));
        		  	
        		  	String str="profile_pic\\"+txtid.getText()+"img.jpg";
                    Toolkit toolkit = Toolkit.getDefaultToolkit();
                    Image image = toolkit.getImage(str);
                    Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
                    ImageIcon icon=new ImageIcon(scaledImage); 
                    lblpic.setIcon(icon);
                    txtphoto.setText(str);
                    
                    String str1="profile_pic\\"+txtid.getText()+"sign.jpg";
                    Toolkit toolkit1 = Toolkit.getDefaultToolkit();
                    Image image1 = toolkit1.getImage(str1);
                    Image scaledImage1 = image1.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
                    ImageIcon icon1=new ImageIcon(scaledImage1); 
                    lblsign.setIcon(icon1);
                    txtsign.setText(str1);
          		  
                  /*JOptionPane.showMessageDialog(this,"Record Found,Please Fill The Next Form");
         		  dispose();  
         		  new Teacher_Details();*/
          		  int t=JOptionPane.showConfirmDialog(this, "Record Found,Do You Want To Fill The Next Form?");
                  if(t==0){
                  	this.dispose();
                      new Teacher_Details();
                  }
                  else if(t==1){
                  	int k=JOptionPane.showConfirmDialog(this, "Do You Want To Enter New Values?");  
                	  	if(k==0){
                		  reset();
                	  	}	
                	  	else if(k==1){
                		  
                	  	}
                  }
        		}else
            	  JOptionPane.showMessageDialog(this,"Record Not Found,Please Insert Values");
            	}catch(Exception ex){            
            	  JOptionPane.showMessageDialog(this,ex.toString());
            	} 
    }

        if (ae.getSource() == btnsave) {
            /*sql ="insert into student_details values('" + txtid.getText() + "','"+cmbuniv_no.getSelectedItem()+"','" +cmbcourse_code.getSelectedItem()+"','"+cmbbatch_code.getSelectedItem()+"','"+txtroll.getText()+"','"+txtnem.getText() +
            "','"+txtgnem.getText()+"','"+cmbrel.getSelectedItem()+"','"+txtfocc.getText()+"','"+txtmnem.getText()+"','" +txtmocc.getText()+"','"+ txtdet.getText() + "','" + gender + "','" +
            cmbmstatus.getSelectedItem() + "','" +txtemail.getText()+"','" +txtcaddr.getText() +
            "','" + txtcpin.getText() + "','" + txtccity.getText() + "','" + txtcstate.getText() + "','" + txtctel.getText() +
            "','" + txtcmob.getText() + "','" + txtpaddr.getText() + "','" + txtppin.getText() + "','" + txtpcity.getText() +
            "','" + txtpstate.getText() + "','" + txtptel.getText() + "','" +txtphoto.getText()+"','"+txtsign.getText() + "')";
            try {
            	File f1=new File(txtphoto.getText());
                File f2=new File("D:\\new_android_workspace\\Stud Internal Assess\\src\\profile_pic\\"+txtid.getText()+".jpg");
                filecopy.copyFile(f1, f2);
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(this, "Personal Details Stored");
            } catch (SQLException sqex) {
                JOptionPane.showMessageDialog(this, sqex.getMessage().toString(), "Error in SQL Insertion",
                                              JOptionPane.ERROR_MESSAGE);
            }catch(Exception e){}*/
            /*dispose();
            new Teacher_Details();*/
        	ImageIcon iconic=new ImageIcon("images/stat_sys_warning.png");
			int  x=  JOptionPane.showConfirmDialog(this,"Are You Sure With Your Filled Information?","User Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,iconic);
			if(x==0){
				if(txtid.getText().trim().length()!=0){
				if(txtid.getText().trim().length()<=5){
				if(cmbuniv_no.getSelectedIndex()!=0){
				if(cmbcourse_code.getSelectedIndex()!=0){
				if(cmbbatch_code.getSelectedIndex()!=0){
				if(txtroll.getText().trim().length()!=0){
				if(Integer.valueOf(txtroll.getText())>0&&Integer.valueOf(txtroll.getText())<=110){
				if(txtnem.getText().trim().length()!=0){
				if(txtgnem.getText().trim().length()!=0){
				if(cmbrel.getSelectedIndex()!=0){
				if(txtfocc.getText().trim().length()!=0){
				if(txtmnem.getText().trim().length()!=0){
				if(txtmocc.getText().trim().length()!=0){
				if(txtdet.getText().trim().length()!=0){
				if(cmbgender.getSelectedIndex()!=0){
				if(cmbmstatus.getSelectedIndex()!=0){
				if(txtemail.getText().trim().length()!=0){
				if(txtemail.getText().matches("[a-zA-Z0-9\\.]+@[a-zA-Z0-9\\-\\_\\.]+\\.[a-zA-Z0-9]{3}")){
				if(txtcaddr.getText().trim().length()!=0){
				if(txtcpin.getText().trim().length()!=0){
			    if(txtcpin.getText().trim().length()==6){
			    if(txtccity.getText().trim().length()!=0){
				if(txtcstate.getText().trim().length()!=0){
				if(txtctel.getText().trim().length()!=0){
				if(txtctel.getText().trim().length()<15){
				if(txtcmob.getText().trim().length()!=0){
				if(txtcmob.getText().trim().length()==10){
				if(txtpaddr.getText().trim().length()!=0){
				if(txtppin.getText().trim().length()!=0){
				if(txtppin.getText().trim().length()==6){
	    		if(txtpcity.getText().trim().length()!=0){
				if(txtpstate.getText().trim().length()!=0){
				if(txtptel.getText().trim().length()!=0){
		    	if(txtptel.getText().trim().length()<15){
				if(txtphoto.getText().trim().length()!=0){
			    if(txtsign.getText().trim().length()!=0){

					try{
		        	File imgfile = new File(txtphoto.getText());
		        	File imgfile1=new File(txtsign.getText());
		        	 
		        	 FileInputStream fin = new FileInputStream(imgfile);
		        	 FileInputStream fin1 = new FileInputStream(imgfile1);
		        	 
		        	  PreparedStatement pre =
		        	  cn.prepareStatement("insert into student_details values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		        	 
		        	  pre.setString(1,txtid.getText());
		        	  pre.setString(2,(cmbuniv_no.getSelectedItem()).toString());
		        	  pre.setString(3,(cmbcourse_code.getSelectedItem()).toString());
		        	  pre.setString(4,(cmbbatch_code.getSelectedItem()).toString());
		        	  pre.setInt(5,Integer.parseInt(txtroll.getText()));
		        	  pre.setString(6,txtnem.getText());
		        	  pre.setString(7,txtgnem.getText());
		        	  pre.setString(8,(cmbrel.getSelectedItem()).toString());
		        	  pre.setString(9,txtfocc.getText());
		        	  pre.setString(10,txtmnem.getText());
		        	  pre.setString(11,txtmocc.getText());
		        	  pre.setString(12,txtdet.getText());
		        	  pre.setString(13,(cmbgender.getSelectedItem()).toString());
		        	  pre.setString(14,(cmbmstatus.getSelectedItem()).toString());
		        	  pre.setString(15,txtemail.getText());
		        	  pre.setString(16,txtcaddr.getText());
		        	  pre.setString(17,txtcpin.getText());
		        	  pre.setString(18,txtccity.getText());
		        	  pre.setString(19,txtcstate.getText());
		        	  pre.setString(20,txtctel.getText());
		        	  pre.setLong(21,Long.parseLong(txtcmob.getText()));
		        	  pre.setString(22,txtpaddr.getText());
		        	  pre.setString(23,txtppin.getText());
		        	  pre.setString(24,txtpcity.getText());
		        	  pre.setString(25,txtpstate.getText());
		        	  pre.setString(26,txtptel.getText());
		        	  pre.setString(27,txtphoto.getText());
		        	  pre.setBinaryStream(28,(InputStream)fin,(int)imgfile.length());
		        	  pre.setString(29,txtsign.getText());
		        	  pre.setBinaryStream(30,(InputStream)fin1,(int)imgfile1.length());
		        	  pre.executeUpdate();
		        	  //System.out.println("Successfully inserted the file into the database!");
		        	  JOptionPane.showMessageDialog(this, "Personal Details Stored");
		        	  pre.close();
		        	  //cn.close(); 
		        	}catch (Exception ex){
		        	System.out.println(ex.getMessage());
		        	}
		        	try{
		        	stmt=cn.createStatement();
		           	rs = stmt.executeQuery("select img_val from student_details where Sid='"+txtid.getText()+"'");
		              int i = 0;
		              while (rs.next()) {
		              InputStream in = rs.getBinaryStream(1);
		              OutputStream f = new FileOutputStream(new File("profile_pic\\"+txtid.getText()+"img.jpg"));
		              i++;
		              int c = 0;
		              while ((c = in.read()) > -1) {
		              f.write(c);
		              }
		              f.close();
		              in.close();
		              }
		              }catch(Exception ex){
		              System.out.println(ex.getMessage());
		            }
		              try{
		              	stmt=cn.createStatement();
		                 	rs = stmt.executeQuery("select img_val1 from student_details where Sid='"+txtid.getText()+"'");
		                    int i = 0;
		                    while (rs.next()) {
		                    InputStream in = rs.getBinaryStream(1);
		                    OutputStream f = new FileOutputStream(new File("profile_pic\\"+txtid.getText()+"sign.jpg"));
		                    i++;
		                    int c = 0;
		                    while ((c = in.read()) > -1) {
		                    f.write(c);
		                    }
		                    f.close();
		                    in.close();
		                    }
		                    }catch(Exception ex){
		                    System.out.println(ex.getMessage());
		                  }
		            int t=JOptionPane.showConfirmDialog(this, "Do You Want To Enter More Values?");
		            if(t==0){
		          	  reset();
		            }
		            else if(t==1){
		            	this.dispose();
		                new Teacher_Details(); 
		            }
				}else{
					JOptionPane.showMessageDialog(this,"Please Insert Scanned Image Of Sign");
						btnbrows2.grabFocus();
					}
				}else{
					JOptionPane.showMessageDialog(this,"Please Insert Scanned Copy Of Image");
						btnbrows1.grabFocus();
					}
				}else{
					JOptionPane.showMessageDialog(this,"Please Insert Valid Telephone Number");
						txtptel.setText("");
						txtptel.grabFocus();
					}		            
				}else{
					JOptionPane.showMessageDialog(this,"Please Insert Telephone Number");
						txtptel.grabFocus();
					}			            
				}else{
					JOptionPane.showMessageDialog(this,"Please Insert State Name");
						txtpstate.grabFocus();
					}				            
				}else{
					JOptionPane.showMessageDialog(this,"Please Insert City Name");
						txtpcity.grabFocus();
					}					            
				}else{
					JOptionPane.showMessageDialog(this,"Please Insert Valid Pincode");
						txtppin.setText("");
						txtppin.grabFocus();
					}						            
				}else{
					JOptionPane.showMessageDialog(this,"Please Insert Pincode");
						txtppin.grabFocus();
					}							            
				}else{
					JOptionPane.showMessageDialog(this,"Please Insert Permanent Address");
						txtpaddr.grabFocus();
					}
				}else{
					JOptionPane.showMessageDialog(this,"Please Insert Valid Mobile Number");
						txtcmob.setText("");
						txtcmob.grabFocus();
					}
				}else{
					JOptionPane.showMessageDialog(this,"Please Insert Mobile Number");
						txtcmob.grabFocus();
					}										            
				}else{
					JOptionPane.showMessageDialog(this,"Please Insert Valid Telephone Number");
						txtctel.setText("");
						txtctel.grabFocus();
					}											            
				}else{
					JOptionPane.showMessageDialog(this,"Please Insert Telephone Number");
						txtctel.grabFocus();
					}												            
				}else{
					JOptionPane.showMessageDialog(this,"Please Insert State Name");
						txtcstate.grabFocus();
					}													            
				}else{
					JOptionPane.showMessageDialog(this,"Please Insert City Name");
						txtccity.grabFocus();
					}														            
				}else{
					JOptionPane.showMessageDialog(this,"Please Insert Valid Pincode");
						txtcpin.setText("");
						txtcpin.grabFocus();
					}
				}else{
					JOptionPane.showMessageDialog(this,"Please Insert Pincode");
						txtcpin.grabFocus();
					}
				}else{
					JOptionPane.showMessageDialog(this,"Please Insert Correspondence Address");
						txtcaddr.grabFocus();
					}																            
				}else{
					JOptionPane.showMessageDialog(this,"Please Insert Valid Email");
						txtemail.setText("");
						txtemail.grabFocus();
					}																	            
				}else{
					JOptionPane.showMessageDialog(this,"Please Insert Email Address");
						txtemail.grabFocus();
					}																		            
				}else{
					JOptionPane.showMessageDialog(this,"Please Select Marital Status");
						cmbmstatus.grabFocus();
					}																			            
				}else{
					JOptionPane.showMessageDialog(this,"Please Select Gender");
						cmbgender.grabFocus();
					}																				            
				}else{
					JOptionPane.showMessageDialog(this,"Please Insert Date of Birth");
						txtdet.grabFocus();
					}																					            
				}else{
					JOptionPane.showMessageDialog(this,"Please Insert Mother's Occupation");
						txtmocc.grabFocus();
					}																						            
				}else{
					JOptionPane.showMessageDialog(this,"Please Insert Mother's Name");
						txtmnem.grabFocus();
					}																							            
				}else{
					JOptionPane.showMessageDialog(this,"Please Insert Father's Occupation");
						txtfocc.grabFocus();
					}																								            
				}else{
					JOptionPane.showMessageDialog(this, "Please Select Relationship");
						cmbrel.grabFocus();
					}
				}else{
					JOptionPane.showMessageDialog(this,"Please Insert Father's/Guardian Name");
						txtgnem.grabFocus();
					}
				}else{
					JOptionPane.showMessageDialog(this,"Please Insert Student's Name");
						txtnem.grabFocus();
					}
				}else{
					JOptionPane.showMessageDialog(this,"Please Insert Valid Roll Number");
						txtroll.setText("");
						txtroll.grabFocus();
				}
				}
				else{
					JOptionPane.showMessageDialog(this,"Please Insert Roll Number");
						txtroll.grabFocus();
					}																												            
				}else{
					JOptionPane.showMessageDialog(this,"Please Select Batch Code");
						cmbbatch_code.grabFocus();
					}																													            
				}else{
					JOptionPane.showMessageDialog(this,"Please Select Course Code");
						cmbcourse_code.grabFocus();
					}																														            
				}else{
					JOptionPane.showMessageDialog(this,"Please Select University Number");
						cmbuniv_no.grabFocus();
					}																															            
				}
				else{
					JOptionPane.showMessageDialog(this,"Please Insert Valid ID");
						txtid.setText("");
						txtid.grabFocus();
					}
				}
				else{
					JOptionPane.showMessageDialog(this,"Please Insert Student's ID");
						txtid.setText("");
				}		            
			}else{}
        }
       if(ae.getSource()==btnpre){
    	   this.dispose();
    	   new Paper_Details1();
       }
    }
    public void reset(){
    	ImageIcon ico1=new ImageIcon(); 
        ImageIcon ico=new ImageIcon(); 
        txtcpin.setText("");
        txtccity.setText("");
        txtctel.setText("");
        txtcmob.setText("");
        txtcstate.setText("");
        txtppin.setText("");
        txtdet.setText("");
        txtpcity.setText("");
        txtpstate.setText("");
        txtptel.setText("");
        txtemail.setText("");
        txtphoto.setText("");
        txtsign.setText("");
        txtnem.setText("");
        txtgnem.setText("");
        txtmnem.setText("");
        txtmocc.setText("");
        txtemail.setText("");
        txtmocc.setText("");
        txtfocc.setText("");
        txtid.setText("");
        txtcaddr.setText("");
        txtpaddr.setText("");
        txtroll.setText("");
        cmbgender.setSelectedIndex(0);
        cmbuniv_no.setSelectedIndex(0);
        cmbcourse_code.setSelectedIndex(0);
        cmbbatch_code.setSelectedIndex(0);
        cmbtitle.setSelectedIndex(0);
        cmbrel.setSelectedIndex(0);
        cmbmstatus.setSelectedIndex(0);
        lblsign.setIcon(ico1);
        lblpic.setIcon(ico);
    }
    public static void main(String[] args) {
        new Personal_Details();
    }
}
