package phase3_lsp.with_lsp;

/**
 * WITH LSP — Eagle.java
 * Eagles genuinely fly. Honest subclass of FlyingBird.
 * Can substitute FlyingBird anywhere — no surprises.
 */

public class Eagle extends FlyingBird {

	public Eagle() {
		super("Eagle");
	}
	
	@Override
	public void fly() {
		System.out.println(name + " is soaring at 3000 feet!");
	}
	
	@Override
	public void makeSound() {
		System.out.println(name + " screeches powerfully");
	}

}
