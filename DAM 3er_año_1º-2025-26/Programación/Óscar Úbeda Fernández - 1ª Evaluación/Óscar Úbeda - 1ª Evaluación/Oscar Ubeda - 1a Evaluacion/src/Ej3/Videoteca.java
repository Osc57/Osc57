package Ej3;

import java.util.ArrayList;

public class Videoteca {
    //Genero Array
    private ArrayList<Pelicula> listaPeliculas;

    //Genero constructores
    public Videoteca() {
        listaPeliculas = new ArrayList<Pelicula>();
    }

    public Videoteca(ArrayList<Pelicula> listaPeliculas) {
        this.listaPeliculas = listaPeliculas;
    }

    //Genero metodos
    public void mostrarPeliculas() {
        if (listaPeliculas.isEmpty()) System.out.print("LISTA VACIA, NO HAY PELICULAS");

        for (Pelicula p : listaPeliculas) {
            System.out.println(p);
        }
    }

    public Integer duracionPromedio() {
        if (listaPeliculas.isEmpty()) return 0;

        int suma = 0;
        for (Pelicula p : listaPeliculas) {
            suma = p.getDuracionMinutos() + suma;
        }

        return suma / listaPeliculas.size();
    }

    public Pelicula masAntigua() {
        if (listaPeliculas.isEmpty()) return null;

        Pelicula pelicula = null;
        int mayor = Integer.MIN_VALUE;

        for (Pelicula p : listaPeliculas) {
            if (p.cuantosAnos() > mayor) {
                mayor = p.cuantosAnos();
                pelicula = p;
            }
        }

        return pelicula;
    }

    public ArrayList<Pelicula> buscarPelicula(String s) {
        if (listaPeliculas.isEmpty()) return null;

        ArrayList<Pelicula> peliculas = new ArrayList<>();


        for (Pelicula p : listaPeliculas) {
            if (p.getTitulo().equalsIgnoreCase(s) || p.getDirector().equalsIgnoreCase(s) || p.getGenero().equalsIgnoreCase(s)) {
                peliculas.add(p);
            }
        }

        return peliculas;
    }

    public void anadirPelicula(Pelicula pelicula) {
        if (pelicula == null || pelicula.getTitulo().isEmpty()) {
            System.out.print("ERROR: NO SE HA INTRODUCIDO NINGUNA PELICULA");
            return;
        }

        boolean encontrado = false;

        for (Pelicula p : this.listaPeliculas) {
            if (p.getTitulo().equalsIgnoreCase(pelicula.getTitulo())) {
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            this.listaPeliculas.add(pelicula);
            System.out.println("PELICULA AÑADIDA");
        } else {
            System.out.println("ERROR EN LA PELICULA");
            return;
        }

        for (Pelicula pe : this.listaPeliculas) {
            System.out.println(pe);
        }
    }

    //Genero el getter
    public ArrayList<Pelicula> getListaPeliculas() {
        return listaPeliculas;
    }
}
