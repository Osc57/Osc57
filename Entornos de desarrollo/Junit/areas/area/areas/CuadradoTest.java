package areas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CuadradoTest {
    @Test
    void testCalcularAreaCuadrado() {
        Cuadrado cuadrado1 = new Cuadrado(15);
        double resultado = cuadrado1.CalcularAreaCuadrado();
        assertEquals(225,resultado,"Error en la operación"); 
    }

    @Test
    void testGetBase() {
        Cuadrado cuadrado1 = new Cuadrado(4);
        double base = cuadrado1.getBase();
        assertEquals(4, base);

    }

    @Test
    void testSetBase() {
        Cuadrado cuadrado1 = new Cuadrado(5);
        cuadrado1.setBase(10);
        double resultado=cuadrado1.getBase();
        assertEquals(10, resultado);

    }
}
