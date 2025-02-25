package Ej1;

import java.util.ArrayList;

public class Registro {
    private ArrayList<String> listaFrancia = new ArrayList<>();
    private ArrayList<String> listaEmails = new ArrayList<>();
    private ArrayList<String> listaLogins = new ArrayList<>();
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

    public String ordenarLogins() {
        listaLogins.sort((a, b) -> {
            return -1 * a.compareTo(b);
        });
        return "";
    }

    public String mostrarLogins() {
        if (listaLogins.isEmpty()) {
            return "Vacia";
        } else {
            for (String l : listaLogins) {
                return l;
            }
        }
        return "";
    }

    //Nombre y Apellido
    public String anadirNombreApe(String nombre, String ape) {
        listaNombreApe.add(nombre);
        listaNombreApe.add(ape);
        return "";
    }
}
