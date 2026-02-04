import java.io.*;

public class Practica {
    public static boolean validarNombre(String nombre) {
        String regex = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ]+(\\s[a-zA-ZáéíóúÁÉÍÓÚñÑ]+)+$";
        return nombre.trim().matches(regex);
    }

    public static boolean validarCorreo(String correo) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return correo.trim().matches(regex);
    }

    public static boolean validarTelefono(String telef) {
        String regex = "[6-9]\\d{8}";
        return telef.trim().matches(regex);
    }

    public static boolean validarDni(String dni) {
        String regex = "\\d{8}[A-Z]";
        return dni.trim().matches(regex);
    }

    public static boolean validarLineaCompleta(String linea) {
        String[] partes = linea.split(";");

        if (partes.length != 4) return false;

        return validarNombre(partes[0]) &&
                validarCorreo(partes[1]) &&
                validarTelefono(partes[2]) &&
                validarDni(partes[3]);
    }

    //21 inválidos
    //79 validos
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"));
             BufferedWriter bwValidos = new BufferedWriter(new FileWriter("usuarios_validos.txt"));
             BufferedWriter bwInvalidos = new BufferedWriter(new FileWriter("usuarios_invalidos.txt"))) {
            String linea;

            int contadorV = 0;
            int contadorF = 0;
            while ((linea = br.readLine()) != null) {
                if (validarLineaCompleta(linea)) {
                    bwValidos.write(linea);
                    bwValidos.newLine();
                    contadorV++;
                } else {
                    bwInvalidos.write(linea);
                    bwInvalidos.newLine();
                    contadorF++;
                }
            }

            System.out.println(contadorV + " válidos");
            System.out.println(contadorF + " inválidos");

        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + e.getMessage());
        }
    }


    /*
    public static void main(String[] args) {
        String regexNombre = "(?i)[a-záéíóúñ]+\\\\s[a-záéíóúñ]+\\\\s?";
        String regexCorreo = "\\w+@\\w+\\.[a-z]{2,}";
        String regexTelefono = "(6\\d{8})|(7\\d{8})|(8\\d{8})|(9\\d{8})";
        String regexDni = "\\d{8}[A-Z]";

        Pattern pNombre = Pattern.compile(regexNombre);
        Pattern pCorreo = Pattern.compile(regexCorreo);
        Pattern pTlf = Pattern.compile(regexTelefono);
        Pattern pDni = Pattern.compile(regexDni);

        try (BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"))) {
            String linea = br.readLine();

            while ((linea = br.readLine()) != null) {
                if (pNombre.matcher(linea).matches()){
                    System.out.println(linea);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + e.getMessage());
        }
    }
    */
}
