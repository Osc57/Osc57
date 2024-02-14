package punto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import java.math.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.beans.Transient;

class Puntotest {

    @BeforeEach
    void nuevopunto(){
        Punto p1 = new Punto(3, 2);
    }

    @Test
    void testGetx(){
        p1.setX(3);
        assertEquals(3, p1.getX());
    }    

    @Test
    void testSetY(){
        p1.setY(2);
        assertEquals(2, p1.setY());
    }

    @Test
    void testdistancia(){
        Punto p2=new Punto(2, 1);
        assertEquals(p1.distancia(p2), sqrt(2));
    }

    @Test
    void testCompara(){
        Punto p2 = new Punto(3, 2);
        assertTrue(p1.compara(p2));
    }


}

