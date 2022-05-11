package CafeMangment;

import java.awt.Color;
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

import Model.User;
import dao.userdao;

public class Signup {
	private ImageIcon firstback;
	private JLabel firstbackLabel;
	
	
	
	
	private ImageIcon saveicon;
	private ImageIcon exiticon;
	private ImageIcon clearicon;
	
	private ImageIcon loginicon;
	private JFrame frame;
	private JLabel signup;
	private JLabel nameLabel;
	private JLabel emailLabel;
	private JLabel mobilenumberLabel;
	private JLabel addressesLabel;
	private JLabel passwordLabel;
	private JLabel securityLabel;
	private JLabel answerLabel;
	private JTextField nameTextfield;
	private JTextField emailTextfield;
	private JTextField mobilenumberTextfield;
	private JTextField adressTextfield;
	private JPasswordField passwordTextfield;
	private JTextField securityTextfield;
	private JTextField  answerTextfield;
	private JButton savebutton;
	private JButton clearbutton;
	private JButton exitbutton;
	private JButton forgotpasswordbutton;
	private JButton loginbutton;
	private String emailpattern="^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";
	private String mobilenumberpattern=" ^[0-9]*$";
	
	public Signup()
	{
		frame =new JFrame();
		frame.setLayout(null);
		frame.setSize(1360,768);
		frame.setUndecorated(true);
		
		
		firstback=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\first page background.PNG");
		
		firstbackLabel=new JLabel();
		firstbackLabel.setBounds(0,0,1360,768);
		firstbackLabel.setIcon(firstback);
		
		signup=new JLabel("SignUp");
		signup.setFont(new Font("Tahoma ",Font.BOLD,36));
		signup.setBounds(710, 100, 200, 50);
		signup.setForeground(Color.RED);
		
		nameLabel=new JLabel("Name");
		nameLabel.setFont(new Font("Tahoma",Font.BOLD,14));
		nameLabel.setBounds(550,150,100,20);
		
		
		emailLabel=new JLabel("Email");
		emailLabel.setFont(new Font("Tahoma",Font.BOLD,14));
		emailLabel.setBounds(550,190,100,20);
		
		mobilenumberLabel=new JLabel("MobileNum");
		mobilenumberLabel.setFont(new Font("Tahoma",Font.BOLD,14));
		mobilenumberLabel.setBounds(550,230,100,20);
		
		addressesLabel=new JLabel("Adresses");
		addressesLabel.setFont(new Font("Tahoma",Font.BOLD,14));
		addressesLabel.setBounds(550,270,100,20);
		
		passwordLabel=new JLabel("Password");
		passwordLabel.setFont(new Font("Tahoma",Font.BOLD,14));
		passwordLabel.setBounds(550,310,100,20);
		
		securityLabel=new JLabel("Secutity Question");
		securityLabel.setFont(new Font("Tahoma",Font.BOLD,14));
		securityLabel.setBounds(550,350,130,20);
		
		
		answerLabel=new JLabel("Answer ");
		answerLabel.setFont(new Font("Tahoma",Font.BOLD,14));
		answerLabel.setBounds(550,390,100,20);
		
		
		nameTextfield=new JTextField();
		nameTextfield.setBounds(680,150,250,20);
		
		
		
		
		emailTextfield=new JTextField();
		emailTextfield.setBounds(680,190,250,20);
	
			
		
		mobilenumberTextfield=new JTextField();
		mobilenumberTextfield.setBounds(680,230,250,20);
		
		
		adressTextfield=new JTextField();
		adressTextfield.setBounds(680,270,250,20);
		
		passwordTextfield=new JPasswordField();
		passwordTextfield.setBounds(680,310,250,20);
		
		securityTextfield=new JTextField();
		securityTextfield.setBounds(680,350,250,20);
		
		answerTextfield=new JTextField();
		answerTextfield.setBounds(680,390,250,20);
		
	
		
		saveicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\save.png");
		savebutton=new JButton("Save");
		savebutton.setIcon(saveicon);
		savebutton.setFont(new Font("Tahoma",Font.BOLD,12));
		savebutton.setBounds(580,430,120,30);
		savebutton.setFocusable(false);
		savebutton.addActionListener(new ActionListener()
				{
		
			public void actionPerformed(ActionEvent e) {
				
				User user=new User();
				
				user.setName(nameTextfield.getText());
				user.setEmail(emailTextfield.getText());
				user.setMobilnNumber(mobilenumberTextfield.getText());
				user.setAdress(adressTextfield.getText());
				user.setPassword(passwordTextfield.getText());
				user.setSecurityQuestion(securityTextfield.getText());
				user.setAnswer(answerTextfield.getText());
				user.setName(nameTextfield.getText());
				
			userdao.save(user);
			clear();
				
			}
				});
		
		clearicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\clear.png");
		clearbutton=new JButton("Clear");
		clearbutton.setIcon(clearicon);
		clearbutton.setFont(new Font("Tahoma",Font.BOLD,12));
		clearbutton.setBounds(720,430,120,30);
		clearbutton.setFocusable(false);
		clearbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				clear();
			}
		}
			);

		 
		exiticon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\exit small.PNG");
		exitbutton=new JButton("Exit");
		exitbutton.setIcon(exiticon);
		exitbutton.setFont(new Font("Tahoma",Font.BOLD,12));
		exitbutton.setBounds(860,430,120,30);
		exitbutton.setFocusable(false);
		exitbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
			int a=	JOptionPane.showConfirmDialog(null,"Do you Want To Close This App","Closing..",JOptionPane.YES_NO_OPTION);
				if(a==0)
				{
					System.exit(0);
				}
				
			}
			
		});
		
		
		forgotpasswordbutton=new JButton("Forgot password ? ");
		forgotpasswordbutton.setFont(new Font("Tahoma",Font.BOLD,12));
		forgotpasswordbutton.setBounds(580,480,155,30);
		forgotpasswordbutton.setFocusable(false);
		forgotpasswordbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
			   frame.setVisible(false);
			   new Forgetpassword();
				
			}
			
		});
		
		loginicon = new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\login.png");
		loginbutton=new JButton("Login ");
		loginbutton.setIcon(loginicon);
		loginbutton.setFont(new Font("Tahoma",Font.BOLD,12));
		loginbutton.setBounds(835,480,155,30);
		loginbutton.setFocusable(false);
		loginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
			
				new Login();
				
			}
			
		});
		
		frame.add(savebutton);
		frame.add(clearbutton);
		frame.add(forgotpasswordbutton);
		frame.add(loginbutton);
		frame.add(exitbutton);
		frame.add(mobilenumberTextfield);
		frame.add(nameTextfield);
		frame.add(emailTextfield);
		frame.add(adressTextfield);
		frame.add(passwordTextfield);
		frame.add(securityTextfield);
		frame.add(answerTextfield);
		frame.add(emailLabel);
		frame.add(mobilenumberLabel);
		frame.add(addressesLabel);
		frame.add(passwordLabel);
		frame.add(securityLabel);
		frame.add(answerLabel);
		
		frame.add(nameLabel);
		frame.add(signup);
		frame.add(firstbackLabel);
		frame.setVisible(true);
		
	}
	
	
	
	public  void clear()
	{
		nameTextfield.setText("");
		emailTextfield.setText("");
		mobilenumberTextfield.setText("");
		adressTextfield.setText(" ");
		passwordTextfield.setText("");
		securityTextfield.setText(" ");
		answerTextfield.setText(" ");
		
		
	}
	
	private void validatefield()
	{
		String name = nameTextfield.getText();
		String email= emailTextfield.getText();
		String mobile=mobilenumberTextfield.getText();
		String address=adressTextfield.getText();
		String password=	passwordTextfield.getText();
		String security=securityTextfield.getText();
     	String answer=	answerTextfield.getText();
	
	if ( !name.equals(" ") && email.matches(emailpattern) && mobile.matches(mobilenumberpattern) && mobile.length()==10 && !address.equals("") && !password.equals(" ") && !security.equals(" ") &&  !answer.equals(" ") )
	
		savebutton.setEnabled(true);
	
	else 
	 
		savebutton.setEnabled(false);
	
	}
	
	
	
	
	
	public static void main(String[] args) {
		new Signup();

	}

}
