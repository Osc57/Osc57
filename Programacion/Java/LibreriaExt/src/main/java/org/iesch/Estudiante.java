package org.iesch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.List;

public class Estudiante {

    private String nombre;
    private int edad;
    private List<String> asignaturas;
    private boolean aprobado;


    public Estudiante() {
        this.nombre = nombre;
        this.edad = edad;
        this.asignaturas = asignaturas;
        this.aprobado = aprobado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<String> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<String> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public boolean isAprobado() {
        return aprobado;
    }

    public void setAprobado(boolean aprobado) {
        this.aprobado = aprobado;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", asignaturas=" + asignaturas +
                ", aprobado=" + aprobado +
                '}';
    }

    public static void main(String[] args) {
        ArrayList asignaturas = new ArrayList<>();
        asignaturas.add("Matematicas");
        asignaturas.add("Fisica");
        asignaturas.add("Quimica");

        Estudiante estudiante = new Estudiante();
        estudiante.setNombre("Juan");
        estudiante.setEdad(20);
        estudiante.setAsignaturas(asignaturas);
        estudiante.setAprobado(true);

        System.out.println(estudiante);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(estudiante);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

}
