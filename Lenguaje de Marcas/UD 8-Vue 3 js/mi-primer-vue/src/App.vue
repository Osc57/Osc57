<!--
<style>
  h1 {
    color: red;
  }
</style>

<script setup>
  const nombre = "Luis";
  const estilo = "color:blue";
  const estado = true;
  const colores = ["blue", "red", "green"];
  const contador = 6;
</script>
-->
<!--
<template>
  <h1>Hola {{ nombre.toUpperCase() }}</h1>
   <h2 :style="estilo">Hola a toda la clase de DAM 1. Soy azul</h2>
  <h2>{{ activo ? "Estoy activo" : "Estoy inactivo" }}</h2>
  <h2 v-bind:style="`color: ${colores[2]}`"> Color con interpolación.</h2>
  <h2>Contador: {{ contador + 2 }}</h2>

  Esto no se puede hacer
  <p>{{ if (activo) { return contador} }}</p>-->

  <!-- 
  <p v-if="nombre==='Oscar'">Mi nombre es Óscar</p>

  <h1 v-show="contador===1">El contador el igual a 1</h1>

  <div v-if="estado === true">
    <p>Hola estoy activo</p>
    <p>Me mola la clase de DAM 1 Hoy</p>
  </div>
  <p v-else-if="estado === false">Hola NO estoy activo</p>
  <p v-else>Hola, aquí no voy a entrar NUNCA</p>

</template>
  -->
  <script setup>
      const nombre = "Vue 3"
      const arrayFrutas =["🍎","🍌","🍉","🍓","🍒"];
  </script>
<template>
  <h1>Hola {{ nombre }}</h1>
  <ul>
    <li v-for = " (fruta, index) in arrayFrutas"
        :key="index"
    >
      {{ index + 1 }} - {{ fruta }}
    </li>
  </ul>
</template>
<style>
  h1 {
    color: red;
  }
</style>






















