import 'package:flutter/material.dart';

class ListView1Screen extends StatelessWidget {
  const ListView1Screen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Listview Tipo 1')),
      body: ListView(
        children: [
          ListTile(
            leading: Icon(Icons.access_time_sharp),
            title: Text('Hola mundo'),
            subtitle: Text('Tienes una cita a las 16:00 en la peluqueria'),
            onTap: (){

            },
            trailing: Icon(Icons.arrow_forward_sharp),
          ),
          ListTile(
            leading: Icon(Icons.access_time_sharp),
            title: Text('Hola mundo'),
          ),
          ListTile(
            leading: Icon(Icons.access_time_sharp),
            title: Text('Hola mundo'),
          ),
          ListTile(
            leading: Icon(Icons.access_time_sharp),
            title: Text('Hola mundo'),
          ),
          ListTile(
            leading: Icon(Icons.access_time_sharp),
            title: Text('Hola mundo'),
          ),
          ListTile(
            leading: Icon(Icons.access_time_sharp),
            title: Text('Hola mundo'),
          ),
          ListTile(
            leading: Icon(Icons.access_time_sharp),
            title: Text('Hola mundo'),
          ),
          ListTile(
            leading: Icon(Icons.access_time_sharp),
            title: Text('Hola mundo'),
          ),
          ListTile(
            leading: Icon(Icons.access_time_sharp),
            title: Text('Hola mundo'),
          ),
          ListTile(
            leading: Icon(Icons.access_time_sharp),
            title: Text('Hola mundo'),
          ),
          ListTile(
            leading: Icon(Icons.access_time_sharp),
            title: Text('Hola mundo'),
          ),
          ListTile(
            leading: Icon(Icons.access_time_sharp),
            title: Text('Hola mundo'),
          ),
          ListTile(
            leading: Icon(Icons.access_time_sharp),
            title: Text('Hola mundo'),
          ),
          ListTile(
            leading: Icon(Icons.access_time_sharp),
            title: Text('Hola mundo'),
          ),
          ListTile(
            leading: Icon(Icons.access_time_sharp),
            title: Text('Hola mundo'),
          ),
          ListTile(
            leading: Icon(Icons.access_time_sharp),
            title: Text('Hola mundo'),
          ),
          ListTile(
            leading: Icon(Icons.access_time_sharp),
            title: Text('Hola mundo'),
          ),
          ListTile(
            leading: Icon(Icons.access_time_sharp),
            title: Text('Hola mundo'),
          ),
        ],
      )
    );
  }
}
