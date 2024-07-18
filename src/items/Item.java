package items;

public class Item extends AbstractItem{
	//The class has three private instance variables
    private String name;
    private double size;
    private double weight;

    public Item(String name, double size, double weight) {
    	super(name, size, weight);
    	this.name = name;
    	this.size = size;
    	this.weight = weight;
    }
    
    //This method returns the value of the "name" instance variable.
    public String getName() {
    	return name;
    }
    
    // It returns the value of the "size" instance variable.
    @Override
    public double getSize() {
        return size;
    }
    
    // It returns the value of the "weight" instance variable.
    @Override
    public double getWeight() {
        return weight;
    }
    //It prints out information about the item, including its name, size, and weight.
    @Override
    public void printItemInfo() {
        System.out.println("Item Name: " + this.name + ", Size: " + this.size + ", Weight: " + this.weight);
    }
}

