package CafeMangment;

import java.awt.Color;
import java.awt.Component;

import Model.Category;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

import dao.categorydao;
import dao.dbo;
import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;





public class ManageCategory {
	private DefaultTableModel model;
	private JFrame frame;
	private JLabel back;
	private ImageIcon backicon;
	private JLabel  managecategory;
	private ImageIcon categoryicon;
	private JButton close;
	private ImageIcon closeicon;
	private JLabel viewcategory;
	private JLabel click;
	private JTable table;
	private JLabel addnewcatagory;
	private JTextField newcatagory;
	private JButton save;
	private ImageIcon saveicon;
	private JButton clear;
	private ImageIcon clearicon;
	
	private Object colomn[]= {"id","category"};
	
	public  ManageCategory(String email)
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
		     
		     
		     
		     categoryicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\category.PNG");
		     managecategory=new JLabel("Manage Category");
		     managecategory.setIcon(categoryicon);
		     managecategory.setFont(new Font("Tahoma",Font.BOLD,14));
		     managecategory.setBounds(5, 10, 200, 20);
		     
		     
		     closeicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\close.PNG");
		     close=new JButton();
		     close.setIcon(closeicon);
		     close.setBounds(670, 10, 20, 20);
		     close.addActionListener(new ActionListener() {

			
				public void actionPerformed(ActionEvent e) {
					
					frame.setVisible(false);
					new home(email);
					
				}
		    	 
		     });
		     
		     viewcategory=new JLabel("View Category");
		     viewcategory.setFont(new Font("Tahoma",Font.BOLD,14));
		     viewcategory.setBounds(480, 70, 150, 20);
		     
		     addnewcatagory=new JLabel("Add New Category");
		     addnewcatagory.setFont(new Font("Tahoma",Font.BOLD,14));
		     addnewcatagory.setBounds(120, 170, 150, 20);
		     
		     newcatagory=new JTextField();
		     newcatagory.setBounds(50, 200, 300, 20);
		     
		   
		     
		     clearicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\clear.PNG");
		     clear=new JButton("Clear");
		     clear.setIcon(clearicon);
		     clear.setBounds(230,240, 100, 20);
		     clear.addActionListener(new ActionListener() {

					
					public void actionPerformed(ActionEvent e) {
						
						clear();
					}
					
					});

		     model=new DefaultTableModel();
		     table=new JTable();
		   model.setColumnIdentifiers(colomn);
		     table.setModel(model);
		     table.setBackground(Color.WHITE);
		     table.setForeground(Color.BLACK);
		     table.setGridColor(Color.RED);
		     table.setFont(new Font("Tahoma",Font.BOLD,14));
		     table.setRowHeight(30);
		     table.setAutoCreateRowSorter(true);
		   JScrollPane pane=new JScrollPane(table);
		   pane.setForeground(Color.RED);
		    pane.setBackground(Color.WHITE);
		   pane.setBounds(360, 110, 330, 200);
		 
		DefaultTableModel dtm=(DefaultTableModel)table.getModel();
		ArrayList<Category>list=categorydao.arraylist();
	      Iterator <Category>itr=list.iterator() ;
	     while(itr.hasNext())
	     {
	    	 Category categoryobj=itr.next();
	    	 dtm.addRow(new Object[] {categoryobj.getId(),categoryobj.getName()});
	    	 
	     }
	       table.addMouseListener(new MouseAdapter()
	    		   {
	    	   public void mouseClicked(MouseEvent e)
	    	   {
	    		  
	    		   int index=table.getSelectedRow();
	    		   TableModel model=table.getModel();
	    		   String id =model.getValueAt(index, 0).toString();
	    		   String name =model.getValueAt(index, 1).toString();
	    			
	    		   int a=JOptionPane.showConfirmDialog(pane, "do you want to delete this category","selection",JOptionPane.YES_NO_OPTION);
	    		   if(a==0)
	    		   {
	    			   
	    			  
	    	   	
	        		   categorydao.delete(id , name); 
	        		  
	        		   new ManageCategory();
	    		   }
	    		   
	 
	    	   }
	    		   });
	       
		   click=new JLabel(" * Click the Category to delete");
		   click.setBounds(430, 325, 220, 20);
		   click.setFont(new Font("Tahoma ",Font.BOLD,14));
		   
		   saveicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\save.PNG");
		     save=new JButton("Save");
		     save.setIcon(saveicon);
		     save.setBounds(80,240, 100, 20);
		     save.addActionListener(new ActionListener() {
		    	
				
				public void actionPerformed(ActionEvent e) {
				
					
				Category category=new Category();
				category.setName(newcatagory.getText());
				categorydao.save(category);
				
		 
				 
				
				
	            
				  frame.setVisible(false);
				  new ManageCategory();
				}
		    	 
		     });
		   
		     
		     frame.add(click);
		   frame.getContentPane().add(pane);
		     frame.add(clear);
		     frame.add(save);
		     frame.add(newcatagory);
		     frame.add(addnewcatagory);
		     frame.add(viewcategory);
		     frame.add(close);
		   frame.add(managecategory);  
		   frame.add(back);
		  
		 frame.setVisible(true);   
		
		 
		
		
	}
	
  public ManageCategory() {
	  frame=new JFrame();
	    frame.setSize(700,400);
	    frame.setLayout(null);
	    frame.setUndecorated(true);
	     frame.setLocation(350,134);
	     
	     backicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\small-page-background.PNG");
	     back=new JLabel();
	     back.setIcon(backicon);
	     back.setBounds(0, 0, 700, 400);
	     
	     
	     
	     categoryicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\category.PNG");
	     managecategory=new JLabel("Manage Category");
	     managecategory.setIcon(categoryicon);
	     managecategory.setFont(new Font("Tahoma",Font.BOLD,14));
	     managecategory.setBounds(5, 10, 200, 20);
	     
	     
	     closeicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\close.PNG");
	     close=new JButton();
	     close.setIcon(closeicon);
	     close.setBounds(670, 10, 20, 20);
	     close.addActionListener(new ActionListener() {

		
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				new home();
				
			}
	    	 
	     });
	     
	     viewcategory=new JLabel("View Category");
	     viewcategory.setFont(new Font("Tahoma",Font.BOLD,14));
	     viewcategory.setBounds(480, 70, 150, 20);
	     
	     addnewcatagory=new JLabel("Add New Category");
	     addnewcatagory.setFont(new Font("Tahoma",Font.BOLD,14));
	     addnewcatagory.setBounds(120, 170, 150, 20);
	     
	     newcatagory=new JTextField();
	     newcatagory.setBounds(50, 200, 300, 20);
	     
	   
	     
	     clearicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\clear.PNG");
	     clear=new JButton("Clear");
	     clear.setIcon(clearicon);
	     clear.setBounds(230,240, 100, 20);
	     clear.addActionListener(new ActionListener() {

				
				public void actionPerformed(ActionEvent e) {
					
					clear();
				}
				
				});

	     model=new DefaultTableModel();
	     table=new JTable();
	   model.setColumnIdentifiers(colomn);
	table.setModel(model);
	     table.setBackground(Color.WHITE);
	     table.setForeground(Color.BLACK);
	     table.setGridColor(Color.RED);
	     table.setFont(new Font("Tahoma",Font.BOLD,14));
	     table.setRowHeight(30);
	     table.setAutoCreateRowSorter(true);
	   JScrollPane pane=new JScrollPane(table);
	   pane.setForeground(Color.RED);
	    pane.setBackground(Color.WHITE);
	   pane.setBounds(360, 110, 330, 200);
	   
	   DefaultTableModel dtm=(DefaultTableModel)table.getModel();
		ArrayList<Category>list=categorydao.arraylist();
	      Iterator <Category>itr=list.iterator() ;
	     while(itr.hasNext())
	     {
	    	 Category categoryobj=itr.next();
	    	 dtm.addRow(new Object[] {categoryobj.getId(),categoryobj.getName()});
	    	 
	     }
       
       table.addMouseListener(new MouseAdapter()
    		   {
    	   public void mouseClicked(MouseEvent e)
    	   {
    		  
    		   int index=table.getSelectedRow();
    		   TableModel model=table.getModel();
    		   String id =model.getValueAt(index, 0).toString();
    		   String name =model.getValueAt(index, 1).toString();
    			
    		   int a=JOptionPane.showConfirmDialog(pane, "do you want to delete this category","selection",JOptionPane.YES_NO_OPTION);
    		   if(a==0)
    		   {
    			   
    			  
    	   	
        		   categorydao.delete(id , name); 
        		  
        		   new ManageCategory();
    		   }
    		   
 
    	   }
    		   });
       
	   click=new JLabel(" * Click the Category to delete");
	   click.setBounds(430, 325, 220, 20);
	   click.setFont(new Font("Tahoma ",Font.BOLD,14));
	   
	   saveicon=new ImageIcon("C:\\Users\\miki\\Desktop\\cafe\\Cafe Image & Icon\\images\\save.PNG");
	     save=new JButton("Save");
	     save.setIcon(saveicon);
	     save.setBounds(80,240, 100, 20);
	     save.addActionListener(new ActionListener() {
	    	
			
			public void actionPerformed(ActionEvent e) {
			
				
			Category category=new Category();
			category.setName(newcatagory.getText()	);
			categorydao.save(category);
			
	 
			 
			
			
            
			  frame.setVisible(false);
			  new ManageCategory();
			}
	    	 
	     });
	   
	     
	     frame.add(click);
	   frame.getContentPane().add(pane);
	     frame.add(clear);
	     frame.add(save);
	     frame.add(newcatagory);
	     frame.add(addnewcatagory);
	     frame.add(viewcategory);
	     frame.add(close);
	   frame.add(managecategory);  
	   frame.add(back);
	  
	 frame.setVisible(true);   
  }
  
 

  private   void clear()
	{
	  newcatagory.setText("");
	}
	public static void main(String[] args) {
		new ManageCategory();
	}
	

}
