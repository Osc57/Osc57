package Ej3;

public class Demo {
    public static void main(String[] args) {

        MetodoPago metodoPago1 = new TarjetaCredito();
        System.out.println(metodoPago1.procesarPago(123));

        MetodoPago metodoPago2 = new PayPal();
        System.out.println(metodoPago2.procesarPago(1567.56));

        MetodoPago metodoPago3 = new TransferenciaBancaria();
        System.out.println(metodoPago3.procesarPago(12000.57));
    }
}
