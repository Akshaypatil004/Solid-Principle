package simple_project.with_solid;

/**
 * [DIP] Notifier.java — the abstraction
 * ============================================================
 * OrderConfirmationService depends on THIS — not on EmailSender.
 * Both sides depend on this abstraction.
 * That is the Dependency Inversion.
 */
public interface Notifier {
    void send(String message);
}