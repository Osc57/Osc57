/*
23. A partir del nombre completo de un fichero obtener:
- path del directorio donde está
- nombre del fichero
- extensión
Por ejemplo:
Nombre completo: /home/dam/Documents/UD05_Ejercicios.pdf
Deberemos obtener:
- path: /home/dam/Documents/
- nombre del fichero: UD05_Ejercicios
- extensión: pdf
*/

import java.util.Scanner;

public class Ej23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dame tu ruta de fichero: ");
        String ruta = scanner.nextLine();

        System.out.println("Nombre completo: " + ruta);
        System.out.println("path: " + ruta.substring(ruta.indexOf(ruta), ruta.lastIndexOf('/') + 1));
        System.out.println("nombre del fichero: " + ruta.substring(ruta.lastIndexOf('/') + 1));
        System.out.println("extensión: " + ruta.substring(ruta.lastIndexOf('.') + 1));

    }
}
