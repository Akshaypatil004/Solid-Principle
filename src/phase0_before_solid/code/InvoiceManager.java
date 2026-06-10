// InvoiceManager.java ( GOD Class - contain everything ) 
package phase0_before_solid.code;

import java.util.ArrayList;
import java.util.List;

/**
 * Phase 0 - The GOD class ( before SOLID ) 
 * project - Invoice Billing System
 * 
 * This class has FIVE jobs:
 *    Job 1 — Store invoice data (items + prices)
 *    Job 2 — Calculate total with tax
 *    Job 3 — Print/display the invoice
 *    Job 4 — Save to database
 *    Job 5 — Send email notification
 *    
 * PROBLEM: This class has 5 reasons to change.
 * Every reason to change is a risk of breaking the other 4 jobs.
 */
public class InvoiceManager {
	
	 // JOB 1: Data storage
    //  If item structure changes (add quantity, discount) → edit THIS class
	
	private String customerName;
	private List<String> itemNames  = new ArrayList<>();
	private List<Double> itemPrices = new ArrayList<>();
	
	// constructor
	public InvoiceManager(String customerName) {
		System.out.println("InvoiceManager.InvoiceManager()");
		this.customerName = customerName;
	}
	
	// add item method
	public void addItem(String name, double price) {
		System.out.println("InvoiceManager.addItem()");
		itemNames.add(name);
		itemPrices.add(price);
	}
	
	//  JOB 2: Tax calculation
    //  Tax rate is hardcoded
    //  If GST changes from 18% to 12% → edit THIS class.
	
	public double calculateTotal() {
		System.out.println("InvoiceManager.calculateTotal()");
		
		double total = 0;
		for(double price : itemPrices) {
			total += price;
		}
		
		// problem : tax rate , hardcoded
		double taxRate = 0.18;
		double tax = total * taxRate;
		return total + tax;
		
	}
	

	 // JOB 3: Display / printing
    //  If output format changes (text → HTML → PDF) → edit THIS class.
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
        //   PROBLEM: printInvoice() calls calculateTotal() internally.
        //   Change calculateTotal() → printInvoice() is affected.
        System.out.printf("  TOTAL (incl. 18%% GST)       Rs %8.2f%n", calculateTotal());
        System.out.println("===========================================");
    }
	
	//  JOB 4: Database persistence
    //  If DB changes (MySQL → MongoDB, add new columns) → edit THIS class.
	
	 public void saveToDatabase() {
		  	//    PROBLEM: DB code lives next to print and email code.
	        //     A slip while fixing DB code can accidentally
	        //     break the line above or below in printInvoice().
		 	System.out.println("InvoiceManager.saveToDatabase()");
		 	
	        System.out.println();
	        System.out.println("[DATABASE]");
	        System.out.println("  Connecting to MySQL @ localhost:3306 ...");
	        System.out.printf("  INSERT INTO invoices (customer, total) VALUES ('%s', %.2f)%n",
	                customerName, calculateTotal());
	        System.out.println("  Record saved successfully.");
	    }
	 
	 	//  JOB 5: Email notification
	    //  If email provider changes (SMTP → SendGrid → AWS SES) → edit THIS class.
	    //  A fifth unrelated reason to open and edit this file.
	
	 public void sendEmailNotification() {
	        //     PROBLEM: Email config is hardcoded here inside the billing class.
	        //     Completely wrong place for this responsibility.
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
		
		InvoiceManager invoice = new InvoiceManager("Akshay Patil");
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
