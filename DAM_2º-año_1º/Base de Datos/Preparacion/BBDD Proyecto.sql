/*Crear la Base de Datos para el proyecto intermodular*/
/*Óscar Úbeda - Base de Datos Clinica Bucodental*/

/*Creo la estructura de la base de datos*/
CREATE DATABASE IF NOT EXISTS proyectoOscar;
USE proyectoOscar;

CREATE TABLE trabajadores (
	dni CHAR(9) PRIMARY KEY,
	nombre VARCHAR(50) NOT NULL,
	apellidos VARCHAR(250) NOT NULL,
	telefono VARCHAR(15) NOT NULL,
	dni_jefe CHAR(9),
	CONSTRAINT fk_trabajador_jefe FOREIGN KEY (dni_jefe) REFERENCES trabajadores(dni) ON DELETE SET NULL);

CREATE TABLE recepcionista (
	dni CHAR(9) PRIMARY KEY,
	CONSTRAINT fk_recepcionista_trabajador FOREIGN KEY (dni) REFERENCES trabajadores(dni) ON DELETE CASCADE); 
	
CREATE TABLE odontologo (
	dni CHAR(9) PRIMARY KEY,
	CONSTRAINT fk_odontologo_trabajador FOREIGN KEY (dni) REFERENCES trabajadores(dni) ON DELETE CASCADE);
	
CREATE TABLE cliente (
	dni CHAR(9) PRIMARY KEY,
	nombre VARCHAR(50) NOT NULL,
	apellidos VARCHAR(250) NOT NULL,
	direccion VARCHAR(250) NOT NULL,
	telefono VARCHAR(15) NOT NULL,
	fechaDeAlta DATE NOT NULL,
	fechaDeBaja DATE DEFAULT NULL);
	
CREATE TABLE tratamientos (
	id INT AUTO_INCREMENT PRIMARY KEY,
	tipo VARCHAR(50) NOT NULL);
	
CREATE TABLE proporciona (
	dni_odontologo CHAR(9),
	id_tratamiento INT,
	fecha DATE NOT NULL,
	PRIMARY KEY (dni_odontologo,id_tratamiento),
	CONSTRAINT fk_proporciona_odontologo FOREIGN KEY (dni_odontologo) REFERENCES odontologo(dni) ON DELETE CASCADE,
	CONSTRAINT fk_proporciona_tratamiento FOREIGN KEY (id_tratamiento) REFERENCES tratamientos(id) ON DELETE CASCADE);
	
CREATE TABLE cita (
	id INT AUTO_INCREMENT PRIMARY KEY,
	fechaCita DATETIME NOT NULL,
	dni_cliente CHAR(9),
	id_tratamiento INT,
	CONSTRAINT fk_cita_cliente FOREIGN KEY (dni_cliente) REFERENCES cliente(dni),
	CONSTRAINT fk_cita_tratamiento FOREIGN KEY (id_tratamiento) REFERENCES tratamientos(id));

CREATE TABLE gestiona (
	id_cita INT,
	dni_recepcionista CHAR(9),
	PRIMARY KEY (id_cita, dni_recepcionista),
	CONSTRAINT fk_gestiona_cita FOREIGN KEY (id_cita) REFERENCES cita(id),
	CONSTRAINT fk_gestiona_recepcionista FOREIGN KEY (dni_recepcionista) REFERENCES recepcionista(dni));
	
CREATE TABLE historial (
	dni_cliente CHAR(9) NOT NULL,
	id_tratamiento INT NOT NULL,
	fecha_tratamiento DATETIME NOT NULL,
	PRIMARY KEY (dni_cliente, fecha_tratamiento),
	CONSTRAINT fk_historial_cliente FOREIGN KEY (dni_cliente) REFERENCES cliente(dni) ON DELETE CASCADE,
	CONSTRAINT fk_historial_tratamiento FOREIGN KEY (id_tratamiento) REFERENCES tratamientos(id));


	
	
	