package Ej1;

import javax.swing.*;
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

        Pattern patternFrancia = Pattern.compile(regexFrancia);
        Pattern patternEmailYahoo = Pattern.compile(regexEmailYahoo);
        Pattern patternLogin = Pattern.compile(regexLogin);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("DATA.csv"));) {
            String linea = null;
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
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        registro.ordenarLogins();
        System.out.println(registro.mostrarLogins());
    }
}
