package Ej3;

public class TarjetaCredito extends MetodoPago {
    @Override
    public String procesarPago(double monto) {
        return "Pago realizado via tarjeta de crédito, cantidad de " + monto + "€";
    }
}
