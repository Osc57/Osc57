package Ap1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ej1 {
    static void main() {
        ArrayList<String> stringsArray = new ArrayList<>(Arrays.asList("Hola", "Que tal", "Como estás", "Saludos", "Bonjour", "Hello"));

        for (String s : stringsArray) {
            System.out.print(s + " ");
        }
    }
}
