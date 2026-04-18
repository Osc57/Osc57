package org.example.Vista;

import org.example.Modelo.Usuarios;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static org.example.ControladorDAO.UsuariosDAO.combrobarUsuarios;
import static org.example.Utils.Componentes.*;

public class Login extends JFrame{

    public Login() {
        this.setTitle("Login");
        this.setSize(500, 370);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);

        JPanel jPanel = new JPanel();
        jPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(jPanel);
        jPanel.setLayout(null);

        JLabel textoLabel = new JLabel("LOGIN");
        textoLabel.setFont(FUENTE_TITULO);
        textoLabel.setBounds(0, 30, 500, 50);
        textoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jPanel.add(textoLabel);

        //======================================================================================================

        JLabel user = new JLabel("USUARIO:");
        user.setFont(FUENTE_LABEL);
        user.setBounds(50, 110, 150, 30);
        jPanel.add(user);

        JTextField jTextField = new JTextField();
        jTextField.setBounds(200, 110, 250, 35);
        jTextField.setFont(FUENTE_CAMPOS);
        jPanel.add(jTextField);

        //======================================================================================================

        JLabel passw = new JLabel("CONTRASEÑA:");
        passw.setFont(FUENTE_LABEL);
        passw.setBounds(50, 170, 150, 30);
        jPanel.add(passw);

        JPasswordField jPasswordField = new JPasswordField();

        jPasswordField.setBounds(200, 170, 250, 35);
        jPasswordField.setFont(FUENTE_CAMPOS);

        jPanel.add(jPasswordField);

        //======================================================================================================

        JButton btnInicioSes = new JButton("INICIAR SESIÓN");
        btnInicioSes.setFont(FUENTE_BOTON);
        jPanel.add(btnInicioSes);
        btnInicioSes.setBounds(250, 240, 200, 45);
        btnInicioSes.setBackground(COLOR_BOTONES_AZUL);
        btnInicioSes.setForeground(Color.WHITE);
        jPanel.add(btnInicioSes);

        btnInicioSes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = jTextField.getText();
                String password = new String(jPasswordField.getPassword()).trim();

                if (userName.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "⚠️ Rellena todos los campos");
                    return;
                }

                Usuarios usuarios = new Usuarios(userName, password);

                int resultado = combrobarUsuarios(usuarios);

                switch (resultado) {
                    case 0:
                        JOptionPane.showMessageDialog(null, "❌ El usuario no existe");
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null, "✅ Login Correcto");
                        dispose();
                        if (userName.equalsIgnoreCase("admin")) {
                            new GestionAfterLogin().setVisible(true);
                        } else {
                            new SacarDatosUsuarios().setVisible(true);
                        }
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "❌ Contraseña Incorrecta");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "⚠️ No se ha podido completar el inicio de sesión");
                }
            }
        });

        //======================================================================================================

        JButton btnRegistro = new JButton("REGISTRARSE");
        btnRegistro.setFont(FUENTE_BOTON);
        jPanel.add(btnRegistro);
        btnRegistro.setBounds(50, 240, 170, 45);
        btnRegistro.setBackground(COLOR_BOTONES_AZUL);
        btnRegistro.setForeground(Color.WHITE);
        jPanel.add(btnRegistro);

        btnRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new RegistroUser().setVisible(true);
            }
        });

    }



    public static void main(String[] args) {
        Login login = new Login();

        login.setVisible(true);
    }
}
