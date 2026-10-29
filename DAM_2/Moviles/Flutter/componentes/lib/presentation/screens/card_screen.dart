import 'package:flutter/material.dart';

import '../widgets/card_personalizada.dart';
import '../widgets/card_personalizada2.dart';

class CardScreen extends StatelessWidget {
  const CardScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Tarjetas - Cards')),
      body: ListView(
        padding: EdgeInsets.symmetric(horizontal: 20, vertical: 10),
        children: [CardTipo1(), CardTipo2()],
      ),
    );
  }
}
