void main() {
  final miCuadrado = Cuadrado(lado: 3);

  miCuadrado.lado = 5; 

  print('Área: ${miCuadrado.area}');
}

class Cuadrado {
  double _lado;

  Cuadrado({required double lado})
      : assert(lado >= 0, 'El lado debe ser mayor o igual a cero'),
        _lado = lado;

  double get lado => _lado;

  set lado(double valor) {
    if (valor < 0) {
      throw ArgumentError('El valor debe ser mayor o igual a cero');
    }
    _lado = valor;
  }

  double get area {
    return _lado * _lado;
  }
}
