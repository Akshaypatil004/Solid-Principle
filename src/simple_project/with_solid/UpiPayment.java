package simple_project.with_solid;

/**
 * [OCP + LSP + ISP] UpiPayment.java OCP: Added without touching
 * PaymentProcessor LSP: Implements both Payable and Refundable — honest
 * contract
 */
public class UpiPayment implements Payable, Refundable {

	@Override
	public void pay(double amount) {
		System.out.println("[UPI] Sending payment request to UPI ID...");
		System.out.printf("[UPI] Rs %.2f confirmed via UPI.%n", amount);
	}

	@Override
	public void refund(double amount) {
		System.out.printf("[UPI] Refunding Rs %.2f to UPI account.%n", amount);
		System.out.println("[UPI] Refund initiated.");
	}

	@Override
	public String getPaymentType() {
		return "UPI";
	}
}
