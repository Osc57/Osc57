<script setup>
  import { ref, computed } from 'vue'

  const contador = ref(0);

  const arrayNumeros = ref([]); 
  
  const incrementa = () => contador.value++;

  const decrementa = () => contador.value--;
  
  const anadir = () => arrayNumeros.value.push(contador.value);

  const resetear = () => contador.value = 0;

  
  const estiloContador = computed(() => {
	if (contador.value > 0)
		return "text-success"
	else if (contador.value == 0)
		return "text-warning"
	else
		return "text-danger"
	})

    const bloquearBotonAnadir = computed( ()=>{
      const numBuscar = arrayNumeros.value.find((num) => num === contador.value );
      return numBuscar || numBuscar === 0;
    });
</script>

<template>
  <div class="contaier">
    <h2 :class="estiloContador" class="mb-3 text-center">{{ contador }}</h2>
    <div class="btn-group">
      <button @click="incrementa" class="btn btn-light">Incrementa</button>
      <button @click="decrementa" class="btn btn-light">Decrementa</button>
      <button @click="anadir" :disabled="bloquearBotonAnadir" class="btn btn-light">Añadir</button>
      <button @click="resetear" class="btn btn-light">Resetear</button>
    </div>

 

  </div>
  <table class="table table-striped ml-3">
    <thead>
      <th scope="col">Lista</th>
    </thead>
    <tbody>
     <tr scope="row" v-for="(num,index) in arrayNumeros" :key="index">
      {{ num }}
     </tr>
    </tbody>
  </table>
  <ul class="list-group">
    <li class="list-group-item" v-for="(num,index) in arrayNumeros" :key="index">
      {{ num }}

    </li>
</ul>
</template>


