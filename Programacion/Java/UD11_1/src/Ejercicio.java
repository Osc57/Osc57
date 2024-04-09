public class Ejercicio {

    public static void main(String[] args) {
        String uri = "https://www.google.com/search?q=Java+21";
        String[] partes = uri.split("://");
        String protocolo = partes[0];
        System.out.println("Protocolo: " + protocolo);

        String resto = partes[1];
        partes = resto.split("/");
        String dominio = partes[0];
        resto = partes[1];
        System.out.println("Dominio: " + dominio);

        partes = resto.split("\\?q=");
        String ruta = partes[0];
        System.out.println("Ruta: " + ruta);

        String busqueda = partes[1];
        System.out.println("Búsqueda: " + busqueda);


    }
}
