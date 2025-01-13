import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validación de números de teléfono. Crea una expresión regular que valide un
 * número de teléfono de 10 dígitos en formato 123-456-7890. Los guiones son
 * obligatorios y deben estar en las posiciones correctas.
 * • “123-456-7890” -> válido
 * • “123-45-7890” -> no válido
 * **/
public class Ej13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce un número de teléfono: ");
        String tlfno = scanner.nextLine();

        String regexTelefono = "\\d{3}-\\d{3}-\\d{4}$";

        Pattern patternTlfno = Pattern.compile(regexTelefono);
        Matcher matcherTlfno = patternTlfno.matcher(tlfno);

        if (matcherTlfno.find()){
            System.out.println("El teléfono es valido");
        }else {
            System.out.println("El teléfono no es valido");
        }
    }
}
