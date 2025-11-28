/*
18. Codifica una función que acepte como parámetro una frase y devuelva como
resultado un array de string con las palabras que contiene la frase.
“Hola mundo”  a[0] = “Hola”, a[1] = “mundo”.
*/

public class Ej18 {
    public static String[] devolverPalabras(String p) {
        return p.split(" ");
    }

    public static void main(String[] args) {
        String holaMundo = "Hola mundo";
        String[] palabras = devolverPalabras(holaMundo);

        for (int i = 0; i < palabras.length; i++) {
            System.out.println("a[" + i + "] = " + palabras[i]);
        }
    }
}
