import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;


public class ImpuestosTest {

    @Test
    @DisplayName("Calcular PVP: Caso normal (1.00 + 21% = 1.21)")
    void testPVP_CasoNormal() {
        double resultado = Impuestos.calcularPVP(1.00, 0.21);
        assertEquals(1.21, resultado, 0.001);
    }

    @Test
    @DisplayName("Calcular PVP: Con precio base cero")
    void testPVP_PrecioCero() {
        double resultado = Impuestos.calcularPVP(0.0, 0.21);
        assertEquals(0.0, resultado, 0.001);
    }

    @Test
    @DisplayName("Calcular PVP: Con impuesto de cero por ciento")
    void testPVP_TipoCero() {
        double resultado = Impuestos.calcularPVP(100.0, 0.0);
        assertEquals(100.0, resultado, 0.001);
    }

    //----------------------------------------

    @Test
    @DisplayName("Calcular Precio: Caso inverso (1.21 con 21% = 1.00)")
    void testPrecio_CasoNormal() {
        double resultado = Impuestos.calcularPrecio(1.21, 0.21);
        assertEquals(1.00, resultado, 0.001);
    }

    @Test
    @DisplayName("Calcular Precio: Con PVP de cero")
    void testPrecio_PvpCero() {
        double resultado = Impuestos.calcularPrecio(0.0, 0.21);
        assertEquals(0.0, resultado, 0.001);
    }

    //------------------------------------

    @Test
    @DisplayName("Error: Lanzar excepción si el impuesto es negativo en PVP")
    void testPVP_ErrorSiTipoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            Impuestos.calcularPVP(10.0, -0.1);
        });
    }

    @Test
    @DisplayName("Error: Lanzar excepción si el impuesto es negativo en Precio")
    void testPrecio_ErrorSiTipoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            Impuestos.calcularPrecio(10.0, -0.1);
        });
    }
}




