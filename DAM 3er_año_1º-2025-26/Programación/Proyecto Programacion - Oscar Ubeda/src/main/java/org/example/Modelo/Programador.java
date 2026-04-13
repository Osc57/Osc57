package org.example.Modelo;

public class Programador extends Empleados{
    private String lenguajePrincipal;

    public Programador() {
    }

    public Programador(String lenguajePrincipal) {
        this.lenguajePrincipal = lenguajePrincipal;
    }

    public Programador(String dni, String nombre, String apellidos, String email, double salario, int departamento, String lenguajePrincipal) {
        super(dni, nombre, apellidos, email, salario, departamento);
        this.lenguajePrincipal = lenguajePrincipal;
    }

    public String getLenguajePrincipal() {
        return lenguajePrincipal;
    }

    public void setLenguajePrincipal(String lenguajePrincipal) {
        this.lenguajePrincipal = lenguajePrincipal;
    }
}
