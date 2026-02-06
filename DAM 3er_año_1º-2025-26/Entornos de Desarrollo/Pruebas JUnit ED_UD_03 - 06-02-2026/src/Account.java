import java.util.Objects;

public class Account {
    private final String customerName;
    private double balance;

    public Account(String customerName) {
        this.customerName = Objects.requireNonNull(customerName, "El nombre no puede ser nulo");
        this.balance = 0;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getBalance() {
        return balance;
    }

    public void credit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("El monto debe ser positivo");
        }
        balance += amount;
    }

    public void debit(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("El monto debe ser positivo");
        }
        balance -= amount;
    }
}
