import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class PilaTest {
    private Pila pila;
    @BeforeEach
    public void pila(){
        pila = new Pila();
    }

    @Test
    public void testPushPila(){
        pila.push(46);
        
    }
}
