package org.example.Vista;

import org.example.Modelo.Empleados;
import org.example.Modelo.Gerente;
import org.example.Modelo.Programador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static org.example.ControladorDAO.GerenteDAO.mostrarGerentes;
import static org.example.Utils.Funcionalidad.*;
import static org.example.Utils.Funcionalidad.LISTA_EMPLEADOS;
import static org.example.Utils.Messages.mostrarMensaje;

public class AsignarGerente extends JFrame {

    public AsignarGerente() {
        this.setTitle("Seleccione Gerente");
        this.setSize(570, 460);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        configurarCierreVentana(this);

        JLabel introducirCliente = new JLabel("•Seleccione gerente para el proyecto");
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

        configurarListaEnScroll(LISTA_GERENTE);

        JScrollPane jScrollPane = new JScrollPane(LISTA_GERENTE);
        jScrollPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 5));

        MODEL_GERENTE.removeAllElements();

        ArrayList<Gerente> empleados = mostrarGerentes();
        for (Gerente t : empleados) {
            MODEL_GERENTE.addElement(t);
        }

        JButton btnSeleccionEmple = crearEstiloBotonSubmit("SELECCIONAR GERENTE");
        btnSeleccionEmple.setPreferredSize(new Dimension(515, 45));

        btnSeleccionEmple.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Gerente> seleccionados = LISTA_GERENTE.getSelectedValuesList();

            }
        });

        panelBoton.add(btnSeleccionEmple);

        panelPrincipal.add(jScrollPane, BorderLayout.CENTER);
        panelPrincipal.add(panelBoton, BorderLayout.SOUTH);

        return panelPrincipal;
    }

    public static void main(String[] args) {
        new AsignarGerente().setVisible(true);
    }
}
