import java.util.Scanner;

public class Ej1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String vocales = "aeiou";

        System.out.print("Dime una palabra: ");
        String palabra = scanner.nextLine().toLowerCase();

        int contador = 0;
        for (char i : palabra.toCharArray()){
            for (char vocal : vocales.toCharArray()){
                if (vocal == i){
                    contador++;
                }
            }
        }
        System.out.println("Tu plabra " + palabra + " tiene " + contador + " vocales");
        scanner.close();
    }
}
