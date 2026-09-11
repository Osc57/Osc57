<script setup>
import { ref, computed } from 'vue'

const contadorLocales = ref(0);
const contadorVisitante = ref(0);
const arrayLocales = ref([]);
const arrayVisitantes = ref([]);
const mostrarResultado = ref(false);

const incrementa1L = () => contadorLocales.value += 1;
const incrementa2L = () => contadorLocales.value += 2;
const incrementa3L = () => contadorLocales.value += 3;

const incrementa1V = () => contadorVisitante.value += 1;
const incrementa2V = () => contadorVisitante.value += 2;
const incrementa3V = () => contadorVisitante.value += 3;

const anadirEquipos = () => {
    arrayLocales.value.push(contadorLocales.value);
    arrayVisitantes.value.push(contadorVisitante.value);
    mostrarResultado.value = true;
    resetear();
}

const resetear = () => {
    contadorLocales.value = 0;
    contadorVisitante.value = 0;
}

const bloquearBotonAnadir = computed(() => {
    return contadorLocales.value === 0 && contadorVisitante.value === 0;
});
</script>

<template>
    <div class="container-fluid py-5" style="min-height: 100vh;">
        <div class="row text-center">
            <div>
                <h1 class="text-center">Marcador de Baloncesto</h1>
            </div>

            <div class="row text-center mb-4 justify-content-center">
                <div class="col-md-5">
                    <h2>Local</h2>
                    <h2 class="mb-3 display-4">{{ contadorLocales }}</h2>
                    <div class="d-flex justify-content-center gap-2">
                        <button @click="incrementa1L" class="btn btn-primary">+1</button>
                        <button @click="incrementa2L" class="btn btn-primary">+2</button>
                        <button @click="incrementa3L" class="btn btn-primary">+3</button>
                    </div>
                </div>

                <div class="col-md-2 d-flex align-items-center justify-content-center">
                    <img class="img-fluid" src="../assets/basketball.png" alt="Baloncesto" style="max-height: 150px;">
                </div>

                <div class="col-md-5">
                    <h2>Visitante</h2>
                    <h2 class="mb-3 display-4">{{ contadorVisitante }}</h2>
                    <div class="d-flex justify-content-center gap-2">
                        <button @click="incrementa1V" class="btn btn-danger">+1</button>
                        <button @click="incrementa2V" class="btn btn-danger">+2</button>
                        <button @click="incrementa3V" class="btn btn-danger">+3</button>
                    </div>
                </div>
            </div>

            <div>
                <button @click="resetear" class="btn btn-warning mx-2">Resetear</button>
                <button @click="anadirEquipos" :disabled="bloquearBotonAnadir" class="btn btn-success">Terminar
                    Partido</button>
            </div>
          
            <div v-if="arrayLocales.length > 0" class="mt-4 text-start">
                <h3>Resultados finales: </h3>
                <ul class="list-group">
                    <li class="list-group-item" v-for="(local, index) in arrayLocales" :key="index">
                        Resultado final: Local {{ local }} - Visitante {{ arrayVisitantes[index] }}
                    </li>
                </ul>
            </div>
        </div>
    </div>
</template>