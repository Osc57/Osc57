package org.example.Vista;

import org.example.Modelo.Departamento;
import org.example.Modelo.Empleados;

import javax.swing.*;
import java.util.ArrayList;

import static org.example.ControladorDAO.DepartamentoDAO.obtenerDepartamentos;

public class ModificarGerente extends JFrame {
    private ModificarEmpleado ventanaAnterior;
    private Empleados empleado;
    private ArrayList<Departamento> departamentos = obtenerDepartamentos();
}
