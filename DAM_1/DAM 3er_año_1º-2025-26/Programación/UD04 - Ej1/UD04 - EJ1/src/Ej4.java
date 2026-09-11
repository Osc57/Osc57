/*
4. Crear una función "EscribirTablaMultiplicar", que reciba como parámetro un
número entero, y escriba la tabla de multiplicar de ese número (por ejemplo,
para el 3 deberá llegar desde "3x1=3" hasta "3x10=30").
*/

import java.util.Scanner;

public class Ej4 {
    /*
    public static String escribirTablaMultiplicar(int n) {
        String tabla = "";

        for (int i = 0; i <= 10; i++) {
            int resultado = n * i;
            tabla = tabla + n + " x " + i + " = " + resultado;

            if (i < 10) {
                tabla = tabla + "\n";
            }
        }
        return tabla;
    }
    */
    public static String escribirTablaMultiplicar(int n) {
        StringBuilder tabla = new StringBuilder();

        for (int i = 0; i <= 10; i++) {
            int resultado = n * i;
            tabla.append(n).append(" x ").append(i).append(" = ").append(resultado);

            if (i < 10) {
                tabla.append("\n");
            }
        }
        return tabla.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Di que tabla de multiplicar quieres: ");
        int n = scanner.nextInt();

        System.out.println(escribirTablaMultiplicar(n));
    }
}
