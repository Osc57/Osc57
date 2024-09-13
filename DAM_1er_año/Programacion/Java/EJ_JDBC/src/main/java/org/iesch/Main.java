package org.iesch;


import org.iesch.bbdd.DatabaseCRUD;
import org.iesch.persona.Alumno;

public class Main {
    public static void main(String[] args) {
        DatabaseCRUD dbcrud = new DatabaseCRUD();

        Alumno alumno = new Alumno("Alberto","Chicote del Olmo","C/La Parra nº2");
        Alumno alumno2 = new Alumno("Julio","Fernandez Suarez","C/Rojo nº7");
        Alumno alumno3 = new Alumno("Guillermo","Lorente Francisco","C/Calle Normal nº2");
        Alumno alumno4 = new Alumno("Lionel","Andres Messi","C/Campeon del Mundo nº3");
        Alumno alumno5 = new Alumno("Javier","Eduardo Perez","C/Las Buenas Noches nº2");
        Alumno alumno6 = new Alumno("Mariano","Rajoy Brey","C/El PP nº98");
        Alumno alumno7 = new Alumno("Paco","Martinez Alberado","C/Rojo nº3");
        Alumno alumno8= new Alumno("Jose","Manuel Alvarez","C/Esternocleidomastoideo nº5");
        Alumno alumno9 = new Alumno("Pablo","Lopez Martin","C/La Esquina nº2");
        Alumno alumno10 = new Alumno("Maria","Rubio Sanchez","C/Gaviotas nº56");


        dbcrud.inserta(alumno);
        dbcrud.inserta(alumno2);
        dbcrud.inserta(alumno3);
        dbcrud.inserta(alumno4);
        dbcrud.inserta(alumno5);
        dbcrud.inserta(alumno6);
        dbcrud.inserta(alumno7);
        dbcrud.inserta(alumno8);
        dbcrud.inserta(alumno9);
        dbcrud.inserta(alumno10);
    }
}