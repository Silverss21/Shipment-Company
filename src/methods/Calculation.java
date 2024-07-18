package methods;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import containers.Container;
import items.Item;

public class Calculation {
	
	
	private ArrayList<Order> orderList = new ArrayList<>();
	private ArrayList<Item> items = new ArrayList<>();
	
	Container bigContainer = new Container(75.6, 1800, 1800);
    Container smallContainer = new Container(38.1, 1000, 1200);
	
	// Getters and setters

	public ArrayList<Order> getOrderList() {
		return orderList;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public void setOrderList(ArrayList<Order> orderList) {
		this.orderList = orderList;
	}
	
	
	// Methods 
	//This method calculates and returns the total weight of an order. 
	public  double totalWeight(Order orderInfo) {
        double totalWeight = 0;
        
        Map<String, Integer> orderItems = orderInfo.getQuantities();
        
        totalWeight += (orderItems.get("Laptop") * items.get(0).getWeight());
        totalWeight += (orderItems.get("Desktop") * items.get(1).getWeight());
        totalWeight += (orderItems.get("Mouse") * items.get(2).getWeight());
        totalWeight += (orderItems.get("LCD Screen") * items.get(3).getWeight());
        
        
        return totalWeight;
    }
	
	//This method calculates and returns the total volume of an order.
    public  double totalVolume(Order orderInfo) {
    	double totalVolume = 0;
        
        Map<String, Integer> orderItems = orderInfo.getQuantities();
        
        totalVolume += (orderItems.get("Laptop") * items.get(0).getSize());
        totalVolume += (orderItems.get("Desktop") * items.get(1).getSize());
        totalVolume += (orderItems.get("Mouse") * items.get(2).getSize());
        totalVolume += (orderItems.get("LCD Screen") * items.get(3).getSize());
        
        
        return totalVolume;
    }
    
    // This method calculates and returns the number of big and small containers needed for shipping an order.
    // It takes into account the total weight and total size of the order.
    //If the remaining size after considering big containers is small enough
    // it determines the number of small containers required based on weight thresholds.
    
    
    public  int[] bestShipping(Order orderInfo) {
        double totalWeight = totalWeight(orderInfo);
        double totalSize = totalVolume(orderInfo);
        
        System.out.println(totalWeight);
        System.out.println(totalSize);
        
        int smallContainers500Plus = 0;
        int smallContainersUpTo500 = 0;
        
        int bigContainersNeeded = (int) (totalSize / bigContainer.getSize());
        double remainingSize = (totalSize / bigContainer.getSize()) - bigContainersNeeded;
        
        if(remainingSize > smallContainer.getSize()) {
        	bigContainersNeeded += 1;
        } else {
        	double remainingPercentage = remainingSize / totalSize;
        	double remainingWeight = totalWeight * remainingPercentage;
        	if (remainingWeight > 500) {
        		smallContainers500Plus += 1;
        	} else {
        		smallContainersUpTo500 += 1;
        	}
        }
        
        return new int[]{bigContainersNeeded, smallContainers500Plus, smallContainersUpTo500};
        
    }
    
    //This method calculates and returns the shipping cost based on the number of big and small containers needed
    public double hippingPrice(int[] amountOfContainers) {
    	
    	double cost = 0;
    	cost += amountOfContainers[0] * bigContainer.getCost(false);
    	cost += amountOfContainers[1] * smallContainer.getCost(false);
    	cost += amountOfContainers[2] * smallContainer.getCost(true);
    	
    	return cost;
        
    }
    //This method adds a new Order object to the orderList ArrayList.
    public void addOrder() {
    	orderList.add( new Order() );
    }
    //This method adds an Item object to the items ArrayList.
    public void addItems(Item item) {
    	items.add(item);
    }
    //This method prints information about an item given its index in the items ArrayList.
    public void printItem(int itemIndex) {
    	if(items.get(itemIndex) != null) {
    		items.get(itemIndex).printItemInfo();
    	} else {
    		System.out.println("Null item... Index out of list");
    	}
    }
    //This method prints information about an order given its index in the orderList ArrayList.
    public void printOrder(int orderIndex) {
    	Order o = orderList.get(orderIndex);
    	Map<String, Integer> quantities = o.getQuantities();
    	
    	if(quantities.get("Laptop") != null) {
    		System.out.println("Amount of laptops: " + quantities.get("Laptop"));
    	}
    	
    	if(quantities.get("Desktop") != null) {
    		System.out.println("Amount of desktop: " + quantities.get("Desktop"));
    	}
    	
    	if(quantities.get("Mouse") != null) {
    		System.out.println("Amount of mices: " + quantities.get("Mouse"));
    	}
    	
    	if(quantities.get("LCD Screen") != null) {
    		System.out.println("Amount of LCD screens: " + quantities.get("LCD Screen"));
    	}
    	
    }
}
