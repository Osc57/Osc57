/*1. Consulta en la que utilices el operador AND, LIKE y la cláusula ORDER BY.*/
/*Consulta que saca el nombre, apellido y telefono de los clientes que su apellido sea Gil y su telefono empiece por 9 ordenados por nombre alfabeticamente*/

SELECT nombre, apellidos, telefono FROM cliente WHERE apellidos LIKE '%Gil%' AND telefono LIKE '9%' ORDER BY nombre ASC;

mysql> SELECT nombre, apellidos, telefono FROM cliente WHERE apellidos LIKE '%Gil%' AND telefono LIKE '9%' ORDER BY nombre ASC;
+--------+----------------+-----------+
| nombre | apellidos      | telefono  |
+--------+----------------+-----------+
| Luis   | Hernández Gil  | 922222222 |
+--------+----------------+-----------+
1 row in set (0.00 sec)

/*2. Consulta en la que uses el operador IN junto con una subconsulta.*/
/*Consulta que muestra el id del tratamiento Limpieza dental*/

SELECT id FROM tratamientos WHERE tipo = 'Limpieza dental';

mysql> SELECT id FROM tratamientos WHERE tipo = 'Limpieza dental';
+----+
| id |
+----+
|  1 |
+----+
1 row in set (0.00 sec)

/*3. Consulta en la que uses el operador ALL junto con una subconsulta.*/
/*Consulta que muestra si hay un jefe para todos los empleados si no saldra emprty set*/

SELECT nombre FROM trabajadores WHERE dni = ALL (SELECT DISTINCT dni_jefe FROM trabajadores WHERE dni_jefe IS NOT NULL);

mysql> SELECT nombre FROM trabajadores WHERE dni = ALL (SELECT DISTINCT dni_jefe FROM trabajadores WHERE dni_jefe IS NOT NULL);
+--------+
| nombre |
+--------+
| Juan   |
+--------+
1 row in set (0.00 sec)

/*4. Consulta en la que utilices tres subconsultas, una dentro de otra.*/
/*Consulta que devuelve los clientes que recibieron el tratamiento 1*/

SELECT nombre FROM cliente WHERE dni IN (SELECT dni_cliente FROM historial WHERE id_tratamiento = (SELECT id FROM tratamientos WHERE tipo = (SELECT tipo FROM tratamientos WHERE id = 1)));

mysql> SELECT nombre FROM cliente WHERE dni IN (SELECT dni_cliente FROM historial WHERE id_tratamiento = (SELECT id FROM tratamientos WHERE tipo = (SELECT tipo FROM tratamientos WHERE id = 1)));
+--------+
| nombre |
+--------+
| Ana    |
+--------+
1 row in set (0.00 sec)

/*5. Consulta en la que sea necesario concatenar tres tablas usando JOIN y además haya una condición en un WHERE.*/
/*Consulta que muestra los recepcionistas que gestionaron las citas de limpieza dental y para que cliente*/

SELECT cliente.nombre AS nombre_cliente, trabajadores.nombre AS nombre_trabajador, tratamientos.tipo AS tipo_tratamiento 
FROM cliente 
JOIN cita ON cliente.dni = cita.dni_cliente 
JOIN trabajadores ON cita.id IN (SELECT id_cita FROM gestiona WHERE dni_recepcionista = trabajadores.dni) 
JOIN tratamientos ON cita.id_tratamiento = tratamientos.id 
WHERE tratamientos.tipo = 'Limpieza dental';

mysql> SELECT cliente.nombre AS nombre_cliente, trabajadores.nombre AS nombre_trabajador, tratamientos.tipo AS tipo_tratamiento
    -> FROM cliente
    -> JOIN cita ON cliente.dni = cita.dni_cliente
    -> JOIN trabajadores ON cita.id IN (SELECT id_cita FROM gestiona WHERE dni_recepcionista = trabajadores.dni)
    -> JOIN tratamientos ON cita.id_tratamiento = tratamientos.id
    -> WHERE tratamientos.tipo = 'Limpieza dental';
+----------------+-------------------+------------------+
| nombre_cliente | nombre_trabajador | tipo_tratamiento |
+----------------+-------------------+------------------+
| Ana            | María            | Limpieza dental  |
+----------------+-------------------+------------------+
1 row in set (0.00 sec)

/*6. Consulta en la que utilices la función COUNT, la cláusula WHERE y la operación JOIN.*/
/*Consulta que muestra todos los clientes con citas en 2024 y despues*/

SELECT COUNT(*) AS total_clientes FROM cliente JOIN cita ON cliente.dni = cita.dni_cliente WHERE cita.fechaCita > '2024-01-01';

mysql> SELECT COUNT(*) AS total_clientes FROM cliente JOIN cita ON cliente.dni = cita.dni_cliente WHERE cita.fechaCita > '2024-01-01';
+----------------+
| total_clientes |
+----------------+
|              3 |
+----------------+
1 row in set (0.00 sec)

/*7. Consulta en la que utilices la cláusula GROUP BY y la cláusula WHERE*/
/*Consulta que muestra cuantos tratamientos ha realizado cada odontologo desde 2024*/

SELECT dni_odontologo, COUNT(*) AS total_tratamientos FROM proporciona WHERE fecha > '2023-01-01' GROUP BY dni_odontologo;

mysql> SELECT dni_odontologo, COUNT(*) AS total_tratamientos FROM proporciona WHERE fecha > '2024-01-01' GROUP BY dni_odontologo;
+----------------+--------------------+
| dni_odontologo | total_tratamientos |
+----------------+--------------------+
| 11111111A      |                  1 |
| 22222222B      |                  1 |
| 33333333C      |                  1 |
+----------------+--------------------+
3 rows in set (0.00 sec)

/*8. Consulta en la que uses las cláusulas GROUP BY y HAVING.*/


/*9. Consulta en la que uses las cláusulas WHERE, HAVING y una subconsulta.*/


/*10. Consulta en la que utilices uno de los operadores de conjuntos (EXCEPT, INTERSECT o
EXCEPT.*/












































