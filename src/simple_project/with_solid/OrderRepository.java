package simple_project.with_solid;

public class OrderRepository {
	
	public void save(Order order, double total, String paymentType) {
		System.out.println("[DB] Saving order for: " + order.getCustomerName());
        System.out.printf("[DB] Total: Rs %.2f | Payment: %s%n",
                total, paymentType);
        System.out.println("[DB] Order saved.");
	}

}
