import java.util.Scanner;

public class Ej8 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el precio de la vivienda: ");
        float precio = scanner.nextFloat();

        System.out.print("Introduce la superficie de la vivienda: ");
        float superficie = scanner.nextFloat();

        System.out.print("Introduce SI tiene garaje (true/false): ");
        boolean garaje = scanner.nextBoolean();

        if (precio<150000 && superficie>80 && garaje){
            System.out.println("Me interesa");
        }else
            System.out.println("No me interesa");

        scanner.close();
    }
}
