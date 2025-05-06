<script setup>
  const nombre = "Óscar";
  const color = "color:aqua";
</script>

<template>
  <h1 v-bind:style="color">Hola {{ nombre.toUpperCase() }} !!</h1>
</template>

<style>

</style>
