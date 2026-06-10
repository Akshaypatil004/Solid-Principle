package phase1_srp.with_srp;

/**
 * SRP — Job 5: Email notification only.
 * This class only knows how to send an email notification.
 * Reason to change: email provider changes (SMTP → SendGrid → AWS SES)
 *
 * BENEFIT: Change email provider here — billing logic is never touched.
 */
public class EmailNotifier {

    public void notify(Invoice invoice, double total) {
        System.out.println();
        System.out.println("[EMAIL]");
        System.out.println("  Connecting to SMTP: smtp.gmail.com:587");
        System.out.println("  To      : "
                + invoice.getCustomerName().toLowerCase().replace(" ", ".") + "@example.com");
        System.out.println("  Subject : Invoice Generated");
        System.out.printf("  Body    : Dear %s, your invoice of Rs %.2f is ready.%n",
                invoice.getCustomerName(), total);
        System.out.println("  Email sent successfully.");
    }
}
