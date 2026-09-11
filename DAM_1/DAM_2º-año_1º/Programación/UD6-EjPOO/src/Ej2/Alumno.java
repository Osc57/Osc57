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

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public char getGrupo() {
        return grupo;
    }

    public void setGrupo(char grupo) {
        this.grupo = grupo;
    }

    public ArrayList<String> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(ArrayList<String> asignaturas) {
        this.asignaturas = asignaturas;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "curso='" + curso + '\'' +
                ", grupo=" + grupo +
                ", asignaturas=" + asignaturas +
                '}';
    }
}
