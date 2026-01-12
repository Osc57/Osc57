package Ap4;

public class Revista extends Publicacion {
    private int numeroEdicion;


    public Revista(String titulo, String autor) {
        super(titulo, autor);
    }

    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() + " edición número " + numeroEdicion;
    }
}
