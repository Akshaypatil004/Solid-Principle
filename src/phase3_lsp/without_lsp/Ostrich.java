package phase3_lsp.without_lsp;

public class Ostrich extends Bird {

	public Ostrich() {
		super("Ostrich");
	}
	
	// force to override fly() - but cannot full promise 
	@Override
	public void fly() {
		throw new UnsupportedOperationException("Ostrich cannot fly! ");
	}
	
	public void run() {
		System.out.println(super.name + " is running at 70 km/h!");
	}

}
