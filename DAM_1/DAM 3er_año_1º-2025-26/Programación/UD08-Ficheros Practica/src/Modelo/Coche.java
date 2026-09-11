package Modelo;

public class Coche extends Vehiculos {
    private int numeroPuertas;
    private String tipoCombustible;

    public Coche(String marca, String modelo, int anoFabricacion, String matricula, double precio, int numeroPuertas, String tipoCombustible) {
        super(marca, modelo, anoFabricacion, matricula, precio);
        this.numeroPuertas = numeroPuertas;
        this.tipoCombustible = tipoCombustible;
    }

    @Override
    public String descripcion() {
        return super.descripcion() + ", número de puertas " + numeroPuertas + ", tipo de combustible " + tipoCombustible;
    }
}
