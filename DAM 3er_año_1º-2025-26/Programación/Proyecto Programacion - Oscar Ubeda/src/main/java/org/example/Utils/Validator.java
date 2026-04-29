package org.example.Utils;

public class Validator {

    public static final String NOMBRE_EMPRESA = "@empresa.emp";

    public static boolean camposRellenos(String... campos) {
        for (String c : campos) {
            if (c == null || c.isBlank()) {
                return false;
            }
        }
        return true;
    }

    public static boolean dniValido(String dni) {
        return dni.matches("^[0-9]{8}[A-Za-z]$");
    }

    public static boolean usuarioValido(String usuario) {
        return usuario.matches("^[a-zA-Z0-9_]{4,12}$");
    }

    public static boolean passwordValida(String password) {
        return password.matches("^(?=.*[A-Z])(?=.*[^a-zA-Z]).{12,}$");
    }

    public static boolean passwordsCoinciden(String p1, String p2) {
        return p1.equals(p2);
    }

    public static boolean nombreValido(String nombre) {
        return nombre.matches("^[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+(?: [A-ZÁÉÍÓÚÑ][a-záéíóúñ]+)*$");
    }

    public static boolean apellidosValido(String apellido) {
        return apellido.matches("^[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+(?: [A-ZÁÉÍÓÚÑ][a-záéíóúñ]+)+$");
    }

    public static boolean telefonoValido(String telefono) {
        return telefono.matches("^[0-9]{9}");
    }

    public static boolean validarEmail(String email) {
        return email.matches("^[a-zA-Z0-9._%+-]+" + NOMBRE_EMPRESA + "$");
    }

    public static boolean salarioValido(String salarioTexto) {

        salarioTexto = salarioTexto.trim().replace(",", ".");

        try {
            double salario = Double.parseDouble(salarioTexto);

            return salario > 0;

        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static double calcularBono(String rango, double salarioBase) {
        double porcentaje = switch (rango.toUpperCase()) {
            case "ALTO" -> 0.50;
            case "MEDIO" -> 0.25;
            case "BAJO" -> 0.10;
            default -> 0;
        };

        return salarioBase * porcentaje;
    }

}
