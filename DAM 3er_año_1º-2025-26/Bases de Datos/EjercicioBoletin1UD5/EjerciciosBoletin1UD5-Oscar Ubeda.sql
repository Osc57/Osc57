/*Ejercicio 1-Óscar Úbeda*/

--Creo al base de datos y me posiciono en ella
CREATE DATABASE IF NOT EXISTS CLINICA_SALUD;
USE CLINICA_SALUD;

--Creo las tablas de la BBDD
CREATE TABLE ESPECIALIDADES (
	cod_especialidad NUMERIC(3) PRIMARY KEY,
	nombre_especialidad VARCHAR(50) NOT NULL,
	area_medica VARCHAR(30),
	disponible CHAR(1) ENUM ('N','S') DEFAULT ('S'),
	CONSTRAINT chk_areaMedica CHECK (area_medica IN ('MEDICINA GENERAL','CIRUGIA','PEDRIATRIA','CARDIOLOGIA'))
	);

CREATE TABLE MEDICOS (
	num_colegiado VARCHAR(15) PRIMARY KEY,
	nombre VARCHAR(40) NOT NULL,
	apellidos VARCHAR(60) NOT NULL,
	telefono VARCHAR(12),
	email VARCHAR(80) NOT NULL,
	fecha_y_hora_alta DATE DEFAULT (NOW()),
	anos_experiencia INT,
	cod_especialidad NUMERIC(3),
	CONSTRAINT chk_anosExp CHECK (anos_experiencia > 0 AND anos_experiencia < 50),
	CONSTRAINT fk_medicos_especialidades FOREIGN KEY (cod_especialidad) REFERENCES ESPECIALIDADES(cod_especialidad) ON DELETE RESTRICT
	);
	
CREATE TABLE PACIENTES (
	num_historial INT AUTO_INCREMENT PRIMARY KEY,
	dni CHAR(9) NOT NULL UNIQUE,
	nombre VARCHAR(40) NOT NULL,
	apellidos VARCHAR(60) NOT NULL,
	fecha_nacimiento DATE NOT NULL,
	grupo_sanguineo CHAR(3) ENUM ('A+', 'A-', 'B+', 'B-','AB+', 'AB-', 'O+', 'O-'),
	alergias VARCHAR(250),
	telefono_contacto VARCHAR(12) NOT NULL
	);

CREATE TABLE CONSULTAS (
	cod_consulta INT AUTO_INCREMENT PRIMARY KEY,
	num_historial INT,
	num_colegiado_medico VARCHAR(15)
	fecha_consulta DATE DEFAULT(NOW()),
	diagnostico VARCHAR(200),
	precio DECIMAL(6,2)
	pagado CHAR(1) ENUM ('N','S') DEFAULT ('S'),
	CONSTRAINT fk_historial_paciente FOREIGN KEY (num_historial) REFERENCES PACIENTES(num_historial) ON DELETE CASCADE,
	CONSTRAINT fk_coelgiado_medicos FOREIGN KEY (num_colegiado_medico) REFERENCES MEDICOS(num_historial) ON DELETE RESTRICT,
	CONSTRAINT chk_precio CHECK (precio > 0  AND precio < 0)
	);
	
--Inserto en ESPECIALIDADES 
INSERT INTO ESPECIALIDADES (cod_especialidad, nombre, area_medica, disponible) VALUES (101, 'CARDIOLOGIA', 'CARDIOLOGIA', 'S');

--Inserto en MEDICOS
INSERT INTO MEDICOS (num_colegiado, nombre, apellidos, telefono, email, anos_experiencia, cod_especialidad) VALUES ('28-4567890', 'Carlos', 'Fernández Ruiz', 'cfernandez@clinica.es', 5, 999);

--Insterto en MEDICOS el medico correctamente
INSERT INTO MEDICOS (num_colegiado, nombre, apellidos, telefono, email, anos_experiencia, cod_especialidad) VALUES ('28-4567890', 'Carlos', 'Fernández Ruiz', 'cfernandez@clinica.es', 5, 101);

--Inserto en PACIENTES
INSERT INTO PACIENTES (dni, nombre, apellidos, fecha_nacimiento, grupo_sanguineo, telefono_contacto) VALUES ('12345678A', 'Maria', 'Gracia Lopez', 1990-05-15, 'A+', '666777888');

--Inserto en CONSULTAS
INSERT INTO CONSULTAS (num_historial, num_colegiado_medico, precio, pagado) VALUES (1, '28-4567890', 75.50, 'N');

/*
11.Añade un campo horario_consulta en la tabla MEDICOS que sea de tipo texto de 20
caracteres (valores permitidos: 'MAÑANA', 'TARDE', 'COMPLETO').
12.Modifica el campo email de la tabla MEDICOS para que tenga una longitud de 100
caracteres.
13.Añade un campo mutua en la tabla PACIENTES de tipo texto de 50 caracteres con valor por
defecto 'PARTICULAR'.
14.Elimina el campo alergias de la tabla PACIENTES.
15.Añade una restricción CHECK a la tabla CONSULTAS para que el campo precio no pueda
superar los 1000 euros (modifica la restricción existente).
16.Crea una restricción UNIQUE en la tabla MEDICOS para el campo email (si no la tiene ya).
*/

--Añado campo a medicos
ALTER TABLE MEDICOS ADD horario_consulta VARCHAR(20) ENUM ('MAÑANA', 'TARDE', 'COMPLETO');

--Modifico campo MEDICOS
ALTER TABLE MEDICOS MODIFY COLUMN email VARCHAR(100);

--Añado campo mutua en PACIENTES
ALTER TABLE PACIENTES ADD mutua VARCHAR(50) DEFAULT ('PARTICULAR')


-- Ejercicio 2 - Cursos online 
-- Fecha: 09/01/26
-- Nombre: Óscar Úbeda

-- Borramos la base de datos si existe 
DROP DATABASE IF EXISTS ACADEMIA_VIRTUAL;
-- Creamos la base de datos
CREATE DATABASE ACADEMIA_VIRTUAL;

-- Nos situamos en la base de datos 
USE ACADEMIA_VIRTUAL;

-- Creamos la tabla CATEGORIAS 
CREATE TABLE CATEGORIAS (
	id_categoria INTEGER AUTO_INCREMENT PRIMARY KEY,
	nombre_categoria VARCHAR(40) NOT NULL UNIQUE,
	descripcion VARCHAR(150),
	activa CHAR(1) DEFAULT 'S', 
	
	CONSTRAINT ck_activa CHECK (activa IN ('S', 'N'))
);

-- Creamos la tabla INSTRUCTORES
CREATE TABLE INSTRUCTORES (
	email VARCHAR(100) PRIMARY KEY,
	nombre_completo VARCHAR(80) UNIQUE,
	biografia TEXT,
	fecha_registro DATE DEFAULT CURRENT_DATE,
	puntuacion_media DECIMAL(3,2),
	certificado	CHAR(1),
	linkedin VARCHAR(150),
	
	CONSTRAINT ck_puntuacion_rango CHECK (puntuacion_media BETWEEN 0 AND 5),
    CONSTRAINT ck_certificado_valores CHECK (certificado IN ('S', 'N'))
);

-- Creamos la tabla Cursos
CREATE TABLE CURSOS(
	cod_curso CHAR(10) PRIMARY KEY,
	titulo VARCHAR(100) NOT NULL,
	descripcion TEXT,
	nivel CHAR(15),
	duracion_horas INTEGER,
	precio DECIMAL(6,2),
	
	CONSTRAINT chk_nivel CHECK (nivel IN ('BASICO','INTERMEDIO','AVANZADO','EXPERTO')),
	CONSTRAINT ck_duracion_horas CHECK (duracion_horas > 0 AND duracion_horas < 500),
);