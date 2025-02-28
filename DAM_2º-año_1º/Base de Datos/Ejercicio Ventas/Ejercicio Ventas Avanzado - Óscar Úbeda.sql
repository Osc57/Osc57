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
mysql> SELECT DISTINCT UPPER(empleados.nombre) AS Nombre, UPPER(empleados.apellidos) AS Apellidos FROM empleados 
JOIN pedidos ON empleados.id_empleado=pedidos.id_empleado 
JOIN detalles_pedidos ON pedidos.numero_pedido=detalles_pedidos.numero_pedido 
JOIN productos ON detalles_pedidos.numero_producto=productos.numero_producto 
WHERE productos.precio_venta > (SELECT AVG(precio_venta) FROM productos) ORDER BY apellidos,nombre;
+----------+-----------+
| Nombre   | Apellidos |
+----------+-----------+
| MATEO    | BERGES    |
| PEDRO    | DONOSO    |
| SUSANA   | MAESTRE   |
| CATALINA | PELAYO    |
| MARIA    | TORRES    |
| CAROL    | VIESCAS   |
| DAVID    | VIESCAS   |
+----------+-----------+
7 rows in set (0,02 sec)

/*Ej5*/
mysql> SELECT COUNT(numero_producto) AS numeroProductos FROM productos WHERE id_categoria=3;
+-----------------+
| numeroProductos |
+-----------------+
|               4 |
+-----------------+
1 row in set (0,00 sec)

/*Ej6*/
mysql> SELECT MAX(precio_venta) AS precioMayor, MIN(precio_venta) AS precioMenor FROM productos;
+-------------+-------------+
| precioMayor | precioMenor |
+-------------+-------------+
|     1800.00 |        4.99 |
+-------------+-------------+
1 row in set (0,00 sec)

/*Ej7*/
mysql> SELECT * FROM productos WHERE precio_venta IN (SELECT MAX(precio_venta) FROM productos);
+-----------------+--------------------------+-------------+--------------+-------+--------------+
| numero_producto | nombre                   | descripcion | precio_venta | stock | id_categoria |
+-----------------+--------------------------+-------------+--------------+-------+--------------+
|               2 | Eagle FS-3 Mountain Bike | NULL        |      1800.00 |     8 |            2 |
+-----------------+--------------------------+-------------+--------------+-------+--------------+
1 row in set (0,00 sec)

/*Ej8*/
mysql> SELECT productos.* FROM productos 
JOIN categorias ON productos.id_categoria=categorias.id_categoria WHERE LENGTH(categorias.descripcion) > 8;
+-----------------+---------------------------------------+-------------+--------------+-------+--------------+
| numero_producto | nombre                                | descripcion | precio_venta | stock | id_categoria |
+-----------------+---------------------------------------+-------------+--------------+-------+--------------+
|               3 | Dog Ear Cyclecomputer                 | NULL        |        75.00 |    20 |            1 |
|               5 | Dog Ear Helmet Mount Espejos          | NULL        |         7.45 |    12 |            1 |
|               7 | Viscount C-500 Wireless Bike Computer | NULL        |        49.00 |    30 |            1 |
|               8 | Kryptonite Advanced 2000 U-Lock       | NULL        |        50.00 |    20 |            1 |
|               9 | Nikoma Lok-Tight U-Lock               | NULL        |        33.00 |    12 |            1 |
|              10 | Viscount Microshell Casco             | NULL        |        36.00 |    20 |            1 |
|              18 | Viscount CardioSport Sport Watch      | NULL        |       179.00 |    12 |            1 |
|              19 | Viscount Tru-Beat pulsometro          | NULL        |        47.00 |    20 |            1 |
|              20 | Dog Ear Monster guantes               | NULL        |        15.00 |    30 |            1 |
|              21 | Dog Ear Aero-Flow Hinchador           | NULL        |        55.00 |    25 |            1 |
|              22 | Pro-Sport  Dillo Gafas de sol         | NULL        |        82.00 |    18 |            1 |
|              25 | King Cobra Casco                      | NULL        |       139.00 |    30 |            1 |
|              26 | Glide-O-Matic Cycling Casco           | NULL        |       125.00 |    24 |            1 |
|              30 | Clear Shade 85-T Gafas                | NULL        |        45.00 |    14 |            1 |
|              31 | True Grip Competition Guantes         | NULL        |        22.00 |    20 |            1 |
|              34 | TransPort Bicycle Parrilla            | NULL        |        27.00 |    14 |            1 |
|              35 | HP Deluxe Alforjas                    | NULL        |        39.00 |    10 |            1 |
|              38 | Cycle-Doc Pro Repair Stand            | NULL        |       166.00 |    12 |            1 |
|               2 | Eagle FS-3 Mountain Bike              | NULL        |      1800.00 |     8 |            2 |
|               6 | Viscount Mountain Bike                | NULL        |       635.00 |     5 |            2 |
|              11 | GT RTS-2 Mountain Bike                | NULL        |      1650.00 |     5 |            2 |
|               4 | Victoria Pro All Weather Llantas      | NULL        |        54.95 |    20 |            4 |
|              12 | Shinoman 105 SC Frenos                | NULL        |        23.50 |    16 |            4 |
|              13 | Shinoman Dura-Ace Auriculares         | NULL        |        67.50 |    20 |            4 |
|              14 | Eagle SA-120 Pedales sin clip         | NULL        |       139.95 |    20 |            4 |
|              15 | ProFormance clip para pedal 2G        | NULL        |         4.99 |    40 |            4 |
|              16 | ProFormance ATB Pedal todo-terreno    | NULL        |        28.00 |    40 |            4 |
|              17 | Shinoman Deluxe TX-30 Pedal           | NULL        |        45.00 |    60 |            4 |
|              36 | Cosmic Elite Road Warrior Ruedas      | NULL        |       165.00 |    22 |            4 |
|              37 | AeroFlo ATB Ruedas                    | NULL        |       189.00 |    40 |            4 |
|              39 | Road Warrior soporte para maletero    | NULL        |       175.00 |     6 |            5 |
|              40 | Ultimate Export 2G baca para bibileta | NULL        |       180.00 |     8 |            5 |
+-----------------+---------------------------------------+-------------+--------------+-------+--------------+
32 rows in set (0,01 sec)

/*Ej9*/
mysql> SELECT RPAD(nombre,10,'*')AS nombre FROM empleados WHERE LENGTH(nombre)<=10;
+------------+
| nombre     |
+------------+
| Maria***** |
| Mateo***** |
| Carol***** |
| Pedro***** |
| David***** |
| Catalina** |
| Susana**** |
| Domingo*** |
+------------+
8 rows in set (0,00 sec)

/*Ej10*/
mysql> SELECT COUNT(numero_producto) AS numeroProductos FROM productos WHERE descripcion IS NULL;
+-----------------+
| numeroProductos |
+-----------------+
|              39 |
+-----------------+
1 row in set (0,00 sec)

/*Ej11*/
mysql> SELECT pedidos.numero_pedido, clientes.id_cliente, clientes.nombre, EXTRACT(MONTH FROM pedidos.fecha_pedido) AS mes FROM pedidos INNER JOIN clientes ON pedidos.id_cliente=clientes.id_cliente LIMIT 10;
+---------------+------------+--------+------+
| numero_pedido | id_cliente | nombre | mes  |
+---------------+------------+--------+------+
|             2 |       1001 | Susana |    9 |
|             7 |       1001 | Susana |    9 |
|            16 |       1001 | Susana |    9 |
|            55 |       1001 | Susana |    9 |
|           107 |       1001 | Susana |    9 |
|           137 |       1001 | Susana |    9 |
|           138 |       1001 | Susana |    9 |
|           151 |       1001 | Susana |    9 |
|           154 |       1001 | Susana |    9 |
|           213 |       1001 | Susana |   10 |
+---------------+------------+--------+------+
10 rows in set (0,00 sec)


/*Ej12*/
mysql> SELECT pedidos.numero_pedido, clientes.id_cliente, clientes.nombre, DATE_FORMAT(pedidos.fecha_pedido, '%d/%m/%Y') AS fecha FROM pedidos INNER JOIN clientes ON pedidos.id_cliente=clientes.id_cliente LIMIT 20;
+---------------+------------+--------+------------+
| numero_pedido | id_cliente | nombre | fecha      |
+---------------+------------+--------+------------+
|             2 |       1001 | Susana | 01/09/2007 |
|             7 |       1001 | Susana | 01/09/2007 |
|            16 |       1001 | Susana | 02/09/2007 |
|            55 |       1001 | Susana | 09/09/2007 |
|           107 |       1001 | Susana | 16/09/2007 |
|           137 |       1001 | Susana | 23/09/2007 |
|           138 |       1001 | Susana | 24/09/2007 |
|           151 |       1001 | Susana | 27/09/2007 |
|           154 |       1001 | Susana | 29/09/2007 |
|           213 |       1001 | Susana | 11/10/2007 |
|           320 |       1001 | Susana | 02/11/2007 |
|           346 |       1001 | Susana | 07/11/2007 |
|           349 |       1001 | Susana | 08/11/2007 |
|           394 |       1001 | Susana | 18/11/2007 |
|           408 |       1001 | Susana | 23/11/2007 |
|           413 |       1001 | Susana | 24/11/2007 |
|           425 |       1001 | Susana | 26/11/2007 |
|           426 |       1001 | Susana | 26/11/2007 |
|           443 |       1001 | Susana | 29/11/2007 |
|           452 |       1001 | Susana | 30/11/2007 |
+---------------+------------+--------+------------+
20 rows in set (0,00 sec)

/*Ej13*/
mysql> SELECT DATE_ADD(NOW(), INTERVAL (9 - DAYOFWEEK(NOW())) % 7 DAY) AS ProximoMiercoles;
+---------------------+
| ProximoMiercoles    |
+---------------------+
| 2025-02-24 15:55:42 |
+---------------------+
1 row in set (0.01 sec)

/*Ej14*/
mysql> SELECT nombre FROM productos ORDER BY LENGTH(nombre);
+---------------------------------------+
| nombre                                |
+---------------------------------------+
| King Cobra Casco                      |
| AeroFlo ATB Ruedas                    |
| HP Deluxe Alforjas                    |
| Turbo Twin Llantas                    |
| Dog Ear Cyclecomputer                 |
| StaDry Cycling culote                 |
| Viscount Mountain Bike                |
| GT RTS-2 Mountain Bike                |
| Shinoman 105 SC Frenos                |
| Clear Shade 85-T Gafas                |
| Ultra-Pro Rain maillot                |
| Nikoma Lok-Tight U-Lock               |
| Dog Ear Monster guantes               |
| Eagle FS-3 Mountain Bike              |
| Viscount Microshell Casco             |
| X-Pro All Weather Llantas             |
| Cycle-Doc Pro Repair Stand            |
| TransPort Bicycle Parrilla            |
| Shinoman Deluxe TX-30 Pedal           |
| Dog Ear Aero-Flow Hinchador           |
| Glide-O-Matic Cycling Casco           |
| Ultra-2K Competition Llanta           |
| Viscount Tru-Beat pulsometro          |
| Wonder Wool Cycle Calcetines          |
| Dog Ear Helmet Mount Espejos          |
| Pro-Sport  Dillo Gafas de sol         |
| Eagle SA-120 Pedales sin clip         |
| Shinoman Dura-Ace Auriculares         |
| True Grip Competition Guantes         |
| Kool-Breeze Rocket Top Jersey         |
| ProFormance clip para pedal 2G        |
| Kryptonite Advanced 2000 U-Lock       |
| Viscount CardioSport Sport Watch      |
| Cosmic Elite Road Warrior Ruedas      |
| Victoria Pro All Weather Llantas      |
| ProFormance ATB Pedal todo-terreno    |
| Road Warrior soporte para maletero    |
| Viscount C-500 Wireless Bike Computer |
| Ultimate Export 2G baca para bibileta |
+---------------------------------------+
39 rows in set (0.00 sec)

/*Ej15*/
mysql> SELECT COUNT(productos.numero_producto) AS productos FROM productos 
INNER JOIN detalles_pedidos ON productos.numero_producto=detalles_pedidos.numero_producto 
INNER JOIN pedidos ON detalles_pedidos.numero_pedido=pedidos.numero_pedido 
INNER JOIN categorias ON productos.id_categoria=categorias.id_categoria 
WHERE productos.precio_venta > (SELECT AVG(precio_venta) FROM productos) AND categorias.id_categoria IN (SELECT id_categoria FROM categorias WHERE descripcion='componentes');
+-----------+
| productos |
+-----------+
|        99 |
+-----------+
1 row in set (0.00 sec)

/*Ej16*/
mysql> SELECT nombre,precio_venta*stock AS precioTotal FROM productos 
WHERE id_categoria IN (SELECT id_categoria FROM categorias WHERE descripcion='ropa');
+-------------------------------+-------------+
| nombre                        | precioTotal |
+-------------------------------+-------------+
| Ultra-Pro Rain maillot        |     2550.00 |
| StaDry Cycling culote         |     1518.00 |
| Kool-Breeze Rocket Top Jersey |      384.00 |
| Wonder Wool Cycle Calcetines  |      570.00 |
+-------------------------------+-------------+
4 rows in set (0.00 sec)

/*Ej17*/
mysql> SELECT id_cliente, COUNT(fecha_pedido) AS pedidos FROM pedidos 
WHERE id_cliente IN (SELECT id_cliente FROM clientes WHERE ciudad='Robledo') GROUP BY id_cliente;
+------------+---------+
| id_cliente | pedidos |
+------------+---------+
|       1001 |      38 |
|       1005 |      31 |
|       1006 |      23 |
+------------+---------+
3 rows in set (0.00 sec)

/*Ej18*/
mysql> SELECT SUM(productos.stock) AS totalProductos FROM productos 
INNER JOIN productos_proveedores ON productos.numero_producto=productos_proveedores.numero_producto 
INNER JOIN proveedores ON productos_proveedores.id_prov=proveedores.id_prov 
INNER JOIN categorias ON productos.id_categoria=categorias.id_categoria 
WHERE proveedores.id_prov IN (SELECT id_prov FROM proveedores WHERE ciudad='Madrid') AND categorias.id_categoria IN (SELECT id_categoria FROM categorias WHERE descripcion='Bicicletas');
+----------------+
| totalProductos |
+----------------+
|           NULL |
+----------------+
1 row in set (0.00 sec)

/*Ej19*/
mysql> SELECT COUNT(id_empleado) AS empleados FROM empleados WHERE id_empleado IN (SELECT id_empleado FROM pedidos WHERE precio_total IN (SELECT MAX(precio_total) FROM pedidos));
+-----------+
| empleados |
+-----------+
|         1 |
+-----------+
1 row in set (0,01 sec)

/*Ej20*/
mysql> SELECT descripcion FROM categorias WHERE id_categoria IN (SELECT id_categoria FROM productos WHERE precio_venta IN (SELECT MIN(precio_venta) FROM productos));
+-------------+
| descripcion |
+-------------+
| Componentes |
+-------------+
1 row in set (0,00 sec)

/*Ej21*/
mysql> SELECT * FROM clientes WHERE id_cliente IN (SELECT id_cliente FROM pedidos WHERE fecha_pedido > '2007-11-20' AND fecha_pedido < '2007-11-23');
+------------+--------+-----------+-----------------+----------+-----------+------------+-------------+----------+
| id_cliente | nombre | apellidos | direccion       | ciudad   | provincia | cod_postal | codigo_area | telefono |
+------------+--------+-----------+-----------------+----------+-----------+------------+-------------+----------+
|       1012 | Lisa   | Colomer   | Calle Zurita 13 | Belmonte | MADRID    | 28006      |         425 | 555-2556 |
+------------+--------+-----------+-----------------+----------+-----------+------------+-------------+----------+
1 row in set (0.00 sec)

/*Ej22*/
mysql> SELECT * FROM empleados WHERE id_empleado IN (SELECT id_empleado FROM pedidos WHERE fecha_pedido IN (SELECT MAX(fecha_pedido) FROM pedidos));
+-------------+----------+-----------+-------------------------+------------+-----------+------------+-------------+----------+
| id_empleado | nombre   | apellidos | direccion               | ciudad     | provincia | cod_postal | codigo_area | telefono |
+-------------+----------+-----------+-------------------------+------------+-----------+------------+-------------+----------+
|         702 | Maria    | Torres    | Calle del Rio 122       | Daganzo    | MADRID    | 28019      |         425 | 555-2516 |
|         704 | Carol    | Viescas   | Calle bahia 22          | Horcajuelo | MADRID    | 28033      |         425 | 555-2576 |
|         705 | Pedro    | Donoso    | Avda del Oeste 45       | San Roman  | TOLEDO    | 45284      |         210 | 5552311  |
|         706 | David    | Viescas   | Cortes 16               | Robledo    | MADRID    | 28052      |         425 | 555-2661 |
|         707 | Catalina | Pelayo    | Calle del Pez 5 Apt. 2A | Somosierra | MADRID    | 28105      |         206 | 555-2697 |
+-------------+----------+-----------+-------------------------+------------+-----------+------------+-------------+----------+
5 rows in set (0.02 sec)

/*Ej23*/
mysql> SELECT productos_proveedores.numero_producto,(precio_venta-productos_proveedores.precio_por_mayor) AS beneficio FROM productos 
INNER JOIN productos_proveedores ON productos.numero_producto=productos_proveedores.numero_producto 
WHERE (precio_venta-productos_proveedores.precio_por_mayor)=(SELECT MAX(precio_venta-productos_proveedores.precio_por_mayor) FROM productos INNER JOIN productos_proveedores ON producto
s.numero_producto=productos_proveedores.numero_producto);
+-----------------+-----------+
| numero_producto | beneficio |
+-----------------+-----------+
|              11 |    573.38 |
+-----------------+-----------+
1 row in set (0.00 sec)

/*Ej24*/










