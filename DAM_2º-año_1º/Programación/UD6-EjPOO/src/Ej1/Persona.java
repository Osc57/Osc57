package Ej1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Persona {
    private String nombre;
    private String apellidos;
    private LocalDate fNacimiento;
    private String dni;
    private Character sexo;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public Persona(LocalDate fNacimiento, String nombre) {
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

    public String Saludar(){
        return "Hola soy " + this.nombre;
    }

    public long CalcularEdad(){
        LocalDate hoy = LocalDate.now();

        return ChronoUnit.YEARS.between(fNacimiento, hoy);
    }

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

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fNacimiento=" + fNacimiento +
                ", dni='" + dni + '\'' +
                ", sexo=" + sexo +
                '}';
    }
}
