package org.example.TerceraEvaluacion.Ej1

class Alumno(private val nombre: String, private val notas: List<Double>){


    fun media(): Double {
        var suma: Double = 0.0;
        var contador: Int = 0;

        for (n: Double in notas) {
            suma = n + suma;
            contador++;
        }
        return suma / contador;
    }

    fun estaAprobado(): Boolean {
        var aprobado = false;

        if (media() >= 5.0) {
            aprobado = true;
        }

        return aprobado;
    }

    override fun toString(): String {
        return "Alumno(nombre='$nombre', notas=$notas)"
    }

}