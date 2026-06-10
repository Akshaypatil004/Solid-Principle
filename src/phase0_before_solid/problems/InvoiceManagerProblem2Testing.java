package phase0_before_solid.problems;


import java.util.ArrayList;
import java.util.List;
/**
 * Problem 2 — Cannot Test in Isolation
	The scenario
	
	You want to write a unit test:
	"Verify that 18% GST is applied correctly to a total of Rs 10,000"
	Expected result: 10,000 + 1,800 = 11,800
 */


public class InvoiceManagerProblem2Testing {
	
	 // JOB 1: Data storage
	
	private String customerName;
	private List<String> itemNames  = new ArrayList<>();
	private List<Double> itemPrices = new ArrayList<>();
	
	// constructor
	public InvoiceManagerProblem2Testing(String customerName) {
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
		
		double taxRate = 0.18; 
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
     System.out.printf("  TOTAL (incl. 18%% GST)       Rs %8.2f%n", calculateTotal());   
     System.out.println("===========================================");
 }
	
	//  JOB 4: Database persistence
	
	 public void saveToDatabase() {
		 	System.out.println("InvoiceManager.saveToDatabase()");
		 	
	        System.out.println();
	        System.out.println("[DATABASE]");
	        System.out.println("  Connecting to MySql @ localhost:3306 ..."); 
	        
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
		InvoiceManagerProblem2Testing invoice = new InvoiceManagerProblem2Testing("Test Customer");
		invoice.addItem("test product",10000.0);
		
		double total = invoice.calculateTotal();
		System.out.println("Expected : 11800.0 | Got : " + total);
		
		// DANGER: The same object also has these methods:
        // invoice.saveToDatabase();      -- writes to real DB if called accidentally
        // invoice.sendEmailNotification(); -- sends real email if called accidentally

        // In a large codebase, a junior dev writes:
        // invoice.saveToDatabase(); // "just to check it works"
        // --> PRODUCTION DATABASE NOW HAS JUNK TEST RECORDS
		
	}
}

/**
 * The real-world consequence
	In large projects, this causes:
	
	Test data appearing in production databases
	Real emails sent to real customers during test runs
	Tests that are slow (they make real network connections)
	Tests that fail in CI/CD because there's no DB connection available
	
The core issue
	calculateTotal() is a pure math function — it takes numbers and returns a number.
	It should be testable with zero side effects.
	
	But because it lives in InvoiceManager, testing it means instantiating an object
	that carries DB connections and email config with it.
	
	You cannot test one job without the whole class being present.
 */
