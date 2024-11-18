import java.util.Scanner;

/**
 * Palíndromo. Resuelve el problema anterior utilizando recursividad de
 * funciones.
 * **/
public class Ej25 {
    static String limpiarPalabra(String p){
        String tildes = "àáâãäåæçèéêëìíîïðñòóôõöøùúûüýÿ";
        String letras = "aaaaaaaceeeeiiiionoooooouuuuyy";
        String palabraLimpia = p;
        for (int i = 0; i < tildes.length(); i++) {
            palabraLimpia = palabraLimpia.replace(tildes.charAt(i), letras.charAt(i));
        }
        return palabraLimpia;
    }
    static String cadenaInversa(String cadena){
        String inversa = "";
        for (int i = cadena.length() -1 ; i >= 0; i--) {
            inversa = inversa + cadena.charAt(i);
        }
        return inversa;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime una palabra para comprobar si es un palindromo: ");
        String palabra = scanner.nextLine().toLowerCase();

        //System.out.println(limpiarPalabra(cadenaInversa(palabra)));
        if (limpiarPalabra(palabra).equals(limpiarPalabra(cadenaInversa(palabra)))){
            System.out.println("La palabra " + palabra + " es un palindromo");
        }else {
            System.out.println("La palabra " + palabra + " no es un palindromo");
        }

    }
}
