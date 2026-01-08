package Ap3;

public class Coche extends Vehiculo {

    public Coche(String marca, String modelo) {
        super(marca, modelo);
    }

    public String abrirMaletero() {
        return "Maletero abierto";
    }

    @Override
    public String arrancar() {
        return "Brrrrm Brrrrm coche arrancado";
    }
}
