package org.example.Vista;

import org.example.Modelo.Departamento;
import org.example.Modelo.Empleados;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static org.example.ControladorDAO.DepartamentoDAO.obtenerDepartamentos;
import static org.example.Utils.Estilos.*;

public class EmpleadoProgramador extends JFrame {
    private DarAltaEmpleado ventanaAnterior;
    private Empleados empleado;
    private ArrayList<Departamento> departamentos = obtenerDepartamentos();

    public EmpleadoProgramador(DarAltaEmpleado ventanaAnterior, Empleados empleado) {
        this.ventanaAnterior = ventanaAnterior;
        this.empleado = empleado;

        this.setTitle("Programador");
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        configurarCierreVentana(this);

        JLabel introducirCliente = new JLabel("Introduzca los datos del programador");
        introducirCliente.setFont(FUENTE_TITULO_2);
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(15, 50, 0, 0));

        JPanel panelDatosUsuario = getjPanelDatosUsuario();
        JPanel panelBotonRetorno = getPanelBotonRetorno(this, ventanaAnterior);

        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(panelDatosUsuario, BorderLayout.CENTER);
        this.add(panelBotonRetorno, BorderLayout.SOUTH);
    }

    private JPanel getjPanelDatosUsuario() {
        JPanel panelRegistro = new JPanel(new BorderLayout());
        panelRegistro.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 10));

        // Panel central con los labels y los campos
        JPanel panelCentro = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JPanel panelLabels = new JPanel(new GridLayout(3, 1, 5, 5));
        panelLabels.add(crearLabels("Salario: "));
        panelLabels.add(crearLabels("Depto.: "));
        panelLabels.add(crearLabels("Lenguaje Pro.: "));//Combo Box

        JPanel panelFields = new JPanel(new GridLayout(3, 1, 5, 5));
        JTextField txtsalario = crearFields();

        JComboBox<Departamento> comboBoxDepart = new JComboBox<>();

        for (Departamento d : departamentos) {
            comboBoxDepart.addItem(d);
        }

        panelFields.add(txtsalario);
        panelFields.add(comboBoxDepart);

        panelCentro.add(panelLabels);
        panelCentro.add(panelFields);
        panelRegistro.add(panelCentro, BorderLayout.CENTER);


        JPanel panelBoton = new JPanel((new FlowLayout(FlowLayout.CENTER)));
        JButton btnCrearUser = crearEstiloBotonSubmit("DAR DE ALTA PROGRAMADOR");

        btnCrearUser.setPreferredSize(new Dimension(380, 45));
        panelBoton.add(btnCrearUser);


        panelRegistro.add(panelBoton, BorderLayout.SOUTH);

        return panelRegistro;
    }
}
