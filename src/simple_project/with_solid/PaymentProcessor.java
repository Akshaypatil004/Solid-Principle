package simple_project.with_solid;

/**
 * [SRP + OCP] PaymentProcessor.java
 * ============================================================
 * SRP: ONE JOB — coordinate payment and refund operations
 * OCP: Works with ANY Payable — forever closed for modification
 *      Add Crypto, EMI, Wallet → create new class, don't touch this
 */

public class PaymentProcessor {

	 //OCP: depends on Payable interface, not on any concrete class
	public void processPayment(Payable payment, double amount) {
		System.out.println("[PAYMENT] Processing " + payment.getPaymentType() + "...");
        payment.pay(amount);
	}
	
	// ISP + LSP: only processes refund if payment genuinely supports it
    public void processRefund(Payable payment, double amount) {
        if (payment instanceof Refundable) {
            System.out.println("[REFUND] Processing refund via " + payment.getPaymentType() + "...");
            ((Refundable) payment).refund(amount);
        } else {
            System.out.println("[REFUND] " + payment.getPaymentType()
                    + " does not support online refunds.");
            System.out.println("[REFUND] Please process manually at the counter.");
            // No crash. No exception. Honest, graceful handling.
        }
    }
}
