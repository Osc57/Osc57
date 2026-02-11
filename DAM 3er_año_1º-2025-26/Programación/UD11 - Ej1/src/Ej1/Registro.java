package Ej1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
Utiliza como fuente de datos el fichero DATA.csv disponible en Moodle (UD08)
para llevar a cabo este ejercicio. Crea la clase Registro que corresponda con la
misma estructura de los registros del fichero DATA.csv. Crea un programa que lea
la información del fichero, cree un registro por cada línea del fichero (excepto la
cabecera) y añada cada registro a una lista. Utilizando los métodos de ordenación y
búsqueda de las listas el programa deberá mostrar:
• Los registros del país Francia (FR).
• Los registros con email de yahoo ordenados por nombre.
• Los registros con el último login entre noviembre de 2015 y enero de 2017
ambos incluidos ordenados por fecha de manera descendente.
• Los nombres y apellidos de los registros cuyo nombre (first_name) empiecen
por ‘A’ ordenados por fecha (descendente) del último inicio de sesión
(last_login).
*/


public class Registro {
    public static boolean verificarFrancia(String pais) {
        String regex = "FR";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(pais);

        return matcher.find();
    }
    
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("DATA.csv"))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                if (verificarFrancia(linea)){
                    System.out.println(linea);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
