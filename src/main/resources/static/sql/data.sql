-- ===========================
--     USUARIOS (LOGIN)
-- ===========================
INSERT INTO usuario (codigo, contrasena, fecha_creacion)
VALUES
('admin01', '123456', '2025-01-01'),
('user02', 'abc123', '2025-01-02');

-- ===========================
--         CLIENTES
-- ===========================
INSERT INTO clientes (nombre, edad, fecha_registro)
VALUES
('Ana Torres', 30, '2025-01-10'),
('Luis Ramírez', 45, '2025-01-11'),
('María López', 22, '2025-01-11');

-- ===========================
--       MEDICAMENTOS
-- ===========================
INSERT INTO medicamentos (nombre, stock, fecha_registro)
VALUES
('Paracetamol', 200, '2025-01-05'),
('Ibuprofeno', 150, '2025-01-06'),
('Amoxicilina', 80, '2025-01-07');

-- ===========================
--       DEVOLUCIONES
-- ===========================
INSERT INTO devoluciones (medicamento, cantidad, fecha)
VALUES
('Paracetamol', 5, '2025-01-12'),
('Ibuprofeno', 3, '2025-01-12'),
('Amoxicilina', 1, '2025-01-13');
