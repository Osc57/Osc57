/**
 * Codifica una función que elimine los espacios en una cadena de caracteres.
 * “Hola mundo”  “Holamundo”
 * **/
public class Ej17 {
    static String eliminarEspacios(String p){
        return p.replaceAll(" ", "");
    }

    public static void main(String[] args) {
        String holaMundo = "Hola mundo";
        System.out.println(eliminarEspacios(holaMundo));
    }
}
