/*
15. Codifica una función que devuelva una cadena de caracteres con los
caracteres en el orden inverso al orden original.
“Hola mundo”  “odnum aloH”.
*/

public class Ej15 {
    public static String inverso(String p) {
        StringBuilder pInversa = new StringBuilder();
        for (int i = p.length() - 1; i >= 0; i--) {
            pInversa.append(p.charAt(i));
        }
        return pInversa.toString();
    }

    public static void main(String[] args) {
        String palabra = "Hola Mundo";

        System.out.println(inverso(palabra));
    }
}
