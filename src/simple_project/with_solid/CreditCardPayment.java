package simple_project.with_solid;

/**
 * [OCP + LSP + ISP] CreditCardPayment.java
 * ============================================================ OCP: New payment
 * type = new class, zero existing files touched LSP: Implements both Payable
 * AND Refundable — honest contract ISP: Only implements what it genuinely
 * supports
 */
public class CreditCardPayment implements Payable, Refundable {

	@Override
	public void refund(double amount) {
        System.out.printf("[CREDIT] Refunding Rs %.2f to card ending 4242.%n", amount);
        System.out.println("[CREDIT] Refund processed in 3-5 days.");
	}

	@Override
	public void pay(double amount) {
		System.out.println("[CREDIT] Charging card ending 4242...");
		System.out.printf("[CREDIT] Rs %.2f authorized successfully.%n", amount);
	}

	@Override
	public String getPaymentType() {
		return "Credit Card"; 
	}

}
