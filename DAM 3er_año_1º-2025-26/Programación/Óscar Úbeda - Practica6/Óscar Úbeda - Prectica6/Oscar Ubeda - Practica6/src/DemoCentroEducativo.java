import Modelo.CentroEducativo;
import Modelo.PersonalAdministrativo;
import Modelo.Profesor;
import Modelo.Trabajador;

import java.time.LocalDate;
import java.util.ArrayList;

public class DemoCentroEducativo {
    public static void main(String[] args) {
        ArrayList<Trabajador> listaTrabajadores = new ArrayList<>();

        listaTrabajadores.add(new Profesor("Samuel", "Lopez Varado", "11111111A", LocalDate.of(2001, 8, 14), 1700, "Matematicas", 40));
        listaTrabajadores.add(new Profesor("Santiago", "Varado Lopez", "22222222B", LocalDate.of(2000, 2, 1), 1650, "Geografia", 40));
        listaTrabajadores.add(new PersonalAdministrativo("Julia", "Mesias Delgado", "33333333B", LocalDate.of(2010, 2, 1), 2650, "Jefa de Estudios", 1));
        listaTrabajadores.add(new PersonalAdministrativo("Joaquin", "Miguel Lopez", "44444444B", LocalDate.of(2010, 2, 1), 1750, "Director", 1));

        CentroEducativo centroEducativo = new CentroEducativo(listaTrabajadores);

        System.out.println("MOSTRAR TRABAJADORES");
        centroEducativo.mostrarTrabajadores();

        System.out.println();
        System.out.println("SALARIO MEDIO");
        System.out.println(centroEducativo.salarioMedio());

        System.out.println();
        System.out.println("TRABAJADOR CON MAYOR ANTIGÜEDAD");
        System.out.println(centroEducativo.trabajadorMayorAntiguedad());

        System.out.println();
        System.out.println("LLAMAR METODO TRABAJADOR REFERENCIAS DE TRABAJADOR");
        for (Trabajador t : listaTrabajadores) {
            System.out.println(t.getNombre() + " " + t.getApellidos() + " " + t.trabajar());

        }

        System.out.println();
        System.out.println("BUSCAR TRABAJADOR");
        for (Trabajador t : centroEducativo.buscarTrabajador("Profesor")) System.out.println(t);

    }
}
