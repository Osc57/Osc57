package areas;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CirculoTest {
    @Test
    void testCalcularAreaCirculo() {
        Circulo circulo1 = new Circulo(3);
        double resultado = circulo1.CalcularAreaCirculo();
        assertEquals(28.274333882308138,resultado); 
      
    }

    @Test
    void testGetRadio() {
    Circulo circulo1 = new Circulo(2);
        double radio = circulo1.getRadio();
    }

    @Test
    void testSetRadio() {
        Circulo circulo1 = new Circulo(5);
        circulo1.setRadio(10);
    }
}

  
    