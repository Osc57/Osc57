<template>
  <div class="app-container">
    <Ejercicio2 />
    <Ejercicio3 />
  </div>
</template>

<script setup>
import Ejercicio2 from './components/Ejercicio2.vue';
import Ejercicio3 from './components/Ejercicio3.vue';
</script>

<style>
.app-container {
  max-width: 800px;  /* Ancho máximo para evitar que se expandan demasiado */
  margin: 0 auto;    /* Centrado horizontal */
  padding: 0;        /* Elimina padding externo */
}
</style>
