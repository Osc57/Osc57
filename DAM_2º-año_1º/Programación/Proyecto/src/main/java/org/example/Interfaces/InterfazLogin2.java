package org.example.Interfaces;

import org.example.Clases.Recepcionista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import static org.example.BBDD.BBDD.connect;

public class InterfazLogin2 extends JFrame {
    private static final Color COLOR_FONDO_LISTA = new Color(240, 240, 240);
    private static final Color COLOR_BOTON_ACCEDER = new Color(70, 130, 180);
    private static final Color COLOR_TEXTO_BOTON = Color.WHITE;

    private JList<Recepcionista> listaNombres;
    private DefaultListModel<Recepcionista> model;

    public InterfazLogin2() {
        this.setTitle("Selección de Usuario - Clínica Dental");
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(0, 10));

        JPanel panelArriba = new JPanel();
        panelArriba.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        JLabel jLabel = new JLabel("SELECCIONE USUARIO");
        jLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panelArriba.add(jLabel);

        model = new DefaultListModel<>();
        listaNombres = new JList<>(model);
        listaNombres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaNombres.setFont(new Font("Arial", Font.PLAIN, 18));
        listaNombres.setFixedCellHeight(35);
        listaNombres.setBackground(COLOR_FONDO_LISTA);

        JScrollPane jScrollPane = new JScrollPane(listaNombres);
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

        cargarTrabajadores();
    }

    private JButton botonAcceder() {
        JButton btnAcceder = new JButton("ACCEDER");
        btnAcceder.setFont(new Font("Arial", Font.BOLD, 50));
        btnAcceder.setPreferredSize(new Dimension(200, 50));
        btnAcceder.setMinimumSize(new Dimension(200, 50));
        btnAcceder.setMaximumSize(new Dimension(200, 50));

        btnAcceder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Recepcionista recepcionistaSeleccionado = listaNombres.getSelectedValue();
                if (recepcionistaSeleccionado != null) {
                    JOptionPane.showMessageDialog(null, "Has accedido como: " + recepcionistaSeleccionado.getNombre() + " " + recepcionistaSeleccionado.getApellidos());
                    updateRecepcionista(recepcionistaSeleccionado.getDni());
                    dispose();
                    InterfazGestiona interfazGestiona = new InterfazGestiona();
                    interfazGestiona.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona a un trabajador");
                }
            }
        });
        return btnAcceder;
    }

    private void updateRecepcionista(String documento) {
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE recepcionista SET dni = ?")) {

            preparedStatement.setString(1, documento);
            int filas = preparedStatement.executeUpdate();

            if (filas == 0) {
                try (PreparedStatement psInsert = connection.prepareStatement("INSERT INTO recepcionista (dni) VALUES (?)")) {
                    psInsert.setString(1, documento);
                    psInsert.executeUpdate();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void cargarTrabajadores() {
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM trabajadores;")) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Recepcionista trabajador = new Recepcionista();
                trabajador.setDni(resultSet.getString("dni"));
                trabajador.setNombre(resultSet.getString("nombre"));
                trabajador.setApellidos(resultSet.getString("apellidos"));
                trabajador.setTelefono(resultSet.getInt("telefono"));

                model.addElement(trabajador);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        InterfazLogin2 login = new InterfazLogin2();
        login.setVisible(true);
    }
}

