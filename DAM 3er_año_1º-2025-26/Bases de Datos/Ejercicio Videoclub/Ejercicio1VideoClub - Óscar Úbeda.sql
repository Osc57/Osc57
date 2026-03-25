/*Ejercicio Videoclub - Óscar Úbeda*/
/*Ej1*/
mysql> UPDATE cliente SET direccion = 'Mayor, 10 Teruel' WHERE dni = '022222222R';
Query OK, 1 row affected (0.032 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> SELECT * FROM cliente WHERE dni = '022222222R';
+------------+-------------------+------------------+-----------+
| DNI        | Nombre            | Direccion        | Telefono  |
+------------+-------------------+------------------+-----------+
| 022222222R | Maria Casas Comas | Mayor, 10 Teruel | 555666111 |
+------------+-------------------+------------------+-----------+
1 row in set (0.008 sec)

/*Ej2*/
mysql> UPDATE cliente SET nombre = UPPER(nombre);
Query OK, 2 rows affected (0.048 sec)
Rows matched: 2  Changed: 2  Warnings: 0

mysql> SELECT * FROM cliente;
+------------+--------------------+------------------+-----------+
| DNI        | Nombre             | Direccion        | Telefono  |
+------------+--------------------+------------------+-----------+
| 011111111Z | PEDRO MARTINEZ ROY | NULL             | 934444444 |
| 022222222R | MARIA CASAS COMAS  | Mayor, 10 Teruel | 555666111 |
+------------+--------------------+------------------+-----------+
2 rows in set (0.005 sec)

/*Ej3*/
mysql> INSERT INTO pelicula (codpeli, titulo, codgenero, segundaparte, codactor) VALUES 
(6, 'Lo que el agua se llevó', (SELECT codgenero FROM genero WHERE descripcion = 'Drama'), 4, (SELECT codactor FROM actor WHERE nombre = 'Eva'));
Query OK, 1 row affected (0.046 sec)

mysql> SELECT * FROM pelicula WHERE codpeli = 6;
+---------+-------------------------+-----------+--------------+----------+
| CodPeli | Titulo                  | CodGenero | SegundaParte | CodActor |
+---------+-------------------------+-----------+--------------+----------+
|       6 | Lo que el agua se llevó |         3 |            4 |        3 |
+---------+-------------------------+-----------+--------------+----------+
1 row in set (0.005 sec)

/*Ej4*/
mysql> INSERT INTO copia (codcopia, codpeli) VALUES (1, 6);
Query OK, 1 row affected (0.035 sec)

mysql> SELECT * FROM copia WHERE codPeli = 6;
+---------+----------+
| CodPeli | CodCopia |
+---------+----------+
|       6 |        1 |
+---------+----------+
1 row in set (0.015 sec)

/*Ej5*/
mysql> INSERT INTO factura (codfactura, fecha, importe, dni) VALUES (4, NOW(), 0, (SELECT dni FROM cliente WHERE nombre LIKE ('Pedro Martinez %')));
Query OK, 1 row affected, 1 warning (0.039 sec)

mysql> SELECT * FROM factura WHERE codfactura = 4;
+------------+------------+---------+------------+
| CodFactura | Fecha      | Importe | DNI        |
+------------+------------+---------+------------+
|          4 | 2026-03-25 |    0.00 | 011111111Z |
+------------+------------+---------+------------+
1 row in set (0.005 sec)

/*Ej6*/
mysql> INSERT INTO detallefactura (CodFactura, LineaFactura,Descripcion,PrecioUnitaro,NumeroUnidades) VALUES (4, 1, 'Piel 1', 4.50, 1);
Query OK, 1 row affected (0.034 sec)

mysql> INSERT INTO detallefactura (CodFactura, LineaFactura,Descripcion,PrecioUnitaro,NumeroUnidades) VALUES (4, 2, 'Refresco', 2.50, 2);
Query OK, 1 row affected (0.032 sec)

mysql> SELECT * FROM detallefactura WHERE codfactura = 4;
+------------+--------------+-------------+---------------+----------------+
| CodFactura | LineaFactura | Descripcion | PrecioUnitaro | NumeroUnidades |
+------------+--------------+-------------+---------------+----------------+
|          4 |            1 | Piel 1      |          4.50 |              1 |
|          4 |            2 | Refresco    |          2.50 |              2 |
+------------+--------------+-------------+---------------+----------------+
2 rows in set (0.009 sec)

mysql> UPDATE factura SET importe = (SELECT SUM(PrecioUnitaro * NumeroUnidades) FROM detallefactura WHERE codfactura = 4) WHERE codfactura = 4;
Query OK, 1 row affected (0.049 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> SELECT * FROM factura WHERE codfactura = 4;
+------------+------------+---------+------------+
| CodFactura | Fecha      | Importe | DNI        |
+------------+------------+---------+------------+
|          4 | 2026-03-25 |    9.50 | 011111111Z |
+------------+------------+---------+------------+
1 row in set (0.007 sec)

/*Ej7*/
mysql> INSERT INTO prestamo VALUES (6, 1, now(), (SELECT dni FROM cliente WHERE nombre LIKE 'Pedro Martinez %'));
Query OK, 1 row affected, 1 warning (0.116 sec)

mysql> SELECT * FROM prestamo WHERE codpeli = 6;
+---------+----------+------------+------------+
| CodPeli | CodCopia | Fecha      | DNI        |
+---------+----------+------------+------------+
|       6 |        1 | 2026-03-25 | 011111111Z |
+---------+----------+------------+------------+
1 row in set (0.007 sec)

/*Ej8*/
mysql> INSERT INTO interpretada VALUES (6, (SELECT codactor FROM pelicula WHERE codpeli = 6));
Query OK, 1 row affected (0.256 sec)

mysql> SELECT * FROM interpretada WHERE codpeli = 6;
+---------+----------+
| CodPeli | CodActor |
+---------+----------+
|       6 |        3 |
+---------+----------+
1 row in set (0.006 sec)

/*Ej9*/
mysql> DELETE FROM pelicula WHERE codpeli = 6;
ERROR 1451 (23000): Cannot delete or update a parent row: a foreign key constraint fails (`videoclub`.`copia`, CONSTRAINT `copia_ibfk_1` FOREIGN KEY (`CodPeli`) REFERENCES `pelicula` (`CodPeli`))

/*Porque la esa clave tiene registros en otras tablas*/