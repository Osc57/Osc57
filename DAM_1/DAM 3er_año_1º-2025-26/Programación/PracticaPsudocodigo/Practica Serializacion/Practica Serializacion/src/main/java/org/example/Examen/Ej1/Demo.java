package org.example.Examen.Ej1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        ArrayList<Registro> registros = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("DATA.csv"))) {
            String linea;
            br.readLine();

            while ((linea = br.readLine()) != null) {
                String[] lista = linea.split(",");
                Registro registro = new Registro(lista);
                registros.add(registro);

            }

            System.out.println("REGISTROS PORTUGAL");
            for (Registro r : registros) {
                if (r.getCountry().equalsIgnoreCase("PT")) {
                    System.out.println(r);
                }
            }

            System.out.println();
            System.out.println("REGISTROS YAHOO");
            for (Registro r : registros) {
                if (r.getEmail().contains("@yahoo")) {
                    System.out.println(r);
                }
            }

            System.out.println("==========================================================================================================================");
            System.out.println("REGISTROS ENTRE AGOSTO Y MARZO 2015 - 2017");

            registros.sort((a, b) ->
                    b.getFechaLogin().compareTo(a.getFechaLogin()));

            for (Registro r : registros) {
                LocalDate f = r.getFechaLogin();
                int year = f.getYear();
                int month = f.getMonthValue();

                if (year >= 2015 && year <= 2017) {

                    //Agosto diciembre
                    boolean parte1 = (month >= 8 && month <= 12);

                    //Enero marzo
                    boolean parte2 = (month >= 1 && month <= 3);

                    if (parte1 || parte2) {
                        System.out.println(r);
                    }
                }


            }

            System.out.println();
            System.out.println("NOMBRE QUE EMPIECE POR A");

            registros.sort((a, b) ->
                    a.getFirst_name().compareTo(b.getFirst_name()));

            for (Registro r : registros) {
                if (r.getFirst_name().startsWith("A")) {
                    System.out.println(r);
                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
