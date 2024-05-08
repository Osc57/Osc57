<script setup>
  import BlogPost from './components/BlogPost.vue';
  import ButtonCounter from './components/ButtonCounter.vue';
  
</script>

<template>
  <div class="container">
    <h1>Componentes</h1>
    <ButtonCounter></ButtonCounter>
    <BlogPost titulo="Post 01" :id="1" body="Esto es mi descripción 01" colorText="primary"/>
    <BlogPost titulo="Post 02" :id="2" body="Esto es mi descripción 02" colorText="warning"/>
    <BlogPost titulo="Post 03" :id="3" body="Esto es mi descripción 03" colorText="danger"/>
    <BlogPost titulo="Post 04" :id="4"/>

  </div>
  

</template>