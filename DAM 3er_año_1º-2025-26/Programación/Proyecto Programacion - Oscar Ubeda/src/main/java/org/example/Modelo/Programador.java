package org.example.Modelo;

public class Programador extends Empleados{
    private String lenguajePrincipal;

    public Programador(String lenguajePrincipal) {
        this.lenguajePrincipal = lenguajePrincipal;
    }

    public Programador(String dni, String nombre, String email, double salario, String lenguajePrincipal) {
        super(dni, nombre, email, salario);
        this.lenguajePrincipal = lenguajePrincipal;
    }

    public String getLenguajePrincipal() {
        return lenguajePrincipal;
    }

    public void setLenguajePrincipal(String lenguajePrincipal) {
        this.lenguajePrincipal = lenguajePrincipal;
    }
}
