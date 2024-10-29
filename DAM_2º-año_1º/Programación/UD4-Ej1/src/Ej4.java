import java.util.Scanner;

/**
 * Crear una función "EscribirTablaMultiplicar", que reciba como parámetro un
 * número entero, y escriba la tabla de multiplicar de ese número (por ejemplo,
 * para el 3 deberá llegar desde "3x1=3" hasta "3x10=30").
 * **/
public class Ej4 {
    static void EscribirTablaMultiplicar(int n){
        for (int i = 0; i < 11; i++) {
            int multi = n * i;
            System.out.println(n + "x" + i + "=" + multi);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Que tabla de multiplicar quieres saber: ");
        int num = scanner.nextInt();

        EscribirTablaMultiplicar(num);
    }

}
