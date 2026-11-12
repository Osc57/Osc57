import 'package:flutter/material.dart';
import 'package:practica_03/screens/plantilla.dart';


class Pantalla2 extends StatelessWidget {
  const Pantalla2({super.key});

  @override
  Widget build(BuildContext context) {
    const color = Colors.green;
    return PlantillaPantalla(
      numeroPantalla: 2,
      colorTema: color,
      botones: [
        crearBoton(context, 'Ir a Pantalla 5', '/p5', color),
      ],
    );
  }
}
