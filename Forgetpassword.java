package CafeMangment;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Model.User;
import dao.dbo;
import dao.userdao;

public class Forgetpassword {
	
	private JLabel fpw;
	private JLabel firstLabel;
	private ImageIcon firstback;
	private JLabel emaillabel;
	private JLabel sqlabel;
	private JLabel answerlabel;
	private JLabel  newpasslabel;
	private JTextField emailtextfield;
  private JTextField sqtextfield;
  private JTextField answertextfield;
	private JPasswordField newpasswordtextfield;
	private JButton loginbutton;
	private JButton signupbutton;
	private JButton exitbutton;
	private JButton clearbutton;
	private JButton updatebutton;
	private JButton searchbutton;
	private ImageIcon loginicon;
	private ImageIcon exiticon;
	private ImageIcon clearicon;
	private ImageIcon searchIcon;
	private ImageIcon updateicon;;
	
	private JFrame frame;
	private String DBanswer="";
	private String email="";
	
	public Forgetpassword()
	{
		frame=new JFrame();
		frame.setUndecorated(true);
		frame.setLayout(null);
		frame.setSize(1368,760);
		
		firstback=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\first page background.PNG");
		firstLabel=new JLabel();
		firstLabel.setIcon(firstback);
		firstLabel.setBounds(0, 0, 1368,760);
		
		
		
		
		fpw = new JLabel("Forgot Password ?");
		fpw.setFont(new Font ("Tahoma",Font.BOLD,36));
		fpw.setForeground(new Color(204,0,0));
		fpw.setBounds(590,100,400,50);
		
		
		emaillabel=new JLabel("Email");
		emaillabel.setFont(new Font ("Tahoma",Font.BOLD,14));
		emaillabel.setBounds(520,160,120,20);
		
		sqlabel=new JLabel("Security Question");
		sqlabel.setFont(new Font ("Tahoma",Font.BOLD,14));
		sqlabel.setBounds(520,200,130,20);
		
		
		answerlabel=new JLabel("Answer");
		answerlabel.setFont(new Font ("Tahoma",Font.BOLD,14));
		answerlabel.setBounds(520,240,120,20);
		
		newpasslabel=new JLabel("New Password ");
		newpasslabel.setFont(new Font ("Tahoma",Font.BOLD,14));
		newpasslabel.setBounds(520,280,120,20);
	
		
		emailtextfield=new JTextField();
		emailtextfield.setBounds(660, 160, 250, 20);
		
		sqtextfield=new JTextField();
		sqtextfield.setBounds(660, 200, 250, 20);
		sqtextfield.setEditable(false);
		
		answertextfield=new JTextField();
		answertextfield.setBounds(660, 240, 250, 20);
		
		newpasswordtextfield=new JPasswordField();
		newpasswordtextfield.setBounds(660, 280, 250, 20);
		
		searchIcon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\search.png");
		searchbutton=new JButton("Search");
		searchbutton.setIcon(searchIcon);
		searchbutton.setFont(new Font ("Tahoma",Font.BOLD,14));
		searchbutton.setFocusable(false);
		searchbutton.setBounds(930, 160, 130, 20);
		searchbutton.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				
	           User user=null;
	           email=emailtextfield.getText();
				user=userdao.search(email);
			
				if(user==null)
				
					JOptionPane.showMessageDialog(null, "<html><b style = \"color:red \"> Unknown Email address </b></html>","Message",JOptionPane.ERROR_MESSAGE);
				
				else 
				{
					searchbutton.setEnabled(false);
					emailtextfield.setEditable(false);
					sqtextfield.setText(user.getSecurityQuestion());
					DBanswer=user.getAnswer();
				}
				
				
				
				
			}
			
			
		});
		
		updateicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\save.png");
		updatebutton=new JButton("Update");
		updatebutton.setIcon(updateicon);
		updatebutton.setFocusable(false);
		updatebutton.setFont(new Font("Tahoma",Font.BOLD,14));
		updatebutton.setBounds(590, 330, 130, 20);
		updatebutton.addActionListener(new ActionListener()
				{

					
					public void actionPerformed(ActionEvent e) {
						 email=emailtextfield.getText();
						@SuppressWarnings("deprecation")
						String newpassword=newpasswordtextfield.getText();
						String answer=answertextfield.getText();
						
						if(answer.equals(DBanswer))
						{
							userdao.update(email, newpassword);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "<html><b style = \"color:red \"> Incorrect Answer for you security Question </b></html>","Message",JOptionPane.ERROR_MESSAGE);
						}
				
						
					}
			
				});
		
		clearicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\clear.png");
		clearbutton=new JButton("Clear");
		clearbutton.setIcon(clearicon);
		clearbutton.setFocusable(false);
		clearbutton.setFont(new Font("Tahoma",Font.BOLD,14));
		clearbutton.setBounds(740, 330, 100, 20);
		clearbutton.addActionListener(new ActionListener()
		{

	
	public void actionPerformed(ActionEvent e) {
		
		clear();
	}
	
		});
		
		
		exiticon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\exit.png");
		exitbutton=new JButton("Exit");
		exitbutton.setIcon(exiticon);
		exitbutton.setFocusable(false);
		exitbutton.setFont(new Font("Tahoma",Font.BOLD,14));
		exitbutton.setBounds(860, 330, 100, 20);
		  exitbutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					
				int a=	JOptionPane.showConfirmDialog(null,"Do you Really Want to close  ","Closing..",JOptionPane.YES_NO_OPTION);
					if(a==0)
					{
						frame.setVisible(false);
						new Login();
					}
					
				}
				
			});
	      
		
		loginbutton=new JButton("Login");
		loginbutton.setFocusable(false);
		loginbutton.setFont(new Font("Tahoma",Font.BOLD,14));
		loginbutton.setBounds(860, 370, 100, 20);
		loginbutton.addActionListener(new ActionListener()
		{

	
	public void actionPerformed(ActionEvent e) {
		
		
	     	frame.setVisible(false);
	         new Login() ;
		
	}
	
		});
		
		signupbutton=new JButton("SignUp");
		signupbutton.setFocusable(false);
		signupbutton.setFont(new Font("Tahoma",Font.BOLD,14));
		signupbutton.setBounds(590, 370, 100, 20);
		signupbutton.addActionListener(new ActionListener()
		{

	
	public void actionPerformed(ActionEvent e) {
		
		frame.setVisible(false);
	       new Signup() ;
		
	}
	
		});
		
		
		frame.add(signupbutton);
		frame.add(loginbutton);
		frame.add(exitbutton);
		frame.add(updatebutton);
		frame.add(clearbutton);	
		frame.add(searchbutton);
		frame.add(emailtextfield);
		frame.add(sqtextfield);
		frame.add(answertextfield);
		frame.add(newpasswordtextfield);
		frame.add(newpasslabel);
		frame.add(sqlabel);
		frame.add(answerlabel);
		frame.add(emaillabel);
		frame.add(fpw);
		frame.add(firstLabel);
		frame.setVisible(true);
		
	}
	
	
	public void clear()
	{
		emailtextfield.setText("");
		sqtextfield.setText("");
		answertextfield.setText("");
		newpasswordtextfield.setText("");
		searchbutton.setEnabled(true);
		emailtextfield.setEditable(true);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		new Forgetpassword();
	}

}
