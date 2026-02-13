-- Ejercicio de Empresa
-- Óscar Úbeda

-- CONSULTAS SIMPLES
--Ej1
mysql> SELECT NomDep FROM departamento;
+----------------------------+
| NomDep                     |
+----------------------------+
| Administraci├│n Zona Sur   |
| Direcci├│n General         |
| Investigaci├│n y Dise├▒o   |
| Jefatura F├íbrica Zona Sur |
| Producci├│n Zona Sur       |
| Ventas Zona Sur            |
+----------------------------+
6 rows in set (0.008 sec)

-- Ej2
mysql> SELECT Nomdep, PreAnu FROM departamento;
+----------------------------+--------------+
| Nomdep                     | PreAnu       |
+----------------------------+--------------+
| Administraci├│n Zona Sur   |  14000000.00 |
| Direcci├│n General         |  26000000.00 |
| Investigaci├│n y Dise├▒o   |  25000000.00 |
| Jefatura F├íbrica Zona Sur |   6200000.00 |
| Producci├│n Zona Sur       | 108000000.00 |
| Ventas Zona Sur            |  13500000.00 |
+----------------------------+--------------+
6 rows in set (0.007 sec)

-- Ej3
mysql> SELECT * FROM departamento;
+--------+-----------+-----------+--------+----------------------------+--------------+-------+
| CodDep | CodEmpDir | CodDepDep | CodCen | NomDep                     | PreAnu       | TiDir |
+--------+-----------+-----------+--------+----------------------------+--------------+-------+
| ADMZS  |         5 | NULL      | OFZS   | Administraci├│n Zona Sur   |  14000000.00 | P     |
| DIRGE  |         1 | NULL      | DIGE   | Direcci├│n General         |  26000000.00 | P     |
| IN&DI  |         2 | DIRGE     | DIGE   | Investigaci├│n y Dise├▒o   |  25000000.00 | P     |
| JEFZS  |         6 | NULL      | FAZS   | Jefatura F├íbrica Zona Sur |   6200000.00 | F     |
| PROZS  |         9 | JEFZS     | FAZS   | Producci├│n Zona Sur       | 108000000.00 | P     |
| VENZS  |         3 | ADMZS     | OFZS   | Ventas Zona Sur            |  13500000.00 | F     |
+--------+-----------+-----------+--------+----------------------------+--------------+-------+
6 rows in set (0.006 sec)

-- Ej4
mysql> SELECT NomEmp, SalEmp FROM empleado;
+-----------------------------+------------+
| NomEmp                      | SalEmp     |
+-----------------------------+------------+
| Saladino Mandam├ís, Augusto | 7200000.00 |
| Manrique Bacterio, Luisa    | 4500000.00 |
| Monforte Cid, Rold├ín       | 5200000.00 |
| Topaz Ill├ín, Carlos        | 3200000.00 |
| Alada Veraz, Juana          | 6200000.00 |
| Gozque Altanero, C├índido   | 5000000.00 |
| Forzado L├│pez, Galeote     | 1600000.00 |
| Mascullas Alto, Elo├¡sa     | 1600000.00 |
| Mando Correa, Rosa          | 3100000.00 |
| Mosc Amuerta, Mario         | 1300000.00 |
+-----------------------------+------------+
10 rows in set (0.007 sec)

-- Ej5
mysql> SELECT DISTINCT NumHi FROM empleado;
+-------+
| NumHi |
+-------+
|     1 |
|     0 |
|     2 |
+-------+
3 rows in set (0.008 sec)


-- Ej6
mysql> SELECT NomEmp, SalEmp * NumHi * 4 / 100 AS ComplementoFamiliar FROM empleado;
+-----------------------------+---------------------+
| NomEmp                      | ComplementoFamiliar |
+-----------------------------+---------------------+
| Saladino Mandam├ís, Augusto |       288000.000000 |
| Manrique Bacterio, Luisa    |            0.000000 |
| Monforte Cid, Rold├ín       |       208000.000000 |
| Topaz Ill├ín, Carlos        |            0.000000 |
| Alada Veraz, Juana          |       248000.000000 |
| Gozque Altanero, C├índido   |       200000.000000 |
| Forzado L├│pez, Galeote     |            0.000000 |
| Mascullas Alto, Elo├¡sa     |        64000.000000 |
| Mando Correa, Rosa          |       248000.000000 |
| Mosc Amuerta, Mario         |            0.000000 |
+-----------------------------+---------------------+
10 rows in set (0.005 sec)

-- Ej7
mysql> SELECT NomDep, PreAnu AS Euros, PreAnu * 1.10 AS Dolares FROM departamento;
+----------------------------+--------------+----------------+
| NomDep                     | Euros        | Dolares        |
+----------------------------+--------------+----------------+
| Administraci├│n Zona Sur   |  14000000.00 |  15400000.0000 |
| Direcci├│n General         |  26000000.00 |  28600000.0000 |
| Investigaci├│n y Dise├▒o   |  25000000.00 |  27500000.0000 |
| Jefatura F├íbrica Zona Sur |   6200000.00 |   6820000.0000 |
| Producci├│n Zona Sur       | 108000000.00 | 118800000.0000 |
| Ventas Zona Sur            |  13500000.00 |  14850000.0000 |
+----------------------------+--------------+----------------+
6 rows in set (0.007 sec)

-- Ej8
mysql> SELECT NomDep AS NombreDeDepartamento, PreAnu AS Euros, PreAnu * 1.10 AS Dolares FROM departamento;
+----------------------------+--------------+----------------+
| NombreDeDepartamento       | Euros        | Dolares        |
+----------------------------+--------------+----------------+
| Administraci├│n Zona Sur   |  14000000.00 |  15400000.0000 |
| Direcci├│n General         |  26000000.00 |  28600000.0000 |
| Investigaci├│n y Dise├▒o   |  25000000.00 |  27500000.0000 |
| Jefatura F├íbrica Zona Sur |   6200000.00 |   6820000.0000 |
| Producci├│n Zona Sur       | 108000000.00 | 118800000.0000 |
| Ventas Zona Sur            |  13500000.00 |  14850000.0000 |
+----------------------------+--------------+----------------+
6 rows in set (0.005 sec)

-- Ej9
mysql> SELECT NomEmp, SalEmp FROM empleado WHERE SalEmp > 3000000;
+-----------------------------+------------+
| NomEmp                      | SalEmp     |
+-----------------------------+------------+
| Saladino Mandam├ís, Augusto | 7200000.00 |
| Manrique Bacterio, Luisa    | 4500000.00 |
| Monforte Cid, Rold├ín       | 5200000.00 |
| Topaz Ill├ín, Carlos        | 3200000.00 |
| Alada Veraz, Juana          | 6200000.00 |
| Gozque Altanero, C├índido   | 5000000.00 |
| Mando Correa, Rosa          | 3100000.00 |
+-----------------------------+------------+
7 rows in set (0.019 sec)

-- Ej10
mysql> SELECT NomEmp, SalEmp, NumHi FROM empleado WHERE NumHi > 0 AND SalEmp > 4000000;
+-----------------------------+------------+-------+
| NomEmp                      | SalEmp     | NumHi |
+-----------------------------+------------+-------+
| Saladino Mandam├ís, Augusto | 7200000.00 |     1 |
| Monforte Cid, Rold├ín       | 5200000.00 |     1 |
| Alada Veraz, Juana          | 6200000.00 |     1 |
| Gozque Altanero, C├índido   | 5000000.00 |     1 |
+-----------------------------+------------+-------+
4 rows in set (0.006 sec)

-- Ej11
mysql> SELECT NomDep, PreAnu FROM departamento WHERE PreAnu BETWEEN 10000000 AND 20000000;
+--------------------------+-------------+
| NomDep                   | PreAnu      |
+--------------------------+-------------+
| Administraci├│n Zona Sur | 14000000.00 |
| Ventas Zona Sur          | 13500000.00 |
+--------------------------+-------------+
2 rows in set (0.008 sec)

mysql> SELECT NomDep, PreAnu FROM departamento WHERE PreAnu >= 10000000 AND PreAnu <= 20000000;
+--------------------------+-------------+
| NomDep                   | PreAnu      |
+--------------------------+-------------+
| Administraci├│n Zona Sur | 14000000.00 |
| Ventas Zona Sur          | 13500000.00 |
+--------------------------+-------------+
2 rows in set (0.008 sec)

-- Ej12
mysql> SELECT * FROM empleado WHERE CodDep = 'PROZS' OR CodDep = 'VENZS';
+--------+--------+----------+------------+------------+-----------+-------------------------+-------+------------+
| CodEmp | CodDep | ExTelEmp | FecInEmp   | FecNaEmp   | NifEmp    | NomEmp                  | NumHi | SalEmp     |
+--------+--------+----------+------------+------------+-----------+-------------------------+-------+------------+
|      7 | PROZS  | NULL     | 1994-06-30 | 1975-08-07 | 47123132D | Forzado L├│pez, Galeote |     0 | 1600000.00 |
|      8 | PROZS  | NULL     | 1994-08-15 | 1976-06-15 | 32132154H | Mascullas Alto, Elo├¡sa |     1 | 1600000.00 |
|      9 | PROZS  | 12124    | 1982-06-10 | 1968-07-19 | 11312121D | Mando Correa, Rosa      |     2 | 3100000.00 |
|     10 | PROZS  | NULL     | 1993-11-02 | 1975-01-07 | 32939393D | Mosc Amuerta, Mario     |     0 | 1300000.00 |
|      3 | VENZS  | 2133     | 1984-06-08 | 1965-12-07 | 23823930D | Monforte Cid, Rold├ín   |     1 | 5200000.00 |
|      4 | VENZS  | 3838     | 1990-08-09 | 1975-02-21 | 38293923L | Topaz Ill├ín, Carlos    |     0 | 3200000.00 |
+--------+--------+----------+------------+------------+-----------+-------------------------+-------+------------+
6 rows in set (0.007 sec)

mysql> SELECT * FROM empleado WHERE CodDep IN ('PROZS', 'VENZS');
+--------+--------+----------+------------+------------+-----------+-------------------------+-------+------------+
| CodEmp | CodDep | ExTelEmp | FecInEmp   | FecNaEmp   | NifEmp    | NomEmp                  | NumHi | SalEmp     |
+--------+--------+----------+------------+------------+-----------+-------------------------+-------+------------+
|      7 | PROZS  | NULL     | 1994-06-30 | 1975-08-07 | 47123132D | Forzado L├│pez, Galeote |     0 | 1600000.00 |
|      8 | PROZS  | NULL     | 1994-08-15 | 1976-06-15 | 32132154H | Mascullas Alto, Elo├¡sa |     1 | 1600000.00 |
|      9 | PROZS  | 12124    | 1982-06-10 | 1968-07-19 | 11312121D | Mando Correa, Rosa      |     2 | 3100000.00 |
|     10 | PROZS  | NULL     | 1993-11-02 | 1975-01-07 | 32939393D | Mosc Amuerta, Mario     |     0 | 1300000.00 |
|      3 | VENZS  | 2133     | 1984-06-08 | 1965-12-07 | 23823930D | Monforte Cid, Rold├ín   |     1 | 5200000.00 |
|      4 | VENZS  | 3838     | 1990-08-09 | 1975-02-21 | 38293923L | Topaz Ill├ín, Carlos    |     0 | 3200000.00 |
+--------+--------+----------+------------+------------+-----------+-------------------------+-------+------------+
6 rows in set (0.008 sec)

-- Ej13
mysql> SELECT * FROM departamento WHERE TiDir = 'F' OR PreAnu > 20000000;
+--------+-----------+-----------+--------+----------------------------+--------------+-------+
| CodDep | CodEmpDir | CodDepDep | CodCen | NomDep                     | PreAnu       | TiDir |
+--------+-----------+-----------+--------+----------------------------+--------------+-------+
| DIRGE  |         1 | NULL      | DIGE   | Direcci├│n General         |  26000000.00 | P     |
| IN&DI  |         2 | DIRGE     | DIGE   | Investigaci├│n y Dise├▒o   |  25000000.00 | P     |
| JEFZS  |         6 | NULL      | FAZS   | Jefatura F├íbrica Zona Sur |   6200000.00 | F     |
| PROZS  |         9 | JEFZS     | FAZS   | Producci├│n Zona Sur       | 108000000.00 | P     |
| VENZS  |         3 | ADMZS     | OFZS   | Ventas Zona Sur            |  13500000.00 | F     |
+--------+-----------+-----------+--------+----------------------------+--------------+-------+
5 rows in set (0.021 sec)

-- Ej14
mysql> SELECT * FROM empleado WHERE YEAR(FecNaEmp) < 1970 OR YEAR(FecNaEmp) > 1975;
+--------+--------+----------+------------+------------+-----------+-----------------------------+-------+------------+
| CodEmp | CodDep | ExTelEmp | FecInEmp   | FecNaEmp   | NifEmp    | NomEmp                      | NumHi | SalEmp     |
+--------+--------+----------+------------+------------+-----------+-----------------------------+-------+------------+
|      1 | DIRGE  | 1111     | 1972-07-01 | 1961-08-07 | 21451451V | Saladino Mandam├ís, Augusto |     1 | 7200000.00 |
|      3 | VENZS  | 2133     | 1984-06-08 | 1965-12-07 | 23823930D | Monforte Cid, Rold├ín       |     1 | 5200000.00 |
|      5 | ADMZS  | 1239     | 1976-08-07 | 1958-03-08 | 38223923T | Alada Veraz, Juana          |     1 | 6200000.00 |
|      6 | JEFZS  | 23838    | 1991-08-01 | 1969-06-03 | 26454122D | Gozque Altanero, C├índido   |     1 | 5000000.00 |
|      8 | PROZS  | NULL     | 1994-08-15 | 1976-06-15 | 32132154H | Mascullas Alto, Elo├¡sa     |     1 | 1600000.00 |
|      9 | PROZS  | 12124    | 1982-06-10 | 1968-07-19 | 11312121D | Mando Correa, Rosa          |     2 | 3100000.00 |
+--------+--------+----------+------------+------------+-----------+-----------------------------+-------+------------+
6 rows in set (0.010 sec)

-- Ej15
mysql> SELECT * FROM empleado WHERE CodEmp IN (SELECT CodEmp FROM empleado WHERE CodDep = 'PROZS' AND SalEmp > 2000000) OR CodEmp IN (SELECT CodEmp FROM empleado WHERE CodDep = 'VENZS' AND NumHi > 1);
+--------+--------+----------+------------+------------+-----------+--------------------+-------+------------+
| CodEmp | CodDep | ExTelEmp | FecInEmp   | FecNaEmp   | NifEmp    | NomEmp             | NumHi | SalEmp     |
+--------+--------+----------+------------+------------+-----------+--------------------+-------+------------+
|      9 | PROZS  | 12124    | 1982-06-10 | 1968-07-19 | 11312121D | Mando Correa, Rosa |     2 | 3100000.00 |
+--------+--------+----------+------------+------------+-----------+--------------------+-------+------------+
1 row in set (0.012 sec)

-- Ej16
mysql> SELECT * FROM departamento WHERE (CodCen = 'FAZS' AND PreAnu > 10000000) OR (CodCen = 'OFZS' AND TiDir = 'P');
+--------+-----------+-----------+--------+--------------------------+--------------+-------+
| CodDep | CodEmpDir | CodDepDep | CodCen | NomDep                   | PreAnu       | TiDir |
+--------+-----------+-----------+--------+--------------------------+--------------+-------+
| PROZS  |         9 | JEFZS     | FAZS   | Producci├│n Zona Sur     | 108000000.00 | P     |
| ADMZS  |         5 | NULL      | OFZS   | Administraci├│n Zona Sur |  14000000.00 | P     |
+--------+-----------+-----------+--------+--------------------------+--------------+-------+
2 rows in set (0.009 sec)

-- Ej17
mysql> SELECT NomDep, PreAnu FROM departamento WHERE PreAnu NOT IN (SELECT PreAnu FROM departamento WHERE PreAnu BETWEEN 10000000 AND 20000000);
+----------------------------+--------------+
| NomDep                     | PreAnu       |
+----------------------------+--------------+
| Direcci├│n General         |  26000000.00 |
| Investigaci├│n y Dise├▒o   |  25000000.00 |
| Jefatura F├íbrica Zona Sur |   6200000.00 |
| Producci├│n Zona Sur       | 108000000.00 |
+----------------------------+--------------+
4 rows in set (0.012 sec)

-- Ej18
mysql> SELECT NomDep FROM departamento WHERE NomDep LIKE '%Zona%';
+----------------------------+
| NomDep                     |
+----------------------------+
| Administraci├│n Zona Sur   |
| Jefatura F├íbrica Zona Sur |
| Producci├│n Zona Sur       |
| Ventas Zona Sur            |
+----------------------------+
4 rows in set (0.006 sec)

-- Ej19
mysql> SELECT NomEmp, SalEmp FROM empleado WHERE (NomEmp LIKE 'M%' OR NomEmp LIKE 'F%') AND SalEmp > 3000000;
+--------------------------+------------+
| NomEmp                   | SalEmp     |
+--------------------------+------------+
| Manrique Bacterio, Luisa | 4500000.00 |
| Monforte Cid, Rold├ín    | 5200000.00 |
| Mando Correa, Rosa       | 3100000.00 |
+--------------------------+------------+
3 rows in set (0.008 sec)

-- Ej20
mysql> SELECT * FROM empleado WHERE FecNaEmp BETWEEN '1970-01-01' AND '1979-12-31' AND CodDep NOT IN ('PROZS') AND (NomEmp LIKE '%ar%' OR NomEmp LIKE '%o') AND SalEmp > 3000000;
+--------+--------+----------+------------+------------+-----------+----------------------+-------+------------+
| CodEmp | CodDep | ExTelEmp | FecInEmp   | FecNaEmp   | NifEmp    | NomEmp               | NumHi | SalEmp     |
+--------+--------+----------+------------+------------+-----------+----------------------+-------+------------+
|      4 | VENZS  | 3838     | 1990-08-09 | 1975-02-21 | 38293923L | Topaz Ill├ín, Carlos |     0 | 3200000.00 |
+--------+--------+----------+------------+------------+-----------+----------------------+-------+------------+
1 row in set (0.008 sec)

-- SUBCONSULTAS
