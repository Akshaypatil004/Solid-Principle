package phase4_isp.with_isp;

//With ISP — BasicPrinter implements ONLY Printable.
//It doesn't even know scan/fax/staple interfaces exist

public class BasicPrinter implements Printable {

	@Override
	public void print(String document) {
		 System.out.println("[BasicPrinter] Printing: " + document);
	}

}
