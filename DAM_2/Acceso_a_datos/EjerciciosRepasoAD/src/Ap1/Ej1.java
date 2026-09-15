package Ap1;

import java.util.ArrayList;
import java.util.Arrays;

/*
Ej1. Crear una lista de Strings y añadir elementos a ella. Luego, imprimir todos
los elementos de la lista usando un bucle for-each.
*/

public class Ej1 {
    static void main() {
        ArrayList<String> stringsArray = new ArrayList<>(Arrays.asList("Hola", "Que tal", "Como estás", "Saludos", "Bonjour", "Hello"));

        for (String s : stringsArray) {
            System.out.print(s + " ");
        }
    }
}
