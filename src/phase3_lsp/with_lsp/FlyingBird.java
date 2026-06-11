package phase3_lsp.with_lsp;

/**
 * WITH LSP — FlyingBird.java
 * =============================================================
 * RESPONSIBILITY: Represents birds that CAN fly.
 *
 * fly() lives here — not in Bird.
 * This means: only birds that genuinely fly ever extend this class.
 * The promise "I can fly" is now only made by classes that can keep it.
 *
 * Any code that needs flying uses FlyingBird — not Bird.
 * LSP guaranteed: every FlyingBird truly flies. No exceptions.
*/

public abstract class FlyingBird extends Bird {

	public FlyingBird(String name) {
		super(name);
	}
	
	public void fly() {
		System.out.println(name + " is flying");
	}

}
