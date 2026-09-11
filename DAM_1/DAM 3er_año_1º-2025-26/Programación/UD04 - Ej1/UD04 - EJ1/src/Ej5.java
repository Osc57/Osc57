/*
5. Crear una función que reciba una letra y un número, y escriba un "triángulo"
formado por esa letra, que tenga como anchura inicial la que se ha indicado.
Por ejemplo, si la letra es Q y la anchura es 4, debería escribir
QQQQ
QQQ
QQ
Q
*/

import java.util.Scanner;

public class Ej5 {
    /*
    public static String triangulo(char letra, int ancho) {
        String resultado = "";

        for (int i = ancho; i >= 1; i--) {
            String linea = "";
            for (int j = 1; j <= i; j++) {
                linea += letra;
            }
            resultado += linea + "\n";
        }

        return resultado;

    }
    */

    public static String triangulo(char letra, int ancho) {
        StringBuilder resultado = new StringBuilder();

        for (int i = ancho; i >= 1; i--) {
            StringBuilder linea = new StringBuilder();
            linea.append(String.valueOf(letra).repeat(i));
            resultado.append(linea).append("\n");
        }
        return resultado.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime una letra: ");
        String l = scanner.next().toUpperCase();
        char caract = l.charAt(0);

        System.out.print("Dime el ancho de tu piramide: ");
        int a = scanner.nextInt();

        System.out.println(triangulo(caract, a));

    }
}
