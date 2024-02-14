import java.util.HashSet;

public class Ej2 {
    public static void main(String[] args) {
        HashSet<Integer> enteros = new HashSet<>();

        enteros.add(1);
        enteros.add(1);
        enteros.add(2);
        enteros.add(3);
        enteros.add(4);
        enteros.add(4);
        enteros.add(5);

        System.out.println(enteros);

        //Elimino elemento
        enteros.remove(3);
        System.out.println(enteros);

        //Compruebo si un valor está presente
        System.out.println(enteros.contains(2));
        System.out.println(enteros.contains(3));

    }
}
