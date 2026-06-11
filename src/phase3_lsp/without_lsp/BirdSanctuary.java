package phase3_lsp.without_lsp;

import java.util.Arrays;
import java.util.List;

public class BirdSanctuary {

	// trust that all birds can fly - safe assumption ? no
	public void makeAllBirdsFly(List<Bird> birds) {

		System.out.println("---- Making all birds fly ----");
		for (Bird bird : birds) {
			bird.eat();
			bird.fly();// crash when bird = ostrich
		}

	}

	public static void main(String[] args) {

		BirdSanctuary sanctuary = new BirdSanctuary();

		System.out.println("=== Bird Sanctuary (WITHOUT LSP) ===\n");

		// These work fine:
		List<Bird> flyingOnes = Arrays.asList(new Sparrow(), new Eagle());
		System.out.println("Test 1 — Only flying birds:");
		sanctuary.makeAllBirdsFly(flyingOnes);

		System.out.println();
		System.out.println("Test 2 — Mixed list including Ostrich:");

		// This CRASHES — Ostrich.fly() throws UnsupportedOperationException
		List<Bird> allBirds = Arrays.asList(new Sparrow(), new Ostrich(), new Eagle());
		try {
			sanctuary.makeAllBirdsFly(allBirds);
		} catch (UnsupportedOperationException e) {
			System.out.println("CRASH: " + e.getMessage());
			System.out.println();
			System.out.println(">>> This is the LSP violation.");
			System.out.println(">>> Ostrich said 'I am a Bird' but broke the fly() promise.");
			System.out.println(">>> The fix is NOT to add a try-catch here.");
			System.out.println(">>> The fix is to redesign the Bird hierarchy.");
		}

	}

}
