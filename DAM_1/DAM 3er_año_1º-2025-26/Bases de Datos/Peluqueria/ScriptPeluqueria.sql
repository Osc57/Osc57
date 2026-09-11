DROP DATABASE IF EXISTS peluqueria;
CREATE DATABASE peluqueria;
USE peluqueria;

DROP TABLE  IF EXISTS cliente CASCADE;
DROP TABLE  IF EXISTS empleado CASCADE;
DROP TABLE  IF EXISTS servicio CASCADE;
DROP TABLE  IF EXISTS empleado_servicio CASCADE;
DROP TABLE  IF EXISTS evento CASCADE;
DROP TABLE  IF EXISTS detalle_evento CASCADE;
DROP TABLE  IF EXISTS cita CASCADE;


CREATE TABLE cliente (
  id INTEGER PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  apellido VARCHAR(50),
  email VARCHAR(100) NOT NULL,
  telefono VARCHAR(7),
  fecha_nacimiento DATE,
  localidad VARCHAR(15)
) ;

CREATE TABLE empleado (
  id INTEGER PRIMARY KEY,
  nombre VARCHAR(50),
  apellido VARCHAR(50),
  email VARCHAR(100) DEFAULT NULL,
  detalles VARCHAR(300) DEFAULT NULL,
  fecha_contrato DATE DEFAULT NULL,
  salario NUMERIC(10,2) DEFAULT NULL,
  salon VARCHAR(30) DEFAULT NULL,
  activo CHAR(1) DEFAULT 'Y',
  id_jefe INTEGER,
  localidad VARCHAR(30)
)  ;
  
  ALTER TABLE empleado ADD CONSTRAINT FOREIGN KEY(id_jefe) REFERENCES empleado(id);
  
CREATE TABLE servicio (
  id INTEGER PRIMARY KEY,
  nombre VARCHAR(50),
  genero VARCHAR(10),
  detalles VARCHAR(500),
  valoracion NUMERIC(10,2),
  tiempo INTEGER
);

CREATE TABLE empleado_servicio (
  id_empleado INTEGER NOT NULL,
  id_servicio INTEGER NOT NULL,
  PRIMARY KEY (id_empleado, id_servicio),
  FOREIGN KEY (id_empleado) REFERENCES empleado(id),
  FOREIGN KEY (id_servicio) REFERENCES servicio(id)
);


CREATE TABLE evento (
  id INTEGER PRIMARY KEY,
  nombre VARCHAR(50),
  cliente VARCHAR(50),
  detalles VARCHAR(500),
  fecha_comienzo DATE
) ;


CREATE TABLE detalle_evento (
  id_evento INTEGER,
  linea INTEGER,
  nombre VARCHAR(50) NOT NULL,
  cantidad VARCHAR(50) DEFAULT NULL,
  detalles VARCHAR(500),
  precio NUMERIC(10,2) NOT NULL,
  id_empleado INTEGER,
  PRIMARY KEY (id_evento, linea),
  FOREIGN KEY (id_evento) REFERENCES evento(id),
  FOREIGN KEY (id_empleado) REFERENCES empleado(id)
);


CREATE TABLE cita (
  id_empleado INTEGER,
  id_servicio INTEGER,
  id_cliente INTEGER,
  fecha_cita TIMESTAMP,
  precio NUMERIC(10,2),
  tiempo INTEGER,
  PRIMARY KEY (id_empleado, id_servicio, id_cliente, fecha_cita),
  FOREIGN KEY (id_empleado, id_servicio) REFERENCES empleado_servicio(id_empleado, id_servicio),
  FOREIGN KEY (id_cliente) REFERENCES cliente(id)
);


INSERT INTO cliente (id, nombre, apellido, email, telefono, fecha_nacimiento, localidad) VALUES
(1, 'Angela', 'Merkel', 'am@t.com', '001', str_to_date('1981-4-1', '%Y-%m-%d'), 'Sevilla');
INSERT INTO cliente (id, nombre, apellido, email, telefono, fecha_nacimiento, localidad) VALUES
(2, 'Michelle', 'Obama', 'mo@t.com', '002', str_to_date('1971-4-19', '%Y-%m-%d'), 'Madrid');
INSERT INTO cliente (id, nombre, apellido, email, telefono, fecha_nacimiento, localidad) VALUES
(3, 'Hilary', 'Clinton', 'hc@t.com', '003', str_to_date('1977-6-24', '%Y-%m-%d'),'Zaragoza');
INSERT INTO cliente (id, nombre, apellido, email, telefono, fecha_nacimiento, localidad) VALUES
(4, 'Pedro', 'Sanchez', 'ps@t.com', '004', str_to_date('1969-5-21', '%Y-%m-%d'), 'Teruel');
INSERT INTO cliente (id, nombre, apellido, email, telefono, fecha_nacimiento, localidad) VALUES
(5, 'Yolanda', 'Diaz', 'yd@t.com', '005', str_to_date('1965-6-12', '%Y-%m-%d'), 'Huesca');
INSERT INTO cliente (id, nombre, apellido, email, telefono, fecha_nacimiento, localidad) VALUES
(6, 'Pablo', 'Casado', 'pc@t.com', '006', str_to_date('1963-7-4', '%Y-%m-%d'), 'Segovia');
INSERT INTO cliente (id, nombre, apellido, email, telefono, fecha_nacimiento, localidad) VALUES
(7, 'Vladimir', 'Putin', 'vp@t.com', '007', str_to_date('1957-8-23', '%Y-%m-%d'), 'Barcelona');
INSERT INTO cliente (id, nombre, apellido, email, telefono, fecha_nacimiento, localidad) VALUES
(8, 'Donald', 'Trump', 'dt@t.com', '008', str_to_date('1956-9-30', '%Y-%m-%d'), 'Madrid');
INSERT INTO cliente (id, nombre, apellido, email, telefono, fecha_nacimiento, localidad) VALUES
(9, 'Marcos', 'Sanchez', 'ac@t.com', '009', str_to_date('1955-10-13', '%Y-%m-%d'), 'Teruel');
INSERT INTO cliente (id, nombre, apellido, email, telefono, fecha_nacimiento, localidad) VALUES
(10, 'Antonio', 'Banderas', 'ac@t.com', '009', str_to_date('1955-10-13', '%Y-%m-%d'), 'Madrid');
INSERT INTO cliente (id, nombre, apellido, email, telefono, fecha_nacimiento, localidad) VALUES
(11, 'Ana', 'Lopez', 'ac@t.com', '009', str_to_date('1955-10-13', '%Y-%m-%d'), 'Soria');


INSERT INTO empleado (id, nombre, apellido, email, detalles, fecha_contrato, salario, salon, id_jefe, localidad) VALUES
(1, 'Aitana', 'Ocana', 'ana@pelu.com', 'Aitana es la responsable del centro desde sus inicios. Es creativa y emprendedora, le encanta aportar nuevas ideas.', str_to_date('2001-4-1', '%Y-%m-%d'), 1200, 'Romareda', NULL, 'Teruel');
INSERT INTO empleado (id, nombre, apellido, email, detalles, fecha_contrato, salario,  salon, id_jefe, localidad) VALUES
(2, 'Rigoberta', 'Bandini', 'vale@pelu.com', 'Rigoberta es la última incorporación.', str_to_date('2019-5-10', '%Y-%m-%d'), 980, 'Romareda', 1, 'Cella');
INSERT INTO empleado (id, nombre, apellido, email, detalles, fecha_contrato, salario, salon, id_jefe, localidad) VALUES
(3, 'Rosalia', 'Vila', 'lia@pelu.com', 'Rosalia es una apasianada de la manicura.', str_to_date('2019-8-11', '%Y-%m-%d'), 1300, 'Romareda', 1, 'Calamocha');
INSERT INTO empleado (id, nombre, apellido, email, detalles, fecha_contrato, salario, salon, id_jefe, localidad) VALUES
(4, 'Raquel', 'Loreal', 'lore@pelu.com', 'Raquel es una apasianada de la transformacion.', str_to_date('2020-8-11', '%Y-%m-%d'), 1300, 'Centro', 1, 'Teruel');
INSERT INTO empleado (id, nombre, apellido, email, detalles, fecha_contrato, salario, salon, id_jefe, localidad) VALUES
(5, 'Ramon', 'Llongeras', 'llon@pelu.com', 'Ramon domina la tijera como nadie.', str_to_date('2020-2-21', '%Y-%m-%d'), 1300, 'Centro', NULL,'Cella');
INSERT INTO empleado (id, nombre, apellido, email, detalles, fecha_contrato, salario, salon, id_jefe, localidad) VALUES
(6, 'Omar', 'Montes', 'omar@pelu.com', 'Omar domina el secador como nadie.', str_to_date('2020-3-20', '%Y-%m-%d'), 1020, 'Centro', 5, 'Daroca');
INSERT INTO empleado (id, nombre, apellido, email, detalles, fecha_contrato, salario, salon, id_jefe, localidad) VALUES
(7, 'Iris', 'Mala', 'iris@pelu.com', 'Iris es Iris.', str_to_date('2020-3-20', '%Y-%m-%d'), 1050, 'Centro', 5, 'Calatayud');
INSERT INTO empleado (id, nombre, apellido, email, detalles, fecha_contrato, salario, salon, id_jefe, localidad) VALUES
(8, 'Saul', 'Morales', 'saul@pelu.com', 'Saul es estupendo.', str_to_date('2020-3-20', '%Y-%m-%d'), 1000, 'Ensanche', NULL, 'Teruel');
INSERT INTO empleado (id, nombre, apellido, email, detalles, fecha_contrato, salario, salon, id_jefe, localidad) VALUES
(9, 'Otro', 'Otra', 'otro@pelu.com', 'Otro es otro.', str_to_date('2020-3-20', '%Y-%m-%d'), 900, 'Ensanche', 8, 'Jaen');
INSERT INTO empleado (id, nombre, apellido, email, detalles, fecha_contrato, salario, salon, id_jefe, localidad) VALUES
(10, 'Rosa', 'Perez', 'rosa@pelu.com', 'Rosa corta barbas.', str_to_date('2021-3-10', '%Y-%m-%d'), 1100, 'Ensanche', 8, 'Valencia');
INSERT INTO empleado (id, nombre, apellido, email, detalles, fecha_contrato, salario, salon, id_jefe, localidad) VALUES
(11, 'Bruce', 'Lee', 'lee@pelu.com', 'Bruce lucha como nadie.', str_to_date('2021-4-24', '%Y-%m-%d'), 1500, 'Fuenfresca', NULL, 'Utrillas');
INSERT INTO empleado (id, nombre, apellido, email, detalles, fecha_contrato, salario, salon, id_jefe, localidad) VALUES
(12, 'Peter', 'Parker', 'peter@pelu.com', 'Peter domina las alturas.', str_to_date('2021-5-20', '%Y-%m-%d'), 1000, 'Fuenfresca', 11, 'Utrillas');
INSERT INTO empleado (id, nombre, apellido, email, detalles, fecha_contrato, salario, salon, id_jefe, localidad) VALUES
(13, 'Ana', 'Mor', 'ana@pelu.com', 'Ana es una crack.', str_to_date('2021-6-21', '%Y-%m-%d'), 1400, 'Fuenfresca', 11, 'Griegos');
INSERT INTO empleado (id, nombre, apellido, email, detalles, fecha_contrato, salario, salon, id_jefe, localidad) VALUES
(14, 'Eva', 'Solis', 'eva@pelu.com', 'Eva domina la plancha el secador como nadie.', str_to_date('2021-6-24', '%Y-%m-%d'), 1000, 'Fuenfresca', 1,'Sevilla');


INSERT INTO servicio(id, nombre, genero, detalles, valoracion, tiempo) VALUES (1, 'cortar', 'mujer', 'Cada corte es unico y personal',  20, 30);
INSERT INTO servicio(id, nombre, genero, detalles, valoracion, tiempo) VALUES (2, 'cortar', 'hombre', 'Cada corte es unico y personal',  16, 20);
INSERT INTO servicio(id, nombre, genero, detalles, valoracion, tiempo) VALUES (3, 'balayage', 'mujer', 'Nuestra tecnica aporta lumnosidad y naturalidad',  45, 60);
INSERT INTO servicio(id, nombre, genero, detalles, valoracion, tiempo) VALUES (4, 'maquillar', 'unisex', 'El maquillaje de los profesionales',  75, 60);
INSERT INTO servicio(id, nombre, genero, detalles, valoracion, tiempo) VALUES (5, 'rasurar barba', 'hombre', 'La barba rasurada',  75, 20);
INSERT INTO servicio(id, nombre, genero, detalles, valoracion, tiempo) VALUES (6, 'lavar pelo', 'unisex', 'Pelo como la seda',  95, 15);
INSERT INTO servicio(id, nombre, genero, detalles, valoracion, tiempo) VALUES (7, 'tinte de color', 'unisex', 'Pelo multicolor',  85, 70);
INSERT INTO servicio(id, nombre, genero, detalles, valoracion, tiempo) VALUES (8, 'limpieza de cutis', 'hombre', 'Tu cara limpia',  60, 60);
INSERT INTO servicio(id, nombre, genero, detalles, valoracion, tiempo) VALUES (9, 'limpieza de cutis', 'mujer', 'Tu cara limpia',  80, 60);
INSERT INTO servicio(id, nombre, genero, detalles, valoracion, tiempo) VALUES (10, 'esmalte de uñas', 'mujer', 'Brillan',  80, 40);

INSERT INTO empleado_servicio VALUES (1, 1);
INSERT INTO empleado_servicio VALUES (1, 2);
INSERT INTO empleado_servicio VALUES (1, 3);
INSERT INTO empleado_servicio VALUES (2, 1);
INSERT INTO empleado_servicio VALUES (2, 2);
INSERT INTO empleado_servicio VALUES (2, 3);
INSERT INTO empleado_servicio VALUES (3, 4);
INSERT INTO empleado_servicio VALUES (4, 1);
INSERT INTO empleado_servicio VALUES (10, 3);
INSERT INTO empleado_servicio VALUES (12, 4);
INSERT INTO empleado_servicio VALUES (13, 5);
INSERT INTO empleado_servicio VALUES (14, 8);
INSERT INTO empleado_servicio VALUES (1, 6);
INSERT INTO empleado_servicio VALUES (2, 7);
INSERT INTO empleado_servicio VALUES (4, 8);
INSERT INTO empleado_servicio VALUES (4, 9);
INSERT INTO empleado_servicio VALUES (3, 5);
INSERT INTO empleado_servicio VALUES (7, 5);
INSERT INTO empleado_servicio VALUES (4, 6);
INSERT INTO empleado_servicio VALUES (5, 7);
INSERT INTO empleado_servicio VALUES (5, 8);
INSERT INTO empleado_servicio VALUES (6, 9);
INSERT INTO empleado_servicio VALUES (6, 10);



INSERT INTO cita VALUES (1, 1, 1, str_to_date('2021-2-18', '%Y-%m-%d'), 20, 30);
INSERT INTO cita VALUES (1, 1, 1, str_to_date('2021-3-14', '%Y-%m-%d'), 20, 30);
INSERT INTO cita VALUES (1, 3, 1, str_to_date('2021-3-14', '%Y-%m-%d'), 45, 60);
INSERT INTO cita VALUES (2, 1, 2, str_to_date('2021-1-18', '%Y-%m-%d'), 20, 30);
INSERT INTO cita VALUES (2, 2, 2, str_to_date('2021-2-14', '%Y-%m-%d'), 75, 60);
INSERT INTO cita VALUES (2, 3, 2, str_to_date('2021-2-20', '%Y-%m-%d'), 45, 60);

INSERT INTO cita VALUES (3, 4, 3, str_to_date('2021-2-19', '%Y-%m-%d'), 20, 30);
INSERT INTO cita VALUES (4, 1, 3, str_to_date('2021-3-15', '%Y-%m-%d'), 20, 30);

INSERT INTO cita VALUES (10, 3, 4, str_to_date('2021-3-14', '%Y-%m-%d'), 16, 20);
INSERT INTO cita VALUES (12, 4, 4, str_to_date('2021-1-18', '%Y-%m-%d'), 16, 20);
INSERT INTO cita VALUES (13, 5, 4, str_to_date('2021-2-14', '%Y-%m-%d'), 16, 20);
INSERT INTO cita VALUES (14, 8, 4, str_to_date('2021-2-20', '%Y-%m-%d'), 16, 20);

INSERT INTO cita VALUES (1, 6, 5, str_to_date('2021-4-18', '%Y-%m-%d'), 75, 60);
INSERT INTO cita VALUES (2, 7, 5, str_to_date('2021-5-14', '%Y-%m-%d'), 75, 60);

INSERT INTO cita VALUES (4, 8, 6, str_to_date('2021-3-14', '%Y-%m-%d'), 16, 20);
INSERT INTO cita VALUES (2, 2, 6, str_to_date('2021-1-18', '%Y-%m-%d'), 16, 20);

INSERT INTO cita VALUES (2, 3, 7, str_to_date('2021-2-14', '%Y-%m-%d'), 16, 20);
INSERT INTO cita VALUES (4, 9, 8, str_to_date('2021-2-20', '%Y-%m-%d'), 16, 20);

INSERT INTO cita VALUES (3, 5, 7, str_to_date('2021-2-16', '%Y-%m-%d'), 16, 20);
INSERT INTO cita VALUES (4, 6, 8, str_to_date('2021-2-20', '%Y-%m-%d'), 16, 20);
INSERT INTO cita VALUES (5, 7, 7, str_to_date('2021-2-18', '%Y-%m-%d'), 16, 20);
INSERT INTO cita VALUES (5, 8, 8, str_to_date('2021-2-21', '%Y-%m-%d'), 16, 20);
INSERT INTO cita VALUES (6, 9, 7, str_to_date('2021-4-14', '%Y-%m-%d'), 16, 20);
INSERT INTO cita VALUES (6, 10, 8, str_to_date('2021-3-20', '%Y-%m-%d'), 16, 20);



INSERT INTO evento(id, nombre, cliente, detalles, fecha_comienzo) VALUES
(1, 'Maria Antonieta', 'Teatro las esquinas', '10 caracterizaciones para personajes prinicpales y 50 secundarios',  str_to_date('2021-09-04','%Y-%m-%d'));
INSERT INTO evento(id, nombre, cliente, detalles, fecha_comienzo) VALUES
(2, 'Hamlet', 'Cine Maravillas', '9 caracterizaciones para personajes prinicpales y 30 secundarios',  str_to_date('2021-09-04','%Y-%m-%d'));
INSERT INTO evento(id, nombre, cliente, detalles, fecha_comienzo) VALUES
(3, 'Evento de empresarios', 'Teatro Marin', 'Peinados y recogidos',  str_to_date('2021-09-04','%Y-%m-%d'));
INSERT INTO evento(id, nombre, cliente, detalles, fecha_comienzo) VALUES
(4, 'Boda real', 'Catedral', 'Tratamiento completos',  str_to_date('2021-09-04','%Y-%m-%d'));
INSERT INTO evento(id, nombre, cliente, detalles, fecha_comienzo) VALUES
(5, 'Feria de informatica', 'IES Segundo de Chomon', 'Cuidado de manos',  str_to_date('2021-09-04','%Y-%m-%d'));
INSERT INTO evento(id, nombre, cliente, detalles, fecha_comienzo) VALUES
(6, 'Feria del deporte ', 'Palacio de exposiciones', 'Limpieza de caras',  str_to_date('2021-09-04','%Y-%m-%d'));


INSERT INTO detalle_evento(id_evento, linea, nombre, cantidad, detalles, precio, id_empleado) VALUES
('1', '1', 'Caracterización completa',  '10', '', 100, 4);
INSERT INTO detalle_evento(id_evento, linea, nombre, cantidad, detalles, precio, id_empleado) VALUES
('1', '2', 'Caracterización básica', '50', '', 100, 1);
INSERT INTO detalle_evento(id_evento, linea, nombre, cantidad, detalles, precio, id_empleado) VALUES
('2', '1', 'Caracterizacion basica', '40', '', 100, 3);

INSERT INTO detalle_evento(id_evento, linea, nombre, cantidad, detalles, precio, id_empleado) VALUES
('2', '2', 'Caracterización completa', '9', '', 100, 2);
INSERT INTO detalle_evento(id_evento, linea, nombre, cantidad, detalles, precio, id_empleado) VALUES
('2', '3', 'Peinados', '49', '', 500, 1);


INSERT INTO detalle_evento(id_evento, linea, nombre, cantidad, detalles, precio, id_empleado) VALUES
('3', '1', 'Estilismo', '50', '', 100, 6);
INSERT INTO detalle_evento(id_evento, linea, nombre, cantidad, detalles, precio, id_empleado) VALUES
('3', '2', 'Cuidados faciales', '10', '', 100, 5);

INSERT INTO detalle_evento(id_evento, linea, nombre, cantidad, detalles, precio, id_empleado) VALUES
('4', '1', 'Peinados', '1000', '', 100000, 6);
INSERT INTO detalle_evento(id_evento, linea, nombre, cantidad, detalles, precio, id_empleado) VALUES
('4', '2', 'Recogidos', '500', '', 8000, 8);

INSERT INTO detalle_evento(id_evento, linea, nombre, cantidad, detalles, precio, id_empleado) VALUES
('4', '3', 'Estilismo', '1000', '', 10000, 7);
INSERT INTO detalle_evento(id_evento, linea, nombre, cantidad, detalles, precio, id_empleado) VALUES
('5', '1', 'Manos y uñas', '50', '', 500, 9);
INSERT INTO detalle_evento(id_evento, linea, nombre, cantidad, detalles, precio, id_empleado) VALUES
('5', '2', 'Peinados', '70', '', 14000, 8);
INSERT INTO detalle_evento(id_evento, linea, nombre, cantidad, detalles, precio, id_empleado) VALUES
('6', '2', 'Recorte de barbas', '10', '', 500, 10);





commit;





