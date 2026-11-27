import 'package:flutter/material.dart';
import 'package:practica4/screen/segunda_pantalla.dart';
import 'package:practica4/widgets/custom_input_field.dart';

class FormScreen extends StatelessWidget {
  const FormScreen({super.key});

    @override
  Widget build(BuildContext context) {
    final GlobalKey<FormState> formKey = GlobalKey<FormState>();

    return Scaffold(
      body: Center(
        child: SingleChildScrollView(
          child: Padding(
            padding: const EdgeInsets.symmetric(horizontal: 20, vertical: 10),
            child: Form(
              key: formKey,
              child: Column(
                mainAxisSize: MainAxisSize.min,
                children: [
                  const CustomInputField(
                    userLabel: 'Enter your username',
                    passwdLabel: 'Enter your password',
                  ),
                  const SizedBox(height: 20),
                  SizedBox(
                    width: double.infinity,
                    child: ElevatedButton(
                      style: ElevatedButton.styleFrom(
                        backgroundColor: Colors.black,
                        foregroundColor: Colors.white,
                        padding: const EdgeInsets.symmetric(vertical: 15),
                      ),
                      onPressed: () {
                        if (formKey.currentState!.validate()) {
                          Navigator.pushReplacement(
                            context,
                            MaterialPageRoute(
                              builder: (context) => const SegundaPantalla(),
                            ),
                          );
                        }
                      },
                      child: const Text('Log In'),
                    ),
                  ),
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }


}
