package phase5_dip.without_dip;

//EmailSender.java — low-level detail class

public class EmailSender {
	
	public void sendEmail(String message) {
		System.out.println("[EMAIL] connecting to smtp.gmail.com:587");
		System.out.println("[EMAIL] sending: " + message);
	}

}
