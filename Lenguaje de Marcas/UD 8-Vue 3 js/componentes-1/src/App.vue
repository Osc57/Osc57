<script setup>
  import { ref } from 'vue';
  import BlogPost from './components/BlogPost.vue';
  import ButtonCounter from './components/ButtonCounter.vue';

  // 1 - Me creo un array de objetos
  const posts = ref([
    
    { titulo: 'Post 01', id: 1, body:'descripcion 01'},
    { titulo: 'Post 02', id: 2, body:'descripcion 02'},
    { titulo: 'Post 03', id: 3, body:'descripcion 03'},
    { titulo: 'Post 04', id: 4, body:'descripcion 04'},
    { titulo: 'Post 05', id: 5, body:'descripcion 05'},
    { titulo: 'Post 06', id: 6, },
  
  ]);

  const favorito = ref('');

//Me creo una función para cambiar mi post favorito
  const cambiarFavorito = ( post ) => {
    favorito.value = post;
  }
</script>

<template>
  <div class="container">
    <h1>Componentes</h1>
    <h2>Mi Post Favorito: {{ favorito }}</h2>
    <!--
    <BlogPost titulo="Post 01" :id="1" body="Esto es mi descripción 01" colorText="primary"/>
    <BlogPost titulo="Post 02" :id="2" body="Esto es mi descripción 02" colorText="warning"/>
    <BlogPost titulo="Post 03" :id="3" body="Esto es mi descripción 03" colorText="danger"/>
    <BlogPost titulo="Post 04" :id="4" />
    -->
    <BlogPost v-for="post in posts" 
    :key="post.id" 
    :titulo="post.titulo" 
    :id="post.id" 
    :body="post.body"
    @cambiarNombreFavorito ="cambiarFavorito"
    />
  </div>

  
</template>