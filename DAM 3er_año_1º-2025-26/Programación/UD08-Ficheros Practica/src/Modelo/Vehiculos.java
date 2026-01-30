package Modelo;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.time.temporal.ChronoUnit;


public class Vehiculos {
    private String marca;
    private String modelo;
    private int anoFabricacion;
    private String matricula;
    private double precio;

    public Vehiculos(String matricula) {
        this.matricula = matricula;
    }

    public Vehiculos(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public Vehiculos(String marca, String modelo, int anoFabricacion, String matricula, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacion = anoFabricacion;
        this.matricula = matricula;
        this.precio = precio;
    }

    public String descripcion() {
        return "Vehiculo marca " + marca + ", modelo " + modelo + ", año " + anoFabricacion
                + ", matricula " + matricula + ", precio " + precio;
    }

    public int calcularAntiguedad() {
        //return Period.between(LocalDate.ofEpochDay(anoFabricacion), LocalDate.now()).getYears();
        return LocalDate.now().getYear() - anoFabricacion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnoFabricacion() {
        return anoFabricacion;
    }

    public void setAnoFabricacion(int anoFabricacion) {
        this.anoFabricacion = anoFabricacion;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Vehiculo marca " + marca + ", modelo " + modelo + ", año " + anoFabricacion
                + ", matricula " + matricula + ", precio " + precio;
    }
}
