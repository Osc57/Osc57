import java.util.Scanner;

/**
 * Codifica un programa que al introducir un día de
 * la semana devuelva la actividad extraexcolar correspondiente. Si el día no
 * tiene ninguna actividad debe devolver esta circunstancia. Si el valor
 * introducido no corresponde a ninguno de los días debe devolver un mensaje
 * de “Valor erróneo”.
 * 1 – lunes        Música
 * 2 – martes       Natación
 * 3 – miércoles    Inglés
 * 4 – jueves       Natación
 * 5 – viernes      -
 * 6 – sábado       Deporte escolar
 * 7 – domingo      -
 * **/
public class Ej2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduceme un día de la semana(1-7): ");

        switch (scanner.nextInt()){
            case 1:
                System.out.println("El lunes tienes música");
                break;
            case 2:
                System.out.println("El martes tienes natación");
                break;
            case 3:
                System.out.println("El miércoles tienes inglés");
                break;
            case 4:
                System.out.println("El jueves tienes natación");
                break;
            case 5:
                System.out.println("El viernes no tienes nada");
                break;
            case 6:
                System.out.println("El sábado tienes deporte escolar");
                break;
            case 7:
                System.out.println("El domingo no tienes nada");
                break;
            default:
                System.out.println("Valor erróneo");
                break;
        }
    }
}
