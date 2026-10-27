import 'package:flutter/material.dart';

class AlertScreen extends StatelessWidget {
   
  const AlertScreen({super.key});
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Alertas"),
        backgroundColor: Colors.red,
        elevation: 0,
      ),
      body: Center(
         child: Text('AlertScreen'),
      ),
    );
  }
}