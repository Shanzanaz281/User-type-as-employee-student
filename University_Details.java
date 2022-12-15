import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class University_Details extends JFrame implements ActionListener{
    Connection cn;
    Statement stmt;
    ResultSet rs;
    String sql="";
    JLabel lblhd;
    JTextField txtuniv_no,txtuniv_name,txtpin,txtcity,txtstate,txttelno,txtemail,txtweb;
    JTextArea txtadd;
    JButton btnreset, btnsave,btnexit,btnfind;
    JPanel panel;
    Container c;
    ImageIcon img;
    public University_Details() {
        img = new ImageIcon("images/2jb0c3d.jpg", null);
        panel = new JPanel() {
                protected void paintComponent(Graphics g) {
                    g.drawImage(img.getImage(), 0, 0, 750, 680, null);
                    super.paintComponent(g);
                }
            };
        panel.setOpaque(false);
        panel.setPreferredSize(new Dimension(750, 450));
        c = getContentPane();
        panel.setLayout(null);
        c.add(panel);
        lblhd = new JLabel("UNIVERSITY DETAILS");
        txtuniv_no = new JTextField();
        txtuniv_name= new JTextField();
        txtadd=new JTextArea();
        txtpin=new JTextField();
        txtcity=new JTextField();
        txtstate=new JTextField();
        txttelno=new JTextField();
        txtemail=new JTextField();
        txtweb=new JTextField();
        btnreset = new JButton("Reset",new ImageIcon("images/ico1_1.png"));
        btnreset.addActionListener(this);
        btnsave = new JButton("Save",new ImageIcon("images/save3.png"));
        btnsave.addActionListener(this); 
        btnfind = new JButton("Find",new ImageIcon("images/search.png"));
        btnfind.addActionListener(this);
        btnexit = new JButton("Exit", new ImageIcon("images/KREST.png"));
        btnexit.addActionListener(this);
        txtuniv_no.setEditable(true);
        addcomp(200, 5, 360, 30, lblhd);
        lblhd.setFont(new Font("COPPERPLATE GOTHIC LIGHT", Font.CENTER_BASELINE, 20));
        addcomp(500, 5, 225, 50, new JLabel(new ImageIcon("images/cim_lbl2.jpg")));
        addcomp(200, 70, 120, 30, new JLabel("University Number"));
        addcomp(340, 70, 100, 30, txtuniv_no);
        addcomp(200, 110, 390, 20, new JLabel("______________________________________________________"));
        addcomp(200, 150, 100, 30, new JLabel("University Name"));
        addcomp(340, 150, 200, 30,txtuniv_name);
        addcomp(200, 200, 120, 30, new JLabel("University Address"));
        addcomp(340, 200, 200, 60, txtadd);
        addcomp(200, 280, 100, 30, new JLabel("Pincode"));
        addcomp(340, 280, 100, 30, txtpin);
        addcomp(200,330,100,30,new JLabel("City"));
        addcomp(340,330,100,30,txtcity);
        addcomp(200,380,100,30,new JLabel("State"));
        addcomp(340,380,100,30,txtstate);
        addcomp(200,430,120,30,new JLabel("Telephone Number"));
        addcomp(340,430,150,30,txttelno);
        addcomp(200,480,100,30,new JLabel("Email"));
        addcomp(340,480,200,30,txtemail);
        addcomp(200,530,100,30,new JLabel("Website"));
        addcomp(340,530,200,30,txtweb);
        addcomp(200, 560, 390, 20, new JLabel("______________________________________________________"));
        addcomp(250, 600, 90, 30, btnreset);
        addcomp(350, 600, 90, 30, btnsave);
        addcomp(450, 600, 90, 30, btnexit);
        addcomp(450, 70, 80, 30, btnfind);
        addcomp(0,0,163,651,new JLabel (new ImageIcon("images/edit1.jpg")));  
        
        try {
  		  Class.forName("com.mysql.jdbc.Driver");
    	      cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_final?characterEncoding=UTF-8","root","");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex.toString());
        } 
        
        setBounds(200, 10, 750, 680);
        setTitle("University Details Form");
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
            	  txtuniv_no.setText("");
            	  txtuniv_name.setText("");
            	  txtadd.setText("");
            	  txtpin.setText("");
            	  txtcity.setText("");
            	  txtstate.setText("");
            	  txttelno.setText("");
            	  txtemail.setText("");
            	  txtweb.setText("");
              }
              if (ae.getSource() == btnfind) {
            	  try {
              		  stmt = cn.createStatement();
                      rs=stmt.executeQuery("select * from university_details where Univ_no='"+txtuniv_no.getText()+"'");
                        if(rs.next()) { 
                		  txtuniv_no.setText(rs.getString("Univ_no"));
                		  txtuniv_name.setText(rs.getString("Univ_Name"));
                		  txtadd.setText(rs.getString("Univ_Address"));
                		  txtpin.setText(rs.getString("Pincode"));
                		  txtcity.setText(rs.getString("City"));
                		  txtstate.setText(rs.getString("State"));
                		  txttelno.setText(rs.getString("Telno"));
                		  txtemail.setText(rs.getString("Email"));
                		  txtweb.setText(rs.getString("Website"));
                		  //JOptionPane.showMessageDialog(this,"Record Found,Please Fill The Next Form");
                		  int t=JOptionPane.showConfirmDialog(this, "Record Found,Do You Want To Fill Next Form?");
                          if(t==0){
                        	  this.dispose();
                              new Course_Details();
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
			 if(txtuniv_no.getText().trim().length()!=0){
			 if(txtuniv_name.getText().trim().length()!=0){
			 if(txtadd.getText().trim().length()!=0){
			 if(txtpin.getText().trim().length()!=0){
			 if(txtpin.getText().trim().length()==6){
			 if(txtcity.getText().trim().length()!=0){
			 if(txtstate.getText().trim().length()!=0){
			 if(txttelno.getText().trim().length()!=0){
			 if(txttelno.getText().trim().length()<15){
			 if(txtemail.getText().trim().length()!=0){
			 if(txtemail.getText().matches("[a-zA-Z0-9\\.]+@[a-zA-Z0-9\\-\\_\\.]+\\.[a-zA-Z0-9]{3}")){
			 if(txtweb.getText().trim().length()!=0){
			 sql="insert into university_details values('"+txtuniv_no.getText()+"','"+txtuniv_name.getText()+"','"+txtadd.getText()+"','"+txtpin.getText()+"','"+txtcity.getText()+
			 "','"+txtstate.getText()+"','"+txttelno.getText()+"','"+txtemail.getText()+"','"+txtweb.getText()+"')";
			  try{
			      stmt=cn.createStatement();
			      stmt.executeUpdate(sql);
			      JOptionPane.showMessageDialog(this, "University Details Stored");
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
			      new Course_Details(); 
			  }
			  /*this.dispose();
			  new Course_Details();*/
			 }											 
			 else{
				 JOptionPane.showMessageDialog(this,"Please Insert Web Address");
					 txtweb.grabFocus();
				 }											 
			 }											 
			 else{
				 JOptionPane.showMessageDialog(this,"Please Insert Valid Email Address");
			 txtemail.setText("");
					 txtemail.grabFocus();
				 }
			 }	 
			 else{
				 JOptionPane.showMessageDialog(this,"Please Insert Email Address");
					 txtemail.grabFocus();
				 }													 
			 }
			 else{
				 JOptionPane.showMessageDialog(this,"Please Insert Valid Telephone Number");
			 txttelno.setText("");
					 txttelno.grabFocus();
				 }													 
			 }											 
			 else{
				 JOptionPane.showMessageDialog(this,"Please Insert Telephone Number");
					 txttelno.grabFocus();
				 }
			 }												 								 
			 else{
				 JOptionPane.showMessageDialog(this,"Please Insert State Name");
					 txtstate.grabFocus();
				 }
			 }												 					 
			 else{
				 JOptionPane.showMessageDialog(this,"Please Insert City Name");
					 txtcity.grabFocus();
				 }									 
			 }											 
			 else{
				 JOptionPane.showMessageDialog(this,"Please Insert Correct Pincode");
			 txtpin.setText("");
					 txtpin.grabFocus();
				 }													 
			 }												 
			 else{
				 JOptionPane.showMessageDialog(this,"Please Insert Pincode");
					 txtpin.grabFocus();
				 }													 
			 }											 
			 else{
				 JOptionPane.showMessageDialog(this,"Please Insert University Address");
					 txtadd.grabFocus();
				 }													 
			 }												 
			 else{
				 JOptionPane.showMessageDialog(this,"Please Insert University Name");
					 txtuniv_name.grabFocus();
				 }
			 }												 
			 else{
				 JOptionPane.showMessageDialog(this,"Please Insert University Number");
						 txtuniv_no.grabFocus();
					 }
				 
				 }
				 else{}
			      }
			}
      public void reset(){
      txtuniv_no.setText("");
   	  txtuniv_name.setText("");
   	  txtadd.setText("");
   	  txtpin.setText("");
   	  txtcity.setText("");
   	  txtstate.setText("");
   	  txttelno.setText("");
   	  txtemail.setText("");
   	  txtweb.setText("");
      }
    public static void main(String[] args) {
        new University_Details();
    }
}
