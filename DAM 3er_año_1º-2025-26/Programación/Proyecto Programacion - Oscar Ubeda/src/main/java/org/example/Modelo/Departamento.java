package org.example.Modelo;

public class Departamento {
    private int id;
    private String nombre;
    private String ubicacion;

    public Departamento() {
    }

    public Departamento(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public Departamento(String nombre) {
        this.nombre = nombre;
    }

    public Departamento(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }


    public String mostrarDepartamento() {
        return nombre + " - " + ubicacion;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
