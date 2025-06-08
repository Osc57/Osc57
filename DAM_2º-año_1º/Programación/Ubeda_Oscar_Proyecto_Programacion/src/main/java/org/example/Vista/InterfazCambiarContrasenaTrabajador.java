package org.example.Vista;

import org.example.Modelo.Trabajador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import static org.example.Controlador.ControladorJefe.cambiarContrasena;
import static org.example.Controlador.ControladorJefe.verificarContrasenaActual;
import static org.example.Controlador.ControladorTrabajador.actualizarPrimerLoginEnBD;
import static org.example.Vista.InterfazLogin.*;

public class InterfazCambiarContrasenaTrabajador extends JFrame {

    JPasswordField pwdActual = new JPasswordField();
    JPasswordField pwdNueva = new JPasswordField();
    JPasswordField pwdConfirmar = new JPasswordField();

    public InterfazCambiarContrasenaTrabajador() {
        this.setTitle("Cambiar Contraseña");
        this.setSize(480, 460);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        configurarCierreVentana(this);

        JLabel introducirCliente = new JLabel("•Introduzca la contraseña");
        introducirCliente.setFont(FUENTE_TITULO_2);
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 0));

        JPanel panelCambiarContrasena = getjPanelCambiarContrasena();

        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(panelCambiarContrasena, BorderLayout.CENTER);
    }

    private JPanel getjPanelCambiarContrasena() {
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panelCampos = new JPanel(new GridLayout(3, 2, 5, 5));

        JPanel panelBoton = new JPanel(new GridLayout(1, 2, 10, 10));

        // Fila 1: Contraseña actual
        panelCampos.add(crearLabels("Contraseña actual:"));
        panelCampos.add(crearPasswordFieldConToggle(pwdActual));

        // Fila 2: Nueva contraseña
        panelCampos.add(crearLabels("Nueva contraseña:"));
        panelCampos.add(crearPasswordFieldConToggle(pwdNueva));

        // Fila 3: Confirmar contraseña
        panelCampos.add(crearLabels("Confirmar contraseña:"));
        panelCampos.add(crearPasswordFieldConToggle(pwdConfirmar));

        // Botón con validación
        JButton btnCambiar = crearEstiloBoton("Cambiar Contraseña");
        btnCambiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarPassword();
            }
        });

        panelPrincipal.add(panelCampos, BorderLayout.CENTER);


        panelBoton.add(btnCambiar);

        panelPrincipal.add(panelBoton, BorderLayout.SOUTH);

        return panelPrincipal;
    }

    // Nuevo método para crear el campo de contraseña con toggle
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

    private void verificarPassword() {
        String dniTrabajador = InterfazLogin.obtenerTrabajador();
        String passwordActual = new String(pwdActual.getPassword());
        String nuevaPassword = new String(pwdNueva.getPassword());
        String confirmarPassword = new String(pwdConfirmar.getPassword());

        Trabajador trabajador = new Trabajador();
        trabajador.setDni(dniTrabajador);

        // Validaciones en cascada con else if para mayor eficiencia
        if (passwordActual.isEmpty() || nuevaPassword.isEmpty() || confirmarPassword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!nuevaPassword.equals(confirmarPassword)) {
            JOptionPane.showMessageDialog(null, "Las contraseñas nuevas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (nuevaPassword.equals(passwordActual)) {
            JOptionPane.showMessageDialog(null, "La nueva contraseña debe ser diferente a la actual", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!cumpleRequisitosContrasena(nuevaPassword)) {
            JOptionPane.showMessageDialog(null, "La contraseña no cumple con los requisitos mínimos:\n"
                    + "- Mínimo 8 caracteres\n"
                    + "- Al menos un número\n"
                    + "- Al menos una mayúscula\n"
                    + "- Al menos un carácter especial", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Si pasó todas las validaciones, proceder con la verificación en BD
            if (verificarContrasenaActual(trabajador, passwordActual)) {
                if (cambiarContrasena(trabajador, nuevaPassword)) {
                    trabajador.setPrimerLogin(false);
                    actualizarPrimerLoginEnBD(trabajador);
                    JOptionPane.showMessageDialog(null, "Contraseña cambiada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    new InterfazGestionaCliente().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al cambiar la contraseña", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña actual incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean cumpleRequisitosContrasena(String password) {
        // Verificar longitud mínima primero (requisito más simple y rápido de comprobar)
        if (password.length() < 8) {
            return false;
        }
        // Verificar al menos un número
        else if (!password.matches(".*\\d.*")) {
            return false;
        }
        // Verificar al menos una mayúscula
        else if (!password.matches(".*[A-Z].*")) {
            return false;
        }
        // Verificar al menos un carácter especial
        else if (!password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
            return false;
        }

        // Si pasó todas las validaciones
        return true;
    }

    private JLabel crearLabels(String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(FUENTE_LABEL);
        label.setPreferredSize(new Dimension(120, 30));

        return label;
    }


    private JButton crearEstiloBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(FUENTE_BOTONES);
        boton.setBackground(COLOR_BOTONES_AZUL);
        boton.setFocusPainted(false);
        boton.setForeground(Color.WHITE);
        boton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        return boton;
    }

    public static void main(String[] args) {
        new InterfazCambiarContrasenaTrabajador().setVisible(true);
    }
}
