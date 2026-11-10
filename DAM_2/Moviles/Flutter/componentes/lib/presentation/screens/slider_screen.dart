import 'package:flutter/material.dart';

class SliderScreen extends StatefulWidget {
  const SliderScreen({super.key});

  @override
  State<SliderScreen> createState() => _SliderScreenState();
}

class _SliderScreenState extends State<SliderScreen> {
  // 1. La variable de estado ahora vive dentro de la clase State
  double _valorSlider = 20;
  bool _activado = false;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Sliders & Checks')),
      body: Column(
        children: [
          Slider.adaptive(
            min: 0,
            max: 400,
            // 2. Enlazamos la propiedad con nuestra variable de estado
            value: _valorSlider,
            onChanged: _activado
                ? (value) {
                    // 3. Sintaxis correcta para disparar el rediseño de la UI
                    setState(() {
                      _valorSlider = value;
                    });
                  }
                : null,
          ),
          /*
          Checkbox.adaptive(
            value: _activado,
            onChanged: (value) {
              setState(() {
                _activado = value ?? true;
              });
            },
          ),

          Switch.adaptive(
            value: _activado,
            onChanged: (value) {
              setState(() {
                _activado =
                    value; // El Switch entrega un bool directo, no es nuleable
              });
            },
          ),

          CheckboxListTile.adaptive(
            title: Text('Habilitar Slider'),
            titleAlignment: .center,
            /*secondary: Icon(Icons.access_alarm),
            subtitle: Text('Esto es el subtitulo'),*/
            value: _activado,
            onChanged: (value) {
              setState(() {
                _activado = value ?? true;
              });
            },
          ),
*/
          SwitchListTile.adaptive(
            title: Text('Habilitar Slider'),

            value: _activado,
            onChanged: (value) {
              setState(() {
                _activado = value ?? true;
              });
            },
          ),

          Expanded(
            child: SingleChildScrollView(
              child: Image(
                image: NetworkImage(
                  'https://cdn.pixabay.com/photo/2020/07/06/17/51/batman-5377804_1280.png',
                ),
                fit: BoxFit.contain,
                width: _valorSlider,
              ),
            ),
          ),
        ],
      ),
    );
  }
}
