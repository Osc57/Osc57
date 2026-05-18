package org.example.Vista;

import org.example.Modelo.Empleados;
import org.example.Modelo.Programador;
import org.example.Modelo.Proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        configurarCierreVentana(this);

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

        ArrayList<Programador> empleados = obtenerEmpleadosLibres();
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

                if (seleccionados.size() < 2) {
                    mostrarMensaje("⚠️ Debes seleccionar al menos 2 programadores");
                    return;
                }

                for (Programador p : seleccionados) {
                    asignarProgramadorProyecto(p, proyecto);
                }

                new AsignarGerente(proyecto).setVisible(true);


            }
        });

        panelBoton.add(btnSeleccionEmple);

        panelPrincipal.add(jScrollPane, BorderLayout.CENTER);
        panelPrincipal.add(panelBoton, BorderLayout.SOUTH);

        return panelPrincipal;
    }
}
