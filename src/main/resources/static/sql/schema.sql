-- ===========================
--        TABLA USUARIO
-- ===========================
CREATE TABLE usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(50) NOT NULL,
    contrasena VARCHAR(200) NOT NULL,
    fecha_creacion DATE NOT NULL
);

-- ===========================
--       TABLA CLIENTES
-- ===========================
CREATE TABLE clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    edad INT NOT NULL,
    fecha_registro DATE NOT NULL
);

-- ===========================
--     TABLA MEDICAMENTOS
-- ===========================
CREATE TABLE medicamentos (
    id_medicamento INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    stock INT NOT NULL,
    fecha_registro DATE NOT NULL
);

-- ===========================
--     TABLA DEVOLUCIONES
-- ===========================
CREATE TABLE devoluciones (
    id_devolucion INT AUTO_INCREMENT PRIMARY KEY,
    medicamento VARCHAR(100) NOT NULL,
    cantidad INT NOT NULL,
    fecha DATE NOT NULL
);