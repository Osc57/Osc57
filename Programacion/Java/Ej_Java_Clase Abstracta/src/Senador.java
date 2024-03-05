public class Senador extends Legislador{

    @Override
    public String getCamaraEnQueTrabaja() {
        return "Yo ni aparezco por el senado";
    }

    @Override
    public String toString() {
        return "Senador{" +
                "provinciaQueRepresenta='" + provinciaQueRepresenta + '\'' +
                ", partidoPolitico='" + partidoPolitico + '\'' +
                ", nombre='" + nombre + '\'' +
                ", DNI='" + DNI + '\'' +
                '}';
    }
}
