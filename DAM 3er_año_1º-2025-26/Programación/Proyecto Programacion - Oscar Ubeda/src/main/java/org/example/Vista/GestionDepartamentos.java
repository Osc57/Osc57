package org.example.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.example.ControladorDAO.DepartamentoDAO.existenDepartamentos;
import static org.example.Utils.Funcionalidad.*;
import static org.example.Utils.Messages.mostrarMensaje;

public class GestionDepartamentos extends JFrame {

    public GestionDepartamentos() {
        this.setTitle("Gestión Departamento");
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

        JButton botonDarAlta = crearEstiloBoton("<html>Crear un <br> departamento</html>");
        botonDarAlta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CrearDepartamento().setVisible(true);
                dispose();
            }
        });

        JButton botonModificar = crearEstiloBoton("<html>Modificar un <br> departamento</html>");
        botonModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (existenDepartamentos()) {
                    new SeleccionDeptoModificar().setVisible(true);
                    dispose();
                } else {
                    mostrarMensaje("⚠️ No hay departamentos para modificar");
                }

            }
        });

        JButton botonDarBaja = crearEstiloBoton("<html>Eliminar un <br> departamento</html>");
        botonDarBaja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (existenDepartamentos()) {
                    new EliminarDepartamento().setVisible(true);
                    dispose();
                } else {
                    mostrarMensaje("⚠️ No hay departamentos para eliminar");
                }

            }
        });

        panelGestion.add(botonDarAlta);
        panelGestion.add(botonModificar);
        panelGestion.add(botonDarBaja);

        return panelGestion;
    }

    public static void main(String[] args) {
        new GestionDepartamentos().setVisible(true);
    }
}
