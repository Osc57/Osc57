/*Ejercicios JOBS - Óscar Úbeda*/
/*Ej1*/
mysql> DELETE FROM alum WHERE dni IN (SELECT dni FROM antiguo);
Query OK, 4 rows affected (0.039 sec)

mysql> SELECT * FROM alum;
+-----+--------+------+-----------+
| DNI | NOMBRE | EDAD | LOCALIDAD |
+-----+--------+------+-----------+
| 2A  | PEDRO  |   19 | COSLADA   |
| 4A  | LUISA  |   18 | TORREJ├ôN |
| 7A  | RAQUEL |   19 | TOLEDO    |
+-----+--------+------+-----------+
3 rows in set (0.005 sec)

/*Ej2*/
mysql> INSERT INTO emple (emp_no, apellido, oficio, dir, fecha_alt, salario, comision, dept_no) SELECT 200, 'saavedra', oficio, dir, NOW(), salario * 1.20, comision, dept_no 
FROM (SELECT * FROM emple WHERE apellido = 'sala') AS Sala;
Query OK, 1 row affected, 1 warning (0.036 sec)
Records: 1  Duplicates: 0  Warnings: 1

mysql> SELECT * FROM emple WHERE emp_no = 200 OR apellido = 'sala';
+--------+----------+----------+------+------------+---------+----------+---------+
| EMP_NO | APELLIDO | OFICIO   | DIR  | FECHA_ALT  | SALARIO | COMISION | DEPT_NO |
+--------+----------+----------+------+------------+---------+----------+---------+
|    200 | saavedra | VENDEDOR | 7698 | 2026-03-25 |  195000 |    65000 |      30 |
|   7521 | SALA     | VENDEDOR | 7698 | 1981-02-22 |  162500 |    65000 |      30 |
+--------+----------+----------+------+------------+---------+----------+---------+
2 rows in set (0.008 sec))

/*Ej3*/




