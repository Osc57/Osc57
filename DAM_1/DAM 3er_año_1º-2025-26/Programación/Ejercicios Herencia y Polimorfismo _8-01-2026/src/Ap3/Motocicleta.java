package Ap3;

public class Motocicleta extends Vehiculo {

    public Motocicleta(String marca, String modelo) {
        super(marca, modelo);
    }

    public String hacerCaballito() {
        return "El vehiculo " + super.marca + " " + super.modelo + " ha hecho un caballito";
    }
}
