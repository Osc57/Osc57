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

public class Login extends JFrame {
    protected static final Font FUENTE_TITULO = new Font("Arial", Font.BOLD, 42);
    protected static final Font FUENTE_TITULO_2 = new Font("Arial", Font.BOLD, 25);

    protected static final Color COLOR_FONDO_GRIS_CLARO = new Color(240, 240, 240);
    protected static final Color COLOR_BOTON_GRIS_CLARO = new Color(230, 230, 230);

    protected static final Color COLOR_BOTONES_AZUL = new Color(70, 130, 180);

    protected static final Font FUENTE_LABEL = new Font("Arial", Font.BOLD, 18);
    protected static final Font FUENTE_CAMPOS = new Font("Arial", Font.PLAIN, 16);
    protected static final Font FUENTE_EMOJI = new Font("Arial", Font.BOLD, 25);

    protected static final Font FUENTE_BOTON = new Font("Arial", Font.BOLD, 18);
    protected static final Font FUENTE_BOTONES = new Font("Arial", Font.BOLD, 18);

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

    public static void configurarCierreVentana(JFrame ventana) {
        ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(ventana, "¿Quiere cerrar sesión?", "Cerrar sesión",
                        JOptionPane.YES_NO_OPTION);

                if (respuesta == JOptionPane.YES_OPTION) {
                    ventana.dispose();
                    new Login().setVisible(true);
                }
            }
        });
    }


    public static void main(String[] args) {
        Login login = new Login();

        login.setVisible(true);
    }
}
