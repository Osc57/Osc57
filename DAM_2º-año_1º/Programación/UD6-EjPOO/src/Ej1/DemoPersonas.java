package Ej1;

import java.time.LocalDate;
import java.util.ArrayList;

public class DemoPersonas {
    public static void main(String[] args) {
        Persona persona = new Persona("Juan", "Perez", LocalDate.of(1998, 3, 12), "11111111A", 'H');
        Persona persona1 = new Persona("Miguel", "Perez", LocalDate.of(1987, 1, 2), "22222222B", 'H');
        Persona persona2 = new Persona("Lucia", "Gutierrez", LocalDate.of(2001, 7, 1), "33333333C", 'M');
        Persona persona3 = new Persona("Alberto", "Gimenez", LocalDate.of(1965, 12, 12), "44444444D", 'H');
        Persona persona4 = new Persona("Alejandro", "Sanz", LocalDate.of(2002, 8, 29), "55555555E", 'H');

        ArrayList<Persona> personasList = new ArrayList<>();
        personasList.add(persona);
        personasList.add(persona1);
        personasList.add(persona2);
        personasList.add(persona3);
        personasList.add(persona4);

        Personas personas =  new Personas(personasList);
        personas.mostrarPersonas();
        System.out.println("Edad media: " + personas.edadMedia());
        System.out.println(personas.personaMasEdad());

    }
}
