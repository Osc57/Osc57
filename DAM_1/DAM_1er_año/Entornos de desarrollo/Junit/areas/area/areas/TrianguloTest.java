package areas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TrianguloTest {
    Triangulo triangulo;

    @BeforeEach
    void nuevoTriangulo(){
        triangulo = new Triangulo(12,20);
    }

    @Test
    void testCalcularAreaTriangulo() {
        double resultado = triangulo.CalcularAreaTriangulo();
        assertEquals(120,resultado,"Error en la operación");
    }

    @Test
    void testGetAltura() {
        double altura = triangulo.getAltura();
        assertEquals(20, altura);
    }

    @Test
    void testGetBase() {
        double base = triangulo.getBase();
        assertEquals(12, base);
    }

    @Test
    void testSetAltura() {
        triangulo.setAltura(40);
        double resultado=triangulo.getAltura();
        assertEquals(40,resultado );
    }

    @Test
    void testSetBase() {
        triangulo.setBase(24);
        double resultado=triangulo.getBase();
        assertEquals(24, resultado);

    }
}
