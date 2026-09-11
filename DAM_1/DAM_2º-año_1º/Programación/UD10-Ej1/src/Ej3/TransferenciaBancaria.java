package Ej3;

public class TransferenciaBancaria extends MetodoPago {

    @Override
    public String procesarPago(double monto) {
        return "Pago realizado mediante una transferencia bancaria: -" + monto + "€";
    }
}
