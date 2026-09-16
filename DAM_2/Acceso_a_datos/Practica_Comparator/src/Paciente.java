import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Paciente {
    private String nombre;
    private int gravedad;
    private LocalDateTime llegada;

    public Paciente(String nombre, int gravedad, LocalDateTime llegada) {
        this.nombre = nombre;
        this.gravedad = gravedad;
        this.llegada = llegada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getGravedad() {
        return gravedad;
    }

    public void setGravedad(int gravedad) {
        this.gravedad = gravedad;
    }

    public LocalDateTime getLlegada() {
        return llegada;
    }

    public void setLlegada(LocalDateTime llegada) {
        this.llegada = llegada;
    }

    /*
    public static Comparator<Paciente> comparadorGravedad(List<Paciente> list) {
        
        for (Paciente p : list) {
        }
    }
    */

    @Override
    public String toString() {
        return "Paciente -> " + "Nombre: " + nombre + " - Gravedad: " + gravedad + " - Llegada: " + llegada;

    }
}
