package Ej2;

public class Auto extends Vehiculo {
    @Override
    public String describirVehiculo() {
        return super.describirVehiculo() + " concretamente un auto";
    }
}
