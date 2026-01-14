/*
13. Validación de números de teléfono. Crea una expresión regular que valide un
número de teléfono de 10 dígitos en formato 123-456-7890. Los guiones son
obligatorios y deben estar en las posiciones correctas.
• “123-456-7890” -> válido
• “123-45-7890” -> no válido
*/

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ej13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean correcto;

        String regexTelefono = "\\d{3}-\\d{3}-\\d{4}";


        do {
            System.out.print("Dime un número de telefono formato(XXX-XXX-XXXX): ");
            String telefono = scanner.nextLine();


            Pattern pattern = Pattern.compile(regexTelefono);
            Matcher matcher = pattern.matcher(telefono);

            if (matcher.find()) {
                System.out.println("Teléfono correcto");
                correcto = true;
            } else {
                System.out.println("Formato incorrecto");
                correcto = false;
            }
        } while (!correcto);
    }
}
