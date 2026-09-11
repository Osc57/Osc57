package Ap4;

public class Publicacion {
    protected String titulo;
    protected String autor;

    public Publicacion(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String mostrarInformacion() {
        return "El libro " + titulo + " fue escrito por " + autor;
    }
}
