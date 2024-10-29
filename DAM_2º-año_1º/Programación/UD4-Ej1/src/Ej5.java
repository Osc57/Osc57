import java.util.Scanner;

/**
 * Crear una función que reciba una letra y un número, y escriba un "triángulo"
 * formado por esa letra, que tenga como anchura inicial la que se ha indicado.
 * Por ejemplo, si la letra es Q y la anchura es 4, debería escribir
 * QQQQ
 * QQQ
 * QQ
 * Q
 * **/
public class Ej5 {
    static void triangulo(int a){
        for (int i = a; i >= 1 ; i--) {
            for (int j = 1; j <= i ; j++) {
                System.out.print("Q");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime la anchura de la piramide decreciente: ");
        int ancho = scanner.nextInt();

        triangulo(ancho);
    }
}
