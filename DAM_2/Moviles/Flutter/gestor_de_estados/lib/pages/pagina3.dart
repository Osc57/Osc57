import 'package:flutter/material.dart';
import 'package:gestor_de_estados/providers/contador_provider.dart';
import 'package:gestor_de_estados/providers/theme_provider.dart';
import 'package:provider/provider.dart';


class Pagina3 extends StatelessWidget {
  const Pagina3({super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
      //color: Colors.limeAccent,
      child: Column(
        mainAxisAlignment: .center,
        children: [
          Center(child: Text('El contador de la página 1 marca: '),),
          Text(context.watch<ContadorProvider>().contador.toString(), style: TextStyle(fontSize: 120),),
          SizedBox(height: 30,),
          ElevatedButton(onPressed: (){
            context.read<ThemeProvider>().cambiarTheme();
          }, child: Text('Modo Light/Dark'))
        ],
      )
      );
  }
}