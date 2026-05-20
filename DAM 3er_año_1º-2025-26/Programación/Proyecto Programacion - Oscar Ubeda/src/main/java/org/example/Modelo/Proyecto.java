package org.example.Modelo;

import java.util.Date;

public class Proyecto {
    private int id;
    private String nombre;
    private String tipo;
    private double presupuesto;
    private Date fechaInicio;
    private boolean finalizado;

    public Proyecto(int id, String nombre, String tipo, double presupuesto, Date fechaInicio, boolean finalizado) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.presupuesto = presupuesto;
        this.fechaInicio = fechaInicio;
        this.finalizado = finalizado;
    }

    public Proyecto(String nombre, String tipo, double presupuesto, Date fechaInicio, boolean finalizado) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.presupuesto = presupuesto;
        this.fechaInicio = fechaInicio;
        this.finalizado = finalizado;
    }

    public boolean getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}
