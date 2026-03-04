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
