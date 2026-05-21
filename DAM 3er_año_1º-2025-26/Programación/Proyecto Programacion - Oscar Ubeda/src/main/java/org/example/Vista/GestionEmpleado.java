package org.example.Vista;

import org.example.Modelo.Departamento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static org.example.ControladorDAO.DepartamentoDAO.obtenerDepartamentos;
import static org.example.Utils.Funcionalidad.*;
import static org.example.Utils.Messages.mostrarMensaje;

public class GestionEmpleado extends JFrame {

    public GestionEmpleado() {
        this.setTitle("Gestión Empleados");
        this.setSize(500, 370);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        configurarCierreVentana(this);

        JPanel panelBotonesCentro = getjPanelBotonesCentro();
        JPanel panelBotonRetorno = getPanelBotonRetorno(this, new GestionAfterLogin());

        this.add(panelBotonesCentro, BorderLayout.CENTER);
        this.add(panelBotonRetorno, BorderLayout.SOUTH);

    }

    private JPanel getjPanelBotonesCentro() {
        JPanel panelGestion = new JPanel(new GridLayout(3, 1, 15, 15));
        panelGestion.setBorder(BorderFactory.createEmptyBorder(50, 70, 20, 70));
        panelGestion.setBackground(COLOR_FONDO_GRIS_CLARO);

        JButton botonDarAlta = crearEstiloBoton("<html>Dar de alta <br> empleado</html>");
        botonDarAlta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Departamento> departamentos = obtenerDepartamentos();

                if (departamentos.isEmpty()) {
                    mostrarMensaje("⚠️ Debe dar de alta un departamento \n" +
                            "Para poder crear un empelado");
                    return;
                }

                new DarAltaEmpleado().setVisible(true);
                dispose();

            }
        });

        JButton botonModificar = crearEstiloBoton("<html>Modificar datos <br> empleado</html>");
        botonModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ModificarEmpleado().setVisible(true);
                dispose();
            }
        });

        JButton botonDarBaja = crearEstiloBoton("<html>Dar de baja <br> empleado</html>");
        botonDarBaja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EliminarEmpleado().setVisible(true);
                dispose();

            }
        });

        panelGestion.add(botonDarAlta);
        panelGestion.add(botonModificar);
        panelGestion.add(botonDarBaja);

        return panelGestion;
    }
}
