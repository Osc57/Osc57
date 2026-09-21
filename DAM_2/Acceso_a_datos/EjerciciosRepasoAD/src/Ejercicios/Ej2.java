package Ejercicios;


/*
2) Imprimir todos los elementos de una lista: Crea una lista de cadenas. Utiliza un
“Consumer” para imprimir cada cadena en la lista.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Ej2 {
    static void main() {
        List<String> stringsArray = new ArrayList<>(Arrays.asList("Hola", "Que tal", "Como estás", "Saludos", "Bonjour", "Hello"));

        Consumer<String> imprimir = System.out::println;

        imprimir.accept(String.valueOf(stringsArray));
    }
}
