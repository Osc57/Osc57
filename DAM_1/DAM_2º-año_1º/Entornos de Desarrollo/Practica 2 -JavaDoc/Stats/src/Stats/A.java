
/** Esta es la clase de la práctica 2
 *
 * @author Óscar Úbeda
 * @since 14-11-2024
 * @version 1.0
 *
 */
public class A {

    static double[] createArray(int length, double min, double rangeLength) {

        double[] aRandom = new double[length]; //Genero un array con la longitud que me pide el usuario

        for (int i = 0; i < aRandom.length; i++) {
            aRandom[i] = (int) (Math.random() * (rangeLength - min) + min); //Introduzco números aleatorios desde el 
            //número minimo que da el usuario hasta el número final
        }
        return aRandom; //devuelvo el array
    }

    public static void main(String[] args) {
        double[] a = createArray(10, 0, 67); //Le doy el largo del array y de que número hasta que número 
        //de aleatorios lleno el array

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " "); //Muestro los números del array
        }
    }
}
