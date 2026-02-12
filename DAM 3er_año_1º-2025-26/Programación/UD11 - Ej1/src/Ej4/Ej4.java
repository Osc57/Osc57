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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ej4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Lista inicial predefinida
        ArrayList<String> lista = new ArrayList<>(Arrays.asList("monitor", "keyboard", "trackpad", "computer"));

        System.out.println("Lista inicial: " + lista);

        // 2. Pedir palabras para el cambio
        System.out.println("Sustituir la palabra:");
        String buscar = sc.nextLine();

        System.out.println("Por:");
        String reemplazo = sc.nextLine();

        // 3. Sustitución
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


