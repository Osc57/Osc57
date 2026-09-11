import java.util.Scanner;

/**
 * Desarrolla un programa que pida al usuario introducir una frase de manera
 * indefinida. Una vez introducida el programa mostrará el número total de
 * veces que aparece la letra ‘s’ (independientemente de que sean mayúsculas y
 * minúsculas). El programa debe finalizar cuando el usuario introduzca
 * únicamente un punto (., ASCII 46).
 **/
public class Ej2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime una frase indefinida: ");
        String frase = scanner.nextLine().toLowerCase();

        int contador = 0;

        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == 's') {
                contador++;
            } else {
                if (frase.charAt(i) == '.') {
                    System.out.println("Números de 's' antes del punto: " + contador);
                } else {
                    System.out.println("La letra s aparece " + contador + " vez/ces");
                }
            }
        }

    }
}
