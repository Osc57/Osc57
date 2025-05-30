package org.example.Vista;

import org.example.Modelo.Jefe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static org.example.Controlador.ControladorJefe.cargarJefe;
import static org.example.Vista.InterfazLogin.*;

public class InterfazSeleccionJefe extends JFrame {
    private final JList<Jefe> LISTA_NOMBRES_JEFE;

    protected static Jefe jefeSeleccionado = new Jefe();

    public InterfazSeleccionJefe() {
        this.setTitle("Selección de Admin");
        this.setSize(500, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        configurarCierreVentana(this);

        JPanel panelArriba = new JPanel();
        panelArriba.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        JLabel jLabel = new JLabel("SELECCIONE JEFE");
        jLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panelArriba.add(jLabel);

        DefaultListModel<Jefe> MODEL_JEFE = new DefaultListModel<>();
        LISTA_NOMBRES_JEFE = new JList<>(MODEL_JEFE);
        LISTA_NOMBRES_JEFE.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        LISTA_NOMBRES_JEFE.setFont(new Font("Arial", Font.PLAIN, 18));
        LISTA_NOMBRES_JEFE.setFixedCellHeight(35);
        LISTA_NOMBRES_JEFE.setBackground(COLOR_FONDO_GRIS_CLARO);

        JScrollPane jScrollPane = new JScrollPane(LISTA_NOMBRES_JEFE);
        jScrollPane.setBorder(BorderFactory.createEmptyBorder());

        JButton btnAcceder = botonAcceder();
        btnAcceder.setFont(new Font("Arial", Font.BOLD, 16));
        btnAcceder.setBackground(COLOR_BOTONES_AZUL);
        btnAcceder.setForeground(COLOR_TEXTO_BOTON);

        JPanel panelCentro = new JPanel(new BorderLayout());
        panelCentro.add(jScrollPane, BorderLayout.CENTER);
        panelCentro.add(btnAcceder, BorderLayout.SOUTH);
        panelCentro.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));

        this.add(panelArriba, BorderLayout.NORTH);
        this.add(panelCentro, BorderLayout.CENTER);

        ArrayList<Jefe> jefes = cargarJefe();
        for (Jefe j : jefes){
            MODEL_JEFE.addElement(j);
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    private JButton botonAcceder() {
        JButton btnAcceder = new JButton("ACCEDER");
        btnAcceder.setFont(new Font("Arial", Font.BOLD, 50));
        btnAcceder.setPreferredSize(new Dimension(200, 50));
        btnAcceder.setMinimumSize(new Dimension(200, 50));
        btnAcceder.setMaximumSize(new Dimension(200, 50));

        btnAcceder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jefeSeleccionado = LISTA_NOMBRES_JEFE.getSelectedValue();
                if (jefeSeleccionado != null) {
                    JOptionPane.showMessageDialog(null, "Has accedido como: " + jefeSeleccionado.getNombre() + " " + jefeSeleccionado.getApellidos());
                    controlJefe(jefeSeleccionado.getDni(), jefeSeleccionado.getNombre(), jefeSeleccionado.getApellidos());
                    new InterfazGestionJefe().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona jefe");
                }
            }
        });
        return btnAcceder;
    }

    private void controlJefe(String dni, String nombre, String apellidos) {
        DateTimeFormatter fechaLoggin = DateTimeFormatter.ofPattern("yyyy/MM/dd - HH:mm:ss");

        try (BufferedWriter registro = new BufferedWriter(new FileWriter("registroJefe.txt", true))) {
            String linea = "[" + LocalDateTime.now().format(fechaLoggin) + "] " + "Jefe: " + nombre + " " + apellidos + " | " + "DNI: " + dni + "\n";

            registro.write(linea);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String obtenerDNIJefe(){
        if (jefeSeleccionado != null){
            return jefeSeleccionado.getDni();
        }else {
            return "";
        }
    }
}

