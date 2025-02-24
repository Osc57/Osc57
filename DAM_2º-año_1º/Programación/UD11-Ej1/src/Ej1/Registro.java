package Ej1;

import java.util.ArrayList;

public class Registro {
    private ArrayList<String> listaFrancia = new ArrayList<>();
    private ArrayList<String> listaEmails = new ArrayList<>();
    private ArrayList<String> listaLogins = new ArrayList<>();
    private ArrayList<String> listaNombreApe = new ArrayList<>();

    public String anadirFrancia(String f){
        listaFrancia.add(f);
        return "";
    }

    public String anadirEmail(String e){
        listaEmails.add(e);
        return "";
    }

    public String anadirLogins(String l){
        listaLogins.add(l);
        return "";
    }

    public String anadirNombreApe(String nombre, String ape){
        listaNombreApe.add(nombre);
        listaNombreApe.add(ape);
        return "";
    }
}
