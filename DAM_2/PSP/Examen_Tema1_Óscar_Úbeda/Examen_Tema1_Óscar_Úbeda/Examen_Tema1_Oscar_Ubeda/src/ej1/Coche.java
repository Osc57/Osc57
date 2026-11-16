package ej1;

public class Coche {

    private String nombre;
    private Puesto puesto;

    public Coche(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
