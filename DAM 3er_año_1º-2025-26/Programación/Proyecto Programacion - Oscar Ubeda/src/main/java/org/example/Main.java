package org.example;

import org.example.Modelo.Empleados;
import org.example.Modelo.Gerente;
import org.example.Modelo.Programador;

import java.util.ArrayList;

import static org.example.ControladorDAO.EmpleadosDAO.*;
import static org.example.ControladorDAO.GerenteDAO.insertarGerente;
import static org.example.ControladorDAO.GerenteDAO.mostrarGerentes;
import static org.example.ControladorDAO.ProgramadorDAO.insertarProgramador;
import static org.example.ControladorDAO.ProgramadorDAO.mostrarProgramadores;

public class Main {
    public static void main(String[] args) {
        ArrayList<Programador> programadores = mostrarProgramadores();
        ArrayList<Empleados> empleados = mostrarEmpleados();
        ArrayList<Gerente> gerentes = mostrarGerentes();

        boolean esGerente = false;

        Empleados empleado = new Empleados("32345600Y", "Panacota", "Seven Six", "sevensix@seven.six", 2560.0, 1);

        /*
        if (insertarEmpleado(empleados)) {
            insertarProgramador(empleados, new Programador("Python"));
            boolean exitoCargo = true;

            if (!esGerente) {
                exitoCargo = insertarGerente(empleados, new Gerente(500, "Bajo"));
                //Aqui habra un combobox que dira los 4 lenguajes de programacion mas usados y una opcion que sea otro
                //Se asignaria un especifica si elige la opcion otro
            } else {
                exitoCargo =
            }

            if (!exitoCargo){
                System.out.println("Bien");
            }else {
                System.out.println("Mal")
            }
        }
        */

        /*
        if (insertarEmpleado(empleado)) {
            insertarGerente(empleado, new Gerente(300, "Medio"));
            System.out.println("Good");
        } else {
            System.out.println("Not Good");
        }
        */

        for (Programador p : programadores) {
            System.out.println(p);
        }

        System.out.println();
        for (Empleados e : empleados) {
            System.out.println(e);
        }

        System.out.println();
        for (Gerente g : gerentes){
            System.out.println(g);
        }

    }
}
