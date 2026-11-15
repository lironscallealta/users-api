CREATE TABLE columns_metadata (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    table_name VARCHAR(64) NOT NULL,
    column_name VARCHAR(64) NOT NULL,
    api_key VARCHAR(64) NOT NULL,
    label VARCHAR(100) NOT NULL,
    type VARCHAR(20) NOT NULL,
    sort_order INT NOT NULL DEFAULT 0,
    show_in_create BOOLEAN NOT NULL DEFAULT TRUE,
    show_in_edit BOOLEAN NOT NULL DEFAULT TRUE,
    required BOOLEAN NOT NULL DEFAULT FALSE,
    is_read_only BOOLEAN NOT NULL DEFAULT FALSE,
    is_searchable BOOLEAN NOT NULL DEFAULT FALSE,
    is_hidden BOOLEAN NOT NULL DEFAULT FALSE,
    highlight BOOLEAN NOT NULL DEFAULT FALSE,
    is_state BOOLEAN NOT NULL DEFAULT FALSE,
    CONSTRAINT uk_columns_metadata_table_api_key UNIQUE (table_name, api_key)
);

ALTER TABLE usuarios ADD COLUMN ultimo_login DATETIME NULL AFTER fecha_actualizacion_usuario;

INSERT INTO columns_metadata (
    table_name,
    column_name,
    api_key,
    label,
    type,
    sort_order,
    show_in_create,
    show_in_edit,
    required,
    is_read_only,
    is_searchable,
    is_hidden,
    highlight,
    is_state
) VALUES
('usuarios', 'id', 'id', 'ID', 'string', 1, FALSE, FALSE, FALSE, TRUE, FALSE, TRUE, FALSE, FALSE),
('usuarios', 'nombre', 'nombre', 'Nombre', 'string', 2, TRUE, TRUE, TRUE, FALSE, TRUE, FALSE, TRUE, FALSE),
('usuarios', 'apellido', 'apellido', 'Apellido', 'string', 3, TRUE, TRUE, TRUE, FALSE, TRUE, TRUE, FALSE, FALSE),
('usuarios', 'rut', 'rut', 'RUT', 'string', 4, TRUE, TRUE, TRUE, FALSE, TRUE, TRUE, FALSE, FALSE),
('usuarios', 'dv', 'dv', 'DV', 'string', 5, TRUE, TRUE, TRUE, FALSE, FALSE, TRUE, FALSE, FALSE),
('usuarios', 'email', 'email', 'Correo', 'email', 6, TRUE, TRUE, TRUE, FALSE, TRUE, FALSE, FALSE, FALSE),
('usuarios', 'telefono_celular', 'telefonoCelular', 'Teléfono', 'string', 7, TRUE, TRUE, FALSE, FALSE, FALSE, TRUE, FALSE, FALSE),
('usuarios', 'fecha_nacimiento_usuario', 'fechaNacimiento', 'Fecha de nacimiento', 'date', 8, TRUE, TRUE, FALSE, FALSE, FALSE, TRUE, FALSE, FALSE),
('usuarios', 'rol_id', 'rol', 'Rol', 'string', 9, TRUE, TRUE, TRUE, FALSE, TRUE, FALSE, FALSE, FALSE),
('usuarios', 'departamento', 'departamento', 'Departamento', 'string', 10, TRUE, TRUE, FALSE, FALSE, TRUE, FALSE, FALSE, FALSE),
('usuarios', 'estado_id', 'estado', 'Estado', 'string', 11, TRUE, TRUE, TRUE, FALSE, FALSE, FALSE, FALSE, TRUE),
('usuarios', 'ultimo_login', 'ultimoLogin', 'Último ingreso', 'timestamp', 12, FALSE, FALSE, FALSE, TRUE, FALSE, FALSE, FALSE, FALSE);
