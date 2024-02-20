import static org.junit.Assert.*;
import org.junit.Test;

public class CirculoTest {
    
    @Test
    void testCalcularAreaCirculo(){
        Circulo circulo1 = new Circulo(2);
        double resultado = circulo1.CalcularAreaCirculo();
        assertEquals(5, resultado);
    }

    @Test
    void testGetRadio(){
        Circulo circulo1 = new Circulo(2);
        double resultado = circulo1.getRadio();
        
    }

    @Test
    void testSetRadio(){
        Circulo circulo1 = new Circulo(5);
        circulo1.setRadio(10);
    } 
    
    

}