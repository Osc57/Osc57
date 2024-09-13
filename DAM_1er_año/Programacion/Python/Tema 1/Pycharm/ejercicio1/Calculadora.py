def suma(sumando1, sumando2):
    result = sumando1 + sumando2
    return result
def resta(restando1, restando2):
    result = restando1 - restando2
    return result
def multiplicar(primer_elemento, segundo_elemento):
    result = primer_elemento * segundo_elemento
    return result
def dividir(dividir1, dividir2):
    result = dividir1/dividir2
    return result




if __name__ == '__main__':

    operacion = input("Introduce la operación a realizar: \n"
                "'s' para sumar\n"
                "'r' para restar\n"
                "'m' para multiplicar\n"
                "'d' para dividir\n")
    operando1 = int(input("Introduce el primer operando: "))
    operando2 = int(input("Introduce el segundo operando: "))


    match operacion:
        case 's':
            resultado = suma(operando1, operando2)
            print(f'El resultado de la suma es: {resultado}')
        case 'r':
            resultado = resta(operando1, operando2)
            print(f'El resultado de la resta es: {resultado}')
        case 'm':
            resultado = multiplicar(operando1, operando2)
            print(f'El resultado de la multiplicación es: {resultado}')
        case 'd':
            resultado = dividir(operando1, operando2)
            print(f'El resultado de tu división es: {resultado}')
        case _:
            print("Opción invalida")

