package org.example.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.example.Utils.Componentes.*;

public class GestionAfterLogin extends JFrame {

    public GestionAfterLogin() {
        this.setTitle("Gestión Empresa");
        this.setSize(500, 370);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        configurarCierreVentana(this);

        JPanel panelBotonesGetion = getjPanlepanelBotonesGestion();
        JPanel panelBotonRetorno = getPanelBotonRetorno(this, new Login());

        this.add(panelBotonesGetion, BorderLayout.CENTER);
        this.add(panelBotonRetorno, BorderLayout.SOUTH);

    }

    private JPanel getjPanlepanelBotonesGestion() {
        JPanel panelBotonesGestion = new JPanel(new GridLayout(3, 1, 15, 15));
        panelBotonesGestion.setBorder(BorderFactory.createEmptyBorder(50, 70, 20, 70));
        panelBotonesGestion.setBackground(COLOR_FONDO_GRIS_CLARO);

        JButton botonGestiona = crearEstiloBoton("<html>Gestiona <br> Proyectos</html>");
        botonGestiona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //dispose();

            }
        });

        JButton botonDarCitaCliente = crearEstiloBoton("<html>Gestiona <br> Empleados</html>");
        botonDarCitaCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GestionEmpleado().setVisible(true);
            }
        });

        JButton botonHistorialCliente = crearEstiloBoton("<html>Gestiona <br> Departamentos</html>");
        botonHistorialCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //dispose();

            }
        });

        panelBotonesGestion.add(botonGestiona);
        panelBotonesGestion.add(botonDarCitaCliente);
        panelBotonesGestion.add(botonHistorialCliente);

        return panelBotonesGestion;
    }


}
