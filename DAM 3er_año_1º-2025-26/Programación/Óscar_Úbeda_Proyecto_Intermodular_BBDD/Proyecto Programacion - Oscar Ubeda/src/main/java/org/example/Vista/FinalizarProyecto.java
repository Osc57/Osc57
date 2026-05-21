package org.example.Vista;

import org.example.Modelo.Proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static org.example.ControladorDAO.ProyectosDAO.*;
import static org.example.Utils.Funcionalidad.*;
import static org.example.Utils.Messages.mostrarMensaje;

public class FinalizarProyecto extends JFrame {

    public FinalizarProyecto() {
        this.setTitle("Finalizar Proyecto");
        this.setSize(480, 430);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        configurarCierreVentana(this);

        JLabel introducirCliente = new JLabel("•Finalize un proyecto");
        introducirCliente.setFont(FUENTE_TITULO_2);
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 0));

        JPanel panelScrollPanel = getJPanelScrollPanel();
        JPanel panelBotonRetorno = getPanelBotonRetorno(this, new GestionProyectos());

        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(panelScrollPanel, BorderLayout.CENTER);
        this.add(panelBotonRetorno, BorderLayout.SOUTH);
    }

    private JPanel getJPanelScrollPanel(){
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 15));

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));

        configurarListaEnScroll(LIST_PROYECT);

        JScrollPane jScrollPane = new JScrollPane(LIST_PROYECT);
        jScrollPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 5));

        MODEL_PROYECT.removeAllElements();

        ArrayList<Proyecto> proyectos = mostrarProyectosSinFinalizar();
        for (Proyecto p : proyectos) {
            MODEL_PROYECT.addElement(p);
        }

        JButton btnSeleccionEmple = crearEstiloBotonSubmit("SELECCIONAR PROYECTO");
        btnSeleccionEmple.setPreferredSize(new Dimension(420, 45));

        btnSeleccionEmple.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Proyecto seleccionado = LIST_PROYECT.getSelectedValue();

                if (seleccionado == null) {
                    mostrarMensaje("⚠️ Seleccione una opción");
                    return;
                }

                Proyecto proyectoSeleccionado = new Proyecto(
                        seleccionado.getId(),
                        seleccionado.getNombre(),
                        seleccionado.getTipo(),
                        seleccionado.getPresupuesto(),
                        seleccionado.getFechaInicio(),
                        seleccionado.getFinalizado()
                );

                // 1. Contar empleados del proyecto
                int empleados = contarTrabajadoresProyecto(proyectoSeleccionado);

                // 2. Mensaje personalizado
                int respuesta = JOptionPane.showConfirmDialog(
                        null,
                        "⚠️ Hay " + empleados + " empleados trabajando en este proyecto.\n" +
                                "¿Desea finalizarlo igualmente?",
                        "Finalizar Proyecto",
                        JOptionPane.YES_NO_OPTION
                );

                if (respuesta == JOptionPane.YES_OPTION) {
                    // 3. Eliminar empleados del proyecto
                    boolean trabajadoresEliminados = eliminarTrabajadoresProyecto(proyectoSeleccionado);

                    // 4. Finalizar proyecto
                    boolean proyectoFinalizado = finalizarProyecto(proyectoSeleccionado);

                    if (proyectoFinalizado) {
                        mostrarMensaje("✅ Proyecto finalizado correctamente");

                        new GestionProyectos().setVisible(true);
                        dispose();

                    } else {
                        mostrarMensaje("❌ No se pudo finalizar el proyecto");
                    }
                }
            }

        });

        panelBoton.add(btnSeleccionEmple);

        panelPrincipal.add(jScrollPane, BorderLayout.CENTER);
        panelPrincipal.add(panelBoton, BorderLayout.SOUTH);

        return panelPrincipal;
    }
}
