<script setup>
import { ref, computed } from 'vue'

const tareas = ref([
    { id: 1, texto: 'Preparar actividad de Vue', completada: false },
    { id: 2, texto: 'Revisar el examen de Lenguaje de Marcas', completada: false },
    { id: 3, texto: 'Corregir pr�cticas de Bootstrap', completada: true },
    { id: 4, texto: 'Subir notas al aula virtual', completada: false },
    { id: 5, texto: 'Enviar recordatorio a los alumnos', completada: true }
])

const encontrarTarea = (id) => {
    const tarea = tareas.value.find(t => t.id === id);
    if (tarea) {
        tarea.completada = !tarea.completada;
    }
}
</script>

<template>
    <div class="container py-5">
        <div class="container py-5">
            <div class="mt-5">
                <h1 class="text-center">Óscar - Ejercicio 3: Lista de Tareas</h1>

                <ul class="list-group mt-3">
                    <li v-for="tarea in tareas" :key="tarea.id"
                        class="list-group-item d-flex justify-content-between align-items-center"
                        :class="{ 'text-decoration-line-through text-muted': tarea.completada }">
                        {{ tarea.texto }}

                        <button @click="encontrarTarea(tarea.id)"
                            :class="['btn', 'btn-sm', tarea.completada ? 'btn-success' : 'btn-warning']">
                            {{ tarea.completada ? 'Finalizado' : 'Pendiente' }}
                        </button>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</template>

<style scoped>
.text-decoration-line-through {
    text-decoration: line-through;
}
</style>