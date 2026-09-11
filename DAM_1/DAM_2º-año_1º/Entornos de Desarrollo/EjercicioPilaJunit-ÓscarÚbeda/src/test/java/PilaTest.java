import org.example.Pila;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.testng.AssertJUnit.*;

public class PilaTest {
    private Pila pila;

    @BeforeEach
    public void pilaInicializacion(){
        pila = new Pila();
    }


    @Test
    public void testPilaPushNumeroValidoRango(){
        assertTrue(pila.push(46));
    }

    @Test
    public void testPilaPushNumeroInvalidoRango(){
        assertTrue(pila.push(47));
    }

    @Test
    public void testPilaPushNumeroInferiorNoRango(){
        assertTrue(pila.push(38));
    }

    @Test
    public void testPilaPuchNumeroMayorNoRango(){
        assertTrue(pila.push(76));
    }

    @Test
    public void testPilaPopExtraer(){
        pila.push(46);
        pila.push(50);

        assertEquals("46",pila.pop());
    }

    @Test
    public void testPilaPopVacio(){
        assertEquals(null,pila.pop());
    }
}