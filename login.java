import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JPasswordField;
import java.sql.*;

public class login extends JFrame implements ActionListener,KeyListener {
	JButton btnlogin, btncncl;
	JLabel lbluid,lblpwd;
	JTextField txtuid;
	JPasswordField txtpwd;
	JPanel panel;
	ImageIcon img;
	Container c;
	Connection con;
	Statement stmt;
	ResultSet rs;
	public login() {
		img = new ImageIcon("images/login2_n.png", null);
		panel = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.drawImage(img.getImage(), 0, 0,600, 400, null);
				super.paintComponent(g);
			}
		};
		setResizable(false);
		panel.setOpaque(false);
		panel.setPreferredSize(new Dimension(600, 400));
		c = getContentPane();
		panel.setLayout(null);
		c.add(panel);
		btnlogin = new JButton("Login");
		btncncl = new JButton("Cancel");
		txtuid = new JTextField();
		txtpwd = new JPasswordField();
		lbluid = new JLabel("User Id");
		lblpwd = new JLabel("Password");
		addcomp(220, 85, 100, 30, lbluid);
		addcomp(220, 110, 170, 28, txtuid);
		addcomp(225, 160, 100, 30, lblpwd);
		addcomp(223, 190, 170, 28, txtpwd);
		addcomp(390, 280, 100, 30, btnlogin);btnlogin.addKeyListener(this);
		addcomp(465, 280, 100, 30, btncncl);btncncl.addKeyListener(this);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_final?characterEncoding=UTF-8","root","");
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(this, ex.toString());
		}

		setBounds(410, 240, 570, 420);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("User Login");
		setVisible(true);
		//setIconImage(Toolkit.getDefaultToolkit().getImage("images/catchpoint.jpg"));
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/catchpoint1.png"));
	}
	public void addcomp(int x, int y, int w, int h, Component com) {
		com.setBounds(x, y, w, h);
		panel.add(com);
		if (com instanceof JLabel) {
			((JLabel)com).setForeground(Color.black);
		}
		if(com instanceof JButton) {
			((JButton)com).setBorder(null);
			((JButton)com).setBorderPainted(false);
			((JButton)com).setContentAreaFilled(false);
			((JButton)com).setOpaque(false);
			((JButton)com).addActionListener(this);
			((JButton)com).setForeground(Color.black);
		}       
	}
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnlogin) {
			boolean temp = false;
			try {
				stmt = con.createStatement();
				rs =stmt.executeQuery("select * from login_details where usid ='" + txtuid.getText().toUpperCase() + "' and upwd ='" + String.valueOf(txtpwd.getPassword()) + "'");
				if (rs.next()) {
					if(txtuid.getText().equals(rs.getString("usid"))){
						if(txtpwd.getText().equals(rs.getString("upwd")))
							temp = true;
					}}
			} catch (Exception ex) {

				JOptionPane.showMessageDialog(this, ex);
			}
			if (temp) {
				ImageIcon iconic=new ImageIcon("images/login1_1.png");
				JOptionPane.showMessageDialog(this, "Login Permitted", "Message", JOptionPane.INFORMATION_MESSAGE, iconic);
				new main();
				dispose();                
			}else{
				txtuid.setText("");
				txtpwd.setText("");
				ImageIcon iconic1=new ImageIcon("images/login1_2.png");
				JOptionPane.showMessageDialog(this, "UserId / Password does not Match", "Message", JOptionPane.INFORMATION_MESSAGE, iconic1);
			}
		}
		if (ae.getSource() == btncncl) {
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new login();
	}
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyPressed(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {
		
		if(e.getSource()==btnlogin){
			if(e.getKeyCode()== e.VK_ENTER){
				boolean temp = false;
				try {
					stmt = con.createStatement();
					rs =stmt.executeQuery("select * from login_details where usid ='" + txtuid.getText().toUpperCase() + "' and upwd ='" + String.valueOf(txtpwd.getPassword()) + "'");
					if (rs.next()) {
						if(txtuid.getText().equals(rs.getString("usid"))){
							if(txtpwd.getText().equals(rs.getString("upwd")))
								temp = true;
						}}
				} catch (Exception ex) {

					JOptionPane.showMessageDialog(this, ex);
				}
				if (temp){
					ImageIcon iconic=new ImageIcon("images/login1_1.png");
					JOptionPane.showMessageDialog(this, "Login Permitted", "Message", JOptionPane.INFORMATION_MESSAGE, iconic);
					new main();
					dispose();                
				}else{
					txtuid.setText("");
					txtpwd.setText("");
					ImageIcon iconic1=new ImageIcon("images/login1_2.png");
					JOptionPane.showMessageDialog(this, "UserId / Password does not Match", "Message", JOptionPane.INFORMATION_MESSAGE, iconic1);
				}
			}			
		}
		if(e.getSource()==btncncl){
			if(e.getKeyCode()== e.VK_ENTER){
				dispose();
			}
		}
	}
}
