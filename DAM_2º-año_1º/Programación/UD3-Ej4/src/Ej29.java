import java.util.Scanner;

/**
 * Crea un programa que "dibuje" un rectángulo hueco, cuyo borde sea una fila
 * (o columna) de asteriscos y cuyo interior esté formado por espacios en
 * blanco, con el ancho y el alto que indique el usuario. Por ejemplo, si desea
 * anchura 4 y altura 3, el rectángulo sería así:
 *  ****
 *  *  *
 *  ****
 * **/
public class Ej29 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime la altura de el rectángulo hueco: ");
        int altura = scanner.nextInt();

        for (int i = 1; i <= altura; i++) {
            for (int j = 1; j <= altura ; j++) {
                if (i == 1 || i == altura || j == 1 || j == altura){
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }
}
