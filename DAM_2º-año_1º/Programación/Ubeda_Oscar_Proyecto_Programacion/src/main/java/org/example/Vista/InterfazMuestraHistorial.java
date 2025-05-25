package org.example.Vista;

import org.example.Modelo.Cliente;
import org.example.Modelo.Historial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static org.example.Controlador.ControladorCliente.cargarClientes;
import static org.example.Controlador.ControladorHistorial.cargarHistorial;
import static org.example.Vista.InterfazLogin.*;

public class InterfazMuestraHistorial extends JFrame {

    private JList<Historial> LISTA_NOMBRES_HISTORIAL;
    private static DefaultListModel<Historial> MODEL_USUARIO_HISTORIAL;

    public InterfazMuestraHistorial(){
        this.setTitle("Historial");
        this.setSize(460, 460);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        configurarCierreVentana(this);

        JLabel introducirCliente = new JLabel("•Seleccione cliente o Filtre el DNI");
        introducirCliente.setFont(FUENTE_TITULO_2);
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 0));

        JPanel panelGestionDni = getjPanelGestionDni();
        JPanel panelBotonRetorno = getjPanelBotonRetorno();

        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(panelGestionDni, BorderLayout.CENTER);
        this.add(panelBotonRetorno, BorderLayout.SOUTH);
    }

    private JPanel getjPanelGestionDni() {
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 15));

        JPanel panelBoton = new JPanel(new GridLayout(1, 2, 10, 10));

        JButton botonConfirmar = crearEstiloBoton("Confirmar");
        botonConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //seleccionCliente();
            }
        });

        JButton botonFiltrar = crearEstiloBoton("Filtrar DNI");
        botonFiltrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InterfazFiltrarDNICliente().setVisible(true);
                dispose();
            }
        });

        MODEL_USUARIO_HISTORIAL = new DefaultListModel<>();
        LISTA_NOMBRES_HISTORIAL = new JList<>(MODEL_USUARIO_HISTORIAL);

        LISTA_NOMBRES_HISTORIAL.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        LISTA_NOMBRES_HISTORIAL.setFont(new Font("Arial", Font.PLAIN, 18));
        LISTA_NOMBRES_HISTORIAL.setFixedCellHeight(35);
        LISTA_NOMBRES_HISTORIAL.setBackground(COLOR_FONDO_GRIS_CLARO);

        JScrollPane jScrollPane = new JScrollPane(LISTA_NOMBRES_HISTORIAL);
        jScrollPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 10));

        String dniCliente = InterfazSeleccionHistorial.obtenerDNICliente();

        ArrayList<Historial> historiales = cargarHistorial(dniCliente);
        for (Historial h : historiales) {
            MODEL_USUARIO_HISTORIAL.addElement(h);
        }

        panelBoton.add(botonFiltrar);
        panelBoton.add(botonConfirmar);

        panelPrincipal.add(jScrollPane, BorderLayout.CENTER);
        panelPrincipal.add(panelBoton, BorderLayout.SOUTH);

        return panelPrincipal;

    }

    private JPanel getjPanelBotonRetorno() {
        JPanel panelBotonRetorno = new JPanel(new BorderLayout());
        JButton botonRetorno = new JButton("←");
        panelBotonRetorno.add(botonRetorno, BorderLayout.SOUTH);
        panelBotonRetorno.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 320));
        panelBotonRetorno.setBackground(COLOR_FONDO_GRIS_CLARO);

        botonRetorno.setFocusPainted(false);
        botonRetorno.setBackground(COLOR_BOTON_GRIS_CLARO);
        botonRetorno.setFont(FUENTE_EMOJI);

        botonRetorno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new InterfazSeleccionHistorial().setVisible(true);
            }
        });
        return panelBotonRetorno;
    }

    private JButton crearEstiloBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(FUENTE_BOTONES);
        boton.setBackground(COLOR_BOTONES_AZUL);
        boton.setFocusPainted(false);
        boton.setForeground(Color.WHITE);
        boton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        return boton;
    }

}
