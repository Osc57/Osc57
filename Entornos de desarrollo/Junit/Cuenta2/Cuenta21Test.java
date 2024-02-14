package Cuenta2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;


public class Cuenta21Test {
    private Cuenta2 cta;

    @BeforeEach
    public void nuevacuenta2(){
        cta = new Cuenta2("ES21099865462528660871295", 0);
    }

    @Test
    void testGetSaldo(){
        float saldo = cta.getSaldo();
        //assertEquals(100, saldo);
        assertEquals(10, saldo, "ojo no va"); //cambio respecto a JUnit4 string al 
        //final
    }

    @Test
    void testSetSaldo(){
        
        cta.setSaldo(20);
        assertEquals(20, cta.getSaldo());
    }

    @Test
    void testIngresarDinero(){
        
        cta.ingresarDinero(400);
        assertEquals(500, cta.getSaldo());
    }

    @Test
    void testExtraerDinero(){
        /*
         * cuenta cuenta1 = new cuenta("ES21099865462528660871295", 100);
         * cuenta1.extraerDinero(20);
         * assertEquals(80, cuenta1.getSaldo());
         */

         try{
           
            cta.extraerDinero(120);
            fail("Error. Se deberia haber lanzado una excepción porque el saldo es negativo");
         }catch(ArithmeticException ae){
            //prueba correcta
         }
    }
}
