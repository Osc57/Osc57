/*Ejercicios Empresa - Consultas Avanzadas*/
/*Óscar Úbeda*/

-- Ej1
mysql> SELECT UPPER(NomDep) AS NombreDepartamento, PreAnu AS Presupuesto FROM departamento;
+----------------------------+--------------+
| NombreDepartamento         | Presupuesto  |
+----------------------------+--------------+
| ADMINISTRACI├│N ZONA SUR   |  14000000.00 |
| DIRECCI├│N GENERAL         |  26000000.00 |
| INVESTIGACI├│N Y DISE├▒O   |  25000000.00 |
| JEFATURA F├ÍBRICA ZONA SUR |   6200000.00 |
| PRODUCCI├│N ZONA SUR       | 108000000.00 |
| VENTAS ZONA SUR            |  13500000.00 |
+----------------------------+--------------+
6 rows in set (0.204 sec)

-- Ej2
mysql> SELECT LOWER(NomEmp) AS NombreEmpleado, SalEmp AS Salario FROM empleado;
+-----------------------------+------------+
| NombreEmpleado              | Salario    |
+-----------------------------+------------+
| saladino mandam├ís, augusto | 7200000.00 |
| manrique bacterio, luisa    | 4500000.00 |
| monforte cid, rold├ín       | 5200000.00 |
| topaz ill├ín, carlos        | 3200000.00 |
| alada veraz, juana          | 6200000.00 |
| gozque altanero, c├índido   | 5000000.00 |
| forzado l├│pez, galeote     | 1600000.00 |
| mascullas alto, elo├¡sa     | 1600000.00 |
| mando correa, rosa          | 3100000.00 |
| mosc amuerta, mario         | 1300000.00 |
+-----------------------------+------------+
10 rows in set (0.129 sec)

-- Ej3
mysql> SELECT NomEmp, UPPER(SUBSTRING(CodDep, 1, 2)) AS CodigoDep FROM empleado;
+-----------------------------+-----------+
| NomEmp                      | CodigoDep |
+-----------------------------+-----------+
| Saladino Mandam├ís, Augusto | DI        |
| Manrique Bacterio, Luisa    | IN        |
| Monforte Cid, Rold├ín       | VE        |
| Topaz Ill├ín, Carlos        | VE        |
| Alada Veraz, Juana          | AD        |
| Gozque Altanero, C├índido   | JE        |
| Forzado L├│pez, Galeote     | PR        |
| Mascullas Alto, Elo├¡sa     | PR        |
| Mando Correa, Rosa          | PR        |
| Mosc Amuerta, Mario         | PR        |
+-----------------------------+-----------+
10 rows in set (0.008 sec)

-- Ej4
mysql> SELECT CodEmp, CodDep, CONCAT(CodEmp, '-' ,CodDep, '-' ,IFNULL(ExTelEmp, 'XXXXX')) AS Codigo FROM empleado;
+--------+--------+----------------+
| CodEmp | CodDep | Codigo         |
+--------+--------+----------------+
|      1 | DIRGE  | 1-DIRGE-1111   |
|      2 | IN&DI  | 2-IN&DI-2233   |
|      3 | VENZS  | 3-VENZS-2133   |
|      4 | VENZS  | 4-VENZS-3838   |
|      5 | ADMZS  | 5-ADMZS-1239   |
|      6 | JEFZS  | 6-JEFZS-23838  |
|      7 | PROZS  | 7-PROZS-XXXXX  |
|      8 | PROZS  | 8-PROZS-XXXXX  |
|      9 | PROZS  | 9-PROZS-12124  |
|     10 | PROZS  | 10-PROZS-XXXXX |
+--------+--------+----------------+
10 rows in set (0.005 sec)

-- Ej5
mysql> SELECT NomEmp, SUBSTRING(NomEmp, 1, LOCATE(' ', NomEmp) - 1) AS Nombre, SUBSTRING(NomEmp, LOCATE(' ', NomEmp) + 1) AS Apellidos FROM empleado;
+-----------------------------+-----------+--------------------+
| NomEmp                      | Nombre    | Apellidos          |
+-----------------------------+-----------+--------------------+
| Saladino Mandam├ís, Augusto | Saladino  | Mandam├ís, Augusto |
| Manrique Bacterio, Luisa    | Manrique  | Bacterio, Luisa    |
| Monforte Cid, Rold├ín       | Monforte  | Cid, Rold├ín       |
| Topaz Ill├ín, Carlos        | Topaz     | Ill├ín, Carlos     |
| Alada Veraz, Juana          | Alada     | Veraz, Juana       |
| Gozque Altanero, C├índido   | Gozque    | Altanero, C├índido |
| Forzado L├│pez, Galeote     | Forzado   | L├│pez, Galeote    |
| Mascullas Alto, Elo├¡sa     | Mascullas | Alto, Elo├¡sa      |
| Mando Correa, Rosa          | Mando     | Correa, Rosa       |
| Mosc Amuerta, Mario         | Mosc      | Amuerta, Mario     |
+-----------------------------+-----------+--------------------+
10 rows in set (0.019 sec)

-- Ej6
mysql> SELECT NomEmp, SalEmp, ROUND(SalEmp * 1.12, 2) AS Salario FROM empleado;
+-----------------------------+------------+------------+
| NomEmp                      | SalEmp     | Salario    |
+-----------------------------+------------+------------+
| Saladino Mandam├ís, Augusto | 7200000.00 | 8064000.00 |
| Manrique Bacterio, Luisa    | 4500000.00 | 5040000.00 |
| Monforte Cid, Rold├ín       | 5200000.00 | 5824000.00 |
| Topaz Ill├ín, Carlos        | 3200000.00 | 3584000.00 |
| Alada Veraz, Juana          | 6200000.00 | 6944000.00 |
| Gozque Altanero, C├índido   | 5000000.00 | 5600000.00 |
| Forzado L├│pez, Galeote     | 1600000.00 | 1792000.00 |
| Mascullas Alto, Elo├¡sa     | 1600000.00 | 1792000.00 |
| Mando Correa, Rosa          | 3100000.00 | 3472000.00 |
| Mosc Amuerta, Mario         | 1300000.00 | 1456000.00 |
+-----------------------------+------------+------------+
10 rows in set (0.021 sec)

-- Ej7
mysql> SELECT NomEmp, SalEmp, TRUNCATE(SalEmp * 1.12, 1) AS Salario FROM empleado;
+-----------------------------+------------+-----------+
| NomEmp                      | SalEmp     | Salario   |
+-----------------------------+------------+-----------+
| Saladino Mandam├ís, Augusto | 7200000.00 | 8064000.0 |
| Manrique Bacterio, Luisa    | 4500000.00 | 5040000.0 |
| Monforte Cid, Rold├ín       | 5200000.00 | 5824000.0 |
| Topaz Ill├ín, Carlos        | 3200000.00 | 3584000.0 |
| Alada Veraz, Juana          | 6200000.00 | 6944000.0 |
| Gozque Altanero, C├índido   | 5000000.00 | 5600000.0 |
| Forzado L├│pez, Galeote     | 1600000.00 | 1792000.0 |
| Mascullas Alto, Elo├¡sa     | 1600000.00 | 1792000.0 |
| Mando Correa, Rosa          | 3100000.00 | 3472000.0 |
| Mosc Amuerta, Mario         | 1300000.00 | 1456000.0 |
+-----------------------------+------------+-----------+
10 rows in set (0.006 sec)

-- Ej8

-- Ej9
mysql> SELECT NomEmp, EXTRACT(DAY FROM FecNaEmp) AS Dia, EXTRACT(MONTH FROM FecNaEmp) AS Mes, EXTRACT(YEAR FROM FecNaEmp) AS Año FROM empleado;
+-----------------------------+------+------+------+
| NomEmp                      | Dia  | Mes  | Año  |
+-----------------------------+------+------+------+
| Saladino Mandam├ís, Augusto |    7 |    8 | 1961 |
| Manrique Bacterio, Luisa    |    8 |    6 | 1970 |
| Monforte Cid, Rold├ín       |    7 |   12 | 1965 |
| Topaz Ill├ín, Carlos        |   21 |    2 | 1975 |
| Alada Veraz, Juana          |    8 |    3 | 1958 |
| Gozque Altanero, C├índido   |    3 |    6 | 1969 |
| Forzado L├│pez, Galeote     |    7 |    8 | 1975 |
| Mascullas Alto, Elo├¡sa     |   15 |    6 | 1976 |
| Mando Correa, Rosa          |   19 |    7 | 1968 |
| Mosc Amuerta, Mario         |    7 |    1 | 1975 |
+-----------------------------+------+------+------+
10 rows in set (0.006 sec)

-- Ej10
mysql> SELECT NomEmp, FecNaEmp, TIMESTAMPDIFF(YEAR, FecNaEmp, CURDATE()) AS Edad FROM empleado;
+-----------------------------+------------+------+
| NomEmp                      | FecNaEmp   | Edad |
+-----------------------------+------------+------+
| Saladino Mandam├ís, Augusto | 1961-08-07 |   64 |
| Manrique Bacterio, Luisa    | 1970-06-08 |   55 |
| Monforte Cid, Rold├ín       | 1965-12-07 |   60 |
| Topaz Ill├ín, Carlos        | 1975-02-21 |   51 |
| Alada Veraz, Juana          | 1958-03-08 |   68 |
| Gozque Altanero, C├índido   | 1969-06-03 |   56 |
| Forzado L├│pez, Galeote     | 1975-08-07 |   50 |
| Mascullas Alto, Elo├¡sa     | 1976-06-15 |   49 |
| Mando Correa, Rosa          | 1968-07-19 |   57 |
| Mosc Amuerta, Mario         | 1975-01-07 |   51 |
+-----------------------------+------------+------+
10 rows in set (0.017 sec)

-- Ej11
mysql> SELECT NomEmp, FecInEmp, FLOOR(TIMESTAMPDIFF(YEAR, FecInEmp, CURDATE()) / 4) AS Vacaciones FROM empleado;
+-----------------------------+------------+------------+
| NomEmp                      | FecInEmp   | Vacaciones |
+-----------------------------+------------+------------+
| Saladino Mandam├ís, Augusto | 1972-07-01 |         13 |
| Manrique Bacterio, Luisa    | 1991-06-14 |          8 |
| Monforte Cid, Rold├ín       | 1984-06-08 |         10 |
| Topaz Ill├ín, Carlos        | 1990-08-09 |          8 |
| Alada Veraz, Juana          | 1976-08-07 |         12 |
| Gozque Altanero, C├índido   | 1991-08-01 |          8 |
| Forzado L├│pez, Galeote     | 1994-06-30 |          7 |
| Mascullas Alto, Elo├¡sa     | 1994-08-15 |          7 |
| Mando Correa, Rosa          | 1982-06-10 |         10 |
| Mosc Amuerta, Mario         | 1993-11-02 |          8 |
+-----------------------------+------------+------------+
10 rows in set (0.006 sec)

-- Ej12


-- EJERCICIOS DE AGRUPACIÓN
-- Ej1
mysql> SELECT COUNT(*) AS EmpeladosConHijos FROM hijo WHERE NumHij = 2;
+-------------------+
| EmpeladosConHijos |
+-------------------+
|                 1 |
+-------------------+
1 row in set (0.176 sec)

-- Ej2
mysql> SELECT COUNT(*) AS SinExtension FROM empleado WHERE ExTelEmp IS NULL;
+--------------+
| SinExtension |
+--------------+
|            3 |
+--------------+
1 row in set (0.005 sec)

-- Ej3
mysql> SELECT AVG(TIMESTAMPDIFF(YEAR, FecNaEmp, CURDATE())) AS EdadMedia FROM empleado;
+-----------+
| EdadMedia |
+-----------+
|   56.1000 |
+-----------+
1 row in set (0.007 sec)

-- Ej4
