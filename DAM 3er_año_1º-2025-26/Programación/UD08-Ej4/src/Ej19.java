import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
19. Validar contraseñas. Escribe una expresión regular para validar contraseñas que
deben cumplir con los siguientes requisitos:
• Tener al menos 8 caracteres.
• Contener al menos una letra mayúscula.
• Contener al menos un número.
• Contener al menos un carácter especial (@, #, %, etc.).
*/
public class Ej19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean correcto;

        String regex = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[! \"#$%&'()*+,\\-./:;<=>?@^_`{|}]).{8,}$";

        System.out.println("""
                • Tener al menos 8 caracteres.
                • Contener al menos una letra mayúscula.
                • Contener al menos un número.
                • Contener al menos un carácter especial (@, #, %, etc.).""");

        do {
            System.out.print("Dime una contraseña para validar: ");
            String password = scanner.next();

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(password);

            if (matcher.find()) {
                System.out.println("Contraseña correcta");
                correcto = true;
            } else {
                System.out.println("Contraseña no valida");
                correcto = false;
            }

        } while (!correcto);
    }
}
