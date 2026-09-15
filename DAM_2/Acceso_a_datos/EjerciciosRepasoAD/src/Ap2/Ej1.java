package Ap2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Ej1. Crear un Set de Strings y añadir elementos a él. Luego, imprimir todos los
elementos del Set. ¿Qué observas acerca del orden de los elementos?
*/

public class Ej1 {
    static void main() {
        Set<String> stringSet = new HashSet<>(Arrays.asList("Hola", "Que tal", "Como estás", "Saludos", "Bonjour", "Hello"));

        System.out.print(stringSet);
    }
}
