import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Crea un programa que genere un array de 10 números aleatorios entre -10 y
 * 10 de manera que no haya elementos repetidos. El programa mostrará los
 * números contenidos en el array.
 * **/
public class Ej11 {
    public static void main(String[] args) {
        int [] aleatorios1 = new int[10];
        int contador = 0;

        while (contador < aleatorios1.length){
            int aleatorios = (int) (Math.random() * 21) - 10;

            int i;
            for (i = 0; i < contador; i++) {
                if (aleatorios1[i] == aleatorios){
                    break;
                }
            }

            if (i == contador){
                aleatorios1[contador] = aleatorios;
                contador++;
            }
        }

        System.out.println("Array donde no hay repetidos: " + Arrays.toString(aleatorios1));
    }
}





