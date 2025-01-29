package Ej5;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese: ");
        String passw = scanner.nextLine();

        String regexPass = "\\b[A-Z]\\w[0-9].{8,}\\b";

        Pattern pattern = Pattern.compile(regexPass);
        Matcher matcher = pattern.matcher(passw);

        if (matcher.find()){
            System.out.println("si");
        }else {
            System.out.println("no");
        }
    }
}
