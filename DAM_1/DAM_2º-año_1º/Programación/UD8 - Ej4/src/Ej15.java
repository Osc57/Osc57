import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validar una dirección IP. Escribe una expresión regular para validar una
 * dirección IP en formato IPv4. La dirección debe constar de cuatro números de 0 a 255
 * separados por puntos.
 * • “192.168.0.1” es válida
 * • “256.168.0.1” no es válida
 * **/
public class Ej15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime una dirección IP: ");
        String direccionIP = scanner.nextLine();

        String regexIP = "^(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

        Pattern patternIP = Pattern.compile(regexIP);
        Matcher matcherIP = patternIP.matcher(direccionIP);

        if (matcherIP.find()){
            System.out.println("La dirección IP es correcta");
        }else {
            System.out.println("La dirección IP no es correcta");
        }
    }
}
