package org.example.Vista;

import org.example.Modelo.Departamento;
import org.example.Modelo.Empleados;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static org.example.ControladorDAO.DepartamentoDAO.obtenerDepartamentos;
import static org.example.ControladorDAO.EmpleadosDAO.*;
import static org.example.Utils.Funcionalidad.*;
import static org.example.Utils.Messages.mostrarMensaje;

public class EmpleadosSinDepartamento extends JFrame {
    public EmpleadosSinDepartamento() {
        this.setTitle("Eliminar Empleado");
        this.setSize(480, 430);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        configurarCierreVentana(this);

        JLabel introducirCliente = new JLabel("•Reasigne un departamento");
        introducirCliente.setFont(FUENTE_TITULO_2);
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 0));

        JPanel panelScrollPanel = getJPanelScrollPanel();
        //JPanel panelBotonRetorno = getPanelBotonRetorno(this, null);

        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(panelScrollPanel, BorderLayout.CENTER);
        //this.add(panelBotonRetorno, BorderLayout.SOUTH);
    }

    public JPanel getJPanelScrollPanel() {
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 15));

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));

        configurarListaEnScroll(LISTA_EMPLEADOS);

        LISTA_EMPLEADOS.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);


        JScrollPane jScrollPane = new JScrollPane(LISTA_EMPLEADOS);
        jScrollPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 5));

        MODEL_EMPLEADOS.removeAllElements();

        ArrayList<Empleados> empleados = mostrarEmpeladosSinDepto();
        for (Empleados e : empleados) {
            MODEL_EMPLEADOS.addElement(e);
        }

        JButton btnSeleccionEmple = crearEstiloBotonSubmit("SELECCIONAR EMPLEADO");
        btnSeleccionEmple.setPreferredSize(new Dimension(420, 45));

        btnSeleccionEmple.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Obtener empleados seleccionados
                List<Empleados> seleccionados = LISTA_EMPLEADOS.getSelectedValuesList();

                if (seleccionados.isEmpty()) {
                    mostrarMensaje("⚠️ Debes seleccionar al menos un empleado.");
                    return;
                }

                // Crear ventana emergente
                JDialog dialog = new JDialog((Frame) null, "Asignar departamento", true);
                dialog.setLayout(new BorderLayout());
                dialog.setSize(450, 120);
                dialog.setLocationRelativeTo(null);

                // ComboBox con departamentos
                JComboBox<Departamento> comboDeptos = new JComboBox<>();
                for (Departamento d : obtenerDepartamentos()) {
                    comboDeptos.addItem(d);
                }

                JButton btnAsignar = new JButton("Asignar");

                btnAsignar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        Departamento deptoSeleccionado = (Departamento) comboDeptos.getSelectedItem();

                        if (deptoSeleccionado == null) {
                            mostrarMensaje("⚠️ Seleccione una opción");
                            return;
                        }

                        // Asignar a todos los empleados seleccionados
                        for (Empleados emp : seleccionados) {
                            asignarEmpleadoADepartamento(emp, deptoSeleccionado);
                        }

                        JOptionPane.showMessageDialog(dialog,
                                "Departamento asignado a " + seleccionados.size() + " empleados.");

                        dialog.dispose();

                        if (saberSiNoHayEmpeladoEnDepartamento()) {
                            new EmpleadosSinDepartamento().setVisible(true);
                            dispose();

                        } else {
                            new GestionDepartamentos().setVisible(true);
                            dispose();
                        }
                    }
                });

                dialog.add(comboDeptos, BorderLayout.CENTER);
                dialog.add(btnAsignar, BorderLayout.SOUTH);

                dialog.setVisible(true);
            }
        });


        panelBoton.add(btnSeleccionEmple);

        panelPrincipal.add(jScrollPane, BorderLayout.CENTER);
        panelPrincipal.add(panelBoton, BorderLayout.SOUTH);

        return panelPrincipal;

    }
}
