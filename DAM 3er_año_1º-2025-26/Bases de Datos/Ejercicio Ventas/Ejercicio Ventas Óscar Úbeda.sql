-- Ejercicio de Ventas
-- Óscar Úbeda

-- CONSULTAS BÁSICAS DE SELECCIÓN
-- Ej1
mysql> SELECT CONCAT(nombre, " ", apellidos) AS Nombre, ciudad FROM empleados;
+-----------------+------------+
| Nombre          | ciudad     |
+-----------------+------------+
| Maria Torres    | Daganzo    |
| Mateo Berges    | Tielmes    |
| Carol Viescas   | Horcajuelo |
| Pedro Donoso    | San Roman  |
| David Viescas   | Robledo    |
| Catalina Pelayo | Somosierra |
| Susana Maestre  | Belmonte   |
| Domingo Dumbo   | Navalcan   |
+-----------------+------------+
8 rows in set (0.005 sec)

-- Ej2
mysql> SELECT numero_producto, nombre, precio_venta FROM productos WHERE stock BETWEEN 10 AND 50;
+-----------------+---------------------------------------+--------------+
| numero_producto | nombre                                | precio_venta |
+-----------------+---------------------------------------+--------------+
|               3 | Dog Ear Cyclecomputer                 |        75.00 |
|               4 | Victoria Pro All Weather Llantas      |        54.95 |
|               5 | Dog Ear Helmet Mount Espejos          |         7.45 |
|               7 | Viscount C-500 Wireless Bike Computer |        49.00 |
|               8 | Kryptonite Advanced 2000 U-Lock       |        50.00 |
|               9 | Nikoma Lok-Tight U-Lock               |        33.00 |
|              10 | Viscount Microshell Casco             |        36.00 |
|              12 | Shinoman 105 SC Frenos                |        23.50 |
|              13 | Shinoman Dura-Ace Auriculares         |        67.50 |
|              14 | Eagle SA-120 Pedales sin clip         |       139.95 |
|              15 | ProFormance clip para pedal 2G        |         4.99 |
|              16 | ProFormance ATB Pedal todo-terreno    |        28.00 |
|              18 | Viscount CardioSport Sport Watch      |       179.00 |
|              19 | Viscount Tru-Beat pulsometro          |        47.00 |
|              20 | Dog Ear Monster guantes               |        15.00 |
|              21 | Dog Ear Aero-Flow Hinchador           |        55.00 |
|              22 | Pro-Sport 'Dillo Gafas de sol'        |        82.00 |
|              23 | Ultra-Pro Rain maillot                |        85.00 |
|              24 | StaDry Cycling culote                 |        69.00 |
|              25 | King Cobra Casco                      |       139.00 |
|              26 | Glide-O-Matic Cycling Casco           |       125.00 |
|              27 | X-Pro All Weather Llantas             |        24.00 |
|              28 | Turbo Twin Llantas                    |        29.00 |
|              29 | Ultra-2K Competition Llanta           |        34.00 |
|              30 | Clear Shade 85-T Gafas                |        45.00 |
|              31 | True Grip Competition Guantes         |        22.00 |
|              32 | Kool-Breeze Rocket Top Jersey         |        32.00 |
|              33 | Wonder Wool Cycle Calcetines          |        19.00 |
|              34 | TransPort Bicycle Parrilla            |        27.00 |
|              35 | HP Deluxe Alforjas                    |        39.00 |
|              36 | Cosmic Elite Road Warrior Ruedas      |       165.00 |
|              37 | AeroFlo ATB Ruedas                    |       189.00 |
|              38 | Cycle-Doc Pro Repair Stand            |       166.00 |
+-----------------+---------------------------------------+--------------+
33 rows in set (0.009 sec)

-- Ej3
mysql> SELECT nombre FROM productos WHERE nombre LIKE '%Mountain%' OR '%Trail%' ORDER BY precio_venta DESC;
+--------------------------+
| nombre                   |
+--------------------------+
| Eagle FS-3 Mountain Bike |
| GT RTS-2 Mountain Bike   |
| Viscount Mountain Bike   |
+--------------------------+
3 rows in set, 1 warning (0.011 sec)

-- Ej4
mysql> SELECT * FROM clientes WHERE nombre LIKE '%a' AND provincia NOT IN ('Madrid','Toledo');
+------------+---------+-----------+----------------------+-----------+-----------+------------+-------------+----------+
| id_cliente | nombre  | apellidos | direccion            | ciudad    | provincia | cod_postal | codigo_area | telefono |
+------------+---------+-----------+----------------------+-----------+-----------+------------+-------------+----------+
|       1007 | Maria   | Salgado   | Avenida Pirineos 901 | O Pereiro | ORENSE    | 32208      |         503 | 555-2526 |
|       1017 | Manuela | Seidel    | Coso 68              | Mundil    | ORENSE    | 32501      |         541 | 555-2641 |
+------------+---------+-----------+----------------------+-----------+-----------+------------+-------------+----------+
2 rows in set (0.007 sec)

-- Ej5
mysql> SELECT nombre,apellidos, CONCAT(codigo_area, " ", telefono) AS telefono FROM empleados WHERE cod_postal LIKE '28%';
+----------+-----------+--------------+
| nombre   | apellidos | telefono     |
+----------+-----------+--------------+
| Maria    | Torres    | 425 555-2516 |
| Mateo    | Berges    | 253 555-2581 |
| Carol    | Viescas   | 425 555-2576 |
| David    | Viescas   | 425 555-2661 |
| Catalina | Pelayo    | 206 555-2697 |
| Susana   | Maestre   | 425 555-2301 |
+----------+-----------+--------------+
6 rows in set (0.007 sec)

-- Ej6
mysql> SELECT precio_venta AS Precio_Original, precio_venta * 0.85 AS Precio_Con_Descuento FROM productos;
+-----------------+----------------------+
| Precio_Original | Precio_Con_Descuento |
+-----------------+----------------------+
|         1800.00 |            1530.0000 |
|           75.00 |              63.7500 |
|           54.95 |              46.7075 |
|            7.45 |               6.3325 |
|          635.00 |             539.7500 |
|           49.00 |              41.6500 |
|           50.00 |              42.5000 |
|           33.00 |              28.0500 |
|           36.00 |              30.6000 |
|         1650.00 |            1402.5000 |
|           23.50 |              19.9750 |
|           67.50 |              57.3750 |
|          139.95 |             118.9575 |
|            4.99 |               4.2415 |
|           28.00 |              23.8000 |
|           45.00 |              38.2500 |
|          179.00 |             152.1500 |
|           47.00 |              39.9500 |
|           15.00 |              12.7500 |
|           55.00 |              46.7500 |
|           82.00 |              69.7000 |
|           85.00 |              72.2500 |
|           69.00 |              58.6500 |
|          139.00 |             118.1500 |
|          125.00 |             106.2500 |
|           24.00 |              20.4000 |
|           29.00 |              24.6500 |
|           34.00 |              28.9000 |
|           45.00 |              38.2500 |
|           22.00 |              18.7000 |
|           32.00 |              27.2000 |
|           19.00 |              16.1500 |
|           27.00 |              22.9500 |
|           39.00 |              33.1500 |
|          165.00 |             140.2500 |
|          189.00 |             160.6500 |
|          166.00 |             141.1000 |
|          175.00 |             148.7500 |
|          180.00 |             153.0000 |
+-----------------+----------------------+
39 rows in set (0.007 sec)

-- SUBCONSULTAS
-- Ej7
mysql> SELECT * FROM productos WHERE precio_venta > (SELECT AVG(precio_venta) FROM productos);
+-----------------+---------------------------------------+-------------+--------------+-------+--------------+
| numero_producto | nombre                                | descripcion | precio_venta | stock | id_categoria |
+-----------------+---------------------------------------+-------------+--------------+-------+--------------+
|               2 | Eagle FS-3 Mountain Bike              | NULL        |      1800.00 |     8 |            2 |
|               6 | Viscount Mountain Bike                | NULL        |       635.00 |     5 |            2 |
|              11 | GT RTS-2 Mountain Bike                | NULL        |      1650.00 |     5 |            2 |
|              18 | Viscount CardioSport Sport Watch      | NULL        |       179.00 |    12 |            1 |
|              37 | AeroFlo ATB Ruedas                    | NULL        |       189.00 |    40 |            4 |
|              39 | Road Warrior soporte para maletero    | NULL        |       175.00 |     6 |            5 |
|              40 | Ultimate Export 2G baca para bibileta | NULL        |       180.00 |     8 |            5 |
+-----------------+---------------------------------------+-------------+--------------+-------+--------------+
7 rows in set (0.021 sec)

-- Ej8
-- Ej9
mysql> SELECT * FROM proveedores
    -> WHERE id_prov NOT IN (SELECT id_prov FROM productos_proveedores
    -> WHERE numero_producto IN(SELECT numero_producto FROM productos
    -> WHERE numero_producto IN (SELECT numero_producto FROM detalles_pedidos
    -> WHERE numero_pedido IN (SELECT numero_pedido FROM pedidos WHERE YEAR(fecha_pedido) = 2007))));
+---------+-----------------------+------------------+-------------+-----------+------------+----------------+----------------+---------+-------+
| id_prov | nombre                | direccion        | ciudad      | provincia | cod_postal | telefono       | fax            | pag_web | email |
+---------+-----------------------+------------------+-------------+-----------+------------+----------------+----------------+---------+-------+
|      11 | Astro Paper productos | Avda. del Rio 56 | Castroviejo | LA RIOJA  | 26637      | (941) 555-9876 | (941) 555-9875 | NULL    | NULL  |
+---------+-----------------------+------------------+-------------+-----------+------------+----------------+----------------+---------+-------+
1 row in set (0.117 sec)

-- Ej10
mysql> SELECT * FROM categorias WHERE id_categoria NOT IN (SELECT id_categoria FROM productos WHERE precio_venta <= 30);
+--------------+--------------------+
| id_categoria | descripcion        |
+--------------+--------------------+
|            2 | Bicicletas         |
|            5 | **** para el coche |
|            7 | Scooters           |
+--------------+--------------------+
3 rows in set (0.009 sec)

-- Ej11
mysql> SELECT * FROM productos WHERE precio_venta > (SELECT precio_venta FROM productos WHERE numero_producto = 15);
+-----------------+---------------------------------------+-------------+--------------+-------+--------------+
| numero_producto | nombre                                | descripcion | precio_venta | stock | id_categoria |
+-----------------+---------------------------------------+-------------+--------------+-------+--------------+
|               2 | Eagle FS-3 Mountain Bike              | NULL        |      1800.00 |     8 |            2 |
|               3 | Dog Ear Cyclecomputer                 | NULL        |        75.00 |    20 |            1 |
|               4 | Victoria Pro All Weather Llantas      | NULL        |        54.95 |    20 |            4 |
|               5 | Dog Ear Helmet Mount Espejos          | NULL        |         7.45 |    12 |            1 |
|               6 | Viscount Mountain Bike                | NULL        |       635.00 |     5 |            2 |
|               7 | Viscount C-500 Wireless Bike Computer | NULL        |        49.00 |    30 |            1 |
|               8 | Kryptonite Advanced 2000 U-Lock       | NULL        |        50.00 |    20 |            1 |
|               9 | Nikoma Lok-Tight U-Lock               | NULL        |        33.00 |    12 |            1 |
|              10 | Viscount Microshell Casco             | NULL        |        36.00 |    20 |            1 |
|              11 | GT RTS-2 Mountain Bike                | NULL        |      1650.00 |     5 |            2 |
|              12 | Shinoman 105 SC Frenos                | NULL        |        23.50 |    16 |            4 |
|              13 | Shinoman Dura-Ace Auriculares         | NULL        |        67.50 |    20 |            4 |
|              14 | Eagle SA-120 Pedales sin clip         | NULL        |       139.95 |    20 |            4 |
|              16 | ProFormance ATB Pedal todo-terreno    | NULL        |        28.00 |    40 |            4 |
|              17 | Shinoman Deluxe TX-30 Pedal           | NULL        |        45.00 |    60 |            4 |
|              18 | Viscount CardioSport Sport Watch      | NULL        |       179.00 |    12 |            1 |
|              19 | Viscount Tru-Beat pulsometro          | NULL        |        47.00 |    20 |            1 |
|              20 | Dog Ear Monster guantes               | NULL        |        15.00 |    30 |            1 |
|              21 | Dog Ear Aero-Flow Hinchador           | NULL        |        55.00 |    25 |            1 |
|              22 | Pro-Sport 'Dillo Gafas de sol'        | NULL        |        82.00 |    18 |            1 |
|              23 | Ultra-Pro Rain maillot                | NULL        |        85.00 |    30 |            3 |
|              24 | StaDry Cycling culote                 | NULL        |        69.00 |    22 |            3 |
|              25 | King Cobra Casco                      | NULL        |       139.00 |    30 |            1 |
|              26 | Glide-O-Matic Cycling Casco           | NULL        |       125.00 |    24 |            1 |
|              27 | X-Pro All Weather Llantas             | NULL        |        24.00 |    20 |            6 |
|              28 | Turbo Twin Llantas                    | NULL        |        29.00 |    18 |            6 |
|              29 | Ultra-2K Competition Llanta           | NULL        |        34.00 |    22 |            6 |
|              30 | Clear Shade 85-T Gafas                | NULL        |        45.00 |    14 |            1 |
|              31 | True Grip Competition Guantes         | NULL        |        22.00 |    20 |            1 |
|              32 | Kool-Breeze Rocket Top Jersey         | NULL        |        32.00 |    12 |            3 |
|              33 | Wonder Wool Cycle Calcetines          | NULL        |        19.00 |    30 |            3 |
|              34 | TransPort Bicycle Parrilla            | NULL        |        27.00 |    14 |            1 |
|              35 | HP Deluxe Alforjas                    | NULL        |        39.00 |    10 |            1 |
|              36 | Cosmic Elite Road Warrior Ruedas      | NULL        |       165.00 |    22 |            4 |
|              37 | AeroFlo ATB Ruedas                    | NULL        |       189.00 |    40 |            4 |
|              38 | Cycle-Doc Pro Repair Stand            | NULL        |       166.00 |    12 |            1 |
|              39 | Road Warrior soporte para maletero    | NULL        |       175.00 |     6 |            5 |
|              40 | Ultimate Export 2G baca para bibileta | NULL        |       180.00 |     8 |            5 |
+-----------------+---------------------------------------+-------------+--------------+-------+--------------+
38 rows in set (0.140 sec)

-- Ej 12
mysql> SELECT * FROM clientes WHERE provincia = (SELECT provincia FROM clientes WHERE nombre = 'Shinoman, Incorporated');
Empty set (0.011 sec)

-- Ej13
mysql> SELECT * FROM clientes WHERE provincia NOT IN (SELECT DISTINCT provincia FROM proveedores);
+------------+---------+-----------+----------------------+-----------+-----------+------------+-------------+----------+
| id_cliente | nombre  | apellidos | direccion            | ciudad    | provincia | cod_postal | codigo_area | telefono |
+------------+---------+-----------+----------------------+-----------+-----------+------------+-------------+----------+
|       1007 | Maria   | Salgado   | Avenida Pirineos 901 | O Pereiro | ORENSE    | 32208      |         503 | 555-2526 |
|       1016 | Jaime   | Vives     | Serrano 101          | Seiro     | ORENSE    | 32301      |         503 | 555-2636 |
|       1017 | Manuela | Seidel    | Coso 68              | Mundil    | ORENSE    | 32501      |         541 | 555-2641 |
|       1027 | Lucas   | Pelayo    | Avda del Sur 87      | O Pereiro | ORENSE    | 32208      |         503 | 555-2316 |
+------------+---------+-----------+----------------------+-----------+-----------+------------+-------------+----------+
4 rows in set (0.011 sec)

-- Ej14
mysql> SELECT DISTINCT p.* FROM proveedores p JOIN productos_proveedores pp ON p.id_prov = pp.id_prov WHERE pp.numero_producto NOT IN (SELECT numero_producto FROM detalles_pedidos);
+---------+------------------------+----------------------+-------------+-----------+------------+----------------+----------------+---------+-------+
| id_prov | nombre                 | direccion            | ciudad      | provincia | cod_postal | telefono       | fax            | pag_web | email |
+---------+------------------------+----------------------+-------------+-----------+------------+----------------+----------------+---------+-------+
|       6 | Big Sky Mountain Bikes | Carretera del Sol 20 | Albatana    | ALBACETE  | 02653      | (967) 222-1234 | (967) 222-1235 | NULL    | NULL  |
|       9 | Lone Star Bike Supply  | Calle del rey 74     | Escalonilla | TOLEDO    | 45915      | (925) 666-9876 | (925) 666-9877 | NULL    | NULL  |
+---------+------------------------+----------------------+-------------+-----------+------------+----------------+----------------+---------+-------+
2 rows in set (0.213 sec)

-- Ej15
mysql> SELECT DISTINCT p.* FROM proveedores p JOIN productos_proveedores pp ON p.id_prov = pp.id_prov
    -> JOIN detalles_pedidos dp ON pp.numero_producto = dp.numero_producto;
+---------+------------------------+---------------------------+--------------+-----------+------------+----------------+----------------+-------------------------------+------------------------------+
| id_prov | nombre                 | direccion                 | ciudad       | provincia | cod_postal | telefono       | fax            | pag_web                       | email                        |
+---------+------------------------+---------------------------+--------------+-----------+------------+----------------+----------------+-------------------------------+------------------------------+
|       6 | Big Sky Mountain Bikes | Carretera del Sol 20      | Albatana     | ALBACETE  | 02653      | (967) 222-1234 | (967) 222-1235 | NULL                          | NULL                         |
|       9 | Lone Star Bike Supply  | Calle del rey 74          | Escalonilla  | TOLEDO    | 45915      | (925) 666-9876 | (925) 666-9877 | NULL                          | NULL                         |
|       7 | Dog Ear                | Avda. Mar Salada 57       | Navalon      | VALENCIA  | 46003      | (96) 888-9876  | (96) 888-9877  | NULL                          | NULL                         |
|       2 | Viscount               | Calle Comercio 19         | Santa Amalia | MALAGA    | 29127      | (95) 777-1234  | (95) 777-1235  | http://www.viscountbikes.com/ | pedidos@ViscountBikes.com    |
|       8 | Sun Sports Suppliers   | Apartado 10082            | Saucedilla   | CACERES   | 10003      | (927) 777-9876 | (310) 777-9877 | NULL                          | NULL                         |
|       3 | Nikoma of America      | Carretera del Norte 88    | Batres       | MADRID    | 28324      | (91) 666-1234  | (91) 666-1235  | http://www.nikomabikes.com/   | BuyBikes@NikomaBikes.com     |
|       1 | Shinoman, Incorporated | Calle Sur 34              | Belmonte     | MADRID    | 28001      | (91) 888-1234  | (91) 888-1235  | http://www.shinoman.com/      | Sales@Shiniman.com           |
|       4 | ProFormance            | Calle San Cirilo 29       | Ademuz       | VALENCIA  | 46012      | (96) 444-1234  | (96) 444-1235  | http://www.ProFormBikes.com/  | Sales@ProFormBikes.com       |
|      10 | Armadillo Brand        | Calle de al lado 123      | Dosbarrios   | TOLEDO    | 45137      | (925) 444-9876 | (925) 444-9877 | http://www.DilloBikes.com/    | Bikeproductos@DilloBikes.com |
|       5 | Kona, Incorporated     | Apartado de correos 28429 | Robledo      | MADRID    | 28052      | (91) 333-1234  | (91) 333-1235  | http://www.konabikes.com/     | Sales@KonaBikes.com          |
+---------+------------------------+---------------------------+--------------+-----------+------------+----------------+----------------+-------------------------------+------------------------------+
10 rows in set (0.022 sec)

-- Ej16
mysql> SELECT * FROM productos WHERE precio_venta
    -> > ALL (SELECT p2.precio_venta FROM productos p2 JOIN categorias c ON p2.id_categoria = c.id_categoria
    -> WHERE c.descripcion = 'Ropa');
+-----------------+---------------------------------------+-------------+--------------+-------+--------------+
| numero_producto | nombre                                | descripcion | precio_venta | stock | id_categoria |
+-----------------+---------------------------------------+-------------+--------------+-------+--------------+
|               2 | Eagle FS-3 Mountain Bike              | NULL        |      1800.00 |     8 |            2 |
|               6 | Viscount Mountain Bike                | NULL        |       635.00 |     5 |            2 |
|              11 | GT RTS-2 Mountain Bike                | NULL        |      1650.00 |     5 |            2 |
|              14 | Eagle SA-120 Pedales sin clip         | NULL        |       139.95 |    20 |            4 |
|              18 | Viscount CardioSport Sport Watch      | NULL        |       179.00 |    12 |            1 |
|              25 | King Cobra Casco                      | NULL        |       139.00 |    30 |            1 |
|              26 | Glide-O-Matic Cycling Casco           | NULL        |       125.00 |    24 |            1 |
|              36 | Cosmic Elite Road Warrior Ruedas      | NULL        |       165.00 |    22 |            4 |
|              37 | AeroFlo ATB Ruedas                    | NULL        |       189.00 |    40 |            4 |
|              38 | Cycle-Doc Pro Repair Stand            | NULL        |       166.00 |    12 |            1 |
|              39 | Road Warrior soporte para maletero    | NULL        |       175.00 |     6 |            5 |
|              40 | Ultimate Export 2G baca para bibileta | NULL        |       180.00 |     8 |            5 |
+-----------------+---------------------------------------+-------------+--------------+-------+--------------+
12 rows in set (0.113 sec)

-- Ej17
mysql> SELECT * FROM pedidos WHERE precio_total < ALL (SELECT precio_total FROM pedidos WHERE id_cliente = 1001);
Empty set (0.212 sec)

-- Ej18
mysql> SELECT * FROM productos p WHERE precio_venta <= ALL
    -> (SELECT p2.precio_venta FROM productos p2 WHERE p2.id_categoria = p.id_categoria);
+-----------------+------------------------------------+-------------+--------------+-------+--------------+
| numero_producto | nombre                             | descripcion | precio_venta | stock | id_categoria |
+-----------------+------------------------------------+-------------+--------------+-------+--------------+
|               5 | Dog Ear Helmet Mount Espejos       | NULL        |         7.45 |    12 |            1 |
|               6 | Viscount Mountain Bike             | NULL        |       635.00 |     5 |            2 |
|              15 | ProFormance clip para pedal 2G     | NULL        |         4.99 |    40 |            4 |
|              27 | X-Pro All Weather Llantas          | NULL        |        24.00 |    20 |            6 |
|              33 | Wonder Wool Cycle Calcetines       | NULL        |        19.00 |    30 |            3 |
|              39 | Road Warrior soporte para maletero | NULL        |       175.00 |     6 |            5 |
+-----------------+------------------------------------+-------------+--------------+-------+--------------+
6 rows in set (0.012 sec)