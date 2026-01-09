package Ap3;

public class Coche extends Vehiculo {

    public Coche(String marca, String modelo) {
        super(marca, modelo);
    }

    public String abrirMaletero() {
        return "El vehiculo " + super.modelo + super.marca + " ha abierto el maletero";
    }

}
