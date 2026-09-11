package Ej3;

public class Demo {
    public static void main(String[] args) {
        MetodoPago tarjetaCredito = new TarjetaCredito();
        MetodoPago payPal = new PayPal();
        MetodoPago transeferenciaBancaria = new TranseferenciaBancaria();

        System.out.println(tarjetaCredito.procesarPago(700));
        System.out.println(payPal.procesarPago(450));
        System.out.println(transeferenciaBancaria.procesarPago(1500));
    }
}
