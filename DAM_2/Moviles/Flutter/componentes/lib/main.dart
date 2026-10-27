import 'package:flutter/material.dart';

import 'presentation/screens.dart';


void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Material App',
      // home: ListView1Screen(),
      initialRoute: "Home",
      routes: {
        "Home"     : (BuildContext context) => HomeScreen(),
        "ListView1": (context) => ListView1Screen(),
        "ListView2": (context) => ListView2Screen(), 
        "Alert"    : (context) => AlertScreen(),
        "Card"     : (context) => CardScreen()
      },
      // onGenerateRoute gestiona donde vamos cuando la ruta con nombre no existe
      onGenerateRoute: (settings) => MaterialPageRoute(builder: (context) => HomeScreen(),),
      theme: ThemeData.light().copyWith(
        useMaterial3: false,
        appBarTheme: AppBarTheme(
          backgroundColor: Colors.green,
        )
      ),
    );
  }
}
