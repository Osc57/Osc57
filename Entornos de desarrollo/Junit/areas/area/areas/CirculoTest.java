package areas;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CirculoTest {
    @Test
    void testCalcularAreaCirculo() {
        Circulo circulo1 = new Circulo(14);
        double resultado = circulo1.CalcularAreaCirculo();
        assertEquals(615.7521601035994,resultado,"Error en la operación"); 
      
    }

    @Test
    void testGetRadio() {
        Circulo circulo1 = new Circulo(2);
        double radio = circulo1.getRadio();
        assertEquals(2, radio);

    }

    @Test
    void testSetRadio() {
        Circulo circulo1 = new Circulo(5);
        circulo1.setRadio(10);
        double resultado = circulo1.getRadio();
        assertEquals(10, resultado);

    }
}

  
    