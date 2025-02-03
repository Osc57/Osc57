package Ej3;

public abstract class Vehiculo {
    protected String marca;
    protected String modelo;

    public abstract String arrancar();

    public Vehiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }
}
