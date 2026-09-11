package org.example.Vista;

import org.example.Controlador.ControladorCita;
import org.example.Modelo.Cita;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static org.example.Controlador.ControladorCita.mostrarCitaCliente;
import static org.example.Vista.InterfazLogin.*;
import static org.example.Vista.InterfazLogin.COLOR_BOTONES_AZUL;
import static org.example.Vista.InterfazModificarCita.LISTA_NOMBRES_CITAS;
import static org.example.Vista.InterfazModificarCita.MODEL_USUARIO_CITAS;

public class InterfazEliminarCita extends JFrame {

    private static Cita citaSeleccionada = new Cita();

    public InterfazEliminarCita() {
        this.setTitle("Eliminar cita");
        this.setSize(460, 460);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        configurarCierreVentana(this);

        JLabel introducirCliente = new JLabel("•Seleccione cita para eliminar");
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

        JButton botonConfirmar = crearEstiloBoton("Eliminar Cita");
        botonConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarCita();
            }
        });

        MODEL_USUARIO_CITAS = new DefaultListModel<>();
        LISTA_NOMBRES_CITAS = new JList<>(MODEL_USUARIO_CITAS);

        LISTA_NOMBRES_CITAS.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        LISTA_NOMBRES_CITAS.setFont(new Font("Arial", Font.PLAIN, 18));
        LISTA_NOMBRES_CITAS.setFixedCellHeight(35);
        LISTA_NOMBRES_CITAS.setBackground(COLOR_FONDO_GRIS_CLARO);

        JScrollPane jScrollPane = new JScrollPane(LISTA_NOMBRES_CITAS);
        jScrollPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 10));

        String dniCliente = InterfazSeleccionEliminarCita.obtenerDNICliente();
        ArrayList<Cita> citas = mostrarCitaCliente(dniCliente);
        if (citas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Este cliente no tiene citas", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            for (Cita c : citas) {
                MODEL_USUARIO_CITAS.addElement(c);
            }
        }

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
                new InterfazSeleccionEliminarCita().setVisible(true);
                dispose();
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

    public void eliminarCita() {
        citaSeleccionada = LISTA_NOMBRES_CITAS.getSelectedValue();
        if (citaSeleccionada != null) {
            if (ControladorCita.eliminarCita(citaSeleccionada)) {
                JOptionPane.showMessageDialog(null, "Cita eliminada con exito");
                dispose();
                new InterfazGestionCita().setVisible(true);

            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar la cita", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Selecciona una cita");
        }
    }

}
