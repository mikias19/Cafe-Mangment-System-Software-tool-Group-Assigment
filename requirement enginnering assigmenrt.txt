package CafeMangment;

import java.awt.Color;
import dao.userdao;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import dao.userdao;
import Model.User;

public class Login {
	private ImageIcon popuoicon;
	private JButton signupbutton;
	private JButton  clearbutton;
	private JButton exitbutton;
	private JButton forgotpswbutton;
	private JButton loginbutton;
	private ImageIcon saveicon;
	private ImageIcon clearicon;
	private ImageIcon exiticon;
	private ImageIcon loginiconfirst;
	private ImageIcon signupicon;
	
	private JLabel iconlogin;
	private ImageIcon  loginicon ;
	private JLabel login;
	private JFrame frame;  
	private JLabel email;
	private JLabel password;
	private JTextField emailtextfield;
	private JPasswordField passwordtextfield;
   private String emailpattern="^+[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";
	public Login()
	{
      frame=new JFrame();
      frame.setSize(1360,768);
      frame.setLayout(null);
      frame.setUndecorated(true);
      
      loginicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\first page background.PNG");
      iconlogin=new JLabel();
      iconlogin.setBounds(0, 0, 1360,768 );
      iconlogin.setIcon(loginicon);
      
      
      login=new JLabel("Login");
      login.setFont(new Font("Tahoma",Font.BOLD,36));
      login.setForeground(Color.RED);
      login.setBounds(700, 200, 150, 40);
      
      email=new JLabel("Email");
      email.setFont(new Font("Tahoma ",Font.BOLD,14));
      email.setBounds(580, 270, 100, 20);
      
      password=new JLabel("Password");
      password.setFont(new Font("Tahoma ",Font.BOLD,14));
      password.setBounds(580, 310, 100, 20);
      
      emailtextfield=new JTextField();
      emailtextfield.setBounds(700, 270, 250, 20);
      emailtextfield.addKeyListener(new KeyAdapter() {
    	  
    	  public void keyReleased(KeyEvent e)
    	  {
    		  valid();
    	  }
      });

      
      passwordtextfield=new JPasswordField();
      passwordtextfield.setBounds(700, 310, 250, 20);
      passwordtextfield.addKeyListener(new KeyAdapter() {
    	  
    	  public void keyReleased(KeyEvent e)
    	  {
    		  valid();
    	  }
      });
 
      loginiconfirst=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\login.png");
      loginbutton=new JButton("Login");
      loginbutton.setEnabled(false);
      loginbutton.setIcon(loginiconfirst);
      loginbutton.setFont(new Font("Tahoma ",Font.BOLD,14));
      loginbutton.setBounds(600,360,120, 20);
      loginbutton.setFocusable(false);
   
      loginbutton.addActionListener(new ActionListener()
    		  {

    	 
				public void actionPerformed(ActionEvent e) {
					
					
					String email=emailtextfield.getText();
					String password= passwordtextfield.getText();
					 User user=null;
				
				user= userdao. login(email,password);
				 if(user==null)
				 
			
					 JOptionPane.showMessageDialog(null,"<html><b style = \"color:red\"> Incorrect Email Or Password </b></html>","Message",JOptionPane.ERROR_MESSAGE);
				 
				 else 
				 {
					 if(user.getStatus().equals("false"))
					 {
						 ImageIcon popupicon = new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\popupicon\\wait.png");
						 JOptionPane.showMessageDialog(null, "<html><b>Wait for admin approval </b></html>","message",JOptionPane.INFORMATION_MESSAGE,popupicon);
					 }
					 else 
					 {
						 frame.setVisible(false);
					    new home(email);
					 }
				 }
					
				
				
    	  
				}});
      
      
     
      
      clearicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\clear.png");
      clearbutton=new JButton("Clear");
      clearbutton.setIcon(clearicon);
      clearbutton.setFont(new Font("Tahoma ",Font.BOLD,14));
      clearbutton.setBounds(740,360,120, 20);
      clearbutton.setFocusable(false);
      clearbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				emailtextfield.setText(" ");
				passwordtextfield.setText("");
			}
		}
			);
      
      exiticon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\exit small.PNG");
      exitbutton=new JButton("Exit");
      exitbutton.setIcon(exiticon);
      exitbutton.setFont(new Font("Tahoma ",Font.BOLD,14));
      exitbutton.setBounds(880,360,120, 20);
      exitbutton.setFocusable(false);
      exitbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
			int a=	JOptionPane.showConfirmDialog(null,"Do you Really Want to close the login ","Closing..",JOptionPane.YES_NO_OPTION);
				if(a==0)
				{
					frame.setVisible(false);
					new Signup();
				}
				
			}
			
		});
      
      
      forgotpswbutton=new JButton("Forgot password ?");
      forgotpswbutton.setFont(new Font("Tahoma ",Font.BOLD,14));
      forgotpswbutton.setBounds(600,410,200, 20);
      forgotpswbutton.setFocusable(false);
      forgotpswbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
			   frame.setVisible(false);
			   new Forgetpassword();
				
			}
			
		});
     
      
      signupbutton=new JButton("SignUp");
      signupbutton.setFont(new Font("Tahoma ",Font.BOLD,14));
      signupbutton.setBounds(880,410,120, 20);
      signupbutton.setFocusable(false);
      signupbutton.addActionListener(new ActionListener()
    		  {

				public void actionPerformed(ActionEvent e) {
					new Signup();
				}
    	  
    		  });
      
      
      
      frame.add(forgotpswbutton);
      frame.add(signupbutton);
      frame.add(clearbutton);
      frame.add(exitbutton);
      frame.add(loginbutton);
      frame.add(password);
      frame.add(passwordtextfield);
      frame.add(emailtextfield);
      frame.add(login);
      frame.add(email);
      frame.add(iconlogin);
      frame.setVisible(true);
      
	}