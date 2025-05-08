package org.example.Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static org.example.Controlador.Conectar.connect;

public class InterfazDarAltaCliente extends JFrame {
    private static final Font FUENTE_TITULO = new Font("Arial", Font.BOLD, 25);
    private static final Font FUENTE_LABEL = new Font("Arial", Font.BOLD, 20);
    private static final Font FUENTE_CAMPOS = new Font("Arial", Font.PLAIN, 20);
    private static final Color COLOR_BOTONES = new Color(70, 130, 180);
    private static final Font FUENTE_BOTONES = new Font("Arial", Font.BOLD, 18);

    private final Map<String, JTextField> CAMPO_USUARIO = new HashMap<>();

    public InterfazDarAltaCliente() {
        this.setTitle("Formulario");
        this.setSize(420, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        /*
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new InterfazGestionaUsuario().setVisible(true);
            }
        });
        */
        JLabel introducirCliente = new JLabel("•Introduce Los Datos Del Cliente");
        introducirCliente.setFont(FUENTE_TITULO);
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(15, 5, 15, 0));

        JPanel panelDatosUsuario = getjPanelDatosUsuario();

        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(panelDatosUsuario);
    }

    private JPanel getjPanelDatosUsuario() {
        JPanel panelPrincipal = new JPanel(new BorderLayout());

        JPanel panelDatos = new JPanel();
        panelDatos.setLayout(new GridLayout(5, 1, 5, 5));

        panelDatos.add(crearFilaDatos("DNI: "));
        panelDatos.add(crearFilaDatos("Nombre: "));
        panelDatos.add(crearFilaDatos("Apellidos: "));
        panelDatos.add(crearFilaDatos("Dirección: "));
        panelDatos.add(crearFilaDatos("Teléfono: "));

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));

        JButton btnEnviar = crearEstiloBoton("Enviar");
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarDatosCliente();
            }
        });

        JButton btnEliminar = crearEstiloBoton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarFormulario();
            }
        });


        panelBotones.add(btnEnviar);
        panelBotones.add(btnEliminar);

        panelPrincipal.add(panelDatos, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        return panelPrincipal;
    }

    private JPanel crearFilaDatos(String texto) {
        JPanel fila = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 10));

        JLabel label = new JLabel(texto);
        label.setFont(FUENTE_LABEL);
        label.setPreferredSize(new Dimension(120, 30));

        JTextField field = new JTextField(15);
        field.setFont(FUENTE_CAMPOS);
        field.setPreferredSize(new Dimension(150, 30));

        String clave = texto.trim().replace(":", "").trim();
        CAMPO_USUARIO.put(clave, field);

        fila.add(label);
        fila.add(field);

        return fila;
    }

    private void enviarDatosCliente() {
        String dni = CAMPO_USUARIO.get("DNI").getText();
        String nombre = CAMPO_USUARIO.get("Nombre").getText();
        String apellidos = CAMPO_USUARIO.get("Apellidos").getText();
        String direccion = CAMPO_USUARIO.get("Dirección").getText();
        String telefono = CAMPO_USUARIO.get("Teléfono").getText();
        Date fechaActual = new Date(System.currentTimeMillis());

        if (dni.isEmpty() || nombre.isEmpty() || apellidos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "DNI, Nombre y Apellidos son campos obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!dni.matches("[0-9]{8}[A-Za-z]")){
            JOptionPane.showMessageDialog(this, "Formato de DNI invalido", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        try (Connection connection = connect();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO cliente (dni, nombre, apellidos, direccion, telefono, fechaDeAlta) VALUES (?, ?, ?, ?, ?, ?)")) {

            ps.setString(1, dni);
            ps.setString(2, nombre);
            ps.setString(3, apellidos);
            ps.setString(4, direccion);
            ps.setString(5, telefono);
            ps.setDate(6, fechaActual);

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas == 0) {
                JOptionPane.showMessageDialog(this, "Usuario registrado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                limpiarFormulario();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar los datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarFormulario() {
        for (JTextField field : CAMPO_USUARIO.values()) {
            field.setText("");
        }
    }


    private JButton crearEstiloBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(FUENTE_BOTONES);
        boton.setBackground(COLOR_BOTONES);
        boton.setFocusPainted(false);
        boton.setForeground(Color.WHITE);
        boton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        return boton;
    }


    public static void main(String[] args) {
        new InterfazDarAltaCliente().setVisible(true);
    }
}
