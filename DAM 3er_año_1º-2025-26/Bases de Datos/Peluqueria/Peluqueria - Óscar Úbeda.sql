/*PRUEBA PARA PRACTICAR EXAMEN UD6-UD7 - ÓSCAR ÚBEDA*/
/*Ej1*/
mysql> SELECT * FROM servicio WHERE id IN (SELECT id_servicio FROM empleado_servicio WHERE id_empleado IN (SELECT id FROM empleado WHERE nombre = 'Rigoberta'));
+----+----------------+--------+-------------------------------------------------+------------+--------+
| id | nombre         | genero | detalles                                        | valoracion | tiempo |
+----+----------------+--------+-------------------------------------------------+------------+--------+
|  1 | cortar         | mujer  | Cada corte es unico y personal                  |      20.00 |     30 |
|  2 | cortar         | hombre | Cada corte es unico y personal                  |      16.00 |     20 |
|  3 | balayage       | mujer  | Nuestra tecnica aporta lumnosidad y naturalidad |      45.00 |     60 |
|  7 | tinte de color | unisex | Pelo multicolor                                 |      85.00 |     70 |
+----+----------------+--------+-------------------------------------------------+------------+--------+
4 rows in set (0.034 sec)

/*Ej2*/
mysql> SELECT * FROM empleado WHERE id NOT IN (SELECT id_empleado FROM empleado_servicio);
+----+--------+----------+---------------+-------------------------+----------------+---------+------------+--------+---------+-----------+
| id | nombre | apellido | email         | detalles                | fecha_contrato | salario | salon      | activo | id_jefe | localidad |
+----+--------+----------+---------------+-------------------------+----------------+---------+------------+--------+---------+-----------+
|  8 | Saul   | Morales  | saul@pelu.com | Saul es estupendo.      | 2020-03-20     | 1000.00 | Ensanche   | Y      |    NULL | Teruel    |
|  9 | Otro   | Otra     | otro@pelu.com | Otro es otro.           | 2020-03-20     |  900.00 | Ensanche   | Y      |       8 | Jaen      |
| 11 | Bruce  | Lee      | lee@pelu.com  | Bruce lucha como nadie. | 2021-04-24     | 1500.00 | Fuenfresca | Y      |    NULL | Utrillas  |
+----+--------+----------+---------------+-------------------------+----------------+---------+------------+--------+---------+-----------+
3 rows in set (0.009 sec)

/*Ej3*/
mysql> SELECT * FROM empleado e WHERE salario > (SELECT salario FROM empleado WHERE id = e.id_jefe);
+----+---------+----------+---------------+------------------------------------------------+----------------+---------+----------+--------+---------+-----------+
| id | nombre  | apellido | email         | detalles                                       | fecha_contrato | salario | salon    | activo | id_jefe | localidad |
+----+---------+----------+---------------+------------------------------------------------+----------------+---------+----------+--------+---------+-----------+
|  3 | Rosalia | Vila     | lia@pelu.com  | Rosalia es una apasianada de la manicura.      | 2019-08-11     | 1300.00 | Romareda | Y      |       1 | Calamocha |
|  4 | Raquel  | Loreal   | lore@pelu.com | Raquel es una apasianada de la transformacion. | 2020-08-11     | 1300.00 | Centro   | Y      |       1 | Teruel    |
| 10 | Rosa    | Perez    | rosa@pelu.com | Rosa corta barbas.                             | 2021-03-10     | 1100.00 | Ensanche | Y      |       8 | Valencia  |
+----+---------+----------+---------------+------------------------------------------------+----------------+---------+----------+--------+---------+-----------+
3 rows in set (0.007 sec)

/*Ej4*/
mysql> SELECT nombre FROM empleado WHERE id IN (SELECT id_empleado FROM detalle_evento WHERE id_evento IN (SELECT id FROM evento WHERE nombre = 'Hamlet')) AND 
id IN (SELECT id_empleado FROM empleado_servicio WHERE id_servicio IN (SELECT id FROM servicio WHERE nombre = 'maquillar'));
+---------+
| nombre  |
+---------+
| Rosalia |
+---------+
1 row in set (0.011 sec)

/*Ej5*/
mysql> SELECT nombre FROM empleado WHERE id IN (SELECT id_empleado FROM empleado_servicio WHERE id_servicio IN (SELECT id FROM servicio WHERE nombre = 'cortar' AND genero = 'mujer')) AND id IN (SELECT id_empleado FROM empleado_servicio WHERE id_servicio IN (SELECT id FROM servicio WHERE nombre = 'cortar' AND genero = 'hombre'));
+-----------+
| nombre    |
+-----------+
| Aitana    |
| Rigoberta |
+-----------+
2 rows in set (0.009 sec)

/*Ej6*/
mysql> SELECT DISTINCT(e.nombre), SUM(precio) AS Recaudado FROM empleado e JOIN cita c ON e.id = c.id_empleado GROUP BY c.id_empleado;
+-----------+-----------+
| nombre    | Recaudado |
+-----------+-----------+
| Aitana    |    160.00 |
| Ana       |     16.00 |
| Eva       |     16.00 |
| Omar      |     32.00 |
| Peter     |     16.00 |
| Ramon     |     32.00 |
| Raquel    |     68.00 |
| Rigoberta |    247.00 |
| Rosa      |     16.00 |
| Rosalia   |     36.00 |
+-----------+-----------+
10 rows in set (0.010 sec)

/*Ej7*/
mysql> SELECT c.nombre, c.telefono, COUNT(ci.id_empleado) AS Numero_Citas FROM cliente c JOIN cita ci ON c.id = ci.id_cliente WHERE DATE(fecha_cita) LIKE '%-02-%' GROUP BY ci.id_cliente HAVING Numero_Citas > 2;
+----------+----------+--------------+
| nombre   | telefono | Numero_Citas |
+----------+----------+--------------+
| Vladimir | 007      |            3 |
| Donald   | 008      |            3 |
+----------+----------+--------------+
2 rows in set (0.009 sec)

/*Ej8*/
mysql> SELECT e.nombre, COUNT(es.id_empleado) AS Numero_Servicios FROM empleado e JOIN empleado_servicio es ON e.id = es.id_empleado WHERE e.salon = 'Romareda' GROUP BY e.nombre;
+-----------+------------------+
| nombre    | Numero_Servicios |
+-----------+------------------+
| Aitana    |                4 |
| Rigoberta |                4 |
| Rosalia   |                2 |
+-----------+------------------+
3 rows in set (0.007 sec)

/*Ej9*/
mysql> SELECT DISTINCT(e.nombre), SUM(precio) AS Recaudado FROM empleado e JOIN cita c ON e.id = c.id_empleado GROUP BY c.id_empleado HAVING Recaudado > (SELECT AVG(c.precio));
+-----------+-----------+
| nombre    | Recaudado |
+-----------+-----------+
| Aitana    |    160.00 |
| Omar      |     32.00 |
| Ramon     |     32.00 |
| Raquel    |     68.00 |
| Rigoberta |    247.00 |
| Rosalia   |     36.00 |
+-----------+-----------+
6 rows in set (0.025 sec)

/*Ej10*/
