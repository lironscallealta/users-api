-- 1. Tabla Roles
CREATE TABLE roles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre_rol VARCHAR(50) NOT NULL,
    descripcion VARCHAR(255)
);

-- 2. Tabla Usuarios
CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    rut VARCHAR(22),
    dv VARCHAR(1),
    email VARCHAR(50) NOT NULL UNIQUE,
    telefono_celular VARCHAR(20),
    fecha_nacimiento_usuario DATE NOT NULL,
    rol_id BIGINT NOT NULL,
    activo BOOLEAN NOT NULL,
    fecha_creacion_usuario DATETIME NOT NULL,
    fecha_actualizacion_usuario DATETIME,
    CONSTRAINT fk_usuario_rol FOREIGN KEY (rol_id) REFERENCES roles(id)
);
