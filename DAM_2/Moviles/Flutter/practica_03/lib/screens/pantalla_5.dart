import 'package:flutter/material.dart';
import 'package:practica_03/screens/plantilla.dart';


class Pantalla5 extends StatelessWidget {
  const Pantalla5({super.key});

  @override
  Widget build(BuildContext context) {
    const color = Colors.red;
    return PlantillaPantalla(
      numeroPantalla: 5,
      colorTema: color,
      botones: [
        crearBoton(context, 'Ir a Pantalla 1 (Apilar)', '/', color),
        crearBoton(context, 'Ir a Pantalla 2', '/p2', color),
        crearBoton(context, 'Ir a Pantalla 4', '/p4', color),
        const SizedBox(height: 20),
        ElevatedButton.icon(
          style: ElevatedButton.styleFrom(
            backgroundColor: Colors.black87,
            foregroundColor: Colors.white,
            minimumSize: const Size(250, 50),
          ),
          icon: const Icon(Icons.delete_forever),
          label: const Text('Vaciar pila y volver a Inicio'),
          onPressed: () {
            Navigator.pushNamedAndRemoveUntil(context, '/', (route) => false);
          },
        ),
      ],
    );
  }
}
