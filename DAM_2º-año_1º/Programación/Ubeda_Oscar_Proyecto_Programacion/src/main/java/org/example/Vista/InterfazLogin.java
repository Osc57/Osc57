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

import static org.example.Controlador.ControladorJefe.comprobarLogginAdmin;
import static org.example.Controlador.ControladorRecepcionista.comprobarLogginRecepcionista;
import static org.example.Controlador.ControladorRecepcionista.updateRecepcionista;
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
        jPasswordField.setBounds(200, 170, 250, 35);//Le doy tamaño
        jPasswordField.setFont(FUENTE_CAMPOS);
        jPanel.add(jPasswordField);//Lo añado al panel

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
                String pass = new String(jPasswordField.getPassword());
                String user = jTextField.getText();

                if (user.equalsIgnoreCase("admin")) {
                    if (comprobarLogginAdmin(user, pass)) {
                        JOptionPane.showMessageDialog(null, "✅ Login Correcto ✅");
                        dispose();
                        new InterfazGestionJefe().setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "⚠ Contraseña Incorrecta ⚠");
                    }
                } else if (comprobarLogginRecepcionista(user, pass)) {
                    Trabajador trabajador = resgistroTrabajador(user);
                    updateRecepcionista(trabajador.getDni());
                    controlTrabajadores(trabajador.getDni(),trabajador.getNombre(),trabajador.getApellidos());

                    JOptionPane.showMessageDialog(null, "✅ Login Correcto ✅");
                    dispose();
                    new InterfazGestionaCliente().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "⚠ Usuario o Contraseña Incorrectos ⚠");
                }

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
}








