/*Crear la Base de Datos para el proyecto intermodular*/
/*Óscar Úbeda - Base de Datos Clinica Bucodental*/

CREATE DATABASE IF NOT EXISTS proyectoOscar;
USE proyectoOscar;

CREATE TABLE trabajadores (
	dni CHAR(9) PRIMARY KEY,
	nombre VARCHAR(50) NOT NULL,
	apellidos VARCHAR(250) NOT NULL,
	telefono INT);

CREATE TABLE recepcionista (
	dni CHAR(9) PRIMARY KEY,
	CONSTRAINT fk_recepcionista_tr FOREIGN KEY (dni) REFERENCES trabajadores(dni) ON DELETE CASCADE); 
	
CREATE TABLE odontologo (
	dni CHAR(9) PRIMARY KEY,
	CONSTRAINT fk_odontologo_tr FOREIGN KEY (dni) REFERENCES trabajadores(dni) ON DELETE CASCADE);
	
CREATE TABLE cliente (
	dni CHAR(9) PRIMARY KEY,
	nombre VARCHAR(50) NOT NULL,
	apellidos VARCHAR(250) NOT NULL,
	direccion VARCHAR(250) NOT NULL,
	telefono INT);
	
CREATE TABLE tratamientos (
	id INT AUTO_INCREMENT PRIMARY KEY,
	tipo VARCHAR(50) NOT NULL,
	fecha DATE,
	dni_cliente CHAR(9) NOT NULL,
	odontologoACargo CHAR(9) NOT NULL,
	CONSTRAINT fk_tratamiento_cliente FOREIGN KEY (dni_cliente) REFERENCES cliente(dni),
	CONSTRAINT fk_tratamiento_odontologo FOREIGN KEY (odontologoACargo) REFERENCES odontologo(dni));
	

	
	
	