package Ap4;

public class Libro extends Publicacion {
    private int numeroPaginas;

    public Libro(String titulo, String autor) {
        super(titulo, autor);
    }

    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() + " tiene " + numeroPaginas + " páginas";
    }
}
