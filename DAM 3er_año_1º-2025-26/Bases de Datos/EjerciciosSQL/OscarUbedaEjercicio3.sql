/*Ejercicio 2 - Óscar Úbeda*/
/*Caso 1*/
/*Caso 1:
Proveedores (#id_prov: numerico, nombre: cadena(30), teléfono:cadena(9), mail: cadena(20))
Categorías (#id_categoria:cadena (2), descripcion:cadena (50))
Productos (#numero_producto: entero, nombre: cadena(30), precio_venta: decimal, stock: entero, id_categoria: cadena(2))
																								Categorias
Productos_provedores (#id_prov: numerico, #numero_producto:numerico)
					Proveedores 		Productos
Clientes (#id_cliente: cadena(3), nombre:cadena(25),apellidos:cadena(25), dirección:cadena(30),
teléfono:cadena(9))
Empleados (#id_empleado: cadena(3), nombre:cadena(30), apellidos:cadena(30) , dirección: cadena (30)
codigo_area: cadena(2))
Pedidos (#numero_pedido: entero, fecha_pedido:fecha, id_cliente:cadena(3), id_empleado:cadena(3))
Clientes Empleados
VNN { id_cliente, id_empleado }
Detalles_Pedidos (#numero_pedido:entero, #numero_producto:entero, cantidad:entero, precio:decimal(2 decimales))
					Pedidos 				Producto
Además:
 En detalles_pedidos el campo cantidad debe estar comprendido entre 1 y 100.
 En todas las tablas el campo teléfono debe ser único.
*/

CREATE DATABASE IF NOT EXIST CASO1;
USE CASO1;

CREATE TABLE Proveedores (
	id_prov NUMERIC PRIMARY KEY,
	nombre VARCHAR(30),
	telefono CHAR(9),
	mail VARCHAR(20)
	);

CREATE TABLE Categorias (
	id_categoria CHAR(2) PRIMARY KEY,
	descripcion VARCHAR(50)
	);
	
CREATE TABLE Productos (
	numero_producto int PRIMARY KEY,
	nombre VARCHAR(30),
	precio_ventana FLOAT,
	stock INT,
	id_categoria CHAR(2),
	CONSTRAINT fk_productos_categoria FOREIGN KEY (id_categoria) REFERENCES Categorias(id_categoria)
	);


