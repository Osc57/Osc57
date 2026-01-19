package Ej3;

import java.time.LocalDate;

public class DemoVideoteca {
    public static void main(String[] args) {
        Videoteca videoteca = new Videoteca();

        //(String titulo, String director, LocalDate fechaEstreno, int duracionMinutos, String genero, double calificacion)
        Pelicula pelicula1 = new Pelicula("Padre no hay mas que uno", "Santiago Segura", LocalDate.of(2018, 4, 21), 3850, "Comedia", 7.8);
        Pelicula pelicula2 = new Pelicula("Padre no hay mas que uno 2", "Santiago Segura", LocalDate.of(2020, 4, 21), 4850, "Comedia", 6.8);
        Pelicula pelicula3 = new Pelicula("Padre no hay mas que uno 3", "Santiago Segura", LocalDate.of(2022, 4, 21), 3870, "Comedia", 5.8);
        Pelicula pelicula4 = new Pelicula("Padre no hay mas que uno 4", "Santiago Segura", LocalDate.of(2024, 4, 21), 3849, "Comedia", 9.8);

        videoteca.getListaPeliculas().add(pelicula1);
        videoteca.getListaPeliculas().add(pelicula2);
        videoteca.getListaPeliculas().add(pelicula3);
        videoteca.getListaPeliculas().add(pelicula4);

        System.out.println("PELICULAS");
        videoteca.mostrarPeliculas();

        System.out.println();
        System.out.println("DURACIÓN PROMEDIO");
        System.out.println(videoteca.duracionPromedio() + " minutos " + videoteca.duracionPromedio() / 60.0 + " hora/s");//" -> " + videoteca.duracionPromedio() / 60 + " hora/s "

        System.out.println();
        System.out.println("PELICULA MÁS ANTIGÜA");
        System.out.println(videoteca.masAntigua());

        System.out.println();
        System.out.println("REALIZAR BUSQUEDA (titulo, director o género)");
        for (Pelicula p : videoteca.buscarPelicula("Padre no hay mas que uno")) System.out.println(p);

        System.out.println();
        System.out.println("AÑADIR NUEVA PELICULA");
        videoteca.anadirPelicula(new Pelicula("Padre no hay mas que uno 5", "Santiago Segura", LocalDate.of(2025, 4, 21), 4500, "Comedia", 6.8));

    }
}
