package Ej2;

import Ej1.Persona;

import java.time.LocalDate;
import java.util.ArrayList;

public class Alumno extends Persona {
    private String curso;
    private char grupo;
    private ArrayList<String> asignaturas;

    public Alumno(String nombre, String apellidos, LocalDate fNacimiento, String dni, Character sexo) {
        super(nombre, apellidos, fNacimiento, dni, sexo);
    }
}
