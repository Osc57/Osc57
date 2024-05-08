<script setup>

defineProps(['titulo', 'body', 'id','colorText']);
</script>

<template>
    <div class="card">
        <div class="card-body">
            <h5 class="card-title" :class="'text-${colorText}'">{{ id }} - {{ titulo }}</h5>
            <p>{{ body }}</p>
        </div>
    </div>
</template>