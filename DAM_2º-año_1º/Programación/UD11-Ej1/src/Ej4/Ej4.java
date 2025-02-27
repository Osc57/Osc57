package Ej4;

import java.util.ArrayList;
import java.util.List;

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
 * **/
public class Ej4 {
    private static void imprimeLaLista(List<String> l) {
        for (String componente : l){
            System.out.print(componente + ", ");
        }
        System.out.println("\n");
    }
    public static void main(String[] args) {
        List<String> listaComponentes = new ArrayList<>();

        listaComponentes.add("monitor");
        listaComponentes.add("keyboard");
        listaComponentes.add("trackpad");
        listaComponentes.add("computer");

        imprimeLaLista(listaComponentes);

        listaComponentes.set(2,"mouse");

        imprimeLaLista(listaComponentes);


    }
}
