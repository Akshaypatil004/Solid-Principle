package phase1_srp.with_srp;

import java.util.List;

/**
 * SRP — Job 3: Print/display only.
 * This class only knows how to format and display an invoice.
 * Reason to change: output format changes (text → HTML → PDF → receipt format)
 *
 * BENEFIT: Change the print format here — nothing else is at risk.
 * Tax logic, DB, email are completely untouched.
 */
public class InvoicePrinter {

    public void print(Invoice invoice, double total) {
        System.out.println("===========================================");
        System.out.println("                 INVOICE                  ");
        System.out.println("===========================================");
        System.out.println("Customer : " + invoice.getCustomerName());
        System.out.println("-------------------------------------------");

        List<String> names  = invoice.getItemNames();
        List<Double> prices = invoice.getItemPrices();

        for (int i = 0; i < names.size(); i++) {
            System.out.printf("  %-25s Rs %8.2f%n", names.get(i), prices.get(i));
        }

        System.out.println("-------------------------------------------");
        System.out.printf("  Subtotal                     Rs %8.2f%n", invoice.getSubtotal());
        System.out.printf("  TOTAL (incl. 18%% GST)        Rs %8.2f%n", total);
        System.out.println("===========================================");
    }
}