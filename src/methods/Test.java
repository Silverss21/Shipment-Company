package methods;

import items.Item;
import gui.ShipmentGUI;
public class Test {
//This method serves as the entry point of the program.and it create two instance Calculation(calc) and ShipmentGui(gui)
	public static void main(String[] args) {
		Calculation calc = new Calculation();
		
		
		calc.addItems(new Item("Laptop", 0.15, 6.5));
		calc.addItems(new Item("Desktop", 0.75, 20));
		calc.addItems(new Item("Mouse", 0.018, 0.2));
		calc.addItems(new Item("LCD Screen", 1.344, 2.6));
        
        calc.addOrder();
        
        ShipmentGUI gui = new ShipmentGUI(calc);

	}

}
