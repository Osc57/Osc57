/*
4. Crea un programa que escriba en pantalla los números del 1 al 10, usando
"while".
*/
public class Ej4 {
    public static void main(String[] args) {

        int contador = 1;

        while (contador <= 10) {
            System.out.print(contador++ + ", ");
        }
    }
}
