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
----------------------------------------------------------------------------------------
  -->
<!--
  <script setup>
      const nombre = "Vue 3"
      const arrayFrutas =["🍎","🍌","🍉","🍓","🍒"];
  </script>
<template>
  <h1>Hola {{ nombre }}</h1>
  <ul>
  -->
    <!-- El :key ha de ser algo que no se repita en el elemento -->
    <!-- 
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
----------------------------------------------------------------------------------------
-->
<!--
<script setup>
    const name = "Vue 3";
    const arrayFrutas = [
        {
            name: "Manzana",
            price: "$1.00",
            description: "Una manzana",
        },
        {
            name: "Pera",
            price: "$2.00",
            description: "Una pera",
        },
        {
            name: "Naranja",
            price: "$3.00",
            description: "Una naranja",
        },
    ];
</script>

<template>
    <h1>Hola {{ name }}!</h1>
    <ul>
        <li v-for = " (fruta, index) in arrayFrutas"
          :key="index"
        >
        {{ fruta.name }} - {{ fruta.description }} - {{ fruta.price }}
        </li>
    </ul>
</template>
----------------------------------------------------------------------------------------
-->
<!--
<script setup>
    const nombre = "Vue 3";

    //método hacerClick
    const hacerClick = ( mensaje ) => {
      console.log( mensaje );
    }

</script>

<template>
  <h1>Hola {{ nombre }}</h1>
  <button v-on:click.left="hacerClick('Click desde el Botón 1')">Boton 1</button>
  <button @click.middle="hacerClick('Click desde el botón 2')">Botón 2</button>
  <button @click.right="hacerClick('Click desde el botón 2')">Botón 3</button>

</template>

<style>
  h1 {
    color: red;
  }
</style>
----------------------------------------------------------------------------------------
-->
<script setup>
import { ref, computed } from 'vue';

const nombre = "Vue 3"
//Voy a convertir el contador en una variable reactiva
  const contador = ref(0);

  const arrayFavoritos = ref([]);

  const incrementar = () => {
    //contador++
    contador.value++;
  }
  const decrementar = () => {
    contador.value--;
  }

  const resetear = () => {
    contador.value = 0;
  }

  const anadir = () => {
    arrayFavoritos.value.push(contador.value);
  }

  const claseContador = computed(()=>{
    if ( contador.value === 0 ) return 'zero';
    return contador.value > 0 ? 'positive' : 'negative';
  });

  const bloquearBotonAdd = computed( () => {
    const numSearch = arrayFavoritos.value.find((num) => num === contador.value );
    //console.log(numSearch);
    //if (numSearch === 0) return true;

    //return numSearch ? true : false;
    return numSearch || numSearch === 0;
    
  })


</script>
<template>
  <h1>Hola {{ nombre }}</h1>
  <h2 :class="claseContador">{{ contador }}</h2>
  <button @click="incrementar">Incrementar</button>
  <button @click="decrementar">Decrementar</button>
  <button @click="resetear">Resetear</button>
  <button @click="anadir":disabled="bloquearBotonAdd">Añadir</button>
  
  <ul>
    <li
      v-for="(num, index) in arrayFavoritos":key="index">
      {{ num }}
    </li>
      
  </ul>
</template>
<style>
  h1{
    color: red;
  }
  .negative{
    color: red;
  }
  .positive{
    color: green;
  }
  .zero{
    color: peru;
  }
</style>
----------------------------------------------------------------------------------------






















