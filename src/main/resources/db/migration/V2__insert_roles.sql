-- Insertar roles iniciales con mensaje temporal por definir
INSERT INTO roles (nombre_rol, descripcion) VALUES
('ADMIN', 'Definir que hace una vez terminado todos los microservicios'),
('GERENTE', 'Definir que hace una vez terminado todos los microservicios'),
('EMPLEADO', 'Definir que hace una vez terminado todos los microservicios'),
('VETERINARIO', 'Definir que hace  una vez terminado todos los microservicios'),
('CLIENTE', 'Definir que hace una vez terminado todos los microservicios');

-- Usuarios de ejemplo (con cada una de las opciones de rol)
INSERT INTO usuarios (nombre, apellido, rut, dv, email, telefono_celular, fecha_nacimiento_usuario, rol_id, activo, fecha_creacion_usuario) VALUES
('Admin', 'Ejemplo', '11111111', '1', 'admin@ejemplo.com', '+56911111111', '1980-01-01', 1, TRUE, CURRENT_TIMESTAMP),
('Gerente', 'Ejemplo', '22222222', '2', 'gerente@ejemplo.com', '+56922222222', '1985-05-15', 2, TRUE, CURRENT_TIMESTAMP),
('Empleado', 'Ejemplo', '33333333', '3', 'empleado@ejemplo.com', '+56933333333', '1990-10-20', 3, TRUE, CURRENT_TIMESTAMP),
('Veterinario', 'Ejemplo', '44444444', '4', 'veterinario@ejemplo.com', '+56944444444', '1988-12-10', 4, TRUE, CURRENT_TIMESTAMP),
('Cliente', 'Ejemplo', '55555555', '5', 'cliente@ejemplo.com', '+56955555555', '1995-03-25', 5, TRUE, CURRENT_TIMESTAMP);
