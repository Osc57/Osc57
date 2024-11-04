import java.util.SortedMap;

/**
 * Crea un programa (o clase) java llamado IntArray
 * **/
public class Ej12_IntArray {
    /**
     * a) Codifica una función que genere un array de una longitud dada de
     * enteros aleatorios pertenecientes a un rango dado empezando en un
     * entero mínimo dado.
     *
     * public static int[] createRandom(int length, int min, int bound);
     * **/
    public static int[] createRandom(int lenght, int min, int bound){
        int[] aRandom = new int[lenght];

        for (int i = 0; i < aRandom.length; i++) {
            aRandom[i] = (int) (Math.random() * (bound - min)+min);
        }
        return aRandom;
    }
    /**
     * b) Codifica una función que recorra todos los elementos de un array de
     * enteros y los muestre por consola en una línea.
     *
     * public static void showArray(int[] a);
     * **/
    public static void showArray(int[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
    /**
     * Codifica una función que busque un valor entre los elementos de un
     * array de enteros, el valor de retorno de la función será el primer índice
     * en el que se ha encontrado al número o -1 si no existe en el array.
     *
     * public static int find(int[] a, int search);
     * **/
    public static int find(int[] a, int search){
        for (int i = 0; i < a.length; i++) {
            if (a[i] == search){
                return i;
            }
        }
        return -1;
    }
    /**
     * d) Codifica una función que busque un valor entre los elementos de un
     * array de enteros a partir de un índice dado, el valor de retorno de la
     * función será el primer índice en el que se ha encontrado al número o -
     * 1 si no existe en el array.
     * public static int find(int[] a, int search, int fromIndex);
     * **/
    public static int finD(int[] a, int search, int fromIndex){
        if (fromIndex < 0 || fromIndex >= a.length){
            System.out.println("No existe en el array");
        }
        for (int i = fromIndex; i < a.length; i++) {
            if (a[i] == search){
                return i;
            }
        }
        return -1;
    }

    /**
     * e) Codifica una función que devuelva el mínimo de los datos en el array.
     *
     * public static int getMin(int[] a);
     * **/
    public static int getMin(int[] a){
        return -1;
    }
    public static void main(String[] args) {
        System.out.println("Ejercicio a");
        int [] a = createRandom(10,5,20);
        for (int n : a){
            System.out.print(n + " ");
        }

        System.out.println();
        System.out.println("Ejercicio b");
        int [] b = {7,8,3,2,7,8,1,12};
        showArray(b);

        System.out.println();
        System.out.println("Ejercicio c");
        int [] c = {3,4,5,12,45,67};
        int encontrar = find(c,13);

        if (encontrar != -1){
            System.out.println("Se encuentra en la posicion " + encontrar + " del Array");
        }else {
            System.out.println("No se encuentra en el Array");
        }

        System.out.println("Ejercicio d");
        int [] d = {21,54,66,78,8,9};
        int busca = finD(d,66,2);
        if (busca != -1){
            System.out.println("Esta en la posicion " + busca + " del Array");
        }else {
            System.out.println("Valor no encontrado");
        }
        
        System.out.println("Ejercicio e");



    }
}
