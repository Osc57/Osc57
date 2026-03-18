-- DROP DATABASE if exists circo;
-- drop database if exists nba;
-- drop database if exists venta;
-- DROP DATABASE IF EXISTS jardineria;
DROP DATABASE IF EXISTS telefonia;
CREATE DATABASE telefonia;

use telefonia;


CREATE TABLE tarifas (
  id_tarifa NUMERIC(11) PRIMARY KEY,
  nombre varchar(45) DEFAULT NULL,
  establecimiento float DEFAULT NULL,
  minuto_movil float DEFAULT NULL,
  minuto_fijo float DEFAULT NULL,
  num_promociones int DEFAULT NULL
) ;


INSERT INTO tarifas VALUES (1,'Barata',0.15,0.01,0.05,null);
INSERT INTO tarifas VALUES (2,'Normal',0.5,0.05,0.1,null);
INSERT INTO tarifas VALUES (3,'Buena',0.01,0.1,0.05,null);

CREATE TABLE promociones (
  id_tarifa NUMERIC(11),
  id_promocion NUMERIC(11),
  nombre varchar(45) DEFAULT NULL,
  fecha_inicio date,
  fecha_fin date,
  descuento float,
  CONSTRAINT tarifa_cliente_fk FOREIGN KEY (id_tarifa) REFERENCES tarifas (id_tarifa),
  CONSTRAINT tarifa_cliente_pk PRIMARY KEY (id_tarifa, id_promocion)  
) ;


INSERT INTO promociones VALUES (1, 1, 'Navidad', '2024-12-17', '2025-01-07', 0.25);
INSERT INTO promociones VALUES (1, 2, 'Champions', '2025-03-17', '2021-05-07', 0.1);


CREATE TABLE clientes (
  id_cliente NUMERIC(11) PRIMARY KEY,
  nif varchar(9) DEFAULT NULL,
  nombre varchar(45) DEFAULT NULL,
  apellidos varchar(45) DEFAULT NULL,
  tlf varchar(9) UNIQUE,
  tarifa NUMERIC(11) DEFAULT NULL,
  edad INT,	
  padrino NUMERIC(11),
  CONSTRAINT tarifa_fk FOREIGN KEY (tarifa) REFERENCES tarifas (id_tarifa),
  CONSTRAINT padrino_fk FOREIGN KEY (padrino) REFERENCES clientes (id_cliente)
);


INSERT INTO clientes VALUES (1,'1A','Ambrosio','Faustino','677554433',1, 20,NULL);
INSERT INTO clientes VALUES (2,'2C','Caludio','Caniggia','654332211',2, 30,1);
INSERT INTO clientes VALUES (3,'4D','Marco','Van Basten','655432215',3, 40,1);
INSERT INTO clientes VALUES (4,'3F','Meho ','Kodro','678443367',1, 60,1);
INSERT INTO clientes VALUES (5,'6G','Federica ','Kon','678442156',1,70, 1);


CREATE TABLE llamadas (
  id_llamada NUMERIC(11) PRIMARY KEY,
  id_cliente NUMERIC(11) DEFAULT NULL,
  destino varchar(20) DEFAULT NULL,
  duracion NUMERIC(11,2) DEFAULT NULL,
  fecha DATE DEFAULT NULL,
  importe NUMERIC(11,2) DEFAULT NULL,
  tipo varchar(4)  DEFAULT NULL,
  CONSTRAINT llamdadas_fk FOREIGN KEY (id_cliente) REFERENCES clientes (id_cliente)
);


INSERT INTO llamadas VALUES (1,1,'956775477',2,'2024-12-16',null, 'N');

INSERT INTO llamadas VALUES (2,1,'651221198',3,'2025-01-03' , null, 'I');
INSERT INTO llamadas VALUES (3,1,'655432215',1,'2025-01-04', null, 'R');
INSERT INTO llamadas VALUES (4,2,'678443367',10,'2024-01-04', null, 'I');
INSERT INTO llamadas VALUES (5,3,'965172504',180,'2025-01-05' , null, 'I');
INSERT INTO llamadas VALUES (6,3,'678665543',27,'2024-01-16', null, 'R');

commit;