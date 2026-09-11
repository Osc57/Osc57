
/** Esta es la clase de la práctica 2
 *
 * @author Óscar Úbeda
 * @since 14-11-2024
 * @version 1.0
 *
 */
public class F {

    static double getAvg(double[] a) {
        int contador = 0;//Me creo una variable contador para contar los números que hay en el Array
        double suma = 0;//Me creo la variable suma 
        for (int i = 0; i < a.length; i++) {//Recorro el Array
            suma = a[i] + suma;//Sumo los números del Array
            contador++;//El contador sumara 1 por cada número que haya en el Array
        }
        return (double) suma / contador;//Devuelvo la media, la suma dividido por el número de números que hay en el Array
    }

    public static void main(String[] args) {
        double[] h = {17, 24, 31, 43, 50};//Me creo un Array
        System.out.println(getAvg(h));//Llamo al método
    }
}
