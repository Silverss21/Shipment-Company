package methods;

import java.util.HashMap;
import java.util.Map;

public class Order {
	
	private Map<String, Integer> quantities = new HashMap<>();
//// This method returns the HashMap "quantities," which contains the quantities of different items in the order.
	public Map<String, Integer> getQuantities() {
		return quantities;
	}
//This method sets the "quantities" instance variable using the provided HashMap of item quantities
	public void setQuantities(Map<String, Integer> quantities) {
		this.quantities = quantities;
	}
	
	
}
