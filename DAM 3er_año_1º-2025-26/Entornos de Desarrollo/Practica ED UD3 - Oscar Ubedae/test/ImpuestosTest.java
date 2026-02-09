import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ImpuestosTest {
    @Test
    void testPVP_CasoNormal() {
        double resultado = Impuestos.calcularPVP(1.00, 0.21);
        assertEquals(1.21, resultado, 0.001);
    }

    @Test
    void testPVP_PrecioCero() {
        double resultado = Impuestos.calcularPVP(0.0, 0.21);
        assertEquals(0.0, resultado, 0.001);
    }

    @Test
    void testPVP_TipoCero() {
        double resultado = Impuestos.calcularPVP(100.0, 0.0);
        assertEquals(100.0, resultado, 0.001);
    }

    @Test
    void testPrecio_CasoNormal() {
        double resultado = Impuestos.calcularPrecio(1.21, 0.21);
        assertEquals(1.00, resultado, 0.001);
    }

    @Test
    void testPrecio_PvpCero() {
        double resultado = Impuestos.calcularPrecio(0.0, 0.21);
        assertEquals(0.0, resultado, 0.001);
    }

    @Test
    void testPVP_ErrorSiTipoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            Impuestos.calcularPVP(10.0, -0.1);
        });
    }

    @Test
    void testPrecio_ErrorSiTipoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            Impuestos.calcularPrecio(10.0, -0.1);
        });
    }
}



