package Ej1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

    //Email
    public String anadirEmail(String e) {
        listaEmails.add(e);
        return "";
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

        StringBuilder resultado = new StringBuilder();
        for (String l : listaLogins) {
            resultado.append(l).append("\n");
        }
        return resultado.toString().trim();
    }

    //Nombre y Apellido
    public String anadirNombreApe(String nombre, String ape) {
        listaNombreApe.add(nombre);
        listaNombreApe.add(ape);
        return "";
    }
}
