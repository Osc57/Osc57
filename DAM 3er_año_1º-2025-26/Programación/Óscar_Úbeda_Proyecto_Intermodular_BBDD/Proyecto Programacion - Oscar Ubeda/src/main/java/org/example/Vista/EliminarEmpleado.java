package org.example.Vista;

import org.example.Modelo.Empleados;
import org.example.Modelo.Gerente;
import org.example.Modelo.Programador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static org.example.ControladorDAO.EmpleadosDAO.*;
import static org.example.ControladorDAO.GerenteDAO.mostrarGerentes;
import static org.example.ControladorDAO.GerenteDAO.saberSiGerenteEstaEnProyecto;
import static org.example.ControladorDAO.ProgramadorDAO.mostrarProgramadores;
import static org.example.ControladorDAO.ProgramadorDAO.programadorTieneAsignaciones;
import static org.example.Utils.Funcionalidad.*;
import static org.example.Utils.Messages.mostrarMensaje;

public class EliminarEmpleado extends JFrame {

    public EliminarEmpleado() {
        this.setTitle("Eliminar Empleado");
        this.setSize(480, 460);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        configurarCierreVentana(this);

        JLabel introducirCliente = new JLabel("•De de baja a un empleado");
        introducirCliente.setFont(FUENTE_TITULO_2);
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 0));

        JPanel panelScrollPanel = getJPanelScrollPanel();
        JPanel panelBotonRetorno = getPanelBotonRetorno(this, new GestionEmpleado());

        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(panelScrollPanel, BorderLayout.CENTER);
        this.add(panelBotonRetorno, BorderLayout.SOUTH);
    }

    public JPanel getJPanelScrollPanel() {
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

                //Empleados empleados = new Empleados(seleccionado.getDni(), seleccionado.getNombre(), seleccionado.getApellidos(), seleccionado.getEmail(), seleccionado.getTelefono());

                String dni = seleccionado.getDni();

                boolean esGerente = seleccionarGerenteEmpleado(seleccionado);
                boolean esProgramador = seleccionarProgramadormpleado(seleccionado);

                // ============================================================
                // VALIDACIONES PARA GERENTE
                // ============================================================
                if (esGerente) {

                    // 1. ¿Es el último gerente?
                    if (mostrarGerentes().size() == 1) {
                        mostrarMensaje("⚠️ No puede eliminar al último gerente de la empresa.");
                        return;
                    }

                    // 2. ¿Está asignado a un proyecto?
                    Gerente gTemp = new Gerente();
                    gTemp.setDni(dni);

                    if (saberSiGerenteEstaEnProyecto(gTemp)) {
                        mostrarMensaje("⚠️ Este gerente está asignado a un proyecto.\nDebe reasignarlo antes de eliminarlo.");
                        return;
                    }

                    // 3. Confirmación
                    int respuesta = JOptionPane.showConfirmDialog(
                            null,
                            "⚠️ ¿Está seguro de que quiere eliminar a este GERENTE?",
                            "Eliminar Empleado",
                            JOptionPane.YES_NO_OPTION
                    );

                    if (respuesta == JOptionPane.YES_OPTION) {
                        if (eliminarEmpleado(seleccionado)) {
                            mostrarMensaje("✅ Gerente eliminado correctamente");
                            new GestionEmpleado().setVisible(true);
                            dispose();
                        } else {
                            mostrarMensaje("❌ Error al eliminar el gerente");
                        }
                    }

                    return; // IMPORTANTE
                }

                // ============================================================
                // VALIDACIONES PARA PROGRAMADOR
                // ============================================================
                if (esProgramador) {

                    // 1. ¿Es el último programador?
                    if (mostrarProgramadores().size() == 1) {
                        mostrarMensaje("⚠️ No puede eliminar al último programador de la empresa.");
                        return;
                    }

                    // 2. ¿Está asignado a un proyecto?
                    Programador pTemp = new Programador();
                    pTemp.setDni(dni);

                    if (programadorTieneAsignaciones(pTemp)) {
                        mostrarMensaje("⚠️ Este programador está asignado a un proyecto.\nDebe reasignarlo antes de eliminarlo.");
                        return;
                    }

                    // 3. Confirmación
                    int respuesta = JOptionPane.showConfirmDialog(
                            null,
                            "⚠️ ¿Está seguro de que quiere eliminar a este PROGRAMADOR?",
                            "Eliminar Empleado",
                            JOptionPane.YES_NO_OPTION
                    );

                    if (respuesta == JOptionPane.YES_OPTION) {
                        if (eliminarEmpleado(seleccionado)) {
                            mostrarMensaje("✅ Programador eliminado correctamente");
                            dispose();
                            new GestionEmpleado().setVisible(true);
                        } else {
                            mostrarMensaje("❌ Error al eliminar al programador");
                        }
                    }

                    return;
                }

                // ============================================================
                // SI LLEGA AQUÍ → EL EMPLEADO NO ES NI GERENTE NI PROGRAMADOR
                // ============================================================
                mostrarMensaje("⚠️ Este empleado no tiene rol asignado (ni gerente ni programador).");
            }
        });


        panelBoton.add(btnSeleccionEmple);

        panelPrincipal.add(jScrollPane, BorderLayout.CENTER);
        panelPrincipal.add(panelBoton, BorderLayout.SOUTH);

        return panelPrincipal;
    }
}

