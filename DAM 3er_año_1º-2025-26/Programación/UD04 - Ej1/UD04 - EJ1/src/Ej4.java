/*
4. Crear una función "EscribirTablaMultiplicar", que reciba como parámetro un
número entero, y escriba la tabla de multiplicar de ese número (por ejemplo,
para el 3 deberá llegar desde "3x1=3" hasta "3x10=30").
*/

import java.util.Scanner;

public class Ej4 {
    public static void escribirTablaMultiplicar(int n) {
        for (int i = 0; i <= 10; i++) {
            int resultado = n * i;
            System.out.println(n + " x " + i + " = " + resultado);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Di que tabla de multiplicar quieres: ");
        int n = scanner.nextInt();

        escribirTablaMultiplicar(n);
    }
}
