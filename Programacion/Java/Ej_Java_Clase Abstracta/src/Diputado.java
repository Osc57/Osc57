public class Diputado extends Legislador{
    public Diputado(String nombre, String DNI) {
        super(nombre, DNI);
    }

    public Diputado(String nombre, String DNI, String provinciaQueRepresenta) {
        super(nombre, DNI, provinciaQueRepresenta);
    }

    @Override
    public String getCamaraEnQueTrabaja() {
        return null;
    }

    @Override
    public String getCamaraEnQueTrabaja(String camara) {
        return null;
    }

    @Override
    public String toString() {
        return "Diputado{" +
                "provinciaQueRepresenta='" + provinciaQueRepresenta + '\'' +
                ", nombre='" + nombre + '\'' +
                ", DNI='" + DNI + '\'' +
                ", Camara en la que trabaja=" + getCamaraEnQueTrabaja() +
                '}';
    }
}
