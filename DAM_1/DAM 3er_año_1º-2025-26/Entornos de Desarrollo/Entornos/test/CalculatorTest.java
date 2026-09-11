import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    @DisplayName("Add two numbers")
    void add() {
        assertAll( () -> assertEquals(4, Calculator.add(2, 2)),
                () -> assertEquals(-4,Calculator.multiply(2,-2)));

    }

    void multiPly() {

    }
}
