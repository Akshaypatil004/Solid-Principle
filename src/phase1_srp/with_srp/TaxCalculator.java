package phase1_srp.with_srp;

/**
 * SRP — Job 2: Tax calculation only.
 * This class does one thing: take a subtotal and return the total with tax.
 * Reason to change: tax rate changes, new tax rules, GST slabs added.
 *
 * BENEFIT: Any class that needs tax calculation (QuotationManager,
 * RefundManager, ReceiptManager) uses THIS class. No duplication.
 */

public class TaxCalculator {
	
	private double taxRate;
	
	public TaxCalculator(double taxRate) {
		System.out.println("TaxCalculator.TaxCalculator()");
		
		this.taxRate = taxRate;
	}
	
	public double calcuteTotal(double subTotal) {
		double tax = subTotal * taxRate;
		return subTotal + tax;
	}
	
	public double getTaxRate() {
		return taxRate;
	}

}
