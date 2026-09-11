/** 
let operacion = prompt("Dime la operación que quieres hacer (suma/resta/multiplicacion/division): ")
let n1 = parseFloat(prompt("Dime un número"))
let n2 = parseFloat(prompt("Dime otro número"))

if (operacion == "suma") {

    console.log(`La suma de ${n1} y ${n2} es ${n1 + n2}`)

} else if (operacion == "resta") {
    console.log(`La resta de ${n1} y ${n2} es ${n1 - n2}`)

} else if (operacion == "multiplicacion") {
    console.log(`La multiplicación de ${n1} y ${n2} es ${n1 * n2}`)

} else if (operacion == "division") {
    console.log(`La division de ${n1} y ${n2} es ${n1 / n2}`)

} else {
    console.log("ERROR")
}
**/

let continuar = true;

while (continuar) {
    let operacion = prompt("Dime la operación que quieres hacer:\n(suma/resta/multiplicacion/division)\no escriba salir para terminar");

    if (operacion == "salir") {
        console.log("Has salido de la calculadora")
        continuar = false;
        break;
    }

    if (["suma", "resta", "multiplicacion", "division"].includes(operacion)) {
        let n1 = parseFloat(prompt("Dime un número:"));
        let n2 = parseFloat(prompt("Dime otro número:"));

        let resultado;
        switch (operacion) {
            case "suma":
                resultado = n1 + n2;
                break;
            case "resta":
                resultado = n1 - n2;
                break;
            case "multiplicacion":
                resultado = n1 * n2;
                break;
            case "division":
                if (n2 === 0) {
                    console.log("No se puede dividir por cero.");
                    continue;
                }
                resultado = n1 / n2;
                break;
        }
        console.log(`Operación: ${operacion}`)
        console.log(`Número 1: ${n1}`)
        console.log(`Número 2: ${n2}`)
        console.log(`Resultado: ${resultado}`);
    } else {
        console.log("ERROR");
    }
}





