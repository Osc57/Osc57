package org.example.Modelo;

import java.time.LocalDate;

public class Version {
    private int numeroVersion;
    private LocalDate fecha;
    private String descripcion;

    private Proyecto proyecto;

    public Version(int numeroVersion, LocalDate fecha, String descripcion) {
        this.numeroVersion = numeroVersion;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public int getNumeroVersion() {
        return numeroVersion;
    }

    public void setNumeroVersion(int numeroVersion) {
        this.numeroVersion = numeroVersion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
}
