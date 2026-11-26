import 'package:api_rest_1/models/post.dart';
import 'package:api_rest_1/services/posts_service.dart';
import 'package:flutter/material.dart';

class PostsScreen extends StatefulWidget {
  const PostsScreen({super.key});

  @override
  State<PostsScreen> createState() => _PostsScreenState();
}

class _PostsScreenState extends State<PostsScreen> {

  // Lista de Post: la inicializo a null mientras no haya datos disponibles.
  List<Post>? listaPosts;
  // Indicador para decir si está cargando o ha terminado la carga.
  bool isLoading = false;

  @override
  void initState() {
    super.initState();
    // TODO: Aqui iniciaré la carga de los Posts de la API
    obtenerPosts();
  }
  // Obtener las publicaciones 
  void obtenerPosts() async{
    listaPosts = await PostsService().obtenerPosts();
    // Aqui solo marcaremos la carga como completada si se recibió una respuesta válida
    if (listaPosts != null ){
      setState(() {
        isLoading = true;
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Post')),
      body: Visibility(
        visible: isLoading,
        replacement: Center(child: CircularProgressIndicator.adaptive(),),
        child: ListView.builder(
          itemCount: listaPosts?.length,
          itemBuilder: (context, index) {
            return Row(
              children: [
                Container(
                  height: 50,
                  width: 50,
                  decoration: BoxDecoration(
                    borderRadius: .circular(12),
                    color: Colors.lightBlueAccent
                  ),
                ),
                SizedBox(width: 16,),
                Expanded(
                  child: Column(
                    crossAxisAlignment: .start,
                    children: [
                      Text(listaPosts![index].title, maxLines: 2, overflow: .ellipsis, style: TextStyle(fontSize: 14,fontWeight: .bold),),
                      Text(listaPosts![index].body ?? '', maxLines:  3, overflow: .ellipsis,),
                    ],
                  ),
                ),
              ],
            );
          },
        ),
      ),
    );
  }
}
