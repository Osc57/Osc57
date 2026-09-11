import java.util.ArrayList;
import java.util.Scanner;

import java.util.Scanner;

public class Ej4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String j1, j2;


            System.out.println("Juguemos a piedra papel o tijera");
            System.out.print("Dime tu nombre jugador 1: ");
            j1 = scanner.next();

            System.out.print("Dime tu nombre jugador 2: ");
            j2 = scanner.next();

            System.out.println("Hola " + j1 + " y " + j2);
            System.out.println("Vamos a jugar");

            System.out.print("J1: Selecciona (piedra, papel o tijera): ");
            String seleccion1 = scanner.next();

            System.out.print("J2: Selecciona (piedra, papel o tijera): ");
            String seleccion2 = scanner.next();

            if (!seleccion1.equals("piedra") && !seleccion1.equals("papel") && !seleccion1.equals("tijera")){
                System.out.println("Introduce datos validos");

            } else if (!seleccion2.equals("piedra") && !seleccion2.equals("papel") && !seleccion2.equals("tijera")) {
                System.out.println("Introduce datos validos");
            }

        if ((seleccion1.equals("piedra") && (seleccion2.equals("papel")))) {
                System.out.println("Ha ganado: " + j2 + ". Felicidades!");

            } else if ((seleccion1.equals("papel") && (seleccion2.equals("tijera")))) {
                System.out.println("Ha ganado: " + j2 + ". Felicidades!");

            } else if ((seleccion1.equals("tijera") && (seleccion2.equals("piedra")))) {
                System.out.println("Ha ganado: " + j2 + ". Felicidades!");

            } else if ((seleccion1.equals("piedra") && seleccion2.equals("tijeras"))) {
                System.out.println("Ha ganado: " + j1 + ". Felicidades!");

            } else if ((seleccion1.equals("tijera") && (seleccion2.equals("papel")))) {
                System.out.println("Ha ganado: " + j1 + ". Felicidades!");

            } else if ((seleccion1.equals("papel")) && (seleccion2.equals("piedra"))) {
                System.out.println("Ha ganado: " + j1 + ". Felicidades!");

            } else if ((seleccion1.equals(seleccion2))) {
                System.out.println("Hay un empate");

            }else
                System.out.println("Metierón los datos mal, vuelvan a meterlos");

    }
}

