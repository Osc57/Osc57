import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> numeroCorredores = new HashMap<>();
        Map<String, String> ciclistaEquipo = new HashMap<>();
        Map<String, Integer> equipoSumaEdades = new HashMap<>();
        Map<String, Integer> paisNumero = new HashMap<>();
        String ruta = "./Equipos";
        File[] archivos = listarDirectorios(ruta);
        //Coger cada archivo y ver su contenido...

        for (File archivo : archivos){
            String nombreEquipo = archivo.getName().replace(".txt","").trim();
            System.out.println(" ");
            System.out.println("TRATAMOS EL ARCHIVO: " + nombreEquipo);
            numeroCorredores.put(nombreEquipo, 0);
            equipoSumaEdades.put(nombreEquipo, 0);
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(archivo));
                String linea = "";
                while ((linea = bufferedReader.readLine()) != null){
                    System.out.println(linea);
                    int numeroDeCiclistasEnEquipo = numeroCorredores.get(nombreEquipo);
                    numeroCorredores.put(nombreEquipo,numeroDeCiclistasEnEquipo + 1);
                    String[] partes = linea.split("\\|");
                    String nombre = partes[0].trim();
                    String pais = partes[1].trim();
                    int numeroDeCorredoresEnUnPais = paisNumero.getOrDefault(pais, 0);
                    paisNumero.put(pais, numeroDeCorredoresEnUnPais);
                    int edad = Integer.parseInt(partes[2].trim().replace("años", "").trim().replace(".", "").trim());

                    ciclistaEquipo.put(nombre,nombreEquipo);
                    int sumaEdades = equipoSumaEdades.get(nombreEquipo);
                    equipoSumaEdades.put(nombre, sumaEdades + edad);

                }
                System.out.println(equipoSumaEdades);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        //Todos los archivos tratados:
        equipoConMasCorrecores(numeroCorredores);
        equipoConMenosCorredores(numeroCorredores);

        buscarCiclista("Jonas Vingegaard", ciclistaEquipo);

        equipoConMenorMediadeEdad(equipoSumaEdades, numeroCorredores);
        equipoConMayorMediadeEdad(equipoSumaEdades, numeroCorredores);

        pasiConMasCorredores(paisNumero);

        interfazBuscaCiclista(ciclistaEquipo);

    }

    private static void interfazBuscaCiclista(Map<String, String> ciclistaEquipo) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un ciclista: ");
        String nombre = scanner.nextLine();
        if (ciclistaEquipo.containsKey(nombre)){
            System.out.println("El ciclista: " + nombre + " pertenece a: " + ciclistaEquipo.get(nombre));
        }
    }

    private static void pasiConMasCorredores(Map<String, Integer> paisNumero) {
        int maximo = Collections.max(paisNumero.values());
        System.out.println(maximo);
        for(String key : paisNumero.keySet()){
            int valor = paisNumero.get(key);
            if (maximo == valor){
                System.out.println("El pais con más corredores es: " + key + " y tiene: " + valor + " corredores");
            }
        }
    }

    private static void equipoConMayorMediadeEdad(Map<String, Integer> equipoSumaEdades, Map<String, Integer> numeroCorredores) {
        for (String key : equipoSumaEdades.keySet()){
            System.out.println(key + " " + numeroCorredores.get(key));
            int valor = numeroCorredores.get(key);
            int valorSuma = equipoSumaEdades.get(key);
            equipoSumaEdades.put(key, valorSuma/valor);
            System.out.println(equipoSumaEdades);
        }
        int maximo = Collections.max(equipoSumaEdades.values());
        for (String key : equipoSumaEdades.keySet()){
            int valor = equipoSumaEdades.get(key);
            if (valor == maximo){
                System.out.println("El quipo con mayor media es: " + key + " y la media es: " + maximo);
            }
        }
    }


    private static void equipoConMenorMediadeEdad(Map<String, Integer> equipoSumaEdades, Map<String, Integer> numeroCorredores) {
        for (String key : equipoSumaEdades.keySet()){
            System.out.println(key + " " + numeroCorredores.get(key));
            int valor = numeroCorredores.get(key);
            int valorSuma = equipoSumaEdades.get(key);
            equipoSumaEdades.put(key, valorSuma/valor);
            System.out.println(equipoSumaEdades);
        }
        int minimo = Collections.min(equipoSumaEdades.values());
        for (String key : equipoSumaEdades.keySet()){
            int valor = equipoSumaEdades.get(key);
            if (valor == minimo){
                System.out.println("El quipo con menor media es: " + key + " y la media es: " + minimo);
            }
        }
    }

    private static void buscarCiclista(String nombre, Map<String, String> ciclistaEquipo) {
        System.out.println("El ciclista " + nombre + " corre en el equipo " + ciclistaEquipo.get(nombre));
    }

    private static void equipoConMenosCorredores(Map<String, Integer> numeroCorredores) {
        int minimo = Collections.min(numeroCorredores.values());
        for (String key : numeroCorredores.keySet()){
            int valor = numeroCorredores.get(key);
            if (minimo == valor){
                System.out.println("El equipo con menos corredores es: " + key + " y tiene " + valor + " corredores.");
            }
        }
    }

    private static void equipoConMasCorrecores(Map<String, Integer> numeroCorredores) {
        int maximo = Collections.max(numeroCorredores.values());
        for (String key : numeroCorredores.keySet()){
            int valor = numeroCorredores.get(key);
            if (maximo == valor){
                System.out.println("El equipo con más corredores es: " + key + " y tiene " + valor + " corredores.");
            }
        }

    }

    private static File[] listarDirectorios(String ruta) {
        File directorio = new File(ruta);
        if (directorio.exists() && directorio.isDirectory()){
            File[] archivos = directorio.listFiles();
            return archivos;
        }else{
            System.out.println("El directorio indicado no existe");
            System.exit(2);//Cerrar mi programa
        }
        return null;
    }
}
