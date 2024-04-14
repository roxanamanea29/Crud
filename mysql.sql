-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS tarea;

-- Seleccionar la base de datos
USE tarea;

CREATE TABLE Tarea (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    descripcion TEXT,
    realizada VARCHAR(50),
    prioridad VARCHAR(50)
);

-- Insertar una nueva tarea
INSERT INTO Tarea (nombre, descripcion, realizada, prioridad)
VALUES ('Completar informe', 'Terminar el informe mensual de ventas', 'Sí', 'Alta');

-- Insertar otra tarea
INSERT INTO Tarea (nombre, descripcion, realizada, prioridad)
VALUES ('Revisar correo electrónico', 'Revisar y responder correos electrónicos pendientes', 'No', 'Media');

-- Puedes seguir insertando más tareas según sea necesario
-- Insertar una nueva tarea
INSERT INTO Tarea (nombre, descripcion, realizada, prioridad)
VALUES ('Completar informe', 'Terminar el informe mensual de ventas', 'Sí', 'Alta');

-- Insertar otra tarea
INSERT INTO Tarea (nombre, descripcion, realizada, prioridad)
VALUES ('Revisar correo electrónico', 'Revisar y responder correos electrónicos pendientes', 'No', 'Media');

-- Puedes seguir insertando más tareas según sea necesario
