package Ej5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Escribe un programa que permita crear una lista de palabras y que, a continuación,
 * pida una palabra al usuario y la elimine de la lista.
 * Ejemplo:
 * Lista inicial: “monitor”, “keyboard”, “trackpad”, “computer”
 * Eliminar la palabra:
 * “trackpad”
 * Lista final: “monitor”, “keyboard”, “computer”
 **/
public class Ej5 {
    private static void imprimeLaLista(List<String> l) {
        for (String componente : l) {
            System.out.print(componente + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> listaComponentes = new ArrayList<>();

        listaComponentes.add("monitor");
        listaComponentes.add("keyboard");
        listaComponentes.add("trackpad");
        listaComponentes.add("computer");

        imprimeLaLista(listaComponentes);
        System.out.print("Que palabra quieres elminiar de la lista: ");
        String palabra = scanner.nextLine();

        listaComponentes.remove(palabra);

        imprimeLaLista(listaComponentes);
    }
}
