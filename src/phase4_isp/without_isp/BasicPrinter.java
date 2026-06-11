package phase4_isp.without_isp;
/**
 * BasicPrinter.java — only prints, but forced to implement everything
 */
public class BasicPrinter implements MultiFunctionDevice {

	@Override
	public void print(String document) {
		 System.out.println("[BasicPrinter] Printing: " + document);
	}

	@Override
	public void fax(String document) {
		 // BasicPrinter cannot fax — but the interface FORCES this method!
        throw new UnsupportedOperationException("BasicPrinter does not support faxing!");

	}

	@Override
	public void scan(String document) {
		 // BasicPrinter cannot scan — but the interface FORCES this method!
        throw new UnsupportedOperationException("BasicPrinter does not support scanning!");
	}

	@Override
	public void staple(String docuement) {
		 // BasicPrinter cannot staple — but the interface FORCES this method!
        throw new UnsupportedOperationException("BasicPrinter does not support stapling!");

	}

}
