import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Paper_Details1 extends JFrame implements ActionListener,KeyListener {
    Connection cn;
    Statement stmt;
    ResultSet rs;
    String sql = "";
    JLabel lbluniv_no, lblhead, lblpaper_code, lblcourse_code,lblpaper_name, lblsem_no, lblthmarks, lblpracmarks, lblweight, lblclass, lblyear;
    JTextField txtpaper_code,txtpaper_name, txtthmarks, txtpracmarks, txtweight, txtclass,txtp_type;
    JButton btnreset, btnsave, btnpre, btnexit,btnfind,btnnext;
    JComboBox lstsem_no,cmbyear,cmbuniv_no,cmbcourse_code;
    List lstpaper_code,lstpaper_name,lstth_marks,lstprac_marks,lstweight,lsttotal,lstp_type;
    JPanel panel;
    Container c;
    ImageIcon img;
    
    public Paper_Details1() {
        img = new ImageIcon("images/2jb0c3d.jpg", null);
        panel = new JPanel() {
                protected void paintComponent(Graphics g) {
                    g.drawImage(img.getImage(), 0, 0, 1171, 620, null);
                    super.paintComponent(g);
                }
            };
        panel.setOpaque(false);
        panel.setPreferredSize(new Dimension(1171, 620));
        c = getContentPane();
        panel.setLayout(null);
        c.add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lblhead = new JLabel("PAPER DETAILS");
        lblpaper_code = new JLabel("Paper Code");
        lblcourse_code = new JLabel("Course Code");
        lblpaper_name=new JLabel("Paper Name");
        lblsem_no = new JLabel("Sem. No");
        lblthmarks = new JLabel("Theory_Marks");
        lblpracmarks = new JLabel("Prac_Marks");
        lblweight = new JLabel("Weightage");
        lblclass = new JLabel("Total Class");
        lblyear = new JLabel("Year No");
        lbluniv_no = new JLabel("Univ. No");
        txtpaper_code = new JTextField();txtpaper_code.addKeyListener(this);
        txtpaper_name=new JTextField();txtpaper_name.addKeyListener(this);
        txtthmarks = new JTextField();txtthmarks.addKeyListener(this);
        txtpracmarks = new JTextField();txtpracmarks.addKeyListener(this);
        txtweight = new JTextField();txtweight.addKeyListener(this);
        txtclass = new JTextField();txtclass.addKeyListener(this);
        txtp_type= new JTextField();txtp_type.addKeyListener(this);
        btnreset = new JButton("Reset", new ImageIcon("images/ico1_1.png"));
        btnreset.addActionListener(this);
        btnsave = new JButton("Save", new ImageIcon("images/save3.png"));
        btnsave.addActionListener(this);
        btnpre = new JButton("Back", new ImageIcon("images/pre2.png"));
        btnpre.addActionListener(this);
        btnnext = new JButton("Next", new ImageIcon("images/next2.png"));
        btnnext.addActionListener(this);
        btnexit = new JButton("Exit", new ImageIcon("images/cn.jpg"));
        btnexit.addActionListener(this);
        btnfind=new JButton("Find",new ImageIcon("images/search.png"));
        btnfind.addActionListener(this);
        cmbyear=new JComboBox();
        cmbyear.addItem("-Select-");
        cmbyear.addItem("1");
        cmbyear.addItem("2");
        cmbyear.addItem("3");
        lstsem_no = new JComboBox();
        lstsem_no.addItem("-Select-");
        lstsem_no.addItem("1");
        lstsem_no.addItem("2");
        lstsem_no.addItem("3");
        lstsem_no.addItem("4");
        lstsem_no.addItem("5");
        lstsem_no.addItem("6");
        lstpaper_code=new List();
        lstpaper_name=new List();
        lstth_marks=new List();
        lstprac_marks=new List();
        lstweight=new List();
        lsttotal=new List();
        lstp_type=new List();
        
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
        addcomp(200, 0, 300, 50, lblhead);
        lblhead.setFont(new Font("COPPERPLATE GOTHIC LIGHT", Font.BOLD, 25));
        addcomp(900, 10, 225, 50, new JLabel(new ImageIcon("images/cim_lbl2.jpg")));
        addcomp(200, 80, 100, 30, lblcourse_code);
        addcomp(310, 80, 100, 30,cmbcourse_code);
        addcomp(430, 80, 100, 30, lbluniv_no);
        addcomp(515, 80, 100, 30,cmbuniv_no);
        addcomp(635, 80, 100, 30, lblsem_no);
        addcomp(720, 80, 75, 30, lstsem_no);
        addcomp(815, 80, 100, 30, lblyear);
        addcomp(900, 80, 75, 30, cmbyear);
        addcomp(985,80,85,30,btnfind);
        addcomp(200, 120, 1000, 15, new JLabel("____________________________________________________________________________________________________________________________"));
        addcomp(205, 170, 860, 15, new JLabel("__________________________________________________________________________________________________________________________"));
        addcomp(225,180,100,30,lblpaper_code);addcomp(210, 220, 100, 30, txtpaper_code);addcomp(320, 183, 1, 291, new JLabel(new ImageIcon("images/line.jpg")));
        addcomp(390,180,100,30,lblpaper_name);addcomp(330,220,200,30,txtpaper_name);addcomp(540, 183, 1, 291, new JLabel(new ImageIcon("images/line.jpg")));
        addcomp(580,180,100,30,new JLabel("Paper Type*"));addcomp(550,220,125,30,txtp_type);addcomp(685, 183, 1, 291, new JLabel(new ImageIcon("images/line.jpg")));
        addcomp(690, 180, 100, 30, lblthmarks);addcomp(695, 220, 75, 30, txtthmarks);addcomp(780, 183, 1, 291, new JLabel(new ImageIcon("images/line.jpg")));
        addcomp(795, 180, 100, 30, lblpracmarks);addcomp(790, 220, 75, 30, txtpracmarks);addcomp(875, 183, 1, 291, new JLabel(new ImageIcon("images/line.jpg")));
        addcomp(890, 180, 100, 30, lblweight);addcomp(885, 220, 75, 30, txtweight);addcomp(970, 183, 1, 291, new JLabel(new ImageIcon("images/line.jpg")));
        addcomp(985, 180, 100, 30, lblclass);addcomp(980, 220, 75, 30, txtclass);
        addcomp(205, 200, 860, 15, new JLabel("__________________________________________________________________________________________________________________________"));
        addcomp(205, 245, 860, 15, new JLabel("__________________________________________________________________________________________________________________________"));
        addcomp(210,265,100,200,lstpaper_code);
        addcomp(330,265,200,200,lstpaper_name);
        addcomp(550,265,125,200,lstp_type);
        addcomp(695,265,75,200,lstth_marks);
        addcomp(790,265,75,200,lstprac_marks);
        addcomp(885,265,75,200,lstweight);
        addcomp(980,265,75,200,lsttotal);
        addcomp(205, 460, 860, 15, new JLabel("__________________________________________________________________________________________________________________________"));
        addcomp(205, 183, 1, 291, new JLabel(new ImageIcon("images/line.jpg")));
        addcomp(1059, 183, 1, 291, new JLabel(new ImageIcon("images/line.jpg")));
        addcomp(200, 510, 1000, 15, new JLabel("____________________________________________________________________________________________________________________________"));
        addcomp(200,490,400,30,new JLabel("NOTE: *You Can Only Fill Courseware/Add-On In Corresponding Field."));
        addcomp(592, 545, 90, 30, btnreset);
        addcomp(692, 545, 87, 30, btnsave);
        addcomp(789, 545, 87, 30, btnpre);
        addcomp(886, 545, 87, 30, btnnext);
        addcomp(983, 545, 87, 30, btnexit);
        addcomp(0, 0, 179, 592, new JLabel(new ImageIcon("images/paper_side_new.jpg")));

        setBounds(100, 60, 1151, 620);
        setVisible(true);
        setTitle("Paper Details Form");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        //setIconImage(Toolkit.getDefaultToolkit().getImage("images/catchpoint.jpg"));
        setIconImage(Toolkit.getDefaultToolkit().getImage("images/catchpoint1.png"));
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
        if (com instanceof JTextField){ 
        	((JTextField)com).setFont(new Font("Arial", Font.BOLD,12));
        }
        if(com instanceof List){
        	((List)com).setFont(new Font("Castellar",Font.ROMAN_BASELINE,15));
        }
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == btnexit) {
            dispose();
        }
        if (ae.getSource() == btnreset) {
        	cmbcourse_code.setSelectedIndex(0);
        	cmbuniv_no.setSelectedIndex(0);
        	lstsem_no.setSelectedIndex(0);
        	cmbyear.setSelectedIndex(0);
        	txtpaper_code.setText("");
        	txtpaper_name.setText("");
        	txtp_type.setText("");
        	txtclass.setText("");
            txtthmarks.setText("");
            txtpracmarks.setText("");
            txtweight.setText("");
            txtclass.setText("");
            lstpaper_code.removeAll();
            lstpaper_name.removeAll();
            lstth_marks.removeAll();
            lstprac_marks.removeAll();
            lstweight.removeAll();
            lsttotal.removeAll();
            lstp_type.removeAll();
        }

        if (ae.getSource() == btnpre) {
          this.dispose();
            new Batch_Details();
        } 
        if (ae.getSource() == btnnext) {
            this.dispose();
              new Personal_Details();
          } 
        if(ae.getSource()==btnfind){
        	lstpaper_code.removeAll();
    		lstpaper_name.removeAll();
    		lstp_type.removeAll();
    		lstth_marks.removeAll();
    		lstprac_marks.removeAll();
    	    lstweight.removeAll();;
    		lsttotal.removeAll();
        	try{
    		    stmt = cn.createStatement();
    		    
                        rs=stmt.executeQuery("select paper_details.Course_Code,paper_details.Univ_no,paper_details.Sem_no,paper_details.Year_no from paper_details where Course_Code='"+cmbcourse_code.getSelectedItem()+"' and Univ_no='"+cmbuniv_no.getSelectedItem()+"' and Sem_no='"+lstsem_no.getSelectedItem()+"' and Year_no='"+cmbyear.getSelectedItem()+"'");
                        if(rs.next()) {                  	  	  
                  	  	  cmbcourse_code.setSelectedItem(rs.getString("Course_Code"));
                  		  cmbuniv_no.setSelectedItem(rs.getString("Univ_no"));
                  		  lstsem_no.setSelectedItem(rs.getString("Sem_no"));
                  		  cmbyear.setSelectedItem(rs.getString("Year_no"));
                        }
                }catch(Exception ex){            
                JOptionPane.showMessageDialog(this,ex.toString());
                	} 
                try{
        		    stmt = cn.createStatement();
        		    
                            rs=stmt.executeQuery("select paper_details.Paper_Code,paper_details.Paper_Name,paper_details.Paper_Type,paper_details.PaperTh_Marks,paper_details.PaperPrac_Marks,paper_details.Paper_Weightage,paper_details.Paper_TotalClass from paper_details where Course_Code='"+cmbcourse_code.getSelectedItem()+"' and Univ_no='"+cmbuniv_no.getSelectedItem()+"' and Sem_no='"+lstsem_no.getSelectedItem()+"' and Year_no='"+cmbyear.getSelectedItem()+"'");
                            while(rs.next()) {
                            	lstpaper_code.addItem(rs.getString("Paper_Code"));
                        		lstpaper_name.addItem(rs.getString("Paper_Name"));
                        		lstp_type.addItem(rs.getString("Paper_Type"));
                        		lstth_marks.addItem(rs.getString("PaperTh_Marks"));
                        		lstprac_marks.addItem(rs.getString("PaperPrac_Marks"));
	                    	    lstweight.addItem(rs.getString("Paper_Weightage"));
	                    		lsttotal.addItem(rs.getString("Paper_TotalClass"));
	                    		/*JOptionPane.showMessageDialog(this,"Record Found,Please Fill The Next Form");
	                    		dispose();  
	                   		  	new Personal_Details();*/
                            }
                           /* else
                        		  JOptionPane.showMessageDialog(this,"Record Not Found,Please Insert Values");*/
                }catch(Exception ex){            
                    JOptionPane.showMessageDialog(this,ex.toString());
            	}
           
        }
        if (ae.getSource() == btnsave) { 
        	ImageIcon iconic=new ImageIcon("images/stat_sys_warning.png");
			 int  x=  JOptionPane.showConfirmDialog(this,"Are You Sure With Your Filled Information?","User Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,iconic);
			 if(x==0){	
				 if(cmbcourse_code.getSelectedIndex()!=0){
				 if(cmbuniv_no.getSelectedIndex()!=0){
				 if(lstsem_no.getSelectedIndex()!=0){
				 if(cmbyear.getSelectedIndex()!=0){
				 if(lstpaper_code.getItemCount()!=0){
				 if(lstpaper_name.getItemCount()!=0){
				 if(lstp_type.getItemCount()!=0){
				 if(lstth_marks.getItemCount()!=0){
				 if(lstprac_marks.getItemCount()!=0){
				 if(lstweight.getItemCount()!=0){
				 if(lsttotal.getItemCount()!=0){
					for(int i=0;i<lstpaper_code.getItemCount();i++){
		            sql ="insert into paper_details values('"+cmbcourse_code.getSelectedItem()
		            	 + "','"+ cmbuniv_no.getSelectedItem()+"','" +lstsem_no.getSelectedItem()+"','"+cmbyear.getSelectedItem()+"','"+lstpaper_code.getItem(i)+"','"+lstpaper_name.getItem(i)+ "','"+
		            	 lstp_type.getItem(i).toUpperCase()+"','"+lstth_marks.getItem(i)+ "','"+
		            	 lstprac_marks.getItem(i) + "','" +lstweight.getItem(i)+"','"+lsttotal.getItem(i)+"')";
		            try {
		                stmt = cn.createStatement();
		                stmt.executeUpdate(sql);
		                
		            	}
		            catch (SQLException sqex)
		            	{
		            		JOptionPane.showMessageDialog(this, sqex.getMessage().toString(), "Error in SQL Insertion",
		                                              JOptionPane.ERROR_MESSAGE);
		            	}
		        	}
		        	JOptionPane.showMessageDialog(this, "Paper Details Stored");
		            /*this.dispose();
		            new Personal_Details();*/    
		        	int t=JOptionPane.showConfirmDialog(this, "Do You Want To Enter More Values?");
		            if(t==0){
		          	  reset();
		            }
		            else if(t==1){
		          	  this.dispose();
		                new Personal_Details(); 
		            }
				 }else{
					 JOptionPane.showMessageDialog(this,"Please Insert Total Classes");
					 txtclass.grabFocus();
				 }
				 }else{
					 JOptionPane.showMessageDialog(this,"Please Insert Paper Weightages");
					 txtweight.grabFocus();
				 }
				 }else{
					 JOptionPane.showMessageDialog(this,"Please Insert Paper Practical Marks");
					 txtpracmarks.grabFocus();
				 }
				 }else{
					 JOptionPane.showMessageDialog(this,"Please Insert Paper Theory Marks");
					 txtthmarks.grabFocus();
				 }
				 }else{
					 JOptionPane.showMessageDialog(this,"Please Insert Paper Types");
					 txtp_type.grabFocus();
				 }   
				 }else{
					 JOptionPane.showMessageDialog(this,"Please Insert Paper Names");
					 txtpaper_name.grabFocus();
				 }     
				 }else{
					 JOptionPane.showMessageDialog(this,"Please Insert Paper Codes");
					 txtpaper_code.grabFocus();
				 }           	            
				 }else{
					 JOptionPane.showMessageDialog(this,"Please Select The Year Number");
					 cmbyear.setSelectedIndex(0);
					 cmbyear.grabFocus();
				 }
				 }else{
					 JOptionPane.showMessageDialog(this,"Please Select The Semester Number");
					 lstsem_no.setSelectedIndex(0);
					 lstsem_no.grabFocus();
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
									            
		  }else{}
       } 
     }
    public void reset(){
    	cmbcourse_code.setSelectedIndex(0);
    	cmbuniv_no.setSelectedIndex(0);
    	lstsem_no.setSelectedIndex(0);
    	cmbyear.setSelectedIndex(0);
    	txtpaper_code.setText("");
    	txtpaper_name.setText("");
    	txtp_type.setText("");
    	txtclass.setText("");
        txtthmarks.setText("");
        txtpracmarks.setText("");
        txtweight.setText("");
        txtclass.setText("");
        lstpaper_code.removeAll();
        lstpaper_name.removeAll();
        lstth_marks.removeAll();
        lstprac_marks.removeAll();
        lstweight.removeAll();
        lsttotal.removeAll();
        lstp_type.removeAll();
    }
    public static void main(String[] args) {
    	new Paper_Details1();
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
		// TODO Auto-generated method stub
		if(e.getSource()==txtpaper_code){
			if(e.getKeyCode()==e.VK_ENTER){
				if(txtpaper_code.getText().trim().length()!=0){
					lstpaper_code.add(txtpaper_code.getText().trim());
					txtpaper_code.setText("");
				}
				else{
					JOptionPane.showMessageDialog(this, "You Can't Fill Whitespace As Paper Code");
					txtpaper_code.grabFocus();
				}
			}
		}
		if(e.getSource()==txtpaper_name){
			if(e.getKeyCode()==e.VK_ENTER){
				if(txtpaper_name.getText().trim().length()!=0){
					if(lstpaper_name.getItemCount()!=lstpaper_code.getItemCount()){
					lstpaper_name.add(txtpaper_name.getText().trim());
					txtpaper_name.setText("");
					}else{
						JOptionPane.showMessageDialog(this, "You Can't Enter More Paper Name(s)");
						txtpaper_name.setText("");
					}
				}else{
					JOptionPane.showMessageDialog(this, "You Can't Fill Whitespace As Paper Name");
					txtpaper_name.grabFocus();
				}
			}
		}
		if(e.getSource()==txtthmarks){
			if(e.getKeyCode()==e.VK_ENTER){
				if(txtthmarks.getText().trim().length()!=0){
					if(lstth_marks.getItemCount()!=lstpaper_code.getItemCount()){
					if(txtthmarks.getText().trim().length()<=3){
					lstth_marks.add(txtthmarks.getText().trim());
					txtthmarks.setText("");
					}else{
						JOptionPane.showMessageDialog(this, "Please Insert Correct Theory Marks");
						txtthmarks.setText("");
						txtthmarks.grabFocus();
					}
					}else{
						JOptionPane.showMessageDialog(this, "You Can't Enter More Theory Marks");
						txtthmarks.setText("");
					}
				}else{
					JOptionPane.showMessageDialog(this, "You Can't Fill Whitespace As Theory Marks");
					txtthmarks.grabFocus();
				}
			}
		}
		if(e.getSource()==txtpracmarks){
			if(e.getKeyCode()==e.VK_ENTER){
				if(txtpracmarks.getText().trim().length()!=0){
					if(lstprac_marks.getItemCount()!=lstpaper_code.getItemCount()){
					if(txtpracmarks.getText().trim().length()<=3){
					lstprac_marks.add(txtpracmarks.getText().trim());
					txtpracmarks.setText("");
					}else{
						JOptionPane.showMessageDialog(this, "Please Insert Correct Practical Marks");
						txtpracmarks.setText("");
						txtpracmarks.grabFocus();
					}
					}else{
						JOptionPane.showMessageDialog(this, "You Can't Enter More Practical Marks");
						txtpracmarks.setText("");
					}
				}else{
					JOptionPane.showMessageDialog(this, "You Can't Fill Whitespace As Practical Marks");
					txtpracmarks.grabFocus();
				}
			}
		}
		if(e.getSource()==txtweight){
			if(e.getKeyCode()==e.VK_ENTER){
				if(txtweight.getText().trim().length()!=0){
					if(lstweight.getItemCount()!=lstpaper_code.getItemCount()){
						if(txtweight.getText().trim().length()<=3){
							lstweight.add(txtweight.getText().trim());
							txtweight.setText("");
						}else{
							JOptionPane.showMessageDialog(this, "Please Insert Correct Paper Weightage");
							txtweight.setText("");
							txtweight.grabFocus();
						}
					}else{
						JOptionPane.showMessageDialog(this, "You Can't Enter More Paper Weightage Marks");
						txtweight.setText("");
					}
				}else{
					JOptionPane.showMessageDialog(this, "You Can't Fill Whitespace As Paper Weightage");
					txtweight.grabFocus();
				}
			}
		}
		if(e.getSource()==txtclass){
			if(e.getKeyCode()==e.VK_ENTER){
				if(txtclass.getText().trim().length()!=0){
					if(lsttotal.getItemCount()!=lstpaper_code.getItemCount()){
						if(txtclass.getText().trim().length()<=3){
							lsttotal.add(txtclass.getText().trim());
							txtclass.setText("");
						}else{
							JOptionPane.showMessageDialog(this, "Please Insert Correct Total Class");
							txtclass.setText("");
							txtclass.grabFocus();
						}
					}else{
						JOptionPane.showMessageDialog(this, "You Can't Enter More Total Class");
						txtclass.setText("");
					}
				}else{
					JOptionPane.showMessageDialog(this, "You Can't Fill Whitespace As Total Class");
					txtclass.grabFocus();
				}
			}
		}
		if(e.getSource()==txtp_type){
			if(e.getKeyCode()==e.VK_ENTER){
				if(txtp_type.getText().trim().length()!=0){
					if(lstp_type.getItemCount()!=lstpaper_code.getItemCount()){
						if(txtp_type.getText().equalsIgnoreCase("Courseware")||txtp_type.getText().equalsIgnoreCase("Add-On")){
							lstp_type.add(txtp_type.getText());
							txtp_type.setText("");
						}
					else{
						JOptionPane.showMessageDialog(this, "Please Follow The Instruction Given Below");	
						txtp_type.setText("");
					}
				}else{
					JOptionPane.showMessageDialog(this, "You Can't Enter More Values As Paper Type");
					txtp_type.setText("");
					}
			}else{
				JOptionPane.showMessageDialog(this, "You Can't Fill Whitespace As Paper Type");
				txtp_type.grabFocus();
			}		
			}
		}
	}
}
