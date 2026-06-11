package phase4_isp.with_isp;

public class ScannerOnly implements Scannable{

	@Override
	public void scan(String document) {
		System.out.println("[ScannerOnly] Scanning: " + document);
		
	}

}
