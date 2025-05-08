package org.example.Vista;

import org.example.Modelo.Recepcionista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.example.Controlador.Conexion.connect;
import static org.example.Controlador.ControladorRecepcionista.cargarTrabajadores;

public class InterfazSeleccionUsuario extends JFrame {
    private static final Color COLOR_FONDO_LISTA = new Color(240, 240, 240);
    private static final Color COLOR_BOTON_ACCEDER = new Color(70, 130, 180);
    private static final Color COLOR_TEXTO_BOTON = Color.WHITE;

    private final JList<Recepcionista> LISTA_NOMBRES;
    private final DefaultListModel<Recepcionista> MODEL;

    public InterfazSeleccionUsuario() {
        this.setTitle("Selección de Usuario");
        this.setSize(500, 450);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);

        JPanel panelArriba = new JPanel();
        panelArriba.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        JLabel jLabel = new JLabel("SELECCIONE USUARIO");
        jLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panelArriba.add(jLabel);

        MODEL = new DefaultListModel<>();
        LISTA_NOMBRES = new JList<>(MODEL);
        LISTA_NOMBRES.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        LISTA_NOMBRES.setFont(new Font("Arial", Font.PLAIN, 18));
        LISTA_NOMBRES.setFixedCellHeight(35);
        LISTA_NOMBRES.setBackground(COLOR_FONDO_LISTA);

        JScrollPane jScrollPane = new JScrollPane(LISTA_NOMBRES);
        jScrollPane.setBorder(BorderFactory.createEmptyBorder());

        JButton btnAcceder = botonAcceder();
        btnAcceder.setFont(new Font("Arial", Font.BOLD, 16));
        btnAcceder.setBackground(COLOR_BOTON_ACCEDER);
        btnAcceder.setForeground(COLOR_TEXTO_BOTON);

        JPanel panelCentro = new JPanel(new BorderLayout());
        panelCentro.add(jScrollPane, BorderLayout.CENTER);
        panelCentro.add(btnAcceder, BorderLayout.SOUTH);
        panelCentro.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));

        this.add(panelArriba, BorderLayout.NORTH);
        this.add(panelCentro, BorderLayout.CENTER);

        MODEL.addElement(cargarTrabajadores());
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
                    //updateRecepcionista(recepcionistaSeleccionado.getDni());
                    controlRecepcionista(recepcionistaSeleccionado.getDni(), recepcionistaSeleccionado.getNombre(), recepcionistaSeleccionado.getApellidos());
                    new InterfazGestionaUsuario().setVisible(true);
                    dispose();

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





