DROP TABLE IF EXISTS PACIENTE;
DROP TABLE IF EXISTS USUARIO;


CREATE TABLE usuario (
  username VARCHAR(255) PRIMARY KEY,
  password VARCHAR(255) NOT NULL,
   rol VARCHAR(20) NOT NULL
);


CREATE TABLE paciente (
    id VARCHAR(20) PRIMARY KEY, --dni
    username VARCHAR(50) UNIQUE NOT NULL,
    nombre VARCHAR(100),
    apellidos VARCHAR(150),
    email VARCHAR(150),
    genero CHAR(1) CHECK (genero IN ('F','M')),
    telefono VARCHAR(20),
    fecha_nacimiento DATE,
    direccion VARCHAR(255),
    codigo_postal VARCHAR(10),
    seguro_dental BOOLEAN,
    num_seguro VARCHAR(255),
    notas VARCHAR(255),
    FOREIGN KEY (username) REFERENCES usuario(username) ON DELETE CASCADE
);

CREATE TABLE peticion_cita (
                               id SERIAL PRIMARY KEY,
                               username VARCHAR(255) NOT NULL,
                               fecha DATE NOT NULL,
                               hora TIME NOT NULL,
                               hora_fin TIME NOT NULL,
                               tipo VARCHAR(50) NOT NULL,
                               estado VARCHAR(50) NOT NULL,
                               notas TEXT
);


/* password es 123456*/
INSERT INTO usuario (username, password, rol) VALUES
('paciente1', '$2a$10$7QJ5eFDdlLZsRyE5ZlhXsu9zVkYzPv9MQ0zld4UtlrJjVtiQk3FvC', 'PACIENTE'),
('paciente2', '$2a$10$7QJ5eFDdlLZsRyE5ZlhXsu9zVkYzPv9MQ0zld4UtlrJjVtiQk3FvC', 'PACIENTE'),
('paciente3', '$2a$10$7QJ5eFDdlLZsRyE5ZlhXsu9zVkYzPv9MQ0zld4UtlrJjVtiQk3FvC', 'PACIENTE'),
('personal1', '$2a$10$7QJ5eFDdlLZsRyE5ZlhXsu9zVkYzPv9MQ0zld4UtlrJjVtiQk3FvC', 'PERSONAL'),
('personal2', '$2a$10$7QJ5eFDdlLZsRyE5ZlhXsu9zVkYzPv9MQ0zld4UtlrJjVtiQk3FvC', 'PERSONAL'),
('personal3', '$2a$10$7QJ5eFDdlLZsRyE5ZlhXsu9zVkYzPv9MQ0zld4UtlrJjVtiQk3FvC', 'PERSONAL'),
('admin1', '$2a$10$7QJ5eFDdlLZsRyE5ZlhXsu9zVkYzPv9MQ0zld4UtlrJjVtiQk3FvC', 'ADMIN'),
('admin2', '$2a$10$7QJ5eFDdlLZsRyE5ZlhXsu9zVkYzPv9MQ0zld4UtlrJjVtiQk3FvC', 'ADMIN'),
('admin3', '$2a$10$7QJ5eFDdlLZsRyE5ZlhXsu9zVkYzPv9MQ0zld4UtlrJjVtiQk3FvC', 'ADMIN');




INSERT INTO paciente (id, username, nombre, apellidos, email, telefono, genero, fecha_nacimiento, direccion, codigo_postal, seguro_dental, num_seguro, notas) VALUES
('11111111A', 'paciente', 'Ana', 'García López', 'ana@example.com', '600111111', 'F', '1990-01-15', 'Calle Falsa 123', '28001', TRUE, 'SD12345', 'Alergia a penicilina'),
('22222222B', 'paciente1', 'Juan', 'Pérez Martínez', 'juan@example.com', '600222222', 'M', '1985-05-30', 'Calle Real 45', '28002', FALSE, NULL, 'Observación: hipertensión'),
('33333333C', 'paciente2', 'María', 'Rodríguez Díaz', 'maria@example.com', '600333333', 'F', '1992-07-20', 'Av. Central 10', '28003', TRUE, 'SD67890', 'Alergia al látex'),
('44444444D', 'paciente3', 'Carlos', 'Sánchez Torres', 'carlos@example.com', '600444444', 'M', '1988-12-10', 'Plaza Mayor 5', '28004', FALSE, NULL, 'Observación: necesita revisión ortodóntica');