package org.example.SegundaEvaluacion;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ej1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String regex = "([A-Z])";


        System.out.print("Dime una contraseña: ");
        String passw = sc.nextLine();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(passw);

        if (matcher.matches()){
            System.out.print("Contraseña segura");
        }else {
            System.out.print("Las reglas no se cumplen");
        }

    }
}
