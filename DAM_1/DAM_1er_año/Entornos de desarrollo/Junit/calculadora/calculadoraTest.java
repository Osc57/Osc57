package calculadora;

import static org.junit.Assert.*;
import org.junit.Test;

public class calculadoraTest {
  
    @Test
    public void testSuma(){

        calculadora calcu = new calculadora(20, 10);
        int resultado = calcu.suma();
        assertEquals (30, resultado);

    }
    @Test
    public void testResta(){

        calculadora calcu = new calculadora(15, 10);
        int resultado = calcu.resta();
        assertEquals("La resta es correcta", 5, resultado);
        
    }
    @Test
    public void testMultiplicacion(){

        calculadora calcu = new calculadora(5, 10);
        int resultado = calcu.multiplica();
        assertEquals(50, resultado);
    }
    @Test
    public void testDivision(){

        calculadora calcu = new calculadora(49, 7);
        int resultado = calcu.divide2();
        assertEquals(7, resultado);
    }


}
