package Ej5;

/*
5. Escribe un programa que permita crear una lista de palabras y que, a continuación,
pida una palabra al usuario y la elimine de la lista.
Ejemplo:
Lista inicial: “monitor”, “keyboard”, “trackpad”, “computer”
Eliminar la palabra:
“trackpad”
Lista final: “monitor”, “keyboard”, “computer”
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ej5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> lista = new ArrayList<>(Arrays.asList("monitor", "keyboard", "trackpad", "computer"));

        System.out.println("Lista inicial: " + lista);

        System.out.print("Eliminar la palabra: ");
        String eliminar = sc.nextLine();

        if (lista.contains(eliminar)) {
            lista.remove(eliminar);
            System.out.println("Lista final: " + lista);
        } else {
            System.out.println("La palabra '" + eliminar + "' no se encuentra en la lista.");
        }
    }
}
