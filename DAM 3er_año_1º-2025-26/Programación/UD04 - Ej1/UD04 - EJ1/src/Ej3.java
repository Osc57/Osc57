/*
3. Crea una función que calcule un número elevado a otro, usando
multiplicaciones sucesivas.
*/

import java.util.Scanner;

public class Ej3 {
    public static int elevarNumero(int n, int potencia) {
        int resultado = 1;

        if (potencia < 0) {
            return 1;
        } else {
            for (int i = 0; i < potencia; i++) {
                resultado = resultado * n;
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un número: ");
        int n1 = scanner.nextInt();

        System.out.print("A cuanto lo quieres elevar: ");
        int elevar = scanner.nextInt();

        System.out.println("El resultado de elevar " + n1 + " a " + elevar + " es " + elevarNumero(n1, elevar));

    }
}
