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
