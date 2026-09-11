package Ej4;

public class Demo {
    public static void main(String[] args) {
        CuentaBancaria cuentaBancaria = new CuentaBancaria("ES6112343456420456323532", "Adolfo Ramizer Gus", 45684);

        System.out.println(cuentaBancaria.depositar(750));
        System.out.println(cuentaBancaria.mostrarSaldo());
        System.out.println("-----------------------------------------------------");
        System.out.println(cuentaBancaria.retirar(750));
        System.out.println("-----------------------------------------------------");
        System.out.println(cuentaBancaria.mostrarSaldo());
    }
}
