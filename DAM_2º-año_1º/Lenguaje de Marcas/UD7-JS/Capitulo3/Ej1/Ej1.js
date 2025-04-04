for(i = 2; i <= 100; i++){
    let j = 2
    let esPrimo = true 

    while((j < i) && (esPrimo)){
        if ( i % j == 0){
            esPrimo = false
        }
        j++
    }

    if(esPrimo){
        console.log(i + " es Primo")
    }else{
        console.log(i + " NO es Primo")
    }
}