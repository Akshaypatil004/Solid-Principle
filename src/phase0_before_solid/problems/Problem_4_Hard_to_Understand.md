# Problem 4 — Hard to Understand and Navigate

## The scenario

A new developer joins the team on Day 1.
Their first task: "Fix the tax rate — it should be 12% not 18%."

They open `InvoiceManager.java` and see:

```
Line   1–15  : Class declaration and field variables
Line  16–30  : Constructor and addItem()
Line  31–55  : calculateTotal() — tax logic is here
Line  56–85  : printInvoice() — lots of String formatting
Line  86–95  : printInvoice() still... (calls calculateTotal() internally)
Line  96–130 : saveToDatabase() — JDBC imports and SQL strings
Line 131–165 : sendEmailNotification() — SMTP config
Line 166–200 : main() method
```

## The questions running through the new dev's head

- "Is the tax rate in `calculateTotal()`? Or is it also in `saveToDatabase()`?"
- "Does `printInvoice()` have its own calculation or does it call the method?"
- "If I change line 42, what calls it? Will DB insert use the new value automatically?"
- "Is there a `TaxConfig` or `Settings` class somewhere? Or is this the only place?"
- "Who wrote this? Can I ask them? (They left the company 6 months ago.)"

**They spend 2 hours reading before making a 1-line change.**
**Then they spend another hour re-testing everything because they're not sure what they touched.**

## The compounding effect

This is not just "slightly annoying". In real codebases:
- Files grow to 500, 1000, 2000 lines
- The God Class accumulates more jobs over time (logging, caching, validation...)
- No one wants to touch it — it becomes "legacy code"
- Eventually the team decides to rewrite the whole system from scratch
- The rewrite costs months of work and introduces new bugs
- **The root cause was bad code structure from Day 1**

