import 'package:flutter/material.dart';

class Pagina1 extends StatelessWidget {
  const new({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.lightGreenAccent,
      body: Column(
        children: [
          Center(
            child: Text('7', style: TextStyle(fontSize: 120),),
          ),
          ElevatedButton(onPressed: (){

          },
          child: Text('Incrementar'))
        ],
      ),
    );
  }
}