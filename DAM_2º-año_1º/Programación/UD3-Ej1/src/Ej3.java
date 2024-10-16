import java.util.Scanner;

/**
 * Crea un programa que lea una letra tecleada por el usuario y diga si se trata
 * de un carácter alfabético, una cifra numérica o algún otro carácter.
 * **/
public class Ej3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce un carácter: ");

        if (scanner.hasNext()){
            if (scanner.hasNextInt()){
                System.out.println("Es un carácter numérico");
            } else if (scanner.hasNextLine()) {
                System.out.println("Es un carácter alfabetico");
                
            }else {
                System.out.println("Es otro carácter");
            }

        }

    }
}
