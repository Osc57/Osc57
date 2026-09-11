package Ap3;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();

        listaVehiculos.add(new Coche("Toyota", "Corolla"));
        listaVehiculos.add(new Motocicleta("Honda", "Civic"));
        listaVehiculos.add(new Coche("Ford", "Mustang"));
        listaVehiculos.add(new Motocicleta("Yamaha", "MT-07"));

        for (Vehiculo v : listaVehiculos) {
            System.out.println(v.arrancar());
            if (v instanceof Coche) {
                System.out.println(((Coche) v).abrirMaletero());
            } else if (v instanceof Motocicleta) {
                System.out.println(((Motocicleta) v).hacerCaballito());
            }
        }

    }
}
