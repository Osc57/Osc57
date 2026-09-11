/*Script multitablas de la base de datos*/
/*Fecha 21/01/2025*/

/*Ej1*/
mysql> SELECT dni,nombre,apellidos,beca,facultad,activo,facultades.nomfacultad FROM investigadores 
JOIN facultades ON investigadores.facultad=facultades.idfacultad;
+-----------+--------+-----------+----------+----------+--------+----------------------+
| dni       | nombre | apellidos | beca     | facultad | activo | nomfacultad          |
+-----------+--------+-----------+----------+----------+--------+----------------------+
| 11111111X | Luis   | Lopez     |  5250.78 |        1 | S      | Ciencias Matematicas |
| 22222222K | Ana    | Gracia    |  3000.50 |        1 | S      | Ciencias Matematicas |
| 33333333P | Sonia  | Gomez     |  2000.50 |        1 | S      | Ciencias Matematicas |
| 44444444R | Raquel | Raya      |  8000.50 |        3 | N      | Ciencias Quimicas    |
| 55555555I | Pedro  | Martinez  | 45000.30 |        4 | S      | Ciencias Geologicas  |
| 66666666D | Sara   | Salas     |  8000.00 |        4 | S      | Ciencias Geologicas  |
+-----------+--------+-----------+----------+----------+--------+----------------------+
6 rows in set (0.00 sec)

/*Ej2*/
mysql> SELECT investigadores.*,facultades.nomfacultad FROM facultades 
LEFT JOIN investigadores ON facultades.idfacultad=investigadores.facultad;
+-----------+--------+-----------+----------+----------+--------+----------------------+
| DNI       | nombre | apellidos | beca     | facultad | activo | nomfacultad          |
+-----------+--------+-----------+----------+----------+--------+----------------------+
| 33333333P | Sonia  | Gomez     |  2000.50 |        1 | S      | Ciencias Matematicas |
| 22222222K | Ana    | Gracia    |  3000.50 |        1 | S      | Ciencias Matematicas |
| 11111111X | Luis   | Lopez     |  5250.78 |        1 | S      | Ciencias Matematicas |
| NULL      | NULL   | NULL      |     NULL |     NULL | NULL   | Ciencias Fisicas     |
| 44444444R | Raquel | Raya      |  8000.50 |        3 | N      | Ciencias Quimicas    |
| 66666666D | Sara   | Salas     |  8000.00 |        4 | S      | Ciencias Geologicas  |
| 55555555I | Pedro  | Martinez  | 45000.30 |        4 | S      | Ciencias Geologicas  |
+-----------+--------+-----------+----------+----------+--------+----------------------+
7 rows in set (0.00 sec)

/*Ej3*/
mysql> SELECT reservas.*,investigadores.nombre,investigadores.apellidos FROM reservas 
INNER JOIN investigadores ON reservas.dni=investigadores.dni;
+-----------+----------+------------+------------+--------+-----------+
| DNI       | IdEquipo | FInicio    | FFin       | nombre | apellidos |
+-----------+----------+------------+------------+--------+-----------+
| 11111111X | H555     | 2024-05-11 | 2024-12-06 | Luis   | Lopez     |
| 11111111X | K111     | 2024-09-25 | 2024-11-03 | Luis   | Lopez     |
| 33333333P | M333     | 2024-10-03 | 2024-11-20 | Sonia  | Gomez     |
| 55555555I | K111     | 2024-11-15 | 2024-10-06 | Pedro  | Martinez  |
| 66666666D | H222     | 2024-09-05 | 2024-10-06 | Sara   | Salas     |
+-----------+----------+------------+------------+--------+-----------+
5 rows in set (0.02 sec)

/*Ej4*/
mysql> SELECT reservas.*,investigadores.nombre,investigadores.apellidos,equipos.descripcion FROM reservas 
INNER JOIN investigadores ON reservas.dni=investigadores.dni 
INNER JOIN equipos ON reservas.idequipo=equipos.idequipo;
+-----------+----------+------------+------------+--------+-----------+------------------------------+
| DNI       | IdEquipo | FInicio    | FFin       | nombre | apellidos | descripcion                  |
+-----------+----------+------------+------------+--------+-----------+------------------------------+
| 66666666D | H222     | 2024-09-05 | 2024-10-06 | Sara   | Salas     | Multimetro digital FLUKE     |
| 11111111X | H555     | 2024-05-11 | 2024-12-06 | Luis   | Lopez     | Telemetro laser SICK         |
| 11111111X | K111     | 2024-09-25 | 2024-11-03 | Luis   | Lopez     | Lente para camara FUJINON-TV |
| 55555555I | K111     | 2024-11-15 | 2024-10-06 | Pedro  | Martinez  | Lente para camara FUJINON-TV |
| 33333333P | M333     | 2024-10-03 | 2024-11-20 | Sonia  | Gomez     | Fuente de Voltaje TEKTRONIX  |
+-----------+----------+------------+------------+--------+-----------+------------------------------+
5 rows in set (0.02 sec)