package org.iesch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.runtime.ObjectMethods;
import java.nio.file.Path;
import java.nio.file.Paths;
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
/*
        System.out.println(estudiante);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(estudiante);
            System.out.println(json);

            //File file = new File("texto.json");
            //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            //bufferedWriter.write(json);
            //bufferedWriter.close();

            objectMapper.writeValue(Paths.get("estudiante.json").toFile(), estudiante);

            File file = new File("estudianteFichero.json");
            objectMapper.writeValue(file, estudiante);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
*/

        //Deserializar
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Estudiante estudiante1 = objectMapper.readValue(new File("estudiante.json"), Estudiante.class);
            System.out.println(estudiante1);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
