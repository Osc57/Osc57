import 'package:flutter/material.dart';
import 'package:practica_03/screens/plantilla.dart';

class Pantalla3 extends StatelessWidget {
  const Pantalla3({super.key});

  @override
  Widget build(BuildContext context) {
    const color = Colors.orange;
    return PlantillaPantalla(
      numeroPantalla: 3,
      colorTema: color,
      botones: [
        crearBoton(context, 'Ir a Pantalla 1', '/', color),
        crearBoton(context, 'Ir a Pantalla 2', '/p2', color),
      ],
    );
  }
}
