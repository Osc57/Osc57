/*Ejercicio 2 - Óscar Úbeda*/
/*1. Crea un script de nombre tunombrerestricciones.sql*/
/*2. Crea una base de datos de nombre restricciones y posiciónate en ella*/
CREATE DATABASE IF NOT EXISTS restricciones;
USE restricciones;

/*3. Crea la tabla PROVINCIAS con los siguientes campos:
◦ Cod_provi de tipo numeric(2) y es la clave primaria
◦ Nombre de tipo varchar(25), es obligatorio
◦ Pais de tipo varchar(25) debe ser uno de los siguientes España, Portugal o Italia.*/
CREATE TABLE PROVINCIAS (
	Cod_provi NUMERIC(2) PRIMARY KEY,
	Nombre VARCHAR(25) NOT NULL,
	Pais VARCHAR(25),
	CONSTRAINT ck_pais_valido CHECK (Pais IN ('España', 'Portugal', 'Italia'))
	);
	
/*4. Introduce la provincia 1 Ávila de España*/
INSERT INTO PROVINCIAS (Cod_provi, Nombre, Pais) VALUES (01, 'Ávila', 'España');

/*5. Crea la tabla EMPRESAS con los siguientes campos:
◦ Cod_empre numeric(2) es la clave
◦ Nombre varchar(25) obligatorio por defecto será empresa1
◦ Fecha_creacion de tipo fecha.*/
CREATE TABLE EMPRESAS (
	Cod_empresa NUMERIC(2) PRIMARY KEY,
	Nombre VARCHAR(25) NOT NULL DEFAULT 'empresa1',
	Fecha_creacion DATE
	);
	
/*6. Introduce la empresa 20 llamada Alfa21 S.A
Nota: La función NOW(), que no requiere parámetros, devuelve la fecha y hora del sistema. SELECT
NOW()*/
INSERT INTO EMPRESAS (Cod_empresa, Nombre, Fecha_creacion) VALUES (20, 'Alfa21 S.A', NOW())

/*7. Crea la tabla CONTINENTES con los siguientes campos:
◦ Cod_continente de tipo numeric y es la clave primaria
◦ Nombre de tipo varchar(20) el valor por defecto es EUROPA y es obligatorio*/
CREATE TABLE CONTINENTES (
	Cod_contienente NUMERIC(2) PRIMARY KEY,
	Nombre VARCHAR(20) NOT NULL DEFAULT 'EUROPA'
	);
	
/*8. Crea la tabla ALUMNOS con los siguientes campos:
◦ codigo numeric(3) y es la clave primaria
◦ nombre varchar(21), es obligatorio
◦ apellido varchar(30), es obligatorio.
◦ curso de tipo numeric y ha de ser 1,2 o 3
◦ fecha_matricula de tipo fecha y por defecto es la fecha actual*/
CREATE TABLE ALUMNOS (
    codigo NUMERIC(3) PRIMARY KEY,
    nombre VARCHAR(21) NOT NULL,
    apellido VARCHAR(30) NOT NULL,
    curso NUMERIC,
    fecha_matricula DATE DEFAULT NOW(),
    CONSTRAINT ck_curso_valido CHECK (curso IN (1, 2, 3))
	);

/*9. Crea la tabla EMPLEADOS con los siguientes campos:
◦ Cod_empleado numeric(2) y es clave
◦ Nombre cadena de caracteres de longitud máxima 20 y es obligatorio
◦ Apellido cadena de caracteres de longitud máxima 25
◦ Salario número de 7 cifras con dos decimales debe ser mayor que 0*/
CREATE TABLE EMPLEADOS (
    Cod_empleado NUMERIC(2) PRIMARY KEY,
    Nombre VARCHAR(20) NOT NULL,
    Apellido VARCHAR(25),
    Salario NUMERIC(7, 2),
    CONSTRAINT ck_salario_positivo CHECK (Salario > 0)
	);
 
/*10. Además tiene dos campos que son claves ajenas de las tablas provincias y empresas
respectivamente. Para la clave ajena de provincias indicaremos un borrado en cascada. NOTA: EN
TOTAL DEBE HABER SEIS CAMPOS.*/
ALTER TABLE EMPLEADOS ADD Cod_empresa NUMERIC(2),
ALTER TABLE EMPLEADOS ADD Cod_provi NUMERIC(2);
ALTER TABLE EMPLEADOS ADD CONSTRAINT fk_empleado_provincia FOREIGN KEY (Cod_provi) REFERENCES PROVINCIAS(Cod_provi) ON DELETE CASCADE; 
ALTER TABLE EMPLEADOS ADD CONSTRAINT fk_empleado_empresa FOREIGN KEY (Cod_empresa) REFERENCES EMPRESAS(Cod_empresa);

/*11. Introduce en la tabla EMPLEADOS, la empleada 300 de nombre Verónica López y salario 3000 ¿Qué
ocurre? ¿Por qué?*/
INSERT INTO EMPLEADOS (Cod_empleado, Nombre, Apellido, Salario) VALUES (300, 'Verónica', 'López', 3000); 

/*12. Introduce los mismos datos que antes pero el código del empleado será 30*/
INSERT INTO EMPLEADOS (Cod_empleado, Nombre, Apellido, Salario) VALUES (30, 'Verónica', 'López', 3000); 

/*13. Introduce en la tabla EMPLEADOS el empleado 10 llamado Sergio Pérez que trabaja para la empresa
de código 10 en la provincia 1 ¿Qué ocurre? ¿Por qué?*/
INSERT INTO EMPLEADOS (Cod_empleado, Nombre, Apellido, Cod_empresa, Cod_provi) VALUES (10, 'Sergio', 'Pérez', 10, 1); 

/*14. Introduce en la tabla EMPLEADOS el empleado 10 llamado Sergio Pérez que trabaja para la empresa
Alfa21 y vive en Ávila.*/
INSERT INTO EMPLEADOS (Cod_empleado, Nombre, Apellido, Cod_empresa, Cod_provi) VALUES (10, 'Sergio', 'Pérez', 10, 1); 

/*15. Crea la tabla PROVINCIAS y PERSONAS con la estructura que se muestra a continuación, en negrita
la clave principal y codprovin referencia a cod_provincia. Además pondremos la opción de
BORRADO EN CASCADA.*/
CREATE TABLE PERSONAS (
    DNI CHAR(9) PRIMARY KEY,
	NOMBRE VARCHAR(25),
	DIRECCION VARCHAR(50),
	CODPROVIN INT
	);
	
CREATE TABLE PROVINCIAS_PERSONAS (
	CODPROVIN INT PRIMARY KEY,
	NOM_PROVINCIA VARCHAR(30),
	POBLACION INTEGER
	);

ALTER TABLE PERSONAS ADD CONSTRAINT fk_personas_personas FOREIGN KEY (CODPROVIN) REFERENCES PROVINCIAS_PERSONAS(CODPROVIN) ON DELETE CASCADE;

/*16. Crea la tabla EJEMPLO1 y asigna a la columna fecha la fecha del sistema: DNI VARCHAR(10)
NOMBRE VARCHAR(30) EDAD NUMERIC(2) FECHA DATE*/
CREATE TABLE EJEMPLO1 (
    DNI VARCHAR(10) PRIMARY KEY,
    NOMBRE VARCHAR(30),
    EDAD NUMERIC(2),
    FECHA DATE DEFAULT NOW()
	);

/*17. Insertar una fila con los valores siguientes, 1234, PEPA, 21 sin la columna fecha, comprobando
después que efectivamente añade la fecha actual.*/	
INSERT INTO EJEMPLO1 (DNI, NOMBRE, EDAD) VALUES ('1234', 'PEPA', 21);

/*18. Crea la tabla EJEMPLO3 cuyas columnas y restricciones son las siguientes: DNI VARCHAR2(10)
NOMBRE VARCHAR(30) EDAD NUMERIC(2) CURSO NUMERIC*/
CREATE TABLE EJEMPLO3 (
	DNI VARCHAR(10),
    NOMBRE VARCHAR(30),
    EDAD NUMERIC(2),
    CURSO NUMERIC
	);

/*19. Restricciones:
◦ El DNI no puede ser nulo
◦ La clave principal es el DNI
◦ La EDAD ha de estar comprendida entre 5 y 20 años
◦ El curso sólo puede almacenar 1,2 o 3*/
ALTER TABLE EJEMPLO3 ADD CONSTRAINT pk_dni_ejemplo3 PRIMARY KEY (DNI);
ALTER TABLE EJEMPLO3 ADD CONSTRAINT ck_edad_ejemplo3 CHECK (EDAD >= 5 AND EDAD <= 20);
ALTER TABLE EJEMPLO3 ADD CONSTRAINT ck_curso_ejemplo3 CHECK (CURSO IN (1, 2, 3));

/*20. Crea las tablas siguientes, con los campos y restricciones indicadas:
◦ ALUMNOS Codigo numeric (2 ) PK Nombre varchar (25) obligatorio
◦ MODULOS Codigo integer PK, Nombre varchar (25)
◦ NOTAS Cod_alumno numeric(2) Cod_modulo integer Nota numeric(2),
▪ (Cod_alumno, modulo) es la clave primaria
▪ Debe tener dos campos que hacen referencia a la tabla MODULOS y ALUMNOS*/
-- 1. Creación de la tabla ALUMNOS
CREATE TABLE ALUMNOS (
    Codigo NUMERIC(2) PRIMARY KEY,
    Nombre VARCHAR(25) NOT NULL   
	);

CREATE TABLE MODULOS (
    Codigo INTEGER PRIMARY KEY,
    Nombre VARCHAR(25)
	);

CREATE TABLE NOTAS (
    Cod_alumno NUMERIC(2),
    Cod_modulo INTEGER,
    Nota NUMERIC(2),
    CONSTRAINT pk_notas PRIMARY KEY (Cod_alumno, Cod_modulo),
    CONSTRAINT fk_notas_alumnos FOREIGN KEY (Cod_alumno) REFERENCES ALUMNOS(Codigo),
    CONSTRAINT fk_notas_modulos FOREIGN KEY (Cod_modulo) REFERENCES MODULOS(Codigo)
	);

mysql> source C:\Users\dam1\Desktop\OscarUbedaRestricciones.sql
Query OK, 1 row affected (0.349 sec)

Database changed
Query OK, 0 rows affected (0.248 sec)

Query OK, 1 row affected (0.072 sec)

Query OK, 0 rows affected (0.133 sec)

ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'CREATE TABLE CONTINENTES (
        Cod_contienente NUMERIC(2) PRIMARY KEY,
        Nombre VARC' at line 9
ERROR 1067 (42000): Invalid default value for 'fecha_matricula'
Query OK, 0 rows affected (0.075 sec)

ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'TABLE EMPLEADOS ADD Cod_provi NUMERIC(2)' at line 5
ERROR 1072 (42000): Key column 'Cod_provi' doesn't exist in table
ERROR 1072 (42000): Key column 'Cod_empresa' doesn't exist in table
ERROR 1264 (22003): Out of range value for column 'Cod_empleado' at row 1
Query OK, 1 row affected (0.011 sec)

ERROR 1054 (42S22): Unknown column 'Cod_empresa' in 'field list'
ERROR 1054 (42S22): Unknown column 'Cod_empresa' in 'field list'
Query OK, 0 rows affected (0.064 sec)

Query OK, 0 rows affected (0.068 sec)

Query OK, 0 rows affected (0.376 sec)
Records: 0  Duplicates: 0  Warnings: 0

ERROR 1067 (42000): Invalid default value for 'FECHA'
ERROR 1146 (42S02): Table 'restricciones.ejemplo1' doesn't exist
Query OK, 0 rows affected (0.063 sec)

Query OK, 0 rows affected (0.195 sec)
Records: 0  Duplicates: 0  Warnings: 0

Query OK, 0 rows affected (0.167 sec)
Records: 0  Duplicates: 0  Warnings: 0

Query OK, 0 rows affected (0.175 sec)
Records: 0  Duplicates: 0  Warnings: 0

Query OK, 0 rows affected (0.090 sec)

Query OK, 0 rows affected (0.069 sec)

Query OK, 0 rows affected (0.183 sec)

mysql>