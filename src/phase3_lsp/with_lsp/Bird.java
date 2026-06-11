package phase3_lsp.with_lsp;

/**
 * WITH LSP — Bird.java (Base class)
 * =============================================================
 * SINGLE RESPONSIBILITY: What ALL birds share — nothing more.
 *
 * By removing fly() from here, we stop making promises
 * that not all birds can keep.
 *
 * Only put a method in Bird if EVERY bird that ever exists
 * can genuinely fulfil it without exception or empty body.
 *
 *Every bird:
 *  - Has a name     ✅
 *  - Eats           ✅
 *  - Can fly        ✗ (ostriches, penguins — no)
 *  - Makes a sound  ✅
 * =============================================================
 */

public abstract class Bird {
	
	protected String name;
	
	public Bird(String name) {
		this.name = name;
	}
	
	public void eat() {
		System.out.println(name + " is eating.");
	}
	
	public void makeSound() {
		System.out.println(name + " makes a sound");
	}
	
	public String getName() {
		return name;
	}

}
