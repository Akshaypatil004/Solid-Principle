package phase5_dip.with_dip;

/**
 * WITH DIP — Notifier.java (The Abstraction / Interface)
 * ================================================================
 *
 * NotificationService depends on THIS — not on EmailSender.
 * EmailSender, SmsSender, PushNotifier all depend on THIS.
 *
 * BOTH the high-level class AND the low-level classes
 * point to this abstraction. Neither points to the other.
 * That is the Dependency Inversion.
 * ================================================================
 */
public interface Notifier {
	
	void send(String message);
	

}
