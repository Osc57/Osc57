package Ej1;
/*
Utiliza como fuente de datos el fichero DATA.csv disponible en Moodle (UD08)
para llevar a cabo este ejercicio. Crea la clase Registro que corresponda con la
misma estructura de los registros del fichero DATA.csv. Crea un programa que lea
la información del fichero, cree un registro por cada línea del fichero (excepto la
cabecera) y añada cada registro a una lista. Utilizando los métodos de ordenación y
búsqueda de las listas el programa deberá mostrar:
• Los registros del país Francia (FR).
• Los registros con email de yahoo ordenados por nombre.
• Los registros con el último login entre noviembre de 2015 y enero de 2017
ambos incluidos ordenados por fecha de manera descendente.
• Los nombres y apellidos de los registros cuyo nombre (first_name) empiecen
por ‘A’ ordenados por fecha (descendente) del último inicio de sesión
(last_login).
*/

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Registro {
    private String firstName;
    private String lastName;
    private String email;
    private String country;
    private LocalDateTime lastLogin;
    
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Registro(String[] datos) {
        this.firstName = datos[1];
        this.lastName = datos[2];
        this.email = datos[6];
        this.country = datos[7];
        this.lastLogin = LocalDateTime.parse(datos[9], FORMATO);
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getCountry() { return country; }
    public LocalDateTime getLastLogin() { return lastLogin; }

    @Override
    public String toString() {
        return String.format("%-10s %-10s | %-2s | %-25s | %s", firstName, lastName, country, email, lastLogin.format(FORMATO));
    }
}

