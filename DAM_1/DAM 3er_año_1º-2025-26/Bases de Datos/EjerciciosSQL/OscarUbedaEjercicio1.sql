/*Ejercicio 1 - Óscar Úbeda*/
/*1. Crea un script sql de nombre tunombreEjercicio1.sql. Allí vas a ir poniendo todas las sentencias SQL.
Incluye dentro del archivo tu nombre y comentarios*/

/*2. Crea la base de datos TERFRUTOS*/
CREATE DATABASE TERFRUTOS;

/*3. Posiciónate en ella.*/
USE TERFRUTOS;

/*4. Crea una tabla que se llame TIENDAS con los siguientes campos:
◦ NUMERO_TIENDA Número de dos cifras.
◦ DIRECCION, Texto 100.
◦ CP_TIENDA, Texto 5.
◦ TELEFONO, Texto 9.*/
CREATE TABLE TIENDAS(
	NUMERO_TIENDA NUMERIC(2),
	DIRECCION VARCHAR(100),
	CP_TIENDA CHAR(5),
	TELEFONO CHAR(9)
	);

/*5. Indica la clave primaria*/
ALTER TABLE TIENDAS ADD PRIMARY KEY (NUMERO_TIENDA);

/*6. Crea otra tabla que llamaremos VENDEDORES con los siguientes campos:
◦ NIF, Texto 12.
◦ NOMBRE, Texto 90.
◦ DOMICILIO, Texto 100.
◦ CP_VENDEDOR, Texto 5.
◦ CIUDAD, Texto 20.
◦ TELEFONO, Texto 9.
◦ FECHA_NACIMIENTO, Fecha.
◦ ESTADO_CIVIL, Texto 20.
◦ NUMERO_HIJOS, Numérico.
◦ NUMERO_TIENDA, Numérico*/
CREATE TABLE VENDEDORES(
	NIF CHAR(12),
	DOMICILIO VARCHAR(100),
	CP_VENDEDOR CHAR(5),
	CIUDAD VARCHAR(20),
	TELEFONO CHAR(9),
	FECHA_NACIMIENTO DATE,
	ESTADO_CIVIL VARCHAR(20),
	NUMEROS_HIJOS NUMERIC(10,2),
	NUMERO_TIENDA NUMERIC(2)
	);

/*7. Indica la clave primaria y la clave ajena. Si se borra una tienda el vendedor pasará estar sin tienda*/
ALTER TABLE VENDEDORES ADD PRIMARY KEY (NIF);
ALTER TABLE VENDEDORES ADD CONSTRAINT FK_Vendedores_Tiendas FOREIGN KEY (NUMERO_TIENDA) REFERENCES TIENDAS (NUMERO_TIENDA) ON DELETE CASCADE;

/*8. Inserta un nuevo campo con nombre MINUSVALIA, que sea de tipo texto, con valores S o N*/
ALTER TABLE VENDEDORES ADD COLUMN MINUSVALIA CHAR(1) DEFAULT 'N';
ALTER TABLE VENDEDORES ADD CONSTRAINT Chk_Minusvalia CHECK (MINUSVALIA IN ('S', 'N'));

/*9. Añade un nuevo campo SUELDO en la tabla vendedores.*/
ALTER TABLE VENDEDORES ADD COLUMN SUELDO DOUBLE;

/*10. Modifica el ESTADO_CIVIL de la tabla vendedores para que ahora sea un campo de texto de 1
carácter de longitud*/
ALTER TABLE VENDEDORES MODIFY COLUMN ESTADO_CIVIL CHAR(1);

/*11. Ejecuta el script y haz una captura de pantalla del resultado*/
mysql> source C:\Users\dam1\Desktop\OscarUbedaEjercicio1.sql
Query OK, 1 row affected (0.393 sec)

Query OK, 0 rows affected (0.399 sec)

Query OK, 0 rows affected (0.630 sec)

Query OK, 0 rows affected (0.855 sec)
Records: 0  Duplicates: 0  Warnings: 0

Query OK, 0 rows affected (0.969 sec)

Query OK, 0 rows affected (1.126 sec)
Records: 0  Duplicates: 0  Warnings: 0

Query OK, 0 rows affected (1.473 sec)
Records: 0  Duplicates: 0  Warnings: 0

Query OK, 0 rows affected (1.965 sec)
Records: 0  Duplicates: 0  Warnings: 0

Query OK, 0 rows affected (2.313 sec)
Records: 0  Duplicates: 0  Warnings: 0

Query OK, 0 rows affected (2.568 sec)
Records: 0  Duplicates: 0  Warnings: 0

Query OK, 0 rows affected (3.084 sec)
Records: 0  Duplicates: 0  Warnings: 0

Query OK, 0 rows affected (3.085 sec)

mysql>


