package phase2_ocp.without_ocp;


public class AreaCalculator {
	
	  //   Every new shape = open this file and add another if-else
	  //   This method grows forever as shapes are added
	  //   Every edit risks breaking the existing shape calculations
	
	public double calculateArea(Object shape) {
		
		if(shape instanceof Circle) {
			Circle c = (Circle) shape;
			double radius = c.getRadius();
			return Math.PI * radius * radius;
		}
		else if(shape instanceof Rectangle) {
			Rectangle r = (Rectangle) shape;
			double width = r.getWidth();
			double height = r.getHeight();
			return width * height;
			
			//   Every new shape = open this file and add another if-else
			//   This method grows forever as shapes are added
			//   Every edit risks breaking the existing shape calculations
		}
		else if(shape instanceof Square) {
			
			// added this later in second time run
			Square s = (Square) shape;
			double side = s.getSide();
			return side * side;
			
		}
		else {
			throw new IllegalArgumentException("Unknown shape");
		}
	}

}
