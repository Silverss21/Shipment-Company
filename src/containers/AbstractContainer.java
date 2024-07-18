package containers;

public abstract class AbstractContainer {
    protected double size;          // Size of the container
    protected double costLow;       // Low cost of the container
    protected double costHigh;      // High cost of the container

    public AbstractContainer(double size, double costLow, double costHigh) {
        this.size = size;
        this.costLow = costLow;
        this.costHigh = costHigh;
    }

    public abstract double getSize();                          // Abstract method to get the size of the container

    public abstract double getCost(boolean isLow);            // Abstract method to get the cost of the container

    public abstract void printContainerInfo();                 // Abstract method to print information about the container
}
