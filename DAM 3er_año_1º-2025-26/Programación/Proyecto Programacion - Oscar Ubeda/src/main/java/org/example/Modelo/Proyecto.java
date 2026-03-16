package org.example.Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Proyecto {
    private int id;
    private String nombre;
    private double presupuesto;
    private LocalDate fechaInicio;

    private Cliente cliente;
    private List<Version> version;
    private List<Empleados> empleados = new ArrayList<>();

    public Proyecto(int id, String nombre, double presupuesto, LocalDate fechaInicio) {
        this.id = id;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.fechaInicio = fechaInicio;
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

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Version> getVersion() {
        return version;
    }

    public void setVersion(List<Version> version) {
        this.version = version;
    }

    public List<Empleados> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleados> empleados) {
        this.empleados = empleados;
    }
}
