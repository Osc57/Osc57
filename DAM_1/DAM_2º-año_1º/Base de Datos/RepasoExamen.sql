/*Creación de tablase Ejercicio Farmacias*/
/*Fecha 27/01/2025*/
/*Creacion de la base de datos*/
CREATE DATABASE IF NOT EXISTS farmacias;

/*Me posiciono en la base de datos*/
USE farmacias;

/*Creo las tablas*/
/*Creamos la tabla fabricante*/
CREATE TABLE fabricante(
	codigoF CHAR(6) PRIMARY KEY,
	nombre VARCHAR(20),
	pais VARCHAR(20) DEFAULT ('España'));
	
/*Creamos la tabla medicamento*/
CREATE TABLE medicamento(
	codigoM INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(30),
	categoria VARCHAR(20),
	fabricante CHAR(6),
	CONSTRAINT fk_medicamento_fabricante FOREIGN KEY (fabricante) REFERENCES fabricante(codigoF),
	CONSTRAINT ck_nombre_med CHECK (nombre=UPPER(nombre)));
	
/*Creamos la tabla farmacia*/
CREATE TABLE farmacia(
	codigoF CHAR(12) PRIMARY KEY,
	propietario VARCHAR(30) NOT NULL,
	direccion VARCHAR(40),
	ciudad VARCHAR(15),
	cp CHAR(5));
	
/*Creamos la tabla venta*/
CREATE TABLE venta(
	codigoF CHAR(12),
	codigoM INT,
	fecha DATE,
	cantidad INT,
	precioVenta FLOAT,
	PRIMARY KEY (codigoF,codigoM,fecha),
	CONSTRAINT fk_venta_farmacia FOREIGN KEY (codigoF) REFERENCES farmacia(codigoF) ON DELETE CASCADE,
	CONSTRAINT fk_venta_medicamento FOREIGN KEY (codigoM) REFERENCES medicamento(codigoM) ON DELETE CASCADE,
	CONSTRAINT ck_cantidad CHECK (cantidad>99));
	
/*Modificaciones*/
ALTER TABLE  medicamento ADD principio_activo VARCHAR(20) AFTER categoria;

ALTER TABLE fabricante MODIFY COLUMN codigoF VARCHAR(30);
ALTER TABLE medicamento MODIFY COLUMN fabricante VARCHAR(30);

DROP CONSTRAINT ck_cantidad;
ALTER TABLE venta MODIFY COLUMN cantidad ENUM(100,200,300);

ALTER TABLE farmacia DROP COLUMN cp;