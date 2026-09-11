/*
12. Validación de dirección de correo electrónico. Escribe una expresión regular
que valide direcciones de correo electrónico en el formato estándar.
• “usuario@dominio.com” -> válido
• “usuario@dominio@com” -> no válido
*/

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ej12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean correcto;
        String regexCorreo = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        
        do {
            System.out.print("Dime un correo electronico: ");
            String correo = scanner.nextLine();

            Pattern pattern = Pattern.compile(regexCorreo);
            Matcher matcher = pattern.matcher(correo);

            if (matcher.find()) {
                System.out.print("El correo es correcto");
                correcto = true;
            } else {
                System.out.println("Introduce un correo valido");
                correcto = false;
            }

        } while (!correcto);
    }
}
