package cuenta;

public class Cuenta {
            //defino dos variables para alojar el número de cuenta y el saldo
        private String numero; //número de la cuenta bancaria
        private float saldo; //saldo de la cuenta bancaria en euros

    public Cuenta(String numCta, float saldoCta){
        numero = numCta;
        saldo = saldoCta;
    }

    public String getNumero(){
        return numero;
    }

    public void setNumero(String numCta){
        this.numero = numCta;
    }

    public float getSaldo(){
        return saldo;
    }

    public void setSaldo(float saldoCta){
        this.saldo = saldoCta;
    }

    public void ingresarDinero(float importe){
        saldo = saldo + importe;
    }

    public void extraerDinero(float importe){
        saldo = saldo - importe;

    }

    public void extraerDinero2(float importe){
        if (saldo-importe < 0) {
            throw new java.lang.ArithmeticException("Saldo Negativo");
        }else
            saldo = saldo - importe;

    }

    public void mostrarCuenta(){
        System.out.println("El número de cuenta es: " + getNumero());
        System.out.println("El saldo es: " + getSaldo() + "€");
    }
    

}
