import java.util.Scanner;

/**
 * Crea un programa para procesar datos de viviendas; define las siguientes variables
 * enteras precio y superficie y la variable booleana tieneGaraje. El programa deberá
 * pedir al usuario que introduzca los valores para estas tres variables. Declara la variable
 * booleana meInteresa cuyo valor será:
 * • Verdadero. Si el precio es menor a 150.000 €, la superficie es mayor que 80m2
 * y la vivienda tiene garaje.
 * • Falso. En caso contrario.
 * El programa mostrará el valor de meInteresa por consola para visualizar si estamos o
 * no interesados en la vivienda.
 * **/
public class Ej11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean tieneGaraje = false;
        boolean meInteresa = false;

        System.out.print("Dime el precio de la vivienda: ");
        int precio = scanner.nextInt();

        System.out.print("Dime la superficie de la vivienda: ");
        int superficie = scanner.nextInt();

        System.out.print("¿Tiene garaje? true(si)/false(no): ");
        tieneGaraje = scanner.nextBoolean();

        meInteresa = precio < 150000 && superficie > 80 && tieneGaraje;

        System.out.println("¿Me interesa?: " + meInteresa);

    }
}
