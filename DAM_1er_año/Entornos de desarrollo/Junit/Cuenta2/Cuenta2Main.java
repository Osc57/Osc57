package Cuenta2;

public class Cuenta2Main {
    public static void main(String[] args) {
        Cuenta2 Cuenta2 = new Cuenta2("ES21099865462528660871295", 0);
        Cuenta2.setSaldo(100);
        Cuenta2.ingresarDinero(200);
        System.out.println(Cuenta2.getSaldo());
        Cuenta2.extraerDinero(50);
        Cuenta2.mostrarCuenta();
        Cuenta2.extraerDinero(500);
        Cuenta2.mostrarCuenta();
    }
    
}
