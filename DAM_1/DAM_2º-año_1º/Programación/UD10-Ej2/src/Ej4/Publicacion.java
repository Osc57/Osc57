package Ej4;

public class Publicacion {
    private String titulo;
    private String autor;

    public Publicacion(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String mostrarInfo() {
        return "Titulo: " + titulo + ", Autor: " + autor;
    }
}
