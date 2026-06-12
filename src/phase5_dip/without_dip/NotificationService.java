package phase5_dip.without_dip;

/**
 * WITHOUT DIP — NotificationService.java
 * ================================================================
 * VIOLATION: High-level business logic directly creates and depends
 * on a low-level concrete class (EmailSender).
 *
 * Problems this causes:
 *  1. Cannot switch to SMS without editing THIS file (OCP violated)
 *  2. Cannot unit test without real SMTP connection
 *  3. Cannot reuse for different notification channels
 *  4. Business logic is tightly coupled to infrastructure detail
 * ================================================================
 */

public class NotificationService {
	
	 //   High-level class creates low-level class directly
    //     This single line is the DIP violation.
    //     NotificationService now owns and controls its dependency.
//	private EmailSender emailSender = new EmailSender();
	private SmsSender smsSender = new SmsSender();
	
	public void notifyUser(String message) {
		System.out.println("[Notification] processing notification...");
//		emailSender.sendEmail(message);
		smsSender.sendSms(message);
	}
	
	public void notifyAdmin(String message) {
        System.out.println("[NOTIFICATION] Alerting admin...");
//        emailSender.sendEmail("[ADMIN ALERT] " + message);
        smsSender.sendSms(message);
    }
	
	 public static void main(String[] args) {
	        System.out.println("=== Notification System (WITHOUT DIP) ===\n");
	 
	        NotificationService service = new NotificationService();
	        service.notifyUser("Your order #1234 has been placed.");
	        System.out.println();
	        service.notifyAdmin("Server CPU usage above 90%.");
	 
	        System.out.println();
	        System.out.println(">>> Now try switching to SMS.");
	        System.out.println(">>> You must open NotificationService.java,");
	        System.out.println(">>> replace EmailSender with SmsSender,");
	        System.out.println(">>> and change sendEmail() to sendSms() everywhere.");
	        System.out.println(">>> That is the DIP violation in action.");
	    }

}
