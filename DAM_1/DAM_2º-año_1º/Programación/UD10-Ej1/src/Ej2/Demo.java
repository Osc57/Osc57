package Ej2;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        Auto auto1 = new Auto();
        Auto auto2 = new Auto();

        Motocicleta motocicleta1 = new Motocicleta();
        Motocicleta motocicleta2 = new Motocicleta();

        Camion camion1 = new Camion();
        Camion camion2 = new Camion();

        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
        listaVehiculos.add(auto1);
        listaVehiculos.add(auto2);
        listaVehiculos.add(motocicleta1);
        listaVehiculos.add(motocicleta2);
        listaVehiculos.add(camion1);
        listaVehiculos.add(camion2);

        for (Vehiculo v : listaVehiculos){
            System.out.println(v.describirVehiculo());
        }
    }
}
