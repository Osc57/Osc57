public class Senador extends Legislador{
    public Senador(String nombre, String DNI) {
        super(nombre, DNI);
    }

    public Senador(String nombre, String DNI, String provinciaQueRepresenta) {
        super(nombre, DNI, provinciaQueRepresenta);
    }

    @Override
    public String getCamaraEnQueTrabaja() {
        return null;
    }

    @Override
    public String toString() {
        return "Senador{" +
                "provinciaQueRepresenta='" + provinciaQueRepresenta + '\'' +
                ", nombre='" + nombre + '\'' +
                ", DNI='" + DNI + '\'' +
                '}';
    }
}
