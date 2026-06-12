package phase5_dip.without_dip;
//SmsSender.java — another low-level class

public class SmsSender {
	
	public void sendSms(String message) {
		System.out.println("[SMS] sending via Twilio API: " + message);
	}

}
