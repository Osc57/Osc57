/*Consultas Simples*/
/*Ej1*/
mysql> SELECT nombre FROM proveedores;
+------------------------+
| nombre                 |
+------------------------+
| Shinoman, Incorporated |
| Viscount               |
| Nikoma of America      |
| ProFormance            |
| Kona, Incorporated     |
| Big Sky Mountain Bikes |
| Dog Ear                |
| Sun Sports Suppliers   |
| Lone Star Bike Supply  |
| Armadillo Brand        |
| Astro Paper productos  |
+------------------------+
11 rows in set (0,00 sec)

/*Ej2*/
mysql> SELECT nombre,precio_venta FROM productos;
+---------------------------------------+--------------+
| nombre                                | precio_venta |
+---------------------------------------+--------------+
| Eagle FS-3 Mountain Bike              |      1800.00 |
| Dog Ear Cyclecomputer                 |        75.00 |
| Victoria Pro All Weather Llantas      |        54.95 |
| Dog Ear Helmet Mount Espejos          |         7.45 |
| Viscount Mountain Bike                |       635.00 |
| Viscount C-500 Wireless Bike Computer |        49.00 |
| Kryptonite Advanced 2000 U-Lock       |        50.00 |
| Nikoma Lok-Tight U-Lock               |        33.00 |
| Viscount Microshell Casco             |        36.00 |
| GT RTS-2 Mountain Bike                |      1650.00 |
| Shinoman 105 SC Frenos                |        23.50 |
| Shinoman Dura-Ace Auriculares         |        67.50 |
| Eagle SA-120 Pedales sin clip         |       139.95 |
| ProFormance clip para pedal 2G        |         4.99 |
| ProFormance ATB Pedal todo-terreno    |        28.00 |
| Shinoman Deluxe TX-30 Pedal           |        45.00 |
| Viscount CardioSport Sport Watch      |       179.00 |
| Viscount Tru-Beat pulsometro          |        47.00 |
| Dog Ear Monster guantes               |        15.00 |
| Dog Ear Aero-Flow Hinchador           |        55.00 |
| Pro-Sport Dillo Gafas de sol         |        82.00 |
| Pro-Sport Dillo Gafas de sol         |        82.00 |
| Ultra-Pro Rain maillot                |        85.00 |
| StaDry Cycling culote                 |        69.00 |
| King Cobra Casco                      |       139.00 |
| Glide-O-Matic Cycling Casco           |       125.00 |
| X-Pro All Weather Llantas             |        24.00 |
| Turbo Twin Llantas                    |        29.00 |
| Ultra-2K Competition Llanta           |        34.00 |
| Clear Shade 85-T Gafas                |        45.00 |
| True Grip Competition Guantes         |        22.00 |
| Kool-Breeze Rocket Top Jersey         |        32.00 |
| Wonder Wool Cycle Calcetines          |        19.00 |
| TransPort Bicycle Parrilla            |        27.00 |
| HP Deluxe Alforjas                    |        39.00 |
| Cosmic Elite Road Warrior Ruedas      |       165.00 |
| AeroFlo ATB Ruedas                    |       189.00 |
| Cycle-Doc Pro Repair Stand            |       166.00 |
| Road Warrior soporte para maletero    |       175.00 |
| Ultimate Export 2G baca para bibileta |       180.00 |
+---------------------------------------+--------------+
39 rows in set (0,00 sec)

/*Ej3*/
mysql> SELECT DISTINCT(provincia) FROM clientes;
+-----------+
| provincia |
+-----------+
| MADRID    |
| TOLEDO    |
| ORENSE    |
| CACERES   |
+-----------+
4 rows in set (0,00 sec)

/*Ej4*/
mysql> SELECT nombre,ciudad FROM proveedores ORDER BY ciudad ASC;
+------------------------+--------------+
| nombre                 | ciudad       |
+------------------------+--------------+
| ProFormance            | Ademuz       |
| Big Sky Mountain Bikes | Albatana     |
| Nikoma of America      | Batres       |
| Shinoman, Incorporated | Belmonte     |
| Astro Paper productos  | Castroviejo  |
| Armadillo Brand        | Dosbarrios   |
| Lone Star Bike Supply  | Escalonilla  |
| Dog Ear                | Navalon      |
| Kona, Incorporated     | Robledo      |
| Viscount               | Santa Amalia |
| Sun Sports Suppliers   | Saucedilla   |
+------------------------+--------------+
11 rows in set (0,00 sec)

/*Ej5*/
mysql> SELECT CONCAT(pag_web,' es la web de ',nombre) AS PaginaWeb FROM proveedores WHERE pag_web IS NOT NULL;
+--------------------------------------------------------------+
| PaginaWeb                                                    |
+--------------------------------------------------------------+
| http://www.shinoman.com/ es la web de Shinoman, Incorporated |
| http://www.viscountbikes.com/ es la web de Viscount          |
| http://www.nikomabikes.com/ es la web de Nikoma of America   |
| http://www.ProFormBikes.com/ es la web de ProFormance        |
| http://www.konabikes.com/ es la web de Kona, Incorporated    |
| http://www.DilloBikes.com/ es la web de Armadillo Brand      |
+--------------------------------------------------------------+
6 rows in set (0,00 sec)

/*Ej6*/
mysql> SELECT fecha_envio-fecha_pedido AS dias_pedido FROM pedidos LIMIT 5;
+-------------+
| dias_pedido |
+-------------+
|           3 |
|           2 |
|           3 |
|           2 |
|           0 |
+-------------+
5 rows in set (0,00 sec)

/*Ej7*/
mysql> SELECT precio_venta * stock AS Valor_inventario FROM productos LIMIT 5;
+------------------+
| Valor_inventario |
+------------------+
|         14400.00 |
|          1500.00 |
|          1099.00 |
|            89.40 |
|          3175.00 |
+------------------+
5 rows in set (0,00 sec)

/*Ej8*/
mysql> SELECT precio_venta-(precio_venta*0.05) AS precio_reducido FROM productos;
+-----------------+
| precio_reducido |
+-----------------+
|       1710.0000 |
|         71.2500 |
|         52.2025 |
|          7.0775 |
|        603.2500 |
|         46.5500 |
|         47.5000 |
|         31.3500 |
|         34.2000 |
|       1567.5000 |
|         22.3250 |
|         64.1250 |
|        132.9525 |
|          4.7405 |
|         26.6000 |
|         42.7500 |
|        170.0500 |
|         44.6500 |
|         14.2500 |
|         52.2500 |
|         77.9000 |
|         80.7500 |
|         65.5500 |
|        132.0500 |
|        118.7500 |
|         22.8000 |
|         27.5500 |
|         32.3000 |
|         42.7500 |
|         20.9000 |
|         30.4000 |
|         18.0500 |
|         25.6500 |
|         37.0500 |
|        156.7500 |
|        179.5500 |
|        157.7000 |
|        166.2500 |
|        171.0000 |
+-----------------+
39 rows in set (0,00 sec)

/*Ej9*/
mysql> SELECT * FROM pedidos ORDER BY id_cliente,fecha_pedido DESC LIMIT 5;
+---------------+--------------+-------------+------------+-------------+--------------+
| numero_pedido | fecha_pedido | fecha_envio | id_cliente | id_empleado | precio_total |
+---------------+--------------+-------------+------------+-------------+--------------+
|           931 | 2008-02-27   | 2008-02-27  |       1001 |         707 |       225.00 |
|           898 | 2008-02-21   | 2008-02-24  |       1001 |         708 |       727.50 |
|           887 | 2008-02-20   | 2008-02-23  |       1001 |         705 |      1493.60 |
|           855 | 2008-02-14   | 2008-02-15  |       1001 |         704 |       117.00 |
|           851 | 2008-02-13   | 2008-02-13  |       1001 |         702 |      1502.40 |
+---------------+--------------+-------------+------------+-------------+--------------+
5 rows in set (0,00 sec)

/*Ej10*/
mysql> SELECT nombre,direccion FROM proveedores ORDER BY nombre ASC;
+------------------------+---------------------------+
| nombre                 | direccion                 |
+------------------------+---------------------------+
| Armadillo Brand        | Calle de al lado 123      |
| Astro Paper productos  | Avda. del Rio 56          |
| Big Sky Mountain Bikes | Carretera del Sol 20      |
| Dog Ear                | Avda. Mar Salada 57       |
| Kona, Incorporated     | Apartado de correos 28429 |
| Lone Star Bike Supply  | Calle del rey 74          |
| Nikoma of America      | Carretera del Norte 88    |
| ProFormance            | Calle San Cirilo 29       |
| Shinoman, Incorporated | Calle Sur 34              |
| Sun Sports Suppliers   | Apartado 10082            |
| Viscount               | Calle Comercio 19         |
+------------------------+---------------------------+
11 rows in set (0,00 sec)

/*Ej11*/
mysql> SELECT nombre,apellidos FROM clientes WHERE apellidos='Sanz';
+--------+-----------+
| nombre | apellidos |
+--------+-----------+
| David  | Sanz      |
+--------+-----------+
1 row in set (0,00 sec)

/*Ej12*/
mysql> SELECT * FROM pedidos WHERE fecha_envio<fecha_pedido;
Empty set (0,00 sec)

/*Ej13*/
mysql> SELECT nombre,apellidos FROM clientes WHERE apellidos LIKE 'Pe%';
+---------+-----------+
| nombre  | apellidos |
+---------+-----------+
| Nicolas | Pelayo    |
| Raquel  | Pelayo    |
| Maria   | Pelayo    |
| Lucas   | Pelayo    |
+---------+-----------+
4 rows in set (0,00 sec)

/*Ej14*/
mysql> SELECT nombre,apellidos FROM clientes WHERE apellidos LIKE 'S%' AND ciudad='Somosierra';
+--------+-----------+
| nombre | apellidos |
+--------+-----------+
| Julia  | Sandoval  |
+--------+-----------+
1 row in set (0,00 sec)

/*Ej15*/
mysql> SELECT nombre,apellidos FROM clientes WHERE ciudad='Somosierra' OR provincia='ORENSE';
+---------+-----------+
| nombre  | apellidos |
+---------+-----------+
| Maria   | Salgado   |
| Andres  | Cervera   |
| Jaime   | Vives     |
| Manuela | Seidel    |
| Julia   | Sandoval  |
| Lucas   | Pelayo    |
+---------+-----------+
6 rows in set (0,00 sec)

/*Ej16*/
mysql> SELECT nombre,telefono FROM proveedores WHERE provincia='MADRID' OR provincia='CACERES';
+------------------------+----------------+
| nombre                 | telefono       |
+------------------------+----------------+
| Shinoman, Incorporated | (91) 888-1234  |
| Nikoma of America      | (91) 666-1234  |
| Kona, Incorporated     | (91) 333-1234  |
| Sun Sports Suppliers   | (927) 777-9876 |
+------------------------+----------------+
4 rows in set (0,00 sec)

/*Ej17*/
mysql> SELECT * FROM pedidos WHERE id_cliente=1001 AND fecha_pedido=fecha_envio;
+---------------+--------------+-------------+------------+-------------+--------------+
| numero_pedido | fecha_pedido | fecha_envio | id_cliente | id_empleado | precio_total |
+---------------+--------------+-------------+------------+-------------+--------------+
|           137 | 2007-09-23   | 2007-09-23  |       1001 |         706 |      1235.65 |
|           817 | 2008-02-08   | 2008-02-08  |       1001 |         705 |      1530.90 |
|           851 | 2008-02-13   | 2008-02-13  |       1001 |         702 |      1502.40 |
|           931 | 2008-02-27   | 2008-02-27  |       1001 |         707 |       225.00 |
+---------------+--------------+-------------+------------+-------------+--------------+
4 rows in set (0,00 sec)

/*Ej18*/
mysql> SELECT nombre,apellidos,provincia,cod_postal FROM clientes WHERE (apellidos='Pelayo') OR (provincia='CACERES') OR (cod_postal LIKE '%9');
+-----------+-----------+-----------+------------+
| nombre    | apellidos | provincia | cod_postal |
+-----------+-----------+-----------+------------+
| Guillermo | Torres    | MADRID    | 28019      |
| Nicolas   | Pelayo    | CACERES   | 10199      |
| Raquel    | Pelayo    | CACERES   | 10199      |
| Samuel    | Abadia    | CACERES   | 10263      |
| Daniel    | Gil       | CACERES   | 10926      |
| David     | Sanz      | CACERES   | 10538      |
| Zacarias  | Escudero  | CACERES   | 10209      |
| Camilo    | Viescas   | CACERES   | 10809      |
| Maria     | Pelayo    | TOLEDO    | 45915      |
| Lucas     | Pelayo    | ORENSE    | 32208      |
+-----------+-----------+-----------+------------+
10 rows in set (0,00 sec)

/*Ej19*/
mysql> SELECT * FROM proveedores WHERE provincia IN ('CACERES','ORENSE','MADRID');
+---------+------------------------+---------------------------+------------+-----------+------------+----------------+----------------+-----------------------------+--------------------------+
| id_prov | nombre                 | direccion                 | ciudad     | provincia | cod_postal | telefono       | fax            | pag_web                     | email                    |
+---------+------------------------+---------------------------+------------+-----------+------------+----------------+----------------+-----------------------------+--------------------------+
|       1 | Shinoman, Incorporated | Calle Sur 34              | Belmonte   | MADRID    | 28001      | (91) 888-1234  | (91) 888-1235  | http://www.shinoman.com/    | Sales@Shiniman.com       |
|       3 | Nikoma of America      | Carretera del Norte 88    | Batres     | MADRID    | 28324      | (91) 666-1234  | (91) 666-1235  | http://www.nikomabikes.com/ | BuyBikes@NikomaBikes.com |
|       5 | Kona, Incorporated     | Apartado de correos 28429 | Robledo    | MADRID    | 28052      | (91) 333-1234  | (91) 333-1235  | http://www.konabikes.com/   | Sales@KonaBikes.com      |
|       8 | Sun Sports Suppliers   | Apartado 10082            | Saucedilla | CACERES   | 10003      | (927) 777-9876 | (310) 777-9877 | NULL                        | NULL                     |
+---------+------------------------+---------------------------+------------+-----------+------------+----------------+----------------+-----------------------------+--------------------------+
4 rows in set (0,00 sec)

/*Ej20*/
mysql> SELECT * FROM clientes WHERE ciudad NOT IN ('Robledo','Somosierra');
+------------+-----------+-----------+-----------------------------+--------------+-----------+------------+-------------+----------+
| id_cliente | nombre    | apellidos | direccion                   | ciudad       | provincia | cod_postal | codigo_area | telefono |
+------------+-----------+-----------+-----------------------------+--------------+-----------+------------+-------------+----------+
|       1002 | Guillermo | Torres    | Calle del Rio 122           | Daganzo      | MADRID    | 28019      |         425 | 555-2681 |
|       1003 | German    | Higueras  | Ruta 2, apartado 203B       | Acebeda (La) | MADRID    | 28002      |         253 | 555-2676 |
|       1004 | Roberto   | Blanes    | Avenida del Monte 672       | Hontanar     | TOLEDO    | 45201      |         713 | 555-2491 |
|       1007 | Maria     | Salgado   | Avenida Pirineos 901        | O Pereiro    | ORENSE    | 32208      |         503 | 555-2526 |
|       1008 | Nicolas   | Pelayo    | Valle Oeste 233             | Santa Ana    | CACERES   | 10199      |         619 | 555-2541 |
|       1010 | Angel     | Sanchez   | Carretera del Rio 667       | Ajofrin      | TOLEDO    | 45710      |         512 | 555-2571 |
|       1011 | Ana       | Higueras  | Ruta 2, apartado 203B       | Venturada    | MADRID    | 28072      |         425 | 555-2631 |
|       1012 | Lisa      | Colomer   | Calle Zurita 13             | Belmonte     | MADRID    | 28006      |         425 | 555-2556 |
|       1013 | Raquel    | Pelayo    |  Buena Vista 21             | Santa Ana    | CACERES   | 10199      |         619 | 555-2546 |
|       1014 | Samuel    | Abadia    | Avda de los Alpes 60        | Plasencia    | CACERES   | 10263      |         760 | 555-2611 |
|       1015 | Daniel    | Gil       | Calle del Mar 26            | Santa Ana    | CACERES   | 10926      |         530 | 555-2616 |
|       1016 | Jaime     | Vives     | Serrano 101                 | Seiro        | ORENSE    | 32301      |         503 | 555-2636 |
|       1017 | Manuela   | Seidel    | Coso 68                     | Mundil       | ORENSE    | 32501      |         541 | 555-2641 |
|       1018 | David     | Sanz      | Calle de Vallejuelo 31      | Fresnedoso   | CACERES   | 10538      |         510 | 555-2646 |
|       1019 | Zacarias  | Escudero  | Calle de kioto 123          | Garvin       | CACERES   | 10209      |         818 | 555-2721 |
|       1020 | Joaquin   | Bou       | Tamesis 24                  | Belmonte     | MADRID    | 28006      |         425 | 555-2726 |
|       1021 | Estella   | Punset    | Paseo Rosales 250           | Dosbarrios   | TOLEDO    | 45260      |         972 | 555-9938 |
|       1022 | Camilo    | Viescas   | Carretera Cuatro Vientos 45 | Ladrillar    | CACERES   | 10809      |         562 | 555-0037 |
|       1024 | Marcos    | Rosales   | Calle abogados 32           | Escalonilla  | TOLEDO    | 45915      |         915 | 555-2286 |
|       1025 | Maria     | Pelayo    | Carretera de Castellon 44   | Escalonilla  | TOLEDO    | 45915      |         915 | 555-2291 |
|       1026 | Luis      | Donoso    | Avda del Oeste 45           | San Roman    | TOLEDO    | 45284      |         210 | 555-2311 |
|       1027 | Lucas     | Pelayo    | Avda del Sur 87             | O Pereiro    | ORENSE    | 32208      |         503 | 555-2316 |
+------------+-----------+-----------+-----------------------------+--------------+-----------+------------+-------------+----------+
22 rows in set (0,00 sec)

/*Ej21*/
mysql> SELECT numero_pedido,id_cliente,fecha_pedido FROM pedidos WHERE id_cliente=1001 ORDER BY fecha_pedido;
+---------------+------------+--------------+
| numero_pedido | id_cliente | fecha_pedido |
+---------------+------------+--------------+
|             7 |       1001 | 2007-09-01   |
|             2 |       1001 | 2007-09-01   |
|            16 |       1001 | 2007-09-02   |
|            55 |       1001 | 2007-09-09   |
|           107 |       1001 | 2007-09-16   |
|           137 |       1001 | 2007-09-23   |
|           138 |       1001 | 2007-09-24   |
|           151 |       1001 | 2007-09-27   |
|           154 |       1001 | 2007-09-29   |
|           213 |       1001 | 2007-10-11   |
|           320 |       1001 | 2007-11-02   |
|           346 |       1001 | 2007-11-07   |
|           349 |       1001 | 2007-11-08   |
|           394 |       1001 | 2007-11-18   |
|           408 |       1001 | 2007-11-23   |
|           413 |       1001 | 2007-11-24   |
|           425 |       1001 | 2007-11-26   |
|           426 |       1001 | 2007-11-26   |
|           443 |       1001 | 2007-11-29   |
|           452 |       1001 | 2007-11-30   |
|           475 |       1001 | 2007-12-06   |
|           501 |       1001 | 2007-12-11   |
|           564 |       1001 | 2007-12-24   |
|           567 |       1001 | 2007-12-25   |
|           596 |       1001 | 2007-12-31   |
|           608 |       1001 | 2008-01-02   |
|           632 |       1001 | 2008-01-07   |
|           649 |       1001 | 2008-01-09   |
|           657 |       1001 | 2008-01-10   |
|           701 |       1001 | 2008-01-17   |
|           723 |       1001 | 2008-01-21   |
|           732 |       1001 | 2008-01-23   |
|           817 |       1001 | 2008-02-08   |
|           851 |       1001 | 2008-02-13   |
|           855 |       1001 | 2008-02-14   |
|           887 |       1001 | 2008-02-20   |
|           898 |       1001 | 2008-02-21   |
|           931 |       1001 | 2008-02-27   |
+---------------+------------+--------------+
38 rows in set (0,00 sec)

/*Ej22*/
mysql> SELECT * FROM productos WHERE nombre LIKE 'Dog%' ORDER BY nombre;
+-----------------+------------------------------+-------------+--------------+-------+--------------+
| numero_producto | nombre                       | descripcion | precio_venta | stock | id_categoria |
+-----------------+------------------------------+-------------+--------------+-------+--------------+
|              21 | Dog Ear Aero-Flow Hinchador  | NULL        |        55.00 |    25 |            1 |
|               3 | Dog Ear Cyclecomputer        | NULL        |        75.00 |    20 |            1 |
|               5 | Dog Ear Helmet Mount Espejos | NULL        |         7.45 |    12 |            1 |
|              20 | Dog Ear Monster guantes      | NULL        |        15.00 |    30 |            1 |
+-----------------+------------------------------+-------------+--------------+-------+--------------+
4 rows in set (0,00 sec)

/*Ej23*/
mysql> SELECT nombre FROM proveedores WHERE ciudad IN ('Batres','Belmonte','Robledo');
+------------------------+
| nombre                 |
+------------------------+
| Shinoman, Incorporated |
| Nikoma of America      |
| Kona, Incorporated     |
+------------------------+
3 rows in set (0,00 sec)

/*Ej24*/
mysql> SELECT nombre FROM productos WHERE precio_venta>=125.00 ORDER BY nombre ASC;
+---------------------------------------+
| nombre                                |
+---------------------------------------+
| AeroFlo ATB Ruedas                    |
| Cosmic Elite Road Warrior Ruedas      |
| Cycle-Doc Pro Repair Stand            |
| Eagle FS-3 Mountain Bike              |
| Eagle SA-120 Pedales sin clip         |
| Glide-O-Matic Cycling Casco           |
| GT RTS-2 Mountain Bike                |
| King Cobra Casco                      |
| Road Warrior soporte para maletero    |
| Ultimate Export 2G baca para bibileta |
| Viscount CardioSport Sport Watch      |
| Viscount Mountain Bike                |
+---------------------------------------+
12 rows in set (0,00 sec)

/*Subconsultas*/
/*Ej25*/
mysql> SELECT nombre,apellidos FROM clientes 
WHERE provincia='MADRID' AND ciudad='Belmonte' AND cod_postal='45915' 
AND id_cliente IN (SELECT id_cliente FROM pedidos 
WHERE fecha_pedido LIKE '%-03-%');
Empty set (0.00 sec)

/*Ej26*/
mysql> SELECT DISTINCT(numero_pedido) FROM detalles_pedidos WHERE numero_producto > (SELECT numero_producto FROM productos WHERE nombre='Shinoman 105 SC Frenos') LIMIT 10;
+---------------+
| numero_pedido |
+---------------+
|            17 |
|            21 |
|            26 |
|            27 |
|            33 |
|            49 |
|            73 |
|            77 |
|            79 |
|           127 |
+---------------+
10 rows in set (0.00 sec)

/*Ej27*/
mysql> SELECT nombre FROM proveedores WHERE id_prov IN (SELECT id_prov FROM productos_proveedores 
WHERE numero_producto IN (SELECT numero_producto FROM productos 
WHERE nombre LIKE 'C%' AND numero_producto IN (SELECT numero_producto FROM detalles_pedidos 
WHERE numero_pedido IN (SELECT numero_pedido FROM pedidos 
WHERE fecha_pedido<'2008-03-01'))));
+------------------------+
| nombre                 |
+------------------------+
| Big Sky Mountain Bikes |
| Dog Ear                |
| Sun Sports Suppliers   |
| Lone Star Bike Supply  |
| Armadillo Brand        |
+------------------------+
5 rows in set (0.00 sec)

/*Ej28*/
mysql> SELECT nombre FROM proveedores 
WHERE id_prov IN (SELECT id_prov FROM productos_proveedores 
WHERE numero_producto IN (SELECT numero_producto FROM productos 
WHERE nombre LIKE 'V%' AND numero_producto NOT IN (SELECT numero_producto FROM detalles_pedidos)));
+------------------------+
| nombre                 |
+------------------------+
| Big Sky Mountain Bikes |
| Lone Star Bike Supply  |
+------------------------+
2 rows in set (0.01 sec)

/*Ej29*/
mysql> SELECT * FROM clientes WHERE ciudad NOT IN (SELECT ciudad FROM empleados);
+------------+----------+-----------+-----------------------------+--------------+-----------+------------+-------------+----------+
| id_cliente | nombre   | apellidos | direccion                   | ciudad       | provincia | cod_postal | codigo_area | telefono |
+------------+----------+-----------+-----------------------------+--------------+-----------+------------+-------------+----------+
|       1003 | German   | Higueras  | Ruta 2, apartado 203B       | Acebeda (La) | MADRID    | 28002      |         253 | 555-2676 |
|       1004 | Roberto  | Blanes    | Avenida del Monte 672       | Hontanar     | TOLEDO    | 45201      |         713 | 555-2491 |
|       1007 | Maria    | Salgado   | Avenida Pirineos 901        | O Pereiro    | ORENSE    | 32208      |         503 | 555-2526 |
|       1008 | Nicolas  | Pelayo    | Valle Oeste 233             | Santa Ana    | CACERES   | 10199      |         619 | 555-2541 |
|       1010 | Angel    | Sanchez   | Carretera del Rio 667       | Ajofrin      | TOLEDO    | 45710      |         512 | 555-2571 |
|       1011 | Ana      | Higueras  | Ruta 2, apartado 203B       | Venturada    | MADRID    | 28072      |         425 | 555-2631 |
|       1013 | Raquel   | Pelayo    |  Buena Vista 21             | Santa Ana    | CACERES   | 10199      |         619 | 555-2546 |
|       1014 | Samuel   | Abadia    | Avda de los Alpes 60        | Plasencia    | CACERES   | 10263      |         760 | 555-2611 |
|       1015 | Daniel   | Gil       | Calle del Mar 26            | Santa Ana    | CACERES   | 10926      |         530 | 555-2616 |
|       1016 | Jaime    | Vives     | Serrano 101                 | Seiro        | ORENSE    | 32301      |         503 | 555-2636 |
|       1017 | Manuela  | Seidel    | Coso 68                     | Mundil       | ORENSE    | 32501      |         541 | 555-2641 |
|       1018 | David    | Sanz      | Calle de Vallejuelo 31      | Fresnedoso   | CACERES   | 10538      |         510 | 555-2646 |
|       1019 | Zacarias | Escudero  | Calle de kioto 123          | Garvin       | CACERES   | 10209      |         818 | 555-2721 |
|       1021 | Estella  | Punset    | Paseo Rosales 250           | Dosbarrios   | TOLEDO    | 45260      |         972 | 555-9938 |
|       1022 | Camilo   | Viescas   | Carretera Cuatro Vientos 45 | Ladrillar    | CACERES   | 10809      |         562 | 555-0037 |
|       1024 | Marcos   | Rosales   | Calle abogados 32           | Escalonilla  | TOLEDO    | 45915      |         915 | 555-2286 |
|       1025 | Maria    | Pelayo    | Carretera de Castellon 44   | Escalonilla  | TOLEDO    | 45915      |         915 | 555-2291 |
|       1027 | Lucas    | Pelayo    | Avda del Sur 87             | O Pereiro    | ORENSE    | 32208      |         503 | 555-2316 |
+------------+----------+-----------+-----------------------------+--------------+-----------+------------+-------------+----------+
18 rows in set (0.01 sec)

/*Ej30*/(No se hace)

/*Ej31*/
mysql> SELECT nombre FROM productos WHERE id_categoria IN (SELECT id_categoria FROM categorias WHERE descripcion='Componentes');
+------------------------------------+
| nombre                             |
+------------------------------------+
| Victoria Pro All Weather Llantas   |
| Shinoman 105 SC Frenos             |
| Shinoman Dura-Ace Auriculares      |
| Eagle SA-120 Pedales sin clip      |
| ProFormance clip para pedal 2G     |
| ProFormance ATB Pedal todo-terreno |
| Shinoman Deluxe TX-30 Pedal        |
| Cosmic Elite Road Warrior Ruedas   |
| AeroFlo ATB Ruedas                 |
+------------------------------------+
9 rows in set (0.00 sec)

/*Ej32*/
mysql> SELECT * FROM productos WHERE precio_venta >= ALL (SELECT precio_venta FROM productos);
+-----------------+--------------------------+-------------+--------------+-------+--------------+
| numero_producto | nombre                   | descripcion | precio_venta | stock | id_categoria |
+-----------------+--------------------------+-------------+--------------+-------+--------------+
|               2 | Eagle FS-3 Mountain Bike | NULL        |      1800.00 |     8 |            2 |
+-----------------+--------------------------+-------------+--------------+-------+--------------+
1 row in set (0.00 sec)

/*Ej33*/
mysql> SELECT * FROM productos WHERE precio_venta < (SELECT precio_venta FROM productos WHERE nombre='Eagle SA-120 Pedales sin clip') ORDER BY precio_venta;
+-----------------+---------------------------------------+-------------+--------------+-------+--------------+
| numero_producto | nombre                                | descripcion | precio_venta | stock | id_categoria |
+-----------------+---------------------------------------+-------------+--------------+-------+--------------+
|              15 | ProFormance clip para pedal 2G        | NULL        |         4.99 |    40 |            4 |
|               5 | Dog Ear Helmet Mount Espejos          | NULL        |         7.45 |    12 |            1 |
|              20 | Dog Ear Monster guantes               | NULL        |        15.00 |    30 |            1 |
|              33 | Wonder Wool Cycle Calcetines          | NULL        |        19.00 |    30 |            3 |
|              31 | True Grip Competition Guantes         | NULL        |        22.00 |    20 |            1 |
|              12 | Shinoman 105 SC Frenos                | NULL        |        23.50 |    16 |            4 |
|              27 | X-Pro All Weather Llantas             | NULL        |        24.00 |    20 |            6 |
|              34 | TransPort Bicycle Parrilla            | NULL        |        27.00 |    14 |            1 |
|              16 | ProFormance ATB Pedal todo-terreno    | NULL        |        28.00 |    40 |            4 |
|              28 | Turbo Twin Llantas                    | NULL        |        29.00 |    18 |            6 |
|              32 | Kool-Breeze Rocket Top Jersey         | NULL        |        32.00 |    12 |            3 |
|               9 | Nikoma Lok-Tight U-Lock               | NULL        |        33.00 |    12 |            1 |
|              29 | Ultra-2K Competition Llanta           | NULL        |        34.00 |    22 |            6 |
|              10 | Viscount Microshell Casco             | NULL        |        36.00 |    20 |            1 |
|              35 | HP Deluxe Alforjas                    | NULL        |        39.00 |    10 |            1 |
|              17 | Shinoman Deluxe TX-30 Pedal           | NULL        |        45.00 |    60 |            4 |
|              30 | Clear Shade 85-T Gafas                | NULL        |        45.00 |    14 |            1 |
|              19 | Viscount Tru-Beat pulsometro          | NULL        |        47.00 |    20 |            1 |
|               7 | Viscount C-500 Wireless Bike Computer | NULL        |        49.00 |    30 |            1 |
|               8 | Kryptonite Advanced 2000 U-Lock       | NULL        |        50.00 |    20 |            1 |
|               4 | Victoria Pro All Weather Llantas      | NULL        |        54.95 |    20 |            4 |
|              21 | Dog Ear Aero-Flow Hinchador           | NULL        |        55.00 |    25 |            1 |
|              13 | Shinoman Dura-Ace Auriculares         | NULL        |        67.50 |    20 |            4 |
|              24 | StaDry Cycling culote                 | NULL        |        69.00 |    22 |            3 |
|               3 | Dog Ear Cyclecomputer                 | NULL        |        75.00 |    20 |            1 |
|              22 | Pro-Sport Dillo Gafas de sol          | NULL        |        82.00 |    18 |            1 |
|              23 | Ultra-Pro Rain maillot                | NULL        |        85.00 |    30 |            3 |
|              26 | Glide-O-Matic Cycling Casco           | NULL        |       125.00 |    24 |            1 |
|              25 | King Cobra Casco                      | NULL        |       139.00 |    30 |            1 |
+-----------------+---------------------------------------+-------------+--------------+-------+--------------+
29 rows in set (0.00 sec)

/*Ej34*/









