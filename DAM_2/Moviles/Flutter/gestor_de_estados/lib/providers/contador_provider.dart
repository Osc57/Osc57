//Este provider va a manejar el contador de la página 1

import 'package:flutter/material.dart';

//ChangeNotifier es una clase que proporciona notificaciones a los Widgets cuando el estado cambia
class ContadorProvider extends ChangeNotifier {
  //Cuando tenemos un estado con provider hemos de poder hacer DOS cosas:
  //1 - Poder leer el valor de ese estado
  //2 - Poder modificar ese estado
  
  int _contador = 0;

  int get contador => _contador;

  void incrementar(){
    _contador++;
    notifyListeners();
  }

   void decrementar(){
    _contador--;
    notifyListeners();
  }

}