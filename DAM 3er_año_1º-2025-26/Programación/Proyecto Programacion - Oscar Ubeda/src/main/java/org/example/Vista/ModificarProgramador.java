package org.example.Vista;

import org.example.Modelo.Departamento;
import org.example.Modelo.Empleados;
import org.example.Modelo.Gerente;
import org.example.Modelo.Programador;
import org.example.Utils.Validator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static org.example.ControladorDAO.DepartamentoDAO.*;
import static org.example.ControladorDAO.EmpleadosDAO.emailExistente;
import static org.example.ControladorDAO.EmpleadosDAO.modificarDatosEmpleado;
import static org.example.ControladorDAO.ProgramadorDAO.modificarDatosProgramador;
import static org.example.ControladorDAO.ProgramadorDAO.obtenerLenguajeProgramador;
import static org.example.Utils.Funcionalidad.*;
import static org.example.Utils.Messages.mostrarMensaje;
import static org.example.Utils.Validator.NOMBRE_EMPRESA;

public class ModificarProgramador extends JFrame {
    private Empleados empleado;
    private ArrayList<Departamento> departamentos = obtenerDepartamentos();
    private Programador programador;

    JTextField txtNombre = new JTextField();
    JTextField txtApellidos = new JTextField();
    JTextField txtTelefono = new JTextField();
    JTextField txtSalario = new JTextField();
    JTextField txtEmail = new JTextField();

    public ModificarProgramador(Empleados empleados) {
        this.empleado = empleados;
        this.programador = obtenerLenguajeProgramador(empleados);

        this.setTitle("Modificar Programador");
        this.setSize(480, 460);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        configurarCierreVentana(this);

        JLabel introducirCliente = new JLabel("•Seleccione datos del programador");
        introducirCliente.setFont(FUENTE_TITULO_2);
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));

        JPanel panelModificarGerente = getJPanelModificarProgramador();
        JPanel panelBotonRetorno = getPanelBotonRetorno(this, new ModificarEmpleado());

        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(panelModificarGerente, BorderLayout.CENTER);
        this.add(panelBotonRetorno, BorderLayout.SOUTH);
    }

    public JPanel getJPanelModificarProgramador() {
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(5, 15, 15, 15));

        JPanel panelCentro = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JPanel panelLabels = new JPanel(new GridLayout(7, 1, 5, 5));
        panelLabels.add(crearLabels("Nombre: "));
        panelLabels.add(crearLabels("Apellidos: "));
        panelLabels.add(crearLabels("Teléfono: "));
        panelLabels.add(crearLabels("Correo: "));
        panelLabels.add(crearLabels("Salario: "));
        panelLabels.add(crearLabels("Depto.: "));
        panelLabels.add(crearLabels("Lenguaje: "));

        JPanel panelFields = new JPanel(new GridLayout(7, 1, 5, 5));
        (txtNombre = crearFields()).setText(empleado.getNombre());
        (txtApellidos = crearFields()).setText(empleado.getApellidos());
        (txtTelefono = crearFields()).setText(empleado.getTelefono());
        (txtEmail = crearFields()).setText(empleado.getEmail());
        (txtSalario = crearFields()).setText(empleado.getSalario() + "");

        JComboBox<Departamento> comboBoxDepart = new JComboBox<>();
        comboBoxDepart.addItem(new Departamento("Seleccione un departamento", " "));

        for (Departamento d : departamentos) {
            comboBoxDepart.addItem(d);
        }

        Departamento dp = new Departamento(empleado.getDepartamento());

        comboBoxDepart.setSelectedIndex(mostrarNombreDepartamento(dp).getId());

        JComboBox<String> comboBoxLProgramacion = new JComboBox<>(new String[]{
                "Seleccione un lenguaje...", "JavaScript", "Python", "Java", "C#", "Otro..."
        });

        comboBoxLProgramacion.setSelectedItem(programador.getLenguajePrincipal());

        panelFields.add(txtNombre);
        panelFields.add(txtApellidos);
        panelFields.add(txtTelefono);
        panelFields.add(txtEmail);
        panelFields.add(txtSalario);
        panelFields.add(comboBoxDepart);
        panelFields.add(comboBoxLProgramacion);

        JPanel panelBoton = new JPanel((new FlowLayout(FlowLayout.CENTER)));
        JButton btnCrearUser = crearEstiloBotonSubmit("MODIFICAR DATOS");

        btnCrearUser.setPreferredSize(new Dimension(380, 45));
        panelBoton.add(btnCrearUser);

        btnCrearUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dni = empleado.getDni();
                String nombre = txtNombre.getText().trim();
                String apellidos = txtApellidos.getText().trim();
                String email = txtEmail.getText().trim();
                String telefono = txtTelefono.getText().trim();
                String salarioTexto = txtSalario.getText().trim();

                Departamento departamento = (Departamento) comboBoxDepart.getSelectedItem();
                int indexLProgram = comboBoxLProgramacion.getSelectedIndex();
                int indexDepartamento = comboBoxDepart.getSelectedIndex();
                Object nivelObj = comboBoxLProgramacion.getSelectedItem();

                if (!Validator.camposRellenos(nombre, apellidos, telefono, salarioTexto)) {
                    mostrarMensaje("⚠️ Rellene todos los campos de texto.");
                    return;
                }

                if (!Validator.nombreValido(nombre)) {
                    mostrarMensaje("⚠️ El nombre debe empezar por mayúscula y ser letras");
                    return;
                }

                if (!Validator.apellidosValido(apellidos)) {
                    mostrarMensaje("⚠️ El apellido debe empezar por mayúscula y ser letras");
                    return;
                }

                if (!Validator.validarEmail(email)) {
                    mostrarMensaje("⚠️ Correo invalido, tiene que tener " + NOMBRE_EMPRESA);
                    return;
                }


                if (!Validator.telefonoValido(telefono)) {
                    mostrarMensaje("⚠️ El teléfono deben ser 9 números");
                    return;
                }

                if (!Validator.salarioValido(salarioTexto)) {
                    mostrarMensaje("⚠️ El salario debe ser un número válido mayor que 0.");
                    return;
                }

                if (indexDepartamento == 0 || departamento == null) {
                    mostrarMensaje("⚠️ Debe seleccionar un departamento");
                    return;
                }

                if (indexLProgram == 0 || nivelObj == null) {
                    mostrarMensaje("⚠️ Debes seleccionar un nivel.");
                    return;
                }

                int idDept = departamento.getId();
                String lenguajeProgramacion = comboBoxLProgramacion.getSelectedItem().toString();//Parseo objeto a String
                double salario = Double.parseDouble(salarioTexto.replace(",", "."));


                Empleados empleadoModificado = new Empleados(dni, nombre, apellidos, email, telefono, salario, idDept);

                if (emailExistente(empleadoModificado)) {
                    mostrarMensaje("⚠️ Este email ya está registrado");
                    return;
                }

                Programador programadorModificado = new Programador(lenguajeProgramacion);

                if (modificarDatosEmpleado(empleadoModificado) && modificarDatosProgramador(empleadoModificado, programadorModificado)) {
                    mostrarMensaje("✅ Empleado modificado exitosamente");
                    dispose();
                    new GestionEmpleado().setVisible(true);
                } else {
                    mostrarMensaje("❌ Error al modificar el empleado");
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
