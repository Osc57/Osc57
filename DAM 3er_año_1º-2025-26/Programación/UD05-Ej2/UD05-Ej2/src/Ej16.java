/*
16. Codifica una función que dado un número entero devuelva un número entero
“dado la vuelta”, es decir con las cifras en orden inverso, pero sin modificar el
signo:
125  521, -26  -62.
*/

public class Ej16 {
    public static int inverso(int n) {
        int signo = n < 0 ? -1 : 1;
        long valorAbsoluto = Math.abs((long) n);
        long invertidoAbsoluto = 0;

        while (valorAbsoluto > 0) {
            invertidoAbsoluto = invertidoAbsoluto * 10 + valorAbsoluto % 10;
            valorAbsoluto /= 10;
        }

        return (int) invertidoAbsoluto * signo;
    }

    public static void main(String[] args) {
        int numero = 125;
        int numero2 = -26;

        System.out.println(inverso(numero) + " " + inverso(numero2));
    }
}
