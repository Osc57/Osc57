import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int rNum = random.nextInt(100);
        System.out.print("Adivina el número (1-100): ");
        int num = scanner.nextInt();
        int contador = 10;

        while (rNum!=num){
            System.out.println(rNum);

            if (num>rNum){
                System.out.println("El número es menor");
            }else {
                System.out.println("El número es mayor");
            }
            contador = contador-1;
            System.out.println("Te quedan " + contador + " intentos");

            System.out.print("Adivina el número (1-100): ");
            scanner.nextInt();
            if (scanner.nextInt()==rNum){
                System.out.println("Ganastes, adivinastes el número en " + contador);
                break;
            }
            if (contador == 0){
                System.out.println("Has perdido, el número era " + rNum);
               break;
            }

        }




    }
}
