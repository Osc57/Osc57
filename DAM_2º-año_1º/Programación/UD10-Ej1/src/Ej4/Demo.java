package Ej4;

public class Demo {
    public static void main(String[] args) {
        CuentaBancaria cuentaBancaria1 = new CuentaBancaria();

        System.out.println(cuentaBancaria1.mostrarSaldo());
        System.out.println(cuentaBancaria1.depositar(17000));
        System.out.println(cuentaBancaria1.mostrarSaldo());
        System.out.println(cuentaBancaria1.retirar(570));
        System.out.println(cuentaBancaria1.mostrarSaldo());
        System.out.println(cuentaBancaria1.retirar(16440));
        System.out.println(cuentaBancaria1.mostrarSaldo());
    }
}
