package Ej2;

public class Motocicleta extends Vehiculo{

    @Override
    public String describirVehiculo() {
        return super.describirVehiculo() + ", que extiende la clase motocicleta";
    }
}
