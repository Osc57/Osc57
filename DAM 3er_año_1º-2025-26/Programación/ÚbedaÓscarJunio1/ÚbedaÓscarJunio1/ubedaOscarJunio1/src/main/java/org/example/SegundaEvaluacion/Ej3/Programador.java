package org.example.SegundaEvaluacion.Ej3;

import jakarta.xml.bind.annotation.XmlRootElement;

public class Programador extends Empleado {
    private String lenguajePrincipal;

    public Programador(String nombre, int edad, double salario, String lenguajePrincipal) {
        super(nombre, edad, salario);
        this.lenguajePrincipal = lenguajePrincipal;
    }

    public String getLenguajePrincipal() {
        return lenguajePrincipal;
    }

    public void setLenguajePrincipal(String lenguajePrincipal) {
        this.lenguajePrincipal = lenguajePrincipal;
    }

    @Override
    public String toString() {
        return super.toString() + " " + lenguajePrincipal;
    }
}
