package items;

public abstract class AbstractItem {
	//The class has three protected instance variables
    protected String name;
    protected double size;
    protected double weight;

    public AbstractItem(String name, double size, double weight) {
        this.name = name;
        this.size = size;
        this.weight = weight;
    }
  //These methods are meant to be implemented by the subclasses and provide the size and weight of an item, respectively.
    public abstract double getSize();

    public abstract double getWeight();
    
    public abstract void printItemInfo();
}
