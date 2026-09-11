package areas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RectanguloTest {
    Rectangulo rectangulo;

    @BeforeEach
    void nuevoRectangulo(){
        rectangulo = new Rectangulo(10,12);
    }

    @Test
    void testCalcularAreaRectangulo() {
        double resultado = rectangulo.CalcularAreaRectangulo();
        assertEquals(120,resultado,"Error en la operación");
    }

    @Test
    void testGetAltura() {
        double altura = rectangulo.getAltura();
        assertEquals(12, altura);
    }

    @Test
    void testGetBase() {
        double base = rectangulo.getBase();
        assertEquals(10, base);

    }

    @Test
    void testSetAltura() {
        rectangulo.setAltura(20);
        double resultado=rectangulo.getAltura();
        assertEquals(20,resultado );
    }

    @Test
    void testSetBase() {
        rectangulo.setBase(15);
        double resultado=rectangulo.getAltura();
        assertEquals(15, resultado);

    }

    @Test
    void testSonLadosIguales() {
       if (rectangulo.getBase() == rectangulo.getAltura()) {
        System.out.println("Esto es un cuadrado");
       }
       else{
        System.out.println("Esto es un rectángulo");
       }
    }
}
