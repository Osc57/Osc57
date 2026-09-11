package org.example.SerializacionDeserealizacion.Ej3;

public class Configuracion {
    private String tema;
    private String idioma;
    private int volumen;

    public Configuracion() {
    }

    public Configuracion(String tema, String idioma, int volumen) {
        this.tema = tema;
        this.idioma = idioma;
        this.volumen = volumen;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }
}
