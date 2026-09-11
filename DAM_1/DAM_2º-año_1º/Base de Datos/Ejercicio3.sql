/*Script creación de base de datos de deportes*/
CREATE DATABASE	IF NOT EXISTS deportes;
USE deportes;
CREATE TABLE equipo(
codigo INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(25),
fecha_cre DATE);

CREATE TABLE jugador (
codigo CHAR(12) PRIMARY KEY,
nombre VARCHAR(25),
apellido1 VARCHAR(30),
apellido2 VARCHAR(30),
demacracion VARCHAR(25));

CREATE TABLE juega (
codigoJugador CHAR(12),
codigoEquipo INT,
fecha_contrato DATE,
PRIMARY KEY (codigoJugador,codigoEquipo,fecha_contrato),
CONSTRAINT fk_juega_jug FOREIGN KEY (codigoJugador) REFERENCES jugador(codigo),
CONSTRAINT fk_juega_equip FOREIGN KEY (codigoEquipo) REFERENCES equipo(codigo));

/*Añado sueldo a jugador*/
ALTER TABLE jugador ADD sueldo FLOAT;

/*Modifico apellido1*/
ALTER TABLE jugador MODIFY COLUMN apellido1 VARCHAR(40); 

/*Enumeracion de valores*/
ALTER TABLE equipo ADD CONSTRAINT ck_equipo_nomb CHECK (nombre IN ('Real Madrid','FC.Barcelona','Real Sociedad'));

/*Elimino apellido 2*/
ALTER TABLE jugadores DROP COLUMN apellido2;
