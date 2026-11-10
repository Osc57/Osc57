import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class SnackBarScreen extends StatelessWidget {
   
  const SnackBarScreen({super.key});
  
  void mostrarSnackBarPersonalizado(BuildContext context){
    //Eliminamos el snackBar para evitar repeticiones absurdas
    ScaffoldMessenger.of(context).clearSnackBars();

    final snackBar = SnackBar(
      content: Text('Hola a DAM 2'),
      action: SnackBarAction(
        label: 'Ok',
        onPressed: (){

        },
        ),
      duration: Duration(seconds: 2),
      backgroundColor: CupertinoColors.activeGreen,

      );

      //Mostramos el SnackBar que nos hemos creado
      ScaffoldMessenger.of(context).showSnackBar(snackBar);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('SnackBar'),

      ),
      body: Center(
         child: Text('SnackBarScreen'),
      ),

      floatingActionButton: FloatingActionButton.extended(
        icon: Icon(Icons.remove_red_eye_outlined),
        onPressed:() => mostrarSnackBarPersonalizado(context),
        label: Text('Mostrar SnackBar')
      
        ),
    
    );
  }
}