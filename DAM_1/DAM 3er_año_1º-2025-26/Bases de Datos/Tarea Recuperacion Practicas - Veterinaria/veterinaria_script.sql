-- ============================================================
--  BASE DE DATOS: VETERINARIA
--  Red de clínicas veterinarias
--  Tablas: clinica, veterinario, propietario, mascota,
--          consulta, tratamiento, mascota_tratamiento
-- ============================================================

DROP DATABASE IF EXISTS VETERINARIA;
CREATE DATABASE VETERINARIA CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci;
USE VETERINARIA;

-- ------------------------------------------------------------
--  1. CLINICA
-- ------------------------------------------------------------
CREATE TABLE clinica (
    cod_clinica   CHAR(5)      NOT NULL,
    nombre        VARCHAR(60)  NOT NULL,
    ciudad        VARCHAR(40)  NOT NULL,
    direccion     VARCHAR(100) NOT NULL,
    telefono      CHAR(9)      NOT NULL,
    num_boxes     TINYINT      NOT NULL,   
    CONSTRAINT pk_clinica PRIMARY KEY (cod_clinica),
    CONSTRAINT ck_clinica_boxes CHECK (num_boxes > 0 AND num_boxes <= 20)
);

-- ------------------------------------------------------------
--  2. VETERINARIO
-- ------------------------------------------------------------
CREATE TABLE veterinario (
    num_colegiado CHAR(8)      NOT NULL,
    nombre        VARCHAR(40)  NOT NULL,
    apellidos     VARCHAR(60)  NOT NULL,
    especialidad  VARCHAR(40)  NOT NULL,
    salario       DECIMAL(8,2) NOT NULL,
    fecha_alta    DATE         NOT NULL,
    cod_clinica   CHAR(5)      NOT NULL,
    CONSTRAINT pk_veterinario PRIMARY KEY (num_colegiado),
    CONSTRAINT fk_vet_clinica  FOREIGN KEY (cod_clinica)
        REFERENCES clinica(cod_clinica) ON DELETE RESTRICT,
    CONSTRAINT ck_vet_salario  CHECK (salario > 0)
);

-- ------------------------------------------------------------
--  3. PROPIETARIO
-- ------------------------------------------------------------
CREATE TABLE propietario (
    id_propietario INT          NOT NULL AUTO_INCREMENT,
    dni            CHAR(9)      NOT NULL,
    nombre         VARCHAR(40)  NOT NULL,
    apellidos      VARCHAR(60)  NOT NULL,
    telefono       CHAR(9),
    email          VARCHAR(80),
    ciudad         VARCHAR(40),
    CONSTRAINT pk_propietario  PRIMARY KEY (id_propietario),
    CONSTRAINT uq_prop_dni     UNIQUE (dni)
);

-- ------------------------------------------------------------
--  4. MASCOTA
-- ------------------------------------------------------------
CREATE TABLE mascota (
    id_mascota     INT          NOT NULL AUTO_INCREMENT,
    nombre         VARCHAR(30)  NOT NULL,
    especie        VARCHAR(20)  NOT NULL,   -- Perro, Gato, Ave, Reptil, Otro
    raza           VARCHAR(40),
    fecha_nac      DATE,
    peso_kg        DECIMAL(5,2),            -- peso en kg
    esterilizado   CHAR(1)      NOT NULL DEFAULT 'N',
    id_propietario INT          NOT NULL,
    CONSTRAINT pk_mascota      PRIMARY KEY (id_mascota),
    CONSTRAINT fk_masc_prop    FOREIGN KEY (id_propietario)
        REFERENCES propietario(id_propietario) ON DELETE CASCADE,
    CONSTRAINT ck_masc_ester   CHECK (esterilizado IN ('S','N')),
    CONSTRAINT ck_masc_peso    CHECK (peso_kg > 0)
);

-- ------------------------------------------------------------
--  5. CONSULTA
-- ------------------------------------------------------------
CREATE TABLE consulta (
    id_consulta    INT           NOT NULL AUTO_INCREMENT,
    fecha          DATE          NOT NULL,
    motivo         VARCHAR(100)  NOT NULL,
    diagnostico    VARCHAR(200),
    importe        DECIMAL(7,2)  NOT NULL,
    pagada         CHAR(1)       NOT NULL DEFAULT 'N',
    id_mascota     INT           NOT NULL,
    num_colegiado  CHAR(8)       NOT NULL,
    CONSTRAINT pk_consulta     PRIMARY KEY (id_consulta),
    CONSTRAINT fk_cons_masc    FOREIGN KEY (id_mascota)
        REFERENCES mascota(id_mascota) ON DELETE CASCADE,
    CONSTRAINT fk_cons_vet     FOREIGN KEY (num_colegiado)
        REFERENCES veterinario(num_colegiado) ON DELETE RESTRICT,
    CONSTRAINT ck_cons_pagada  CHECK (pagada IN ('S','N')),
    CONSTRAINT ck_cons_importe CHECK (importe > 0)
);

-- ------------------------------------------------------------
--  6. TRATAMIENTO
-- ------------------------------------------------------------
CREATE TABLE tratamiento (
    cod_trat      CHAR(6)      NOT NULL,
    nombre        VARCHAR(60)  NOT NULL,
    tipo          VARCHAR(20)  NOT NULL,   -- Medicamento, Cirugia, Vacuna, Prueba
    precio_base   DECIMAL(7,2) NOT NULL,
    requiere_vet  CHAR(1)      NOT NULL DEFAULT 'S',  -- S=sólo veterinario, N=auxiliar
    CONSTRAINT pk_tratamiento  PRIMARY KEY (cod_trat),
    CONSTRAINT ck_trat_precio  CHECK (precio_base > 0),
    CONSTRAINT ck_trat_vet     CHECK (requiere_vet IN ('S','N'))
);

-- ------------------------------------------------------------
--  7. MASCOTA_TRATAMIENTO  (relación mascota ↔ tratamiento)
-- ------------------------------------------------------------
CREATE TABLE mascota_tratamiento (
    id_mascota   INT          NOT NULL,
    cod_trat     CHAR(6)      NOT NULL,
    fecha        DATE         NOT NULL,
    dosis        VARCHAR(40),
    num_sesiones TINYINT      NOT NULL DEFAULT 1,
    CONSTRAINT pk_masc_trat   PRIMARY KEY (id_mascota, cod_trat, fecha),
    CONSTRAINT fk_mt_mascota  FOREIGN KEY (id_mascota)
        REFERENCES mascota(id_mascota) ON DELETE CASCADE,
    CONSTRAINT fk_mt_trat     FOREIGN KEY (cod_trat)
        REFERENCES tratamiento(cod_trat) ON DELETE RESTRICT,
    CONSTRAINT ck_mt_sesiones CHECK (num_sesiones > 0)
);


-- ============================================================
--  DATOS DE EJEMPLO
-- ============================================================

-- ── CLÍNICAS ────────────────────────────────────────────────
INSERT INTO clinica VALUES
('CLN01', 'Clínica Veterinaria Norte',  'Madrid',    'Av. de la Paz 12',       '910001001', 6),
('CLN02', 'Clínica Veterinaria Sur',    'Madrid',    'C/ Retama 45',           '910002002', 4),
('CLN03', 'VetSalud Sevilla',           'Sevilla',   'Av. Borbolla 30',        '954003003', 8),
('CLN04', 'Clínica Animal Barcelona',   'Barcelona', 'C/ Aragón 210',          '932004004', 5),
('CLN05', 'VetNord Bilbao',             'Bilbao',    'Gran Vía 88',            '944005005', 3);

-- ── VETERINARIOS ────────────────────────────────────────────
INSERT INTO veterinario VALUES
('V0000001', 'Ana',      'García Ruiz',       'Medicina general',  2800.00, '2018-03-01', 'CLN01'),
('V0000002', 'Carlos',   'Martínez López',    'Cirugía',           3500.00, '2015-06-15', 'CLN01'),
('V0000003', 'Lucía',    'Fernández Pérez',   'Dermatología',      3100.00, '2019-09-10', 'CLN02'),
('V0000004', 'Jorge',    'Sánchez Vidal',     'Medicina general',  2700.00, '2020-01-20', 'CLN02'),
('V0000005', 'Marta',    'Gómez Torres',      'Oncología',         3900.00, '2016-11-05', 'CLN03'),
('V0000006', 'Pedro',    'López Castillo',    'Traumatología',     3300.00, '2017-04-22', 'CLN03'),
('V0000007', 'Elena',    'Díaz Moreno',       'Medicina general',  2850.00, '2021-02-14', 'CLN04'),
('V0000008', 'Raúl',     'Jiménez Blanco',    'Cardiología',       4100.00, '2014-08-30', 'CLN04'),
('V0000009', 'Sofía',    'Navarro Gil',       'Cirugía',           3600.00, '2018-07-17', 'CLN05'),
('V0000010', 'Iván',     'Romero Molina',     'Dermatología',      3050.00, '2022-05-03', 'CLN05');

-- ── PROPIETARIOS ────────────────────────────────────────────
INSERT INTO propietario (dni, nombre, apellidos, telefono, email, ciudad) VALUES
('11111111A', 'Laura',    'Morales Ruiz',     '600111111', 'laura.m@email.es',   'Madrid'),
('22222222B', 'Antonio',  'Herrera Díaz',     '611222222', 'aherrera@email.es',  'Madrid'),
('33333333C', 'María',    'Santos Iglesias',  '622333333', 'msantos@email.es',   'Sevilla'),
('44444444D', 'Fernando', 'Castro Vega',      '633444444', 'fcastro@email.es',   'Barcelona'),
('55555555E', 'Isabel',   'Ramos Flores',     '644555555', 'iramos@email.es',    'Bilbao'),
('66666666F', 'Pablo',    'Ortiz Serrano',    '655666666', 'portiz@email.es',    'Madrid'),
('77777777G', 'Carmen',   'Peña Cano',        '666777777', 'cpena@email.es',     'Sevilla'),
('88888888H', 'Javier',   'Aguilar Mora',     '677888888', 'jaguilar@email.es',  'Barcelona'),
('99999999I', 'Rosa',     'Medina Rubio',     '688999999', 'rmedina@email.es',   'Madrid'),
('10101010J', 'Tomás',    'Guerrero Pardo',   '699010101', 'tguerrero@email.es', 'Bilbao');

-- ── MASCOTAS ────────────────────────────────────────────────
INSERT INTO mascota (nombre, especie, raza, fecha_nac, peso_kg, esterilizado, id_propietario) VALUES
('Roco',    'Perro',  'Labrador',         '2018-04-10', 28.50, 'S', 1),
('Luna',    'Gato',   'Siamés',           '2020-01-15',  4.20, 'N', 1),
('Max',     'Perro',  'Pastor Alemán',    '2016-07-22', 32.00, 'S', 2),
('Nala',    'Gato',   'Persa',            '2019-11-03',  3.80, 'S', 3),
('Kira',    'Perro',  'Golden Retriever', '2021-03-08', 24.70, 'N', 3),
('Pico',    'Ave',    'Loro Gris',        '2017-06-14',  0.45, 'N', 4),
('Zeus',    'Perro',  'Rottweiler',       '2015-09-30', 42.00, 'S', 5),
('Mimi',    'Gato',   'Común europeo',    '2022-02-20',  3.10, 'N', 5),
('Simba',   'Perro',  'Beagle',           '2020-08-05', 11.20, 'S', 6),
('Cleo',    'Reptil', 'Iguana',           '2019-12-01',  1.80, 'N', 7),
('Toby',    'Perro',  'Bulldog Francés',  '2021-05-17',  9.50, 'N', 8),
('Lola',    'Gato',   'Maine Coon',       '2018-10-28',  6.30, 'S', 9),
('Buba',    'Perro',  'Chihuahua',        '2023-01-11',  2.20, 'N', 10),
('Nico',    'Ave',    'Canario',          '2020-04-02',  0.02, 'N', 4),
('Duna',    'Perro',  'Husky Siberiano',  '2019-06-25', 22.00, 'S', 2);

-- ── TRATAMIENTOS ────────────────────────────────────────────
INSERT INTO tratamiento VALUES
('TR0001', 'Vacuna antirrábica',        'Vacuna',      25.00, 'S'),
('TR0002', 'Vacuna polivalente canina', 'Vacuna',      35.00, 'S'),
('TR0003', 'Desparasitación interna',   'Medicamento', 18.00, 'N'),
('TR0004', 'Desparasitación externa',   'Medicamento', 15.00, 'N'),
('TR0005', 'Limpieza dental',           'Cirugia',     90.00, 'S'),
('TR0006', 'Esterilización',            'Cirugia',    180.00, 'S'),
('TR0007', 'Radiografía',               'Prueba',      60.00, 'S'),
('TR0008', 'Análisis de sangre',        'Prueba',      45.00, 'S'),
('TR0009', 'Quimioterapia sesión',      'Medicamento',200.00, 'S'),
('TR0010', 'Cura de herida',            'Medicamento', 30.00, 'N');

-- ── CONSULTAS ───────────────────────────────────────────────
INSERT INTO consulta (fecha, motivo, diagnostico, importe, pagada, id_mascota, num_colegiado) VALUES
('2023-01-10', 'Revisión anual',         'Sano',                         45.00, 'S',  1, 'V0000001'),
('2023-02-14', 'Cojera pata delantera',  'Esguince leve',                80.00, 'S',  3, 'V0000002'),
('2023-03-05', 'Pérdida de pelo',        'Dermatitis alérgica',          95.00, 'S',  4, 'V0000003'),
('2023-03-22', 'Vómitos',               'Gastroenteritis',               60.00, 'N',  5, 'V0000004'),
('2023-04-11', 'Revisión anual',         'Sano',                         45.00, 'S',  7, 'V0000005'),
('2023-04-18', 'Bulto en piel',          'Lipoma benigno',              150.00, 'S',  9, 'V0000002'),
('2023-05-02', 'Revisión anual',         'Sano',                         45.00, 'S',  2, 'V0000003'),
('2023-05-20', 'Problemas respiratorios','Bronquitis leve',              110.00, 'N',  6, 'V0000007'),
('2023-06-08', 'Cojera pata trasera',    'Displasia de cadera',         200.00, 'S',  3, 'V0000006'),
('2023-06-15', 'Revisión rutinaria',     'Sano',                         45.00, 'S', 12, 'V0000007'),
('2023-07-03', 'No come',               'Obstrucción intestinal',       320.00, 'S', 11, 'V0000008'),
('2023-07-19', 'Masa abdominal',         'Tumor maligno',               250.00, 'N', 15, 'V0000005'),
('2023-08-10', 'Revisión anual',         'Sano',                         45.00, 'S',  8, 'V0000001'),
('2023-08-25', 'Herida en pata',         'Laceración superficial',       55.00, 'S', 13, 'V0000004'),
('2023-09-14', 'Pérdida de pelo',        'Dermatitis seborreica',        85.00, 'S',  1, 'V0000003'),
('2023-09-30', 'Convulsiones',           'Epilepsia idiopática',        180.00, 'N',  7, 'V0000008'),
('2023-10-07', 'Revisión anual',         'Sano',                         45.00, 'S', 14, 'V0000007'),
('2023-10-22', 'Infección ocular',       'Conjuntivitis bacteriana',     70.00, 'S',  4, 'V0000003'),
('2023-11-05', 'Cojera generalizada',    'Artritis',                    130.00, 'S', 15, 'V0000006'),
('2023-11-18', 'Revisión anual',         'Sano',                         45.00, 'S', 10, 'V0000001'),
('2023-12-03', 'Dificultad al respirar', 'Insuficiencia cardíaca',      280.00, 'S',  9, 'V0000008'),
('2023-12-20', 'Revisión anual',         'Sano',                         45.00, 'S',  5, 'V0000004'),
('2024-01-08', 'Masa en cuello',         'Hipertiroidismo',             160.00, 'N', 12, 'V0000005'),
('2024-01-25', 'Vómitos y diarrea',      'Parvovirus',                  220.00, 'S', 13, 'V0000001'),
('2024-02-12', 'Revisión anual',         'Sano',                         45.00, 'S',  1, 'V0000001'),
('2024-02-28', 'Prurito intenso',        'Sarna sarcóptica',            115.00, 'S',  3, 'V0000003'),
('2024-03-15', 'Control postoperatorio', 'Evolución favorable',          60.00, 'S',  9, 'V0000002'),
('2024-04-02', 'Revisión anual',         'Sano',                         45.00, 'S',  2, 'V0000003'),
('2024-04-18', 'Fractura radio',         'Fractura simple',             350.00, 'S',  5, 'V0000002'),
('2024-05-07', 'Revisión anual',         'Sano',                         45.00, 'S', 11, 'V0000007');

-- ── MASCOTAS_TRATAMIENTOS ────────────────────────────────────
INSERT INTO mascota_tratamiento VALUES
(1,  'TR0001', '2023-01-10', '1 ml subcutáneo', 1),
(1,  'TR0003', '2023-01-10', '1 comprimido/mes', 1),
(3,  'TR0007', '2023-02-14', NULL, 1),
(4,  'TR0004', '2023-03-05', 'Pipeta mensual', 1),
(5,  'TR0002', '2023-03-22', '1 ml subcutáneo', 1),
(7,  'TR0001', '2023-04-11', '1 ml subcutáneo', 1),
(7,  'TR0008', '2023-04-11', NULL, 1),
(9,  'TR0005', '2023-04-18', NULL, 1),
(2,  'TR0003', '2023-05-02', '0.5 comprimido/mes', 1),
(3,  'TR0006', '2023-06-08', NULL, 1),
(11, 'TR0008', '2023-07-03', NULL, 1),
(15, 'TR0009', '2023-07-19', '200 mg IV', 4),
(13, 'TR0010', '2023-08-25', 'Cura diaria', 5),
(1,  'TR0004', '2023-09-14', 'Champú semanal', 3),
(7,  'TR0008', '2023-09-30', NULL, 1),
(4,  'TR0003', '2023-10-22', '1 comprimido/día 7 días', 1),
(15, 'TR0007', '2023-11-05', NULL, 2),
(9,  'TR0008', '2023-12-03', NULL, 1),
(12, 'TR0008', '2024-01-08', NULL, 1),
(13, 'TR0002', '2024-01-25', '1 ml subcutáneo', 1),
(1,  'TR0001', '2024-02-12', '1 ml subcutáneo', 1),
(3,  'TR0004', '2024-02-28', 'Baño semanal', 4),
(5,  'TR0007', '2024-04-18', NULL, 1),
(5,  'TR0006', '2024-04-18', NULL, 1);
