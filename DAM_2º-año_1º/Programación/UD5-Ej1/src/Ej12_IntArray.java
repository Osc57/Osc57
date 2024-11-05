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
     * c) Codifica una función que busque un valor entre los elementos de un
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
        int menor = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] < menor){
                menor = a[i];
            }
        }
        return menor;
    }

    /**
     * f) Codifica una función que devuelva el máximo de los datos en el array.
     *
     * public static int getMax(int[] a);
     * **/
    public static int getMax(int[] a){
        int mayor = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > mayor){
                mayor = a[i];
            }
        }
        return mayor;
    }
    /**
     * g) Codifica una función que devuelva la suma de los datos en el array.
     *
     * public static int getSum(int[] a);
     * **/
    public static int getSum(int[] a){
        int suma = 0;
        for (int i = 0; i < a.length; i++) {
            suma = a[i] + suma;
        }
        return suma;
    }

    /**
     * h) Codifica una función que devuelva la media aritmética de los datos en
     * el array.
     * public static double getAvg(int[] a);
     * **/
    public static double getAvg(int[] a){
        int contador = 0;
        int suma = 0;
        for (int i = 0; i < a.length; i++) {
            suma = a[i] + suma;
            contador++;
        }
        return (double) suma /contador;

    }

    /**
     * i) Si queremos obtener los datos que devuelven las funciones anteriores
     * estamos recorriendo el array 4 veces. Esto no es un problema para
     * pocos valores, pero sería un desperdicio de tiempo para arrays con
     * muchos datos. Codifica una función que reciba un array de tipo int y
     * devuelva otro array de longitud 4 y tipo double con los siguientes
     * valores y en ese orden: suma, media, mínimo, máximo.
     *
     * double[] getStats(double[] a);
     * **/
    static double[] getStats(int [] a){
        double [] valores = new double[4];

        valores[0] = getSum(a);
        valores[1] = getAvg(a);
        valores[2] = getMin(a);
        valores [3] = getMax(a);

        return valores;
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
        int encontrar = find(c,4);

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
        int [] e = {33,45,120,77,49,12};
        int min = getMin(e);
        System.out.println("El número menor del Array es: " + min);

        System.out.println("Ejercicio f");
        int [] f = {33,45,120,77,49,12};
        int max = getMax(f);
        System.out.println("El número menor del Array es: " + max);

        System.out.println("Ejercicio g");
        int [] g = {10,2,31,14};
        int sum = getSum(g);
        System.out.println("La suma de los números en el Array es: " + sum);

        System.out.println("Ejercicio h");
        int [] h = {17,24,31,43,50};
        double media = getAvg(h);
        System.out.println("La media de los números del Array es: " + media);

        System.out.println("Ejercicio i");
        int [] i = {17,45,32,66,54};
        double[] estadisticas = getStats(i);

        for (double n : estadisticas){
            System.out.print(n + " ");
        }



    }
}
