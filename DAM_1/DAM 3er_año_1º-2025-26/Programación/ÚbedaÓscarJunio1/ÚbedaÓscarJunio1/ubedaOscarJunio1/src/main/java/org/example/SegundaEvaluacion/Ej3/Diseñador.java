package org.example.SegundaEvaluacion.Ej3;

import jakarta.xml.bind.annotation.XmlRootElement;

public class Diseñador extends Empleado {
    private String especialidad;


    public Diseñador(String nombre, int edad, double salario, String especialidad) {
        super(nombre, edad, salario);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return super.toString() + " " + especialidad;
    }
}
