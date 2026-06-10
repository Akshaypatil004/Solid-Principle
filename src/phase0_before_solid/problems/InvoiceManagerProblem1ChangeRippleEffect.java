package phase0_before_solid.problems;

import java.util.ArrayList;
import java.util.List;

/**
	Problem 1 — Change Ripple Effect
	
	The scenario
	Your manager sends this message on Monday morning:
	
	"Hey, GST rate changed to 12% from next month.
	Also, we're migrating from MySQL to PostgreSQL this week.
	Both need to be done by Friday."
	
 */

public class InvoiceManagerProblem1ChangeRippleEffect {
	
	 // JOB 1: Data storage
	
	private String customerName;
	private List<String> itemNames  = new ArrayList<>();
	private List<Double> itemPrices = new ArrayList<>();
	
	// constructor
	public InvoiceManagerProblem1ChangeRippleEffect(String customerName) {
		this.customerName = customerName;
	}
	
	// add item method
	public void addItem(String name, double price) {
		System.out.println("InvoiceManager.addItem()");
		itemNames.add(name);
		itemPrices.add(price);
	}
	
	//  JOB 2: Tax calculation
	
	public double calculateTotal() {
		System.out.println("InvoiceManager.calculateTotal()");
		
		double total = 0;
		for(double price : itemPrices) {
			total += price;
		}
		
		double taxRate = 0.12; // change one : 0.18 to 0.12 
		double tax = total * taxRate;
		return total + tax;
		
	}
	

	 // JOB 3: Display / printing
	
	public void printInvoice() {
		System.out.println("InvoiceManager.printInvoice()");
		
     System.out.println("===========================================");
     System.out.println("                 INVOICE                  ");
     System.out.println("===========================================");
     System.out.println("Customer : " + customerName);
     System.out.println("-------------------------------------------");
     for (int i = 0; i < itemNames.size(); i++) {
         System.out.printf("  %-25s Rs %8.2f%n",
                 itemNames.get(i), itemPrices.get(i));
     }
     System.out.println("-------------------------------------------");
     System.out.printf("  TOTAL (incl. 12%% GST)       Rs %8.2f%n", calculateTotal()); // change two : TOTAL (incl. 18%% GST) to TOTAL (incl. 12%% GST)  
     System.out.println("===========================================");
 }
	
	//  JOB 4: Database persistence
	
	 public void saveToDatabase() {
		 	System.out.println("InvoiceManager.saveToDatabase()");
		 	
	        System.out.println();
	        System.out.println("[DATABASE]");
	        System.out.println("  Connecting to Postgress @ localhost:5432 ..."); // change three : mysql to postgressql 
	     // Change to PostgreSQL connection string, update SQL syntax, etc
	        
	        System.out.printf("  INSERT INTO invoices (customer, total) VALUES ('%s', %.2f)%n",
	                customerName, calculateTotal());
	        System.out.println("  Record saved successfully.");
	    }
	 
	 	//  JOB 5: Email notification
	
	 public void sendEmailNotification() {
		 	System.out.println("InvoiceManager.sendEmailNotification()");
		 	
	        System.out.println();
	        System.out.println("[EMAIL]");
	        System.out.println("  Connecting to SMTP: smtp.gmail.com:587");
	        System.out.println("  To      : " + customerName.toLowerCase().replace(" ", ".") + "@example.com");
	        System.out.println("  Subject : Invoice Generated");
	        System.out.printf("  Body    : Dear %s, your invoice of Rs %.2f is ready.%n",
	                customerName, calculateTotal());
	        System.out.println("  Email sent successfully.");
	    }
	 
	 public static void main(String[] args) {
		System.out.println(">> Creating invoice to Akshay Patil...");
		System.out.println();
		
		InvoiceManagerProblem1ChangeRippleEffect invoice = new InvoiceManagerProblem1ChangeRippleEffect("Akshay Patil");
		invoice.addItem("Laptop", 75000);
		invoice.addItem("Wireless mouse", 1500.0);
		invoice.addItem("USB-c hub", 2500.0);
		invoice.addItem("Laptop Bag", 3200.0);
		
		invoice.printInvoice();
		invoice.saveToDatabase();
		invoice.sendEmailNotification();
		
		System.out.println();
		
	}
}
/**
 * UNDERSTANDING : 
 * 
 * - I have to go to all the code find the exact lines to change hard to find the 
 *   exact line if code base size increases 
 * - Change at one place affect at other also , because of this
 *   i have to do changes at multiple lines/position
 * 
 * Why this is dangerous
		You are editing two completely different concerns inside one file.
		Every time you scroll past one to fix the other, you risk:
		
		- A stray keystroke breaking the logic next to it
		- An accidental copy-paste overwriting the wrong variable
		- A refactor of DB code that pulls in a variable also used by calculateTotal()
		
		After both changes, you must re-test everything:
		
		- Does printing still work? (you didn't touch it, but it calls calculateTotal())
		- Does email still send? (it also calls calculateTotal())
		- Is the DB insert correct?
		- Is the tax calculation correct?

		All 5 jobs must be re-tested even though you only changed 2 things.
 *   
 */
