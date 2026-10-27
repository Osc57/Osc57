import 'package:componentes/models/menu_option.dart';
import 'package:flutter/material.dart';

class HomeScreen extends StatelessWidget {
   
  const HomeScreen({super.key});
  
  @override
  Widget build(BuildContext context) {
    
    final menuOptions = <MenuOption>[
      MenuOption(ruta: "ListView1", icono: Icons.list_alt, nombre: "ListView Tipo 1"),
      MenuOption(ruta: "ListView2", icono: Icons.list, nombre: "ListView Tipo 2"),
      MenuOption(ruta: "Alert", icono: Icons.add_alert, nombre: "Alertas - Alerts"),
      MenuOption(ruta: "Card", icono: Icons.card_giftcard, nombre: "Tarjetas - Cards"),
    ];

    return Scaffold(
      appBar: AppBar(
        title: Text("Componentes en Flutter"),
      ),
      body: ListView.separated(
        itemBuilder: (context, i ) => ListTile(
          leading: Icon(menuOptions[i].icono, color: Colors.indigo,),
          title: Text(menuOptions[i].nombre),
          onTap: () {
            /*
            final route = MaterialPageRoute(
              builder: (context) => ListView2Screen() 
            );
            Navigator.push(context, route);
            */

            Navigator.pushNamed(context, menuOptions[i].ruta);
          },
          trailing: Icon(Icons.arrow_forward_ios, color: Colors.red,),
        ),
        separatorBuilder: (_, _) => Divider(),
        itemCount: 4
      )
    );
    
  }
}