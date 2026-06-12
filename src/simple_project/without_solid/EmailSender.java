package simple_project.without_solid;

public class EmailSender {

	public void send(String message) {
		System.out.println("[EMAIL] connecting to smtp.gmail.com:587");
		System.out.println("[EMAIL] sending: " + message);
	}

}
