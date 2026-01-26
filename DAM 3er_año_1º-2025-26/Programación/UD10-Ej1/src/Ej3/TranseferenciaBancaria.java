package Ej3;

public class TranseferenciaBancaria extends MetodoPago {
    @Override
    public String procesarPago(double monto) {
        return "Pago realizado via transferencia bancaria, cantidad de " + monto + "€";
    }
}
