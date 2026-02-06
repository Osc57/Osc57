import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class CalculatorTest {
    private Calculator calc;

    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }

    @Test
    @DisplayName("Suma simple: 2 + 3 = 5")
    void testAdd() {
        assertEquals(5, calc.add(2, 3), "La suma debería ser 5");
    }

    @Test
    @DisplayName("Resta simple: 10 - 4 = 6")
    void testSubtract() {
        assertEquals(6, calc.subtract(10, 4));
    }

    @Test
    @DisplayName("Multiplicación simple: 3 * 3 = 9")
    void testMultiply() {
        assertEquals(9, calc.multiply(3, 3));
    }

    @Test
    @DisplayName("División exacta")
    void testDivide() {
        assertEquals(2.5, calc.divide(5, 2), 0.001);
    }

    @Test
    @DisplayName("Lanzar excepción al dividir por cero")
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calc.divide(10, 0));
    }
}
