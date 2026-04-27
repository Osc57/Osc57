package org.example.Modelo;

import java.util.ArrayList;
import java.util.List;

import static org.example.ControladorDAO.DepartamentoDAO.mostrarNombreDepartamento;
import static org.example.ControladorDAO.DepartamentoDAO.obtenerDepartamentos;

public class Empleados {
    private String dni;
    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
    private double salario;

    private int departamento;
    private List<Proyecto> proyectos = new ArrayList<>();

    public Empleados() {
    }

    public Empleados(String dni, String nombre, String apellidos, String email, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.salario = salario;
    }

    public Empleados(String dni, String nombre, String apellidos, String email, String telefono, double salario, int departamento) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.salario = salario;
        this.departamento = departamento;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getDepartamento() {
        return departamento;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }


    public String mostrarEmpleado() {
        return dni + " - " + nombre + " " + apellidos + " - " + departamento;
    }

    @Override
    public String toString() {
        Departamento d = new Departamento();
        d.setId(departamento);
        mostrarNombreDepartamento(d);
        return dni + " - " + nombre + " " + apellidos + " - " + email + " - " + salario + "€" + " - " + d.getNombre();
    }
}
