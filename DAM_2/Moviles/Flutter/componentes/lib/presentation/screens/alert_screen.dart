import 'package:componentes/theme/app_theme.dart';
import 'package:flutter/material.dart';

class AlertScreen extends StatelessWidget {
  const AlertScreen({super.key});

  void mostrarAlerta(BuildContext context) {
    showDialog(
      context: context,
      builder: (context) {
        return AlertDialog(title: Text("Titulo de la Alerta"));
      },
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Alertas"),
        //backgroundColor: Colors.red,
        //elevation: 0,
      ),
      body: Center(
        child: ElevatedButton(
          style: ElevatedButton.styleFrom(
            backgroundColor: AppTheme.secondary,
            shape: StadiumBorder(),
          ),
          onPressed: () {
            mostrarAlerta(context);
          },
          child: Padding(
            padding: EdgeInsets.all(25),
            child: Text("Mostrar Alerta"),
          ),
        ),
      ),
    );
  }
}
