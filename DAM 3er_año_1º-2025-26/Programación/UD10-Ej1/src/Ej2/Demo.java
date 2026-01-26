package Ej2;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();

        listaVehiculos.add(new Auto());
        listaVehiculos.add(new Motocicleta());
        listaVehiculos.add(new Camion());

        for (Vehiculo v : listaVehiculos) {
            System.out.println(v.describirVehiculo());
        }


    }
}
