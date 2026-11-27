import 'package:flutter/material.dart';

class CustomInputField extends StatelessWidget {
  final String userLabel;
  final String passwdLabel;

  const CustomInputField({
    super.key,
    required this.userLabel,
    required this.passwdLabel,
  });

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        TextFormField(
          decoration: InputDecoration(
            labelText: userLabel,
            border: const OutlineInputBorder(),
          ),
          validator: (value) {
            if (value == null || value.trim().isEmpty) {
              return 'Introduce tu usuario';
            }
            return null;
          },
        ),
        const SizedBox(height: 15),
        TextFormField(
          obscureText: true,
          decoration: InputDecoration(
            labelText: passwdLabel,
            border: const OutlineInputBorder(),
          ),
          validator: (value) {
            if (value == null || value.trim().isEmpty) {
              return 'Introduce tu contraseña';
            }
            return null;
          },
        ),
      ],
    );
  }
}
