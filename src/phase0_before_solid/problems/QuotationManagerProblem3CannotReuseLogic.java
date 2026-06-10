package phase0_before_solid.problems;

/**
 * Problem 3 — Cannot Reuse Logic
	The scenario
	New requirement arrives:
	
	"Build a QuotationManager — it creates quotes before invoices.
	Quotes also need GST calculation (same 18% logic)."
 */

public class QuotationManagerProblem3CannotReuseLogic {
	
	
	// Option A : Copy the code (Duplication)
	 public double calculateQuoteTotal(double amount) {
	        // ⚠COPIED from InvoiceManager.calculateTotal()
	        double taxRate = 0.18;  // DUPLICATE #1
	        return amount + (amount * taxRate);
	    }
	 
	 /**
	  * Now the same logic exists in two places.
		When GST changes to 12%:
			Developer A updates InvoiceManager → tax = 0.12 
			Developer B forgets QuotationManager → tax = 0.18 
			Customers get quotes at 18% but invoices at 12%
			Finance team raises an audit issue 3 months later
	  */
	 
	// Option B — Import InvoiceManager (Wrong dependency)
	/*
	 *  public double calculateQuoteTotal(String customer, double amount) {
	
        // ⚠️  Creating a full InvoiceManager just to get tax calculation
        
        InvoiceManager inv = new InvoiceManager(customer);
        inv.addItem("Quote Item", amount);
        
        return inv.calculateTotal();
        
        // QuotationManager now depends on InvoiceManager's DB code,
        // email code, and print code — just to do math.
        // This is called a "wrong dependency" — you brought in
        // far more than you needed.
    }
	 */
}
