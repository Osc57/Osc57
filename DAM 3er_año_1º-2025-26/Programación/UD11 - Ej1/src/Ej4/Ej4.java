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

public class Ej4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> lista = new ArrayList<>();

        System.out.println("Introduce 4 palabras para la lista:");
        for (int i = 0; i < 4; i++) {
            lista.add(sc.next());
        }

        System.out.println("Lista inicial: " + lista);

        System.out.print("\nSustituir la palabra: ");
        String buscar = sc.next();

        System.out.print("Por: ");
        String reemplazo = sc.next();

        if (lista.contains(buscar)) {
            int indice = lista.indexOf(buscar);
            lista.set(indice, reemplazo);
            System.out.println("Lista final: " + lista);
        } else {
            System.out.println("La palabra '" + buscar + "' no existe en la lista.");
        }

        sc.close();
    }
}

