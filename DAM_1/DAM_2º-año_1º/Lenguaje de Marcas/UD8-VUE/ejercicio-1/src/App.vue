<script setup>
const mensaje = "Hola, mundo"

let ganador = 1
const clase_danger = "alert alert-danger"
const clase_success = "alert alert-success"

</script>

<template>
  <div v-if="true" v-bind:class="clase_danger">{{ mensaje }}</div>
  <div v-else v-bind:class="clase_success">{{ mensaje }}</div>

  <div v-show="false" v-bind:class=clase_danger>{{ mensaje }}</div>
</template>
