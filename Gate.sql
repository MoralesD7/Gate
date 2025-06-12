CREATE DATABASE IF NOT EXISTS Gate;
USE Gate;


CREATE TABLE M_Alumno (
    M_alu_id INT UNSIGNED AUTO_INCREMENT,
    M_alu_nombre VARCHAR(30) NOT NULL,
    M_alu_apellido VARCHAR(35) NOT NULL,
    M_alu_email VARCHAR(35) NOT NULL,
    PRIMARY KEY (M_alu_id)
);
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE M_Alumno;
TRUNCATE TABLE E_Token;
SET FOREIGN_KEY_CHECKS = 1;

ALTER TABLE M_Alumno
ADD COLUMN M_alu_matricula VARCHAR(15) NOT NULL UNIQUE AFTER M_alu_id;
DESCRIBE M_alumno;
SELECT * FROM M_Alumno;


CREATE TABLE E_Token (
    E_tok_id INT UNSIGNED AUTO_INCREMENT,
    E_tok_token VARCHAR(30),
    M_alu_id INT UNSIGNED NOT NULL UNIQUE,
    PRIMARY KEY (E_tok_id),
    CONSTRAINT fk_token_alumno FOREIGN KEY (M_alu_id) REFERENCES M_Alumno(M_alu_id)
);
SELECT * FROM E_Token;

CREATE TABLE D_Horario (
    C_hor_id INT UNSIGNED AUTO_INCREMENT,
    C_hor_materia VARCHAR(30),
    C_hor_hora TIME,
    M_alu_id INT UNSIGNED NOT NULL UNIQUE,
    PRIMARY KEY (C_hor_id),
    CONSTRAINT fk_horario_alumno FOREIGN KEY (M_alu_id) REFERENCES M_Alumno(M_alu_id)
);

CREATE TABLE E_Calendario (
    E_cal_id INT UNSIGNED AUTO_INCREMENT,
    E_cal_nombre_cita VARCHAR(30),
    M_alu_id INT UNSIGNED NOT NULL UNIQUE,
    PRIMARY KEY (E_cal_id),
    CONSTRAINT fk_calendario_alumno FOREIGN KEY (M_alu_id) REFERENCES M_Alumno(M_alu_id)
);

CREATE TABLE D_Calendario (
    D_cal_id INT UNSIGNED AUTO_INCREMENT,
    D_cal_descripcion VARCHAR(200),
    D_cal_fecha DATE,
    E_cal_id INT UNSIGNED NOT NULL UNIQUE,
    PRIMARY KEY (D_cal_id),
    CONSTRAINT fk_detalle_calendario FOREIGN KEY (E_cal_id) REFERENCES E_Calendario(E_cal_id)
);

CREATE TABLE E_Tarea (
    E_tar_id INT UNSIGNED AUTO_INCREMENT,
    E_tar_nombre VARCHAR(20),
    M_alu_id INT UNSIGNED NOT NULL UNIQUE,
    PRIMARY KEY (E_tar_id),
    CONSTRAINT fk_tarea_alumno FOREIGN KEY (M_alu_id) REFERENCES M_Alumno(M_alu_id)
);

CREATE TABLE C_Tarea (
    C_tar_id INT UNSIGNED AUTO_INCREMENT,
    C_tar_prioridad INT,
    E_tar_id INT UNSIGNED NOT NULL UNIQUE,
    PRIMARY KEY (C_tar_id),
    CONSTRAINT fk_prioridad_tarea FOREIGN KEY (E_tar_id) REFERENCES E_Tarea(E_tar_id)
);

CREATE TABLE D_Tarea (
    D_tar_id INT UNSIGNED AUTO_INCREMENT,
    D_tar_descripcion VARCHAR(300),
    D_tar_fecha_asignacion DATE,
    D_tar_finalizacion DATE,
    E_tar_id INT UNSIGNED NOT NULL UNIQUE,
    PRIMARY KEY (D_tar_id),
    CONSTRAINT fk_detalle_tarea FOREIGN KEY (E_tar_id) REFERENCES E_Tarea(E_tar_id)
);
