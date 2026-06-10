package phase2_ocp.with_ocp;

public class Square implements Shape {
	
	private double side;
	
	public Square(double side) {
		this.side = side;
	}

	@Override
	public double area() {
		return side * side;
	}

}
