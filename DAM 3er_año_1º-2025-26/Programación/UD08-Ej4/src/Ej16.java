/*
16. Buscar una fecha en formato dd/mm/yyyy. Escribe una expresión regular que
coincida con una fecha en el formato dd/mm/yyyy, donde:
• El día debe de ser 01 a 31
• El mes debe ser de 01 a 12
• El año debe ser un número de 4 dígitos.
*/

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ej16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "^(0[1-9]|1[0-9]|2[0-9]|3[0-1])/(0[1-9]|1[0-2])/\\\\d{4}$";

        System.out.print("Dime una fecha valida con formato (dd/mm/yyyy): ");
        String fecha = scanner.next();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(fecha);

        if (matcher.find()) {
            System.out.println("Fecha valida");
        } else {
            System.out.println("Fecha erronea");
        }

    }
}
