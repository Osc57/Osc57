package Modelo;

public class Motocicleta extends Vehiculos {
    private int cilindrada;
    private String tipoMotor;

    public Motocicleta(String marca, String modelo, int anoFabricacion, String matricula, double precio, int cilindrada, String tipoMotor) {
        super(marca, modelo, anoFabricacion, matricula, precio);
        this.cilindrada = cilindrada;
        this.tipoMotor = tipoMotor;
    }

    @Override
    public String descripcion() {
        return super.descripcion() + ", cilindrada " + cilindrada + " tipo de motor " + tipoMotor;
    }
}
