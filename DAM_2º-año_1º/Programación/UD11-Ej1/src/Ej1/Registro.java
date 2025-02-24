package Ej1;

import java.util.ArrayList;

public class Registro {
    private ArrayList<String> listaFrancia = new ArrayList<>();
    private ArrayList<String> listaEmails = new ArrayList<>();
    private ArrayList<String> listaLogins = new ArrayList<>();
    private ArrayList<String> listaNombreApe = new ArrayList<>();

    public ArrayList<String> getListaFrancia() {
        return listaFrancia;
    }

    public void setListaFrancia(ArrayList<String> listaFrancia) {
        this.listaFrancia = listaFrancia;
    }

    public ArrayList<String> getListaEmails() {
        return listaEmails;
    }

    public void setListaEmails(ArrayList<String> listaEmails) {
        this.listaEmails = listaEmails;
    }

    public ArrayList<String> getListaLogins() {
        return listaLogins;
    }

    public void setListaLogins(ArrayList<String> listaLogins) {
        this.listaLogins = listaLogins;
    }

    public ArrayList<String> getListaNombreApe() {
        return listaNombreApe;
    }

    public void setListaNombreApe(ArrayList<String> listaNombreApe) {
        this.listaNombreApe = listaNombreApe;
    }
}
