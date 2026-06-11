package phase3_lsp.without_lsp;

public class Sparrow extends Bird {

	public Sparrow() {
		super("Sparrow");
	}
	
	@Override
	public void fly() {
		super.fly();
		System.out.println(super.name + " darting through the bushes");
	}
	

}
