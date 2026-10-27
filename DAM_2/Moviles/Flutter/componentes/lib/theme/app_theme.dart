import 'package:flutter/material.dart';

class AppTheme {
  //Color primario
  static const Color primary = Colors.pink;
  static const Color secondary = Colors.yellow;

  //Tema light
  static final ThemeData lightTheme = ThemeData.light().copyWith(
    primaryColor: primary,

    //AppBar
    useMaterial3: false,
    appBarTheme: AppBarTheme(backgroundColor: primary, elevation: 0),
  );

  //Tema Halloween
  static final ThemeData halloweenTheme = ThemeData(
    useMaterial3: true,
    brightness: Brightness.dark,
    colorScheme: const ColorScheme.dark(
      background: Color(0xFF0D0D0D), // Negro noche
      surface: Color(0xFF1A1A1A), // Gris oscuro (tarjetas/barras)
      primary: Color(0xFFFF7518), // Naranja calabaza
      secondary: Color(0xFF9B30FF), // Morado bruja
      error: Color(0xFFD32F2F), // Rojo sangre
    ),
  );
}
