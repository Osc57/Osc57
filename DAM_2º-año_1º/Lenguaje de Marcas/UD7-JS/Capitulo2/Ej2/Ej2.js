let operacion = prompt("Dime la operación que quieres hacer (suma/resta/multiplicacion/division): ")
let n1 = prompt("Dime un número")
let n2 = prompt("Dime otro número")
if(operacion=="suma"){
    console.log(`La suma de ${n1} y ${n2} es ${n1+n2}`)
}else if (operacion=="resta"){
    if(n1 > n2){
        console.log(`La resta de ${n1} y ${n2} es ${n1-n2}`)
    }else{
        console.log(`La resta de ${n2} y ${n1} es ${n2-n1}`)
    }
}else if(operacion=="multiplicacion"){
    console.log(`La multiplicación de ${n1} y ${n2} es ${n1*n2}`)
}else if(operacion=="division"){
    if(n1 < 0){
        console.log("ERROR")
    }else{
        console.log(`La division de ${n1} y ${n2} es ${n1/n2}`)
    }
}else{
    console.log("ERROR")
}