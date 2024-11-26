package Ej1;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Persona {
    private String nombre;
    private String apellidos;
    private LocalDate fNacimiento;
    private String dni;
    private char sexo;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public Persona(String nombre, LocalDate fNacimiento) {
        this.fNacimiento = fNacimiento;
        this.nombre = nombre;
    }

    public Persona(String nombre, String apellidos, LocalDate fNacimiento, String dni, Character sexo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fNacimiento = fNacimiento;
        this.dni = dni;
        this.sexo = sexo;
    }

    //Getter and Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(LocalDate fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public String Saludar() {
        return "Hola soy " + nombre;
    }

    public int CalcularEdad() {
        return Period.between(fNacimiento, LocalDate.now()).getYears();
    }


    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Apellidos: " + apellidos + ", Fecha de Nacimiento: " + fNacimiento +
                ", Dni: " + ", Sexo: " + sexo;
    }
}
