package phase4_isp.without_isp;
// AdvancedPrinter.java — supports all 4 (but still wrong design)
public class AdvancedPrinter implements MultiFunctionDevice {

	@Override
	public void print(String document) {
		 System.out.println("[AdvancedPrinter] Printing: " + document);

	}

	@Override
	public void fax(String document) {
		 System.out.println("[AdvancedPrinter] Faxing: " + document);

	}

	@Override
	public void scan(String document) {
		 System.out.println("[AdvancedPrinter] Scanning: " + document);

	}

	@Override
	public void staple(String document) {
		System.out.println("[AdvancedPrinter] Stapling: " + document);

	}

}
