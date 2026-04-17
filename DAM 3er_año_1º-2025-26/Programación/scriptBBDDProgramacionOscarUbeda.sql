CREATE DATABASE IF NOT EXISTS proyectoOscarUbeda;
USE proyectoOscarUbeda;

-- 1. Departamentos
CREATE TABLE Departamentos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(175) NOT NULL UNIQUE,
    ubicacion VARCHAR(75) NOT NULL
);

-- 2. Empleados
CREATE TABLE Empleados (
    dni CHAR(9) PRIMARY KEY,
    nombre VARCHAR(40) NOT NULL,
    apellidos VARCHAR(200) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    salario DOUBLE NOT NULL DEFAULT 0,
	telefono CHAR(9),
    id_depa INT
	
    CONSTRAINT fk_emple_depa FOREIGN KEY (id_depa) REFERENCES Departamentos(id) ON DELETE SET NULL
);

-- 3. Programadores
CREATE TABLE Programadores ( 
    dni CHAR(9) PRIMARY KEY,
    lenguajePrincipal VARCHAR(150) NOT NULL,
    CONSTRAINT fk_program_emple FOREIGN KEY (dni) REFERENCES Empleados(dni) ON DELETE CASCADE
);

-- 4. Gerentes
CREATE TABLE Gerentes (
    dni CHAR(9) PRIMARY KEY,
    bono DOUBLE NOT NULL DEFAULT 0,
    nivel VARCHAR(50) NOT NULL DEFAULT 'Bajo',
	
    CONSTRAINT ck_nivel CHECK (nivel IN ('Alto','Medio','Bajo')),
    CONSTRAINT fk_gerente_emple FOREIGN KEY (dni) REFERENCES Empleados(dni) ON DELETE CASCADE
);

-- 5. Proyectos
CREATE TABLE Proyectos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(170) NOT NULL,
    presupuesto DOUBLE NOT NULL DEFAULT 0,
    fechaInicio DATE NOT NULL,
    finalizado BOOLEAN DEFAULT FALSE
);

-- 6. Trabajadores 
CREATE TABLE Trabaja (
    dni CHAR(9),
    id_proyect INT,
    PRIMARY KEY(dni, id_proyect),
	
    CONSTRAINT fk_trabaja_emple FOREIGN KEY (dni) REFERENCES Empleados(dni) ON DELETE CASCADE,
    CONSTRAINT fk_trabaja_proyect FOREIGN KEY (id_proyect) REFERENCES Proyectos(id) ON DELETE CASCADE
);

-- 7. Login 
CREATE TABLE Usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(70) NOT NULL UNIQUE DEFAULT 'admin',
    password VARCHAR(70) NOT NULL DEFAULT '1234',
    dni CHAR(9),
	
    CONSTRAINT fk_user_dni FOREIGN KEY (dni) REFERENCES Empleados(dni) ON DELETE CASCADE
);







