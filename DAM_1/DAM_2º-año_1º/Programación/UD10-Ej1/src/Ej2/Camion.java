package Ej2;

public class Camion extends Vehiculo{

    @Override
    public String describirVehiculo() {
        return super.describirVehiculo() + ", que extiende la clase camión";
    }
}
