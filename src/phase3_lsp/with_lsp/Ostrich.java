package phase3_lsp.with_lsp;

/**
 * WITH LSP — Ostrich.java
 * =============================================================
 * Ostrich extends Bird directly — NOT FlyingBird.
 *
 * This is the honest redesign. Ostrich makes NO flying promise.
 * It only promises what it genuinely can do:
 *  - eat()      ✅ (inherited from Bird)
 *  - run()      ✅ (its own unique ability)
 *  - makeSound() ✅ (inherited from Bird)
 *
 * No UnsupportedOperationException.
 * No empty fly() body.
 * No lies.
 *
 * LSP satisfied: Ostrich can substitute Bird anywhere Bird is used.
 * Code that needs a Bird? Ostrich works perfectly.
 * Code that needs a FlyingBird? Ostrich is not offered — by design.
 * =============================================================
 */

public class Ostrich extends Bird {

	public Ostrich() {
		super("Ostrich");	
	}
	
	public void run() {
		System.out.println(name + " is running at 70 km/h!");
	}

	@Override
	public void makeSound() {
		System.out.println(name + " makes a deep booming sound !");
	}
	
}
