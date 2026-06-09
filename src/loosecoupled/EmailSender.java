package loosecoupled;

public class EmailSender implements MessageSender {

	@Override
	public void send(String message) {
		System.out.println("Sending Email: " + message);
	}

}
