import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Buscar una fecha en formato dd/mm/yyyy. Escribe una expresión regular que
 * coincida con una fecha en el formato dd/mm/yyyy, donde:
 * • El día debe se de 01 a 31
 * • El mes debe ser de 01 a 12
 * • El año debe ser un número de 4 dígitos.
 * **/
public class Ej16 {
    public static boolean fechaValida(String f){
        String regexFecha = "^(0[1-9]|1[0-9]|2[0-9]|3[0-1])/(0[1-9]| 1[0-2])/\\d{4}$";

        Pattern patternFecha = Pattern.compile(regexFecha);
        Matcher matcherFecha = patternFecha.matcher(f);

        return matcherFecha.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime una fecha en formato dd/mm/yyyy: ");
        String fecha = scanner.nextLine();

        if (fechaValida(fecha)){
            System.out.println("La fecha es correcta");
        }else {
            System.out.println("La fecha es incorrecta");
        }
    }
}
