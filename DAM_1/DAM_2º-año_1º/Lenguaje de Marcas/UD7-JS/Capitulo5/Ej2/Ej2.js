function sumaElementos(n){
    return n.reduce(function(contador , n){
        return contador + 1;
    },0);
}