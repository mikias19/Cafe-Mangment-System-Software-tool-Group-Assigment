package CafeMangment;

import java.awt.Font;
import Model.productmodel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Model.Category;
import dao.categorydao;
import dao.productdao;

public class product {
	
	private JFrame frame;
	private JLabel back;
	private ImageIcon backicon;
	private JLabel newproduct;
	private ImageIcon newproducticon;
	private JLabel name ;
	private JLabel category;
	private JLabel price;
	private JTextField nametextfield;
	private JComboBox categorycombobox;
	private JTextField pricetextfield;
	private JButton save;
	private ImageIcon saveicon;
	private JButton clear;
	private ImageIcon clearicon;
	private JButton close;
	private ImageIcon closeicon;
	
	public product()
	{
		 frame=new JFrame();
		    frame.setSize(700,400);
		    frame.setLayout(null);
		    frame.setUndecorated(true);
		     frame.setLocation(350,134);
		     
		     backicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\small-page-background.PNG");
		     back=new JLabel();
		     back.setIcon(backicon);
		     back.setBounds(0, 0, 700, 400);
		     
		     newproducticon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\new product.PNG");
		     newproduct=new JLabel("New Product");
		     newproduct.setIcon(newproducticon);
		     newproduct.setFont(new Font("Tahoma",Font.BOLD,14));
		     newproduct.setBounds(20, 20, 250, 20);
		     
		     
		     closeicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\close.PNG");
		     close=new JButton();
		     close.setIcon(closeicon);
		     close.setBounds(650, 20, 30, 30);
		     close.setFont(new Font("Tahoma",Font.BOLD,14));
		     close.addActionListener(new ActionListener() {

			
				public void actionPerformed(ActionEvent e) {
					
					frame.setVisible(false);
					new home();
					
				}
		    	 
		     });
		     
		     name=new JLabel("Name");
		     name.setFont(new Font("Tahoma",Font.BOLD,14));
		     name.setBounds(100, 100, 50, 20);
		     
		     nametextfield=new JTextField();
		     nametextfield.setBounds(200, 100, 300, 20);
		     
		     category=new JLabel("Category");
		     category.setBounds(100,140,80,20);
		     category.setFont(new Font("Tahoma",Font.BOLD,14));
		     
		     
		     categorycombobox=new JComboBox();
		     categorycombobox.setBounds(200,140,300,20);
		     
		     price=new JLabel("Price");
		     price.setFont(new Font("Tahoma",Font.BOLD,14));
		     price.setBounds(100, 180, 50, 20);
		     
		     pricetextfield=new JTextField();
		     pricetextfield.setBounds(200, 180, 300, 20);
		     
		     clearicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\clear.PNG");
		     clear=new JButton("Clear");
		     clear.setIcon(clearicon);
		     clear.setBounds(380,230, 100, 20);
		     clear.addActionListener(new ActionListener() {

					
					public void actionPerformed(ActionEvent e) {
						
						clear();
						
					}
					
					});

		     saveicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\save.PNG");
		     save=new JButton("Save");
		     save.setIcon(saveicon);
		     save.setBounds(230,230, 100, 20);
		     save.addActionListener(new ActionListener() {
		    	
				
				public void actionPerformed(ActionEvent e) {
					
					productmodel  product=new productmodel();
					
					product.setName(nametextfield.getText());
					product.setCategory((String)categorycombobox.getSelectedItem());
					product.setPrice(pricetextfield.getText());
					
					productdao.save(product);
				
				  
				
		
				  frame.setVisible(false);
				 new  product();
				}
		    	 
		     });
		   
		    
		     
		   
		    		 ArrayList<Category> list  = categorydao.arraylist(); 
		  		   
		  		   
		  		   Iterator<Category> itr=list.iterator();
		  		   
		  		   while(itr.hasNext())
		  		   {
		  			   Category categoryobj=itr.next();
		  			  
		  			   categorycombobox.addItem(categoryobj.getName());
		  			   
		  			   
		  		   }
		    	
		  
		     
		     
		     
		     
		     
		     
		     
		     
		     
		     
		     
		     
		     
		     frame.add(save);
		     frame.add(clear);
		     frame.add(nametextfield);
		     frame.add(pricetextfield);
		     frame.add(price);
		     frame.add(categorycombobox);
		     frame.add(category);
		     frame.add(name);
		     frame.add(close);
		     frame.add(newproduct);
		     frame.add(back);
		     frame.setVisible(true);
		    
	}
	
	
	
	public product(String email)
	{
		 frame=new JFrame();
		    frame.setSize(700,400);
		    frame.setLayout(null);
		    frame.setUndecorated(true);
		     frame.setLocation(350,134);
		     
		     backicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\small-page-background.PNG");
		     back=new JLabel();
		     back.setIcon(backicon);
		     back.setBounds(0, 0, 700, 400);
		     
		     newproducticon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\new product.PNG");
		     newproduct=new JLabel("New Product");
		     newproduct.setIcon(newproducticon);
		     newproduct.setFont(new Font("Tahoma",Font.BOLD,14));
		     newproduct.setBounds(20, 20, 250, 20);
		     
		     
		     closeicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\close.PNG");
		     close=new JButton();
		     close.setIcon(closeicon);
		     close.setBounds(650, 20, 30, 30);
		     close.setFont(new Font("Tahoma",Font.BOLD,14));
		     close.addActionListener(new ActionListener() {

			
				public void actionPerformed(ActionEvent e) {
					
					frame.setVisible(false);
					new home(email);
					
				}
		    	 
		     });
		     
		     name=new JLabel("Name");
		     name.setFont(new Font("Tahoma",Font.BOLD,14));
		     name.setBounds(100, 100, 50, 20);
		     
		     nametextfield=new JTextField();
		     nametextfield.setBounds(200, 100, 300, 20);
		     
		     category=new JLabel("Category");
		     category.setBounds(100,140,80,20);
		     category.setFont(new Font("Tahoma",Font.BOLD,14));
		     
		     
		     categorycombobox=new JComboBox();
		     categorycombobox.setBounds(200,140,300,20);
		     
		     price=new JLabel("Price");
		     price.setFont(new Font("Tahoma",Font.BOLD,14));
		     price.setBounds(100, 180, 50, 20);
		     
		     pricetextfield=new JTextField();
		     pricetextfield.setBounds(200, 180, 300, 20);
		     
		     clearicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\clear.PNG");
		     clear=new JButton("Clear");
		     clear.setIcon(clearicon);
		     clear.setBounds(380,230, 100, 20);
		     clear.addActionListener(new ActionListener() {

					
					public void actionPerformed(ActionEvent e) {
						
						clear();
						
					}
					
					});

		     saveicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\save.PNG");
		     save=new JButton("Save");
		     save.setIcon(saveicon);
		     save.setBounds(230,230, 100, 20);
		     save.addActionListener(new ActionListener() {
		    	
				
				public void actionPerformed(ActionEvent e) {
					
					productmodel  product=new productmodel();
					
					product.setName(nametextfield.getText());
					product.setCategory((String)categorycombobox.getSelectedItem());
					product.setPrice(pricetextfield.getText());
					
					productdao.save(product);
				
				  
				
		
				  frame.setVisible(false);
				 new  product();
				}
		    	 
		     });
		   
		    
		     
		   
		    		 ArrayList<Category> list  = categorydao.arraylist(); 
		  		   
		  		   
		  		   Iterator<Category> itr=list.iterator();
		  		   
		  		   while(itr.hasNext())
		  		   {
		  			   Category categoryobj=itr.next();
		  			  
		  			   categorycombobox.addItem(categoryobj.getName());
		  			   
		  			   
		  		   }
		    	
		  
		     
		     
		     
		     
		     
		     
		     
		     
		     
		     
		     
		     
		     
		     frame.add(save);
		     frame.add(clear);
		     frame.add(nametextfield);
		     frame.add(pricetextfield);
		     frame.add(price);
		     frame.add(categorycombobox);
		     frame.add(category);
		     frame.add(name);
		     frame.add(close);
		     frame.add(newproduct);
		     frame.add(back);
		     frame.setVisible(true);
		    
	}
	public void clear()
	{
		nametextfield.setText("");
		pricetextfield.setText("");
	}

	public static void main(String[] args) {
		new product();

	}

}
