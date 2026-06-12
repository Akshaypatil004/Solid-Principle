package phase5_dip.with_dip;

/**
 * WITH DIP — Main.java
 * ================================================================ This is
 * where the decision of WHICH notifier to use is made. This is the only file
 * that changes when you switch providers.
 *
 * NotificationService never changes. The Notifier interface never changes. Only
 * Main.java changes — and it's a one-line swap.
 * ================================================================
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("=== Notification System (WITH DIP) ===\n");

		// ── Demo 1: Email notifications ───────────────────────────────────
		System.out.println("--- Using EmailNotifier ---");
		Notifier emailNotifier = new EmailNotifier();
		NotificationService emailService = new NotificationService(emailNotifier);
		emailService.notifyUser("Your order #1234 has been placed.");
		emailService.sendOrderUpdate("1234", "SHIPPED");

		System.out.println();

		// ── Demo 2: SMS notifications — ZERO changes to NotificationService ──
		System.out.println("--- Using SmsNotifier (switched — NotificationService unchanged) ---");
		Notifier smsNotifier = new SmsNotifier();
		NotificationService smsService = new NotificationService(smsNotifier);
		smsService.notifyUser("Your order #1234 has been placed.");
		smsService.notifyAdmin("Server CPU usage above 90%.");

		System.out.println();

		// ── Demo 4: Testing with MockNotifier — no network needed ─────────
		System.out.println("--- Using MockNotifier (unit testing) ---");
		MockNotifier mock = new MockNotifier();
		NotificationService testService = new NotificationService(mock);

		testService.notifyUser("Test message 1");
		testService.notifyAdmin("Test alert");

		System.out.println();
		System.out.println("Test results:");
		System.out.println("  Total messages sent : " + mock.getSendCount());
		System.out.println("  Last message        : " + mock.getLastMessage());
		System.out.println("  Was called          : " + mock.wasCalled());

		System.out.println();
		System.out.println(">>> NotificationService.java was NEVER modified.");
		System.out.println(">>> Switching Email → SMS → Push → Mock = 1 line change in Main.");
		System.out.println(">>> That is Dependency Inversion Principle.");
	}

}
