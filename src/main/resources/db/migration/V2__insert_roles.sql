-- Insertar roles iniciales con mensaje temporal por definir
INSERT INTO roles (nombre_rol, descripcion) VALUES
('ADMIN', 'Definir que hace una vez terminado todos los microservicios'),
('GERENTE', 'Definir que hace una vez terminado todos los microservicios'),
('EMPLEADO', 'Definir que hace una vez terminado todos los microservicios'),
('VETERINARIO', 'Definir que hace  una vez terminado todos los microservicios'),
('CLIENTE', 'Definir que hace una vez terminado todos los microservicios');

-- Usuarios de ejemplo (con cada una de las opciones de rol)
INSERT INTO usuarios (nombre, apellido, rut, dv, email, telefono_celular, fecha_nacimiento_usuario, rol_id, activo, fecha_creacion_usuario) VALUES
('Carlos', 'Perez', '15342123', '1', 'carlos.admin@ejemplo.com', '+56912345678', '1980-01-01', 1, TRUE, CURRENT_TIMESTAMP),
('Maria', 'Gonzalez', '16453234', 'K', 'maria.gerente@ejemplo.com', '+56987654321', '1985-05-15', 2, TRUE, CURRENT_TIMESTAMP),
('Roberto', 'Diaz', '17564345', '9', 'roberto.empleado@ejemplo.com', '+56911223344', '1990-10-20', 3, TRUE, CURRENT_TIMESTAMP),
('Camila', 'Silva', '18675456', '7', 'camila.veterinario@ejemplo.com', '+56955667788', '1988-12-10', 4, TRUE, CURRENT_TIMESTAMP),
('Diego', 'Rojas', '19786567', '5', 'diego.cliente@ejemplo.com', '+56999887766', '1995-03-25', 5, TRUE, CURRENT_TIMESTAMP);
