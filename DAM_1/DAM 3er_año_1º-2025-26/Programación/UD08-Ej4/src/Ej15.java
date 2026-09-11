import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
15. Validar una dirección IP. Escribe una expresión regular para validar una
dirección IP en formato IPv4. La dirección debe constar de cuatro números de 0 a 255
separados por puntos.
• “192.168.0.1” es válida
• “256.168.0.1” no es válida
*/
public class Ej15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean correcto;

        String regex = "^(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

        do {
            System.out.print("Voy a validarte la IP: ");
            String ip = scanner.nextLine();


            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(ip);

            if (matcher.find()) {
                System.out.println("IP correcta");
                correcto = true;
            } else {
                System.out.println("Formato incorrecto de IP");
                correcto = false;
            }
        } while (!correcto);
    }
}
