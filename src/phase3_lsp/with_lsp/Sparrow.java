package phase3_lsp.with_lsp;

/**
 * WITH LSP — Sparrow.java
 * Sparrows genuinely fly. Honest subclass of FlyingBird.
 * Can substitute FlyingBird anywhere — no surprises.
 */

public class Sparrow extends FlyingBird {

	public Sparrow() {
		super("Sparrow");
	}
	
	@Override
	public void fly() {
		System.out.println(name + " is darting through the bushes!");
	}
	
	@Override
	public void makeSound() {
		System.out.println(name + "chirps: tweet tweet!");
	}

}
