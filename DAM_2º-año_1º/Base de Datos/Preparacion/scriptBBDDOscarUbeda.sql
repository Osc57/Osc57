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
    dni_cliente CHAR(9),
    PRIMARY KEY (id_cita, dni_recepcionista, dni_cliente),
    CONSTRAINT fk_gestiona_cita FOREIGN KEY (id_cita) REFERENCES cita(id),
    CONSTRAINT fk_gestiona_recepcionista FOREIGN KEY (dni_recepcionista) REFERENCES recepcionista(dni),
    CONSTRAINT fk_gestiona_cliente FOREIGN KEY (dni_cliente) REFERENCES cliente(dni)
);

CREATE TABLE historial (
	dni_cliente CHAR(9) NOT NULL,
	id_tratamiento INT NOT NULL,
	fecha_tratamiento DATETIME NOT NULL,
	PRIMARY KEY (dni_cliente, fecha_tratamiento),
	CONSTRAINT fk_historial_cliente FOREIGN KEY (dni_cliente) REFERENCES cliente(dni) ON DELETE CASCADE,
	CONSTRAINT fk_historial_tratamiento FOREIGN KEY (id_tratamiento) REFERENCES tratamientos(id));

/*Procedo a hacer los inserts*/

/*Inserto trabajadores*/
INSERT INTO trabajadores (dni, nombre, apellidos, telefono, dni_jefe) VALUES ('11111111A', 'Juan', 'García López', '600111111', NULL);
INSERT INTO trabajadores (dni, nombre, apellidos, telefono, dni_jefe) VALUES ('22222222B', 'María', 'Martínez Ruiz', '600222222', '11111111A');
INSERT INTO trabajadores (dni, nombre, apellidos, telefono, dni_jefe) VALUES ('33333333C', 'Carlos', 'Pérez Sánchez', '600333333', '11111111A');
INSERT INTO trabajadores (dni, nombre, apellidos, telefono, dni_jefe) VALUES ('44444444D', 'Laura', 'Jiménez Castro', '600444444', '11111111A');

/*Inserto odontologos*/
INSERT INTO odontologo (dni) VALUES ('11111111A');
INSERT INTO odontologo (dni) VALUES ('22222222B');
INSERT INTO odontologo (dni) VALUES ('33333333C');

/*Inserto al recepcionista*/
INSERT INTO recepcionista (dni) VALUES ('22222222B');
INSERT INTO recepcionista (dni) VALUES ('33333333C');
INSERT INTO recepcionista (dni) VALUES ('44444444D');

/*Inserto clientes*/
INSERT INTO cliente (dni, nombre, apellidos, direccion, telefono, fechaDeAlta) VALUES ('12345678Z', 'Ana', 'Díaz Fernández', 'Calle Sol 1', '911111111', '2024-01-15');
INSERT INTO cliente (dni, nombre, apellidos, direccion, telefono, fechaDeAlta) VALUES ('87654321Y', 'Luis', 'Hernández Gil', 'Av. Luna 5', '922222222', '2024-02-20');
INSERT INTO cliente (dni, nombre, apellidos, direccion, telefono, fechaDeAlta) VALUES ('55555555X', 'Elena', 'Torres Vázquez', 'Plaza Estrella 3', '933333333', '2024-03-10');

/*Inserto los tratamientos*/
INSERT INTO tratamientos (tipo) VALUES ('Limpieza dental');
INSERT INTO tratamientos (tipo) VALUES ('Empaste');
INSERT INTO tratamientos (tipo) VALUES ('Ortodoncia');

/*Ahora que odontologo proporciona el tratamiento*/
INSERT INTO proporciona (dni_odontologo, id_tratamiento, fecha) VALUES ('11111111A', 1, '2023-10-01');
INSERT INTO proporciona (dni_odontologo, id_tratamiento, fecha) VALUES ('22222222B', 2, '2023-10-02');
INSERT INTO proporciona (dni_odontologo, id_tratamiento, fecha) VALUES ('33333333C', 3, '2023-10-03');

/*Ahora inserto las citas*/
INSERT INTO cita (fechaCita, dni_cliente, id_tratamiento) VALUES ('2025-10-15 09:00:00', '12345678Z', 1);
INSERT INTO cita (fechaCita, dni_cliente, id_tratamiento) VALUES ('2025-10-15 10:30:00', '87654321Y', 2);
INSERT INTO cita (fechaCita, dni_cliente, id_tratamiento) VALUES ('2025-10-16 11:00:00', '55555555X', 3);

/*Inserto quien a gestionado al cliente para darle citas*/
INSERT INTO gestiona (id_cita, dni_recepcionista, dni_cliente) VALUES (1, '22222222B', '12345678Z');
INSERT INTO gestiona (id_cita, dni_recepcionista, dni_cliente) VALUES (2, '33333333C', '87654321Y');
INSERT INTO gestiona (id_cita, dni_recepcionista, dni_cliente) VALUES (3, '44444444D', '55555555X');

/*Y ahora instroduzco datos en el historial*/
INSERT INTO historial (dni_cliente, id_tratamiento, fecha_tratamiento) VALUES ('12345678Z', 1, '2025-10-15 09:00:00');
INSERT INTO historial (dni_cliente, id_tratamiento, fecha_tratamiento) VALUES ('87654321Y', 2, '2025-10-15 10:30:00');
INSERT INTO historial (dni_cliente, id_tratamiento, fecha_tratamiento) VALUES ('55555555X', 3, '2025-10-16 11:00:00');
