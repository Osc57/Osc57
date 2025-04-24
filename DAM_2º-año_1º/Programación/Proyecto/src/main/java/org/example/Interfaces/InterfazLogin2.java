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

    private JList<A> listaNombres;
    private DefaultListModel<A> model;
    //private JList<Recepcionista> listaNombres;
    //private DefaultListModel<Recepcionista> model;

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

        cargarAlumnos();
    }

    private JButton getjButton() {
        JButton btnAcceder = new JButton("Acceder");
        btnAcceder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                A alumnoSeleccionado = listaNombres.getSelectedValue();
                if (alumnoSeleccionado != null) {//Aqui van los recepcionistas acuerdate
                    JOptionPane.showMessageDialog(null,
                            "Has accedido como: " + alumnoSeleccionado.getNombre() + " " + alumnoSeleccionado.getApellido());

                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona un alumno primero.");
                }
            }
        });
        return btnAcceder;
    }

    private void cargarAlumnos() {
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM alumno;")) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //Recepcionista trabajador = new Recepcionista();
                A a = new A();
                a.setId(resultSet.getInt("id"));
                a.setNombre(resultSet.getString("nombre"));
                a.setApellido(resultSet.getString("apellidos"));
                a.setDireccion(resultSet.getString("direccion"));

                model.addElement(a);
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

