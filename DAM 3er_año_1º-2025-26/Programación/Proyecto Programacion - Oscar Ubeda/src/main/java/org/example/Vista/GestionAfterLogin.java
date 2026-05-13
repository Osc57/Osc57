package org.example.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.example.Utils.Funcionalidad.*;

public class GestionAfterLogin extends JFrame {

    public GestionAfterLogin() {
        this.setTitle("Gestión Empresa");
        this.setSize(500, 370);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        configurarCierreVentana(this);

        JPanel panelBotonesGetion = getjPanlepanelBotonesGestion();

        this.add(panelBotonesGetion, BorderLayout.CENTER);

    }

    private JPanel getjPanlepanelBotonesGestion() {
        JPanel panelBotonesGestion = new JPanel(new GridLayout(3, 1, 15, 15));
        panelBotonesGestion.setBorder(BorderFactory.createEmptyBorder(50, 70, 50, 70));
        panelBotonesGestion.setBackground(COLOR_FONDO_GRIS_CLARO);

        JButton botonGestionarProyectos = crearEstiloBoton("<html>Gestiona <br> Proyectos</html>");
        botonGestionarProyectos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GestionProyectos().setVisible(true);
                dispose();
            }
        });

        JButton botonGestionEmpleados = crearEstiloBoton("<html>Gestiona <br> Empleados</html>");
        botonGestionEmpleados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GestionEmpleado().setVisible(true);
                dispose();
            }
        });

        JButton botonGestionaDeptos = crearEstiloBoton("<html>Gestiona <br> Departamentos</html>");
        botonGestionaDeptos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GestionDepartamentos().setVisible(true);
                dispose();

            }
        });

        panelBotonesGestion.add(botonGestionarProyectos);
        panelBotonesGestion.add(botonGestionEmpleados);
        panelBotonesGestion.add(botonGestionaDeptos);

        return panelBotonesGestion;
    }

    public static void main(String[] args) {
        new GestionAfterLogin().setVisible(true);
    }


}
