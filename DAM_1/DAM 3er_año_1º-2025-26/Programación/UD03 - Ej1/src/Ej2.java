/*
2. Actividades extraexcolares. Codifica un programa que al introducir un día de
la semana devuelva la actividad extraexcolar correspondiente. Si el día no
tiene ninguna actividad debe devolver esta circunstancia. Si el valor
introducido no corresponde a ninguno de los días debe devolver un mensaje
de “Valor erróneo”.
    1 – lunes Música
    2 – martes Natación
    3 – miércoles Inglés
    4 – jueves Natación
    5 – viernes -
    6 – sábado Deporte escolar
    7 – domingo -
*/

import java.util.Scanner;

public class Ej2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un día de la semana (1-7): ");

        switch (scanner.nextInt()) {
            case 1:
                System.out.println("Lunes: Tienes Música");
                break;
            case 2:
                System.out.println("Martes: Tienes Natación");
                break;
            case 3:
                System.out.println("Miércoles: Tienes Inglés");
                break;
            case 4:
                System.out.println("Jueves: Tienes Natación");
                break;
            case 5:
                System.out.println("Viernes: No tienes nada");
                break;
            case 6:
                System.out.println("Sábado: Tienes Deporte Escolar");
                break;
            case 7:
                System.out.println("Domingo: No tienes nada");
                break;
            default:
                System.out.println("ERROR: Valor no igualitario al rango");
                break;
        }
    }
}
