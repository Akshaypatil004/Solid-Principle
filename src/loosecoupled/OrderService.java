package loosecoupled;

public class OrderService {
	private MessageSender sender;
	
	public OrderService(MessageSender sender) {
		this.sender = sender;
	}
	
	public void placeOrder(String item) {
		System.out.println("Order placed: " + item);
		sender.send("Your order for " + item + " is confirmed");
	}
}
