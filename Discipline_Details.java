import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Discipline_Details extends JFrame  implements ActionListener,ItemListener{
    Connection cn;
    Statement stmt;
    ResultSet rs;
    String sql="";
    JLabel lblhd;
    JTextField txtname,txtbatch,txtcourse;
    JTextArea txtremarks,txtaction,txtcriteria;
    JButton btnreset, btnsave,btnexit,btnfind,btnpre;
    JComboBox cmbsid,cmbteacher;
    JComboBox cmbsem_no;
    JCheckBox chkdo;
    JPanel panel;
    Container c;
    ImageIcon img;
    public Discipline_Details() {
        img = new ImageIcon("images/2jb0c3d.jpg", null);
        panel = new JPanel() {
                protected void paintComponent(Graphics g) {
                    g.drawImage(img.getImage(), 0, 0, 800, 680, null);
                    super.paintComponent(g);
                }
            };
        panel.setOpaque(false);
        panel.setPreferredSize(new Dimension(800, 450));
        c = getContentPane();
        panel.setLayout(null);
        c.add(panel);
        lblhd = new JLabel("DISCIPLINARY DETAILS");
        cmbsid=new JComboBox();
        cmbsid.addItem("--Select--");
        txtname= new JTextField();
        txtbatch=new JTextField();
        txtcourse=new JTextField();
        cmbteacher=new JComboBox();
        cmbteacher.addItem("--Select--");
        txtremarks=new JTextArea();
        txtaction=new JTextArea();
        txtcriteria=new JTextArea();
        btnreset = new JButton("Reset",new ImageIcon("images/ico1_1.png"));
        btnreset.addActionListener(this);
        btnsave = new JButton("Save",new ImageIcon("images/save3.png"));
        btnsave.addActionListener(this); 
        btnfind = new JButton("Find",new ImageIcon("images/search.png"));
        btnfind.addActionListener(this);
        btnexit = new JButton("Exit", new ImageIcon("images/KREST.png"));
        btnexit.addActionListener(this);
        btnpre = new JButton("Back", new ImageIcon("images/pre2.png"));
        btnpre.addActionListener(this);
        chkdo = new JCheckBox("Check it for getting Some Details");
        chkdo.setOpaque(false);
        //txtid.setEditable(true);
        
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
        try{
        	stmt = cn.createStatement();
        	rs=stmt.executeQuery("select Teacher_Name from teacher_details order by Teacher_ID asc");
            while(rs.next()){
            cmbteacher.addItem(rs.getString("Teacher_Name"));
            }
        }catch(Exception ex){            
            JOptionPane.showMessageDialog(this,ex.toString());
        }
        
        cmbsem_no=new JComboBox();
        cmbsem_no.addItem("--Select--");
        cmbsem_no.addItem("1");
        cmbsem_no.addItem("2");
        cmbsem_no.addItem("3");
        cmbsem_no.addItem("4");
        cmbsem_no.addItem("5");
        cmbsem_no.addItem("6");
              
        addcomp(200, 5, 360, 30, lblhd);
        lblhd.setFont(new Font("COPPERPLATE GOTHIC LIGHT", Font.CENTER_BASELINE, 20));
        addcomp(560, 5, 225, 50, new JLabel(new ImageIcon("images/cim_lbl2.jpg")));
        addcomp(200, 70, 120, 30, new JLabel("ID No."));
        addcomp(340, 70, 100, 30, cmbsid);addcomp(450, 70, 250, 30, chkdo);chkdo.addItemListener(this);
        addcomp(200, 120, 100, 30, new JLabel("Semester No."));
        addcomp(340, 120, 100, 30, cmbsem_no);                
        addcomp(200, 170, 100, 30, new JLabel("Teacher's Name"));
        addcomp(340, 170, 200, 30,cmbteacher);addcomp(550, 170, 80, 30, btnfind);
        addcomp(200, 205, 590, 20, new JLabel("__________________________________________________________________________________"));
        addcomp(200, 235, 120, 30, new JLabel("Student's Name"));
        addcomp(340, 235, 200, 30, txtname);
        addcomp(200, 280, 120, 30, new JLabel("Batch Name"));
        addcomp(340, 280, 200, 30, txtbatch);
        addcomp(200, 325, 100, 30, new JLabel("Course Name"));
        addcomp(340, 325, 200, 30, txtcourse);
        addcomp(200,385,120,30,new JLabel("Teacher's Remark"));
        addcomp(340,370,200,60,txtremarks);
        addcomp(200,460,120,30,new JLabel("Disciplinary Action"));
        addcomp(340,445,200,60,txtaction);
        addcomp(200,535,100,30,new JLabel("Discipline Criteria"));
        addcomp(340,520,200,60,txtcriteria);
        addcomp(200, 580, 590, 20, new JLabel("__________________________________________________________________________________"));
        addcomp(290, 615, 90, 30, btnreset);
        addcomp(390, 615, 90, 30, btnsave);
        addcomp(490, 615, 90, 30, btnpre);
        addcomp(590, 615, 90, 30, btnexit);
        
        addcomp(0,0,163,651,new JLabel (new ImageIcon("images/discipline_side.jpg")));  
        
        /*try {
  		  Class.forName("com.mysql.jdbc.Driver");
    	      cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_final?characterEncoding=UTF-8","root","");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex.toString());
        }*/ 
        
        setBounds(200, 10, 800, 680);
        setTitle("Disciplinary Details Form");
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
            		rs=stmt.executeQuery("select student_details.Student_Name,course_details.Course_Name,batch_details.Batch_Name from student_details,course_details,batch_details where Sid='"+cmbsid.getSelectedItem()+"' and course_details.Course_Code=student_details.Course_Code and batch_details.Batch_Code=student_details.Batch_Code");
            		if(rs.next()){            			
            			txtname.setText(rs.getString("Student_Name"));        			
            			txtcourse.setText(rs.getString("Course_Name"));
            			txtbatch.setText(rs.getString("Batch_Name"));
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
    			txtcourse.setText("");
    			txtbatch.setText("");
    		}
    	}
    }
    public void addcomp(int x, int y, int w, int h, Component com) {
        com.setBounds(x, y, w, h);
        panel.add(com);
        if(com instanceof JLabel) {
            ((JLabel)com).setForeground(Color.black);
        }
        if (com instanceof JTextArea)
        {
            ((JTextArea)com).setFont(new Font("Arial", Font.BOLD,12));
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
            	  reset();
              }
              if (ae.getSource() == btnfind) {
            	  try {
              		  stmt = cn.createStatement();
                      rs=stmt.executeQuery("select * from disciplinary_details where Sid='"+cmbsid.getSelectedItem()+"' and Sem_no='"+cmbsem_no.getSelectedItem()+"' and Teacher_Name='"+cmbteacher.getSelectedItem()+"'");
                      if(rs.next()) { 
                    	  	  cmbsid.setSelectedItem(rs.getString("Sid"));
                    	  	  cmbsem_no.setSelectedItem(rs.getString("Sem_no"));
                    		  //txtname.setText(rs.getString("Student_Name"));
                    		  txtbatch.setText(rs.getString("Batch_Name"));
                    		  txtcourse.setText(rs.getString("Course_Name"));
                    		  cmbteacher.setSelectedItem(rs.getString("Teacher_Name"));
                    		  txtremarks.setText(rs.getString("T_Remark"));
                    		  txtaction.setText(rs.getString("D_Action"));
                    		  txtcriteria.setText(rs.getString("D_Criteria"));
                    		  JOptionPane.showMessageDialog(this,"Record Found,Please Proceed");
                    		  /*this.dispose();
                    		  new Course_Details();*/ 
                    		  int k=JOptionPane.showConfirmDialog(this, "Do You Want To Over The Assessment?");  
                      	  		if(k==0){
                      	  		JOptionPane.showMessageDialog(this,"Your Assessment Work Is Completed");
                      	  		dispose();
                      	  		}	
                      	  	else if(k==1){
                      	  		
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
			if(cmbsid.getSelectedIndex()!=0){
            if(chkdo.isSelected()==true){
			if(cmbsem_no.getSelectedIndex()!=0){
			if(cmbteacher.getSelectedIndex()!=0){
			if(txtremarks.getText().trim().length()!=0){
			if(txtaction.getText().trim().length()!=0){
			if(txtcriteria.getText().trim().length()!=0){
				sql="insert into disciplinary_details values('"+cmbsid.getSelectedItem()+"','"+cmbsem_no.getSelectedItem()+"','"+txtbatch.getText()+"','"+txtcourse.getText()+"','"+cmbteacher.getSelectedItem()+"','"+txtremarks.getText()+
              "','"+txtaction.getText()+"','"+txtcriteria.getText()+"')";
              try{
                  stmt=cn.createStatement();
                  stmt.executeUpdate(sql);
                  JOptionPane.showMessageDialog(this, "Disciplinary Details Stored");
              }
              catch(SQLException sqex){
                  JOptionPane.showMessageDialog(this,sqex.getMessage().toString(),"Error in SQL Insertion",JOptionPane.ERROR_MESSAGE); 
              }
              /*this.dispose();
              new Course_Details();*/
              int t=JOptionPane.showConfirmDialog(this, "Do You Want To Enter More Values?");
              if(t==0){
            	  reset();
              }
              else if(t==1){
            	  JOptionPane.showMessageDialog(this,"You Have Sucessfully Completed Assessment Work");
            	  this.dispose();             
              }
			}else{
				JOptionPane.showMessageDialog(this,"Please Insert Disciplinary Criteria");
				txtcriteria.grabFocus();
			}
			}else{
				JOptionPane.showMessageDialog(this,"Please Insert Disciplinary Action");
				txtaction.grabFocus();
			}
			}else{
				JOptionPane.showMessageDialog(this,"Please Insert Teacher's Remarks");
				txtremarks.grabFocus();
			}
			}else{
				JOptionPane.showMessageDialog(this,"Please Select Teacher's Name");
				cmbteacher.grabFocus();
			}
			}else{
				JOptionPane.showMessageDialog(this,"Please Select Semester Number");
				cmbsem_no.grabFocus();
			}
            }else{
            	JOptionPane.showMessageDialog(this,"Please Check The Checkbox For Getting Details");
            	chkdo.grabFocus();
            }
			}else{
				JOptionPane.showMessageDialog(this,"Please Select Student's ID");
				cmbsid.grabFocus();
			}
              
			}else{}
          }
	   if(ae.getSource()==btnpre){
		   this.dispose();
		   new Exam_Details();
	   }
    }
    public void reset(){
      cmbsid.setSelectedIndex(0);
      if(chkdo.isSelected()==true){
  		chkdo.setSelected(false);
  	  }
      cmbsem_no.setSelectedIndex(0);
  	  txtname.setText("");
  	  txtbatch.setText("");
  	  txtcourse.setText("");
  	  cmbteacher.setSelectedIndex(0);
  	  txtremarks.setText("");
  	  txtaction.setText("");
  	  txtcriteria.setText("");
    }
    public static void main(String[] args) {
        new Discipline_Details();
    }
}
