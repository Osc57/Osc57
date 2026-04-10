package org.example.Modelo;

import java.util.ArrayList;
import java.util.List;

public class Empleados {
    private String dni;
    private String nombre;
    private String email;
    private double salario;

    private Departamento departamento;
    private List<Empleados> subordinados;
    private List<Proyecto> proyectos = new ArrayList<>();

    public Empleados() {
    }

    public Empleados(String dni, String nombre, String email, double salario) {
        this.dni = dni;
        this.nombre = nombre;
        this.email = email;
        this.salario = salario;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
    public List<Empleados> getSubordinados() {
        return subordinados;
    }

    public void setSubordinados(List<Empleados> subordinados) {
        this.subordinados = subordinados;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }
}
