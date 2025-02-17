/*Consulas con funciones*/
/*Ej1*/
mysql> SELECT nombre, descripcion, ROUND(precio_venta, 1) AS precio_redondeado FROM productos WHERE stock <=10;
+---------------------------------------+-------------+-------------------+
| nombre                                | descripcion | precio_redondeado |
+---------------------------------------+-------------+-------------------+
| Eagle FS-3 Mountain Bike              | NULL        |            1800.0 |
| Viscount Mountain Bike                | NULL        |             635.0 |
| GT RTS-2 Mountain Bike                | NULL        |            1650.0 |
| HP Deluxe Alforjas                    | NULL        |              39.0 |
| Road Warrior soporte para maletero    | NULL        |             175.0 |
| Ultimate Export 2G baca para bibileta | NULL        |             180.0 |
+---------------------------------------+-------------+-------------------+
6 rows in set (0.00 sec)

/*Ej2*/
mysql> SELECT SQRT(49) + ABS(-5) AS raizCuadrada;
+--------------+
| raizCuadrada |
+--------------+
|           12 |
+--------------+
1 row in set (0.00 sec)

/*Ej3*/
mysql> SELECT AVG(precio_venta) AS mediaPrecioVenta FROM productos;
+------------------+
| mediaPrecioVenta |
+------------------+
|       170.290769 |
+------------------+
1 row in set (0.00 sec)

/*Ej4*/
