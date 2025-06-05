/*Crear la Base de Datos para el proyecto intermodular*/
/*Óscar Úbeda - Base de Datos Clinica Bucodental*/

/*Creo la estructura de la base de datos*/
CREATE DATABASE IF NOT EXISTS proyectoOscar;
USE proyectoOscar;

CREATE TABLE trabajadores (
	dni CHAR(9) PRIMARY KEY,
	nombre VARCHAR(50) NOT NULL,
	apellidos VARCHAR(250) NOT NULL,
	telefono VARCHAR(15) NOT NULL);

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
	
	
CREATE TABLE cita (
	id INT AUTO_INCREMENT PRIMARY KEY,
	fechaCita DATETIME NOT NULL UNIQUE,
	dni_cliente CHAR(9),
	id_tratamiento INT,
	CONSTRAINT fk_cita_cliente FOREIGN KEY (dni_cliente) REFERENCES cliente(dni) ON DELETE CASCADE,
	CONSTRAINT fk_cita_tratamiento FOREIGN KEY (id_tratamiento) REFERENCES tratamientos(id));
	
CREATE TABLE historial (
	dni_cliente CHAR(9) NOT NULL,
	id_tratamiento INT NOT NULL,
	fecha_tratamiento DATETIME NOT NULL,
	PRIMARY KEY (dni_cliente, fecha_tratamiento),
	CONSTRAINT fk_historial_cliente FOREIGN KEY (dni_cliente) REFERENCES cliente(dni),
	CONSTRAINT fk_historial_tratamiento FOREIGN KEY (id_tratamiento) REFERENCES tratamientos(id));

CREATE TABLE loggin (
	usuario VARCHAR(25),
	contrasena INT);

/*Procedo a hacer triggers*/
/*Este trigger introduce el dni del trabajador directamente a la tabla odontologo*/
DELIMITER //
CREATE TRIGGER insertar_trabajadores_odontologos
AFTER INSERT ON trabajadores
FOR EACH ROW
BEGIN
    INSERT INTO odontologo (dni) VALUES (NEW.dni);
END//
DELIMITER ;

DELIMITER //

/*Trigger para que cuando sse inserte un trabajador se le cree un usuario auomaticamente con su dni*/
DELIMITER //
CREATE TRIGGER insertar_trabajadores_ususario
AFTER INSERT ON trabajadores
FOR EACH ROW
BEGIN
    INSERT INTO loggin (usuario,contrasena) VALUES (NEW.dni, '1234');
END//
DELIMITER ;

DELIMITER //

/*Trigger para evitar que un DNI de trabajador se use en cliente*/
CREATE TRIGGER evitar_trabajador_como_cliente
BEFORE INSERT ON cliente
FOR EACH ROW
BEGIN
    IF EXISTS (SELECT 1 FROM trabajadores WHERE dni = NEW.dni) THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Este DNI pertenece a un trabajador y no puede ser cliente';
    END IF;
END//

/*Trigger para evitar que un DNI de cliente se use en trabajador*/
CREATE TRIGGER evitar_cliente_como_trabajador
BEFORE INSERT ON trabajadores
FOR EACH ROW
BEGIN
    IF EXISTS (SELECT 1 FROM cliente WHERE dni = NEW.dni) THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Este DNI pertenece a un cliente y no puede ser trabajador';
    END IF;
END//

DELIMITER ;

/*Trigger para eliminar la cita una vez sea pasada y meterla en el historial*/
DELIMITER //
CREATE EVENT auto_limpieza_citas
ON SCHEDULE EVERY 10 SECOND 
STARTS CURRENT_TIMESTAMP
DO
BEGIN
    INSERT INTO historial (dni_cliente, id_tratamiento, fecha_tratamiento)
    SELECT dni_cliente, id_tratamiento, fechaCita
    FROM cita
    WHERE fechaCita < NOW(); 

    DELETE FROM cita WHERE fechaCita < NOW();
END //
DELIMITER ;

/*Inserto users y sus passwords*/
INSERT INTO loggin (usuario, contrasena) VALUES ('Admin', 1234); 

/*Hago un Insert en trabajadores*/
INSERT INTO trabajadores (dni, nombre, apellidos, telefono) VALUES ('12345678A', 'Carlos', 'Gomez Martinez', '600111222');
INSERT INTO trabajadores (dni, nombre, apellidos, telefono) VALUES ('23456789B', 'Ana', 'Lopez Sanchez', '600222333');
INSERT INTO trabajadores (dni, nombre, apellidos, telefono) VALUES ('34567890C', 'David', 'Perez Fernandez', '600333444');
INSERT INTO trabajadores (dni, nombre, apellidos, telefono) VALUES ('45678901D', 'Elena', 'Ruiz Diaz', '600444555');
INSERT INTO trabajadores (dni, nombre, apellidos, telefono) VALUES ('56789012E', 'Pedro', 'Sanz Jimenez', '600555666');

/*Introduzco los tratameintos*/
INSERT INTO tratamientos (tipo) VALUES ('Limpieza dental profesional');
INSERT INTO tratamientos (tipo) VALUES ('Empaste dental');
INSERT INTO tratamientos (tipo) VALUES ('Selladores de fisuras');
INSERT INTO tratamientos (tipo) VALUES ('Consulta odontologica');
INSERT INTO tratamientos (tipo) VALUES ('Revision dental');

INSERT INTO tratamientos (tipo) VALUES ('Endodoncia');
INSERT INTO tratamientos (tipo) VALUES ('Extraccion dental');
INSERT INTO tratamientos (tipo) VALUES ('Extraccion de muelas del juicio');

INSERT INTO tratamientos (tipo) VALUES ('Blanqueamiento dental');
INSERT INTO tratamientos (tipo) VALUES ('Carillas dentales');
INSERT INTO tratamientos (tipo) VALUES ('Ortodoncia invisible');

INSERT INTO tratamientos (tipo) VALUES ('Corona dental');
INSERT INTO tratamientos (tipo) VALUES ('Puente dental');
INSERT INTO tratamientos (tipo) VALUES ('Implante dental');
INSERT INTO tratamientos (tipo) VALUES ('Protesis dental');
INSERT INTO tratamientos (tipo) VALUES ('Reconstruccion dental');

INSERT INTO tratamientos (tipo) VALUES ('Tratamiento de gingivitis');
INSERT INTO tratamientos (tipo) VALUES ('Cirugia periodontal');

INSERT INTO tratamientos (tipo) VALUES ('Ortodoncia metalica');

INSERT INTO tratamientos (tipo) VALUES ('Radiografia dental');	
	
/*Inserto unos usuarios*/
INSERT INTO cliente (dni, nombre, apellidos, direccion, telefono, fechaDeAlta) VALUES 
('12345677A', 'Juan', 'Garcia Perez', 'Calle Mayor 123, Madrid', '600111222', '2020-01-15'),
('23456788B', 'Maria', 'Lopez Fernandez', 'Avenida de la Constitucion 45, Barcelona', '611222333', '2020-02-20'),
('34567899C', 'Carlos', 'Martinez Sanchez', 'Plaza Espana 7, Valencia', '622333444', '2020-03-10'),
('45678911D', 'Ana', 'Rodriguez Gomez', 'Calle Gran Via 89, Sevilla', '633444555', '2020-04-05'),
('56789011E', 'Pedro', 'Hernandez Diaz', 'Paseo de la Castellana 12, Madrid', '644555666', '2020-05-12'),
('67890123F', 'Laura', 'Gomez Ruiz', 'Calle Sierpes 34, Sevilla', '655666777', '2020-06-18'),
('78901234G', 'David', 'Fernandez Lopez', 'Rambla Catalunya 56, Barcelona', '666777888', '2020-07-22'),
('89012345H', 'Sofia', 'Sanchez Martinez', 'Calle Colon 78, Valencia', '677888999', '2020-08-30'),
('90123456I', 'Javier', 'Perez Gonzalez', 'Calle Preciados 90, Madrid', '688999000', '2020-09-14'),
('01234567J', 'Elena', 'Diaz Hernandez', 'Avenida Diagonal 123, Barcelona', '699000111', '2020-10-25'),
('11223344K', 'Miguel', 'Ruiz Gomez', 'Calle Tetuan 45, Sevilla', '610111222', '2021-01-03'),
('22334455L', 'Isabel', 'Gonzalez Perez', 'Paseo de Gracia 67, Barcelona', '621222333', '2021-02-11'),
('33445566M', 'Francisco', 'Jimenez Garcia', 'Calle San Vicente 89, Valencia', '632333444', '2021-03-19'),
('44556677N', 'Lucia', 'Moreno Martin', 'Gran Via 12, Madrid', '643444555', '2021-04-27'),
('55667788O', 'Antonio', 'Alvarez Rodriguez', 'Calle Trajano 34, Sevilla', '654555666', '2021-05-08'),
('66778899P', 'Carmen', 'Torres Sanchez', 'Paseo Maritimo 56, Malaga', '665666777', '2021-06-16'),
('77889900Q', 'Daniel', 'Navarro Lopez', 'Calle Larios 78, Malaga', '676777888', '2021-07-24'),
('88990011R', 'Patricia', 'Romero Fernandez', 'Avenida de America 90, Madrid', '687888999', '2021-08-09'),
('99001122S', 'Alejandro', 'Molina Garcia', 'Calle Real 123, Sevilla', '698999000', '2021-09-17'),
('00112233T', 'Raquel', 'Serrano Martinez', 'Paseo de la Reforma 45, Bilbao', '609000111', '2021-10-05');

/*Inserto citas*/
INSERT INTO cita (fechaCita, dni_cliente, id_tratamiento) VALUES
('2023-11-15 10:00:00', '12345677A', 1),
('2023-12-20 11:30:00', '12345677A', 3),
('2023-11-16 09:15:00', '23456788B', 2),
('2023-12-10 16:45:00', '23456788B', 1),
('2023-11-17 14:00:00', '34567899C', 4),
('2023-11-18 10:30:00', '45678911D', 5),
('2023-12-15 12:00:00', '45678911D', 1),
('2023-11-20 17:00:00', '56789011E', 3),
('2023-12-22 09:30:00', '56789011E', 2);
