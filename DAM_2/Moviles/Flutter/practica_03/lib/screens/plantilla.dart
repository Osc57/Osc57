import 'package:flutter/material.dart';

class PlantillaPantalla extends StatelessWidget {
  final int numeroPantalla;
  final Color colorTema;
  final List<Widget> botones;

  const PlantillaPantalla({
    super.key,
    required this.numeroPantalla,
    required this.colorTema,
    required this.botones,
  });

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Pantalla $numeroPantalla'),
        backgroundColor: colorTema,
        foregroundColor: Colors.white,
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: botones,
        ),
      ),
    );
  }
}

Widget crearBoton(BuildContext context, String texto, String ruta, Color color) {
  return Padding(
    padding: const EdgeInsets.symmetric(vertical: 8.0),
    child: ElevatedButton(
      style: ElevatedButton.styleFrom(
        backgroundColor: color,
        foregroundColor: Colors.white,
        minimumSize: const Size(220, 45),
      ),
      onPressed: () => Navigator.pushNamed(context, ruta),
      child: Text(texto),
    ),
  );
}
