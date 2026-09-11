import java.util.Scanner;

/**
 * Crea un programa que lea una letra tecleada por el usuario y diga si se trata
 * de un carácter alfabético, una cifra numérica o algún otro carácter.
 * **/
public class Ej3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce un carácter: ");
        String letra = scanner.nextLine();
        
        if (letra.length() != 1) {
            System.out.println("Por favor, introduce solo un carácter.");
        } else {
            char caracter = letra.charAt(0);

            if (Character.isLetter(caracter)) {
                System.out.println("Es un carácter alfabético");
            } else if (Character.isDigit(caracter)) {
                System.out.println("Es un carácter numérico");
            } else {
                System.out.println("Es otro carácter");
            }
        }

        scanner.close();
    }
}
