import 'dart:convert';

List<Post> postFromJson(String str) => List<Post>.from(json.decode(str).map((x) => Post.fromJson(x)));

String postToJson(List<Post> data) => json.encode(List<dynamic>.from(data.map((x) => x.toJson())));

// Este archivo contiene el modelo de datos 'Post' 
// y las funciones para convertir el JSON de la API y objetos de Dart.
class Post {

  Post({
    required this.userId,
    required this.id,
    required this.title,
    this.body
  });

  int userId;
  int id;
  String title;
  String? body;

  // Constructor de fabrica: crea un Post leyendo los campos del JSON
  factory Post.fromJson(Map<String, dynamic> json) => Post(
    // Lee el valor del JSON y lo asigna a cada propiedad
    userId: json["userId"], 
    id: json["id"], 
    title: json["title"],
    body: json["body"]
  );

  // Devuelve un Mapa con las propiedades del objeto, listo para codificar como JSON
  Map<String, dynamic> toJson() => {
    "userId": userId,
    "id": id,
    "title": title,
    "body": body
  };

}