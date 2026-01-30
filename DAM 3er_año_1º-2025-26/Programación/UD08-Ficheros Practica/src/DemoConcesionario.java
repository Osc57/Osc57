import Modelo.*;

import java.util.ArrayList;

public class DemoConcesionario {
    public static void main(String[] args) {
        ArrayList<Vehiculos> listaVehiculos = new ArrayList<>();

        listaVehiculos.add(new Coche("Seat", "Ibiza", 2010, "1221 BBB", 14520, 3, "Gasolina"));
        listaVehiculos.add(new Coche("Seat", "Leon", 2015, "2121 BCB", 12540, 5, "Diesel"));
        listaVehiculos.add(new Motocicleta("Suzuki", "Kitana", 2020, "2112 CCC", 25750, 250, "Gasolina"));
        listaVehiculos.add(new Motocicleta("Yamaha", "K47", 2025, "1212 BBC", 22456, 200, "Gasolina"));
        listaVehiculos.add(new Camion("Mercedes", "2", 2005, "1122 CBC", 75265, 7500, 10));
        listaVehiculos.add(new Camion("Camion", "2", 2025, "2211 CCB", 70457, 7500, 10));

        Concesionario concesionario = new Concesionario(listaVehiculos);

        System.out.println("MOSTRAR VEHÍCULOS");
        concesionario.mostrarVehiculos();

        System.out.println();
        System.out.println("VEHICULO MÁS ANTIGÜO");
        System.out.println(concesionario.vehiculoMasAntiguo());

        System.out.println();
        System.out.println("BUSCAR VEHÍCULO");
        for (Vehiculos v : concesionario.buscarVehiculo("Seat")) System.out.println(v);
    }
}
