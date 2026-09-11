class Calculadora:
    n1 = 0
    n2 = 0

    def __init__(self, n1, n2):
        self.n1 = n1
        self.n2 = n2

    def sumar(self):
        suma = self.n1 + self.n2
        print(f'El resultado de la suma es: {suma}')

    def restar(self):
        resta = self.n1 - self.n2
        print(f'El resultado de la resta es: {resta}')

    def multiplicar(self):
        multiplicacion = self.n1 * self.n2
        print(f'El resultado de la multiplicación es: {multiplicacion}')

    def division(self):
        dividir = self.n1 / self.n2
        print(f'El resultado de la división es: {dividir}')


n1 = float(input("Dime un número: "))
n2 = float(input("Dime otro número: "))

calculadora = Calculadora(n1, n2)

calculadora.sumar()
calculadora.restar()
calculadora.division()
calculadora.multiplicar()