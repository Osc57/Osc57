package org.example.Interfaces;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazLogin1 extends JFrame {
    private String usuario = "Admin";
    private String password = "1234";
    private Font colortextoButton = new Font("Arial", Font.PLAIN, 18);
    private JPanel jPanel;
    private JTextField jTextField;
    private JButton jButton;
    private JPasswordField jPasswordField;

    public InterfazLogin1() {
        this.setTitle("Login");
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel = new JPanel();
        jPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(jPanel);
        jPanel.setLayout(null);

        JLabel textoLabel = new JLabel("LOGIN");
        textoLabel.setFont(new Font("Arial", Font.PLAIN, 40));
        textoLabel.setBounds(170, 20, 200, 50);
        jPanel.add(textoLabel);

        //--------------------------------------------------------------------------------------------------------------

        JLabel user = new JLabel("USUARIO:");
        user.setFont(new Font("Arial", Font.PLAIN, 20));
        user.setBounds(50, 100, 150, 30);
        jPanel.add(user);

        jTextField = new JTextField();
        jTextField.setBounds(200, 100, 200, 30);
        jPanel.add(jTextField);

        //--------------------------------------------------------------------------------------------------------------

        JLabel passw = new JLabel("CONTRASEÑA:");
        passw.setFont(new Font("Arial", Font.PLAIN, 20));
        passw.setBounds(50, 160, 150, 30);
        jPanel.add(passw);

        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(200, 160, 200, 30);
        jPanel.add(jPasswordField);

        //--------------------------------------------------------------------------------------------------------------

        jButton = new JButton("Iniciar sesión");
        jButton.setFont(colortextoButton);
        jButton.setBounds(150, 250, 180, 40);
        jPanel.add(jButton);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pass = new String(jPasswordField.getPassword());
                if (jTextField.getText().equalsIgnoreCase(usuario) && pass.equals(password)) {
                    JOptionPane.showMessageDialog(null, "Login Correcto");
                    InterfazLogin2 login2 = new InterfazLogin2();
                    login2.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Login Incorrecto");
                }
            }
        });
    }

    public static void main(String[] args) {
        InterfazLogin1 login1 = new InterfazLogin1();
        login1.setVisible(true);
    }
}
