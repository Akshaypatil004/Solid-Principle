package tightcoupled;

public class OrderService {
	private EmailSender emailSender;
	
	public OrderService()
	{
		this.emailSender = new EmailSender();
	}
	
	public void placeOrder(String item) {
		System.out.println("Order place: " + item);
		emailSender.sendEmail("Your order for " + item + " is confiremed.");
	}

}
