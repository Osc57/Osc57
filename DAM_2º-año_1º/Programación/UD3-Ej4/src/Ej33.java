import java.util.Scanner;

/**
 * Realiza un programa que pida introducir un número entero por la consola.
 * Después deberá mostrar la descomposición del número en factores primos.
 * Ejemplo:
 * 24 | 2
 * 12 | 2
 * 6 | 2
 * 3 | 3
 * 1
 * Tips:
 * • Representa el diagrama de flujo de los programas antes de
 * desarrollarlos
 * • El operador módulo % que calcula el resto sirve para evaluar si un
 * número es divisor. El resto de la división es cero si el dividendo es
 * múltiplo del divisor.
 * • Para evaluar los posibles divisores de un número n basta con evaluar
 * divisores hasta n/2, ya que no puede tener divisores mayores que su
 * mitad.
 * **/
public class Ej33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un número: ");
        int n1 = scanner.nextInt();

        for (int i = 2; i <= n1; i++) {
            while(n1%i==0){
                System.out.println(n1 + "|" + i);
                n1=n1/i;
            }
        }
        if(n1>1){
            System.out.println(n1 + "|" + n1);
        }
        System.out.println(1);
        /*if (n1%i==0){
            System.out.println(n1 + "|" + i);
            n1 = n1/i;
            } else if (n1%i!=0) {
                i++;
            }*/
    }
}
