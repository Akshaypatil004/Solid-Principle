package phase4_isp.without_isp;
// ScannerOnly.java — only scans, but forced to implement everything

public class ScannerOnly implements MultiFunctionDevice {

	@Override
	public void print(String document) {
		throw new UnsupportedOperationException("ScannerOnly cannot print!");

	}

	@Override
	public void fax(String document) {
		throw new UnsupportedOperationException("ScannerOnly cannot fax!");

	}

	@Override
	public void scan(String document) {
		System.out.println("[ScannerOnly] Scanning: " + document);

	}

	@Override
	public void staple(String docuement) {
		throw new UnsupportedOperationException("ScannerOnly cannot staple!");

	}

}
