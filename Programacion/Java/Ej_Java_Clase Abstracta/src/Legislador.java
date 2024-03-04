public abstract class Legislador extends Persona{
    String provinciaQueRepresenta;

    public Legislador(String nombre, String DNI) {
        super(nombre, DNI);
    }

    public Legislador(String nombre, String DNI, String provinciaQueRepresenta) {
        super(nombre, DNI);
        this.provinciaQueRepresenta = provinciaQueRepresenta;
    }

    public  abstract String getCamaraEnQueTrabaja();

    public abstract String getCamaraEnQueTrabaja(String camara);
}
