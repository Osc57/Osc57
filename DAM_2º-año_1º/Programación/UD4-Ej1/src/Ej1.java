import java.util.Scanner;

/**
 * Crear una función llamada "signo", que reciba un número real, y devuelva un
 * número entero con el valor: -1 si el número es negativo, 1 si es positivo o 0 si
 * es cero.
 * **/
public class Ej1 {
   static void signo(float n){
       if (n < 0){
           System.out.println(-1);
       } else if (n > 0) {
           System.out.println(1);
       }else {
           System.out.println(0);
       }

   }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un número real: ");
        float num = scanner.nextFloat();

        signo(num);
    }
}
