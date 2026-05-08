package org.example.Vista;

import org.example.Modelo.Departamento;
import org.example.Modelo.Empleados;
import org.example.Utils.DepartamentoENUM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static org.example.ControladorDAO.DepartamentoDAO.obtenerDepartamentos;
import static org.example.ControladorDAO.EmpleadosDAO.*;
import static org.example.Utils.Funcionalidad.*;
import static org.example.Utils.Messages.mostrarError;

public class ModificarDepartamento extends JFrame {

    private Departamento departamento;

    public ModificarDepartamento(Departamento depart) {
        this.departamento = depart;

        this.setTitle("Modificar Empleado");
        this.setSize(480, 370);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        configurarCierreVentana(this);

        JLabel introducirCliente = new JLabel("•Modifique la ubicación");
        introducirCliente.setFont(FUENTE_TITULO_2);
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 0));

        JPanel panelScrollPanel = getJPanelScrollPanel();
        JPanel panelBotonRetorno = getPanelBotonRetorno(this, new SeleccionDeptoModificar());

        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(panelScrollPanel, BorderLayout.CENTER);
        this.add(panelBotonRetorno, BorderLayout.SOUTH);
    }

    private JPanel getJPanelScrollPanel() {
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 15));

        JPanel panelCentro = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 40));

        JPanel panelLabels = new JPanel(new GridLayout(1, 1, 5, 5));
        panelLabels.add(crearLabels("Ubicación: "));

        JPanel panelFields = new JPanel(new GridLayout(1, 1, 5, 5));

        JComboBox<String> comboBoxUbicacion = new JComboBox<>();
        comboBoxUbicacion.addItem("Selecciona un piso...");

        for (int i = 1; i <= N_PISOS; i++) {
            comboBoxUbicacion.addItem("Piso " + i);
        }

        comboBoxUbicacion.setSelectedItem(departamento.getUbicacion());

        JPanel panelBoton = new JPanel((new FlowLayout(FlowLayout.CENTER)));
        JButton btnCrearDpto = crearEstiloBotonSubmit("MODIFICAR UBICACIÓN");
        btnCrearDpto.setPreferredSize(new Dimension(380, 45));


        panelFields.add(comboBoxUbicacion);

        panelCentro.add(panelLabels);
        panelCentro.add(panelFields);

        panelPrincipal.add(panelCentro, BorderLayout.CENTER);

        panelBoton.add(btnCrearDpto);
        panelPrincipal.add(panelBoton, BorderLayout.SOUTH);
        return panelPrincipal;
    }
}
