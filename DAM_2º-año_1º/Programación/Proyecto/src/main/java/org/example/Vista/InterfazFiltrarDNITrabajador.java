package org.example.Vista;

import org.example.Modelo.Cliente;
import org.example.Modelo.Trabajador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static org.example.Controlador.ControladorJefe.*;
import static org.example.Vista.InterfazDarBajaTrabajador.LISTA_NOMBRES_TRABAJADORES;
import static org.example.Vista.InterfazDarBajaTrabajador.MODEL_USUARIO_TRABAJADORES;
import static org.example.Vista.InterfazLogin.*;

public class InterfazFiltrarDNITrabajador extends JFrame {

    private JTextField fieldDNI = new JTextField();

    public InterfazFiltrarDNITrabajador() {
        this.setTitle("Filtrar DNI");
        this.setSize(360, 240);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new InterfazDarBajaTrabajador().setVisible(true);
            }
        });


        JLabel tituloFiltrar = new JLabel("•Introduce un DNI");
        tituloFiltrar.setFont(FUENTE_TITULO_2);
        tituloFiltrar.setBorder(BorderFactory.createEmptyBorder(15, 60, 15, 0));

        JPanel panelDNI = getjPanelPanelDNI();

        this.add(tituloFiltrar, BorderLayout.NORTH);
        this.add(panelDNI);
    }

    private JPanel getjPanelPanelDNI() {
        JPanel panelGuardar = new JPanel(new BorderLayout());
        JPanel pField = new JPanel();

        JPanel pBoton = new JPanel(new GridLayout(1, 1));
        pBoton.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JButton bEnviar = crearEstiloBoton("Filtrar");
        bEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    if (fieldDNI.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Introduzca el DNI", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (!fieldDNI.getText().matches("[0-9]{8}[A-Za-z]")) {
                        JOptionPane.showMessageDialog(null, "DNI invalido. Debe tener 8 digitos y una letra", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (!comprobarDNITrabajador(fieldDNI.getText())) {
                        JOptionPane.showMessageDialog(null, "El DNI no se encuentra en el programa", "Error", JOptionPane.ERROR_MESSAGE);
                        limpiarCampos();
                    } else {
                        dispose();
                        listaDNITrabajadorFiltrado();
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al buscar al trabajador", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        });

        fieldDNI = crearFields();

        pField.add(fieldDNI);
        pBoton.add(bEnviar);

        panelGuardar.add(pField, BorderLayout.CENTER);
        panelGuardar.add(pBoton, BorderLayout.SOUTH);
        return panelGuardar;
    }

    private void listaDNITrabajadorFiltrado() {
        JDialog dialog = new JDialog(this, "Datos del Cliente", true);
        dialog.setSize(460, 200);
        dialog.setLocationRelativeTo(this);
        dialog.setResizable(false);

        Trabajador trabajador = cargarDniTrabajador(fieldDNI.getText());

        MODEL_USUARIO_TRABAJADORES = new DefaultListModel<>();

        LISTA_NOMBRES_TRABAJADORES = new JList<>(MODEL_USUARIO_TRABAJADORES);

        LISTA_NOMBRES_TRABAJADORES.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        LISTA_NOMBRES_TRABAJADORES.setFont(new Font("Arial", Font.PLAIN, 18));
        LISTA_NOMBRES_TRABAJADORES.setFixedCellHeight(35);
        LISTA_NOMBRES_TRABAJADORES.setBackground(COLOR_FONDO_GRIS_CLARO);

        MODEL_USUARIO_TRABAJADORES.addElement(trabajador);

        JButton btnEliminar = crearEstiloBoton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (seleccionCliente(dialog)) {
                    dialog.dispose();
                }
            }
        });

        JPanel panelContenido = new JPanel(new BorderLayout());
        panelContenido.add(new JScrollPane(LISTA_NOMBRES_TRABAJADORES), BorderLayout.CENTER);
        panelContenido.setBorder(BorderFactory.createEmptyBorder());

        JPanel panelBoton = new JPanel();
        panelBoton.add(btnEliminar);

        panelContenido.add(panelBoton, BorderLayout.SOUTH);
        dialog.add(panelContenido);

        dialog.setVisible(true);
    }

    private boolean seleccionCliente(JDialog d) {
        Trabajador trabajadorSeleccion = LISTA_NOMBRES_TRABAJADORES.getSelectedValue();

        if (trabajadorSeleccion == null) {
            JOptionPane.showMessageDialog(d, "Selecciona un trabajador de la lista", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        int confirmacion = JOptionPane.showConfirmDialog(d, "¿Quieres eliminar este trabajador?", "Eliminar trabajador", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            if (eliminarTrabajador(trabajadorSeleccion.getDni())) {
                JOptionPane.showMessageDialog(d, "Trabajador eliminado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                new InterfazDarBajaTrabajador().setVisible(true);
                return true;
            } else {
                JOptionPane.showMessageDialog(d, "Error al eliminar el trabajador", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return false;
    }

    private void limpiarCampos() {
        fieldDNI.setText("");

    }

    private JTextField crearFields() {
        JTextField field = new JTextField(15);
        field.setFont(FUENTE_CAMPOS);
        field.setPreferredSize(new Dimension(150, 30));

        return field;
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
        new InterfazFiltrarDNITrabajador().setVisible(true);
    }
}

