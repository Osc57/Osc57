/*Base De Datos Empresa Ejercicios Mezclados UD7 UD8 UD8 UD9 - Óscar Úbeda*/
/*Ej1*/
mysql> SELECT CodEmpDir FROM centro UNION SELECT CodEmpDir FROM centro;
+-----------+
| CodEmpDir |
+-----------+
|         1 |
|         5 |
|         6 |
+-----------+
3 rows in set (0.008 sec)

/*Ej2*/
mysql> SELECT CodEmpDir FROM centro UNION ALL SELECT CodEmpDir FROM centro;
+-----------+
| CodEmpDir |
+-----------+
|         1 |
|         5 |
|         6 |
|         1 |
|         5 |
|         6 |
+-----------+
6 rows in set (0.009 sec)

/*Ej3*/
mysql> SELECT CodDep, NomDep FROM departamento WHERE PreAnu > 20000000 UNION SELECT CodDep, NomDep FROM departamento WHERE TiDir = 'F';
+--------+----------------------------+
| CodDep | NomDep                     |
+--------+----------------------------+
| DIRGE  | Direcci├│n General         |
| IN&DI  | Investigaci├│n y Dise├▒o   |
| PROZS  | Producci├│n Zona Sur       |
| JEFZS  | Jefatura F├íbrica Zona Sur |
| VENZS  | Ventas Zona Sur            |
+--------+----------------------------+
5 rows in set (0.114 sec)

/*Ej4*/








