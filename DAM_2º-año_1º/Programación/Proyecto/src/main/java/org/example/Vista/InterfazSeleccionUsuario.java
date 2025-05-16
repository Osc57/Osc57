package org.example.Vista;

import org.example.Modelo.Recepcionista;

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

import static org.example.Controlador.ControladorRecepcionista.cargarTrabajadores;
import static org.example.Controlador.ControladorRecepcionista.updateRecepcionista;
import static org.example.Vista.InterfazLogin.*;

public class InterfazSeleccionUsuario extends JFrame {
    private final JList<Recepcionista> LISTA_NOMBRES;
    private final DefaultListModel<Recepcionista> MODEL_USUARIO;

    public InterfazSeleccionUsuario() {
        this.setTitle("Selección de Usuario");
        this.setSize(500, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        configurarCierreVentana(this);

        JPanel panelArriba = new JPanel();
        panelArriba.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        JLabel jLabel = new JLabel("SELECCIONE USUARIO");
        jLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panelArriba.add(jLabel);

        MODEL_USUARIO = new DefaultListModel<>();
        LISTA_NOMBRES = new JList<>(MODEL_USUARIO);
        LISTA_NOMBRES.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        LISTA_NOMBRES.setFont(new Font("Arial", Font.PLAIN, 18));
        LISTA_NOMBRES.setFixedCellHeight(35);
        LISTA_NOMBRES.setBackground(COLOR_FONDO_GRIS_CLARO);

        JScrollPane jScrollPane = new JScrollPane(LISTA_NOMBRES);
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

        ArrayList<Recepcionista> recepcionistas = cargarTrabajadores();
        for (Recepcionista r : recepcionistas) {
            MODEL_USUARIO.addElement(r);
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
                Recepcionista recepcionistaSeleccionado = LISTA_NOMBRES.getSelectedValue();
                if (recepcionistaSeleccionado != null) {
                    JOptionPane.showMessageDialog(null, "Has accedido como: " + recepcionistaSeleccionado.getNombre() + " " + recepcionistaSeleccionado.getApellidos());
                    controlRecepcionista(recepcionistaSeleccionado.getDni(), recepcionistaSeleccionado.getNombre(), recepcionistaSeleccionado.getApellidos());
                    updateRecepcionista(recepcionistaSeleccionado.getDni());
                    dispose();
                    new InterfazGestionaCliente().setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona a un trabajador");
                }
            }
        });
        return btnAcceder;
    }
    
    private void controlRecepcionista(String dni, String nombre, String apellidos) {
        DateTimeFormatter fechaLoggin = DateTimeFormatter.ofPattern("yyyy/MM/dd - HH:mm:ss");

        try (BufferedWriter registro = new BufferedWriter(new FileWriter("registroRecepcionista.txt", true))) {
            String linea = "[" + LocalDateTime.now().format(fechaLoggin) + "] " + "Recepcionista: " + nombre + " " + apellidos + " | " + "DNI: " + dni + "\n";

            registro.write(linea);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        InterfazSeleccionUsuario login = new InterfazSeleccionUsuario();
        login.setVisible(true);
    }

}





