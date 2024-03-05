public class Diputado extends Legislador{

    public Diputado() {
    }

    @Override
    public String getCamaraEnQueTrabaja() {
        return "Soy un ladrón y mi sede es el Congreso";
    }

    @Override
    public String toString() {
        return "Diputado{" +
                "provinciaQueRepresenta='" + provinciaQueRepresenta + '\'' +
                ", partidoPolitico='" + partidoPolitico + '\'' +
                ", nombre='" + nombre + '\'' +
                ", DNI='" + DNI + '\'' +
                '}';
    }
}
