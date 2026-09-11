package org.example.SegundaEvaluacion.Ej3;


import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;

import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "empresa") // Cambia el nombre raíz si lo deseas
public class ListaEmpleados {

    private ArrayList<Empleado> empleados;

    public ListaEmpleados() {}

    public ListaEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    @XmlElement(name = "empleado") // <-- Añade esto para renombrar cada elemento de la lista
    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public String toString() {
        return empleados.toString();
    }
}

