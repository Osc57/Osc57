
/** Esta es la clase de la práctica 2
 *
 * @author Óscar Úbeda
 * @since 14-11-2024
 * @version 1.0
 *
 */
public class E {

    static double getSum(double[] a) {
        double suma = 0;//Me creo una variable suma para almacenar la suma de los números
        for (int i = 0; i < a.length; i++) {//Recorro el Array 
            suma = a[i] + suma;//Sumo cada número que el Array tenga
        }
        return suma;//Devuelvo la suma 
    }

    public static void main(String[] args) {
        double[] e = {12, 54, 234, 23, 32, 1, 20};//Me creo un Array con números
        System.out.println(getSum(e));//Llamo al método
    }
}
