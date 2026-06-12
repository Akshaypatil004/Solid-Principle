package phase5_dip.with_dip;

public class SmsNotifier implements Notifier {

	@Override
	public void send(String message) {
		System.out.println("[SMS] Connecting to Twilio API...");
		System.out.println("[SMS] " + message);
		System.out.println("[SMS] Delivered.");

	}

}
