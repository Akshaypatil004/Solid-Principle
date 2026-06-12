package simple_project.without_solid;

import java.util.ArrayList;
import java.util.List;

/**
 * CAPSTONE — WITHOUT SOLID (The God Class)
 * ============================================================
 * This one class violates ALL 5 SOLID principles.
 *
 * Project: E-commerce Order Processing System
 * ============================================================
 *
 * VIOLATIONS SUMMARY:
 *  SRP — This class has 5+ jobs: store order, process payment,
 *         calculate discount, save to DB, send notification
 *  OCP — if-else chain for payment types; add new type = edit this file
 *  LSP — CashPayment.processRefund() throws exception (breaks contract)
 *  ISP — One fat interface forces CashPayment to implement refund it can't do
 *  DIP — new EmailSender() hardcoded inside high-level business logic
 */
public class OrderProcessor {
	
	// SRP - violation job 1 : store order data
	
	private String customerName;
	private List<String> items = new ArrayList<>();
	private List<Double> prices = new ArrayList<>();
	private String paymentType; // credit, upi, cash
	
	public OrderProcessor(String customerName, String paymentType) {
		this.customerName = customerName;
		this.paymentType = paymentType;
	}
	
	public void addItem(String item, double price) {
		items.add(item);
		prices.add(price);
	}
	
	// SRP - violation job 2 - calculate total + discount
	public double calculateTotal() {
		double subtotal = 0;
		
		for(double price : prices) {
			subtotal += price;
		}
		
		// Discount logic buried inside — hard to find, hard to reuse
		if(subtotal > 5000) {
			subtotal *= 0.90;
		}
		
		return subtotal;
	}
	
	// SRP + OCP violation - job 3 - process payment
	// every new payment type = open this file + add another else-if
	public void processPayment() {
		double total = calculateTotal();
		
		System.out.println("[PAYMENT] processing Rs " + total + " via " + paymentType);
		
		if(paymentType.equals("credit")) // ocp violation
		{
			System.out.println("[CREDIT] Charging card ending 4321...");
			System.out.println("[CREDIT] Authorized.");
		}
		else if(paymentType.equals("upi")) // ocp violation
		{
			System.out.println("[UPI] sending request to UPI ID...");
			System.out.println("[UPI] Payment Confired.");
			
		}
		else if(paymentType.equals("cash")) // ocp violation
		{
			System.out.println("[CASH] cash collected at counter.");
		}
		// add another payment type , add anothe else if  
	}
	
	// ── [LSP VIOLATION] Refund method
    // CashPayment cannot be refunded online — but the contract says it must
	public void processRefund() {
		if(paymentType.equals("cash")) {
			// lsp violation - cash break the refunds contract
			throw new UnsupportedOperationException("Cash payment "
					+ "cannot be refunded online!");
		}
		
		System.out.println("[REFUND] Refunding Rs " + calculateTotal() + " to " + paymentType);
	}
	
	// SRP - violation - job 4 
	public void saveOrder() {
		System.out.println("[DB] Saving order for: " + customerName);
        System.out.printf("[DB] Total: Rs %.2f | Payment: %s%n",
                calculateTotal(), paymentType);
        System.out.println("[DB] Order saved.");
	}
	
	// DIP - violation job 5 - send notification
	// High-level class creates low-level dependency directly
	
	public void sendConfirmation() {
		// DIP violation - EmailSender Hardwired  into business logic
		EmailSender emailSender = new EmailSender();
		emailSender.send("[ORDER] Dear " + customerName + ", your order of Rs " + calculateTotal() + " is confirmed.");
	}
	
	public static void main(String[] args) {
		System.out.println("--- Order Processing System [ WITHOUT SOLID ] ---\n");
		
		OrderProcessor order = new OrderProcessor("Akshay Patil", "credit");
		order.addItem("Laptop", 75000.0);
		order.addItem("Mouse", 1500.0);
		order.addItem("Bag", 2000.0);
		
		order.processPayment();
		order.saveOrder();
		order.sendConfirmation();
		
		System.out.println("\n--- Try a cash order with refund ---");
        OrderProcessor cashOrder = new OrderProcessor("Shubham", "cash");
        cashOrder.addItem("Keyboard", 2000.00);
        cashOrder.processPayment();
        try {
            cashOrder.processRefund(); // CRASHES — LSP violation
        } catch (UnsupportedOperationException e) {
            System.out.println("CRASH: " + e.getMessage());
            System.out.println("This is what an LSP violation looks like at runtime.");
        }
		
				
	}
	

}
