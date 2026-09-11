/*Ej1*/
mysql> SELECT nombre FROM investigadores 
WHERE facultad IN (SELECT idfacultad FROM facultades WHERE nomfacultad='Ciencias Matematicas');
+--------+
| nombre |
+--------+
| Luis   |
| Ana    |
| Sonia  |
+--------+
3 rows in set (0.00 sec)

/*Ej2*/
mysql> SELECT * FROM reservas 
WHERE idequipo IN (SELECT idequipo FROM equipos WHERE descripcion='Telemetro laser SICK');
+-----------+----------+------------+------------+
| DNI       | IdEquipo | FInicio    | FFin       |
+-----------+----------+------------+------------+
| 11111111X | H555     | 2024-05-11 | 2024-12-06 |
+-----------+----------+------------+------------+
1 row in set (0.00 sec)

/*Ej3*/
mysql> SELECT * FROM reservas 
WHERE dni IN (SELECT dni FROM investigadores 
WHERE facultad IN (SELECT idfacultad FROM facultades 
WHERE nomfacultad='Ciencias Geologicas'));
+-----------+----------+------------+------------+
| DNI       | IdEquipo | FInicio    | FFin       |
+-----------+----------+------------+------------+
| 55555555I | K111     | 2024-11-15 | 2024-10-06 |
| 66666666D | H222     | 2024-09-05 | 2024-10-06 |
+-----------+----------+------------+------------+
2 rows in set (0.00 sec)

/*Ej4*/
mysql> SELECT * FROM reservas 
WHERE dni IN (SELECT dni FROM investigadores
WHERE facultad IN (SELECT idfacultad FROM facultades 
WHERE nomfacultad='Ciencias Geologicas') AND beca > 2000 AND beca<6000);
Empty set (0.00 sec)

/*Ej5*/
mysql> SELECT * FROM reservas 
WHERE idequipo='H222' AND dni IN (SELECT dni FROM investigadores 
WHERE facultad IN (SELECT idfacultad FROM facultades 
WHERE nomfacultad='Ciencias Geologicas'));
+-----------+----------+------------+------------+
| DNI       | IdEquipo | FInicio    | FFin       |
+-----------+----------+------------+------------+
| 66666666D | H222     | 2024-09-05 | 2024-10-06 |
+-----------+----------+------------+------------+
1 row in set (0.00 sec)

/*Ej6*/
 SELECT * FROM reservas 
 WHERE dni IN (SELECT dni FROM investigadores 
 WHERE facultad IN (SELECT idfacultad FROM facultades 
 WHERE nomfacultad='Ciencias Geologicas')) AND idequipo IN (SELECT idequipo FROM equipos 
 WHERE idfacultad=(SELECT idfacultad FROM facultades 
 WHERE nomfacultad='Ciencias Quimicas'));
Empty set (0.00 sec)