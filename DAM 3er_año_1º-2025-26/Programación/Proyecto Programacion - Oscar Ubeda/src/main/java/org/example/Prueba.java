package org.example;

import org.example.Modelo.Programador;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Prueba extends JFrame{

    private JPanel jPanel;
    private JTextField jTextField;
    private JButton jButton;
    private JPasswordField jPasswordField;

    public Prueba() {
        this.setTitle("Login");
        this.setSize(500, 370);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);

        jPanel = new JPanel();
        jPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(jPanel);
        jPanel.setLayout(null);

        JComboBox<String> combo = new JComboBox<>();
        combo.addItem("Opción 1");
        combo.addItem("Opción 2");
        combo.addItem("Otro");

        // IMPORTANTE: Definir posición y tamaño en Layout nulo
        combo.setBounds(50, 50, 200, 30);

        combo.addActionListener(e -> {
            // Obtenemos el objeto seleccionado
            Object seleccionado = combo.getSelectedItem();

            if ("Otro".equals(seleccionado)) {
                String nuevoValor = JOptionPane.showInputDialog(this, "Ingrese la nueva opción:");

                if (nuevoValor != null && !nuevoValor.trim().isEmpty()) {
                    // Insertar antes de la opción "Otro"
                    combo.insertItemAt(nuevoValor, combo.getItemCount() - 1);
                    combo.setSelectedItem(nuevoValor);
                } else {
                    // Si cancela, vuelve a la primera opción para evitar bucles
                    combo.setSelectedIndex(0);
                }
            }
        });

        jPanel.add(combo);
    }


    public static void main(String[] args) {
        Prueba prueba = new Prueba();

        prueba.setVisible(true);
    }
}
