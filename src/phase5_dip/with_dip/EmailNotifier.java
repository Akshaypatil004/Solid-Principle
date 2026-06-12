package phase5_dip.with_dip;

public class EmailNotifier implements Notifier {

	@Override
	public void send(String message) {
		System.out.println("[EMAIL] Connecting to smtp.gmail.com:587...");
        System.out.println("[EMAIL] " + message);
        System.out.println("[EMAIL] Delivered.");
	}

}
