import 'package:flutter/material.dart';

class AppTheme {
  //Color primario
  static const Color primary = Colors.pink;

  static final ThemeData lightTheme = ThemeData.light().copyWith(
    primaryColor: primary,

    //AppBar
    useMaterial3: false,
    appBarTheme: AppBarTheme(backgroundColor: primary, elevation: 0),
  );
}
