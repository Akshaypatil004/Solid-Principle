package phase5_dip.with_dip;

/**
 * WITH DIP — NotificationService.java
 * ================================================================
 * HIGH-LEVEL business logic. Clean. Decoupled. Testable.
 *
 * This class depends ONLY on the Notifier abstraction.
 * It has NO knowledge of:
 *  - EmailSender, SmsSender, PushNotifier, or any concrete class
 *  - SMTP, Twilio, Firebase, or any infrastructure detail
 *  - How messages are actually delivered
 *
 * HOW is the dependency provided?
 *  → Constructor injection — the caller decides what to inject.
 *  → NotificationService never calls 'new' on any notifier.
 * ================================================================
 */

public class NotificationService {
	
	// depends on abstraction
	private Notifier notifier;
	
	// Dependency is INJECTED — not created internally
	public NotificationService(Notifier notifier) {
		this.notifier = notifier;
	}
	
	public void notifyUser(String message) {
		System.out.println("[NOTIFICATION] sending user notification...");
		notifier.send(message);
	}
	
	public void notifyAdmin(String messgae) {
		System.out.println("[NOTIFICATION] sending admin alert...");
		notifier.send(messgae);
	}
	
    public void sendOrderUpdate(String orderId, String status) {
        String message = "Order #" + orderId + " status: " + status;
        System.out.println("[NOTIFICATION] Sending order update...");
        notifier.send(message);
    }

	

}
