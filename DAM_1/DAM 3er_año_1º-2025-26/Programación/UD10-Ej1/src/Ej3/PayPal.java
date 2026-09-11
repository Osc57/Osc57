package Ej3;

public class PayPal extends MetodoPago {
    @Override
    public String procesarPago(double monto) {
        return "Pago realizado via Pay Pal, cantidad de " + monto + "€";
    }
}
