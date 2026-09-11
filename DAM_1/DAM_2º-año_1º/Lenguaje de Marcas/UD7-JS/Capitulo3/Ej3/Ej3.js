let a = 0;
let b = 1;
let resultado = [a, b];

for (let i = 2; i <= 10; i++) {
    let c = a + b;
    resultado.push(c)
    a = b;
    b = c;
}
console.log(resultado.join(","))


