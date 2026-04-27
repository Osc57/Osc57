package org.example.Vista;

import org.example.Modelo.Departamento;
import org.example.Modelo.Empleados;
import org.example.Modelo.Gerente;
import org.example.Utils.Validator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static org.example.ControladorDAO.DepartamentoDAO.obtenerDepartamentos;
import static org.example.ControladorDAO.GerenteDAO.obtenerNivelGerente;
import static org.example.Utils.Funcionalidad.*;
import static org.example.Utils.Messages.mostrarError;

public class ModificarGerente extends JFrame {
    private Empleados empleado;
    private ArrayList<Departamento> departamentos = obtenerDepartamentos();
    private Gerente gerente;

    JTextField txtNombre = new JTextField();
    JTextField txtApellidos = new JTextField();
    JTextField txtTelefono = new JTextField();
    JTextField txtSalario = new JTextField();

    public ModificarGerente(Empleados empleado) {
        this.empleado = empleado;
        this.gerente = obtenerNivelGerente(empleado);

        this.setTitle("Modificar Gerente");
        this.setSize(480, 460);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        configurarCierreVentana(this);

        JLabel introducirCliente = new JLabel("•Seleccione datos del gerente");
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

        JPanel panelCentro = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JPanel panelLabels = new JPanel(new GridLayout(6, 1, 5, 5));
        panelLabels.add(crearLabels("Nombre: "));
        panelLabels.add(crearLabels("Apellidos: "));
        panelLabels.add(crearLabels("Teléfono: "));
        panelLabels.add(crearLabels("Salario: "));
        panelLabels.add(crearLabels("Depto.: "));
        panelLabels.add(crearLabels("Nivel: "));

        JPanel panelFields = new JPanel(new GridLayout(6, 1, 5, 5));
        (txtNombre = crearFields()).setText(empleado.getNombre());
        (txtApellidos = crearFields()).setText(empleado.getApellidos());
        (txtTelefono = crearFields()).setText(empleado.getTelefono());
        (txtSalario = crearFields()).setText(empleado.getSalario() + "");

        JComboBox<Departamento> comboBoxDepart = new JComboBox<>();
        comboBoxDepart.addItem(new Departamento("Seleccione un departamento..."));

        for (Departamento d : departamentos) {
            comboBoxDepart.addItem(d);
        }

        comboBoxDepart.setSelectedIndex(empleado.getDepartamento());

        JComboBox<String> comboBoxNivel = new JComboBox<>(new String[]{
                "Selecciona nivel de gerente...", "Alto", "Medio", "Bajo"});

        comboBoxNivel.setSelectedItem(gerente.getNivel());

        panelFields.add(txtNombre);
        panelFields.add(txtApellidos);
        panelFields.add(txtTelefono);
        panelFields.add(txtSalario);
        panelFields.add(comboBoxDepart);
        panelFields.add(comboBoxNivel);

        JPanel panelBoton = new JPanel((new FlowLayout(FlowLayout.CENTER)));
        JButton btnCrearUser = crearEstiloBotonSubmit("MODIFICAR DATOS");

        btnCrearUser.setPreferredSize(new Dimension(380, 45));
        panelBoton.add(btnCrearUser);

        btnCrearUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText().trim();
                String apellidos = txtApellidos.getText().trim();
                String telefono = txtTelefono.getText().trim();
                String salarioTexto = txtSalario.getText().trim();

                Departamento departamento = (Departamento) comboBoxDepart.getSelectedItem();
                int indexNivel = comboBoxNivel.getSelectedIndex();
                int indexDepartamento = comboBoxDepart.getSelectedIndex();
                Object nivelObj = comboBoxNivel.getSelectedItem();

                if (!Validator.camposRellenos(nombre, apellidos, telefono, salarioTexto)) {
                    mostrarError("⚠️ Rellene todos los campos de texto.");
                    return;
                }

                if (!Validator.nombreValido(nombre)) {
                    mostrarError("⚠️ El nombre debe empezar por mayúscula y ser letras");
                    return;
                }

                if (!Validator.apellidosValido(apellidos)) {
                    mostrarError("⚠️ El apellido debe empezar por mayúscula y ser letras");
                    return;
                }

                if (!Validator.telefonoValido(telefono)) {
                    mostrarError("⚠️ El teléfono deben ser 9 números");
                    return;
                }

            }
        });

        panelCentro.add(panelLabels);
        panelCentro.add(panelFields);
        panelPrincipal.add(panelCentro, BorderLayout.CENTER);
        panelPrincipal.add(panelBoton, BorderLayout.SOUTH);

        return panelPrincipal;
    }

}
