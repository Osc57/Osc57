import 'package:componentes/presentation/widgets/widgets.dart';
import 'package:flutter/material.dart';

class FormularioScreen extends StatelessWidget {
  const FormularioScreen({super.key});

  @override
  Widget build(BuildContext context) {
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
                  icon: Icons.person,
                ),
                SizedBox(height: 20),
                CustomInputField(
                  labelText: 'Apellidos',
                  hintText: 'Apellidos del usuario',
                  icon: Icons.person,
                ),
                SizedBox(height: 20),
                CustomInputField(
                  labelText: 'Teléfono',
                  hintText: 'Teléfono del usuario',
                  icon: Icons.phone,
                  keyboardType: .phone,
                ),
                SizedBox(height: 20),
                CustomInputField(
                  labelText: 'Email',
                  hintText: 'Correo del usuario',
                  icon: Icons.mail,
                  keyboardType: .emailAddress,
                ),
                SizedBox(height: 20),
                CustomInputField(
                  labelText: 'Contraseña',
                  hintText: 'Contraseña del usuario',
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
                    print(value);
                  },
                ),
            
                SizedBox(height: 20),
                ElevatedButton(onPressed: null, child: Text('Guardar')),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
