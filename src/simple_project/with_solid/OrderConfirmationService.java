package simple_project.with_solid;

/**
 * [SRP + DIP] OrderConfirmationService.java
 * ============================================================
 * SRP: ONE JOB — send order confirmation
 * DIP: Depends on Notifier abstraction, injected via constructor
 *      Switch Email → SMS → change Main.java only. Never this class.
 */
public class OrderConfirmationService {

    private final Notifier notifier;

    // DIP: dependency injected, not created inside
    public OrderConfirmationService(Notifier notifier) {
        this.notifier = notifier;
    }

    public void confirm(Order order, double total) {
        String msg = "Dear " + order.getCustomerName()
                + ", your order of Rs " + String.format("%.2f", total)
                + " is confirmed. Thank you!";
        notifier.send(msg);
    }
}
