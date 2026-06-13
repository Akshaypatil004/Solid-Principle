# SOLID Principles — Java Learning Journey

> **"SOLID doesn't make your code work. Your code already works. SOLID makes your code safe to change."**

A complete, hands-on learning project where every SOLID principle is built **twice** —
once intentionally broken, once properly applied — so you can see and feel the exact difference.

---

## Why This Repo Exists

I kept seeing posts about SOLID principles everywhere.
But no one explained **why** it matters or **what actually breaks** without it.

So I decided to learn it the proper way:

- 📝 Handwritten notes for every principle
- 💻 Two versions of every project — **without** the principle (bad code) + **with** the principle (clean code)
- 🔁 Same project, same output, different structure — so the difference is visible
- 🧠 Understanding the **cause** first, then the **cure**

This repo is the result of that journey.

---

## The Core Problem SOLID Solves

Before learning SOLID, I wrote code like this:

```java
// One class doing EVERYTHING — the God Class
public class InvoiceManager {
    public void addItem() { ... }       // stores data
    public void calculateTotal() { ... } // calculates tax
    public void printInvoice() { ... }   // prints output
    public void saveToDatabase() { ... } // saves to DB
    public void sendEmail() { ... }      // sends email
}
```

It worked. But the moment tax rate changed, I had to open this one file — and risk breaking the email, the DB, and the print logic all at once.

**That is tightly coupled code. SOLID is the cure.**

---

## Repo Structure

```
Solid-Principle/
└── src/
    ├── loosecoupled/          → OrderService with loose coupling (interface-based)
    ├── tightcoupled/          → OrderService with tight coupling (hardwired)
    ├── phase0_before_solid/   → The God Class — why SOLID exists
    ├── phase1_srp/            → S — Single Responsibility Principle
    ├── phase2_ocp/            → O — Open/Closed Principle
    ├── phase3_lsp/            → L — Liskov Substitution Principle
    ├── phase4_isp/            → I — Interface Segregation Principle
    ├── phase5_dip/            → D — Dependency Inversion Principle
    └── simple_project/        → Capstone: all 5 principles in one project
```

Each phase folder contains:
```
phase-name/
├── without-[principle]/src/   → bad code with the violation
├── with-[principle]/src/      → clean code with the principle applied
└── README.md                  → what changed and why
```

---

## What I Built — Phase by Phase

---

### Phase 0 — The God Class (Why SOLID Exists)

**Project:** Invoice Billing System

One class doing 5 completely different jobs.

| Job | Method | Who would change it |
|-----|--------|-------------------|
| Store data | `addItem()` | Product team |
| Calculate tax | `calculateTotal()` | Finance team |
| Print invoice | `printInvoice()` | UI team |
| Save to DB | `saveToDatabase()` | DB team |
| Send email | `sendEmail()` | Ops team |

**5 different teams = 5 reasons to change = 5 risks every time you open the file.**

The 4 problems this causes:
1. Change one thing → risk breaking everything else
2. Can't test anything in isolation
3. Can't reuse logic without copy-pasting
4. New developer spends hours just reading before touching anything

---

### Phase 1 — S: Single Responsibility Principle

> *"A class should have only one reason to change."*

**Project:** Invoice Billing System (same project, refactored)

| Before (1 class, 5 jobs) | After (5 classes, 1 job each) |
|--------------------------|-------------------------------|
| `InvoiceManager` does everything | `Invoice.java` — stores data only |
| | `TaxCalculator.java` — calculates tax only |
| | `InvoicePrinter.java` — prints only |
| | `InvoiceRepository.java` — saves to DB only |
| | `EmailNotifier.java` — sends email only |

**The SRP test:** Can I describe this class in one sentence **without the word "and"**?
If you need "and" — it has more than one responsibility.

**Result:** Tax rate changes → open `TaxCalculator.java` only. Nothing else can break.

---

### Phase 2 — O: Open/Closed Principle

> *"Open for extension, closed for modification."*

**Project:** Shape Area Calculator

```java
// WITHOUT OCP — every new shape = open this file and add else-if
public double calculateArea(Object shape) {
    if (shape instanceof Circle) { ... }
    else if (shape instanceof Rectangle) { ... }
    else if (shape instanceof Triangle) { ... }
    // Add Pentagon? Open this file. Risk breaking Circle and Rectangle.
}
```

```java
// WITH OCP — AreaCalculator never changes again
public interface Shape {
    double area();
}

public double calculateArea(Shape shape) {
    return shape.area(); // one line. done. forever.
}
```

**Result:** Added `Pentagon.java` and `Ellipse.java` — `AreaCalculator.java` was never opened.

**The OCP smell:** Any `if (x instanceof SomeType)` chain = OCP violated.

---

### Phase 3 — L: Liskov Substitution Principle

> *"Subclasses must be substitutable for their parent — without breaking anything."*

**Project:** Bird Sanctuary System

```java
// WITHOUT LSP — Ostrich breaks the fly() promise
public class Ostrich extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostrich cannot fly!");
        // Code using Bird crashes at runtime when handed an Ostrich
    }
}
```

```java
// WITH LSP — honest hierarchy
abstract class Bird { void eat(); void makeSound(); }
abstract class FlyingBird extends Bird { void fly(); }

class Sparrow extends FlyingBird { } // genuinely flies ✅
class Eagle  extends FlyingBird { } // genuinely flies ✅
class Ostrich extends Bird      { void run(); } // no fly() promise ✅
class Penguin extends Bird      { void swim(); } // no fly() promise ✅
```

**Result:** Zero runtime crashes. Zero `instanceof` checks. Every class only promises what it can deliver.

**The LSP checklist:**
- Does any method throw `UnsupportedOperationException`? → LSP violated
- Does any overridden method have an empty body? → LSP violated
- Does caller code check `instanceof` before calling a method? → LSP violated

---

### Phase 4 — I: Interface Segregation Principle

> *"Don't force a class to implement methods it doesn't need."*

**Project:** Worker / Robot System

```java
// WITHOUT ISP — fat interface forces Robot to implement eat()
public interface Worker {
    void work();
    void eat();        // humans need this — robots don't
    void takeBreak();  // humans need this — robots don't
}

public class Robot implements Worker {
    public void eat() { /* forced to implement — makes no sense */ }
}
```

```java
// WITH ISP — focused interfaces, each class implements only what it needs
public interface Workable  { void work(); }
public interface Eatable   { void eat(); }
public interface Breakable { void takeBreak(); }

public class HumanWorker implements Workable, Eatable, Breakable { }
public class Robot         implements Workable { } // honest, no forced methods
```

**Result:** No empty methods. No lies. Every class only signs contracts it can keep.

---

### Phase 5 — D: Dependency Inversion Principle

> *"High-level modules should not depend on low-level modules. Both should depend on abstractions."*

**Project:** Notification System

```java
// WITHOUT DIP — business logic hardwired to infrastructure
public class NotificationService {
    private EmailSender emailSender = new EmailSender(); // hardcoded!
    // Can't switch to SMS. Can't test without real SMTP. Tightly coupled.
}
```

```java
// WITH DIP — depend on abstraction, inject from outside
public interface Notifier {
    void send(String message);
}

public class NotificationService {
    private final Notifier notifier;
    public NotificationService(Notifier notifier) { // injected, not created
        this.notifier = notifier;
    }
}

// In Main.java — swap providers with one line:
Notifier notifier = new EmailNotifier(); // or SmsNotifier, PushNotifier, MockNotifier
```

**Result:** Switch Email → SMS = one line in `Main.java`. `NotificationService` never opens.
Testing = inject `MockNotifier`. Zero SMTP. Zero side effects. Instant.

**The DIP smell:** `private SomeConcrete thing = new SomeConcrete();` inside a class = DIP violated.

---

### Simple Project — Capstone (All 5 Together)

**Project:** E-commerce Order Processing System

One complete system — first with **all 5 violations**, then with **all 5 principles applied**.

| Principle | Violation | Fix Applied |
|-----------|-----------|-------------|
| SRP | `OrderProcessor` does 5 jobs | `Order`, `PaymentProcessor`, `OrderRepository`, `DiscountCalculator`, `OrderConfirmationService` |
| OCP | `if-else` payment type chains | `Payable` interface → `CreditCard`, `UPI`, `Cash` each implement it |
| LSP | `CashPayment.processRefund()` throws exception | `Payable` + `Refundable` split — Cash only implements `Payable`, honest |
| ISP | Fat interface forces Cash into refund it can't do | `Payable` (pay only) + `Refundable` (refund only) |
| DIP | `new EmailSender()` hardcoded in business logic | `Notifier` interface injected via constructor |

---

## Tight Coupling vs Loose Coupling

The foundation before any SOLID principle:

| | Tight Coupling | Loose Coupling |
|--|----------------|----------------|
| How classes connect | Directly (`new EmailSender()`) | Through interface (`Notifier`) |
| Change one → | Forces change in others | Others stay untouched |
| Testing | Hard — real dependencies required | Easy — inject mocks |
| Real world analogy | Laptop hardwired to one specific monitor | Laptop with HDMI port — any monitor works |

See `src/tightcoupled/` and `src/loosecoupled/` for the `OrderService` example.

---

## How to Run Any Project

```bash
# Navigate to any phase
cd src/phase1_srp/with-srp/

# Compile all Java files
javac *.java

# Run
java Main
```

---

## Key Takeaways

After building all of this, three things changed in how I think about code:

**1. Build the bad version first.**
You only truly understand why a principle exists when you feel the pain without it.

**2. The question to ask every class:**
*"If requirements change tomorrow, how many files do I need to open?"*
With SOLID — the answer is always 1.

**3. SOLID is not about perfection.**
It's about writing code that your future self (and your teammates) can understand, change, and test without fear.

---

## Learning Resources

- **Code** — every file in this repo is fully commented explaining what principle is applied and why

---

## Connect

If you're learning Java or SOLID principles and want to discuss — feel free to open an issue or reach out on LinkedIn.

⭐ If this repo helped you understand SOLID better, a star means a lot.

---
