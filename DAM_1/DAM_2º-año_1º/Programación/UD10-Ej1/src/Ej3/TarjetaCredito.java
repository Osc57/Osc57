package Ej3;

public class TarjetaCredito extends MetodoPago{

    @Override
    public String procesarPago(double monto) {
        return "Pago realizado por tarjeta de credito: -" + monto + "€";
    }
}
