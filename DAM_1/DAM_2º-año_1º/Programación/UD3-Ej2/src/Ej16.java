import java.util.Scanner;

/**
 * Conversor pesetas – euros. Modifica el programa de manera que el programa
 * pida una cantidad para convertir a euros, muestre el resultado y vuelva a
 * pedir una cantidad para volver a hacerla conversión. Si se introduce un cero el
 * programa debe parar. El programa debe devolver la cantidad en euros si es
 * positivo, el mensaje de advertencia si es negativo y volver a pedir introducir la
 * información tras la operación. Cuando se introduce un cero la ejecución del
 * programa debe finalizar.
 * **/
public class Ej16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.print("Dime una cantidad de pesetas y pulsa 0 para finalizar: ");
            long pesetas = scanner.nextLong();
            double euros = pesetas/166.368;
            if (pesetas == 0){
                System.out.println("Fin programa");
                break;
            }else if (pesetas < 0){
                System.out.println("El valor introducido debe ser mayor a cero");
            }else {
                System.out.printf("La cantidad de euros es: %.2f €%n",euros);
            }
        }
    }
}
