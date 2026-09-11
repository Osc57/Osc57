package Ej3;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Pelicula {
    //Creo atributos
    private String titulo;
    private String director;
    private LocalDate fechaEstreno;
    private int duracionMinutos;
    private String genero;
    private double calificacion;

    //Genero Constructores
    public Pelicula(String titulo) {
        this.titulo = titulo;
    }

    public Pelicula(String titulo, String director) {
        this.titulo = titulo;
        this.director = director;
    }

    public Pelicula(String titulo, String director, LocalDate fechaEstreno, int duracionMinutos, String genero, double calificacion) {
        this.titulo = titulo;
        this.director = director;
        this.fechaEstreno = fechaEstreno;
        this.duracionMinutos = duracionMinutos;
        this.genero = genero;
        this.calificacion = calificacion;
    }

    //Creo metodos
    public String descripcion() {
        return "La pelicula " + titulo + ", dirigida por" + director + ", pertenece al género " + genero;
    }

    public Integer cuantosAnos() {
        if (fechaEstreno == null) return 0;

        return (int) ChronoUnit.YEARS.between(fechaEstreno, LocalDate.now());
    }

    //Creo Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    //Genero toString
    @Override
    public String toString() {
        return "título: " + titulo + ", director: " + director + ", fecha de estreno: " + fechaEstreno + ", duración: " + duracionMinutos +
                ", género: " + genero + ", calificación: " + calificacion;
    }
}
