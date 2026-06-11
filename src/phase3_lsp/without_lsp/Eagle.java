package phase3_lsp.without_lsp;

public class Eagle extends Bird {

	public Eagle() {
		super("Eagle");
	}
	
	@Override
	public void fly() {
		super.fly();
		System.out.println(super.name + " is soaring at 3000 feet");
	}

}
