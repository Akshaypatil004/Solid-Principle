package loosecoupled;

public class Main {
	public static void main(String[] args) {
		OrderService service1  = new OrderService(new EmailSender());
		service1.placeOrder("Laptop");
		
		OrderService service2 = new OrderService(new SmsSender());
		service2.placeOrder("Phone");
		
	}

}
