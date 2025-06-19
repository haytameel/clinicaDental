CREATE TABLE usuario (
  username VARCHAR(255) PRIMARY KEY,
  password VARCHAR(255) NOT NULL,
   rol VARCHAR(20) NOT NULL
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
