package org.example.Modelo;

import static org.example.Controlador.ControladorHistorial.obtenerNombreTratamiento;

public class Cita {
    private int id;
    private String fechaCita;
    private String dniCliente;
    private int idTratamiento;

    public Cita() {
    }

    public Cita(int id, String fechaCita, String dniCliente, int idTratamiento) {
        this.id = id;
        this.fechaCita = fechaCita;
        this.dniCliente = dniCliente;
        this.idTratamiento = idTratamiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public int getIdTratamineto() {
        return idTratamiento;
    }

    public void setIdTratamineto(int idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    @Override
    public String toString() {
        String nombreTratamiento = obtenerNombreTratamiento(this.idTratamiento);
        return dniCliente + " - "  + nombreTratamiento + fechaCita;
    }
}
