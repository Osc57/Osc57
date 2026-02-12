package Ej1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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
    private ArrayList<String> listaFrancia = new ArrayList<>();
    private ArrayList<String> listaEmails = new ArrayList<>();
    private List<String> listaLogins = new ArrayList<>();
    private ArrayList<String> listaNombreApe = new ArrayList<>();

    //Francia
    public String anadirFrancia(String f) {
        listaFrancia.add(f);
        return "";
    }

    public void mostrarFrancia() {
        if (listaEmails.isEmpty()) {
            System.out.println("Vacia");
        } else {
            for (String f : listaFrancia) {
                System.out.println(f);
            }
        }
    }

    //Email
    public String anadirEmail(String e) {
        listaEmails.add(e);
        return "";
    }

    public void ordenarEmails() {
        Collections.sort(listaLogins);
    }

    public String mostrarEmail() {
        if (listaEmails.isEmpty()) {
            return "Vacia";
        }

        StringBuilder email = new StringBuilder();
        for (String e : listaEmails) {
            email.append(e).append("\n");
        }
        return email.toString().trim();
    }

    //Logins
    public String anadirLogins(String l) {
        listaLogins.add(l);
        return "";
    }

    public void ordenarLogins() {
        Collections.sort(listaLogins, Comparator.reverseOrder());
    }

    public String mostrarLogins() {
        if (listaLogins.isEmpty()) {
            return "Vacia";
        }

        StringBuilder login = new StringBuilder();
        for (String l : listaLogins) {
            login.append(l).append("\n");
        }
        return login.toString().trim();
    }

    //Nombre y Apellido
    public String anadirNombreApe(String nombre) {
        listaNombreApe.add(nombre);
        return "";
    }

    public void ordenarNombreApe() {


    }

    public String mostrarNombreApe() {
        if (listaNombreApe.isEmpty()) {
            return "Vacia";
        }

        StringBuilder nombreApe = new StringBuilder();
        for (String nA : listaNombreApe) {
            nombreApe.append(nA).append("\n");
        }
        return nombreApe.toString().trim();
    }
}
