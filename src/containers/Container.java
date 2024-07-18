package containers;

//The code defines a class called "Container" that extends an abstract class named "AbstractContainer." 
//It has three instance variables: "size," "costLow," and "costHigh."

public class Container extends AbstractContainer { 
    private double size;
    private double costLow;
    private double costHigh;
    
    //The constructor initializes these variables using the provided values and calls the superclass constructor.
    
    public Container(double size, double costLow, double costHigh) {
    	super(size, costLow, costHigh);
    	this.size = size;
    	this.costLow = costLow;
    	this.costHigh = costHigh;
    }

    //The class overrides three methods from the abstract class:
    // "getSize()" returns the size of the container,
    // "getCost(boolean isLow)" returns the low or high cost based on the boolean parameter,
    // and "printContainerInfo()" prints information about the container.
    
    @Override
    public double getSize() {
        return size;
    }

    @Override
    public double getCost(boolean isLow) {
        return isLow ? costLow : costHigh;
    }
    
    @Override
    public void printContainerInfo() {
        System.out.println("Container Size: " + this.size + ", Cost (low): " + this.costLow + ", Cost (high): " + this.costHigh);
    }
}

