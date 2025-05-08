package org.example.Interfaces;

import org.example.Clases.Jefe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.example.BBDD.BBDD.connect;

public class InterfazSeleccionJefe extends JFrame {
    private static final Color COLOR_FONDO_LISTA = new Color(240, 240, 240);
    private static final Color COLOR_BOTON_ACCEDER = new Color(70, 130, 180);
    private static final Color COLOR_TEXTO_BOTON = Color.WHITE;

    private final JList<Jefe> LISTA_NOMBRES_JEFE;
    private final DefaultListModel<Jefe> MODEL_JEFE;

    public InterfazSeleccionJefe() {
        this.setTitle("Selección de Admin");
        this.setSize(500, 450);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);

        JPanel panelArriba = new JPanel();
        panelArriba.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        JLabel jLabel = new JLabel("SELECCIONE JEFE");
        jLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panelArriba.add(jLabel);

        MODEL_JEFE = new DefaultListModel<>();
        LISTA_NOMBRES_JEFE = new JList<>(MODEL_JEFE);
        LISTA_NOMBRES_JEFE.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        LISTA_NOMBRES_JEFE.setFont(new Font("Arial", Font.PLAIN, 18));
        LISTA_NOMBRES_JEFE.setFixedCellHeight(35);
        LISTA_NOMBRES_JEFE.setBackground(COLOR_FONDO_LISTA);

        JScrollPane jScrollPane = new JScrollPane(LISTA_NOMBRES_JEFE);
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
                Jefe jefeSeleccionado = LISTA_NOMBRES_JEFE.getSelectedValue();
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


    public static void main(String[] args) {
        InterfazSeleccionJefe login = new InterfazSeleccionJefe();
        login.setVisible(true);
    }
}

