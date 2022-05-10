package CafeMangment;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import dao.categorydao;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import Model.Bill;
import Model.Category;
import Model.productmodel;
import common.openpdf;
import dao.billdao;
import dao.categorydao;
import dao.productdao;

public class PlaceOrder {
	
	private JFrame frame;
	private JLabel back;
	private ImageIcon backicon;
	private JLabel placeorder;
	private ImageIcon placeordericon;
	private JLabel billid;
	private JLabel billidreturn;
	private JLabel customerdetail;
	private JLabel name;
	private JTextField nametextfield;
	private JLabel mobilenumber;
	private JTextField mobiletextfield;
	private JLabel emaile;
	private JTextField emailtextfield;
	private JLabel procategory;
	private JComboBox procategorycombo;
	private JLabel search;
	private JTextField searchtextfield;
	private JTable table1;
	private JLabel nametabel;
	private JTextField nametexttable;
	private JLabel quantity;
	private JSpinner quantityspinner;
	private JLabel price;
	private JTextField pricetextfield;
	private JLabel total;
	private JTextField totaltextfield;
	private JButton clear;
	private ImageIcon clearicon;
	private JButton addtocart;
	private ImageIcon addtocarticon;
	private JButton close;
	private ImageIcon closeicon;
	private JTable table2;
	private JLabel grandtotal;
	private JLabel gtandtotalresult;
	private JButton generatebill;
	private ImageIcon generateicon;
	private String[] colomn={"Name"};
	private String[] colomns= {"Name","Price","Quantity","Total"};
	private DefaultTableModel model;
	private DefaultTableModel secondmodel;
	private JFormattedTextField tf;
	public int billidvar=1;
	public int grandtotalvar=0;
	public int productprice=0;
	public int producttotalvar=1;
	public String emailpatter="^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";
	public String mobilepatter="^[0-9]*$";
	public String useremail;

	public PlaceOrder(String email)
	{
		
		frame=new JFrame();
	      frame.setSize(1360,768);
	      frame.setLayout(null);
	      frame.setUndecorated(true);
	      
	      backicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\full-page-background.PNG");
		     back=new JLabel();
		     back.setIcon(backicon);
		     back.setBounds(0, 0, 1360, 768);
		     
		  placeordericon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\place order.png");
	      placeorder=new JLabel("Place Order");
	      placeorder.setIcon(placeordericon);
	      placeorder.setFont(new Font ("Tahoma",Font.BOLD,14));
	      placeorder.setBounds(50, 50, 130,20);
	      
	      closeicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\close.PNG");
		     close=new JButton();
		     close.setIcon(closeicon);
		     close.setBounds(1300, 40, 30, 30);
		     close.setFocusable(false);
		     close.addActionListener(new ActionListener() {

			
				public void actionPerformed(ActionEvent e) {
					
					frame.setVisible(false);
					new home(email);
					
				}
		    	 
		     }); 
		     
		     
		     
		     billid=new JLabel("Bill Id:");
		     billid.setFont(new Font ("Tahoma",Font.BOLD,14));
		     billid.setBounds(70, 110, 50,20);
	      
		     
		     billidreturn=new JLabel("--");
		     billidreturn.setFont(new Font ("Tahoma",Font.BOLD,14));
		     billidreturn.setBounds(125, 116, 150,20);
		    billidvar=Integer.parseInt(billdao.getId());
		    billidreturn.setText(billdao.getId());
		     
		     
		     customerdetail=new JLabel("Customer Details:");
		     customerdetail.setFont(new Font ("Tahoma",Font.BOLD,14));
		     customerdetail.setBounds(70, 160, 180,20);
		     
		     name=new JLabel("Name");
		     name.setFont(new Font ("Tahoma",Font.BOLD,14));
		     name.setBounds(70, 210, 100,20);
		     
		     nametextfield=new JTextField();
		     nametextfield.setFont(new Font ("Tahoma",Font.BOLD,14));
		     nametextfield.setBounds(70, 260, 250,20);
		     
		     mobilenumber=new JLabel("MobileNumber");
		     mobilenumber.setFont(new Font ("Tahoma",Font.BOLD,14));
		     mobilenumber.setBounds(70, 310, 100,20);
		     
		     mobiletextfield=new JTextField();
		     mobiletextfield.setFont(new Font ("Tahoma",Font.BOLD,14));
		     mobiletextfield.setBounds(70, 360, 250,20);
		     
		     emaile=new JLabel("Email");
		     emaile.setFont(new Font ("Tahoma",Font.BOLD,14));
		     emaile.setBounds(70, 410, 100,20);
		     
		     emailtextfield=new JTextField();
		     emailtextfield.setFont(new Font ("Tahoma",Font.BOLD,14));
		     emailtextfield.setBounds(70, 460, 250,20);
		     
		     procategory=new JLabel("Category");
		     procategory.setFont(new Font ("Tahoma",Font.BOLD,14));
		     procategory.setBounds(350, 110, 100,20);
		     
		     procategorycombo=new JComboBox();
		     procategory.setFont(new Font ("Tahoma",Font.BOLD,14));
		     procategorycombo.setBounds(350, 160, 250,20);
		     ArrayList<Category> list  = categorydao.arraylist(); 
		     Iterator<Category>itr=list.iterator();
		     while(itr.hasNext())
		     {
		    	 Category categoryobj=itr.next();
		    	 procategorycombo.addItem(categoryobj.getName());
		     }
		     procategorycombo.addActionListener(new ActionListener() 
		     
		     {
		    	

				@Override
				public void actionPerformed(ActionEvent e) {
				
					String category=(String)procategorycombo.getSelectedItem();
		    		 productnamebycategory(category);
					
				}
		    	 
		     });
		    search=new JLabel("Search");
		    search.setFont(new Font ("Tahoma",Font.BOLD,14));
		    search.setBounds(350, 210, 100,20);
		    
		    searchtextfield=new JTextField();
		    searchtextfield.setFont(new Font ("Tahoma",Font.BOLD,14));
		    searchtextfield.setBounds(350,260 , 250,20);
		    searchtextfield.addKeyListener(new KeyAdapter() 
		     
		     {
		    	public void keyReleased(KeyEvent e)
		    	 {
		    		 String name=searchtextfield.getText();
		    		 String category=(String)procategorycombo.getSelectedItem();
		    		 productfilterbynameandcategory (name,category);
		    	 }
		    	 
		     });
		    searchtextfield.addMouseListener(new MouseAdapter() {
		    	
		    	public void mouseClicked()
		    	{
		    		int index=table1.getSelectedRow();
		    		TableModel model=table1.getModel();
		    		String name=model.getValueAt(index, 0).toString();
		    		productmodel product=productdao.getproductbyname(name);
		    		nametexttable.setText(product.getName());
		    		pricetextfield.setText(product.getPrice());
		    		quantityspinner.setValue(1);
		    		totaltextfield.setText(product.getPrice());
		    		productprice=Integer.parseInt(product.getPrice());
		    		producttotalvar=Integer.parseInt(product.getPrice());
		    		addtocart.setEnabled(true);
		    	}
		    });
	    
		    table1=new JTable();
		    model=new DefaultTableModel();
		     model.setColumnIdentifiers(colomn);
		    table1.setModel(model);
		   table1.setBounds(350,310,250,380);
		    table1.setFont(new Font("Tahoma",Font.BOLD,14));
		    table1.setBackground(Color.WHITE);
		    table1.setForeground(Color.BLACK);
		    JScrollPane pane=new JScrollPane(table1);
		    pane.setBounds(350,310,250,380);
		    
		    
		    nametabel=new JLabel("Name");
		    nametabel.setFont(new Font("Tahoma",Font.BOLD,14));
		    nametabel.setBounds(630, 110, 100, 20);
		    
		    
		    nametexttable=new JTextField();
		    nametexttable.setFont(new Font("Tahoma",Font.BOLD,14));
		    nametexttable.setBounds(630, 160, 250, 20);
		    nametexttable.setEditable(false);
		    
		    quantity=new JLabel("Quantity");
		    quantity.setFont(new Font("Tahoma",Font.BOLD,14));
		    quantity.setBounds(630, 210, 250, 20);
		    
		    quantityspinner=new JSpinner();
		    quantityspinner.setFont(new Font("Tahoma",Font.BOLD,12));
		    quantityspinner.setBounds(630, 260, 250, 20);
		    JFormattedTextField tf=((JSpinner.DefaultEditor) quantityspinner.getEditor()).getTextField();
		     tf.setEditable(false);
		   
		    
		    
		    price=new JLabel("Price");
		    price.setFont(new Font("Tahoma",Font.BOLD,14));
		    price.setBounds(1080, 110, 250, 20);
		  
		    pricetextfield=new JTextField();
		    pricetextfield.setFont(new Font("Tahoma",Font.BOLD,12));
		    pricetextfield.setBounds(1080, 160, 250, 20);
		    pricetextfield.setEditable(false);
		    
		    total=new JLabel("Total");
		    total.setFont(new Font("Tahoma",Font.BOLD,14));
		    total.setBounds(1080, 210, 310, 20);
		    
		    totaltextfield=new JTextField();
		    totaltextfield.setFont(new Font("Tahoma",Font.BOLD,12));
		    totaltextfield.setBounds(1080, 260, 250, 20);
		    totaltextfield.setEditable(false);
		     
			  clearicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\clear.PNG");
			     clear=new JButton("Clear");
			     clear.setIcon(clearicon);
			     clear.setBounds(680,310, 120, 25);
			     clear.setFocusable(false);
			     clear.addActionListener(new ActionListener() {

						
						public void actionPerformed(ActionEvent e) {
							
							
						}
						
						});
			     addtocarticon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\add to cart.png");
			     addtocart=new JButton("Add To Cart");
			     addtocart.setIcon(addtocarticon);
			     addtocart.setFocusable(false);
			     addtocart.setFont(new Font ("Tahoma",Font.BOLD,14));
			     addtocart.setBounds(1130, 310, 150, 25);
			     addtocart.setEnabled(false);
			     addtocart.addActionListener(new ActionListener() {
			    	
						
						public void actionPerformed(ActionEvent e) {
							
							
						}
						
						});
			     
			     
			   secondmodel=new DefaultTableModel();
			     table2=new JTable();
			     secondmodel.setColumnIdentifiers(colomns);
			     table2.setModel(secondmodel);
			    JScrollPane secondpane =new JScrollPane(table2);
			    secondpane.setBounds(630, 350, 720, 300);
			     
			     
			    grandtotal=new JLabel("GrandTotal:");
			    grandtotal.setFont(new Font("Tahoma",Font.BOLD,14));
			    grandtotal.setBounds(640, 670, 100, 20);
			    
			    gtandtotalresult=new JLabel("0000");
			    gtandtotalresult.setFont(new Font("Tahoma",Font.BOLD,14));
			    gtandtotalresult.setBounds(743, 670, 200, 20);
			    
			    generateicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\generate bill & print.png");
			    generatebill=new JButton("Generat Bill and Print");
			    generatebill.setIcon(generateicon);
			    generatebill.setFont(new Font("Tahoma",Font.BOLD,14));
			    generatebill.setFocusable(false);
			    generatebill.setBounds(1050, 670, 250, 30);
			    generatebill.setEnabled(false);
		    
			   frame.add(gtandtotalresult);
			 frame.add(grandtotal);
		   frame.add(generatebill);
			frame.add(secondpane);
			frame.add(addtocart);
			frame.add(clear);
		    frame.add(price);
		    frame.add(pricetextfield);
		    frame.add(total);
		    frame.add(totaltextfield);
		    frame.add(nametexttable);
		    frame.add(quantityspinner);
		    frame.add(quantity);
		    frame.add(nametabel);
		    frame.add(pane);
		    frame.add(search);
		    frame.add(searchtextfield);
		    frame.add(procategorycombo);
		    frame.add(procategory);
		    frame.add(emaile);
		   frame.add(emailtextfield);
		   frame.add(mobilenumber);
		   frame.add(mobiletextfield);
		     
		   frame.add(customerdetail);
		   frame.add(name);
		   frame.add(nametextfield);
		  frame.add(billid);
		  frame.add(billidreturn);
	      frame.add(close);
	      frame.add(placeorder);
		  frame.add(back);
	      frame.setVisible(true); 
	}
	
	
	
	
	

	public PlaceOrder()
	{
		
		frame=new JFrame();
	      frame.setSize(1360,768);
	      frame.setLayout(null);
	      frame.setUndecorated(true);
	      
	      backicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\full-page-background.PNG");
		     back=new JLabel();
		     back.setIcon(backicon);
		     back.setBounds(0, 0, 1360, 768);
		     
		  placeordericon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\place order.png");
	      placeorder=new JLabel("Place Order");
	      placeorder.setIcon(placeordericon);
	      placeorder.setFont(new Font ("Tahoma",Font.BOLD,14));
	      placeorder.setBounds(50, 50, 130,20);
	      
	      closeicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\close.PNG");
		     close=new JButton();
		     close.setIcon(closeicon);
		     close.setBounds(1300, 40, 30, 30);
		     close.setFocusable(false);
		     close.addActionListener(new ActionListener() {

			
				public void actionPerformed(ActionEvent e) {
					
					frame.setVisible(false);
					new home();
					
				}
		    	 
		     }); 
		     
		     
		     
		     billid=new JLabel("Bill Id:");
		     billid.setFont(new Font ("Tahoma",Font.BOLD,14));
		     billid.setBounds(70, 110, 50,20);
	      
		     
		     billidreturn=new JLabel("--");
		     billidreturn.setFont(new Font ("Tahoma",Font.BOLD,14));
		     billidreturn.setBounds(125, 110, 150,20);
		   billidvar=Integer.parseInt(billdao.getId());
		   billidreturn.setText(billdao.getId());
		     
		     
		     
		     customerdetail=new JLabel("Customer Details:");
		     customerdetail.setFont(new Font ("Tahoma",Font.BOLD,14));
		     customerdetail.setBounds(70, 160, 180,20);
		     
		     name=new JLabel("Name");
		     name.setFont(new Font ("Tahoma",Font.BOLD,14));
		     name.setBounds(70, 210, 100,20);
		     
		     nametextfield=new JTextField();
		     nametextfield.setFont(new Font ("Tahoma",Font.BOLD,14));
		     nametextfield.setBounds(70, 260, 250,20);
		     nametextfield.addKeyListener(new KeyAdapter() 
		     
		     {
		    	public void keyReleased(KeyEvent e)
		    	 {
		    		 validatefiled();
		    	 }
		    	 
		     });
		   
		     mobilenumber=new JLabel("MobileNumber");
		     mobilenumber.setFont(new Font ("Tahoma",Font.BOLD,14));
		     mobilenumber.setBounds(70, 310, 100,20);
		     
		     mobiletextfield=new JTextField();
		     mobiletextfield.setFont(new Font ("Tahoma",Font.BOLD,14));
		     mobiletextfield.setBounds(70, 360, 250,20);
		     mobiletextfield.addKeyListener(new KeyAdapter() 
		     
		     {
		    	public void keyReleased(KeyEvent e)
		    	 {
		    		 validatefiled();
		    	 }
		    	 
		     });
		   
		     emaile=new JLabel("Email");
		     emaile.setFont(new Font ("Tahoma",Font.BOLD,14));
		     emaile.setBounds(70, 410, 100,20);
		     
		     emailtextfield=new JTextField();
		     emailtextfield.setFont(new Font ("Tahoma",Font.BOLD,14));
		     emailtextfield.setBounds(70, 460, 250,20);
		     emailtextfield.addKeyListener(new KeyAdapter() 
		     
		     {
		    	public void keyReleased(KeyEvent e)
		    	 {
		    		 validatefiled();
		    	 }
		    	 
		     });
		   
		     
		     procategory=new JLabel("Category");
		     procategory.setFont(new Font ("Tahoma",Font.BOLD,14));
		     procategory.setBounds(350, 110, 100,20);
		     
		     procategorycombo=new JComboBox();
		     procategory.setFont(new Font ("Tahoma",Font.BOLD,14));
		     procategorycombo.setBounds(350, 160, 250,20);
		     ArrayList<Category> list  = categorydao.arraylist(); 
		     Iterator<Category>itr=list.iterator();
		     while(itr.hasNext())
		     {
		    	 Category categoryobj=itr.next();
		    	 procategorycombo.addItem(categoryobj.getName());
		     }
		     procategorycombo.addActionListener(new ActionListener() 
		     
		     {
		    	

				@Override
				public void actionPerformed(ActionEvent e) {
				
					String category=(String)procategorycombo.getSelectedItem();
		    		 productnamebycategory(category);
					
				}
		    	 
		     });
		    search=new JLabel("Search");
		    search.setFont(new Font ("Tahoma",Font.BOLD,14));
		    search.setBounds(350, 210, 100,20);
		    
		    searchtextfield=new JTextField();
		    searchtextfield.setFont(new Font ("Tahoma",Font.BOLD,14));
		    searchtextfield.setBounds(350,260 , 250,20);
		    searchtextfield.addKeyListener(new KeyAdapter() 
		     
		     {
		    	public void keyReleased(KeyEvent e)
		    	 {
		    		 String name=searchtextfield.getText();
		    		 String category=(String)procategorycombo.getSelectedItem();
		    		 productfilterbynameandcategory (name,category);
		    	 }
		    	 
		     });
		   
		    
	
		    	
		    	
		    
	    
		    table1=new JTable();
		    model=new DefaultTableModel();
		     model.setColumnIdentifiers(colomn);
		    table1.setModel(model);
		   table1.setBounds(350,310,250,380);
		    table1.setFont(new Font("Tahoma",Font.BOLD,14));
		    table1.setBackground(Color.WHITE);
		    table1.setForeground(Color.BLACK);
		    JScrollPane pane=new JScrollPane(table1);
		    pane.setBounds(350,310,250,380);
                table1.addMouseListener(new MouseAdapter() {
		    	
		    	public void mouseClicked(MouseEvent e)
		    	{
		    		
		    		int index=table1.getSelectedRow();
		    		TableModel model=table1.getModel();
		    		String name=model.getValueAt(index, 0).toString();
		    		productmodel product=productdao.getproductbyname(name);
		    		nametexttable.setText(product.getName());
		    		pricetextfield.setText(product.getPrice());
		    		quantityspinner.setValue(1);
		    		totaltextfield.setText(product.getPrice());
		    		productprice=Integer.parseInt(product.getPrice());
		    		producttotalvar=Integer.parseInt(product.getPrice());
		    		addtocart.setEnabled(true);
		    		DefaultTableModel dtm=(DefaultTableModel)table1.getModel();
					dtm.setNumRows(0);
		    
		    	}
		    });
		    
		    nametabel=new JLabel("Name");
		    nametabel.setFont(new Font("Tahoma",Font.BOLD,14));
		    nametabel.setBounds(630, 110, 100, 20);
		    
		    
		    nametexttable=new JTextField();
		    nametexttable.setFont(new Font("Tahoma",Font.BOLD,14));
		    nametexttable.setBounds(630, 160, 250, 20);
		    nametexttable.setEditable(false);
		    
		    quantity=new JLabel("Quantity");
		    quantity.setFont(new Font("Tahoma",Font.BOLD,14));
		    quantity.setBounds(630, 210, 250, 20);
		    
		    quantityspinner=new JSpinner();
		    quantityspinner.setFont(new Font("Tahoma",Font.BOLD,12));
		    quantityspinner.setBounds(630, 260, 250, 20);
		    JFormattedTextField tf=((JSpinner.DefaultEditor) quantityspinner.getEditor()).getTextField();
		     tf.setEditable(false);
		     quantityspinner.addChangeListener(new ChangeListener() 
		     {

				@Override
				public void stateChanged(ChangeEvent e) {
					int quantitiy=(Integer)quantityspinner.getValue();
					if(quantitiy<=0)
					{
						quantityspinner.setValue(1);
						quantitiy=1;
						
					}
					producttotalvar=productprice*quantitiy;
					totaltextfield.setText(String.valueOf(producttotalvar));
					
				}
		    	 
		     });
		    
		    
		    price=new JLabel("Price");
		    price.setFont(new Font("Tahoma",Font.BOLD,14));
		    price.setBounds(1080, 110, 250, 20);
		  
		    pricetextfield=new JTextField();
		    pricetextfield.setFont(new Font("Tahoma",Font.BOLD,12));
		    pricetextfield.setBounds(1080, 160, 250, 20);
		    pricetextfield.setEditable(false);
		    
		    total=new JLabel("Total");
		    total.setFont(new Font("Tahoma",Font.BOLD,14));
		    total.setBounds(1080, 210, 310, 20);
		    
		    totaltextfield=new JTextField();
		    totaltextfield.setFont(new Font("Tahoma",Font.BOLD,12));
		    totaltextfield.setBounds(1080, 260, 250, 20);
		    totaltextfield.setEditable(false);
		     
			  clearicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\clear.PNG");
			     clear=new JButton("Clear");
			     clear.setIcon(clearicon);
			     clear.setBounds(680,310, 120, 25);
			     clear.setFocusable(false);
			     clear.addActionListener(new ActionListener() {

						
						public void actionPerformed(ActionEvent e) {
							
							clearproductfiled();
						}
						
						});
			     addtocarticon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\add to cart.png");
			     addtocart=new JButton("Add To Cart");
			     addtocart.setIcon(addtocarticon);
			     addtocart.setFocusable(false);
			     addtocart.setFont(new Font ("Tahoma",Font.BOLD,14));
			     addtocart.setBounds(1130, 310, 150, 25);
			     addtocart.setEnabled(false);
			     addtocart.addActionListener(new ActionListener() {
			    	
						
						public void actionPerformed(ActionEvent e) {
							
							
							String name=nametexttable.getText();
							String price=pricetextfield.getText();
							String quantity=(String.valueOf(quantityspinner.getValue()));
							String total=totaltextfield.getText();
							
							DefaultTableModel dtm=(DefaultTableModel)table2.getModel();
							dtm.setNumRows(0);
							
							dtm.addRow(new Object[]{name,price,quantity,producttotalvar});
							grandtotalvar=grandtotalvar+producttotalvar;
							gtandtotalresult.setText(String.valueOf(grandtotalvar));
							clearproductfiled();
							
						}
						
						});
			     
			     
			   secondmodel=new DefaultTableModel();
			     table2=new JTable();
			     secondmodel.setColumnIdentifiers(colomns);
			     table2.setModel(secondmodel);
			    JScrollPane secondpane =new JScrollPane(table2);
			    secondpane.setBounds(630, 350, 720, 300);
			    table2.addMouseListener(new MouseAdapter() {
			    	
			    	public void mouseClicked(MouseEvent e)
			    	{
			    		
			    		int index=table2.getSelectedRow();
			    		
			    		int a=JOptionPane.showConfirmDialog(null, "DO yu want to remove this cell","Selection",JOptionPane.YES_NO_OPTION);
			    		if(a==0)
			    		{
			    			TableModel model=table2.getModel();
			    			String total=model.getValueAt(index, 3).toString();
			    			 grandtotalvar=grandtotalvar-Integer.parseInt(total);
			    			 gtandtotalresult.setText(String.valueOf(grandtotalvar));
			    			DefaultTableModel dtm=(DefaultTableModel)table2.getModel();
			    			dtm.removeRow(index);
			    		}
			    
			    	}
			    });
			     
			    grandtotal=new JLabel("GrandTotal:");
			    grandtotal.setFont(new Font("Tahoma",Font.BOLD,14));
			    grandtotal.setBounds(640, 670, 100, 20);
			    
			    gtandtotalresult=new JLabel("0000");
			    gtandtotalresult.setFont(new Font("Tahoma",Font.BOLD,14));
			    gtandtotalresult.setBounds(743, 670, 200, 20);
			    
			    generateicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\generate bill & print.png");
			    generatebill=new JButton("Generat Bill and Print");
			    generatebill.setIcon(generateicon);
			    generatebill.setFont(new Font("Tahoma",Font.BOLD,14));
			    generatebill.setFocusable(false);
			    generatebill.setBounds(1050, 670, 250, 30);
			    generatebill.setEnabled(false);
			    generatebill.addActionListener(new ActionListener()
			    		{

							@Override
							public void actionPerformed(ActionEvent e) {
								String custname=nametextfield.getText();
								String custmobile=mobilenumber.getText();
								String custemail=emailtextfield.getText();
								SimpleDateFormat dFormat=new SimpleDateFormat("dd-MM-yyyy");
								Date date=new Date();
								String todaydate=dFormat.format(date);
								String total=String.valueOf(grandtotalvar);
								String Createdby=useremail;
								
								Bill bill=new Bill();
								bill.setId(billidvar);
								bill.setName(custname);
								bill.setMobilenumber(custmobile);
								bill.setEmail(custemail);
								bill.setDate(todaydate);
								bill.setTotal(total);
								bill.setCreatedby(Createdby);
								billdao.save(bill);
								
								
								String path="C:\\Users\\miki\\Desktop";
								com.itextpdf.text.Document doc=new com.itextpdf.text.Document();
								try
								{
								 PdfWriter.getInstance(doc, new FileOutputStream(path +""+billidvar+".pdf"));	
								 doc.open();
								 Paragraph cafename=new Paragraph("  cafe managment system\n");
								 doc.add(cafename);
								 Paragraph starline=new Paragraph("***************************************************************************");
								 doc.add(starline);
								 Paragraph paragraph3=new Paragraph("\t BillID :"+billidvar+"\nCustomer Name :"+custname+"\n Total paid "+total);
								 doc.add(paragraph3);
								 doc.add(starline);
								 PdfPTable tb1 = new PdfPTable(4);
								 tb1.addCell("Name");
								 tb1.addCell("Price");
								 tb1.addCell("Quantity");
								 tb1.addCell("Total");
								 for(int i=0;i<table2.getRowCount();i++)
								 {
									 String a=table2.getValueAt(i, 0).toString();
									 String b=table2.getValueAt(i, 1).toString();
									 String c=table2.getValueAt(i, 2).toString();
									 String d=table2.getValueAt(i, 3).toString();
									 tb1.addCell(a);
									 tb1.addCell(b);
									 tb1.addCell(c);
									 tb1.addCell(d);
									 
								 }
								 doc.add(tb1);
								 doc.add(starline);
								 Paragraph thankmsg=new Paragraph("Thank You,Please Vist Again.");
								 doc.add(thankmsg);
								 
								 openpdf.openbyid(String.valueOf(billidvar));
								}
							catch(Exception ex)
								{
	                                        JOptionPane.showMessageDialog(null, ex);
								}
								doc.close();
								new PlaceOrder();
							}
			    	
			    		});
		    
			   frame.add(gtandtotalresult);
			 frame.add(grandtotal);
		   frame.add(generatebill);
			frame.add(secondpane);
			frame.add(addtocart);
			frame.add(clear);
		    frame.add(price);
		    frame.add(pricetextfield);
		    frame.add(total);
		    frame.add(totaltextfield);
		    frame.add(nametexttable);
		    frame.add(quantityspinner);
		    frame.add(quantity);
		    frame.add(nametabel);
		    frame.add(pane);
		    frame.add(search);
		    frame.add(searchtextfield);
		    frame.add(procategorycombo);
		    frame.add(procategory);
		    frame.add(emaile);
		   frame.add(emailtextfield);
		   frame.add(mobilenumber);
		   frame.add(mobiletextfield);
		     
		   frame.add(customerdetail);
		   frame.add(name);
		   frame.add(nametextfield);
		  frame.add(billid);
		  frame.add(billidreturn);
	      frame.add(close);
	      frame.add(placeorder);
		  frame.add(back);
	      frame.setVisible(true); 
	}
	
	
	public void validatefiled()
	{
		String name=nametextfield.getText();
		String mobilenum=mobiletextfield.getText();
		
		String email=emailtextfield.getText();
		if(email.matches(emailpatter) && mobilenum.matches(mobilepatter)&&!name.equals("") && grandtotalvar>=0) {
		
			generatebill.setEnabled(true);
			
		}
		else
		{
			generatebill.setEnabled(false);
		}
	}
	public void clearproductfiled()
	{
		nametexttable.setText("");
		pricetextfield.setText("");
		quantityspinner.setValue(1);
		totaltextfield.setText("");
		addtocart.setEnabled(false);
	}
	public void productnamebycategory(String category)
	{
		DefaultTableModel dtm=( DefaultTableModel)table1.getModel();
		dtm.setRowCount(0);
		ArrayList<productmodel>list=productdao.getalldatabycategory(category);
		Iterator<productmodel>itr=list.iterator();
		
		while(itr.hasNext())
		{
			productmodel productobj=itr.next();
			
			dtm.addRow(new Object[] {productobj.getName()});
			
		}
		
	}
	public void productfilterbynameandcategory(String name ,String category)
	{
		DefaultTableModel dtm=( DefaultTableModel)table1.getModel();
		dtm.setRowCount(0);
		
		ArrayList<productmodel>list=productdao.filterproductbyname(name,category);
		Iterator<productmodel>itr=list.iterator();
		
		while(itr.hasNext())
		{
			productmodel productobj=itr.next();
			
			dtm.addRow(new Object[] {productobj.getName()});
			
		}
		
	}
	
	public static void main(String[] args) {
		new PlaceOrder();

	}

}
