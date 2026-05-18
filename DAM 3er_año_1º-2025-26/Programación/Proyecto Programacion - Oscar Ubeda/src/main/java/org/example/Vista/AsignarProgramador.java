package org.example.Vista;

import org.example.Modelo.Empleados;
import org.example.Modelo.Programador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static org.example.ControladorDAO.EmpleadosDAO.*;
import static org.example.ControladorDAO.ProgramadorDAO.mostrarProgramadores;
import static org.example.Utils.Funcionalidad.*;
import static org.example.Utils.Messages.mostrarMensaje;

public class AsignarProgramador extends JFrame {

    public AsignarProgramador() {
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
            }
        });

        panelBoton.add(btnSeleccionEmple);

        panelPrincipal.add(jScrollPane, BorderLayout.CENTER);
        panelPrincipal.add(panelBoton, BorderLayout.SOUTH);

        return panelPrincipal;
    }

    public static void main(String[] args) {
        new AsignarProgramador().setVisible(true);
    }
}
