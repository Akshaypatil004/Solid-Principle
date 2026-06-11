package phase4_isp.with_isp;

public class OfficePrinter implements Printable, Scannable, Faxable {

	@Override
	public void fax(String document) {
		System.out.println("[OfficePrinter] Faxing: " + document);

	}

	@Override
	public void scan(String document) {
		System.out.println("[OfficePrinter] Scanning: " + document);
	}

	@Override
	public void print(String document) {
		System.out.println("[OfficePrinter] Printing: " + document);

	}

}
