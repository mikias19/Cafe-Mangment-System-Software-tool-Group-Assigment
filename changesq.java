package CafeMangment;



import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.User;
import dao.dbo;
import dao.userdao;

public class changesq {
	private JLabel back;
	private ImageIcon backicon;
	private JFrame frame;
	private JLabel emaillabel;
	private JLabel securityQlabel;
	private JLabel answerlabel;
	private JLabel newSequrityqlabel;
	private JLabel newanswerlabel;
	private JTextField emailtextfield;
	private JTextField sqtextfield;
	private JTextField answertextfield;
	private JTextField newsqtextfield;
	private JTextField newanswertextfield;
	private JButton close;
	private ImageIcon closeicon;
	private JButton search;
	private ImageIcon searchicon;
	private JButton update;
	private ImageIcon updateicon;
	private JButton clear;
	private ImageIcon clearicon;
	private JButton home;
	private ImageIcon homeicon;
	private JLabel sqlabel;
	private String dbanswer;
	private String dbemail;
   private String emailpattern="^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";
	public changesq(String emailsq)
	{
		
		 frame=new JFrame();
		    frame.setSize(700,400);
		    frame.setLayout(null);
		    frame.setUndecorated(true);
		     frame.setLocation(350,134);
		     
		     backicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\small-page-background.PNG");
		     back=new JLabel();
		     back.setBounds(0, 0, 700, 400);
		     back.setIcon(backicon);
		     
		     emaillabel=new JLabel("Email");
		     emaillabel.setFont(new Font("Tahoma",Font.BOLD,14));
		     emaillabel.setBounds(50, 100, 100, 20);
		     
		     securityQlabel=new JLabel("Security Question");
		     securityQlabel.setFont(new Font("Tahoma",Font.BOLD,14));
		     securityQlabel.setBounds(50, 140, 160, 20);
		     
		     answerlabel=new JLabel("Answer");
		     answerlabel.setFont(new Font("Tahoma",Font.BOLD,14));
		     answerlabel.setBounds(50, 180, 100, 20);
		     
		     newSequrityqlabel=new JLabel("New Security Question");
		     newSequrityqlabel.setFont(new Font("Tahoma",Font.BOLD,14));
		     newSequrityqlabel.setBounds(50, 220, 160, 20);
		     
		     newanswerlabel=new JLabel("Answer");
		     newanswerlabel.setFont(new Font("Tahoma",Font.BOLD,14));
		     newanswerlabel.setBounds(50, 260, 160, 20);
		     
		     emailtextfield=new JTextField();
		     emailtextfield.setBounds(230, 100, 330, 20);
		     emailtextfield.addKeyListener(new KeyAdapter() {
		    	 
		    	 public void keyReleased(KeyEvent e)
		    	 {
		    		 validatefields(); 
		    	 }
		    	 
		     });
		     sqtextfield=new JTextField();
		     sqtextfield.setBounds(230, 140, 330, 20);
		     sqtextfield.addKeyListener(new KeyAdapter() {
		    	 
		    	 public void keyReleased(KeyEvent e)
		    	 {
		    		 validatefields(); 
		    	 }
		    	 
		     });
		     answertextfield=new JTextField();
		     answertextfield.setBounds(230, 180, 330, 20);
		     answertextfield.addKeyListener(new KeyAdapter() {
		    	 
		    	 public void keyReleased(KeyEvent e)
		    	 {
		    		 validatefields(); 
		    	 }
		    	 
		     });
		     newsqtextfield=new JTextField();
		     newsqtextfield.setBounds(230, 220, 330, 20);
		     newsqtextfield.addKeyListener(new KeyAdapter() {
		    	 
		    	 public void keyReleased(KeyEvent e)
		    	 {
		    		 validatefields(); 
		    	 }
		    	 
		     });
		     
		     
		     newanswertextfield=new JTextField();
		     newanswertextfield.setBounds(230, 260, 330, 20);
		     newanswertextfield.addKeyListener(new KeyAdapter() {
		    	 
		    	 public void keyReleased(KeyEvent e)
		    	 {
		    		 validatefields(); 
		    	 }
		    	 
		     });
		     
		     updateicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\save.png");
		    update=new JButton("Update");
		    update.setIcon(updateicon);
		    update.setFont(new Font("Tahoma",Font.BOLD,14));
		     update.setBounds(160,315, 130, 20);
		     update.setFocusable(false);
		     update.setEnabled(false);
		     update.addActionListener(new ActionListener(){
		    	 public void actionPerformed(ActionEvent e)
		    	 {
		    		
		    		 String email=emailtextfield.getText();
		    		 String answertext=answertextfield.getText();
		    		 String newanswer=newanswertextfield.getText();
		    		 String newsq=newsqtextfield.getText();
		    		 User user=new User();
		    		  user=userdao.search(email);
		    		  dbanswer=user.getAnswer();
		    		  if(dbanswer.equals(answertext))
		    		  {
		    			  
		    			userdao.updatesq(email,newanswer, newsq);
		    			  
		    		  }
		    		  else
		    		  {
		    				JOptionPane.showMessageDialog(null,"<html><b style=\"color:red\">INcorrect Answer address</b></html>","selection",JOptionPane.ERROR_MESSAGE);  
		    		  }
		    		
		    		  frame.setVisible(false);
		    		  new changesq(emailsq);
		    		
		    		
		    	 }
		    	 
		     });
		     
		 	clearicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\clear.png");
			clear=new JButton("Clear");
			clear.setIcon(clearicon);
			clear.setFocusable(false);
			clear.setFont(new Font("Tahoma",Font.BOLD,14));
			clear.setBounds(380, 315, 130, 20);
			clear.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
				     clear();	
				}
			});
		     
			home=new JButton("Home");
			home.setFocusable(false);
			home.setBounds(250, 355,180,20);
			home.addActionListener(new ActionListener()
					{
				public void  actionPerformed(ActionEvent e)
				{
					frame.setVisible(false);
				     new home(emailsq);	
				}
					});
			
			searchicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\search.png");
			search=new JButton("Search");
			search.setIcon(searchicon);
			search.setFont(new Font("Tahoma",Font.BOLD,12));
			search.setFocusable(false);
			search.setBounds(580, 100, 110, 20);
			 
				emailtextfield.setText(emailsq);
		     search.addActionListener(new ActionListener()
    		 {

			
				public void actionPerformed(ActionEvent e) {
					try
					{
					  
						
						String searchemail=emailtextfield.getText();
						User user=new User();
						user=userdao.search(searchemail);
						dbemail=user.getEmail();
						if(dbemail.equals(searchemail))
						{
							emailtextfield.setEditable(false); 
							sqtextfield.setText(user.getSecurityQuestion());
							sqtextfield.setEditable(false);
							search.setEnabled(false);
							
						}
					}
					catch(Exception exceprtion)
					{
						JOptionPane.showMessageDialog(null,"<html><b style=\"color:pink\">Unregister email address</b></html>","selection",JOptionPane.ERROR_MESSAGE);
					}
					
				}
    	 
    		 });
			
			
			
			closeicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\close.PNG");
			close=new JButton();
			close.setIcon(closeicon);
			close.setBounds(650, 30, 30, 30);
            close.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent e) {
					
					frame.setVisible(false);
					new home( emailsq);
					
				}
			});
			sqlabel=new JLabel("Change Security Question ? ");
			sqlabel.setFont(new Font ("Tahoma ",Font.BOLD,25));
			sqlabel.setBounds(200,40,450,30);
			sqlabel.setForeground(new Color(255,255,255));
			
			
			
			frame.add(sqlabel);
			frame.add(close);
			frame.add(search);
			frame.add(update);
			frame.add(clear);
			frame.add(home);
		     frame.add(newanswertextfield);
		     frame.add(newsqtextfield);
		     frame.add(answertextfield);
		     frame.add(sqtextfield);
		     frame.add(emailtextfield);
		     frame.add(newanswerlabel);
		     frame.add(newSequrityqlabel);
		     frame.add(answerlabel);
		     frame.add(securityQlabel);
		     frame.add(emaillabel);
		     frame.add(back);
		     
		     frame.setVisible(true);
		
	}
	public changesq()
	{
		 frame=new JFrame();
		    frame.setSize(700,400);
		    frame.setLayout(null);
		    frame.setUndecorated(true);
		     frame.setLocation(350,134);
		     
		     backicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\small-page-background.PNG");
		     back=new JLabel();
		     back.setBounds(0, 0, 700, 400);
		     back.setIcon(backicon);
		     
		     emaillabel=new JLabel("Email");
		     emaillabel.setFont(new Font("Tahoma",Font.BOLD,14));
		     emaillabel.setBounds(50, 100, 100, 20);
		     
		     securityQlabel=new JLabel("Security Question");
		     securityQlabel.setFont(new Font("Tahoma",Font.BOLD,14));
		     securityQlabel.setBounds(50, 140, 160, 20);
		     
		     answerlabel=new JLabel("Answer");
		     answerlabel.setFont(new Font("Tahoma",Font.BOLD,14));
		     answerlabel.setBounds(50, 180, 100, 20);
		     
		     newSequrityqlabel=new JLabel("New Security Question");
		     newSequrityqlabel.setFont(new Font("Tahoma",Font.BOLD,14));
		     newSequrityqlabel.setBounds(50, 220, 160, 20);
		     
		     newanswerlabel=new JLabel("Answer");
		     newanswerlabel.setFont(new Font("Tahoma",Font.BOLD,14));
		     newanswerlabel.setBounds(50, 260, 160, 20);
		     
		     emailtextfield=new JTextField();
		     emailtextfield.setBounds(230, 100, 330, 20);
		     emailtextfield.addKeyListener(new KeyAdapter() {
		    	 
		    	 public void keyReleased(KeyEvent e)
		    	 {
		    		 validatefields(); 
		    	 }
		    	 
		     });
		     sqtextfield=new JTextField();
		     sqtextfield.setBounds(230, 140, 330, 20);
		     sqtextfield.addKeyListener(new KeyAdapter() {
		    	 
		    	 public void keyReleased(KeyEvent e)
		    	 {
		    		 validatefields(); 
		    	 }
		    	 
		     });
		     answertextfield=new JTextField();
		     answertextfield.setBounds(230, 180, 330, 20);
		     answertextfield.addKeyListener(new KeyAdapter() {
		    	 
		    	 public void keyReleased(KeyEvent e)
		    	 {
		    		 validatefields(); 
		    	 }
		    	 
		     });
		     newsqtextfield=new JTextField();
		     newsqtextfield.setBounds(230, 220, 330, 20);
		     emailtextfield.addKeyListener(new KeyAdapter() {
		    	 
		    	 public void keyReleased(KeyEvent e)
		    	 {
		    		 validatefields(); 
		    	 }
		    	 
		     });
		     newanswertextfield=new JTextField();
		     newanswertextfield.setBounds(230, 260, 330, 20);
		     newanswertextfield.addKeyListener(new KeyAdapter() {
		    	 
		    	 public void keyReleased(KeyEvent e)
		    	 {
		    		 validatefields(); 
		    	 }
		    	 
		     });
		     updateicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\save.png");
		    update=new JButton("Update");
		    update.setIcon(updateicon);
		    update.setFont(new Font("Tahoma",Font.BOLD,14));
		     update.setBounds(160,315, 130, 20);
		     update.setEnabled(false);
		     update.setFocusable(false);
		     update.addActionListener(new ActionListener(){
		    	 public void actionPerformed(ActionEvent e)
		    	 {
		    		
		    		 String email=emailtextfield.getText();
		    		 String answertext=answertextfield.getText();
		    		 String newanswer=newanswertextfield.getText();
		    		 String newsq=newsqtextfield.getText();
		    		 User user=new User();
		    		  user=userdao.search(email);
		    		  dbanswer=user.getAnswer();
		    		  if(dbanswer.equals(answertext))
		    		  {
		    			  
		    			userdao.updatesq(email,newanswer, newsq);

			    		  frame.setVisible(false);
			    		  
			    		  new changesq();
			    		  search.setVisible(true);
			    		  search.setVisible(true);
		    			  
		    		  }
		    		  else
		    		  {
		    				JOptionPane.showMessageDialog(null,"<html><b style=\"color:red\">INcorrect Answer address</b></html>","selection",JOptionPane.ERROR_MESSAGE);  
		    		  }
		    		
		    		
		    		
		    	 }
		    	 
		     });
		     
		 	clearicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\clear.png");
			clear=new JButton("Clear");
			clear.setIcon(clearicon);
			clear.setFocusable(false);
			clear.setFont(new Font("Tahoma",Font.BOLD,14));
			clear.setBounds(380, 315, 130, 20);
			clear.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
				     clear();	
				}
			});
		     
			home=new JButton("Home");
			home.setFocusable(false);
			home.setBounds(250, 355,180,20);
			home.addActionListener(new ActionListener()
					{
				public void  actionPerformed(ActionEvent e)
				{
					frame.setVisible(false);
				     new home();	
				}
					});
			
			
			searchicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\search.png");
			search=new JButton("Search");
			search.setIcon(searchicon);
			search.setFont(new Font("Tahoma",Font.BOLD,12));
			search.setFocusable(false);
			search.setBounds(580, 100, 110, 20);
		     search.addActionListener(new ActionListener()
		    		 {

					
						public void actionPerformed(ActionEvent e) {
							try
							{
							
								String searchemail=emailtextfield.getText();
								User user=new User();
								user=userdao.search(searchemail);
								dbemail=user.getEmail();
								if(dbemail.equals(searchemail))
								{
									emailtextfield.setEditable(false); 
									sqtextfield.setText(user.getSecurityQuestion());
									sqtextfield.setEditable(false);
									 search.setEnabled(false);
									
								}
							}
							catch(Exception exceprtion)
							{
								JOptionPane.showMessageDialog(null,"<html><b style=\"color:pink\">Unregister email address</b></html>","selection",JOptionPane.ERROR_MESSAGE);
							}
							
						}
		    	 
		    		 });
			
			closeicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\close.PNG");
			close=new JButton();
			close.setIcon(closeicon);
			close.setBounds(650, 30, 25, 25);
			close.addActionListener(new ActionListener() {
				
		
				public void actionPerformed(ActionEvent e) {
					
					frame.setVisible(false);
					new home();
					
				}
			});
			

			sqlabel=new JLabel("Change Security Question ? ");
			sqlabel.setFont(new Font ("Tahoma ",Font.BOLD,25));
			sqlabel.setBounds(200,40,450,30);
			sqlabel.setForeground(new Color(255,255,255));
			frame.add(sqlabel);
			frame.add(close);
			frame.add(search);
			frame.add(update);
			frame.add(clear);
			frame.add(home);
		     frame.add(newanswertextfield);
		     frame.add(newsqtextfield);
		     frame.add(answertextfield);
		     frame.add(sqtextfield);
		     frame.add(emailtextfield);
		     frame.add(newanswerlabel);
		     frame.add(newSequrityqlabel);
		     frame.add(answerlabel);
		     frame.add(securityQlabel);
		     frame.add(emaillabel);
		     frame.add(back);
		     
		     
		     frame.setVisible(true);
	}
public void validatefields()
{
	
	String email=emailtextfield.getText();
	String answer=answertextfield.getText();
	String newanswer=newanswertextfield.getText();
	String newsq=newsqtextfield.getText();
	if(email.matches(emailpattern) && !answer.equals("") && !newanswer.equals("") && !newanswer.equals("") )
	{
		update.setEnabled(true);
	}
	else
	{
		update.setEnabled(false);
	}
}
	  public void clear()
	  {
		  emailtextfield.setText("");
		  sqtextfield.setText("");
		  answertextfield.setText("");
		  newsqtextfield.setText("");
		  newanswertextfield.setText("");
		  emailtextfield.setEditable(true);
		  sqtextfield.setEditable(true);
		  update.setEnabled(false);
		  search.setEnabled(true);
	  }
	public static void main(String[] args) {
		new changesq();
	}

}
