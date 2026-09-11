/*Ejercicios 2 UD8 Ventas Óscar Úbeda*/
/*Ej1*/
mysql> UPDATE detalles_pedidos SET precio = precio  * 0.95 where numero_pedido IN 
(SELECT numero_pedido FROM pedidos WHERE id_cliente IN 
(SELECT id_cliente FROM pedidos WHERE fecha_pedido LIKE '2007-10-%' GROUP BY id_cliente HAVING SUM(precio_total)>20000));
Query OK, 1779 rows affected, 682 warnings (0.08 sec)
Rows matched: 1779  Changed: 1779  Warnings: 682

/*Ej2*/
mysql> UPDATE pedidos pe SET precio_total =(SELECT SUM(precio*cantidad) FROM detalles_pedidos dp WHERE dp.numero_pedido = pe.numero_pedido GROUP BY numero_pedido) 
WHERE pe.id_cliente IN (SELECT id_cliente FROM (SELECT * FROM pedidos) AS tabla WHERE fecha_pedido LIKE '2007-10-%' GROUP BY id_cliente HAVING SUM(precio_total)>20000);
Query OK, 492 rows affected (0.02 sec)
Rows matched: 492  Changed: 492  Warnings: 0

/*Ej3*/


/*Ej4*/
mysql> UPDATE productos p SET precio_venta = ROUND (1.35 * (SELECT MAX(precio_por_mayor) FROM productos_proveedores pv 
WHERE p.numero_producto = pv.numero_producto),0) WHERE id_categoria = (SELECT id_categoria WHERE id_categoria LIKE '%Accesorios%');
Query OK, 0 rows affected (0.02 sec)
Rows matched: 0  Changed: 0  Warnings: 0

/*Ej5*/
mysql> INSERT INTO empleados (id_empleado, nombre, apellidos, direccion, ciudad, provincia, cod_postal, codigo_area, telefono) VALUES 
((SELECT MAX(id_empleado) + 1 FROM (SELECT * FROM empleados) AS emp), 'Susana', 'Maroto', 'Pinares 16', 'Villamanta', 'MADRID', '28610', 425, '555-7825');
Query OK, 1 row affected (0.03 sec)

/*Ej6*/
mysql> INSERT INTO empleados (SELECT ((SELECT MAX(id_empleado) + 1 FROM (SELECT * FROM empleados) AS emp)), nombre, apellidos, direccion, ciudad, provincia, cod_postal, codigo_area, telefono FROM clientes WHERE nombre = 'David' AND apellidos = 'Sanz');
Query OK, 1 row affected (0.02 sec)
Records: 1  Duplicates: 0  Warnings: 0

/*Ej7*/


/*Ej8*/


/*Ej9*/

