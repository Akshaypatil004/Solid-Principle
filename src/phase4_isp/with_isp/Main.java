package phase4_isp.with_isp;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== WITH ISP — Segregated Interfaces ===\n");

        // Each variable typed to the interface — only relevant methods visible
        Printable basicPrinter       = new BasicPrinter();
        Scannable scanner            = new ScannerOnly();
        OfficePrinter officePrinter  = new OfficePrinter();
        AdvancedPrinter advPrinter   = new AdvancedPrinter();

        System.out.println("--- Basic Printer (only has print) ---");
        basicPrinter.print("Invoice.pdf");
        // basicPrinter.scan() — this line won't even COMPILE! Safe at compile time.

        System.out.println("\n--- Scanner Only (only has scan) ---");
        scanner.scan("Report.pdf");
        // scanner.print() — won't compile! The method simply doesn't exist.

        System.out.println("\n--- Office Printer (print + scan + fax) ---");
        officePrinter.print("Contract.pdf");
        officePrinter.scan("Contract.pdf");
        officePrinter.fax("Contract.pdf");
        // officePrinter.staple() — won't compile! OfficePrinter doesn't implement Stapleable.

        System.out.println("\n--- Advanced Printer (all 4 capabilities) ---");
        advPrinter.print("LegalDoc.pdf");
        advPrinter.scan("LegalDoc.pdf");
        advPrinter.fax("LegalDoc.pdf");
        advPrinter.staple("LegalDoc.pdf");

        System.out.println("\n=== Key difference: ZERO try/catch, ZERO UnsupportedOperationException ===");
        System.out.println("The compiler protects you — you cannot even call a method that doesn't apply.");
    }
}
