package org.example.Vista;

import org.example.Modelo.Trabajador;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import static org.example.Controlador.ControladorJefe.comprobarLogginAdmin;
import static org.example.Controlador.ControladorRecepcionista.comprobarLogginRecepcionista;
import static org.example.Controlador.ControladorRecepcionista.updateRecepcionista;
import static org.example.Controlador.ControladorTrabajador.esPrimerLogin;
import static org.example.Controlador.ControladorTrabajador.resgistroTrabajador;

public class InterfazLogin extends JFrame {//Extiendo JFrame para ya tener un frame directamente y no tener que ir creandome un frame cade vez
    protected static final Font FUENTE_TITULO = new Font("Arial", Font.BOLD, 42);
    protected static final Font FUENTE_TITULO_2 = new Font("Arial", Font.BOLD, 25);

    protected static final Color COLOR_FONDO_GRIS_CLARO = new Color(240, 240, 240);
    protected static final Color COLOR_BOTON_GRIS_CLARO = new Color(230, 230, 230);

    protected static final Color COLOR_BOTONES_AZUL = new Color(70, 130, 180);
    protected static final Color COLOR_TEXTO_BOTON = Color.WHITE;

    protected static final Font FUENTE_LABEL = new Font("Arial", Font.BOLD, 18);
    protected static final Font FUENTE_CAMPOS = new Font("Arial", Font.PLAIN, 16);
    protected static final Font FUENTE_EMOJI = new Font("Arial", Font.BOLD, 25);

    protected static final Font FUENTE_BOTON = new Font("Arial", Font.BOLD, 18);
    protected static final Font FUENTE_BOTONES = new Font("Arial", Font.BOLD, 18);

    private JPanel jPanel;
    private JTextField jTextField;
    private JButton jButton;
    private JPasswordField jPasswordField;

    private static Trabajador trabajadorLoggin = new Trabajador();

    public InterfazLogin() {
        this.setTitle("Login");
        this.setSize(500, 370);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);

        jPanel = new JPanel();
        jPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(jPanel);
        jPanel.setLayout(null);

        JLabel textoLabel = new JLabel("LOGIN");//Label del login
        textoLabel.setFont(FUENTE_TITULO);//Le doy un estilo a la letra
        textoLabel.setBounds(0, 30, 500, 50);//Le doy un tamaño a esta
        textoLabel.setHorizontalAlignment(SwingConstants.CENTER);//Centro el texto
        jPanel.add(textoLabel);//La añado al panel

//--------------------------------------------------------------------------------------------------------------

        JLabel user = new JLabel("USUARIO:");//Label de usuario
        user.setFont(FUENTE_LABEL);
        user.setBounds(50, 110, 150, 30);//Muevo y ajusto el label
        jPanel.add(user);//Lo añado al panel

        jTextField = new JTextField();//Me genero el jtextfield
        jTextField.setBounds(200, 110, 250, 35);//Le doy tamaño
        jTextField.setFont(FUENTE_CAMPOS);
        jPanel.add(jTextField);//Lo añado al panel

//--------------------------------------------------------------------------------------------------------------

        JLabel passw = new JLabel("CONTRASEÑA:");//Label de contraseña
        passw.setFont(FUENTE_LABEL);
        passw.setBounds(50, 170, 150, 30);//Muevo y ajusto el label
        jPanel.add(passw);

        jPasswordField = new JPasswordField();//Me genero el jtextfield de contraseña
        JPanel passwordPanel = crearPasswordFieldConToggle(jPasswordField);

        passwordPanel.setBounds(200, 170, 250, 35);//Le doy tamaño
        passwordPanel.setFont(FUENTE_CAMPOS);
        jPanel.add(passwordPanel);
//--------------------------------------------------------------------------------------------------------------

        jButton = new JButton("INICIAR SESIÓN");//Me genero el botón
        jButton.setFont(FUENTE_BOTON);
        jButton.setBounds(150, 250, 200, 45);//Selecciono tamaño y ubicación del botón
        jButton.setBackground(COLOR_BOTONES_AZUL);//Color azul para el botón
        jButton.setForeground(Color.WHITE);//Texto blanco
        jPanel.add(jButton);//Lo añado al panel

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dni = jTextField.getText();
                String pass = new String(jPasswordField.getPassword());

                if (dni.equalsIgnoreCase("admin")) {
                    if (comprobarLogginAdmin(dni, pass)) {
                        JOptionPane.showMessageDialog(null, "✅ Login Correcto ✅");
                        dispose();
                        new InterfazGestionJefe().setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "⚠ Contraseña Incorrecta ⚠");
                    }
                } else {
                    // Lógica para trabajador
                    trabajadorLoggin = resgistroTrabajador(dni);

                    if (trabajadorLoggin != null && comprobarLogginRecepcionista(dni, pass)) {
                        if (esPrimerLogin(trabajadorLoggin)) {
                            // Primer login - obligar a cambiar contraseña
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Debes cambiar tu contraseña antes de continuar",
                                    "Cambio requerido",
                                    JOptionPane.INFORMATION_MESSAGE
                            );
                            dispose();
                            new InterfazCambiarContrasenaTrabajador().setVisible(true);
                        } else {
                            // Login normal
                            updateRecepcionista(trabajadorLoggin.getDni());
                            controlTrabajadores(trabajadorLoggin.getDni(), trabajadorLoggin.getNombre(), trabajadorLoggin.getApellidos());
                            JOptionPane.showMessageDialog(null, "✅ Login Correcto ✅");
                            dispose();
                            new InterfazGestionaCliente().setVisible(true);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "⚠ Usuario o Contraseña Incorrectos ⚠");
                    }
                }
            }
        });

    }

    private JPanel crearPasswordFieldConToggle(JPasswordField passwordField) {
        JPanel panel = new JPanel(new BorderLayout());
        passwordField.setFont(FUENTE_CAMPOS);
        passwordField.setPreferredSize(new Dimension(150, 30));
        passwordField.setEchoChar('•');

        panel.add(passwordField, BorderLayout.CENTER);

        // Botón de toggle con mejor estilo
        JButton toggleButton = new JButton("👁");
        toggleButton.setPreferredSize(new Dimension(30, 30));
        toggleButton.setMargin(new Insets(0, 0, 0, 0));
        toggleButton.setToolTipText("Mostrar contraseña");
        toggleButton.setFocusPainted(false);
        toggleButton.setBorderPainted(true);
        toggleButton.setContentAreaFilled(false);
        toggleButton.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));

        toggleButton.addActionListener(e -> {
            if (passwordField.getEchoChar() == (char)0) {
                passwordField.setEchoChar('•');
                toggleButton.setText("👁");
                toggleButton.setToolTipText("Mostrar contraseña");
            } else {
                passwordField.setEchoChar((char)0);
                toggleButton.setText("👁");
                toggleButton.setToolTipText("Ocultar contraseña");
            }
        });

        panel.add(toggleButton, BorderLayout.EAST);
        return panel;
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
                    new InterfazLogin().setVisible(true);
                }
            }
        });
    }

    private void controlTrabajadores(String dni, String nombre, String apellidos) {
        DateTimeFormatter fechaLoggin = DateTimeFormatter.ofPattern("yyyy/MM/dd - HH:mm:ss");

        try (BufferedWriter registro = new BufferedWriter(new FileWriter("registroTrabajadores.txt", true))) {
            String linea = "[" + LocalDateTime.now().format(fechaLoggin) + "] " + "Trabajador: " + nombre + " " + apellidos + " | " + "DNI: " + dni + "\n";

            registro.write(linea);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String obtenerTrabajador() {
        if (trabajadorLoggin == null) {
            JOptionPane.showMessageDialog(null,
                    "No hay trabajador logueado",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return trabajadorLoggin.getDni();
    }
}








