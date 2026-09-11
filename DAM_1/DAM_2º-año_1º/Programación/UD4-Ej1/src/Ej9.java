import java.util.Scanner;

/**
 * Crea una función que realice una cuenta atrás partiendo de un número entero
 * recibido como parámetro y utilizando recursividad.
 * **/
public class Ej9 {
    static void cuentaAtras(int n1){
        if (n1 < 0){
            System.out.println("Fin cuenta atras");
            return;
        }
        System.out.println(n1);
        cuentaAtras(n1-1);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un número para hacer la cuenta atras: ");
        int num1 = scanner.nextInt();

        cuentaAtras(num1);
    }
}
