package phase5_dip.with_dip;

/**
 * WITH DIP — MockNotifier.java (For Testing)
 * ================================================================ This is the
 * DIP testing superpower.
 *
 * Because NotificationService depends on the Notifier abstraction, we can
 * inject this MockNotifier during tests.
 *
 * No SMTP. No Twilio. No network. No side effects. Pure, fast, safe unit
 * testing. ================================================================
 */

public class MockNotifier implements Notifier {

	private int sendCount = 0;
	private String lastMessage = "";

	@Override
	public void send(String message) {
		sendCount++;
		lastMessage = message;
		System.out.println("[MOCK] captured message # " + sendCount + ": " + message);

	}

	// Test helper methods
	public int getSendCount() {
		return sendCount;
	}

	public String getLastMessage() {
		return lastMessage;
	}

	public boolean wasCalled() {
		return sendCount > 0;
	}

}
