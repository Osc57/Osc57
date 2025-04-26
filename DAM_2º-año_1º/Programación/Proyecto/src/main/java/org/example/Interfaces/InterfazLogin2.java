package org.example.Interfaces;

import org.example.Clases.A;
import org.example.Clases.Recepcionista;
import org.example.Clases.Trabajador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import static org.example.BBDD.BBDD.connect;

public class InterfazLogin2 extends JFrame {

    private JList<Recepcionista> listaNombres;
    private DefaultListModel<Recepcionista> model;

    public InterfazLogin2() {
        this.setLayout(new GridLayout(3, 1));
        this.setTitle("Login");
        this.setSize(500, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        model = new DefaultListModel<>();
        listaNombres = new JList<>(model);
        listaNombres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane jScrollPane = new JScrollPane(listaNombres);

        JButton btnAcceder = getjButton();

        JPanel panelCentro = new JPanel(new BorderLayout());
        panelCentro.add(jScrollPane, BorderLayout.CENTER);
        panelCentro.add(btnAcceder, BorderLayout.SOUTH);

        this.add(panelCentro, BorderLayout.CENTER);

        cargarTrabajadores();
    }

    private JButton getjButton() {
        JButton btnAcceder = new JButton("Acceder");
        btnAcceder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Recepcionista recepcionistaSeleccionado = listaNombres.getSelectedValue();
                if (recepcionistaSeleccionado != null) {
                    JOptionPane.showMessageDialog(null,
                            "Has accedido como: " + recepcionistaSeleccionado.getNombre() + " " + recepcionistaSeleccionado.getApellidos());
                    updateRecepcionista(recepcionistaSeleccionado.getDni());

                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona un alumno primero.");
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
                try (PreparedStatement psInsert = connection.prepareStatement(
                        "INSERT INTO recepcionista (dni) VALUES (?)")) {
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

