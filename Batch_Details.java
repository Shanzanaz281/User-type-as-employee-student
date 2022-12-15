import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Batch_Details extends JFrame implements ActionListener{
    Connection cn;
    Statement stmt;
    ResultSet rs;
    String sql="";
    JLabel lblhd;
    JTextField txtbatch_code,txtbatch_name;
    JButton btnreset, btnsave,btnexit,btnfind,btnpre;  
    JComboBox cmbuniv_no,cmbcourse_code,cmbplan;
    JPanel panel;
    Container c;
    ImageIcon img;    
    
    public Batch_Details() {
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
        lblhd = new JLabel("BATCH DETAILS");
        txtbatch_code=new JTextField();
        txtbatch_name=new JTextField(); 
        cmbplan=new JComboBox();
        cmbplan.addItem("--Select--");
        cmbplan.addItem("PREMIUM");
        cmbplan.addItem("NORMAL");
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
        cmbcourse_code=new JComboBox();
        cmbcourse_code.addItem("--Select--");
        try{
        	stmt = cn.createStatement();
        	rs=stmt.executeQuery("select Course_Code from course_details order by Course_Code asc");
            while(rs.next()){
            cmbcourse_code.addItem(rs.getString("Course_Code"));
            }
        }catch(Exception ex){            
            JOptionPane.showMessageDialog(this,ex.toString());
        }
                        
        addcomp(200, 5, 360, 30, lblhd);
        lblhd.setFont(new Font("COPPERPLATE GOTHIC LIGHT", Font.CENTER_BASELINE, 20));
        addcomp(500, 5, 225, 50, new JLabel(new ImageIcon("images/cim_lbl2.jpg")));
        addcomp(200, 70, 100, 30, new JLabel("Batch Code"));
        addcomp(340, 70, 100, 30, txtbatch_code);
        addcomp(200, 110, 410, 15, new JLabel("_________________________________________________________"));
        addcomp(200,145,100,30,new JLabel("Course Code"));
        addcomp(340,145,100,30,cmbcourse_code);
        addcomp(200, 195, 120, 30, new JLabel("University Number"));
        addcomp(340, 195, 100, 30, cmbuniv_no);
        addcomp(200, 245, 100, 30, new JLabel("Batch Name"));
        addcomp(340, 245, 200, 30,txtbatch_name);               
        addcomp(200, 293, 100, 30, new JLabel("Batch Plan"));
        addcomp(340, 295, 100, 25, cmbplan);
        addcomp(200, 330, 410, 15, new JLabel("_________________________________________________________"));
        addcomp(204, 365, 90, 30, btnreset);
        addcomp(304, 365, 90, 30, btnsave);
        addcomp(404, 365, 90, 30, btnpre);
        addcomp(450, 70, 80, 30, btnfind);
        addcomp(504, 365, 90, 30, btnexit);
        addcomp(0,0,163,421,new JLabel (new ImageIcon("images/edit2_n.jpg")));     
        
        setBounds(200, 10, 750, 450);
        setTitle("Batch Details Form");
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

        if (com instanceof JTextField)
        {
            ((JTextField)com).setFont(new Font("Arial", Font.BOLD,12));
        }
        if (com instanceof JComboBox) {
            ((JComboBox)com).setForeground(Color.black);
        }
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnexit) {
                  dispose();
        }
        if (ae.getSource() == btnreset) {
        		  cmbcourse_code.setSelectedIndex(0);
        		  cmbuniv_no.setSelectedIndex(0);
            	  txtbatch_name.setText("");
            	  cmbplan.setSelectedIndex(0);
            	  txtbatch_code.setText("");
        }
        if (ae.getSource() == btnfind) {
                          	  
            	  try {     		 
              		  stmt = cn.createStatement();
                      rs=stmt.executeQuery("select * from batch_details where Batch_Code='"+txtbatch_code.getText()+"'");
                          if(rs.next()) { 
                    	  	  txtbatch_code.setText(rs.getString("Batch_Code"));
                    	  	  cmbcourse_code.setSelectedItem(rs.getString("Course_Code"));
                    		  cmbuniv_no.setSelectedItem(rs.getString("Univ_no"));
                    		  txtbatch_name.setText(rs.getString("Batch_Name"));
                    		  cmbplan.setSelectedItem(rs.getString("Batch_Plan")); 
                   		  /*JOptionPane.showMessageDialog(this,"Record Found,Please Fill The Next Form");
                   		  dispose(); 
                   		  new Paper_Details1();*/
                    		  int t=JOptionPane.showConfirmDialog(this, "Record Found,Do You Want To Fill Next Form?");
                              if(t==0){
                            	  this.dispose();
                                  new Paper_Details1();
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
					 if(txtbatch_code.getText().trim().length()!=0){
					 if(cmbcourse_code.getSelectedIndex()!=0){
					 if(cmbuniv_no.getSelectedIndex()!=0){
					 if(txtbatch_name.getText().trim().length()!=0){
					 if(cmbplan.getSelectedIndex()!=0){
					 sql="insert into batch_details values('"+txtbatch_code.getText()+"','"+cmbcourse_code.getSelectedItem()+"','"+cmbuniv_no.getSelectedItem()+"','"+txtbatch_name.getText()+"','"+cmbplan.getSelectedItem()+"')";
		              try{
		                  stmt=cn.createStatement();
		                  stmt.executeUpdate(sql);
		                  JOptionPane.showMessageDialog(this, "Batch Details Stored");
		              }
		              catch(SQLException sqex){
		                  JOptionPane.showMessageDialog(this,sqex.getMessage().toString(),"Error in SQL Insertion",JOptionPane.ERROR_MESSAGE); 
		              }
		              /*this.dispose();
		              new Paper_Details1();*/
		              int t=JOptionPane.showConfirmDialog(this, "Do You Want To Enter More Values?");
		              if(t==0){
		            	  reset();
		              }
		              else if(t==1){
		            	  this.dispose();
			              new Paper_Details1(); 
		              }
					 }else{
						 JOptionPane.showMessageDialog(this,"Please Select The Batch Plan");
						 cmbplan.setSelectedIndex(0);
						 cmbplan.grabFocus();
					 }
					 }else{
						 JOptionPane.showMessageDialog(this,"Please Insert The Batch Name");
						 txtbatch_name.grabFocus();
					 }
					 }else{
						 JOptionPane.showMessageDialog(this,"Please Select The University Number");
						 cmbuniv_no.setSelectedIndex(0);
						 cmbuniv_no.grabFocus();
					 }
					 }else{
						 JOptionPane.showMessageDialog(this,"Please Select The Course Code");
						 cmbcourse_code.setSelectedIndex(0);
						 cmbcourse_code.grabFocus();
					 }
					 }else{
						 JOptionPane.showMessageDialog(this,"Please Insert The Batch Code");
						 txtbatch_code.grabFocus();
					 }								 
				 }else{}
		}
		   if(ae.getSource()==btnpre){
			   this.dispose();
			   new Course_Details();
		   	}
	  } 
    public void reset(){
      cmbcourse_code.setSelectedIndex(0);
      cmbuniv_no.setSelectedIndex(0);
  	  txtbatch_name.setText("");
  	  cmbplan.setSelectedIndex(0);
  	  txtbatch_code.setText("");
    }
    public static void main(String[] args) {
        new Batch_Details();
    }
}
