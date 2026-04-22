package org.example.Vista;

import org.example.Modelo.Empleados;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

import static org.example.ControladorDAO.EmpleadosDAO.mostrarEmpleados;
import static org.example.Utils.Funcionalidad.*;

public class ModificarEmpleado extends JFrame{


    public ModificarEmpleado() {
        this.setTitle("Modificar Empleado");
        this.setSize(480, 460);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        configurarCierreVentana(this);

        JLabel introducirCliente = new JLabel("•Seleccione empleado a modificar");
        introducirCliente.setFont(FUENTE_TITULO_2);
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 0));

        JPanel panelScrollPanel = getJPanelScrollPanel();
        JPanel panelBotonRetorno = getPanelBotonRetorno(this, new GestionEmpleado());

        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(panelScrollPanel, BorderLayout.CENTER);
        this.add(panelBotonRetorno, BorderLayout.SOUTH);
    }

    private JPanel getJPanelScrollPanel() {
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 15));

        modelEmpelados = new DefaultListModel<>();
        listaEmpelados = new JList<>(modelEmpelados);

        JScrollPane jScrollPane = new JScrollPane(listaEmpelados);
        jScrollPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 10));

        ArrayList<Empleados> empleados = mostrarEmpleados();
        for (Empleados t : empleados) {
            modelEmpelados.addElement(t);
        }

        panelPrincipal.add(jScrollPane, BorderLayout.CENTER);
        return panelPrincipal;
    }

    public static void main(String[] args) {
        new ModificarEmpleado().setVisible(true);
    }
}
