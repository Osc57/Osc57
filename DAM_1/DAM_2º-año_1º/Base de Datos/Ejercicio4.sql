/*Script creación de base de datos de empresa*/
CREATE DATABASE IF NOT EXISTS empresa;
USE empresa;

CREATE TABLE fabricantes (
cod_fabricante INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(25),
pais VARCHAR(25) DEFAULT ('ESPAÑA'),
CONSTRAINT ck_nombre_may CHECK (CAST(nombre as BINARY)=UPPER(nombre)),
CONSTRAINT ck_pais_may CHECK (CAST(pais as BINARY)=UPPER(pais)));

CREATE TABLE articulos (
cod_articulo INT,
cod_fabricante INT,
peso FLOAT,
categoria VARCHAR(25),
precio_venta FLOAT,
precio_costo FLOAT,
PRIMARY KEY (cod_articulo,cod_fabricante,peso,categoria),
CONSTRAINT ck_categoria CHECK (categoria IN ('Primera','Segunda','Tercera')),
CONSTRAINT ck_venta CHECK (precio_venta > 0),
CONSTRAINT ck_costo CHECK (precio_costo > 0));

/*Añado restricción de clave ajena a cod_fabricante*/
ALTER TABLE articulos ADD CONSTRAINT fk_fabricante FOREIGN KEY(cod_fabricante) REFERENCES fabricantes(cod_fabricante) ON DELETE CASCADE;

/*Modifico campo de la tabla fabricantes*/
ALTER TABLE fabricantes MODIFY COLUMN nombre VARCHAR(50);

/*Añado campo en fabricantes fecha creacion empresa*/
ALTER TABLE fabricantes ADD fecha_creacion DATE;

/*Añado en articulos el campo descripcion*/
ALTER TABLE articulos ADD descripcion VARCHAR(500);

/*Inserto nueva tabla paises */
CREATE TABLE paises (
cod CHAR(2) PRIMARY KEY,
pais VARCHAR(25) NOT NULL,
habitantes INTEGER,
renta_per_capita DECIMAL(2,2),
peligroso CHAR(1),
CONSTRAINT ck_codigo CHECK (CAST(cod as BINARY)=UPPER(cod)),
CONSTRAINT ck_habitantes CHECK (habitantes > 10000),
CONSTRAINT ck_peligroso CHECK (peligroso IN ('S','N')));

/*Añado campo en fabricantes pais*/
ALTER TABLE fabricantes ADD COLUMN cod_pais CHAR(2);
ALTER TABLE fabricantes ADD CONSTRAINT fk_fabr_paises FOREIGN KEY(cod_pais) REFERENCES paises(cod) ON DELETE CASCADE;