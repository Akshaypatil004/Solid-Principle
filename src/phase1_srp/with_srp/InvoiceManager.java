package phase1_srp.with_srp;

/**
 * SRP — The Orchestrator.
 * This class doesn't DO anything itself.
 * It just coordinates the other focused classes.
 *
 * This is the KEY insight of SRP:
 * The manager manages. The calculator calculates. The printer prints.
 * Nobody does anyone else's job.
 *
 * Reason to change: the FLOW of the process changes
 * (e.g., "save to DB before printing", "skip email for some customers")
 */

public class InvoiceManager {
	
	private TaxCalculator taxCalculator;
	private InvoicePrinter printer;
	private InvoiceRepository repository;
	private EmailNotifier emailNotifier;
	
	public InvoiceManager() {
		this.taxCalculator = new TaxCalculator(0.18);// 18%GST
		this.printer = new InvoicePrinter();
		this.repository = new InvoiceRepository();
		this.emailNotifier = new EmailNotifier();
	}
	
	public void processInvoice(Invoice invoice) {
		// step 1 : calculate total ( forward to TaxCalculator)
		double total = taxCalculator.calcuteTotal(invoice.getSubtotal());
		
		// step 2 : print invoice
		printer.print(invoice, total);
		
		// step 3: save to db ( forward to InvoiceRepository
		repository.save(invoice, total);
		
		// step 4 : send email (forward to EmailNotifier)
		emailNotifier.notify(invoice, total);
	}
	
	 public static void main(String[] args) {

	        System.out.println(">>> Creating invoice for Akshay Patill...");
	        System.out.println();

	        Invoice invoice = new Invoice("Akshay Patil");
	        invoice.addItem("Laptop",          75000.00);
	        invoice.addItem("Wireless Mouse",   1500.00);
	        invoice.addItem("USB-C Hub",        2500.00);
	        invoice.addItem("Laptop Bag",       3200.00);

	        InvoiceManager manager = new InvoiceManager();
	        manager.processInvoice(invoice);

	        System.out.println();
	        System.out.println(">>> Same output as Phase 0. But now:");
	        System.out.println("    - Change tax rate  → open TaxCalculator.java only");
	        System.out.println("    - Switch database  → open InvoiceRepository.java only");
	        System.out.println("    - Change email     → open EmailNotifier.java only");
	        System.out.println("    - Change format    → open InvoicePrinter.java only");
	    }
	
}
