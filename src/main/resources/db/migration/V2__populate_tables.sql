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

INSERT INTO usuarios (nombre, apellido, rut, dv, email, telefono_celular, departamento, fecha_nacimiento_usuario, rol_id, estado_id, fecha_creacion_usuario) VALUES
('Alan', 'Brito', '15342123', '1', 'alanbrito@duocuc.cl', '+56912345678', 'IT', '1980-01-01', 1, 1, CURRENT_TIMESTAMP),
('Susana', 'Oria', '16453234', 'K', 'susanaoria@duocuc.cl', '+56987654321', NULL, '1985-05-15', 5, 1, CURRENT_TIMESTAMP),
('Roberto', 'Diaz', '17564345', '9', 'roberto.empleado@ejemplo.com', '+56911223344', 'Ventas', '1990-10-20', 3, 1, CURRENT_TIMESTAMP),
('Camila', 'Silva', '18675456', '7', 'camila.veterinario@ejemplo.com', '+56955667788', 'Operaciones', '1988-12-10', 4, 1, CURRENT_TIMESTAMP),
('Diego', 'Rojas', '19786567', '5', 'diego.gerente@ejemplo.com', '+56999887766', 'Comercial', '1995-03-25', 2, 1, CURRENT_TIMESTAMP),
('Valentina', 'Muñoz', '14892341', '5', 'valentina.munoz@correo.cl', '+56922334455', NULL, '1992-07-14', 5, 1, CURRENT_TIMESTAMP),
('Matías', 'González', '18234567', '2', 'matias.gonzalez@correo.cl', '+56933445566', NULL, '1989-11-03', 5, 1, CURRENT_TIMESTAMP),
('Fernanda', 'Soto', '19345678', '0', 'fernanda.soto@correo.cl', '+56944556677', NULL, '1996-02-28', 5, 1, CURRENT_TIMESTAMP),
('Sebastián', 'Contreras', '16789012', '8', 'sebastian.contreras@correo.cl', '+56955443322', NULL, '1984-09-19', 5, 1, CURRENT_TIMESTAMP),
('Javiera', 'Silva', '20123456', '3', 'javiera.silva@correo.cl', '+56966554433', NULL, '1998-04-12', 5, 1, CURRENT_TIMESTAMP),
('Cristóbal', 'Sepúlveda', '15987654', 'K', 'cristobal.sepulveda@correo.cl', '+56977665544', NULL, '1982-06-30', 5, 1, CURRENT_TIMESTAMP),
('Constanza', 'Morales', '17890123', '6', 'constanza.morales@correo.cl', '+56988776655', NULL, '1991-08-22', 5, 1, CURRENT_TIMESTAMP),
('Felipe', 'Vargas', '13456789', '4', 'felipe.vargas@correo.cl', '+56999001122', NULL, '1978-12-05', 5, 1, CURRENT_TIMESTAMP),
('Daniela', 'Castro', '18901234', '1', 'daniela.castro@correo.cl', '+56911002233', NULL, '1994-01-17', 5, 1, CURRENT_TIMESTAMP),
('Nicolás', 'Herrera', '16123987', '7', 'nicolas.herrera@correo.cl', '+56922113344', NULL, '1987-03-09', 5, 1, CURRENT_TIMESTAMP),
('Catalina', 'Flores', '20456789', '9', 'catalina.flores@correo.cl', '+56933224455', NULL, '2000-10-11', 5, 1, CURRENT_TIMESTAMP),
('Ignacio', 'Reyes', '14567123', '2', 'ignacio.reyes@correo.cl', '+56944335566', NULL, '1981-05-24', 5, 1, CURRENT_TIMESTAMP),
('Paula', 'Gutiérrez', '17234890', '5', 'paula.gutierrez@correo.cl', '+56955446677', NULL, '1993-07-08', 5, 1, CURRENT_TIMESTAMP),
('Tomás', 'Araya', '19654321', '8', 'tomas.araya@correo.cl', '+56966557788', NULL, '1997-11-29', 5, 1, CURRENT_TIMESTAMP),
('Bárbara', 'Tapia', '15432987', '0', 'barbara.tapia@correo.cl', '+56977668899', NULL, '1983-02-14', 5, 2, CURRENT_TIMESTAMP),
('Gonzalo', 'Molina', '16876543', 'K', 'gonzalo.molina@correo.cl', '+56988779900', NULL, '1986-06-18', 5, 2, CURRENT_TIMESTAMP),
('Francisca', 'Ortiz', '18345987', '3', 'francisca.ortiz@correo.cl', '+56999880011', NULL, '1990-09-02', 5, 2, CURRENT_TIMESTAMP),
('Rodrigo', 'Paredes', '12987654', '6', 'rodrigo.paredes@correo.cl', '+56911220033', NULL, '1975-04-27', 5, 2, CURRENT_TIMESTAMP),
('Lorena', 'Salazar', '17654987', '4', 'lorena.salazar@correo.cl', '+56922331144', NULL, '1992-12-19', 5, 3, CURRENT_TIMESTAMP),
('Andrés', 'Navarro', '19123876', '1', 'andres.navarro@correo.cl', '+56933442255', NULL, '1995-08-06', 5, 3, CURRENT_TIMESTAMP),
('Marcela', 'Pizarro', '14321654', '7', 'marcela.empleado@ejemplo.com', '+56944553366', 'Ventas', '1985-03-15', 3, 2, CURRENT_TIMESTAMP),
('Patricio', 'Fuentes', '16543876', '9', 'patricio.veterinario@ejemplo.com', '+56955664477', 'Clínica', '1988-07-21', 4, 2, CURRENT_TIMESTAMP),
('Alejandra', 'Campos', '18765234', '2', 'alejandra.gerente@ejemplo.com', '+56966775588', 'Administración', '1991-10-30', 2, 2, CURRENT_TIMESTAMP),
('Benjamín', 'Valdés', '20789456', '5', 'benjamin.empleado@ejemplo.com', '+56977886699', 'Recepción', '2001-01-12', 3, 3, CURRENT_TIMESTAMP),
('Sofía', 'Carrasco', '19876123', 'K', 'sofia.veterinario@ejemplo.com', '+56988997700', 'Cirugía', '1996-05-04', 4, 3, CURRENT_TIMESTAMP),
('Ricardo', 'Figueroa', '15123789', '8', 'ricardo.admin@ejemplo.com', '+56999008811', 'IT', '1982-11-16', 1, 3, CURRENT_TIMESTAMP);
