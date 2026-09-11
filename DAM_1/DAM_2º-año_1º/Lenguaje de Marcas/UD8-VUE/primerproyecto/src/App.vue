<script setup>
const nombre = "Óscar";
const color = "color:red";
const esMartes = null;
const dias = ["Lunes", "Martes", "Miercoles", "Miercoles", "Jueves", "Viernes", "Sábado", "Domingo"];
const activo = false;
const arrayFrutas = ["🍎", "🍌", "🍉", "🍓", "🍒"];
</script>

<template>

  <h1 v-bind:style="color">Hola {{ nombre }} !!</h1>
  <!--
  <h2>{{ esMartes ? "Hoy es Martes" : "Hoy NO es Martes" }}</h2>
  <h2>{{ dias[2] }}</h2>
  
  <h2 v-if="esMartes === true">Es Martes</h2>
  <h2 v-else-if="esMartes === false">NO es Martes</h2>
  <h2 v-else>No tengo NI IDEA de que día es</h2>

  <h2 v-show="activo">Estoy en true</h2>
  -->
  <ul>
    <li v-for="(fruta, index) in arrayFrutas" :key="index">
      {{ index }} - {{ fruta }}
    </li>
  </ul>
</template>

<style>

</style>
