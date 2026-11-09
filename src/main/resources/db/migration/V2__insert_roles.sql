INSERT INTO roles (nombre_rol, descripcion) VALUES
('Administrador', 'Acceso total al sistema, gestión de usuarios, permisos, configuraciones globales y auditoría de todos los módulos.'),
('Gerente', 'Supervisión general, acceso a reportes de ventas, administración de inventario, gestión de personal y métricas del negocio.'),
('Empleado', 'Atención al público, procesamiento de ventas en tienda, manejo de caja, recepción y agendamiento de citas médicas.'),
('Veterinario', 'Gestión de consultas, creación y acceso a historiales clínicos de pacientes, emisión de recetas y registro de diagnósticos.'),
('Cliente', 'Acceso al portal personal para gestionar el perfil de sus mascotas, revisar historial de compras, recetas y reservar citas.');

INSERT INTO usuarios (nombre, apellido, rut, dv, email, telefono_celular, fecha_nacimiento_usuario, rol_id, activo, fecha_creacion_usuario) VALUES
('Alan', 'Brito', '15342123', '1', 'alanbrito@duocuc.cl', '+56912345678', '1980-01-01', 1, TRUE, CURRENT_TIMESTAMP),
('Susana', 'Oria', '16453234', 'K', 'susanaoria@duocuc.cl', '+56987654321', '1985-05-15', 5, TRUE, CURRENT_TIMESTAMP),
('Roberto', 'Diaz', '17564345', '9', 'roberto.empleado@ejemplo.com', '+56911223344', '1990-10-20', 3, TRUE, CURRENT_TIMESTAMP),
('Camila', 'Silva', '18675456', '7', 'camila.veterinario@ejemplo.com', '+56955667788', '1988-12-10', 4, TRUE, CURRENT_TIMESTAMP),
('Diego', 'Rojas', '19786567', '5', 'diego.gerente@ejemplo.com', '+56999887766', '1995-03-25', 2, TRUE, CURRENT_TIMESTAMP);
