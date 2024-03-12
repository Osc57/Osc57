import java.util.Scanner;

public class Ej1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime una frase: ");
        String frase1 = scanner.nextLine().toLowerCase();

        System.out.print("Dime otra frase: ");
        String frase2 = scanner.nextLine().toLowerCase();

        String[] palabras = frase1.split(" ");

        boolean enctrado = false;

        for (String palabra : palabras){
            if (frase2.contains(palabra)){
                System.out.println("La primera palabra es: " + palabra);
                enctrado=true;
                break;
            }
        }
        if (!enctrado){
            System.out.println("No tienen ninguna palabra en común");
        }
    scanner.close();

    }
}
