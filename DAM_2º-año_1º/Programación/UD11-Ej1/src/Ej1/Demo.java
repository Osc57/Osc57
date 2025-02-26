package Ej1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
    public static void main(String[] args) {
        Registro registro = new Registro();

        String regexFrancia = ".*,(FR),.*";
        String regexEmailYahoo = ".*,\\w+@yahoo.(\\w+.|\\w+),.*";
        String regexLogin = "201[5-7]-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}";
        String regexNombreApe= "^\\d+,A\\w+,.*";


        Pattern patternFrancia = Pattern.compile(regexFrancia);
        Pattern patternEmailYahoo = Pattern.compile(regexEmailYahoo);
        Pattern patternLogin = Pattern.compile(regexLogin);
        Pattern patternNombreApe = Pattern.compile(regexNombreApe);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("DATA.csv"));) {
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {

                String[] columnas = linea.split(",");
                if (columnas.length >= 10) {

                    String login = columnas[columnas.length - 1];
                    Matcher matcherLogin = patternLogin.matcher(login);

                    if (patternFrancia.matcher(linea).matches()) {
                        registro.anadirFrancia(linea);
                    }
                    if (patternEmailYahoo.matcher(linea).matches()) {
                        registro.anadirEmail(linea);
                    }
                    if (matcherLogin.matches()) {
                        registro.anadirLogins(linea);
                    }

                    if (patternNombreApe.matcher(linea).matches()){
                        System.out.println(linea);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Muestro los registros de Francia
        /**
         registro.mostrarFrancia();
         **/

        //Ordeno los emails y los muestro
        /**
         registro.ordenarEmails();
         System.out.println(registro.mostrarEmail());
         **/

        //Ordeno los logins y los muestro
        /**
         registro.ordenarLogins();
         System.out.println(registro.mostrarLogins());
         **/

    }
}
