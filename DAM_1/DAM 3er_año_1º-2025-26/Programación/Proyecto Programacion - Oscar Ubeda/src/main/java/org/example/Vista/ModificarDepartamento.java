package org.example.Vista;

import org.example.Modelo.Departamento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import static org.example.ControladorDAO.DepartamentoDAO.modificarDatosDepartamento;
import static org.example.Utils.Funcionalidad.*;
import static org.example.Utils.Messages.mostrarMensaje;

public class ModificarDepartamento extends JFrame {

    private Departamento departamento;

    public ModificarDepartamento(Departamento depart) {
        this.departamento = depart;

        this.setTitle("Modificar Empleado");
        this.setSize(480, 370);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        configurarCierreVentana(this);

        JLabel introducirCliente = new JLabel("•Modifique la ubicación");
        introducirCliente.setFont(FUENTE_TITULO_2);
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 0));

        JPanel panelScrollPanel = getJPanelScrollPanel();
        JPanel panelBotonRetorno = getPanelBotonRetorno(this, new SeleccionDeptoModificar());

        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(panelScrollPanel, BorderLayout.CENTER);
        this.add(panelBotonRetorno, BorderLayout.SOUTH);
    }

    private JPanel getJPanelScrollPanel() {
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 15));

        JPanel panelCentro = new JPanel(new FlowLayout(FlowLayout.CENTER, 85, 50));

        JPanel panelLabels = new JPanel(new GridLayout(1, 1, 5, 5));
        panelLabels.add(crearLabels("Ubicación: "));

        JPanel panelFields = new JPanel(new GridLayout(1, 1, 5, 5));

        JComboBox<String> comboBoxUbicacion = new JComboBox<>();
        comboBoxUbicacion.addItem("Selecciona un piso...");

        for (int i = 1; i <= N_PISOS; i++) {
            comboBoxUbicacion.addItem("Piso " + i);
        }

        comboBoxUbicacion.setSelectedItem(departamento.getUbicacion());

        JPanel panelBoton = new JPanel((new FlowLayout(FlowLayout.CENTER)));
        JButton btnModificarDpto = crearEstiloBotonSubmit("MODIFICAR UBICACIÓN");
        btnModificarDpto.setPreferredSize(new Dimension(380, 45));
        btnModificarDpto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = comboBoxUbicacion.getSelectedIndex();

                if (index <= 0) {
                    mostrarMensaje("⚠️ Debe seleccionar un piso");
                    return;
                }

                String nuevaUbicacion = (String) comboBoxUbicacion.getSelectedItem();

                Departamento departamentoModificar = new Departamento(departamento.getId(), departamento.getNombre(), nuevaUbicacion);

                if (modificarDatosDepartamento(departamentoModificar)) {
                    mostrarMensaje("✅ Piso modificado correctamente");
                    dispose();
                    new GestionDepartamentos().setVisible(true);
                } else {
                    mostrarMensaje("❌ Error al modificar la ubicación");
                }
            }
        });

        panelFields.add(comboBoxUbicacion);

        panelCentro.add(panelLabels);
        panelCentro.add(panelFields);

        panelPrincipal.add(panelCentro, BorderLayout.CENTER);

        panelBoton.add(btnModificarDpto);
        panelPrincipal.add(panelBoton, BorderLayout.SOUTH);
        return panelPrincipal;
    }
}
