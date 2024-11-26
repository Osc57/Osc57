package Ej1;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona("Gustavo");
        Persona persona1 = new Persona("Óscar", LocalDate.of(2003,11,22));
        Persona persona2 = new Persona("Óscar","Úbeda Fernández", LocalDate.of(2003,11,22),"11111111A",'M');

        System.out.println(persona.Saludar());
        System.out.println(persona1.CalcularEdad());
        System.out.println(persona2.toString());
    }
}
