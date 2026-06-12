package simple_project.with_solid;

import java.util.ArrayList;
import java.util.List;

/**
 * [SRP] Order.java — ONE JOB: store order data
 * ============================================================ Reason to
 * change: product team changes order structure Cannot change: payment logic, DB
 * logic, notification logic
 */

public class Order {

	private String customerName;
	private List<String> items = new ArrayList<>();
	private List<Double> prices = new ArrayList<>();

	public Order(String cutomerName) {
		this.customerName = cutomerName;
	}

	public void addItem(String item, double price) {
		items.add(item);
		prices.add(price);
	}

	public String getCustomerName() {
		return customerName;
	}

	public List<String> getItems() {
		return items;
	}

	public List<Double> getPrices() {
		return prices;
	}

	public double getSubtotal() {
		double subtotal = 0;
		
		for(double price : prices) {
			subtotal += price;
		}
		return subtotal;
	}

}
