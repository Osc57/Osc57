package Modelo;

public class Camion extends Vehiculos {
    private double capacidadCarga;
    private int numeroEjes;

    public Camion(String marca, String modelo, int anoFabricacion, String matricula, double precio, double capacidadCarga, int numeroEjes) {
        super(marca, modelo, anoFabricacion, matricula, precio);
        this.capacidadCarga = capacidadCarga;
        this.numeroEjes = numeroEjes;
    }

    @Override
    public String descripcion() {
        return super.descripcion() + ", capacidad de carga " + capacidadCarga + ", numero de ejes " + numeroEjes;
    }
}
