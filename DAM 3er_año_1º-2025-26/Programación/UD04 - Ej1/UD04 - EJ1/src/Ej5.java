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
    public static void triangulo(char letra, int ancho) {

        for (int i = ancho; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(letra);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime una letra: ");
        String l = scanner.next().toUpperCase();
        char caract = l.charAt(0);

        System.out.print("Dime el ancho de tu piramide: ");
        int a = scanner.nextInt();

        triangulo(caract, a);

    }
}
