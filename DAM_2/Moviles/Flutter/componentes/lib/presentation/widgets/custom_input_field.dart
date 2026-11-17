import 'package:flutter/material.dart';

class CustomInputField extends StatelessWidget {
  final String? _hintText;
  final String? _labelText;
  final String? _helperText;
  final IconData? icon;
  final IconData? suffixIcon;
  final TextInputType? keyboardType;
  final bool obscureText;

  final Map<String, String> formValues;
  final String fomrProperty;

  const new({
    super.key,
    this._hintText,
    this._labelText,
    this._helperText,
    this.icon,
    this.suffixIcon,
    this.keyboardType,
    this.obscureText = false,
    required this.formValues,
    required this.fomrProperty,
  });

  @override
  Widget build(BuildContext context) {
    return TextFormField(
      autofocus: true,
      initialValue: '',
      textCapitalization: .words,
      keyboardType: keyboardType,
      obscureText: obscureText,
      onChanged: (value) => formValues[fomrProperty] = value,
      validator: (value) {
        if (value == null) return 'Este campo es requerido';
        return value.length < 3 ? 'Minimo 3 caracteres' : null;
      },
      autovalidateMode: .onUserInteraction,
      decoration: InputDecoration(
        hintText: _hintText,
        labelText: _labelText,
        helperText: _helperText,

        suffixIcon: suffixIcon == null ? null : Icon(suffixIcon),
        icon: icon == null ? null : Icon(icon),
        focusedBorder: OutlineInputBorder(
          borderSide: BorderSide(color: Colors.pinkAccent),
          borderRadius: .only(
            bottomLeft: Radius.circular(10),
            bottomRight: Radius.circular(10),
          ),
        ),
      ),
    );
  }
}
