import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Libro {
    private String titulo;
    private String autor;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Libro libro = (Libro) obj;
        return titulo.equals(libro.titulo) && autor.equals(libro.autor);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + titulo.hashCode();
        result = 31 * result + autor.hashCode();
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Libro> listalibro = new ArrayList<>();

        Libro libro1 = new Libro("Don quijote", "Cervantes");
        Libro libro2 = new Libro("Orgullo y prejuicio", "Jane Austen");
        Libro libro3 = new Libro("Frankenstein", "Mary Shelley");
        Libro libro4 = new Libro("Don quijote", "Cervantes");
        Libro libro5 = new Libro("Don quijote", "Cervantes");
        Libro libro6 = new Libro("Don quijote", "Cervantes");
        Libro libro7 = new Libro("Los tres mosqueteros", "Alexandre Dumas");
        Libro libro8 = new Libro("Don quijote", "Cervantes");
        Libro libro9 = new Libro("Cumbres borrascosas", "Emily Brontë");


        listalibro.add(libro1);
        listalibro.add(libro2);
        listalibro.add(libro3);
        listalibro.add(libro4);
        listalibro.add(libro5);
        listalibro.add(libro6);
        listalibro.add(libro7);
        listalibro.add(libro8);
        listalibro.add(libro9);

        
        for (Libro libro : listalibro) {
            System.out.println(libro.titulo + " - " + libro.autor);
        }
    }
}
