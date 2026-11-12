import 'package:flutter/material.dart';
import 'package:practica_03/screens/pantalla_1.dart';
import 'package:practica_03/screens/pantalla_2.dart';
import 'package:practica_03/screens/pantalla_3.dart';
import 'package:practica_03/screens/pantalla_4.dart';
import 'package:practica_03/screens/pantalla_5.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Práctica Navegación',
      // La aplicación inicia en la ruta '/' (Pantalla 1)
      initialRoute: '/',
      routes: {
        '/': (context) => const Pantalla1(),
        '/p2': (context) => const Pantalla2(),
        '/p3': (context) => const Pantalla3(),
        '/p4': (context) => const Pantalla4(),
        '/p5': (context) => const Pantalla5(),
      },
    );
  }
}
