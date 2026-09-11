package Ej3;

public class Senador extends Legislador {

    @Override
    public String getCamaraEnQueTrabaja() {
        return "Yo ni aparezco por el senado";
    }

    @Override
    public String toString() {
        return "Senador:" +
                super.getNombre() + '\n' +
                super.getDNI() + '\n' +
                super.getPartidoPolitico() + '\n' +
                super.getProvinciaQueRepresenta() + '\n';
    }
}
