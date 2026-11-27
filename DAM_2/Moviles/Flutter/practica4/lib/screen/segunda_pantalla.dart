import 'package:flutter/material.dart';
import 'package:practica4/screen/form_screen.dart'; // Ajusta la ruta si tu archivo se llama distinto

class SegundaPantalla extends StatelessWidget {
  const SegundaPantalla({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Padding(
          padding: const EdgeInsets.symmetric(horizontal: 20),
          child: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              const Icon(
                Icons.check_circle_outline,
                size: 80,
                color: Colors.black,
              ),
              const SizedBox(height: 16),
              const Text(
                '¡Bien, has accedido a la pantalla!',
                textAlign: TextAlign.center,
                style: TextStyle(
                  fontSize: 22,
                  fontWeight: FontWeight.bold,
                ),
              ),
              const SizedBox(height: 30),
              SizedBox(
                width: double.infinity,
                child: ElevatedButton(
                  style: ElevatedButton.styleFrom(
                    backgroundColor: Colors.black,
                    foregroundColor: Colors.white,
                    padding: const EdgeInsets.symmetric(vertical: 15),
                  ),
                  onPressed: () {
                    Navigator.pushReplacement(
                      context,
                      MaterialPageRoute(
                        builder: (context) => const FormScreen(),
                      ),
                    );
                  },
                  child: const Text('Go Back'),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
