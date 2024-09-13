import java.io.*;

public class Main {
    public static void main(String[] args) {
        Estudiante e1 = new Estudiante("Antonio Perez", 38);
        //Estudiante e2 = new Estudiante("Pepito Gomez", 41);

        try (FileOutputStream fileOut = new FileOutputStream("estudiante.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(e1);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    private static void deserializar(String archivo) {
        try (FileInputStream fileInputStream = new FileInputStream(archivo);
             ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        ) {
            Estudiante estudiante = (Estudiante) inputStream.readObject();
        } catch (IOException ex) {

        } catch (ClassNotFoundException e) {
            System.out.println("Error al leer el objeto");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

