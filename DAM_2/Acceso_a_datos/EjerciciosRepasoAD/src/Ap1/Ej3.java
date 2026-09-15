package Ap1;

import java.util.ArrayList;
import java.util.Arrays;

public class Ej3 {
    static void main() {
        ArrayList<String> stringArray = new ArrayList<>(Arrays.asList("Hola", "Que tal", "Como estás", "Saludos", "Bonjour", "Hello"));
        ArrayList<String> emptyArray = new ArrayList<>();

        for (String s : stringArray) {
            String palabra = s.replace(" ", "");

            emptyArray.add(palabra);
        }
        System.out.print(longString(emptyArray));
    }

    static String longString(ArrayList<String> list) {
        String maxima = "";

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > maxima.length()) {
                maxima = list.get(i);
            }
        }


        return "La palabra es '" + maxima + "' con " + maxima.length() + " letras";
    }
}
