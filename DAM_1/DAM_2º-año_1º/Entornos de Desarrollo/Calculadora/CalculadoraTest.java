public class CalculadoraTest{

    @Test
    public void testSuma(){
        Calculadora calculadora = new Calculadora(20,10);
        int resultado = calculadora.suma();
    }
}