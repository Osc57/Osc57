import java.util.TreeSet;

public class Ej3 {
    public static void main(String[] args) {
        TreeSet<Integer> enteros = new TreeSet<>();

        enteros.add(3);
        enteros.add(1);
        enteros.add(4);
        enteros.add(2);
        enteros.add(3);
        enteros.add(4);
        enteros.add(4);
        enteros.add(5);

        System.out.println(enteros);

        //Elimino un elemento de la lista
        enteros.remove(3);
        System.out.println(enteros); //Elimino el número 3

        //El valor esta presente?
        compruebaSiEstaPresente(enteros);


        System.out.println(enteros.contains(4)); //Compruebo si está el número 4
        System.out.println(enteros.contains(3)); //Compruebo si está el número 3


    }

    private static void compruebaSiEstaPresente(TreeSet<Integer> enteros) {
        int valor = 3;
        if (enteros.contains(3)){
            
            System.out.println("El valor " + valor + " está presente");
        }else
            System.out.println("El valor " + valor + " no está presente");
    }
}
