CREATE DATABASE IF NOT EXISTS Gate;
USE Gate;
-- ============================
-- Tabla principal: M_Alumno validado
-- ============================
CREATE TABLE M_Alumno (
    M_alu_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    M_alu_matricula VARCHAR(15) NOT NULL UNIQUE,
    M_alu_nombre VARCHAR(20) NOT NULL,
    M_alu_apellido VARCHAR(25) NOT NULL,
    M_alu_email VARCHAR(30) NOT NULL
);
SELECT * FROM M_Alumno WHERE M_alu_email='breakboy046@gmail.com';
SELECT * FROM M_Alumno;
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE M_Alumno;
TRUNCATE TABLE E_Token;
SET FOREIGN_KEY_CHECKS = 1;
-- ============================
-- Tabla: Token (relación 1 a 1 con M_Alumno) validado
-- ============================
CREATE TABLE E_Token (
    E_tok_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    E_tok_token VARCHAR(15),
    M_alu_id INT UNSIGNED UNIQUE,
    FOREIGN KEY (M_alu_id) REFERENCES M_Alumno(M_alu_id)
);
SELECT * FROM Token;
DROP TABLE Token;


-- ============================
-- Tabla: E_Horario (relación 1:1 con M_Alumno) validado
-- ============================
CREATE TABLE E_Horario (
    E_hor_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    E_hor_hora_inicial TIME NOT NULL,
    E_hor_hora_termino TIME NOT NULL,
    M_alu_id INT UNSIGNED NOT NULL UNIQUE,
    FOREIGN KEY (M_alu_id) REFERENCES M_Alumno(M_alu_id)
);
-- ============================
-- Tabla: E_Dia (relación N:1 con E_Horario) validado
-- ============================

CREATE TABLE E_Dia(
	E_dia_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    E_dia_dia VARCHAR (10) ,
    E_hor_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (E_hor_id) REFERENCES E_Horario(E_hor_id)
);
-- ============================
-- Tabla: E_Materia (relación N:1 con E_Dia) validado
-- ============================
CREATE TABLE E_Materia (
    E_mat_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    E_mat_nombre_materia VARCHAR(25) NOT NULL,
    E_mat_hora_inicio_materia TIME NOT NULL,
    E_mat_hora_final_materia TIME NOT NULL,
    E_mat_salon VARCHAR(25) NOT NULL,
    E_dia_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (E_dia_id) REFERENCES E_Dia(E_dia_id)
);
-- ============================
-- Tabla: E_Evento (relación N:1 con M_Alumno) validado
-- ============================
CREATE TABLE E_evento (
    E_eve_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    E_eve_nombre_cita VARCHAR(20),
    E_eve_descripcion VARCHAR(50),
    E_eve_fecha DATE NOT NULL,
    M_alu_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (M_alu_id) REFERENCES M_Alumno(M_alu_id)
);

-- ============================
-- Tabla: E_Tarea (relación N:1 con M_Alumno) validado
-- ============================
CREATE TABLE E_Tarea (
    E_tar_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    E_tar_nom_tar VARCHAR(20),
    M_alu_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (M_alu_id) REFERENCES M_Alumno(M_alu_id)
);

-- ============================
-- Tabla: C_Tarea (relación 1 a 1 con E_Tarea) validado
-- ============================
CREATE TABLE C_Tarea (
    C_tar_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    C_tar_prioridad VARCHAR(10),
    E_tar_id INT UNSIGNED UNIQUE,
    FOREIGN KEY (E_tar_id) REFERENCES E_Tarea(E_tar_id)
);

-- ============================
-- Tabla: D_Tarea (relación 1 a 1 con E_Tarea) validado
-- ============================
CREATE TABLE D_Tarea (
    D_tar_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    D_tar_descripcion VARCHAR(300),
    D_tar_fecha_asignacion DATE,
    D_tar_fecha_finalizacion DATE,
    E_tar_id INT UNSIGNED UNIQUE,
    FOREIGN KEY (E_tar_id) REFERENCES E_Tarea(E_tar_id)
);
