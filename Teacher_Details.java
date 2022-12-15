import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;

public class Teacher_Details extends JFrame implements ActionListener{
    Connection cn;
    Statement stmt;
    ResultSet rs;
    String sql="";
    JLabel lblhd,lblpic;
    JTextField txtteacher_id,txtteacher_name,txtmob,txtemail,txttime,txtphoto;
    JButton btnreset, btnsave,btnexit,btnfind,btnpre,btnbrows,btnnext;
    JComboBox cmbtitle,cmbmstatus,cmbgender;
    JPanel panel;
    Container c;
    ImageIcon img;    
    ButtonGroup gender=new ButtonGroup();
    String oldfile; 
    JFileChooser flopen=new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images & PNG Images", "jpg", "gif","png");
    public Teacher_Details() {
        img = new ImageIcon("images/2jb0c3d.jpg", null);
        panel = new JPanel() {
                protected void paintComponent(Graphics g) {
                    g.drawImage(img.getImage(), 0, 0, 750, 550, null);
                    super.paintComponent(g);
                }
            };
        panel.setOpaque(false);
        panel.setPreferredSize(new Dimension(750, 550));
        c = getContentPane();
        panel.setLayout(null);
        c.add(panel);
        lblhd = new JLabel("TEACHER's DETAILS");
        txtteacher_id=new JTextField();
        txtteacher_name=new JTextField();
        cmbgender=new JComboBox();
        cmbgender.addItem("--Select--");
        cmbgender.addItem("Male");
        cmbgender.addItem("Female");
        cmbtitle = new JComboBox();
        cmbtitle.addItem("Mr.");
        cmbtitle.addItem("Mrs.");
        cmbtitle.addItem("Miss.");
        cmbmstatus = new JComboBox();
        cmbmstatus.addItem("--Select--");
        cmbmstatus.addItem("Married");
        cmbmstatus.addItem("Unmarried");
        txtmob=new JTextField();
        txtemail=new JTextField();
        txttime=new JTextField();
        txtphoto=new JTextField();
        lblpic = new JLabel("");
        lblpic.setOpaque(true);
        lblpic.setBackground(Color.WHITE);
        btnreset = new JButton("Reset",new ImageIcon("images/ico1_1.png"));
        btnreset.addActionListener(this);
        btnsave = new JButton("Save",new ImageIcon("images/save3.png"));
        btnsave.addActionListener(this); 
        btnfind = new JButton("Find",new ImageIcon("images/search.png"));
        btnfind.addActionListener(this);
        btnexit = new JButton("Exit", new ImageIcon("images/cn.jpg"));
        btnexit.addActionListener(this);
        btnpre = new JButton("Back", new ImageIcon("images/pre2.png"));
        btnpre.addActionListener(this);
        btnnext = new JButton("Next", new ImageIcon("images/next2.png"));
        btnnext.addActionListener(this);
        btnbrows=new JButton("Browse",new ImageIcon("images/search.png"));
        btnbrows.addActionListener(this);
        try{
      	  Class.forName("com.mysql.jdbc.Driver");
    	      cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_final?characterEncoding=UTF-8","root","");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex.toString());
        }
                        
        addcomp(200, 5, 360, 30, lblhd);
        lblhd.setFont(new Font("COPPERPLATE GOTHIC LIGHT", Font.CENTER_BASELINE, 20));
        addcomp(500, 5, 225, 50, new JLabel(new ImageIcon("images/cim_lbl2.jpg")));
        addcomp(200, 70, 100, 30, new JLabel("Teacher ID"));
        addcomp(340, 70, 100, 30, txtteacher_id);
        addcomp(200, 100, 500, 15, new JLabel("______________________________________________________________________"));
        addcomp(200,125,100,30,new JLabel("Teacher's Name"));
        addcomp(340, 125, 60, 30, cmbtitle);
        addcomp(410, 125, 200, 30,txtteacher_name);
        addcomp(200, 175, 120, 30, new JLabel("Gender"));
        addcomp(340, 175, 100, 25, cmbgender);
        addcomp(200,225,100,30,new JLabel("Marital Status"));
        addcomp(340,225,100,30,cmbmstatus);
        addcomp(200,275,120,30,new JLabel("Teacher's Mobile"));
        addcomp(340,275,120,30,txtmob);
        addcomp(200, 325, 100, 30, new JLabel("Teacher's Email")); 
        addcomp(340,325,200,30,txtemail);
        addcomp(200,375,100,30,new JLabel("Teacher's Time"));
        addcomp(340,375,110,30,txttime);
        addcomp(200,425,100,30,new JLabel("Photo"));
        addcomp(340,425,250,30,txtphoto);
        addcomp(600,425,100,30,btnbrows);
        addcomp(600,315,100,100,lblpic);
        addcomp(200, 455, 500, 15, new JLabel("_______________________________________________________________________"));
        addcomp(253, 480, 90, 30, btnreset);
        addcomp(353, 480, 90, 30, btnsave);
        //addcomp(503, 480, 90, 30, btnnext);
        addcomp(450, 70, 80, 30, btnfind);
        addcomp(453, 480, 90, 30, btnpre);
        addcomp(553,480,90,30,btnexit);
        addcomp(0,0,163,523,new JLabel (new ImageIcon("images/Teacher_side.jpg")));     
        
        setBounds(200, 10, 750, 550);
        setTitle("Teacher's Details Form");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        //setIconImage(Toolkit.getDefaultToolkit().getImage("images/catchpoint.jpg"));
        setIconImage(Toolkit.getDefaultToolkit().getImage("images/catchpoint1.png"));
    }   
    public void addcomp(int x, int y, int w, int h, Component com) {
        com.setBounds(x, y, w, h);
        panel.add(com);
        if(com instanceof JLabel) {
            ((JLabel)com).setForeground(Color.black);
            ((JLabel)com).setFont(new Font("Arial", Font.BOLD,12));
        }
        if (com instanceof JRadioButton) {
            ((JRadioButton)com).setForeground(Color.black);
        }
        if (com instanceof JComboBox) {
            ((JComboBox)com).setForeground(Color.black);
        }
        if (com instanceof JTextField)
        {
            ((JTextField)com).setFont(new Font("Arial", Font.BOLD,12));
        }
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnexit) {
                  dispose();
        }
        if(ae.getSource()==btnbrows){
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
        if (ae.getSource() == btnreset) { 
        		  ImageIcon ico=new ImageIcon();
        		  txtteacher_id.setText("");
            	  txtteacher_name.setText("");
            	  cmbtitle.setSelectedIndex(0);
            	  cmbgender.setSelectedIndex(0);
            	  cmbmstatus.setSelectedIndex(0);
            	  txtmob.setText("");
            	  txtemail.setText("");
            	  txttime.setText("");
            	  txtphoto.setText("");
            	  lblpic.setIcon(ico);
        }
        
        if (ae.getSource() == btnfind) {
                          	  
            	  try {
            		  /*Class.forName("com.mysql.jdbc.Driver");
              	      cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_final?characterEncoding=UTF-8","root","");*/
              		  stmt = cn.createStatement();
                      rs=stmt.executeQuery("select * from teacher_details where Teacher_ID='"+txtteacher_id.getText()+"'");
                      if(rs.next()) { 
                	  	  txtteacher_id.setText(rs.getString("Teacher_ID"));                                	  	  
                		  txtteacher_name.setText(rs.getString("Teacher_Name")); 
                		  cmbgender.setSelectedItem(rs.getString("T_Gender"));
                		  cmbmstatus.setSelectedItem(rs.getString("TM_Status"));
                		  if(rs.getString("T_Gender").equalsIgnoreCase("Male")){
                    		  cmbtitle.setSelectedItem("Mr.");
                    	  }
                    	  else if(rs.getString("T_Gender").equalsIgnoreCase("Female")&&rs.getString("TM_Status").equalsIgnoreCase("Married")){
                    		  cmbtitle.setSelectedItem("Mrs.");
                    	  }
                    	  else if(rs.getString("T_Gender").equalsIgnoreCase("Female")&&rs.getString("TM_Status").equalsIgnoreCase("Unmarried")){
                    		  cmbtitle.setSelectedItem("Miss.");
                    	  }
                		  txtmob.setText(rs.getString("Teacher_Mobile"));
                		  txtemail.setText(rs.getString("Teacher_Email"));
                		  txttime.setText(rs.getString("Teacher_Time"));
                		  
                		  String st="profile_pic\\"+txtteacher_id.getText()+"image.jpg";
                          Toolkit toolkit = Toolkit.getDefaultToolkit();
                          Image image = toolkit.getImage(st);
                          Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
                          ImageIcon icon=new ImageIcon(scaledImage); 
                          lblpic.setIcon(icon);
                          txtphoto.setText(st);

                		  //JOptionPane.showMessageDialog(this,"Record Found,Please Proceed");
               		  /*dispose(); 
               		  new PaperAssign_Details();*/
                		  int t=JOptionPane.showConfirmDialog(this, "Record Found,Do You Want To Fill The Next Form?");
                          if(t==0){
                        	  this.dispose();
                              new Paper_Assignment();
                          }
                          else if(t==1){
                        	  int k=JOptionPane.showConfirmDialog(this, "Do You Want To Enter New Values?");  
                        	  if(k==0){
                        		  reset();
                        	  }
                        	  else if(k==1){
                        		  
                        	  }
                          }
                  }
                  else{
            		  JOptionPane.showMessageDialog(this,"Record Not Found,Please Insert Values");
                  		
                  }
              }
              catch(Exception ex)
              {
                  JOptionPane.showMessageDialog(this,ex.toString());
              } 
                              
              }
		        
		   if(ae.getSource()==btnsave) {
			   ImageIcon iconic=new ImageIcon("images/stat_sys_warning.png");
			   int  x=  JOptionPane.showConfirmDialog(this,"Are You Sure With Your Filled Information?","User Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,iconic);                       
		              /*sql="insert into teacher_details values('"+txtteacher_id.getText()+"','"+txtteacher_name.getText()+"','"+str+"','"+cmbmstatus.getSelectedItem()+"','"+txtmob.getText()+"','"+txtemail.getText()+"','"+txttime.getText()+"','"+txtphoto.getText()+"')";
		              try{
		            	  Class.forName("com.mysql.jdbc.Driver");
		          	      cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_final?characterEncoding=UTF-8","root","");
		            	  File f1=new File(txtphoto.getText());
		                  File f2=new File("D:\\new_android_workspace\\Stud Internal Assess\\src\\profile_pic\\"+txtteacher_id.getText()+".jpg");
		                  filecopy.copyFile(f1, f2);
		                  stmt=cn.createStatement();
		                  stmt.executeUpdate(sql);
		                  JOptionPane.showMessageDialog(this, "Teacher Details Stored");
		              }
		              catch(SQLException sqex){
		                  JOptionPane.showMessageDialog(this,sqex.getMessage().toString(),"Error in SQL Insertion",JOptionPane.ERROR_MESSAGE); 
		              }
		              catch(Exception ex)
		              {
		            	  JOptionPane.showMessageDialog(this,ex.toString());  
		              }
		              ImageIcon ico=new ImageIcon();
	        		  txtteacher_id.setText("");
	        		  cmbtitle.setSelectedIndex(0);
	            	  txtteacher_name.setText("");
	            	  gender.clearSelection();
	            	  cmbmstatus.setSelectedIndex(0);
	            	  txtmob.setText("");
	            	  txtemail.setText("");
	            	  txttime.setText("");
	            	  txtphoto.setText("");
	            	  lblpic.setIcon(ico);
		              
		              this.dispose();
		              new Paper_Details();*/
			 if(x==0){
				 if(txtteacher_id.getText().trim().length()!=0){
				 if(txtteacher_name.getText().trim().length()!=0){
				 if(cmbgender.getSelectedIndex()!=0){
				 if(cmbmstatus.getSelectedIndex()!=0){
				 if(txtmob.getText().trim().length()!=0){
				 if(txtmob.getText().trim().length()==10){
				 if(txtemail.getText().trim().length()!=0){
				 if(txtemail.getText().matches("[a-zA-Z0-9\\.]+@[a-zA-Z0-9\\-\\_\\.]+\\.[a-zA-Z0-9]{3}")){
				 if(txttime.getText().trim().length()!=0){
				 if(txtphoto.getText().trim().length()!=0){
				 try{
		        	File imgfile = new File(txtphoto.getText());
		        	 
		        	 FileInputStream fin = new FileInputStream(imgfile);
		        	 
		        	  PreparedStatement pre =
		        	  cn.prepareStatement("insert into teacher_details values(?,?,?,?,?,?,?,?,?)");
		        	 
		        	  pre.setString(1,txtteacher_id.getText());
		        	  pre.setString(2,txtteacher_name.getText());
		        	  pre.setString(3,(cmbgender.getSelectedItem().toString()));
		        	  pre.setString(4,(cmbmstatus.getSelectedItem()).toString());
		        	  pre.setLong(5,Long.parseLong(txtmob.getText()));
		        	  pre.setString(6,txtemail.getText());
		        	  pre.setString(7,txttime.getText());
		        	  pre.setString(8,txtphoto.getText());
		        	  pre.setBinaryStream(9,(InputStream)fin,(int)imgfile.length());
		        	  pre.executeUpdate();
		        	  //System.out.println("Successfully inserted the file into the database!");
		        	  JOptionPane.showMessageDialog(this, "Teacher Details Stored");
		        	  pre.close();
		        	  //cn.close(); 
		        	}catch (Exception ex){
		        	System.out.println(ex.getMessage());
		        	}		  
		        	try{
		            	stmt=cn.createStatement();
		               	rs = stmt.executeQuery("select img_value from teacher_details where Teacher_ID='"+txtteacher_id.getText()+"'");
		                  int i = 0;
		                  while (rs.next()) {
		                  InputStream in = rs.getBinaryStream(1);
		                  OutputStream f = new FileOutputStream(new File("profile_pic\\"+txtteacher_id.getText()+"image.jpg"));
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
		                  new Paper_Assignment(); 
		              }
			 }else{
					JOptionPane.showMessageDialog(this,"Please Insert Scanned Copy Of Image");
						btnbrows.grabFocus();
					}
			 }else{
				 JOptionPane.showMessageDialog(this,"Please Insert Teacher's Time");
					 txttime.grabFocus();
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
				 JOptionPane.showMessageDialog(this,"Please Insert Valid Mobile Number");
			 txtmob.setText("");
					 txtmob.grabFocus();
				 }
			 }else{
				 JOptionPane.showMessageDialog(this,"Please Insert Mobile Number");
					 txtmob.grabFocus();
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
				 JOptionPane.showMessageDialog(this,"Please Insert Teacher's Name");
					 txtteacher_name.grabFocus();
				 }
			 }else{
				 JOptionPane.showMessageDialog(this,"Please Insert Teacher's ID");
				 txtteacher_id.grabFocus();
			 }
		              
			 }
			 else{}
		          }
		   if(ae.getSource()==btnpre){
			   this.dispose();
			   new Personal_Details();
		   	}
		   /*if (ae.getSource() == btnnext) {
	            this.dispose();
	              new Paper_Assignment();
	          }*/
	 } 
    public void reset(){
      ImageIcon ico=new ImageIcon();
	  txtteacher_id.setText("");
  	  txtteacher_name.setText("");
  	  cmbtitle.setSelectedIndex(0);
  	  cmbgender.setSelectedIndex(0);
  	  cmbmstatus.setSelectedIndex(0);
  	  txtmob.setText("");
  	  txtemail.setText("");
  	  txttime.setText("");
  	  txtphoto.setText("");
  	  lblpic.setIcon(ico);
    }
    public static void main(String[] args) {
        new Teacher_Details();
    }
}
