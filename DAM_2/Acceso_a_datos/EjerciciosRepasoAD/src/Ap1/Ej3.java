package Ap1;

import java.util.ArrayList;
import java.util.Arrays;

public class Ej3 {
    static void main() {
        ArrayList<String> stringArray = new ArrayList<>(Arrays.asList("Hola", "Que tal", "Como estás", "Saludos", "Bonjour", "Hello"));


        System.out.print(longString(stringArray));
    }

    static String longString(ArrayList<String> list) {
        String maxima = "";

        for (String s : list) {
            int longitudActualSinEspacios = s.replace(" ", "").length();
            int longitudMaximaSinEspacios = maxima.replace(" ", "").length();

            if (longitudActualSinEspacios > longitudMaximaSinEspacios) {
                maxima = s;
            }
        }

        int letrasFinales = maxima.replace(" ", "").length();

        return "La palabra es '" + maxima + "' con " + letrasFinales + " letras";
    }
}
