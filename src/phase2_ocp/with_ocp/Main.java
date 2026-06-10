package phase2_ocp.with_ocp;

public class Main {
	public static void main(String[] args) {
		AreaCalculator cal = new AreaCalculator();
		
		Circle c = new Circle(14);
		System.out.println("Area of circle: " + cal.calculateArea(c));
		System.out.println("-------------------------------------------");
		
		Rectangle r = new Rectangle(13, 5);
		System.out.println("Area of rectangle: " + cal.calculateArea(r));
		System.out.println("-------------------------------------------");
		
		Square s = new Square(5);
		System.out.println("Area of square: " + cal.calculateArea(s));
		System.out.println("-------------------------------------------");
	}

}
