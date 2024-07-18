package gui;

//The code imports several classes and packages from the Java AWT 
//and Swing libraries to build the graphical interface.

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import methods.Calculation;
import methods.Order;

// The class declares several instance variables
//, including a JFrame object named "frame" and a Calculation object named "calc."
// It also defines variables for the frame's width and height.

public class ShipmentGUI {
	
	 private JFrame frame;
	 private Calculation calc;
	 
	 private int frameWidth = 800;
	 private int frameHeight = 500;
	 
	 private double orderTotalWeight, orderTotalVolume, orderPrice;
	 private int[] amountOfContainers = new int[3];
	 
	 //The class has a constructor that takes a Calculation object as a parameter.
	 // It initializes the "calc" variable, creates a new JFrame, and sets its properties such as title, size, and resizability.
	
	public ShipmentGUI(Calculation calc) {
		
		this.calc = calc;
		
		frame = new JFrame("App");
		frame.setResizable(false);
		frame.setSize( new Dimension(frameWidth, frameHeight) );
		frame.setPreferredSize( new Dimension(frameWidth, frameHeight) );
		
		getListOfOrders();
		//This method sets up the initial view of the GUI, displaying a list of orders. It creates a JPanel, adds a title label, and dynamically generates buttons for each order. 
		//Clicking on an order button triggers the "viewOrder()" method.
		
		
		//Show the frame
		frame.setVisible( true );
  				
  		// Close the program
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	//This method sets up the view for a specific order.
	
	private void viewOrder(Order orderInfo) {
		
		int[] emptyArray = {0, 0, 0};
		
		orderTotalWeight = 0;
		orderTotalVolume = 0;
		amountOfContainers = emptyArray;
		orderPrice = 0;
		
		frame.getContentPane().removeAll();
		
		JPanel orderInfoPanel = new JPanel();
		orderInfoPanel.setPreferredSize(new Dimension(frameWidth, frameHeight));
		
		JButton backButton = new JButton("Back");
		backButton.setPreferredSize(new Dimension(600, 50));
		
		backButton.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent e)
		     { 
		    	 getListOfOrders();
		     }
		  });
		orderInfoPanel.add(backButton);
		
		Integer amountOfLaptops = 0;
		Integer amountOfDesktops = 0;
		Integer amountOfMices = 0;
		Integer amountOfScreens = 0;
		
		if(orderInfo.getQuantities().get("Laptop") != null) {
			amountOfLaptops = orderInfo.getQuantities().get("Laptop");
		} 
		if(orderInfo.getQuantities().get("Desktop") != null) {
			amountOfDesktops = orderInfo.getQuantities().get("Desktop");
		} 
		if(orderInfo.getQuantities().get("Mouse") != null) {
			amountOfMices = orderInfo.getQuantities().get("Mouse");
		} 
		if(orderInfo.getQuantities().get("LCD Screen") != null) {
			amountOfScreens = orderInfo.getQuantities().get("LCD Screen");
		} 
		
		JLabel laptopsTitle = new JLabel("Laptops: ",JLabel.CENTER);
		laptopsTitle.setPreferredSize(new Dimension(400, 50));
		JTextField laptopAmountTextfield = new JTextField(amountOfLaptops.toString());
		laptopAmountTextfield.setHorizontalAlignment(JTextField.CENTER);
		laptopAmountTextfield.setPreferredSize(new Dimension(200, 50));
		
		JLabel desktopTitle = new JLabel("Desktops: ",JLabel.CENTER);
		desktopTitle.setPreferredSize(new Dimension(400, 50));
		JTextField desktopTextfield = new JTextField(amountOfDesktops.toString());
		desktopTextfield.setHorizontalAlignment(JTextField.CENTER);
		desktopTextfield.setPreferredSize(new Dimension(200, 50));
		
		JLabel mouseTitle = new JLabel("Mices: ",JLabel.CENTER);
		mouseTitle.setPreferredSize(new Dimension(400, 50));
		JTextField mouseTextfield = new JTextField(amountOfMices.toString());
		mouseTextfield.setHorizontalAlignment(JTextField.CENTER);
		mouseTextfield.setPreferredSize(new Dimension(200, 50));
		
		JLabel screenTitle = new JLabel("LCD screens: ",JLabel.CENTER);
		screenTitle.setPreferredSize(new Dimension(400, 50));
		JTextField screenTextfield = new JTextField(amountOfScreens.toString());
		screenTextfield.setHorizontalAlignment(JTextField.CENTER);
		screenTextfield.setPreferredSize(new Dimension(200, 50));
		
		orderInfoPanel.add(laptopsTitle);
		orderInfoPanel.add(laptopAmountTextfield);
		
		orderInfoPanel.add(desktopTitle);
		orderInfoPanel.add(desktopTextfield);
		
		orderInfoPanel.add(mouseTitle);
		orderInfoPanel.add(mouseTextfield);
		
		orderInfoPanel.add(screenTitle);
		orderInfoPanel.add(screenTextfield);
		
		
		JButton calculateButton = new JButton("Calculate");
		calculateButton.setPreferredSize(new Dimension(600, 50));
		
		
		JLabel totalWeightLabel = new JLabel("Total weight: ",JLabel.CENTER);
		totalWeightLabel.setPreferredSize(new Dimension(600, 50));
		JLabel totalVolumeLabel = new JLabel("Total weight: ",JLabel.CENTER);
		totalVolumeLabel.setPreferredSize(new Dimension(600, 50));
		JLabel price = new JLabel("Price: ",JLabel.CENTER);
		price.setPreferredSize(new Dimension(600, 50));
		JLabel bigContainers = new JLabel("Big containers: ",JLabel.CENTER);
		bigContainers.setPreferredSize(new Dimension(600, 50));
		JLabel smallContainers = new JLabel("Small containers: ",JLabel.CENTER);
		smallContainers.setPreferredSize(new Dimension(600, 50));
		
		//The "calculateButton" triggers the "calculateData()" method and displays calculated data based on the user's inputs
		
		
		
		
		
		calculateButton.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent e)
		     { 
		    	 int laptopAmount = 0;
		    	 int desktopAmount = 0;
		    	 int mouseAmount = 0;
		    	 int screenAmount = 0;
		    	 
		    	 try{
		    		 laptopAmount = Integer.parseInt( laptopAmountTextfield.getText());
		    		 desktopAmount = Integer.parseInt( desktopTextfield.getText());
		    		 mouseAmount = Integer.parseInt( mouseTextfield.getText());
		    		 screenAmount = Integer.parseInt( screenTextfield.getText());
		         }
		         catch (NumberFormatException ex){
		             ex.printStackTrace();
		         }
		    	 
		    	 
		    	 Map<String, Integer> newQuantities = new HashMap<>();
		    	 newQuantities.put("Laptop", laptopAmount);
		    	 newQuantities.put("Desktop", desktopAmount);
		    	 newQuantities.put("Mouse", mouseAmount);
		    	 newQuantities.put("LCD Screen", screenAmount);
		    	 
		    	 orderInfo.setQuantities(newQuantities);
		    	 
		    	calculateData(orderInfo);
		    	
		    	System.out.println(orderInfo.getQuantities());
		    	
		    	totalWeightLabel.setText("Total weight: " + orderTotalWeight + " kg");
		    	totalVolumeLabel.setText("Total volume: " + orderTotalVolume);
		    	price.setText("Price: " + orderPrice);
		    	bigContainers.setText("Big containers: " + amountOfContainers[0]);
		    	smallContainers.setText("Small containers: " + (amountOfContainers[1] + amountOfContainers[2]) );
		     }
		  });
		
		orderInfoPanel.add(calculateButton);
		orderInfoPanel.add(totalWeightLabel);
		orderInfoPanel.add(totalVolumeLabel);
		orderInfoPanel.add(price);
		orderInfoPanel.add(bigContainers);
		orderInfoPanel.add(smallContainers);
		
		orderInfoPanel.setPreferredSize(new Dimension(frameWidth, 700));
		
		JScrollPane scrollPane = new JScrollPane(orderInfoPanel, 
	            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
	            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		scrollPane.setPreferredSize(new Dimension(frameWidth, frameHeight));
		
		
		frame.add(scrollPane);
		
		frame.pack();
		
	}
	
	//This method calculates data related to the order, such as the total weight, total volume, and the number of required containers
	// It uses the Calculation object ("calc") to perform the calculations and updates the corresponding instance variables.
	
	private void calculateData(Order orderInfo) {
		orderTotalVolume = calc.totalVolume(orderInfo);
		orderTotalWeight = calc.totalWeight(orderInfo);
		amountOfContainers = calc.bestShipping(orderInfo);
		orderPrice = calc.hippingPrice(amountOfContainers);
	}
	
	//The code includes some additional helper methods for setting up the GUI components and managing the user's interactions
	private void getListOfOrders() {
		
		frame.getContentPane().removeAll();
		
		JPanel orderListPanel = new JPanel();
		orderListPanel.setPreferredSize(new Dimension(frameWidth, frameHeight));
		
		JLabel title = new JLabel("List of orders",JLabel.CENTER);
		title.setPreferredSize(new Dimension(frameWidth, 50));
		orderListPanel.add(title);
		
		ArrayList<Order> orders = new ArrayList<>();
		orders = calc.getOrderList();
		
		// For each order inside orders
		for(int i = 0; i < orders.size(); i++){
			
			JButton orderButton = new JButton("Order no. " + i);
			orderButton.setPreferredSize(new Dimension(600, 50));
			
			Order o = orders.get(i);
			
			orderButton.addActionListener(new ActionListener() {
			     public void actionPerformed(ActionEvent e)
			     { 
			    	 viewOrder(o);
			     }
			  });
			
			orderListPanel.add(orderButton);
			
		}
		
		
		JButton addOrderButton = new JButton("Add order");
		addOrderButton.setPreferredSize(new Dimension(600, 50));
		
		addOrderButton.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent e)
		     { 
		    	 calc.addOrder();
		    	 getListOfOrders();
		     }
		  });
		
		
		
		orderListPanel.add(addOrderButton);
		
		frame.add(orderListPanel);
		frame.pack();
		
	}
	
}
