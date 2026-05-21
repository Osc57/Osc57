package org.example.Vista;

import org.example.Modelo.Empleados;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static org.example.ControladorDAO.EmpleadosDAO.mostrarEmpleados;
import static org.example.Utils.Funcionalidad.*;
import static org.example.Utils.Messages.mostrarMensaje;

public class GestionAfterLogin extends JFrame {

    ArrayList<Empleados> empelados = mostrarEmpleados();

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

                if (empelados.isEmpty()) {
                    mostrarMensaje("⚠️ No hay empelados para gestionar a un proyecto");
                    return;
                }

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
