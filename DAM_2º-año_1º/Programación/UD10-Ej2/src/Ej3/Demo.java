package Ej3;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {

        Coche coche1 = new Coche("BMW","R8");
        Coche coche2 = new Coche("Citroën","C5");
        Motocicleta motocicleta1 = new Motocicleta("Yamaha","T30");
        Motocicleta motocicleta2 = new Motocicleta("Suzuki","K3");

        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(coche1);
        vehiculos.add(coche2);
        vehiculos.add(motocicleta1);
        vehiculos.add(motocicleta2);

        for (Vehiculo v : vehiculos){
            System.out.println(v.arrancar());
        }
        System.out.println(coche1.abrirMaletero());
        System.out.println(motocicleta2.hacerCaballito());

    }
}
