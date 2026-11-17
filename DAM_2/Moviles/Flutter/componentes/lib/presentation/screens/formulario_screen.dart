import 'package:componentes/presentation/widgets/widgets.dart';
import 'package:flutter/material.dart';

class FormularioScreen extends StatelessWidget {
  const FormularioScreen({super.key});

  @override
  Widget build(BuildContext context) {
    //GlobalKey nos permite controlar y validar el formulario completo
    final GlobalKey<FormState> _forKey = GlobalKey<FormState>();

    final Map<String, String> formValues = {
      'first_name': 'Óscar',
      'last_name': 'Úbeda',
      'tfno': '654321321',
      'email': 'oubedaf@iesch.org',
      'password': '123456',
      'role': 'Developer',
    };

    return Scaffold(
      appBar: AppBar(title: Text('Formularios')),
      body: SingleChildScrollView(
        child: Padding(
          padding: EdgeInsetsGeometry.symmetric(horizontal: 20, vertical: 10),
          child: Form(
            child: Column(
              children: [
                CustomInputField(
                  labelText: 'Nombre',
                  hintText: 'Nombre del usuario',
                  formValues: formValues,
                  fomrProperty: 'first_name',
                  icon: Icons.person,
                ),
                SizedBox(height: 20),
                CustomInputField(
                  labelText: 'Apellidos',
                  hintText: 'Apellidos del usuario',
                  formValues: formValues,
                  fomrProperty: 'last_name',
                  icon: Icons.person,
                ),
                SizedBox(height: 20),
                CustomInputField(
                  labelText: 'Teléfono',
                  hintText: 'Teléfono del usuario',
                  formValues: formValues,
                  fomrProperty: 'tfno',
                  icon: Icons.phone,
                  keyboardType: .phone,
                ),
                SizedBox(height: 20),
                CustomInputField(
                  labelText: 'Email',
                  hintText: 'Correo del usuario',
                  formValues: formValues,
                  fomrProperty: 'email',
                  icon: Icons.mail,
                  keyboardType: .emailAddress,
                ),
                SizedBox(height: 20),
                CustomInputField(
                  labelText: 'Contraseña',
                  hintText: 'Contraseña del usuario',
                  formValues: formValues,
                  fomrProperty: 'password',
                  icon: Icons.password,
                  obscureText: true,
                ),
                SizedBox(height: 20),

                DropdownButtonFormField(
                  items: [
                    DropdownMenuItem(child: Text('Admin'), value: 'Admin'),
                    DropdownMenuItem(
                      child: Text('Superusuario'),
                      value: 'Superusuario',
                    ),
                    DropdownMenuItem(
                      child: Text('Developer'),
                      value: 'Developer',
                    ),
                    DropdownMenuItem(
                      child: Text('Jr. Developer'),
                      value: 'Jr. Developer',
                    ),
                  ],
                  onChanged: (value) {
                    formValues['role'] = value ?? 'Developer';
                  },
                ),

                SizedBox(height: 20),
                ElevatedButton(
                  onPressed: () {
                    print(formValues);
                  },
                  child: Text('Guardar'),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
