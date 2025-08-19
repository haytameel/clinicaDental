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
