package simple_project.with_solid;

/**
 * [ISP] Refundable.java — focused interface: only refund
 * ============================================================
 * ISP: Only payment methods that CAN refund implement this.
 * Cash doesn't implement this — and that's honest, not a problem.
 */

public interface Refundable {
	
	void refund(double amount);

}
