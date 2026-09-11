let frutas = ["manzana", "plátano", "naranja","sandía","manzana","plátano", "naranja","sandía","melón"];

function contador(array_frutas){
    let map = new Map();

    for (let i = 0; i < array_frutas.length; i++) {
        if(map.has(array_frutas[i])){
            map.set(array_frutas[i],map.get(array_frutas[i]) + 1);
        }else{
            map.set(array_frutas[i], 1);
        }
    }
    return map;
}

console.log(contador(frutas))