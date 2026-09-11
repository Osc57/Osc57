import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class AccountTest {

    @Test
    @DisplayName("Verificar inicialización del constructor")
    void testConstructor() {
        String name = "Juan Pérez";
        Account account = new Account(name);

        assertEquals(name, account.getCustomerName());
        assertEquals(0, account.getBalance(), "El saldo inicial debe ser 0");
    }

    @Test
    @DisplayName("Lanzar excepción cuando el nombre es nulo")
    void testConstructor_NullName_ThrowsException() {
        assertThrows(NullPointerException.class, () -> {
            new Account(null);
        });
    }

    @Test
    @DisplayName("Incrementar saldo con Credit")
    void testCredit() {
        Account account = new Account("Test");
        account.credit(100.50);

        assertEquals(100.50, account.getBalance(), 0.001);
    }

    @Test
    @DisplayName("Decrementar saldo con Debit")
    void testDebit() {
        Account account = new Account("Test");
        account.credit(100.0);
        account.debit(40.0);

        assertEquals(60.0, account.getBalance(), 0.001);
    }

    @Test
    @DisplayName("Lanzar excepción por saldo insuficiente en Debit")
    void testDebit_InsufficientFunds_ThrowsException() {
        Account account = new Account("Test");
        account.credit(10.0);

        assertThrows(IllegalArgumentException.class, () -> {
            account.debit(20.0);
        });
    }
}
