package Ej4;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        Libro libro1 = new Libro("Las flipantes aventuras de un caballo en un desierto","Perico Patas",180);
        Libro libro2 = new Libro("20 leguas de viaje submarino","Julio Verne",210);

        Revista revista1 = new Revista("La maravillosa revista","El autor autorero",35);
        Revista revista2 = new Revista("Noticias impactantes","Jaime",4);

        ArrayList<Publicacion> listaPublicaciones = new ArrayList<>();

        listaPublicaciones.add(libro1);
        listaPublicaciones.add(libro2);
        listaPublicaciones.add(revista1);
        listaPublicaciones.add(revista2);

        for (Publicacion p : listaPublicaciones){
            System.out.println(p.mostrarInfo());
        }
    }
}
