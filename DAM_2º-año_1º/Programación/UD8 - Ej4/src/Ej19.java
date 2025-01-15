import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validar contraseñas. Escribe una expresión regular para validar contraseñas que
 * deben cumplir con los siguientes requisitos:
 * • Tener al menos 8 caracteres.
 * • Contener al menos una letra mayúscula.
 * • Contener al menos un número.
 * • Contener al menos un carácter especial (@, #, %, etc.).
 * **/

public class Ej19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce una contraseña: ");
        String password = scanner.nextLine();

        String regexPasswd = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[! \"#$%&'()*+,\\-./:;<=>?@^_`{|}]).{8,}$";

        Pattern patternPasswd = Pattern.compile(regexPasswd);
        Matcher matcherPasswd = patternPasswd.matcher(password);

        if (matcherPasswd.find()){
            System.out.println("La contraseña es correcta");
        }else {
            System.out.println("La contraseña no es correcta");
        }

    }
}
