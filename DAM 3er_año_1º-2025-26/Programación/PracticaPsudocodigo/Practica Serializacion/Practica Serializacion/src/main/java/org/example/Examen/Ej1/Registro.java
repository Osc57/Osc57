package org.example.Examen.Ej1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Registro {
    private String first_name;
    private String last_name;
    private String email;
    private String country;
    private String last_login;

    public Registro() {
    }

    public Registro(String[] lista) {
        this.first_name = lista[1];
        this.last_name = lista[2];
        this.email = lista[6];
        this.country = lista[7];
        this.last_login = lista[9];

    }

    public LocalDate getFechaLogin() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDate.parse(last_login, f);
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLast_login() {
        return last_login;
    }

    public void setLast_login(String last_login) {
        this.last_login = last_login;
    }

    @Override
    public String toString() {
        return first_name + " " + last_name + "    |    " + email + "   |   " + country + "  |   " + last_login;
    }
}
