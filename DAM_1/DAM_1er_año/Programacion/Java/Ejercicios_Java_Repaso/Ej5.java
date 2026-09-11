import java.util.*;

public class Ej5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> lista = new ArrayList<>();
        lista.add("Perro");
        lista.add("Antonio");
        lista.add("Lucas");
        lista.add("Perro");
        lista.add("Juan");
        lista.add("Iker");

        System.out.print("Que palabra quieres buscar: ");
        String palabra = scanner.next();

        System.out.println("La palabra aparece: " + Collections.frequency(lista, palabra) + " veces");

    }



    }

