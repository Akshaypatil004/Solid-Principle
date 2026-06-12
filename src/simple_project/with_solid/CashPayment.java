package simple_project.with_solid;

/**
 * [OCP + LSP + ISP] CashPayment.java
 * ============================================================
 * ISP: Only implements Payable — NOT Refundable (honest!)
 * LSP: No broken promises. Cash never claims to support refunds.
 * OCP: Added without touching PaymentProcessor
 *
 * Compare with the WITHOUT-SOLID version:
 *   - There: CashPayment was forced to implement refund → threw exception → LSP violated
 *   - Here:  CashPayment only implements what it genuinely supports → no crashes
 */
public class CashPayment implements Payable {

    @Override
    public void pay(double amount) {
        System.out.printf("[CASH] Rs %.2f collected at counter.%n", amount);
        System.out.println("[CASH] Payment received.");
    }

    // No refund() method here — and that's CORRECT by design.
    // If caller needs refund, they check instanceof Refundable first.

    @Override
    public String getPaymentType() { return "Cash"; }
}
