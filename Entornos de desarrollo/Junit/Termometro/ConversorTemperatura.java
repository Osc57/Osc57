package Termometro;

import java.util.Scanner;

public class ConversorTemperatura {

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Elija la conversión que desea realizar:");
        System.out.println("1. Celsius a Fahrenheit");
        System.out.println("2. Fahrenheit a Celsius");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.print("Ingrese la temperatura en grados Celsius: ");
                double celsius = scanner.nextDouble();
                double resultadoFahrenheit = celsiusToFahrenheit(celsius);
                System.out.println(
                        celsius + " grados Celsius equivalen a " + resultadoFahrenheit + " grados Fahrenheit.");
                break;
            case 2:
                System.out.print("Ingrese la temperatura en grados Fahrenheit: ");
                double fahrenheit = scanner.nextDouble();
                double resultadoCelsius = fahrenheitToCelsius(fahrenheit);
                System.out.println(
                        fahrenheit + " grados Fahrenheit equivalen a " + resultadoCelsius + " grados Celsius.");
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }

        scanner.close();
    }
}