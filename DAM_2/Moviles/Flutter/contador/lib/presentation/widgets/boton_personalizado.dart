import 'package:flutter/material.dart';

class BotonPersonalizado extends StatelessWidget {
  const new({super.key});

  @override
  Widget build(BuildContext context) {
    return FloatingActionButton(child: Icon(Icons.add), onPressed: () {});
  }

  
  
}
/*
FloatingActionButton(
            child: Icon(Icons.minimize_rounded),
            onPressed: () {
              setState(() {
                contador++;
              });
            },
  )
  */