INSERT INTO estados_usuario (nombre, descripcion) VALUES
('activo', 'Usuario habilitado para ingresar y operar en el sistema.'),
('inactivo', 'Usuario deshabilitado sin acceso al sistema.'),
('pendiente', 'Usuario en proceso de contratación, aún sin acceso.');

INSERT INTO roles (nombre_rol, nombre_mostrar, icon, descripcion) VALUES
('Administrador', 'Administradores', '🐕', 'Acceso total al sistema, gestión de usuarios, permisos, configuraciones globales y auditoría de todos los módulos.'),
('Gerente', 'Gerentes', '🐦', 'Supervisión general, acceso a reportes de ventas, administración de inventario, gestión de personal y métricas del negocio.'),
('Empleado', 'Empleados', '🐈', 'Atención al público, procesamiento de ventas en tienda, manejo de caja, recepción y agendamiento de citas médicas.'),
('Veterinario', 'Veterinarios', '🐹', 'Gestión de consultas, creación y acceso a historiales clínicos de pacientes, emisión de recetas y registro de diagnósticos.'),
('Cliente', 'Clientes', '👤', 'Acceso al portal personal para gestionar el perfil de sus mascotas, revisar historial de compras, recetas y reservar citas.');

INSERT INTO usuarios (nombre, apellido, rut, dv, email, telefono_celular, fecha_nacimiento_usuario, rol_id, estado_id, fecha_creacion_usuario) VALUES
('Alan', 'Brito', '15342123', '1', 'alanbrito@duocuc.cl', '+56912345678', '1980-01-01', 1, 1, CURRENT_TIMESTAMP),
('Susana', 'Oria', '16453234', 'K', 'susanaoria@duocuc.cl', '+56987654321', '1985-05-15', 5, 1, CURRENT_TIMESTAMP),
('Roberto', 'Diaz', '17564345', '9', 'roberto.empleado@ejemplo.com', '+56911223344', '1990-10-20', 3, 1, CURRENT_TIMESTAMP),
('Camila', 'Silva', '18675456', '7', 'camila.veterinario@ejemplo.com', '+56955667788', '1988-12-10', 4, 1, CURRENT_TIMESTAMP),
('Diego', 'Rojas', '19786567', '5', 'diego.gerente@ejemplo.com', '+56999887766', '1995-03-25', 2, 1, CURRENT_TIMESTAMP);
