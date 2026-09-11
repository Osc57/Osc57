package Ej4;

public class Revista extends Publicacion{
    private int numeroEdicion;

    public Revista(String titulo, String autor, int numeroEdicion) {
        super(titulo, autor);
        this.numeroEdicion = numeroEdicion;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + ", Número de Edición: " + numeroEdicion;
    }
}
