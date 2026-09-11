/*Tarea de Recuperacion de las Practicas Veterinaria - Óscar Úbeda*/
/*CONSULTAS SENCILLAS*/
/*Ej1*/
mysql> SELECT nombre FROM clinica;
+----------------------------+
| nombre                     |
+----------------------------+
| Cl├¡nica Veterinaria Norte |
| Cl├¡nica Veterinaria Sur   |
| VetSalud Sevilla           |
| Cl├¡nica Animal Barcelona  |
| VetNord Bilbao             |
+----------------------------+
5 rows in set (0.00 sec)

/*Ej2*/
mysql> SELECT nombre, ciudad, num_boxes FROM clinica;
+----------------------------+-----------+-----------+
| nombre                     | ciudad    | num_boxes |
+----------------------------+-----------+-----------+
| Cl├¡nica Veterinaria Norte | Madrid    |         6 |
| Cl├¡nica Veterinaria Sur   | Madrid    |         4 |
| VetSalud Sevilla           | Sevilla   |         8 |
| Cl├¡nica Animal Barcelona  | Barcelona |         5 |
| VetNord Bilbao             | Bilbao    |         3 |
+----------------------------+-----------+-----------+
5 rows in set (0.00 sec)

/*Ej3*/
mysql> SELECT * FROM mascota;
+------------+--------+---------+------------------+------------+---------+--------------+----------------+
| id_mascota | nombre | especie | raza             | fecha_nac  | peso_kg | esterilizado | id_propietario |
+------------+--------+---------+------------------+------------+---------+--------------+----------------+
|          1 | Roco   | Perro   | Labrador         | 2018-04-10 |   28.50 | S            |              1 |
|          2 | Luna   | Gato    | Siam├®s          | 2020-01-15 |    4.20 | N            |              1 |
|          3 | Max    | Perro   | Pastor Alem├ín   | 2016-07-22 |   32.00 | S            |              2 |
|          4 | Nala   | Gato    | Persa            | 2019-11-03 |    3.80 | S            |              3 |
|          5 | Kira   | Perro   | Golden Retriever | 2021-03-08 |   24.70 | N            |              3 |
|          6 | Pico   | Ave     | Loro Gris        | 2017-06-14 |    0.45 | N            |              4 |
|          7 | Zeus   | Perro   | Rottweiler       | 2015-09-30 |   42.00 | S            |              5 |
|          8 | Mimi   | Gato    | Com├║n europeo   | 2022-02-20 |    3.10 | N            |              5 |
|          9 | Simba  | Perro   | Beagle           | 2020-08-05 |   11.20 | S            |              6 |
|         10 | Cleo   | Reptil  | Iguana           | 2019-12-01 |    1.80 | N            |              7 |
|         11 | Toby   | Perro   | Bulldog Franc├®s | 2021-05-17 |    9.50 | N            |              8 |
|         12 | Lola   | Gato    | Maine Coon       | 2018-10-28 |    6.30 | S            |              9 |
|         13 | Buba   | Perro   | Chihuahua        | 2023-01-11 |    2.20 | N            |             10 |
|         14 | Nico   | Ave     | Canario          | 2020-04-02 |    0.02 | N            |              4 |
|         15 | Duna   | Perro   | Husky Siberiano  | 2019-06-25 |   22.00 | S            |              2 |
+------------+--------+---------+------------------+------------+---------+--------------+----------------+
15 rows in set (0.00 sec)

/*Ej4*/
mysql> SELECT nombre,especialidad,salario FROM veterinario;
+--------+------------------+---------+
| nombre | especialidad     | salario |
+--------+------------------+---------+
| Ana    | Medicina general | 2800.00 |
| Carlos | Cirug├¡a         | 3500.00 |
| Luc├¡a | Dermatolog├¡a    | 3100.00 |
| Jorge  | Medicina general | 2700.00 |
| Marta  | Oncolog├¡a       | 3900.00 |
| Pedro  | Traumatolog├¡a   | 3300.00 |
| Elena  | Medicina general | 2850.00 |
| Ra├║l  | Cardiolog├¡a     | 4100.00 |
| Sof├¡a | Cirug├¡a         | 3600.00 |
| Iv├ín  | Dermatolog├¡a    | 3050.00 |
+--------+------------------+---------+
10 rows in set (0.00 sec)

/*Ej5*/
mysql> SELECT DISTINCT(especie) AS Especie FROM mascota;
+---------+
| Especie |
+---------+
| Perro   |
| Gato    |
| Ave     |
| Reptil  |
+---------+
4 rows in set (0.00 sec)

/*Ej6*/
mysql> SELECT (importe * 1.21) AS importeConIVA, fecha, motivo FROM consulta;
+---------------+------------+-------------------------+
| importeConIVA | fecha      | motivo                  |
+---------------+------------+-------------------------+
|       54.4500 | 2023-01-10 | Revisi├│n anual         |
|       96.8000 | 2023-02-14 | Cojera pata delantera   |
|      114.9500 | 2023-03-05 | P├®rdida de pelo        |
|       72.6000 | 2023-03-22 | V├│mitos                |
|       54.4500 | 2023-04-11 | Revisi├│n anual         |
|      181.5000 | 2023-04-18 | Bulto en piel           |
|       54.4500 | 2023-05-02 | Revisi├│n anual         |
|      133.1000 | 2023-05-20 | Problemas respiratorios |
|      242.0000 | 2023-06-08 | Cojera pata trasera     |
|       54.4500 | 2023-06-15 | Revisi├│n rutinaria     |
|      387.2000 | 2023-07-03 | No come                 |
|      302.5000 | 2023-07-19 | Masa abdominal          |
|       54.4500 | 2023-08-10 | Revisi├│n anual         |
|       66.5500 | 2023-08-25 | Herida en pata          |
|      102.8500 | 2023-09-14 | P├®rdida de pelo        |
|      217.8000 | 2023-09-30 | Convulsiones            |
|       54.4500 | 2023-10-07 | Revisi├│n anual         |
|       84.7000 | 2023-10-22 | Infecci├│n ocular       |
|      157.3000 | 2023-11-05 | Cojera generalizada     |
|       54.4500 | 2023-11-18 | Revisi├│n anual         |
|      338.8000 | 2023-12-03 | Dificultad al respirar  |
|       54.4500 | 2023-12-20 | Revisi├│n anual         |
|      193.6000 | 2024-01-08 | Masa en cuello          |
|      266.2000 | 2024-01-25 | V├│mitos y diarrea      |
|       54.4500 | 2024-02-12 | Revisi├│n anual         |
|      139.1500 | 2024-02-28 | Prurito intenso         |
|       72.6000 | 2024-03-15 | Control postoperatorio  |
|       54.4500 | 2024-04-02 | Revisi├│n anual         |
|      423.5000 | 2024-04-18 | Fractura radio          |
|       54.4500 | 2024-05-07 | Revisi├│n anual         |
+---------------+------------+-------------------------+
30 rows in set (0.00 sec)

/*Ej7*/
mysql> SELECT nombre AS veterinario, (salario * 14) AS coste_anual FROM veterinario;
+-------------+-------------+
| veterinario | coste_anual |
+-------------+-------------+
| Ana         |    39200.00 |
| Carlos      |    49000.00 |
| Luc├¡a      |    43400.00 |
| Jorge       |    37800.00 |
| Marta       |    54600.00 |
| Pedro       |    46200.00 |
| Elena       |    39900.00 |
| Ra├║l       |    57400.00 |
| Sof├¡a      |    50400.00 |
| Iv├ín       |    42700.00 |
+-------------+-------------+
10 rows in set (0.00 sec)

/*Ej8*/
mysql> SELECT fecha, motivo, importe FROM consulta WHERE YEAR(fecha) = 2023;
+------------+-------------------------+---------+
| fecha      | motivo                  | importe |
+------------+-------------------------+---------+
| 2023-01-10 | Revisi├│n anual         |   45.00 |
| 2023-02-14 | Cojera pata delantera   |   80.00 |
| 2023-03-05 | P├®rdida de pelo        |   95.00 |
| 2023-03-22 | V├│mitos                |   60.00 |
| 2023-04-11 | Revisi├│n anual         |   45.00 |
| 2023-04-18 | Bulto en piel           |  150.00 |
| 2023-05-02 | Revisi├│n anual         |   45.00 |
| 2023-05-20 | Problemas respiratorios |  110.00 |
| 2023-06-08 | Cojera pata trasera     |  200.00 |
| 2023-06-15 | Revisi├│n rutinaria     |   45.00 |
| 2023-07-03 | No come                 |  320.00 |
| 2023-07-19 | Masa abdominal          |  250.00 |
| 2023-08-10 | Revisi├│n anual         |   45.00 |
| 2023-08-25 | Herida en pata          |   55.00 |
| 2023-09-14 | P├®rdida de pelo        |   85.00 |
| 2023-09-30 | Convulsiones            |  180.00 |
| 2023-10-07 | Revisi├│n anual         |   45.00 |
| 2023-10-22 | Infecci├│n ocular       |   70.00 |
| 2023-11-05 | Cojera generalizada     |  130.00 |
| 2023-11-18 | Revisi├│n anual         |   45.00 |
| 2023-12-03 | Dificultad al respirar  |  280.00 |
| 2023-12-20 | Revisi├│n anual         |   45.00 |
+------------+-------------------------+---------+
22 rows in set (0.00 sec)

/*Ej9*/
mysql> SELECT nombre, especie, peso_kg FROM mascota WHERE peso_kg > 15;
+--------+---------+---------+
| nombre | especie | peso_kg |
+--------+---------+---------+
| Roco   | Perro   |   28.50 |
| Max    | Perro   |   32.00 |
| Kira   | Perro   |   24.70 |
| Zeus   | Perro   |   42.00 |
| Duna   | Perro   |   22.00 |
+--------+---------+---------+
5 rows in set (0.00 sec)

/*Ej10*/
mysql> SELECT nombre, salario FROM veterinario WHERE salario > 3200;
+--------+---------+
| nombre | salario |
+--------+---------+
| Carlos | 3500.00 |
| Marta  | 3900.00 |
| Pedro  | 3300.00 |
| Ra├║l  | 4100.00 |
| Sof├¡a | 3600.00 |
+--------+---------+
5 rows in set (0.00 sec)

/*Ej11*/
mysql> SELECT fecha, motivo, importe FROM consulta WHERE importe BETWEEN 100 AND 250;
+------------+-------------------------+---------+
| fecha      | motivo                  | importe |
+------------+-------------------------+---------+
| 2023-04-18 | Bulto en piel           |  150.00 |
| 2023-05-20 | Problemas respiratorios |  110.00 |
| 2023-06-08 | Cojera pata trasera     |  200.00 |
| 2023-07-19 | Masa abdominal          |  250.00 |
| 2023-09-30 | Convulsiones            |  180.00 |
| 2023-11-05 | Cojera generalizada     |  130.00 |
| 2024-01-08 | Masa en cuello          |  160.00 |
| 2024-01-25 | V├│mitos y diarrea      |  220.00 |
| 2024-02-28 | Prurito intenso         |  115.00 |
+------------+-------------------------+---------+
9 rows in set (0.00 sec)

/*Ej12*/
mysql> SELECT * FROM mascota WHERE especie = 'Gato' OR especie = 'Perro';
+------------+--------+---------+------------------+------------+---------+--------------+----------------+
| id_mascota | nombre | especie | raza             | fecha_nac  | peso_kg | esterilizado | id_propietario |
+------------+--------+---------+------------------+------------+---------+--------------+----------------+
|          1 | Roco   | Perro   | Labrador         | 2018-04-10 |   28.50 | S            |              1 |
|          2 | Luna   | Gato    | Siam├®s          | 2020-01-15 |    4.20 | N            |              1 |
|          3 | Max    | Perro   | Pastor Alem├ín   | 2016-07-22 |   32.00 | S            |              2 |
|          4 | Nala   | Gato    | Persa            | 2019-11-03 |    3.80 | S            |              3 |
|          5 | Kira   | Perro   | Golden Retriever | 2021-03-08 |   24.70 | N            |              3 |
|          7 | Zeus   | Perro   | Rottweiler       | 2015-09-30 |   42.00 | S            |              5 |
|          8 | Mimi   | Gato    | Com├║n europeo   | 2022-02-20 |    3.10 | N            |              5 |
|          9 | Simba  | Perro   | Beagle           | 2020-08-05 |   11.20 | S            |              6 |
|         11 | Toby   | Perro   | Bulldog Franc├®s | 2021-05-17 |    9.50 | N            |              8 |
|         12 | Lola   | Gato    | Maine Coon       | 2018-10-28 |    6.30 | S            |              9 |
|         13 | Buba   | Perro   | Chihuahua        | 2023-01-11 |    2.20 | N            |             10 |
|         15 | Duna   | Perro   | Husky Siberiano  | 2019-06-25 |   22.00 | S            |              2 |
+------------+--------+---------+------------------+------------+---------+--------------+----------------+
12 rows in set (0.00 sec)

mysql> SELECT * FROM mascota WHERE (especie='Gato') OR (SELECT especie = 'Perro');
+------------+--------+---------+------------------+------------+---------+--------------+----------------+
| id_mascota | nombre | especie | raza             | fecha_nac  | peso_kg | esterilizado | id_propietario |
+------------+--------+---------+------------------+------------+---------+--------------+----------------+
|          1 | Roco   | Perro   | Labrador         | 2018-04-10 |   28.50 | S            |              1 |
|          2 | Luna   | Gato    | Siam├®s          | 2020-01-15 |    4.20 | N            |              1 |
|          3 | Max    | Perro   | Pastor Alem├ín   | 2016-07-22 |   32.00 | S            |              2 |
|          4 | Nala   | Gato    | Persa            | 2019-11-03 |    3.80 | S            |              3 |
|          5 | Kira   | Perro   | Golden Retriever | 2021-03-08 |   24.70 | N            |              3 |
|          7 | Zeus   | Perro   | Rottweiler       | 2015-09-30 |   42.00 | S            |              5 |
|          8 | Mimi   | Gato    | Com├║n europeo   | 2022-02-20 |    3.10 | N            |              5 |
|          9 | Simba  | Perro   | Beagle           | 2020-08-05 |   11.20 | S            |              6 |
|         11 | Toby   | Perro   | Bulldog Franc├®s | 2021-05-17 |    9.50 | N            |              8 |
|         12 | Lola   | Gato    | Maine Coon       | 2018-10-28 |    6.30 | S            |              9 |
|         13 | Buba   | Perro   | Chihuahua        | 2023-01-11 |    2.20 | N            |             10 |
|         15 | Duna   | Perro   | Husky Siberiano  | 2019-06-25 |   22.00 | S            |              2 |
+------------+--------+---------+------------------+------------+---------+--------------+----------------+
12 rows in set (0.00 sec)

/*Ej13*/
mysql> SELECT * FROM clinica WHERE ciudad = 'Madrid' AND num_boxes >= 5;
+-------------+----------------------------+--------+------------------+-----------+-----------+
| cod_clinica | nombre                     | ciudad | direccion        | telefono  | num_boxes |
+-------------+----------------------------+--------+------------------+-----------+-----------+
| CLN01       | Cl├¡nica Veterinaria Norte | Madrid | Av. de la Paz 12 | 910001001 |         6 |
+-------------+----------------------------+--------+------------------+-----------+-----------+
1 row in set (0.00 sec)

/*Ej14*/
mysql> SELECT * FROM mascota WHERE YEAR(fecha_nac) < 2018 OR YEAR(fecha_nac) > 2021;
+------------+--------+---------+----------------+------------+---------+--------------+----------------+
| id_mascota | nombre | especie | raza           | fecha_nac  | peso_kg | esterilizado | id_propietario |
+------------+--------+---------+----------------+------------+---------+--------------+----------------+
|          3 | Max    | Perro   | Pastor Alem├ín | 2016-07-22 |   32.00 | S            |              2 |
|          6 | Pico   | Ave     | Loro Gris      | 2017-06-14 |    0.45 | N            |              4 |
|          7 | Zeus   | Perro   | Rottweiler     | 2015-09-30 |   42.00 | S            |              5 |
|          8 | Mimi   | Gato    | Com├║n europeo | 2022-02-20 |    3.10 | N            |              5 |
|         13 | Buba   | Perro   | Chihuahua      | 2023-01-11 |    2.20 | N            |             10 |
+------------+--------+---------+----------------+------------+---------+--------------+----------------+
5 rows in set (0.00 sec)

/*Ej15*/
mysql> SELECT * FROM veterinario WHERE cod_clinica = 'CLN01' AND salario > 3000 OR cod_clinica IN (SELECT cod_clinica FROM veterinario WHERE cod_clinica = 'CLN03' AND especialidad = 'Oncolog├¡a');
+---------------+--------+------------------+----------------+---------+------------+-------------+
| num_colegiado | nombre | apellidos        | especialidad   | salario | fecha_alta | cod_clinica |
+---------------+--------+------------------+----------------+---------+------------+-------------+
| V0000002      | Carlos | Mart├¡nez L├│pez | Cirug├¡a       | 3500.00 | 2015-06-15 | CLN01       |
| V0000005      | Marta  | G├│mez Torres    | Oncolog├¡a     | 3900.00 | 2016-11-05 | CLN03       |
| V0000006      | Pedro  | L├│pez Castillo  | Traumatolog├¡a | 3300.00 | 2017-04-22 | CLN03       |
+---------------+--------+------------------+----------------+---------+------------+-------------+
3 rows in set (0.00 sec)

/*Ej16*/
mysql> SELECT * FROM consulta WHERE (num_colegiado = 'V0000003' AND importe > 80.00) OR (SELECT num_colegiado = 'V0000008' AND YEAR(fecha) = 2023);
+-------------+------------+------------------------+-------------------------+---------+--------+------------+---------------+
| id_consulta | fecha      | motivo                 | diagnostico             | importe | pagada | id_mascota | num_colegiado |
+-------------+------------+------------------------+-------------------------+---------+--------+------------+---------------+
|           3 | 2023-03-05 | P├®rdida de pelo       | Dermatitis al├®rgica    |   95.00 | S      |          4 | V0000003      |
|          11 | 2023-07-03 | No come                | Obstrucci├│n intestinal |  320.00 | S      |         11 | V0000008      |
|          15 | 2023-09-14 | P├®rdida de pelo       | Dermatitis seborreica   |   85.00 | S      |          1 | V0000003      |
|          16 | 2023-09-30 | Convulsiones           | Epilepsia idiop├ítica   |  180.00 | N      |          7 | V0000008      |
|          21 | 2023-12-03 | Dificultad al respirar | Insuficiencia card├¡aca |  280.00 | S      |          9 | V0000008      |
|          26 | 2024-02-28 | Prurito intenso        | Sarna sarc├│ptica       |  115.00 | S      |          3 | V0000003      |
+-------------+------------+------------------------+-------------------------+---------+--------+------------+---------------+
6 rows in set (0.00 sec)

/*Ej17*/
mysql> SELECT nombre, especie FROM mascota WHERE especie NOT IN ('Gato', 'Perro');
+--------+---------+
| nombre | especie |
+--------+---------+
| Pico   | Ave     |
| Cleo   | Reptil  |
| Nico   | Ave     |
+--------+---------+
3 rows in set (0.00 sec)

/*Ej18*/
mysql> SELECT * FROM clinica WHERE nombre LIKE ('%Zona%');
Empty set (0.00 sec)

/*No hay clinicas con nombre 'Zona' en el*/

/*Ej19*/
mysql> SELECT nombre, especialidad FROM veterinario WHERE (nombre LIKE 'A%' OR nombre LIKE 'C%' OR nombre LIKE 'M%') AND salario > 3000;
+--------+--------------+
| nombre | especialidad |
+--------+--------------+
| Carlos | Cirug├¡a     |
| Marta  | Oncolog├¡a   |
+--------+--------------+
2 rows in set (0.00 sec)

/*Ej20*/
mysql> SELECT * FROM mascota WHERE YEAR(fecha_nac) IN (2019,2020) AND esterilizado = 'N' AND especie IN ('Perro','Gato') AND peso_kg < 12.00;
+------------+--------+---------+---------+------------+---------+--------------+----------------+
| id_mascota | nombre | especie | raza    | fecha_nac  | peso_kg | esterilizado | id_propietario |
+------------+--------+---------+---------+------------+---------+--------------+----------------+
|          2 | Luna   | Gato    | Siam├®s | 2020-01-15 |    4.20 | N            |              1 |
+------------+--------+---------+---------+------------+---------+--------------+----------------+
1 row in set (0.00 sec)

/*SUBCONSULTAS*/
/*Ej21*/
mysql> SELECT nombre, salario FROM veterinario WHERE salario > (SELECT AVG(salario) FROM veterinario);
+--------+---------+
| nombre | salario |
+--------+---------+
| Carlos | 3500.00 |
| Marta  | 3900.00 |
| Pedro  | 3300.00 |
| Ra├║l  | 4100.00 |
| Sof├¡a | 3600.00 |
+--------+---------+
5 rows in set (0.00 sec)

/*Ej22*/
mysql> SELECT nombre, salario FROM veterinario WHERE salario > (SELECT MAX(salario) FROM veterinario WHERE cod_clinica = 'CLN01');
+--------+---------+
| nombre | salario |
+--------+---------+
| Marta  | 3900.00 |
| Ra├║l  | 4100.00 |
| Sof├¡a | 3600.00 |
+--------+---------+
3 rows in set (0.00 sec)

/*Ej23*/
mysql> SELECT v1.nombre, v1.salario FROM veterinario v1 WHERE v1.salario > (SELECT AVG(v2.salario) FROM veterinario v2 WHERE v2.cod_clinica = v1.cod_clinica);
+--------+---------+
| nombre | salario |
+--------+---------+
| Carlos | 3500.00 |
| Luc├¡a | 3100.00 |
| Marta  | 3900.00 |
| Ra├║l  | 4100.00 |
| Sof├¡a | 3600.00 |
+--------+---------+
5 rows in set (0.00 sec)

/*Ej24*/
mysql> SELECT nombre, precio_base FROM tratamiento WHERE precio_base > (SELECT AVG(precio_base) FROM tratamiento WHERE tipo = 'Vacuna');
+---------------------------+-------------+
| nombre                    | precio_base |
+---------------------------+-------------+
| Vacuna polivalente canina |       35.00 |
| Limpieza dental           |       90.00 |
| Esterilizaci├│n           |      180.00 |
| Radiograf├¡a              |       60.00 |
| An├ílisis de sangre       |       45.00 |
| Quimioterapia sesi├│n     |      200.00 |
+---------------------------+-------------+
6 rows in set (0.00 sec)

/*Ej25*/
mysql> SELECT nombre, especie FROM mascota WHERE id_mascota NOT IN (SELECT id_mascota FROM consulta);
Empty set (0.00 sec)

/*Ej26*/
mysql> SELECT * FROM propietario WHERE id_propietario = ANY (SELECT id_propietario FROM mascota WHERE peso_kg > 30.00);
+----------------+-----------+---------+---------------+-----------+-------------------+--------+
| id_propietario | dni       | nombre  | apellidos     | telefono  | email             | ciudad |
+----------------+-----------+---------+---------------+-----------+-------------------+--------+
|              2 | 22222222B | Antonio | Herrera D├¡az | 611222222 | aherrera@email.es | Madrid |
|              5 | 55555555E | Isabel  | Ramos Flores  | 644555555 | iramos@email.es   | Bilbao |
+----------------+-----------+---------+---------------+-----------+-------------------+--------+
2 rows in set (0.00 sec)

/*Ej27*/
mysql> SELECT * FROM veterinario WHERE salario > ALL (SELECT salario FROM veterinario WHERE cod_clinica = 'CLN02');
+---------------+--------+------------------+----------------+---------+------------+-------------+
| num_colegiado | nombre | apellidos        | especialidad   | salario | fecha_alta | cod_clinica |
+---------------+--------+------------------+----------------+---------+------------+-------------+
| V0000002      | Carlos | Mart├¡nez L├│pez | Cirug├¡a       | 3500.00 | 2015-06-15 | CLN01       |
| V0000005      | Marta  | G├│mez Torres    | Oncolog├¡a     | 3900.00 | 2016-11-05 | CLN03       |
| V0000006      | Pedro  | L├│pez Castillo  | Traumatolog├¡a | 3300.00 | 2017-04-22 | CLN03       |
| V0000008      | Ra├║l  | Jim├®nez Blanco  | Cardiolog├¡a   | 4100.00 | 2014-08-30 | CLN04       |
| V0000009      | Sof├¡a | Navarro Gil      | Cirug├¡a       | 3600.00 | 2018-07-17 | CLN05       |
+---------------+--------+------------------+----------------+---------+------------+-------------+
5 rows in set (0.00 sec)

/*Ej28*/
mysql> SELECT * FROM clinica c WHERE EXISTS (SELECT 1 FROM veterinario v WHERE v.cod_clinica = c.cod_clinica AND EXISTS 
(SELECT 1 FROM consulta co WHERE co.num_colegiado = v.num_colegiado AND co.importe > 200));
+-------------+----------------------------+-----------+------------------+-----------+-----------+
| cod_clinica | nombre                     | ciudad    | direccion        | telefono  | num_boxes |
+-------------+----------------------------+-----------+------------------+-----------+-----------+
| CLN01       | Cl├¡nica Veterinaria Norte | Madrid    | Av. de la Paz 12 | 910001001 |         6 |
| CLN03       | VetSalud Sevilla           | Sevilla   | Av. Borbolla 30  | 954003003 |         8 |
| CLN04       | Cl├¡nica Animal Barcelona  | Barcelona | C/ Arag├│n 210   | 932004004 |         5 |
+-------------+----------------------------+-----------+------------------+-----------+-----------+
3 rows in set (0.00 sec)

/*Ej29*/
mysql> SELECT * FROM tratamiento WHERE cod_trat NOT IN (SELECT cod_trat FROM mascota_tratamiento);
Empty set (0.00 sec)

/*Ej30*/
mysql> SELECT * FROM tratamiento WHERE cod_trat IN (SELECT cod_trat FROM mascota_tratamiento);
+----------+---------------------------+-------------+-------------+--------------+
| cod_trat | nombre                    | tipo        | precio_base | requiere_vet |
+----------+---------------------------+-------------+-------------+--------------+
| TR0001   | Vacuna antirr├íbica       | Vacuna      |       25.00 | S            |
| TR0002   | Vacuna polivalente canina | Vacuna      |       35.00 | S            |
| TR0003   | Desparasitaci├│n interna  | Medicamento |       18.00 | N            |
| TR0004   | Desparasitaci├│n externa  | Medicamento |       15.00 | N            |
| TR0005   | Limpieza dental           | Cirugia     |       90.00 | S            |
| TR0006   | Esterilizaci├│n           | Cirugia     |      180.00 | S            |
| TR0007   | Radiograf├¡a              | Prueba      |       60.00 | S            |
| TR0008   | An├ílisis de sangre       | Prueba      |       45.00 | S            |
| TR0009   | Quimioterapia sesi├│n     | Medicamento |      200.00 | S            |
| TR0010   | Cura de herida            | Medicamento |       30.00 | N            |
+----------+---------------------------+-------------+-------------+--------------+
10 rows in set (0.00 sec)

/*Ej31*/
mysql> SELECT * FROM clinica WHERE cod_clinica IN (SELECT cod_clinica FROM veterinario WHERE salario > 2800);
+-------------+----------------------------+-----------+------------------+-----------+-----------+
| cod_clinica | nombre                     | ciudad    | direccion        | telefono  | num_boxes |
+-------------+----------------------------+-----------+------------------+-----------+-----------+
| CLN01       | Cl├¡nica Veterinaria Norte | Madrid    | Av. de la Paz 12 | 910001001 |         6 |
| CLN02       | Cl├¡nica Veterinaria Sur   | Madrid    | C/ Retama 45     | 910002002 |         4 |
| CLN03       | VetSalud Sevilla           | Sevilla   | Av. Borbolla 30  | 954003003 |         8 |
| CLN04       | Cl├¡nica Animal Barcelona  | Barcelona | C/ Arag├│n 210   | 932004004 |         5 |
| CLN05       | VetNord Bilbao             | Bilbao    | Gran V├¡a 88     | 944005005 |         3 |
+-------------+----------------------------+-----------+------------------+-----------+-----------+
5 rows in set (0.00 sec)

/*Ej32*/
mysql> SELECT * FROM veterinario v WHERE NOT EXISTS (SELECT 1 FROM veterinario v2 WHERE v2.fecha_alta > v.fecha_alta);
+---------------+--------+---------------+---------------+---------+------------+-------------+
| num_colegiado | nombre | apellidos     | especialidad  | salario | fecha_alta | cod_clinica |
+---------------+--------+---------------+---------------+---------+------------+-------------+
| V0000010      | Iv├ín  | Romero Molina | Dermatolog├¡a | 3050.00 | 2022-05-03 | CLN05       |
+---------------+--------+---------------+---------------+---------+------------+-------------+
1 row in set (0.00 sec)

/*Ej33*/
mysql> SELECT * FROM mascota m WHERE m.peso_kg = (SELECT MAX(m2.peso_kg) FROM mascota m2 WHERE m2.especie = m.especie);
+------------+--------+---------+------------+------------+---------+--------------+----------------+
| id_mascota | nombre | especie | raza       | fecha_nac  | peso_kg | esterilizado | id_propietario |
+------------+--------+---------+------------+------------+---------+--------------+----------------+
|          6 | Pico   | Ave     | Loro Gris  | 2017-06-14 |    0.45 | N            |              4 |
|          7 | Zeus   | Perro   | Rottweiler | 2015-09-30 |   42.00 | S            |              5 |
|         10 | Cleo   | Reptil  | Iguana     | 2019-12-01 |    1.80 | N            |              7 |
|         12 | Lola   | Gato    | Maine Coon | 2018-10-28 |    6.30 | S            |              9 |
+------------+--------+---------+------------+------------+---------+--------------+----------------+
4 rows in set (0.00 sec)

/*MULTITABLA*/
/*Ej34*/
mysql> SELECT c.fecha, c.motivo, m.nombre AS nombreMascota, v.nombre AS nombreVet FROM veterinario v JOIN 
consulta c ON v.num_colegiado = c.num_colegiado JOIN mascota m ON c.id_mascota = m.id_mascota;
+------------+-------------------------+---------------+-----------+
| fecha      | motivo                  | nombreMascota | nombreVet |
+------------+-------------------------+---------------+-----------+
| 2023-01-10 | Revisi├│n anual         | Roco          | Ana       |
| 2023-08-10 | Revisi├│n anual         | Mimi          | Ana       |
| 2023-11-18 | Revisi├│n anual         | Cleo          | Ana       |
| 2024-01-25 | V├│mitos y diarrea      | Buba          | Ana       |
| 2024-02-12 | Revisi├│n anual         | Roco          | Ana       |
| 2023-02-14 | Cojera pata delantera   | Max           | Carlos    |
| 2023-04-18 | Bulto en piel           | Simba         | Carlos    |
| 2024-03-15 | Control postoperatorio  | Simba         | Carlos    |
| 2024-04-18 | Fractura radio          | Kira          | Carlos    |
| 2023-03-05 | P├®rdida de pelo        | Nala          | Luc├¡a    |
| 2023-05-02 | Revisi├│n anual         | Luna          | Luc├¡a    |
| 2023-09-14 | P├®rdida de pelo        | Roco          | Luc├¡a    |
| 2023-10-22 | Infecci├│n ocular       | Nala          | Luc├¡a    |
| 2024-02-28 | Prurito intenso         | Max           | Luc├¡a    |
| 2024-04-02 | Revisi├│n anual         | Luna          | Luc├¡a    |
| 2023-03-22 | V├│mitos                | Kira          | Jorge     |
| 2023-08-25 | Herida en pata          | Buba          | Jorge     |
| 2023-12-20 | Revisi├│n anual         | Kira          | Jorge     |
| 2023-04-11 | Revisi├│n anual         | Zeus          | Marta     |
| 2023-07-19 | Masa abdominal          | Duna          | Marta     |
| 2024-01-08 | Masa en cuello          | Lola          | Marta     |
| 2023-06-08 | Cojera pata trasera     | Max           | Pedro     |
| 2023-11-05 | Cojera generalizada     | Duna          | Pedro     |
| 2023-05-20 | Problemas respiratorios | Pico          | Elena     |
| 2023-06-15 | Revisi├│n rutinaria     | Lola          | Elena     |
| 2023-10-07 | Revisi├│n anual         | Nico          | Elena     |
| 2024-05-07 | Revisi├│n anual         | Toby          | Elena     |
| 2023-07-03 | No come                 | Toby          | Ra├║l     |
| 2023-09-30 | Convulsiones            | Zeus          | Ra├║l     |
| 2023-12-03 | Dificultad al respirar  | Simba         | Ra├║l     |
+------------+-------------------------+---------------+-----------+
30 rows in set (0.00 sec)

/*Ej35*/
mysql> SELECT p.nombre AS nombrePropietario, m.nombre AS nombreMascota, m.especie, m.raza FROM mascota m LEFT JOIN propietario p ON m.id_propietario = p.id_propietario;
+-------------------+---------------+---------+------------------+
| nombrePropietario | nombreMascota | especie | raza             |
+-------------------+---------------+---------+------------------+
| Laura             | Roco          | Perro   | Labrador         |
| Laura             | Luna          | Gato    | Siam├®s          |
| Antonio           | Max           | Perro   | Pastor Alem├ín   |
| Mar├¡a            | Nala          | Gato    | Persa            |
| Mar├¡a            | Kira          | Perro   | Golden Retriever |
| Fernando          | Pico          | Ave     | Loro Gris        |
| Isabel            | Zeus          | Perro   | Rottweiler       |
| Isabel            | Mimi          | Gato    | Com├║n europeo   |
| Pablo             | Simba         | Perro   | Beagle           |
| Carmen            | Cleo          | Reptil  | Iguana           |
| Javier            | Toby          | Perro   | Bulldog Franc├®s |
| Rosa              | Lola          | Gato    | Maine Coon       |
| Tom├ís            | Buba          | Perro   | Chihuahua        |
| Fernando          | Nico          | Ave     | Canario          |
| Antonio           | Duna          | Perro   | Husky Siberiano  |
+-------------------+---------------+---------+------------------+
15 rows in set (0.00 sec)

/*Ej36*/
mysql> SELECT c.fecha, c.motivo, c.importe, m.nombre AS nombreMascota, p.nombre AS nombrePropietario, cl.ciudad FROM consulta c 
JOIN mascota m ON c.id_mascota = m.id_mascota JOIN propietario p ON m.id_propietario = p.id_propietario JOIN veterinario v ON c.num_colegiado = v.num_colegiado 
JOIN clinica cl ON v.cod_clinica = cl.cod_clinica;
+------------+-------------------------+---------+---------------+-------------------+-----------+
| fecha      | motivo                  | importe | nombreMascota | nombrePropietario | ciudad    |
+------------+-------------------------+---------+---------------+-------------------+-----------+
| 2023-01-10 | Revisi├│n anual         |   45.00 | Roco          | Laura             | Madrid    |
| 2023-08-10 | Revisi├│n anual         |   45.00 | Mimi          | Isabel            | Madrid    |
| 2023-11-18 | Revisi├│n anual         |   45.00 | Cleo          | Carmen            | Madrid    |
| 2024-01-25 | V├│mitos y diarrea      |  220.00 | Buba          | Tom├ís            | Madrid    |
| 2024-02-12 | Revisi├│n anual         |   45.00 | Roco          | Laura             | Madrid    |
| 2023-02-14 | Cojera pata delantera   |   80.00 | Max           | Antonio           | Madrid    |
| 2023-04-18 | Bulto en piel           |  150.00 | Simba         | Pablo             | Madrid    |
| 2024-03-15 | Control postoperatorio  |   60.00 | Simba         | Pablo             | Madrid    |
| 2024-04-18 | Fractura radio          |  350.00 | Kira          | Mar├¡a            | Madrid    |
| 2023-03-05 | P├®rdida de pelo        |   95.00 | Nala          | Mar├¡a            | Madrid    |
| 2023-05-02 | Revisi├│n anual         |   45.00 | Luna          | Laura             | Madrid    |
| 2023-09-14 | P├®rdida de pelo        |   85.00 | Roco          | Laura             | Madrid    |
| 2023-10-22 | Infecci├│n ocular       |   70.00 | Nala          | Mar├¡a            | Madrid    |
| 2024-02-28 | Prurito intenso         |  115.00 | Max           | Antonio           | Madrid    |
| 2024-04-02 | Revisi├│n anual         |   45.00 | Luna          | Laura             | Madrid    |
| 2023-03-22 | V├│mitos                |   60.00 | Kira          | Mar├¡a            | Madrid    |
| 2023-08-25 | Herida en pata          |   55.00 | Buba          | Tom├ís            | Madrid    |
| 2023-12-20 | Revisi├│n anual         |   45.00 | Kira          | Mar├¡a            | Madrid    |
| 2023-04-11 | Revisi├│n anual         |   45.00 | Zeus          | Isabel            | Sevilla   |
| 2023-07-19 | Masa abdominal          |  250.00 | Duna          | Antonio           | Sevilla   |
| 2024-01-08 | Masa en cuello          |  160.00 | Lola          | Rosa              | Sevilla   |
| 2023-06-08 | Cojera pata trasera     |  200.00 | Max           | Antonio           | Sevilla   |
| 2023-11-05 | Cojera generalizada     |  130.00 | Duna          | Antonio           | Sevilla   |
| 2023-05-20 | Problemas respiratorios |  110.00 | Pico          | Fernando          | Barcelona |
| 2023-06-15 | Revisi├│n rutinaria     |   45.00 | Lola          | Rosa              | Barcelona |
| 2023-10-07 | Revisi├│n anual         |   45.00 | Nico          | Fernando          | Barcelona |
| 2024-05-07 | Revisi├│n anual         |   45.00 | Toby          | Javier            | Barcelona |
| 2023-07-03 | No come                 |  320.00 | Toby          | Javier            | Barcelona |
| 2023-09-30 | Convulsiones            |  180.00 | Zeus          | Isabel            | Barcelona |
| 2023-12-03 | Dificultad al respirar  |  280.00 | Simba         | Pablo             | Barcelona |
+------------+-------------------------+---------+---------------+-------------------+-----------+
30 rows in set (0.00 sec)

/*Ej37*/
mysql> SELECT v.nombre AS nombreVet, v.especialidad, cl.nombre AS nombreCli, cl.ciudad FROM veterinario v JOIN clinica cl ON v.cod_clinica = cl.cod_clinica WHERE cl.ciudad = 'Madrid';
+-----------+------------------+----------------------------+--------+
| nombreVet | especialidad     | nombreCli                  | ciudad |
+-----------+------------------+----------------------------+--------+
| Ana       | Medicina general | Cl├¡nica Veterinaria Norte | Madrid |
| Carlos    | Cirug├¡a         | Cl├¡nica Veterinaria Norte | Madrid |
| Luc├¡a    | Dermatolog├¡a    | Cl├¡nica Veterinaria Sur   | Madrid |
| Jorge     | Medicina general | Cl├¡nica Veterinaria Sur   | Madrid |
+-----------+------------------+----------------------------+--------+
4 rows in set (0.00 sec)

/*Ej38*/
mysql> SELECT p.nombre AS nombrePropietario, m.nombre AS nombreMascota, c.importe AS importePendiente FROM consulta c JOIN mascota m ON c.id_mascota = m.id_mascota JOIN propietario p ON m.id_propietario = p.id_propietario WHERE c.pagada = 'N';
+-------------------+---------------+------------------+
| nombrePropietario | nombreMascota | importePendiente |
+-------------------+---------------+------------------+
| Mar├¡a            | Kira          |            60.00 |
| Fernando          | Pico          |           110.00 |
| Antonio           | Duna          |           250.00 |
| Isabel            | Zeus          |           180.00 |
| Rosa              | Lola          |           160.00 |
+-------------------+---------------+------------------+
5 rows in set (0.00 sec)

/*Ej39*/
mysql> SELECT m.nombre AS nombreMascota,t.nombre AS nombreTratamiento, mt.fecha, mt.num_sesiones FROM mascota m LEFT JOIN mascota_tratamiento mt ON m.id_mascota = mt.id_mascota LEFT JOIN tratamiento t ON mt.cod_trat = t.cod_trat;
+---------------+---------------------------+------------+--------------+
| nombreMascota | nombreTratamiento         | fecha      | num_sesiones |
+---------------+---------------------------+------------+--------------+
| Roco          | Vacuna antirr├íbica       | 2023-01-10 |            1 |
| Roco          | Vacuna antirr├íbica       | 2024-02-12 |            1 |
| Roco          | Desparasitaci├│n interna  | 2023-01-10 |            1 |
| Roco          | Desparasitaci├│n externa  | 2023-09-14 |            3 |
| Luna          | Desparasitaci├│n interna  | 2023-05-02 |            1 |
| Max           | Desparasitaci├│n externa  | 2024-02-28 |            4 |
| Max           | Esterilizaci├│n           | 2023-06-08 |            1 |
| Max           | Radiograf├¡a              | 2023-02-14 |            1 |
| Nala          | Desparasitaci├│n interna  | 2023-10-22 |            1 |
| Nala          | Desparasitaci├│n externa  | 2023-03-05 |            1 |
| Kira          | Vacuna polivalente canina | 2023-03-22 |            1 |
| Kira          | Esterilizaci├│n           | 2024-04-18 |            1 |
| Kira          | Radiograf├¡a              | 2024-04-18 |            1 |
| Pico          | NULL                      | NULL       |         NULL |
| Zeus          | Vacuna antirr├íbica       | 2023-04-11 |            1 |
| Zeus          | An├ílisis de sangre       | 2023-04-11 |            1 |
| Zeus          | An├ílisis de sangre       | 2023-09-30 |            1 |
| Mimi          | NULL                      | NULL       |         NULL |
| Simba         | Limpieza dental           | 2023-04-18 |            1 |
| Simba         | An├ílisis de sangre       | 2023-12-03 |            1 |
| Cleo          | NULL                      | NULL       |         NULL |
| Toby          | An├ílisis de sangre       | 2023-07-03 |            1 |
| Lola          | An├ílisis de sangre       | 2024-01-08 |            1 |
| Buba          | Vacuna polivalente canina | 2024-01-25 |            1 |
| Buba          | Cura de herida            | 2023-08-25 |            5 |
| Nico          | NULL                      | NULL       |         NULL |
| Duna          | Radiograf├¡a              | 2023-11-05 |            2 |
| Duna          | Quimioterapia sesi├│n     | 2023-07-19 |            4 |
+---------------+---------------------------+------------+--------------+
28 rows in set (0.00 sec)

/*Ej40*/
mysql> SELECT m.nombre AS nombreMascota, m.especie, t.nombre AS nombreTratamineto FROM mascota m JOIN mascota_tratamiento mt ON m.id_mascota = mt.id_mascota 
JOIN tratamiento t ON mt.cod_trat = t.cod_trat WHERE t.tipo = 'Cirugia';
+---------------+---------+-------------------+
| nombreMascota | especie | nombreTratamineto |
+---------------+---------+-------------------+
| Simba         | Perro   | Limpieza dental   |
| Max           | Perro   | Esterilizaci├│n   |
| Kira          | Perro   | Esterilizaci├│n   |
+---------------+---------+-------------------+
3 rows in set (0.00 sec)

/*Ej41*/
mysql> SELECT t.tipo,mt.num_sesiones,mt.fecha, m.nombre AS nombreMascota FROM tratamiento t LEFT JOIN mascota_tratamiento mt ON t.cod_trat = mt.cod_trat 
LEFT JOIN mascota m ON mt.id_mascota = m.id_mascota;
+-------------+--------------+------------+---------------+
| tipo        | num_sesiones | fecha      | nombreMascota |
+-------------+--------------+------------+---------------+
| Vacuna      |            1 | 2023-01-10 | Roco          |
| Vacuna      |            1 | 2024-02-12 | Roco          |
| Vacuna      |            1 | 2023-04-11 | Zeus          |
| Vacuna      |            1 | 2023-03-22 | Kira          |
| Vacuna      |            1 | 2024-01-25 | Buba          |
| Medicamento |            1 | 2023-01-10 | Roco          |
| Medicamento |            1 | 2023-05-02 | Luna          |
| Medicamento |            1 | 2023-10-22 | Nala          |
| Medicamento |            3 | 2023-09-14 | Roco          |
| Medicamento |            4 | 2024-02-28 | Max           |
| Medicamento |            1 | 2023-03-05 | Nala          |
| Cirugia     |            1 | 2023-04-18 | Simba         |
| Cirugia     |            1 | 2023-06-08 | Max           |
| Cirugia     |            1 | 2024-04-18 | Kira          |
| Prueba      |            1 | 2023-02-14 | Max           |
| Prueba      |            1 | 2024-04-18 | Kira          |
| Prueba      |            2 | 2023-11-05 | Duna          |
| Prueba      |            1 | 2023-04-11 | Zeus          |
| Prueba      |            1 | 2023-09-30 | Zeus          |
| Prueba      |            1 | 2023-12-03 | Simba         |
| Prueba      |            1 | 2023-07-03 | Toby          |
| Prueba      |            1 | 2024-01-08 | Lola          |
| Medicamento |            4 | 2023-07-19 | Duna          |
| Medicamento |            5 | 2023-08-25 | Buba          |
+-------------+--------------+------------+---------------+
24 rows in set (0.00 sec)

/*Ej42*/
mysql> SELECT v.nombre AS nombreVeterinario, c.nombre AS nombreClinica FROM veterinario v LEFT JOIN consulta co ON v.num_colegiado = co.num_colegiado 
LEFT JOIN clinica c ON v.cod_clinica = c.cod_clinica WHERE co.id_consulta IS NULL;
+-------------------+----------------+
| nombreVeterinario | nombreClinica  |
+-------------------+----------------+
| Sof├¡a            | VetNord Bilbao |
| Iv├ín             | VetNord Bilbao |
+-------------------+----------------+
2 rows in set (0.00 sec)

/*Ej43*/
mysql> SELECT m.nombre AS nombreMascota, p.nombre AS nombrePropietario, v.nombre AS nombreVeterinario FROM consulta c JOIN mascota m ON c.id_mascota = m.id_mascota JOIN propietario p ON m.id_propietario = p.id_propietario JOIN veterinario v ON c.num_colegiado = v.num_colegiado ORDER BY c.fecha DESC;
+---------------+-------------------+-------------------+
| nombreMascota | nombrePropietario | nombreVeterinario |
+---------------+-------------------+-------------------+
| Toby          | Javier            | Elena             |
| Kira          | Mar├¡a            | Carlos            |
| Luna          | Laura             | Luc├¡a            |
| Simba         | Pablo             | Carlos            |
| Max           | Antonio           | Luc├¡a            |
| Roco          | Laura             | Ana               |
| Buba          | Tom├ís            | Ana               |
| Lola          | Rosa              | Marta             |
| Kira          | Mar├¡a            | Jorge             |
| Simba         | Pablo             | Ra├║l             |
| Cleo          | Carmen            | Ana               |
| Duna          | Antonio           | Pedro             |
| Nala          | Mar├¡a            | Luc├¡a            |
| Nico          | Fernando          | Elena             |
| Zeus          | Isabel            | Ra├║l             |
| Roco          | Laura             | Luc├¡a            |
| Buba          | Tom├ís            | Jorge             |
| Mimi          | Isabel            | Ana               |
| Duna          | Antonio           | Marta             |
| Toby          | Javier            | Ra├║l             |
| Lola          | Rosa              | Elena             |
| Max           | Antonio           | Pedro             |
| Pico          | Fernando          | Elena             |
| Luna          | Laura             | Luc├¡a            |
| Simba         | Pablo             | Carlos            |
| Zeus          | Isabel            | Marta             |
| Kira          | Mar├¡a            | Jorge             |
| Nala          | Mar├¡a            | Luc├¡a            |
| Max           | Antonio           | Carlos            |
| Roco          | Laura             | Ana               |
+---------------+-------------------+-------------------+
30 rows in set (0.00 sec)

/*Ej44*/
mysql> SELECT v.nombre AS nombreVeterinario, m.nombre AS nombreMascota, p.nombre AS nombrePropietario FROM consulta c JOIN veterinario v ON c.num_colegiado = v.num_colegiado 
JOIN mascota m ON c.id_mascota = m.id_mascota JOIN propietario p ON m.id_propietario = p.id_propietario WHERE v.cod_clinica = 'CLN03';
+-------------------+---------------+-------------------+
| nombreVeterinario | nombreMascota | nombrePropietario |
+-------------------+---------------+-------------------+
| Marta             | Zeus          | Isabel            |
| Marta             | Duna          | Antonio           |
| Marta             | Lola          | Rosa              |
| Pedro             | Max           | Antonio           |
| Pedro             | Duna          | Antonio           |
+-------------------+---------------+-------------------+
5 rows in set (0.00 sec)

/*Ej45*/
mysql> SELECT t.nombre AS nombreTratamiento, t.tipo, m.nombre AS nombreMascota, mt.fecha FROM tratamiento t JOIN mascota_tratamiento mt ON t.cod_trat = mt.cod_trat JOIN mascota m ON mt.id_mascota = m.id_mascota WHERE m.especie = 'Perro';
+---------------------------+-------------+---------------+------------+
| nombreTratamiento         | tipo        | nombreMascota | fecha      |
+---------------------------+-------------+---------------+------------+
| Vacuna antirr├íbica       | Vacuna      | Roco          | 2023-01-10 |
| Vacuna antirr├íbica       | Vacuna      | Roco          | 2024-02-12 |
| Desparasitaci├│n interna  | Medicamento | Roco          | 2023-01-10 |
| Desparasitaci├│n externa  | Medicamento | Roco          | 2023-09-14 |
| Desparasitaci├│n externa  | Medicamento | Max           | 2024-02-28 |
| Esterilizaci├│n           | Cirugia     | Max           | 2023-06-08 |
| Radiograf├¡a              | Prueba      | Max           | 2023-02-14 |
| Vacuna polivalente canina | Vacuna      | Kira          | 2023-03-22 |
| Esterilizaci├│n           | Cirugia     | Kira          | 2024-04-18 |
| Radiograf├¡a              | Prueba      | Kira          | 2024-04-18 |
| Vacuna antirr├íbica       | Vacuna      | Zeus          | 2023-04-11 |
| An├ílisis de sangre       | Prueba      | Zeus          | 2023-04-11 |
| An├ílisis de sangre       | Prueba      | Zeus          | 2023-09-30 |
| Limpieza dental           | Cirugia     | Simba         | 2023-04-18 |
| An├ílisis de sangre       | Prueba      | Simba         | 2023-12-03 |
| An├ílisis de sangre       | Prueba      | Toby          | 2023-07-03 |
| Vacuna polivalente canina | Vacuna      | Buba          | 2024-01-25 |
| Cura de herida            | Medicamento | Buba          | 2023-08-25 |
| Radiograf├¡a              | Prueba      | Duna          | 2023-11-05 |
| Quimioterapia sesi├│n     | Medicamento | Duna          | 2023-07-19 |
+---------------------------+-------------+---------------+------------+
20 rows in set (0.00 sec)

/*Ej46*/
mysql> SELECT v.*, c.cod_clinica, co.fecha, co.motivo, co.importe FROM veterinario v LEFT JOIN consulta co ON v.num_colegiado = co.num_colegiado 
LEFT JOIN clinica c ON v.cod_clinica = c.cod_clinica;
+---------------+--------+-------------------+------------------+---------+------------+-------------+-------------+------------+-------------------------+---------+
| num_colegiado | nombre | apellidos         | especialidad     | salario | fecha_alta | cod_clinica | cod_clinica | fecha      | motivo                  | importe |
+---------------+--------+-------------------+------------------+---------+------------+-------------+-------------+------------+-------------------------+---------+
| V0000001      | Ana    | Garc├¡a Ruiz      | Medicina general | 2800.00 | 2018-03-01 | CLN01       | CLN01       | 2023-01-10 | Revisi├│n anual         |   45.00 |
| V0000001      | Ana    | Garc├¡a Ruiz      | Medicina general | 2800.00 | 2018-03-01 | CLN01       | CLN01       | 2023-08-10 | Revisi├│n anual         |   45.00 |
| V0000001      | Ana    | Garc├¡a Ruiz      | Medicina general | 2800.00 | 2018-03-01 | CLN01       | CLN01       | 2023-11-18 | Revisi├│n anual         |   45.00 |
| V0000001      | Ana    | Garc├¡a Ruiz      | Medicina general | 2800.00 | 2018-03-01 | CLN01       | CLN01       | 2024-01-25 | V├│mitos y diarrea      |  220.00 |
| V0000001      | Ana    | Garc├¡a Ruiz      | Medicina general | 2800.00 | 2018-03-01 | CLN01       | CLN01       | 2024-02-12 | Revisi├│n anual         |   45.00 |
| V0000002      | Carlos | Mart├¡nez L├│pez  | Cirug├¡a         | 3500.00 | 2015-06-15 | CLN01       | CLN01       | 2023-02-14 | Cojera pata delantera   |   80.00 |
| V0000002      | Carlos | Mart├¡nez L├│pez  | Cirug├¡a         | 3500.00 | 2015-06-15 | CLN01       | CLN01       | 2023-04-18 | Bulto en piel           |  150.00 |
| V0000002      | Carlos | Mart├¡nez L├│pez  | Cirug├¡a         | 3500.00 | 2015-06-15 | CLN01       | CLN01       | 2024-03-15 | Control postoperatorio  |   60.00 |
| V0000002      | Carlos | Mart├¡nez L├│pez  | Cirug├¡a         | 3500.00 | 2015-06-15 | CLN01       | CLN01       | 2024-04-18 | Fractura radio          |  350.00 |
| V0000003      | Luc├¡a | Fern├índez P├®rez | Dermatolog├¡a    | 3100.00 | 2019-09-10 | CLN02       | CLN02       | 2023-03-05 | P├®rdida de pelo        |   95.00 |
| V0000003      | Luc├¡a | Fern├índez P├®rez | Dermatolog├¡a    | 3100.00 | 2019-09-10 | CLN02       | CLN02       | 2023-05-02 | Revisi├│n anual         |   45.00 |
| V0000003      | Luc├¡a | Fern├índez P├®rez | Dermatolog├¡a    | 3100.00 | 2019-09-10 | CLN02       | CLN02       | 2023-09-14 | P├®rdida de pelo        |   85.00 |
| V0000003      | Luc├¡a | Fern├índez P├®rez | Dermatolog├¡a    | 3100.00 | 2019-09-10 | CLN02       | CLN02       | 2023-10-22 | Infecci├│n ocular       |   70.00 |
| V0000003      | Luc├¡a | Fern├índez P├®rez | Dermatolog├¡a    | 3100.00 | 2019-09-10 | CLN02       | CLN02       | 2024-02-28 | Prurito intenso         |  115.00 |
| V0000003      | Luc├¡a | Fern├índez P├®rez | Dermatolog├¡a    | 3100.00 | 2019-09-10 | CLN02       | CLN02       | 2024-04-02 | Revisi├│n anual         |   45.00 |
| V0000004      | Jorge  | S├ínchez Vidal    | Medicina general | 2700.00 | 2020-01-20 | CLN02       | CLN02       | 2023-03-22 | V├│mitos                |   60.00 |
| V0000004      | Jorge  | S├ínchez Vidal    | Medicina general | 2700.00 | 2020-01-20 | CLN02       | CLN02       | 2023-08-25 | Herida en pata          |   55.00 |
| V0000004      | Jorge  | S├ínchez Vidal    | Medicina general | 2700.00 | 2020-01-20 | CLN02       | CLN02       | 2023-12-20 | Revisi├│n anual         |   45.00 |
| V0000005      | Marta  | G├│mez Torres     | Oncolog├¡a       | 3900.00 | 2016-11-05 | CLN03       | CLN03       | 2023-04-11 | Revisi├│n anual         |   45.00 |
| V0000005      | Marta  | G├│mez Torres     | Oncolog├¡a       | 3900.00 | 2016-11-05 | CLN03       | CLN03       | 2023-07-19 | Masa abdominal          |  250.00 |
| V0000005      | Marta  | G├│mez Torres     | Oncolog├¡a       | 3900.00 | 2016-11-05 | CLN03       | CLN03       | 2024-01-08 | Masa en cuello          |  160.00 |
| V0000006      | Pedro  | L├│pez Castillo   | Traumatolog├¡a   | 3300.00 | 2017-04-22 | CLN03       | CLN03       | 2023-06-08 | Cojera pata trasera     |  200.00 |
| V0000006      | Pedro  | L├│pez Castillo   | Traumatolog├¡a   | 3300.00 | 2017-04-22 | CLN03       | CLN03       | 2023-11-05 | Cojera generalizada     |  130.00 |
| V0000007      | Elena  | D├¡az Moreno      | Medicina general | 2850.00 | 2021-02-14 | CLN04       | CLN04       | 2023-05-20 | Problemas respiratorios |  110.00 |
| V0000007      | Elena  | D├¡az Moreno      | Medicina general | 2850.00 | 2021-02-14 | CLN04       | CLN04       | 2023-06-15 | Revisi├│n rutinaria     |   45.00 |
| V0000007      | Elena  | D├¡az Moreno      | Medicina general | 2850.00 | 2021-02-14 | CLN04       | CLN04       | 2023-10-07 | Revisi├│n anual         |   45.00 |
| V0000007      | Elena  | D├¡az Moreno      | Medicina general | 2850.00 | 2021-02-14 | CLN04       | CLN04       | 2024-05-07 | Revisi├│n anual         |   45.00 |
| V0000008      | Ra├║l  | Jim├®nez Blanco   | Cardiolog├¡a     | 4100.00 | 2014-08-30 | CLN04       | CLN04       | 2023-07-03 | No come                 |  320.00 |
| V0000008      | Ra├║l  | Jim├®nez Blanco   | Cardiolog├¡a     | 4100.00 | 2014-08-30 | CLN04       | CLN04       | 2023-09-30 | Convulsiones            |  180.00 |
| V0000008      | Ra├║l  | Jim├®nez Blanco   | Cardiolog├¡a     | 4100.00 | 2014-08-30 | CLN04       | CLN04       | 2023-12-03 | Dificultad al respirar  |  280.00 |
| V0000009      | Sof├¡a | Navarro Gil       | Cirug├¡a         | 3600.00 | 2018-07-17 | CLN05       | CLN05       | NULL       | NULL                    |    NULL |
| V0000010      | Iv├ín  | Romero Molina     | Dermatolog├¡a    | 3050.00 | 2022-05-03 | CLN05       | CLN05       | NULL       | NULL                    |    NULL |
+---------------+--------+-------------------+------------------+---------+------------+-------------+-------------+------------+-------------------------+---------+
32 rows in set (0.00 sec)