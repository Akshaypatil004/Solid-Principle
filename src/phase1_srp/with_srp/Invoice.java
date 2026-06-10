package phase1_srp.with_srp;

import java.util.ArrayList;
import java.util.List;

/**
 * SRP — Job 1: Data holder only.
 * This class stores invoice data and nothing else.
 * Reason to change: item structure changes (add quantity, discount, tax category)
 */

public class Invoice {

	private String customerName;
	private List<String> itemNames = new ArrayList<>();
	private List<Double> itemPrices = new ArrayList<>();
	
	public Invoice(String customerName) {
		System.out.println("Invoice.Invoice()");
		
		this.customerName = customerName;
	}
	
	public void addItem(String name, double price) {
		System.out.println("Invoice.addItem()");
		
		itemNames.add(name);
		itemPrices.add(price);
	}

	public String getCustomerName() {
		return customerName;
	}

	public List<String> getItemNames() {
		return itemNames;
	}

	public List<Double> getItemPrices() {
		return itemPrices;
	}
	
	public double getSubtotal() {
		double subTotal = 0;
		
		for(double price : itemPrices) {
			subTotal += price;
		}
		
		return subTotal;
	}

	@Override
	public String toString() {
		return "Invoice [customerName=" + customerName + ", itemNames=" + itemNames + ", itemPrices=" + itemPrices
				+ "]";
	}
	
	
	
}
