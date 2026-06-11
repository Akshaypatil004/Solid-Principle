// Bird.java - parent class
package phase3_lsp.without_lsp;

public class Bird {
	
	protected String name;
	
	public Bird(String name) {
		this.name = name;
	}
	
	// every bird can fly
	public void fly() {
		System.out.println(name + " is flying !");
	}
	
	public void eat() {
		System.out.println(name + " is eating !");
	}

}
