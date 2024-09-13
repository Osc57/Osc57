package Ej3;

public class Diputado extends Legislador {

    public Diputado() {
    }

    @Override
    public String getCamaraEnQueTrabaja() {
        return "Soy un ladrón y mi sede es el Congreso";
    }

    @Override
    public String toString() {
        return "Diputado:" +
                super.getNombre() + '\n' +
                super.getDNI() + '\n' +
                super.getPartidoPolitico() + '\n' +
                super.getProvinciaQueRepresenta() + '\n';
    }
}
