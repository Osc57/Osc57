/*TAREA RECUPERACIÓN TIENDA DE VIDEOJUEGOS - ÓSCAR ÚBEDA*/
/*Creo Base de Datos*/
DROP DATABASE IF EXISTS GAMEWORLD;

/*1*/
CREATE DATABASE GAMEWORLD;
USE GAMEWORLD;

/*2*/
CREATE TABLE GENEROS_JUEGO (
	id_genero INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(40) NOT NULL UNIQUE,
	descripcion VARCHAR(150),
	multijugador CHAR(1) DEFAULT 'S',
	
	CONSTRAINT ck_multijugador CHECK (multijugador IN ('S', 'N'))
);

/*3*/
CREATE TABLE VIDEOJUEGOS (
	cod_juego VARCHAR(10) PRIMARY KEY,
	titulo VARCHAR(100) NOT NULL UNIQUE,
	desarrollador VARCHAR(80) NOT NULL,
	anio_lanzamiento INT(4),
	clasificacion_edad CHAR(5),
	plataforma VARCHAR(15),
	precio DECIMAL(6,2),
	id_genero INT,
	activo CHAR(1) DEFAULT 'S',
	
	CONSTRAINT ck_anio_lanzamiento CHECK (anio_lanzamiento BETWEEN 1970 AND 2026 + 1),
	CONSTRAINT ck_clasificacion_edad CHECK (clasificacion_edad IN ('PEGI3', 'PEGI7', 'PEGI12', 'PEGI16', 'PEGI18')),
	CONSTRAINT ck_plataforma CHECK (plataforma IN ('PC', 'PS5', 'XBOX', 'SWITCH', 'MOVIL', 'MULTIP')),
	CONSTRAINT ck_precio CHECK (precio >= 0),
	CONSTRAINT ck_activo CHECK (activo IN ('S', 'N')),
	
	CONSTRAINT fk_videoj_generoj FOREIGN KEY (id_genero) REFERENCES GENEROS_JUEGO(id_genero) ON DELETE RESTRICT
);

/*4*/
CREATE TABLE JUGADORES (
	id_jugador INT AUTO_INCREMENT PRIMARY KEY,
	nickname VARCHAR(30) NOT NULL UNIQUE,
	email VARCHAR(100) NOT NULL UNIQUE,
	fecha_registro DATE DEFAULT (CURRENT_DATE),
	pais VARCHAR(50),
	nivel_cuenta INT DEFAULT 1,
	monedas_virtuales INT DEFAULT 0,
	estado_cuenta VARCHAR(12) DEFAULT 'ACTIVA',
	
	CONSTRAINT ck_nivel_cuenta CHECK (nivel_cuenta > 0 AND nivel_cuenta <= 100),
	CONSTRAINT ck_monedas_virtuales CHECK (monedas_virtuales >= 0),
	CONSTRAINT ck_estado_cuenta CHECK (estado_cuenta IN ('ACTIVA', 'SUSPENDIDA', 'BANEADA', 'INACTIVA'))
);

/*5*/
CREATE TABLE PARTIDAS (
    id_partida INT AUTO_INCREMENT PRIMARY KEY,
    cod_juego VARCHAR(10),
    fecha_inicio DATETIME NOT NULL,
    fecha_fin DATETIME,
    modalidad VARCHAR(15),
    mapa_escenario VARCHAR(60),
    
    CONSTRAINT ck_modalidad CHECK (modalidad IN ('INDIVIDUAL', 'COOPERATIVO', 'COMPETITIVO')),
    CONSTRAINT ck_fecha_fin CHECK (fecha_fin IS NULL OR fecha_fin > fecha_inicio),
    
	CONSTRAINT fk_juego_partida FOREIGN KEY (cod_juego) REFERENCES VIDEOJUEGOS(cod_juego) ON DELETE RESTRICT
);

/*6*/
CREATE TABLE PARTICIPACIONES (
	id_participacion INT AUTO_INCREMENT PRIMARY KEY,
	id_partida INT,
	id_jugador INT,
	puntuacion INT DEFAULT 0,
	resultado VARCHAR(10) DEFAULT 'EN_JUEGO',
	tiempo_jugado_sec INT,
	bajas_realizadas INT DEFAULT 0,
	bajas_recibidas INT DEFAULT 0,
	
	
	CONSTRAINT ck_puntuacion CHECK (puntuacion >= 0),
    CONSTRAINT ck_resultado CHECK (resultado IN ('VICTORIA', 'DERROTA', 'EMPATE', 'EN_JUEGO')),
    CONSTRAINT ck_tiempo_jugado CHECK (tiempo_jugado_sec >= 0),
    CONSTRAINT ck_bajas_realiz CHECK (bajas_realizadas >= 0),
    CONSTRAINT ck_bajas_recib CHECK (bajas_recibidas >= 0),
	
	CONSTRAINT restriccion_adicional_jugador UNIQUE (id_partida, id_jugador),
	
	CONSTRAINT fk_partida_paridas FOREIGN KEY (id_partida) REFERENCES PARTIDAS(id_partida) ON DELETE CASCADE,  
    CONSTRAINT fk_jugador_jugadores FOREIGN KEY (id_jugador) REFERENCES JUGADORES(id_jugador) ON DELETE RESTRICT
);

/*MODIFICACIONES DE LA TABLA*/

/*7*/
ALTER TABLE VIDEOJUEGOS ADD descripcion TEXT();

/*8*/
ALTER TABLE PARTIDAS MODIFY mapa_escenario VARCHAR(100);

/*9*/
ALTER TABLE INTO JUGADORES ADD avatar_url TEXT(200);

/*10*/
ALTER TABLE JUGADORES DROP CONSTRAINT ck_nivel_cuenta;

/*11*/

/*12*/
ALTER TABLE VIDEOJUEGOS ADD CONSTRAINT  

