package phase2_ocp.without_ocp;

public class Main {
	public static void main(String[] args) {
		AreaCalculator cal = new AreaCalculator();
		
		Circle c = new Circle(13);
		
		double calculateArea1 = cal.calculateArea(c);
		
		System.out.println("Area of circle : " + calculateArea1);
		System.out.println("___________________________________________");
		
		Rectangle r = new Rectangle(12, 6);
		
		double calculateArea2 = cal.calculateArea(r);
		
		System.out.println("Area of rectangle: " + calculateArea2);
		System.out.println("___________________________________________");
		
		Square s = new Square(4);
		
		double calculateArea3= cal.calculateArea(s);
		
		System.out.println("Area of square : " + calculateArea3);
		
		
	}

}
