import java.util.Scanner;

/**
 * Crea un programa que "dibuje" un triángulo creciente, alineado a la derecha,
 * con la altura que indique el usuario. Por ejemplo, si el usuario dice que desea
 * 4 caracteres de alto, el triángulo sería así:
 *  *
 *  **
 *  ***
 *  ****
 * **/
public class Ej30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca la altura del triángulo: ");
        int altura = sc.nextInt();

        for (int i = 1; i <= altura ; i++) {
            for (int j = 1; j <= i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
