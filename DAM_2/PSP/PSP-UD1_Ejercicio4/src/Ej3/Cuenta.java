package Ej3;

import java.util.Random;

public class Cuenta {
    private double saldo;
    private final Random random = new Random();

    public Cuenta(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void ingresarDinero(double saldo) {

        try {
            Thread.sleep(random.nextInt(401) + 100);
        } catch (InterruptedException e) {

        }

        double saldoAnterior = this.saldo;
        double saldoPosterior = saldoAnterior + saldo;
        this.saldo = saldoPosterior;

        imprimirOperacion("Ingreso", saldo, saldoAnterior, saldoPosterior);
    }

    public void retirarDinero(double saldo) {

        try {
            Thread.sleep(random.nextInt(401) + 100);
        } catch (InterruptedException e) {

        }

        double saldoAnterior = this.saldo;
        double saldoPosterior = saldoAnterior - saldo;
        this.saldo = saldoPosterior;

        imprimirOperacion("Retirada", saldo, saldoAnterior, saldoPosterior);
    }

    private void imprimirOperacion(String tipo, double cantidad, double anterior, double posterior) {
        System.out.println("[" + Thread.currentThread().getName() + "] " + tipo + ": " + cantidad + " €\n" +
                "  Saldo anterior: " + anterior + " €\n" +
                "  Saldo posterior: " + posterior + " €");
    }
}
