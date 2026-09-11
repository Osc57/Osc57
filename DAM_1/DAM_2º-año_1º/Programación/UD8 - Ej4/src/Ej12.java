import java.net.SecureCacheResponse;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validación de dirección de correo electrónico. Escribe una expresión regular
 * que valide direcciones de correo electrónico en el formato estándar.
 * • “usuario@dominio.com” -> válido
 * • “usuario@dominio@com” -> no válido
 **/
public class Ej12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce una dirección de correo electrónico: ");
        String correo = scanner.nextLine();

        String regexEmail = "[a-zA-Z0-9._%+-]+@[a-zA-Z.]+\\.[a-zA-Z]{2,}";

        Pattern patternEmail = Pattern.compile(regexEmail);
        Matcher matcherEmail = patternEmail.matcher(correo);

        if (matcherEmail.find()) {
            System.out.println("La dirección de correo es valida");
        } else {
            System.out.println("La dirección de correo no es valida");
        }
    }
}
