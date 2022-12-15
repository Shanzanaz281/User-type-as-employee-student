import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Course_Details extends JFrame implements ActionListener{
    Connection cn;
    Statement stmt;
    ResultSet rs;
    String sql="";
    JLabel lblhd;
    JTextField txtcourse_code,txtcourse_name;
    JButton btnreset, btnsave,btnexit,btnfind,btnpre;
    JComboBox cmbtotal,cmbuniv_no,cmbmode;
    JPanel panel;
    Container c;
    ImageIcon img;

    public Course_Details() {
        img = new ImageIcon("images/2jb0c3d.jpg", null);
        panel = new JPanel() {
                protected void paintComponent(Graphics g) {
                    g.drawImage(img.getImage(), 0, 0, 750, 450, null);
                    super.paintComponent(g);
                }
            };
        panel.setOpaque(false);
        panel.setPreferredSize(new Dimension(750, 450));
        c = getContentPane();
        panel.setLayout(null);
        c.add(panel);
        lblhd = new JLabel("COURSE DETAILS");
        txtcourse_code=new JTextField();
        txtcourse_name=new JTextField(); 
        cmbmode=new JComboBox();
        cmbmode.addItem("--Select--");
        cmbmode.addItem("SEMESTER");
        cmbmode.addItem("YEAR");
        cmbtotal=new JComboBox();
        cmbtotal.addItem("--Select--");
        cmbtotal.addItem("1");
        cmbtotal.addItem("2");
        cmbtotal.addItem("3");               
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
                
        try{
  		  Class.forName("com.mysql.jdbc.Driver");
    	      cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_final?characterEncoding=UTF-8","root","");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex.toString());
        	} 
        cmbuniv_no=new JComboBox();
        cmbuniv_no.addItem("--Select--");
        try{
        	stmt = cn.createStatement();
        	rs=stmt.executeQuery("select Univ_no from university_details order by Univ_no asc");
            while(rs.next()){
            cmbuniv_no.addItem(rs.getString("Univ_no"));
            }
        }catch(Exception ex){            
            JOptionPane.showMessageDialog(this,ex.toString());
         }
        addcomp(200, 5, 360, 30, lblhd);
        lblhd.setFont(new Font("COPPERPLATE GOTHIC LIGHT", Font.CENTER_BASELINE, 20));
        addcomp(500, 5, 225, 50, new JLabel(new ImageIcon("images/cim_lbl2.jpg")));
        addcomp(200, 70, 100, 30, new JLabel("Course Code"));
        addcomp(340, 70, 100, 30, txtcourse_code);
        addcomp(200, 120, 120, 30, new JLabel("University Number"));
        addcomp(340, 120, 100, 30,cmbuniv_no);
        addcomp(200, 160, 410, 15, new JLabel("_________________________________________________________"));
        addcomp(200, 195, 100, 30, new JLabel("Course Name"));
        addcomp(340, 195, 200, 30,txtcourse_name);               
        addcomp(200, 243, 100, 30, new JLabel("Course Mode"));    
        addcomp(340, 245, 100, 25, cmbmode);
        addcomp(200,288,100,30,new JLabel("Total Year"));
        addcomp(340,290,100,25,cmbtotal);
        addcomp(200, 330, 410, 15, new JLabel("_________________________________________________________"));
        addcomp(204, 365, 90, 30, btnreset);
        addcomp(304, 365, 90, 30, btnsave);
        addcomp(404, 365, 90, 30, btnpre);
        addcomp(450, 70, 80, 30, btnfind);
        addcomp(504, 365, 90, 30, btnexit);
        addcomp(0,0,163,421,new JLabel (new ImageIcon("images/edit1_new.jpg"))); 
        
        setBounds(200, 10, 750, 450);
        setTitle("Course Details Form");
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
        if(com instanceof JComboBox) {
            ((JComboBox)com).setForeground(Color.black);
        }
        if(com instanceof Checkbox) {
            ((Checkbox)com).setForeground(Color.black);
        }
        if (com instanceof JRadioButton) {
            ((JRadioButton)com).setForeground(Color.black);
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
              if (ae.getSource() == btnreset) {
            	  txtcourse_code.setText("");
            	  txtcourse_name.setText("");
            	  cmbmode.setSelectedIndex(0);
            	  cmbtotal.setSelectedIndex(0);
            	  cmbuniv_no.setSelectedIndex(0);
              }
              if (ae.getSource() == btnfind) {
                          	  
            	  try {
              		  stmt = cn.createStatement();
                         rs=stmt.executeQuery("select * from course_details where Course_Code='"+txtcourse_code.getText()+"'");
                         if(rs.next()) { 
                          txtcourse_code.setText(rs.getString("Course_Code"));
                          cmbuniv_no.setSelectedItem(rs.getString("Univ_no"));
                          txtcourse_name.setText(rs.getString("Course_Name"));
                		  cmbmode.setSelectedItem(rs.getString("Course_Mode"));
                		  cmbtotal.setSelectedItem(rs.getString("Total_Year"));
                		  
               		  /*JOptionPane.showMessageDialog(this,"Record Found,Please Fill The Next Form");
               		  dispose();  
               		  new Batch_Details();*/
                		  int t=JOptionPane.showConfirmDialog(this, "Record Found,Do You Want To Fill Next Form?");
                          if(t==0){
                        	  this.dispose();
                              new Batch_Details();
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
                  else
            		  JOptionPane.showMessageDialog(this,"Record Not Found,Please Insert Values");
              }
              catch(Exception ex)
              {
                  JOptionPane.showMessageDialog(this,ex.toString());
              } 
              }
        
   if(ae.getSource()==btnsave) {
	   ImageIcon iconic=new ImageIcon("images/stat_sys_warning.png");
		 int  x=  JOptionPane.showConfirmDialog(this,"Are You Sure With Your Filled Information?","User Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,iconic);
		 if(x==0){
			 if(txtcourse_code.getText().trim().length()!=0){
			 if(cmbuniv_no.getSelectedIndex()!=0){
			 if(txtcourse_name.getText().trim().length()!=0){
		     if(cmbmode.getSelectedIndex()!=0){    
			 if(cmbtotal.getSelectedIndex()!=0){						 
			 sql="insert into course_details values('"+txtcourse_code.getText()+"','"+cmbuniv_no.getSelectedItem()+"','"+txtcourse_name.getText()+"','"+cmbmode.getSelectedItem()+"','"+cmbtotal.getSelectedItem()+"')";
			 try{
                  stmt=cn.createStatement();
                  stmt.executeUpdate(sql);
                  JOptionPane.showMessageDialog(this, "Course Details Stored");
              }
              catch(SQLException sqex){
                  JOptionPane.showMessageDialog(this,sqex.getMessage().toString(),"Error in SQL Insertion",JOptionPane.ERROR_MESSAGE); 
              }
              int t=JOptionPane.showConfirmDialog(this, "Do You Want To Enter More Values?");
              if(t==0){
            	  reset();
              }
              else if(t==1){
            	  this.dispose();
                  new Batch_Details(); 
              }
              /*this.dispose();
              new Batch_Details();*/
	        }else{
	        	JOptionPane.showMessageDialog(this,"Please Select The Total Year");
	        	cmbtotal.setSelectedIndex(0);
	        	cmbtotal.grabFocus();
	        }
	        }else{
        		JOptionPane.showMessageDialog(this,"Please Select The Course Mode");
        		cmbmode.setSelectedIndex(0);
        		cmbmode.grabFocus();
        	}
		    }else{
			    JOptionPane.showMessageDialog(this,"Please Insert The Course Name");
    		    txtcourse_name.grabFocus();
		    }
	        }else{
		        JOptionPane.showMessageDialog(this,"Please Select The University Number");
		        cmbuniv_no.setSelectedIndex(0);
		        cmbuniv_no.grabFocus();
	        } 	 
            }else{
	            JOptionPane.showMessageDialog(this,"Please Insert The Course Code");
		        txtcourse_code.grabFocus();
	        }			        	         	 
         }else{}
     }
   if(ae.getSource()==btnpre){
	   this.dispose();
	   new University_Details();
   	}
   } 
    public void reset(){
      txtcourse_code.setText("");
  	  txtcourse_name.setText("");
  	  cmbmode.setSelectedIndex(0);
  	  cmbtotal.setSelectedIndex(0);
  	  cmbuniv_no.setSelectedIndex(0);
    }
 public static void main(String[] args) {
        new Course_Details();
    }
}
