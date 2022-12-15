import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Paper_Assignment extends JFrame implements ActionListener{
    Connection cn;
    Statement stmt;
    ResultSet rs;
    String sql="";
    JLabel lblhd;
    JTextField txtalloted,txtconducted,txtpaper_time;
    JButton btnreset, btnsave,btnexit,btnpre,btnnext,btnfind;
    JComboBox cmbteacher_id,cmbbatch_code,cmbpaper_code;
    JPanel panel;
    Container c;
    ImageIcon img;    

    public Paper_Assignment() {
        img = new ImageIcon("images/2jb0c3d.jpg", null);
        panel = new JPanel() {
                protected void paintComponent(Graphics g) {
                    g.drawImage(img.getImage(), 0, 0, 800, 490, null);
                    super.paintComponent(g);
                }
            };
        panel.setOpaque(false);
        panel.setPreferredSize(new Dimension(800, 490));
        c = getContentPane();
        panel.setLayout(null);
        c.add(panel);
        lblhd = new JLabel("PAPER ASSIGNMENT DETAILS");
        txtalloted=new JTextField();
        txtpaper_time=new JTextField();
        txtconducted=new JTextField();
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
        try{
      	  Class.forName("com.mysql.jdbc.Driver");
    	      cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_final?characterEncoding=UTF-8","root","");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex.toString());
        }
        cmbteacher_id=new JComboBox();
        cmbteacher_id.addItem("--Select--");
        try{
        	stmt = cn.createStatement();
        	rs=stmt.executeQuery("select Teacher_ID from teacher_details order by Teacher_ID asc");
            while(rs.next()){
            cmbteacher_id.addItem(rs.getString("Teacher_ID"));
            }
        }catch(Exception ex){            
            JOptionPane.showMessageDialog(this,ex.toString());
         }
        cmbbatch_code=new JComboBox();
        cmbbatch_code.addItem("--Select--");
        try{
        	stmt = cn.createStatement();
        	rs=stmt.executeQuery("select Batch_code from batch_details order by Batch_Code asc");
            while(rs.next()){
            cmbbatch_code.addItem(rs.getString("Batch_Code"));
            }
        }catch(Exception ex){            
            JOptionPane.showMessageDialog(this,ex.toString());
        } 
        cmbpaper_code=new JComboBox();
        cmbpaper_code.addItem("--Select--");
        try{
        	stmt = cn.createStatement();
        	rs=stmt.executeQuery("select Paper_Code from paper_details order by Paper_Code asc");
            while(rs.next()){
            cmbpaper_code.addItem(rs.getString("Paper_Code"));
            }
        }catch(Exception ex){            
            JOptionPane.showMessageDialog(this,ex.toString());
        }
        addcomp(200, 5, 360, 40, lblhd);
        lblhd.setFont(new Font("COPPERPLATE GOTHIC LIGHT", Font.CENTER_BASELINE, 17));
        addcomp(560, 5, 225, 50, new JLabel(new ImageIcon("images/cim_lbl2.jpg")));
        addcomp(200, 70, 100, 30, new JLabel("Teacher ID"));
        addcomp(340, 70, 100, 30, cmbteacher_id);
        addcomp(200, 120, 100, 30, new JLabel("Batch Code"));
        addcomp(340, 120, 100, 30, cmbbatch_code);
        addcomp(200,170,100,30,new JLabel("Paper Code"));
        addcomp(340, 170, 100, 30, cmbpaper_code);
        addcomp(450, 170, 80, 30, btnfind);
        addcomp(200, 210, 500, 15, new JLabel("______________________________________________________________________"));
        
        addcomp(200,245,100,30,new JLabel("Paper Timing"));
        addcomp(340,245,110,30,txtpaper_time);
        addcomp(200,295,100,30,new JLabel("Class Alloted"));
        addcomp(340,295,75,30,txtalloted);
        addcomp(200,345,100,30,new JLabel("Class Conducted"));
        addcomp(340,345,75,30,txtconducted);
        addcomp(200, 385, 500, 15, new JLabel("_______________________________________________________________________"));
        addcomp(253, 415, 90, 30, btnreset);
        addcomp(353, 415, 90, 30, btnsave);
        addcomp(453, 415, 90, 30, btnpre);
        //addcomp(503, 415, 90, 30, btnnext);
        addcomp(553,415,90,30,btnexit);
        addcomp(0,0,179,461,new JLabel (new ImageIcon("images/assign.side.jpg")));     
        
        setBounds(200, 10, 800, 490);
        setTitle("Teacher Paper Assignment Details Form");
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
        		  cmbteacher_id.setSelectedIndex(0);
            	  cmbbatch_code.setSelectedIndex(0);
            	  cmbpaper_code.setSelectedIndex(0);
            	  txtpaper_time.setText("");
            	  txtalloted.setText("");
            	  txtconducted.setText("");
        }
        
        if (ae.getSource() == btnfind) {
                          	  
            	  try {
              		  stmt = cn.createStatement();
                      rs=stmt.executeQuery("select * from paper_assign_details where Teacher_ID='"+cmbteacher_id.getSelectedItem()+"' and Batch_Code='"+cmbbatch_code.getSelectedItem()+"' and Paper_Code='"+cmbpaper_code.getSelectedItem()+"'");
                      if(rs.next()) {  
                    	  	  	cmbteacher_id.setSelectedItem(rs.getString("Teacher_ID"));
                        	  	cmbbatch_code.setSelectedItem(rs.getString("Batch_Code"));
                        	  	cmbpaper_code.setSelectedItem(rs.getString("Paper_Code"));
                        	  	txtpaper_time.setText(rs.getString("Paper_Timing"));
                        	  	txtalloted.setText(rs.getString("Class_Alloted"));
                        	  	txtconducted.setText(rs.getString("Class_Conducted"));
                        	  	//JOptionPane.showMessageDialog(this,"Record Found,Please Proceed");
                        	  	int t=JOptionPane.showConfirmDialog(this, "Record Found,Do You Want To Fill The Next Form?");
                                if(t==0){
                              	  this.dispose();
                                    new Attendence_Details();
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
            	  	}catch(Exception ex){
                                  JOptionPane.showMessageDialog(this,ex.toString());
                              } 
            	  	
              }		
		   if(ae.getSource()==btnsave) {
			   ImageIcon iconic=new ImageIcon("images/stat_sys_warning.png");
				 int  x=  JOptionPane.showConfirmDialog(this,"Are You Sure With Your Filled Information?","User Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,iconic);
				 if(x==0){
					 if(cmbteacher_id.getSelectedIndex()!=0){
		             if(cmbbatch_code.getSelectedIndex()!=0){
		             if(cmbpaper_code.getSelectedIndex()!=0){
		             if(txtpaper_time.getText().trim().length()!=0){
		           	 if(txtalloted.getText().trim().length()!=0){
		      		 if(Integer.valueOf(txtalloted.getText())>0&&Integer.valueOf(txtalloted.getText())<=100){
		        	 if(txtconducted.getText().trim().length()!=0){
		             if(Integer.valueOf(txtconducted.getText())>0&&Integer.valueOf(txtconducted.getText())<=100){
		            			  sql="insert into paper_assign_details values('"+cmbteacher_id.getSelectedItem()+"','"+cmbbatch_code.getSelectedItem()+"','"+cmbpaper_code.getSelectedItem()+"','"+txtpaper_time.getText()+"','"+txtalloted.getText()+"','"+txtconducted.getText()+"')";
		              try{
		                  stmt=cn.createStatement();
		                  stmt.executeUpdate(sql);
		                  JOptionPane.showMessageDialog(this, "Teacher Paper Assignment Details Stored");
		              }
		              catch(SQLException sqex){
		                  JOptionPane.showMessageDialog(this,sqex.getMessage().toString(),"Error in SQL Insertion",JOptionPane.ERROR_MESSAGE); 
		              }
		              /*catch(Exception ex)
		              {
		            	  JOptionPane.showMessageDialog(this,ex.toString());  
		              }
		              cmbteacher_id.setSelectedIndex(0);
	            	  cmbbatch_code.setSelectedIndex(0);
	            	  cmbpaper_code.setSelectedIndex(0);
	            	  txtpaper_time.setText("");
	            	  txtalloted.setText("");
	            	  txtconducted.setText("");*/
		              int t=JOptionPane.showConfirmDialog(this, "Do You Want To Enter More Values?");
		              if(t==0){
		            	  reset();
		              }
		              else if(t==1){
		            	  this.dispose();
		                  new Attendence_Details(); 
		              }
				}else{
					JOptionPane.showMessageDialog(this,"Please Insert Correct Conducted Classes");
					txtconducted.setText("");
					txtconducted.grabFocus();
				}
				
				}else{
					 JOptionPane.showMessageDialog(this,"Please Insert Conducted Class");
					 txtconducted.grabFocus();
				  }
				 }else{
					 JOptionPane.showMessageDialog(this,"Please Insert Correct Alloted Classes");
					 txtalloted.setText("");
					 txtalloted.grabFocus();
				 }
				}else{
						JOptionPane.showMessageDialog(this,"Please Insert Alloted Class");
						txtalloted.grabFocus();
					}
				  }else{
					  	JOptionPane.showMessageDialog(this,"Please Insert Paper Timing");
						txtpaper_time.grabFocus();
				  }
				}else{
						JOptionPane.showMessageDialog(this,"Please Select Paper Code");
						cmbpaper_code.grabFocus();
					}
				  }else{
					  JOptionPane.showMessageDialog(this,"Please Select Batch Code");
					  cmbbatch_code.grabFocus();
				  }
				 }else{
					 JOptionPane.showMessageDialog(this,"Please Select Teacher Id");
					 txtalloted.grabFocus();
				 }
		              
				 }else{}
		   }
		   if(ae.getSource()==btnpre){
			   this.dispose();
			   new Teacher_Details();
		   	}
		   /*if (ae.getSource() == btnnext) {
	            this.dispose();
	              new Attendence_Details();
	          }*/
	 } 
    public void reset(){
      cmbteacher_id.setSelectedIndex(0);
  	  cmbbatch_code.setSelectedIndex(0);
  	  cmbpaper_code.setSelectedIndex(0);
  	  txtpaper_time.setText("");
  	  txtalloted.setText("");
  	  txtconducted.setText("");
    }
    public static void main(String[] args) {
        new Paper_Assignment();
    }
}
