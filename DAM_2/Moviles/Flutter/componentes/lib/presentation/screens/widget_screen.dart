import 'package:flutter/material.dart';

class ThemeSwitchScreen extends StatefulWidget {
  const ThemeSwitchScreen({super.key});

  @override
  State<ThemeSwitchScreen> createState() => _ThemeSwitchScreenState();
}

class _ThemeSwitchScreenState extends State<ThemeSwitchScreen> {
  bool isDarkMode = false;

  @override
  Widget build(BuildContext context) {
    final Color backgroundColor = isDarkMode ? const Color(0xFF121212) : Colors.white;
    final Color textColor = isDarkMode ? Colors.white : Colors.black87;
    final Color appBarColor = isDarkMode ? const Color(0xFF1F1F1F) : Colors.blue;

    return Scaffold(
      backgroundColor: backgroundColor,
      appBar: AppBar(
        title: Text(
          isDarkMode ? 'Tema Oscuro' : 'Tema Claro',
          style: const TextStyle(color: Colors.white),
        ),
        backgroundColor: appBarColor,
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(
              isDarkMode ? 'Modo Oscuro Activado' : 'Modo Claro Activado',
              style: TextStyle(fontSize: 18, color: textColor),
            ),
            const SizedBox(height: 16),
            Switch(
              value: isDarkMode,
              activeThumbColor: Colors.blueAccent,
              onChanged: (bool value) {
                setState(() {
                  isDarkMode = value;
                });
              },
            ),
          ],
        ),
      ),
    );
  }
}
