/*
17. Codifica una función que elimine los espacios en una cadena de caracteres.
“Hola mundo”  “Holamundo”
*/

public class Ej17 {
    public static String eliminarEspacios(String p) {
        return p.replaceAll(" ", "");
    }

    public static void main(String[] args) {
        String palabra = "Hola mundo";

        System.out.println(eliminarEspacios(palabra));
    }
}
