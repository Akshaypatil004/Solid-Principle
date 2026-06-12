package simple_project.with_solid;

/**
 * [ISP] Payable.java — focused interface: only payment
 * ============================================================
 * ISP: Not all payment methods support refunds.
 * So we split: Payable (all payments) + Refundable (only some).
 * CashPayment implements Payable only — honest, no broken promise.
 */
public interface Payable {
	
	void pay(double amount);
	String getPaymentType();

}
