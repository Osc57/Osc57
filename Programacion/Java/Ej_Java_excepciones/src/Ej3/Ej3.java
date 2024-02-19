package Ej3;

import java.util.Scanner;

public class Ej3 {
    public static void main(String[] args) {
        try{
            lanzaExcepciones();
            lanzaExcepcionesNoVerificadas();
        }catch (MiExcepcionVerificada e){
            System.out.println("Capturamos la excepción");
            e.printStackTrace();
        } catch (MiExcepcionNoVerificada e) {
            System.out.println("Capturamos la excepción");
            e.printStackTrace();
        }

    }

    private static void lanzaExcepcionesNoVerificadas() throws MiExcepcionNoVerificada {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un número que no sea el 6: ");
        int opcion = scanner.nextInt();
        if (opcion == 6){
            throw new MiExcepcionNoVerificada("Esto es una excepción verificáda");
        }
    }

    private static void lanzaExcepciones() throws MiExcepcionVerificada{
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un número que no sea el 5: ");
        int opcion = scanner.nextInt();
        if (opcion == 5){
            throw new MiExcepcionVerificada("Esto es una excepción verificáda");
        }
    }
}
