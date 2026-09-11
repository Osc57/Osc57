package org.example.TerceraEvaluacion.Ej1


fun devolverAprobados(alumnos: ArrayList<Alumno>): ArrayList<Alumno> {
    val aprobados: ArrayList<Alumno> = ArrayList();

    for (a: Alumno in alumnos) {
        if (a.estaAprobado()) {
            aprobados.add(a);
        }
    }

    return aprobados;
}

fun main() {

}
