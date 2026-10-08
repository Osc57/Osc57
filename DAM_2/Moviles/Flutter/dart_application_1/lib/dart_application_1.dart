void main(){
  
  List<String> listaAlumnos = [
    'Ana',
    'Luis',
    'Marta'
  ];

  print(listaAlumnos);

  listaAlumnos.add('Pedro');

  for (var alumno in listaAlumnos){
    print(alumno);
  }
}
