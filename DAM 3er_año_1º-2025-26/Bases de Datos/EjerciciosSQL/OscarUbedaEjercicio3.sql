/*Ejercicio 2 - Óscar Úbeda*/
/*Caso 1*/
/*
Proveedores (#id_prov: numerico, nombre: cadena(30), teléfono:cadena(9), mail: cadena(20))
Categorías (#id_categoria:cadena (2), descripcion:cadena (50))
Productos (#numero_producto: entero, nombre: cadena(30), precio_venta: decimal, stock: entero, id_categoria: cadena(2))
																								Categorias
Productos_provedores (#id_prov: numerico, #numero_producto:numerico)
					Proveedores 		Productos
Clientes (#id_cliente: cadena(3), nombre:cadena(25),apellidos:cadena(25), dirección:cadena(30),teléfono:cadena(9))
Empleados (#id_empleado: cadena(3), nombre:cadena(30), apellidos:cadena(30) , dirección: cadena (30), codigo_area: cadena(2))
Pedidos (#numero_pedido: entero, fecha_pedido:fecha, id_cliente:cadena(3), id_empleado:cadena(3))
														Clientes 				Empleados
VNN { id_cliente, id_empleado }
Detalles_Pedidos (#numero_pedido:entero, #numero_producto:entero, cantidad:entero, precio:decimal(2 decimales))
					Pedidos 				Producto
Además:
 En detalles_pedidos el campo cantidad debe estar comprendido entre 1 y 100.
 En todas las tablas el campo teléfono debe ser único.
*/

CREATE DATABASE IF NOT EXISTS CASO1;
USE CASO1;

CREATE TABLE Proveedores (
	id_prov NUMERIC PRIMARY KEY,
	nombre VARCHAR(30),
	telefono CHAR(9) UNIQUE,
	mail VARCHAR(20)
	);

CREATE TABLE Categorias (
	id_categoria CHAR(2) PRIMARY KEY,
	descripcion VARCHAR(50)
	);
	
CREATE TABLE Productos (
	numero_producto INT PRIMARY KEY,
	nombre VARCHAR(30),
	precio_ventana DECIMAL,
	stock INT,
	id_categoria CHAR(2),
	CONSTRAINT fk_productos_categoria FOREIGN KEY (id_categoria) REFERENCES Categorias(id_categoria)
	);

CREATE TABLE Productos_provedores (
	id_prov NUMERIC,
	numero_producto INT,
	PRIMARY KEY (id_prov, numero_producto),
	CONSTRAINT fk_pprovedores_provedores FOREIGN KEY (id_prov) REFERENCES Proveedores(id_prov),
	CONSTRAINT fk_pprovedores_productos FOREIGN KEY (numero_producto) REFERENCES Productos(numero_producto)
	);

CREATE TABLE Clientes (
	id_cliente CHAR(3),
	nombre VARCHAR(25),
	apellidos VARCHAR(25),
	direccion VARCHAR(30),
	telefono CHAR(9) UNIQUE
	);

CREATE TABLE Empleados (
	id_empleado CHAR(3) PRIMARY KEY,
	nombre VARCHAR(30),
	apellidos VARCHAR(30),
	direccion VARCHAR(30),
	codigo_area CHAR(2)
	);

CREATE TABLE Pedidos (
	numero_pedido INT PRIMARY KEY,
	fecha_pedido DATE,
	id_cliente CHAR(3),
	id_empleado CHAR(3),
	CONSTRAINT fk_pedidos_cliente FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cleinte),
	CONSTRAINT fk_pedidos_empelados FOREIGN KEY (id_empleado) REFERENCES Empleados(id_empleado),
	CONSTRAINT chk_cantidad_rango CHECK (cantidad >= 1 AND cantidad <= 100)
	);

CREATE TABLE Detalles_Pedidos (
	numero_pedido INT,
	numero_producto INT,
	cantidad INT,
	precio DECIMAL(10,2),
	PRIMARY KEY (numero_pedido, numero_produto),
	CONSTRAINT fk_dpedidos_pedidos FOREIGN KEY (nuemero_pedido) REFERENCES Pedidos(numero_pedidos),
	CONSTRAINT fk_dpedidos_productos FOREIGN KEY (nuemero_productos) REFERENCES Productos(numero_producto)
	);
	