package org.example.Vista;

import org.example.Modelo.Programador;
import org.example.Modelo.Proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import static org.example.ControladorDAO.ProgramadorDAO.*;
import static org.example.Utils.Funcionalidad.*;
import static org.example.Utils.Messages.mostrarMensaje;

public class AsignarProgramador extends JFrame {

    private Proyecto proyecto;

    public AsignarProgramador(Proyecto proyect) {
        this.proyecto = proyect;

        this.setTitle("Seleccione Programador");
        this.setSize(575, 460);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mostrarMensaje("⚠️ Debes completar la asignación antes de cerrar esta ventana.");
            }
        });

        JLabel introducirCliente = new JLabel("•Seleccione programadores para el proyecto");
        introducirCliente.setFont(FUENTE_TITULO_2);
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 0));

        JPanel panelScrollPanel = getJPanelScrollPanel();
        //JPanel panelBotonRetorno = getPanelBotonRetorno(this, new GestionEmpleado());

        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(panelScrollPanel, BorderLayout.CENTER);
        //this.add(panelBotonRetorno, BorderLayout.SOUTH);
    }

    private JPanel getJPanelScrollPanel() {
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 15));

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));

        configurarListaEnScroll(LISTA_PROGRAM);

        LISTA_PROGRAM.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        JScrollPane jScrollPane = new JScrollPane(LISTA_PROGRAM);
        jScrollPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 5));

        MODEL_PROGRAM.removeAllElements();

        ArrayList<Programador> empleados = mostrarProgramadores();
        for (Programador t : empleados) {
            MODEL_PROGRAM.addElement(t);
        }

        JButton btnSeleccionEmple = crearEstiloBotonSubmit("SELECCIONAR PROGRAMADORES");
        btnSeleccionEmple.setPreferredSize(new Dimension(515, 45));

        btnSeleccionEmple.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                List<Programador> seleccionados = LISTA_PROGRAM.getSelectedValuesList();

                if (seleccionados.isEmpty()) {
                    mostrarMensaje("⚠️ Debes seleccionar programadores.");
                    return;
                }

                boolean algunoAsignado = false;

                for (Programador p : seleccionados) {

                    if (saberSiProgramdaroEstaEnProyecto(p)) {

                        int respuesta = JOptionPane.showConfirmDialog(
                                null,
                                "⚠️ " + p.getDni() + " " + p.getNombre() + " Esta asignado a un proyecto\n" +
                                        "¿Quieres asignarlo también a este proyecto?",
                                "Asignar Programador",
                                JOptionPane.YES_NO_OPTION
                        );

                        if (respuesta != JOptionPane.YES_OPTION) {
                            continue; // No asignar, pero seguir con los demás
                        }
                    }

                    if (!asignarProgramadorProyecto(p, proyecto)) {
                        mostrarMensaje("❌ Error al asignar el programador: " + p.getNombre());
                        return;
                    } else {
                        algunoAsignado = true;
                    }

                }

                if (!algunoAsignado) {
                    mostrarMensaje("⚠️ No se asignó ningún programador");
                    return;
                }

                // Solo aquí, una vez terminado el bucle
                new AsignarGerente(proyecto).setVisible(true);
                dispose();
            }
        });


        panelBoton.add(btnSeleccionEmple);

        panelPrincipal.add(jScrollPane, BorderLayout.CENTER);
        panelPrincipal.add(panelBoton, BorderLayout.SOUTH);

        return panelPrincipal;
    }
}
