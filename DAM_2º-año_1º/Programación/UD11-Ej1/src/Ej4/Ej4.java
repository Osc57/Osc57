package Ej4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Escribe un programa que permita crear una lista de palabras y que, a continuación,
 * pida dos palabras y sustituya la primera por la segunda en la lista.
 * Ejemplo:
 * Lista inicial: “monitor”, “keyboard”, “trackpad”, “computer”
 * Sustituir la palabra:
 * “trackpad”
 * Por:
 * “mouse”
 * Lista final: “monitor”, “keyboard”, “mouse”, “computer”
 **/
public class Ej4 {
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
        System.out.print("Dime una frase la cuál quieras cambiar: ");
        String frase = scanner.nextLine().toLowerCase();

        if (listaComponentes.contains(frase)) {
            for (int i = 0; i < listaComponentes.size(); i++) {
                if (frase.equals(listaComponentes.get(i))) {
                    listaComponentes.remove(listaComponentes.get(i));
                    System.out.print("Por cuál la quieres sustituir: ");
                    String sustituto = scanner.nextLine();

                    listaComponentes.add(i, sustituto);
                }
            }
            imprimeLaLista(listaComponentes);
        } else {
            System.out.println("La palabra no esta en la lista");
        }


    }
}
