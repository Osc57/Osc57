package Ap3;

/*
Ej2. Dada una lista de Strings, escribir una función que devuelva un Map donde
las claves son los Strings únicos de la lista y los valores son el número de veces
que cada String aparece en la lista.
*/

import java.util.*;

public class Ej2 {
    static void main() {
        List<String> stringList = new ArrayList<>(List.of("Hola", "Que tal", "Como estás", "Saludos", "Bonjour", "Hello", "Hola", "Como estás", "Saludos", "Bonjour", "Hello"));
        
        System.out.print(contarFrecuenciaStrings(stringList));

    }

    public static Map<String, Integer> contarFrecuenciaStrings(List<String> lista) {
        Map<String, Integer> frecuenciaMap = new HashMap<>();
        for (String str : lista) {
            frecuenciaMap.put(str, frecuenciaMap.getOrDefault(str, 0) + 1);
        }
        return frecuenciaMap;
    }
}
