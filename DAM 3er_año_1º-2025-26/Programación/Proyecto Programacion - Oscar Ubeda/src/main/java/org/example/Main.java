package org.example;

import org.example.Modelo.Empleados;
import org.example.Modelo.Gerente;
import org.example.Modelo.Programador;

import static org.example.ControladorDAO.EmpleadosDAO.insertarEmpleado;
import static org.example.ControladorDAO.GerenteDAO.insertarGerente;
import static org.example.ControladorDAO.ProgramadorDAO.insertarProgramador;

public class Main {
    public static void main(String[] args) {

        boolean esGerente = false;

        Empleados empleados = new Empleados("02345608Y", "Panacoto", "Six Seven", "sixseven@six.seven", 2560.0, 1);

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

        if (insertarEmpleado(empleados)){
            insertarProgramador(empleados, new Programador("Python"));

            System.out.println("Good");
        }else {
            System.out.println("Not Good");
        }


    }
}
