/*Creacion de Usuarios Óscar Úbeda*/

/*Ej1*/
mysql> CREATE USER 'alumno'@'%' IDENTIFIED BY '1234';
Query OK, 0 rows affected (0.03 sec)

mysql> GRANT ALL PRIVILEGES ON investigadores.* TO 'alumno'@'%';
Query OK, 0 rows affected (0.01 sec)

/*Ej2*/
mysql> CREATE USER 'usuariosinpass'@'localhost' IDENTIFIED BY '';
Query OK, 0 rows affected (0.01 sec)

mysql> GRANT ALL PRIVILEGES ON nba.* TO 'usuariosinpass'@'localhost';
Query OK, 0 rows affected (0.01 sec)

/*Ej3*/
mysql> CREATE USER 'userdeterm'@'%' IDENTIFIED BY '1234';
Query OK, 0 rows affected (0.01 sec)

mysql> GRANT SELECT, INSERT, UPDATE ON *.* TO 'userdeterm'@'%';
Query OK, 0 rows affected (0.01 sec)

/*Ej4*/
mysql> DROP USER 'userdeterm'@'%';
Query OK, 0 rows affected (0.01 sec)

/*Ej5*/
mysql> CREATE USER 'admin'@'%' IDENTIFIED BY '1234';
Query OK, 0 rows affected (0.01 sec)

mysql> CREATE USER 'operador1'@'%' IDENTIFIED BY '1234';
Query OK, 0 rows affected (0.02 sec)

mysql> CREATE USER 'operador2'@'%' IDENTIFIED BY '1234';
Query OK, 0 rows affected (0.02 sec)

/****************************************************************/
mysql> CREATE ROLE 'rolAdmin';
Query OK, 0 rows affected (0.01 sec)

mysql> CREATE ROLE 'rolOperador1';
Query OK, 0 rows affected (0.01 sec)

mysql> CREATE ROLE 'rolOperador2';
Query OK, 0 rows affected (0.01 sec)

mysql> GRANT 'rolAdmin' TO 'admin'@'%';
Query OK, 0 rows affected (0.01 sec)

mysql> GRANT 'rolOperador1' TO 'operador1'@'%';
Query OK, 0 rows affected (0.01 sec)

mysql> GRANT 'rolOperador2' TO 'operador2'@'%';
Query OK, 0 rows affected (0.01 sec)

/****************************************************************/
mysql> GRANT ALL PRIVILEGES ON ventas.* TO 'rolAdmin';
Query OK, 0 rows affected (0.01 sec)

mysql> GRANT SELECT, INSERT ON ventas.* TO 'rolOperador1';
Query OK, 0 rows affected (0.01 sec)

mysql> GRANT SELECT ON ventas.clientes TO 'rolOperador1';
Query OK, 0 rows affected (0.01 sec)

mysql> REVOKE INSERT ON ventas.clientes FROM 'rolOperador1';
ERROR 1147 (42000): There is no such grant defined for user 'rolOperador1' on host '%' on table 'clientes'
mysql> REVOKE INSERT ON ventas.clientes FROM 'rolOperador1';

ERROR 1147 (42000): There is no such grant defined for user 'rolOperador1' on host '%' on table 'clientes'
mysql> REVOKE ALTER, DROP, CREATE ON ventas.* FROM 'rolOperador1';

ERROR 1141 (42000): There is no such grant defined for user 'rolOperador1' on host '%'

mysql> GRANT SELECT ON ventas.* TO 'rolOperador2';
Query OK, 0 rows affected (0.01 sec)

mysql> GRANT UPDATE ON ventas.empleados TO 'rolOperador2';
Query OK, 0 rows affected (0.01 sec)

mysql> GRANT UPDATE ON ventas.productos TO 'rolOperador2';
Query OK, 0 rows affected (0.01 sec)

mysql> REVOKE UPDATE (cod_empleado,telefono) ON ventas.empleados FROM 'rolOperador2';
ERROR 1147 (42000): There is no such grant defined for user 'rolOperador2' on host '%' on table 'empleados'

mysql> REVOKE UPDATE (cod_empleado, telefono) ON ventas.productos FROM 'rolOperador2';
ERROR 1147 (42000): There is no such grant defined for user 'rolOperador2' on host '%' on table 'productos'





