/*
7. Crea una función que dada una nota numérica devuelva una nota de forma
textual: Suspenso, Aprobado, Notable y Sobresaliente.
*/

import java.util.Scanner;

public class Ej7 {
    public static String devolverNota(double nota) {
        if (nota >= 0 && nota <= 4) {
            return ("Suspenso");
        } else if (nota >= 5 && nota <= 6) {
            return ("Aprobado");
        } else if (nota >= 7 && nota <= 8) {
            return ("Notable");
        } else if (nota >= 9 && nota <= 10) {
            return ("Sobresaliente");
        } else {
            return ("ERROR:La nota tiene que ser entre 0 y 10");
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime tu nota: ");
        double nota = scanner.nextInt();

        System.out.println(devolverNota(nota));
    }
}
