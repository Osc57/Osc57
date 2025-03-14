/**/


/*Ej1*/
mysql> SELECT nombre, precio_venta, precio_venta*1.10 AS precioSubida FROM productos WHERE id_categoria IN (SELECT id_categoria FROM categorias WHERE descripcion='Ropa');
+-------------------------------+--------------+--------------+
| nombre                        | precio_venta | precioSubida |
+-------------------------------+--------------+--------------+
| Ultra-Pro Rain maillot        |       102.00 |     106.0800 |
| StaDry Cycling culote         |        82.80 |      86.1120 |
| Kool-Breeze Rocket Top Jersey |        38.40 |      39.9360 |
| Wonder Wool Cycle Calcetines  |        22.80 |      23.7120 |
+-------------------------------+--------------+--------------+
4 rows in set (0.02 sec)

/*Ej2*/
mysql> UPDATE productos SET precio_venta=precio_venta*1.04 WHERE id_categoria IN (SELECT id_categoria FROM categorias WHERE descripcion='Ropa');
Query OK, 4 rows affected, 3 warnings (0.01 sec)
Rows matched: 4  Changed: 4  Warnings: 3

mysql> SELECT nombre, precio_venta FROM productos WHERE id_categoria IN (SELECT id_categoria FROM categorias WHERE descripcion='Ropa');;
+-------------------------------+--------------+
| nombre                        | precio_venta |
+-------------------------------+--------------+
| Ultra-Pro Rain maillot        |       106.08 |
| StaDry Cycling culote         |        86.11 |
| Kool-Breeze Rocket Top Jersey |        39.94 |
| Wonder Wool Cycle Calcetines  |        23.71 |
+-------------------------------+--------------+
4 rows in set (0.00 sec)

/*Ej3*/

