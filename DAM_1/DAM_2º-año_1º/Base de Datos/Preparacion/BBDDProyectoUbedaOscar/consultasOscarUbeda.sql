/*Consultas relacionadas con el scriptBBDDOscarUbeda*/
/*Proyecto Bases de datos*/
/*Óscar Úbeda*/

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

SELECT dni_odontologo, COUNT(*) AS total_tratamientos FROM proporciona WHERE fecha > '2024-01-01' GROUP BY dni_odontologo;

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
/*Consulta que muestra a los odontologos que han hecho mas de 5 tratamientos*/

SELECT dni_odontologo, COUNT(*) AS cantidad_tratamientos FROM proporciona GROUP BY dni_odontologo HAVING COUNT(*) > 5;

mysql> SELECT dni_odontologo, COUNT(*) AS cantidad_tratamientos FROM proporciona GROUP BY dni_odontologo HAVING COUNT(*) > 5;
Empty set (0.00 sec)

/*9. Consulta en la que uses las cláusulas WHERE, HAVING y una subconsulta.*/
/*Consulta que muestra los clientes que tienen mas citas que el promedio*/

SELECT dni_cliente, COUNT(*) AS citas FROM cita WHERE fechaCita > '2024-01-01'GROUP BY dni_cliente
HAVING COUNT(*) > (SELECT AVG(citas) FROM (SELECT COUNT(*) AS citas FROM cita GROUP BY dni_cliente) AS promedios);

mysql> SELECT dni_cliente, COUNT(*) AS citas FROM cita WHERE fechaCita > '2024-01-01'GROUP BY dni_cliente
    -> HAVING COUNT(*) > (SELECT AVG(citas) FROM (SELECT COUNT(*) AS citas FROM cita GROUP BY dni_cliente) AS promedios);
Empty set (0.00 sec)

/*10. Consulta en la que utilices uno de los operadores de conjuntos (EXCEPT, INTERSECT o EXCEPT.*/
/*Consulta que mustra los odontologos que no son recepcionistas*/

SELECT dni FROM odontologo EXCEPT SELECT dni FROM recepcionista;

mysql> SELECT dni FROM odontologo EXCEPT SELECT dni FROM recepcionista;
+-----------+
| dni       |
+-----------+
| 11111111A |
+-----------+
1 row in set (0.00 sec)

/*Inserción, modificación y eliminacion*/

/*1. Inserción de datos a partir del resultado de una consulta.*/
/*Inserta los datos de la cita con id5*/

INSERT INTO historial (dni_cliente, id_tratamiento, fecha_tratamiento)
SELECT dni_cliente, id_tratamiento, fechaCita FROM cita WHERE id = 5;

mysql> INSERT INTO historial (dni_cliente, id_tratamiento, fecha_tratamiento)
    -> SELECT dni_cliente, id_tratamiento, fechaCita FROM cita WHERE id = 5;
Query OK, 0 rows affected (0.00 sec)
Records: 0  Duplicates: 0  Warnings: 0

/*2. Modificación de datos utilizando la cláusula WHERE junto con una subconsulta.*/
/*Modifica la direccion de los clientes con tratamiento nº 2*/

UPDATE cliente SET direccion = 'Calle villalobos'
WHERE dni IN (SELECT dni_cliente FROM cita WHERE id_tratamiento = 2);

mysql> UPDATE cliente SET direccion = 'Calle villalobos'
    -> WHERE dni IN (SELECT dni_cliente FROM cita WHERE id_tratamiento = 2);
Query OK, 1 row affected (0.01 sec)
Rows matched: 1  Changed: 1  Warnings: 0

/*3. Modificación de datos, de forma que el nuevo valor se obtenga mediante una subconsulta.*/
/*Modifica el tipo de tratamiento para todas las citas del cliente seleccionado*/

UPDATE cita SET id_tratamiento = (SELECT id FROM tratamientos WHERE tipo = 'Limpieza dental') WHERE dni_cliente = '12345678Z';

mysql> UPDATE cita SET id_tratamiento = (SELECT id FROM tratamientos WHERE tipo = 'Limpieza dental') WHERE dni_cliente = '12345678Z';
Query OK, 0 rows affected (0.00 sec)
Rows matched: 1  Changed: 0  Warnings: 0

/*4. Modificar o eliminar datos utilizando una consulta correlacionada.*/
/*Elimino todas las citas que no tienen registros correspondientes*/

DELETE FROM cita WHERE NOT EXISTS (SELECT 1 FROM historial WHERE historial.dni_cliente = cita.dni_cliente);

mysql> DELETE FROM cita WHERE NOT EXISTS (SELECT 1 FROM historial WHERE historial.dni_cliente = cita.dni_cliente);
Query OK, 0 rows affected (0.00 sec)


/*Vista, funcion, procedimiento y trigger*/

/*Vista*/
/*Muestro a los clientes que no han sido dados de baja*/

CREATE VIEW vista_clientes_activos ASSELECT dni, nombre, apellidos FROM cliente WHERE fechaDeBaja IS NULL;

/*Funcion*/
/*Funcion que devuelve cuántas citas tiene un cliente*/

DELIMITER //

CREATE FUNCTION contar_citas(dniCliente CHAR(9)) 
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE total_citas INT; -- Declaro variable
    SELECT COUNT(*) INTO total_citas FROM cita WHERE dni_cliente = dniCliente; -- Meto en la variable las citas que cuento de el cliente pasado por parámetro
    RETURN total_citas;-- Devuelvo 
END//

DELIMITER ;

mysql> SELECT contar_citas('12345678Z');
+---------------------------+
| contar_citas('12345678Z') |
+---------------------------+
|                         1 |
+---------------------------+
1 row in set (0.01 sec)

/*Procedimiento*/
/*Procedimiento que agrega una cita*/

DELIMITER //

CREATE PROCEDURE agregar_cita(IN p_dni_cliente CHAR(9),IN p_id_tratamiento INT,IN p_fecha DATETIME)
BEGIN
    INSERT INTO cita (dni_cliente, id_tratamiento, fechaCita) VALUES (p_dni_cliente, p_id_tratamiento, p_fecha); -- Introduzco en cita los valores dados por parámetro
END//

DELIMITER ;

mysql> CALL agregar_cita('12345678Z', 1, '2023-12-15 10:00:00');
Query OK, 1 row affected (0.01 sec)

/*Trigger*/
/*Trigger para pasar las citas automaticamente al historial*/

DELIMITER //

CREATE TRIGGER insertar_cita_historial
AFTER INSERT ON cita
FOR EACH ROW
BEGIN
    INSERT INTO historial (dni_cliente, id_tratamiento, fecha_tratamiento) VALUES (NEW.dni_cliente, NEW.id_tratamiento, NEW.fechaCita); --Le paso a historial los datos de la cita
END//

DELIMITER ;

mysql> DELIMITER //
mysql>
mysql> CREATE TRIGGER insertar_cita_historial
    -> AFTER INSERT ON cita
    -> FOR EACH ROW
    -> BEGIN
    ->     INSERT INTO historial (dni_cliente, id_tratamiento, fecha_tratamiento) VALUES (NEW.dni_cliente, NEW.id_tratamiento, NEW.fechaCita);
    -> END//
Query OK, 0 rows affected (0.01 sec)

mysql>








