/**/


/*Ej1*/
mysql> SELECT nombre, precio_venta, precio_venta*1.04 AS precioSubida FROM productos WHERE id_categoria IN (SELECT id_categoria FROM categorias WHERE descripcion='Ropa');
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

/*Ej3*/
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

/*Ej4*/
mysql> INSERT INTO pedidos_historico SELECT * FROM pedidos;
Query OK, 833 rows affected (0.02 sec)
Records: 833  Duplicates: 0  Warnings: 0

/*Ej5*/

/*Ej6*/

/*Ej7*/

/*Ej8*/
mysql> UPDATE detalles_pedidos dp SET dp.precio=(SELECT precio_venta FROM productos p WHERE dp.numero_producto=p.numero_producto);
Query OK, 3067 rows affected (0.05 sec)
Rows matched: 3067  Changed: 3067  Warnings: 0

mysql> UPDATE pedidos SET precio_total = (SELECT SUM(precio*cantidad) FROM detalles_pedidos WHERE pedidos.numero_pedido=
detalles_pedidos.numero_pedido);
Query OK, 833 rows affected (0.01 sec)
Rows matched: 833  Changed: 833  Warnings: 0

/*Ej9*/
mysql> CREATE TABLE saldos_pendientes AS (
    -> SELECT p.numero_pedido, p.fecha_pedido, p.fecha_envio, p.id_cliente, p.id_empleado,
    -> (p.precio_total-ph.precio_total) AS precio_total
    -> FROM pedidos p JOIN pedidos_historico ph ON (p.numero_pedido=ph.numero_pedido));
Query OK, 0 rows affected (0.02 sec)
Records: 0  Duplicates: 0  Warnings: 0

/*Ej11*/
mysql> SELECT proveedores.nombre, AVG(productos_proveedores.dias_envio) AS promedioDias FROM proveedores 
INNER JOIN productos_proveedores ON proveedores.id_prov=productos_proveedores.id_prov 
GROUP BY productos_proveedores.id_prov HAVING promedioDias > (SELECT AVG(productos_proveedores.dias_envio) FROM productos_proveedores);
+------------------------+--------------+
| nombre                 | promedioDias |
+------------------------+--------------+
| Big Sky Mountain Bikes |      10.8182 |
| Dog Ear                |      10.5556 |
| Sun Sports Suppliers   |      11.6000 |
| Lone Star Bike Supply  |      11.0000 |
| Armadillo Brand        |      13.1667 |
+------------------------+--------------+
5 rows in set (0.04 sec)

/*Ej12*/
mysql> SELECT pr1.nombre, SUM(detalles_pedidos.precio*detalles_pedidos.cantidad) AS total FROM productos pr1 JOIN detalles_pedidos ON pr1.numero_producto=detalles_pedidos.numero_producto GROUP BY pr1.numero_producto HAVING total > (SELECT AVG(detalles_pedidos.precio*detalles_pedidos.cantidad) FROM productos pr2 JOIN detalles_pedidos ON pr2.numero_producto=detalles_pedidos.numero_producto WHERE pr1.id_categoria=pr2.id_categoria GROUP BY pr2.id_categoria);
