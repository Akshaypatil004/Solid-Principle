package simple_project.with_solid;

public class DiscountCalculator {
	
	public double applyDiscount(double total) {
		
		if(total > 5000) {
			total *= 0.90;
		}
		
		return total;
		
	}

}
