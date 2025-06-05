package org.example.Vista;

import org.example.Modelo.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.example.Vista.InterfazLogin.*;

public class InterfazGestionJefe extends JFrame {

    private String jefeSeleccionado;

    public InterfazGestionJefe() {
        this.setTitle("Administrador");
        this.setSize(500, 350);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        configurarCierreVentana(this);

        JLabel titulo = new JLabel("Gestiona a los Trabajadores");
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 23, 20, 0));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(FUENTE_TITULO_2);

        JPanel panelBotonesCentro = getjPanelBotonesCentro();

        this.add(titulo, BorderLayout.NORTH);
        this.add(panelBotonesCentro, BorderLayout.CENTER);

    }

    private JPanel getjPanelBotonesCentro() {
        JPanel panelBotonesCentro = new JPanel(new GridLayout(1, 3, 20, 0));
        panelBotonesCentro.setBorder(BorderFactory.createEmptyBorder(20, 40, 80, 40));

        JButton darAlta = crearEstiloBoton("Dar Alta");
        darAlta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new InterfazDarAltaTrabajador().setVisible(true);
            }
        });

        JButton editarTrabajador = crearEstiloBoton("<html>Editar <br> Trabajador </html>");

        JButton darBaja = crearEstiloBoton("Dar Baja");
        darBaja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new InterfazDarBajaTrabajador().setVisible(true);
            }
        });

        panelBotonesCentro.add(darAlta);
        panelBotonesCentro.add(editarTrabajador);
        panelBotonesCentro.add(darBaja);
        return panelBotonesCentro;
    }

    private JButton crearEstiloBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(FUENTE_BOTONES);
        boton.setBackground(COLOR_BOTON_GRIS_CLARO);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        return boton;
    }

    public static void main(String[] args) {
        new InterfazGestionJefe().setVisible(true);
    }
}
