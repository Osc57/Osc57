/*
19. Desarrolla un programa que pida al usuario varios números separados por
comas y muestre su suma.
*/

import java.util.Scanner;

public class Ej19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime una serie de números separados por comas (ej: 1,2,3): ");
        String input = scanner.nextLine();

        String[] numerosComoTexto = input.split(",");

        int suma = 0;
        boolean errorDetectado = false;

        for (String numTexto : numerosComoTexto) {
            numTexto = numTexto.trim();

            try {
                int numero = Integer.parseInt(numTexto);
                suma = suma + numero;
            } catch (NumberFormatException e) {
                System.out.println("ERROR: El valor \"" + numTexto + "\" no es un número válido.");
                errorDetectado = true;
                break;
            }
        }

        if (!errorDetectado) {
            System.out.println("La suma total de los números es: " + suma);
        }

        scanner.close();
    }
}

