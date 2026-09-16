package Ap2;

import java.util.*;

public class Ej3 {
    static void main() {
        List<String> stringsArray = new ArrayList<>(Arrays.asList("Hola", "Que tal", "Como estás", "Saludos", "Bonjour", "Hello", "Hola", "Que tal", "Como estás", "Saludos", "Bonjour", "Hello"));
        Set<String> palabrasUnicas = obtenerStringsUnicos(stringsArray);
        System.out.println("Strings únicos: " + palabrasUnicas);
    }

    public static Set<String> obtenerStringsUnicos(List<String> lista) {
        if (lista == null) {
            return new HashSet<>();
        }
        return new HashSet<>(lista);
    }
}
