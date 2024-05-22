<script setup>
    //Hemos de crear la logica para importar la información en especifico
    import axios from 'axios';
    //useRoute es lo que tiene acceso a todos los parametros que pasemos
    import { useRoute, useRouter } from 'vue-router';
    const route = useRoute();

    const router = useRouter();
    const volver = () => {
        router.push('/pokemons');
    }


    const getData = async () => {
        try{
            const data = await axios.get(`https://pokeapi.co/api/v2/pokemon/${route.params.name}`);
            console.log(data);
        }catch(error){
            console.log(error);
        }
    }


    getData();
</script>

<template>
    <h1>Detalle Pokemon: {{ $route.params.name }}</h1>
    <button @click="volver">Volver</button>



</template>