package org.example.Vista;

import org.example.Modelo.Empleados;
import org.example.Modelo.Programador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static org.example.ControladorDAO.EmpleadosDAO.mostrarEmpleados;
import static org.example.ControladorDAO.ProgramadorDAO.obtenerEmpleadosLibres;
import static org.example.Utils.Funcionalidad.*;
import static org.example.Utils.Funcionalidad.crearEstiloBoton;
import static org.example.Utils.Messages.mostrarMensaje;

public class GestionProyectos extends JFrame {

    ArrayList<Empleados> empleados = mostrarEmpleados();

    public GestionProyectos() {
        this.setTitle("Gestión Proyectos");
        this.setSize(500, 370);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        configurarCierreVentana(this);

        JPanel panelBotonesCentro = getjPanlepanelBotonesGestion();
        JPanel panelBotonRetorno = getPanelBotonRetorno(this, new GestionAfterLogin());

        this.add(panelBotonesCentro, BorderLayout.CENTER);
        this.add(panelBotonRetorno, BorderLayout.SOUTH);
    }

    private JPanel getjPanlepanelBotonesGestion() {
        JPanel panelBotonesGestion = new JPanel(new GridLayout(3, 1, 15, 15));
        panelBotonesGestion.setBorder(BorderFactory.createEmptyBorder(50, 70, 20, 70));
        panelBotonesGestion.setBackground(COLOR_FONDO_GRIS_CLARO);

        JButton botonCrearProyecto = crearEstiloBoton("<html>Crear <br> Proyectos</html>");
        botonCrearProyecto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new CrearProyecto().setVisible(true);
                dispose();

            }
        });

        JButton botonModificarProyecto = crearEstiloBoton("<html>Modificar <br> Proyecto</html>");
        botonModificarProyecto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //dispose();
            }
        });

        JButton botonEliminarProyecto = crearEstiloBoton("<html>Eliminar <br> Proyecto</html>");
        botonEliminarProyecto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //dispose();

            }
        });

        panelBotonesGestion.add(botonCrearProyecto);
        panelBotonesGestion.add(botonModificarProyecto);
        panelBotonesGestion.add(botonEliminarProyecto);

        return panelBotonesGestion;
    }
}
