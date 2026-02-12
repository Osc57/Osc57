package Ej4;

/*
4. Escribe un programa que permita crear una lista de palabras y que, a continuación,
pida dos palabras y sustituya la primera por la segunda en la lista.
Ejemplo:
Lista inicial: “monitor”, “keyboard”, “trackpad”, “computer”
Sustituir la palabra:
“trackpad”
Por:
“mouse”
Lista final: “monitor”, “keyboard”, “mouse”, “computer”
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;


public class Ej4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> lista = new ArrayList<>(Arrays.asList("monitor", "keyboard", "trackpad", "computer"));

        System.out.println("Lista inicial: " + lista);

        System.out.print("Sustituir la palabra: ");
        String buscar = sc.nextLine();

        System.out.print("Por: ");
        String reemplazo = sc.nextLine();

        if (lista.contains(buscar)) {
            int indice = lista.indexOf(buscar);
            lista.set(indice, reemplazo);
            System.out.println("Lista final: " + lista);
        } else {
            System.out.println("La palabra '" + buscar + "' no se encuentra en la lista.");
        }

        sc.close();
    }
}


