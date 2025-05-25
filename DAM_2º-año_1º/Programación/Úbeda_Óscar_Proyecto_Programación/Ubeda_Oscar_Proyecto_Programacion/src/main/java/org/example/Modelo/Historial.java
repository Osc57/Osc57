package org.example.Modelo;

import java.util.Date;

import static org.example.Controlador.ControladorHistorial.obtenerNombreTratamiento;

public class Historial {
    private String dniCliente;
    private int idTratamiento;
    private Date fechaTratamiento;

    public Historial() {
    }

    public Historial(String dniCliente, int idTratamiento, Date fechaTratamiento) {
        this.dniCliente = dniCliente;
        this.idTratamiento = idTratamiento;
        this.fechaTratamiento = fechaTratamiento;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public int getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(int idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public Date getFechaTratamiento() {
        return fechaTratamiento;
    }

    public void setFechaTratamiento(Date fechaTratamiento) {
        this.fechaTratamiento = fechaTratamiento;
    }

    @Override
    public String toString() {
        String nombreTratamiento = obtenerNombreTratamiento(this.idTratamiento);
        return dniCliente + " - " + nombreTratamiento + " - " + fechaTratamiento;
    }
}
