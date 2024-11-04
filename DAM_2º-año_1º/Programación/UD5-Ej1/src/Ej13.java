import java.util.Scanner;

public class Ej13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] a = {12,4,78,99,65,4};

        System.out.print("Dime un numero: ");
        int search = scanner.nextInt();

        for (int i = 0; i < a.length; i++) {
            if (a[i] == search){
                System.out.println(i);
            }
        }

    }
}
