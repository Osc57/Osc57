package org.example.Vista;

import org.example.Modelo.Departamento;
import org.example.Modelo.Programador;
import org.example.Modelo.Proyecto;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static org.example.ControladorDAO.EmpleadosDAO.obtenerProyectosPorEmpleado;
import static org.example.ControladorDAO.EmpleadosDAO.sacarDepartamentoEmpelado;
import static org.example.Utils.Funcionalidad.*;

public class LoginProgramador extends JFrame {

    private Programador programador;

    public LoginProgramador(Programador p) {
        this.programador = p;

        this.setTitle("Datos Gerente");
        this.setSize(480, 430);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        configurarCierreVentana(this);

        JLabel introducirCliente = new JLabel("•Mire sus Datos");
        introducirCliente.setFont(FUENTE_TITULO_2);
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 0));

        JPanel panelScrollPanel = getJPanelScrollPanel();

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBoton.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));

        JButton btnProyectos = crearEstiloBotonSubmit("VER PROYECTOS");
        btnProyectos.setPreferredSize(new Dimension(420, 45));

        btnProyectos.addActionListener(e -> {
            List<Proyecto> proyectos = obtenerProyectosPorEmpleado(programador);
            new VentanaProyectos(proyectos, this).setVisible(true);
            dispose();
        });

        panelBoton.add(btnProyectos);

        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(panelScrollPanel, BorderLayout.WEST);
        this.add(panelBoton, BorderLayout.SOUTH);
    }

    private JPanel getJPanelScrollPanel() {
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        JPanel panelCentro = new JPanel();
        // Panel donde van los labels
        JPanel panelLabels = new JPanel(new GridLayout(7, 1, 5, 5));

        Departamento dep = sacarDepartamentoEmpelado(programador);

        JLabel lblDni = new JLabel("DNI: " + programador.getDni());
        JLabel lblNombre = new JLabel("Nombre completo: " + programador.getNombre() + " " + programador.getApellidos());
        JLabel lblSalario = new JLabel("Salario: " + programador.getSalario() + " €");
        JLabel lblTelefono = new JLabel("Teléfono: " + programador.getTelefono());
        JLabel lblDepto = new JLabel("Departamento asignado: " + dep.getNombre());
        JLabel lblBono = new JLabel("Lenguaje Principal: " + programador.getLenguajePrincipal());
        JLabel lblCorreo = new JLabel("Correo corporativo: " + programador.getEmail());

        lblDni.setFont(FUENTE_TEXTO);
        lblNombre.setFont(FUENTE_TEXTO);
        lblSalario.setFont(FUENTE_TEXTO);
        lblTelefono.setFont(FUENTE_TEXTO);
        lblDepto.setFont(FUENTE_TEXTO);
        lblBono.setFont(FUENTE_TEXTO);
        lblCorreo.setFont(FUENTE_TEXTO);

        // Añadimos los labels al panelLabels
        panelLabels.add(lblDni);
        panelLabels.add(lblNombre);
        panelLabels.add(lblSalario);
        panelLabels.add(lblTelefono);
        panelLabels.add(lblDepto);
        panelLabels.add(lblBono);
        panelLabels.add(lblCorreo);

        panelCentro.add(panelLabels, BorderLayout.WEST);

        // Añadimos panelLabels al panelPrincipal
        panelPrincipal.add(panelCentro, BorderLayout.CENTER);

        return panelPrincipal;
    }
}
