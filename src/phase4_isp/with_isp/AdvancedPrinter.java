package phase4_isp.with_isp;

public class AdvancedPrinter implements Printable, Faxable, Scannable, Stapleable {

	@Override
	public void staple(String document) {
		 System.out.println("[AdvancedPrinter] Stapling: " + document);

	}

	@Override
	public void scan(String document) {
		 System.out.println("[AdvancedPrinter] Scanning: " + document);

	}

	@Override
	public void fax(String document) {
		System.out.println("[AdvancedPrinter] Faxing: " + document);

	}

	@Override
	public void print(String document) {
		System.out.println("[AdvancedPrinter] Printing: " + document);

	}

}
