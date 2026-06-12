package simple_project.with_solid;

/**
 * CAPSTONE — WITH SOLID — Main.java (Orchestrator)
 * ============================================================ All 5 SOLID
 * principles applied. Each class has one job. Main only wires — it contains
 * zero business logic.
 *
 * SOLID APPLIED: S — SRP: Order, DiscountCalculator, PaymentProcessor,
 * OrderRepository, OrderConfirmationService each have exactly one reason to
 * change
 *
 * O — OCP: PaymentProcessor works with any Payable forever. Add new payment →
 * new class, nothing modified.
 *
 * L — LSP: CreditCard/UPI implement Payable+Refundable (honest). Cash
 * implements Payable only (honest). No crashes. No broken promises.
 *
 * I — ISP: Payable (pay only) + Refundable (refund only). Cash not forced to
 * implement refund it can't do.
 *
 * D — DIP: OrderConfirmationService depends on Notifier interface.
 * EmailNotifier injected from here — one-line swap to SMS.
 * ============================================================
 */
public class Main {

	public static void main(String[] args) {

		System.out.println("=== Order Processing System (WITH SOLID) ===\n");

		DiscountCalculator discountCalc = new DiscountCalculator();
		PaymentProcessor payProc = new PaymentProcessor();
		OrderRepository repository = new OrderRepository();
		Notifier notifier = new EmailNotifier(); // swap to SmsNotifier — 1 line
		OrderConfirmationService confirmSvc = new OrderConfirmationService(notifier);

		// ── Order 1: Credit Card (supports payment + refund) ──────────────
		System.out.println("--- Order 1: Rahul Sharma (Credit Card) ---\n");
		Order order1 = new Order("Rahul Sharma");
		order1.addItem("Laptop", 75000.00);
		order1.addItem("Mouse", 1500.00);
		order1.addItem("Bag", 3000.00);

		Payable creditCard = new CreditCardPayment();
		double total1 = discountCalc.applyDiscount(order1.getSubtotal());

		payProc.processPayment(creditCard, total1);
		repository.save(order1, total1, creditCard.getPaymentType());
		confirmSvc.confirm(order1, total1);

		System.out.println();
		System.out.println("[Testing refund — credit card supports it]");
		payProc.processRefund(creditCard, total1);

		// ── Order 2: Cash (supports payment only — no online refund) ──────
		System.out.println("\n--- Order 2: Priya Patel (Cash) ---\n");
		Order order2 = new Order("Priya Patel");
		order2.addItem("Keyboard", 2000.00);
		order2.addItem("Mousepad", 500.00);

		Payable cash = new CashPayment();
		double total2 = discountCalc.applyDiscount(order2.getSubtotal());

		payProc.processPayment(cash, total2);
		repository.save(order2, total2, cash.getPaymentType());
		confirmSvc.confirm(order2, total2);

		System.out.println();
		System.out.println("[Testing refund — cash handles it gracefully, no crash]");
		payProc.processRefund(cash, total2); // ✅ No crash — LSP satisfied

		// ── Order 3: UPI ──────────────────────────────────────────────────
		System.out.println("\n--- Order 3: Amit Kumar (UPI) ---\n");
		Order order3 = new Order("Amit Kumar");
		order3.addItem("Monitor", 15000.00);

		Payable upi = new UpiPayment();
		double total3 = discountCalc.applyDiscount(order3.getSubtotal());

		payProc.processPayment(upi, total3);
		repository.save(order3, total3, upi.getPaymentType());
		confirmSvc.confirm(order3, total3);

		System.out.println();
		System.out.println("=============================================");
		System.out.println("All 5 SOLID principles applied:");
		System.out.println("  S — Each class has one reason to change");
		System.out.println("  O — Add new payment = new class only");
		System.out.println("  L — No runtime crashes from bad contracts");
		System.out.println("  I — Cash not forced into refund it can't do");
		System.out.println("  D — Switch email to SMS = one line in Main");
		System.out.println("=============================================");
	}
}
