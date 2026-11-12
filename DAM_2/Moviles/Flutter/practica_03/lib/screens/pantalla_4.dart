import 'package:flutter/material.dart';
import 'package:practica_03/screens/plantilla.dart';

class Pantalla4 extends StatelessWidget {
  const Pantalla4({super.key});

  @override
  Widget build(BuildContext context) {
    const color = Colors.indigo;
    return PlantillaPantalla(
      numeroPantalla: 4,
      colorTema: color,
      botones: [
        crearBoton(context, 'Ir a Pantalla 3', '/p3', color),
        crearBoton(context, 'Ir a Pantalla 5', '/p5', color),
      ],
    );
  }
}
