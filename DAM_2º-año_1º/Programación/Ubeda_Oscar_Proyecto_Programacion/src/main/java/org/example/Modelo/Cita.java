package org.example.Modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.example.Controlador.ControladorHistorial.obtenerNombreTratamiento;

public class Cita {
    private int id;
    private LocalDateTime fechaCita;
    private String dniCliente;
    private int idTratamiento;

    public Cita() {
    }

    public Cita(int id, LocalDateTime fechaCita, String dniCliente, int idTratamiento) {
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

    public LocalDateTime getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(LocalDateTime fechaCita) {
        this.fechaCita = fechaCita;
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

    @Override
    public String toString() {
        String nombreTratamiento = obtenerNombreTratamiento(this.idTratamiento);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        String fechaFormateada = fechaCita.format(formatter);

        return dniCliente + " - " + nombreTratamiento + " - " + fechaFormateada;
    }
}
