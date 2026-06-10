package phase1_srp.with_srp;

/**
 * SRP — Job 4: Database persistence only. This class only knows how to save an
 * invoice to the database. Reason to change: DB changes (MySQL → PostgreSQL →
 * MongoDB, schema changes)
 *
 * BENEFIT: Switch DB here — tax calc, printing, email have zero risk.
 */

public class InvoiceRepository {

	public void save(Invoice invoice, double total) {
		 System.out.println();
	        System.out.println("[DATABASE]");
	        System.out.println("  Connecting to MySQL @ localhost:3306 ...");
	        System.out.printf("  INSERT INTO invoices (customer, total) VALUES ('%s', %.2f)%n",
	                invoice.getCustomerName(), total);
	        System.out.println("  Record saved successfully.");
	}

}
