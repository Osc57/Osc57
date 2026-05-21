package org.example.Vista;

import org.example.Modelo.Departamento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static org.example.ControladorDAO.DepartamentoDAO.*;
import static org.example.Utils.Funcionalidad.*;
import static org.example.Utils.Messages.mostrarMensaje;

public class SeleccionDeptoModificar extends JFrame {

    public SeleccionDeptoModificar() {
        this.setTitle("Modificar Departamento");
        this.setSize(480, 460);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        configurarCierreVentana(this);

        JLabel introducirCliente = new JLabel("•Seleccione depto. a modificar");
        introducirCliente.setFont(FUENTE_TITULO_2);
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 0));

        JPanel panelScrollPanel = getJPanelScrollPanel();
        JPanel panelBotonRetorno = getPanelBotonRetorno(this, new GestionDepartamentos());

        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(panelScrollPanel, BorderLayout.CENTER);
        this.add(panelBotonRetorno, BorderLayout.SOUTH);
    }

    private JPanel getJPanelScrollPanel() {
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 15));

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));

        configurarListaEnScroll(LISTA_DEPTO);

        JScrollPane jScrollPane = new JScrollPane(LISTA_DEPTO);
        jScrollPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 5));

        MODEL_DEPTO.removeAllElements();

        ArrayList<Departamento> empleados = obtenerDepartamentos();
        for (Departamento d : empleados) {
            MODEL_DEPTO.addElement(d);
        }

        JButton btnSeleccionEmple = crearEstiloBotonSubmit("SELECCIONAR DEPARTAMENTO");
        btnSeleccionEmple.setPreferredSize(new Dimension(420, 45));

        btnSeleccionEmple.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Departamento seleccionado = LISTA_DEPTO.getSelectedValue();

                if (seleccionado == null) {
                    mostrarMensaje("⚠️ Seleccione una opción");
                    return;
                }

                Departamento departamento = new Departamento(seleccionado.getId(), seleccionado.getNombre(), seleccionado.getUbicacion());

                dispose();
                new ModificarDepartamento(departamento).setVisible(true);

            }
        });

        panelBoton.add(btnSeleccionEmple);

        panelPrincipal.add(jScrollPane, BorderLayout.CENTER);
        panelPrincipal.add(panelBoton, BorderLayout.SOUTH);

        return panelPrincipal;
    }
}
