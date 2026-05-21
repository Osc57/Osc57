CREATE DATABASE IF NOT EXISTS proyectoOscarUbeda;
USE proyectoOscarUbeda;

-- 1. Departamentos
CREATE TABLE Departamentos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(175) NOT NULL,
    ubicacion VARCHAR(75) NOT NULL
);

-- 2. Empleados
CREATE TABLE Empleados (
    dni CHAR(9) PRIMARY KEY,
    nombre VARCHAR(40) NOT NULL,
    apellidos VARCHAR(200) NOT NULL,
    email VARCHAR(150) NOT NULL,
    salario DOUBLE NOT NULL DEFAULT 0,
	telefono CHAR(9),
    id_depa INT,
	
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
	tipo VARCHAR(100) NOT NULL,
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
    usuario VARCHAR(70) NOT NULL,
    password VARCHAR(70) NOT NULL,
    dni CHAR(9),
	
    CONSTRAINT fk_user_dni FOREIGN KEY (dni) REFERENCES Empleados(dni) ON DELETE CASCADE
);

INSERT INTO Usuarios (usuario, password) VALUES ('admin', '1234');

INSERT INTO departamentos (nombre, ubicacion) VALUES
('Desarrollo de Software', 'Piso 3'),
('Ingeniería y Sistemas', 'Piso 2'),
('Control de Calidad (QA)', 'Piso 4');

INSERT INTO empleados (dni, nombre, apellidos, email, salario, telefono, id_depa) VALUES
('11111111A', 'Laura', 'Gómez Ruiz', 'lgomezo@empresa.emp', 32000, '611223344', 1),
('22222222B', 'Carlos', 'Martín Pérez', 'cmartina@empresa.emp', 45000, '622334455', 2),
('33333333C', 'Ana', 'Santos Díaz', 'asantosa@empresa.emp', 38000, '633445566', 3),
('44444444D', 'Javier', 'López Mora', 'jlopezo@empresa.emp', 29000, '644556677', 1),
('55555555E', 'María', 'Torres Gil', 'mtorreso@empresa.emp', 27000, '655667788', 2);


INSERT INTO gerentes (dni, bono, nivel) VALUES
('11111111A', 16000, 'Alto'),
('22222222B', 11250, 'Medio'),
('33333333C', 3800, 'Bajo');

INSERT INTO programadores (dni, lenguajePrincipal) VALUES
('33333333C', 'Java'),
('44444444D', 'Python'),
('55555555E', 'JavaScript');








