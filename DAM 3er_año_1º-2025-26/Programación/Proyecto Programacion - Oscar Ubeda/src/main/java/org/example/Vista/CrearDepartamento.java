package org.example.Vista;

import javax.swing.*;
import java.awt.*;

import static org.example.Utils.Funcionalidad.*;

public class CrearDepartamento extends JFrame {
    private JTextField txtNombre;

    private final int nPisos = 5;

    public CrearDepartamento() {
        this.setTitle("Crear un departamento");
        this.setSize(500, 370);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        configurarCierreVentana(this);

        JLabel introducirCliente = new JLabel("Introduzca los datos del departamento");
        introducirCliente.setFont(FUENTE_TITULO_2);
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(15, 15, 0, 0));

        JPanel panelDatosUsuario = getjPanelDatosDepartamento();
        JPanel panelBotonRetorno = getPanelBotonRetorno(this, new GestionDepartamentos());

        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(panelDatosUsuario, BorderLayout.CENTER);
        this.add(panelBotonRetorno, BorderLayout.SOUTH);
    }

    public JPanel getjPanelDatosDepartamento() {
        JPanel panelPrincipal = new JPanel(new GridLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 10));

        JPanel panelCentro = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 30));

        JPanel panelLabels = new JPanel(new GridLayout(2, 1, 5, 5));
        panelLabels.add(crearLabels("Nombre: "));
        panelLabels.add(crearLabels("Ubicación: "));

        JPanel panelFields = new JPanel(new GridLayout(2, 1, 5, 5));
        txtNombre = crearFields();

        JComboBox<String> comboBoxUbicacion = new JComboBox<>();


        comboBoxUbicacion.addItem("Selecciona un piso...");

        for (int i = 1; i <= nPisos; i++) {
            comboBoxUbicacion.addItem("Piso " + i);
        }

        comboBoxUbicacion.setSelectedIndex(0);

        panelFields.add(txtNombre);
        panelFields.add(comboBoxUbicacion);

        panelCentro.add(panelLabels);
        panelCentro.add(panelFields);

        panelPrincipal.add(panelCentro, BorderLayout.CENTER);

        return panelPrincipal;
    }
}
