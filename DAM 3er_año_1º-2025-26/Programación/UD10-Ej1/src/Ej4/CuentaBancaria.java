package Ej4;

public class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    private double saldo;

    public CuentaBancaria(String numeroCuenta, String titular, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
    }

    public String depositar(double monto) {
        saldo = saldo + monto;
        return "Se ha depositado: " + monto + "€";
    }

    public String retirar(double monto) {
        saldo = saldo - monto;

        return "Se han retirado: " + monto + "€";
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String mostrarSaldo() {
        return "Su saldo es de: " + saldo + "€";
    }
}
