import 'package:flutter/material.dart';
import 'package:practica_03/screens/plantilla.dart';

class Pantalla1 extends StatelessWidget {
  const Pantalla1({super.key});

  @override
  Widget build(BuildContext context) {
    const color = Colors.purple;
    return PlantillaPantalla(
      numeroPantalla: 1,
      colorTema: color,
      botones: [
        crearBoton(context, 'Ir a Pantalla 3', '/p3', color),
        crearBoton(context, 'Ir a Pantalla 4', '/p4', color),
      ],
    );
  }
}
