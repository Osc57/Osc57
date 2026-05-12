package org.example.Vista;

import org.example.Modelo.Departamento;
import org.example.Modelo.Empleados;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static org.example.ControladorDAO.EmpleadosDAO.*;
import static org.example.Utils.Funcionalidad.*;
import static org.example.Utils.Messages.mostrarMensaje;

public class ModificarEmpleado extends JFrame {


    public ModificarEmpleado() {
        this.setTitle("Modificar Empleado");
        this.setSize(480, 460);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        configurarCierreVentana(this);

        JLabel introducirCliente = new JLabel("•Seleccione empleado a modificar");
        introducirCliente.setFont(FUENTE_TITULO_2);
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 0));

        JPanel panelScrollPanel = getJPanelScrollPanel();
        JPanel panelBotonRetorno = getPanelBotonRetorno(this, new GestionEmpleado());

        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(panelScrollPanel, BorderLayout.CENTER);
        this.add(panelBotonRetorno, BorderLayout.SOUTH);
    }

    private JPanel getJPanelScrollPanel() {
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 15));

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));

        configurarListaEnScroll(LISTA_EMPLEADOS);

        JScrollPane jScrollPane = new JScrollPane(LISTA_EMPLEADOS);
        jScrollPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 5));

        MODEL_EMPLEADOS.removeAllElements();

        ArrayList<Empleados> empleados = mostrarEmpleados();
        for (Empleados t : empleados) {
            MODEL_EMPLEADOS.addElement(t);
        }

        JButton btnSeleccionEmple = crearEstiloBotonSubmit("SELECCIONAR EMPLEADO");
        btnSeleccionEmple.setPreferredSize(new Dimension(420, 45));

        btnSeleccionEmple.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Empleados seleccionado = LISTA_EMPLEADOS.getSelectedValue();

                if (seleccionado == null) {
                    mostrarMensaje("⚠️ Seleccione una opción");
                    return;
                }

                Empleados empleadosSeleccionado = obtenerDatosEmpelado(seleccionado);

                dispose();
                if (seleccionarGerenteEmpleado(empleadosSeleccionado)) {
                    new ModificarGerente(empleadosSeleccionado).setVisible(true);
                } else {
                    new ModificarProgramador(seleccionado).setVisible(true);
                }
            }
        });

        panelBoton.add(btnSeleccionEmple);

        panelPrincipal.add(jScrollPane, BorderLayout.CENTER);
        panelPrincipal.add(panelBoton, BorderLayout.SOUTH);

        return panelPrincipal;
    }

    public static void main(String[] args) {
        new ModificarEmpleado().setVisible(true);
    }
}
