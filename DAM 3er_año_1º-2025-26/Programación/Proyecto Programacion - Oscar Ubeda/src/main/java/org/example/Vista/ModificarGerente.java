package org.example.Vista;

import org.example.Modelo.Departamento;
import org.example.Modelo.Empleados;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static org.example.ControladorDAO.DepartamentoDAO.obtenerDepartamentos;
import static org.example.Utils.Funcionalidad.*;

public class ModificarGerente extends JFrame {
    private Empleados empleado;
    private ArrayList<Departamento> departamentos = obtenerDepartamentos();

    public ModificarGerente(Empleados empleado) {
        this.setTitle("Modificar Gerente");
        this.setSize(480, 460);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        configurarCierreVentana(this);

        JLabel introducirCliente = new JLabel("•Seleccione empleado a modificar");
        introducirCliente.setFont(FUENTE_TITULO_2);
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 0));

        JPanel panelModificarGerente = getJPanelModificarGerente();
        JPanel panelBotonRetorno = getPanelBotonRetorno(this, new ModificarEmpleado());

        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(panelModificarGerente, BorderLayout.CENTER);
        this.add(panelBotonRetorno, BorderLayout.SOUTH);
    }

    public JPanel getJPanelModificarGerente() {
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 15));

        JPanel panelCentro = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 30));

        JPanel panelLabels = new JPanel(new GridLayout(6, 1, 5, 5));
        panelLabels.add(crearLabels("Nombre: "));
        panelLabels.add(crearLabels("Apellidos: "));
        panelLabels.add(crearLabels("Teléfono: "));
        panelLabels.add(crearLabels("Depto.: "));
        panelLabels.add(crearLabels("Bono: "));

        return panelPrincipal;
    }

}
