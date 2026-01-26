package Ej2;

import java.util.ArrayList;

public class Vehiculo {
    private ArrayList<Vehiculo> listaVehiculo;

    public Vehiculo() {
        listaVehiculo = new ArrayList<>();
    }

    public Vehiculo(ArrayList<Vehiculo> listaVehiculo) {
        this.listaVehiculo = listaVehiculo;
    }

    public String describirVehiculo() {
        return "Hola soy un Vehiculo";
    }
}
