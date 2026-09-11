/**
 *Codifica una función que devuelva una cadena de caracteres con los
 * caracteres en el orden inverso al orden original.
 * “Hola mundo”  “odnum aloH”.
 * **/
public class Ej15 {
    static String cadenaInversa(String cadena){
        String inversa = "";
        for (int i = cadena.length() -1 ; i >= 0; i--) {
            inversa = inversa + cadena.charAt(i);
        }
        return inversa;
    }
    public static void main(String[] args) {
        String holaMundo = "Hola mundo";
        System.out.println(cadenaInversa(holaMundo));
    }
}
