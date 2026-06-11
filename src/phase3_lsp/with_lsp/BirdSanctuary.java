package phase3_lsp.with_lsp;

import java.util.Arrays;
import java.util.List;

/**
 * WITH LSP — BirdSanctuary.java
 * =============================================================
 * Now the sanctuary works safely with both flying and non-flying birds.
 *
 * Key change: makeAllBirdsFly() takes List<FlyingBird> — not List<Bird>.
 * This makes it IMPOSSIBLE to accidentally pass an Ostrich.
 * The type system enforces LSP at compile time, not runtime.
 * =============================================================
 */

public class BirdSanctuary {
	
	// Only FlyingBirds — Ostrich can't enter this list
    // The type system itself prevents the crash. No try-catch needed.
	
    public void makeAllBirdsFly(List<FlyingBird> birds) {
        System.out.println("--- Making all flying birds fly ---");
        for (FlyingBird bird : birds) {
            bird.eat();
            bird.fly();  
        }
    }
    
    // ALL birds can eat — Bird reference works for every bird
    public void feedAllBirds(List<Bird> birds) {
        System.out.println("--- Feeding all birds ---");
        for (Bird bird : birds) {
            bird.eat();  
        }
    }
    
  // ALL birds make sounds
    public void morningCalls(List<Bird> birds) {
        System.out.println("--- Morning calls ---");
        for (Bird bird : birds) {
            bird.makeSound();  // SAFE — every Bird has this
        }
    }
    
    public static void main(String[] args) {
        BirdSanctuary sanctuary = new BirdSanctuary();
 
        System.out.println("=== Bird Sanctuary (WITH LSP) ===\n");
 
        // Flying birds only
        List<FlyingBird> flyingBirds = Arrays.asList(
            new Sparrow(), new Eagle()
        );
 
        // ALL birds including non-flying
        List<Bird> allBirds = Arrays.asList(
            new Sparrow(), new Eagle(),
            new Ostrich()
        );
 
        // Non-flying birds showing their own unique abilities
        Ostrich ostrich = new Ostrich();
 
        sanctuary.makeAllBirdsFly(flyingBirds);
        System.out.println();
 
        sanctuary.feedAllBirds(allBirds);
        System.out.println();
 
        sanctuary.morningCalls(allBirds);
        System.out.println();
 
        System.out.println("--- Special abilities of non-flying birds ---");
        ostrich.run();
 
        System.out.println();
        System.out.println(">>> No crashes. No exceptions. No instanceof checks.");
        System.out.println(">>> Every class only promises what it can genuinely deliver.");
        System.out.println(">>> That is Liskov Substitution Principle.");
    }

}
