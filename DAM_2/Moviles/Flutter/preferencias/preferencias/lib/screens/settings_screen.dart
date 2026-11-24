import 'package:flutter/material.dart';
import 'package:preferencias/config/preferences/preferencias.dart';

class SettingsScreen extends StatefulWidget {
  const SettingsScreen({Key? key}) : super(key: key);

  @override
  State<SettingsScreen> createState() => _SettingsScreenState();
}

class _SettingsScreenState extends State<SettingsScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Preferencias')),
      body: Column(
        children: [
          SwitchListTile.adaptive(
            title: const Text('Permiso de ubicacion'),
            value: Preferencias.permisoUbicacion,
            onChanged: (value) {
              Preferencias.ubicacion = value!;
              setState(() {});
            },
          ),

          SwitchListTile.adaptive(
            title: const Text('Permiso de camara'),
            value: Preferencias.permisoCamara,
            onChanged: (value) {
              Preferencias.camara = value!;
              setState(() {});
            },
          ),

          SwitchListTile.adaptive(
            title: const Text('Tema Dark'),
            value: Preferencias.temaOscuro,
            onChanged: (value) {
              Preferencias.isDarkMode = value!;
              setState(() {});
            },
          ),

          const Divider(),
          Padding(
            padding: const EdgeInsets.symmetric(horizontal: 16),
            child: TextFormField(
              initialValue: Preferencias.nombre,
              decoration: const InputDecoration(
                label: Text('Nombre'),
                helperText: 'Nombre de usuario',
              ),
              onChanged: (value) {
                Preferencias.nombre = value;
                setState(() {});
              },
            ),
          ),
        ],
      ),
    );
  }
}

