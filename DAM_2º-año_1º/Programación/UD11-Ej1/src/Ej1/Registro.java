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

    public void ordenarNombreApe(){
        Collections.sort(listaNombreApe);
    }

    public String mostrarNombreApe(){

        if (listaNombreApe.isEmpty()) {
            return "Vacia";
        }

        StringBuilder nombreApe = new StringBuilder();
        for (String nA : listaNombreApe) {
            nombreApe.append(nA).append("\n");
        }
        return nombreApe.toString().trim();}
}
