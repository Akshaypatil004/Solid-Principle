package phase4_isp.without_isp;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("---- WITHOUT ISP FAT INTERFACE PROBLEM ---- \n");
		
		MultiFunctionDevice basic = new BasicPrinter();
		MultiFunctionDevice scanner = new ScannerOnly();
		MultiFunctionDevice advanced = new AdvancedPrinter();
		
	       // BasicPrinter — only print works
        System.out.println("--- Basic Printer ---");
        basic.print("Invoice.pdf");

        try {
            basic.scan("Invoice.pdf");   // BOOM!
        } catch (UnsupportedOperationException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try {
            basic.fax("Invoice.pdf");    // BOOM!
        } catch (UnsupportedOperationException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try {
            basic.staple("Invoice.pdf"); // BOOM!
        } catch (UnsupportedOperationException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        // ScannerOnly — only scan works
        System.out.println("\n--- Scanner Only ---");
        scanner.scan("Report.pdf");

        try {
            scanner.print("Report.pdf"); // BOOM!
        } catch (UnsupportedOperationException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        // AdvancedPrinter — all works
        System.out.println("\n--- Advanced Printer ---");
        advanced.print("Contract.pdf");
        advanced.scan("Contract.pdf");
        advanced.fax("Contract.pdf");
        advanced.staple("Contract.pdf");
		
	}

}
