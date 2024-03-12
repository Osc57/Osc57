import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ej7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime tu dirección email: ");
        String email = scanner.nextLine();

        Pattern pattern = Pattern.compile("\\b\\w*@\\w*\\.\\w*\\b");
        Matcher matcher = pattern.matcher(email);

        boolean b = matcher.matches();

        if (b == true){
            System.out.println("El correo electrónico es correcto");
        }else {
            System.out.println("El correo electrónico no es correcto");
        }
        scanner.close();
    }
}
