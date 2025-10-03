-- Crear la base de datos
CREATE DATABASE productos_db;

-- Conectarse a la base de datos
\c productos_db

-- COMANDOS PARA CREAR TABLA PARA EL LAB3

-- Creacion de la tabla usuarios con las columnas del Usuario.java
CREATE TABLE usuarios (
                          id BIGSERIAL PRIMARY KEY,
                          nombre VARCHAR(255) NOT NULL,
                          email VARCHAR(255) NOT NULL UNIQUE,
                          rol VARCHAR(255) NOT NULL,
                          password VARCHAR(255) NOT NULL
);

-- Inserta un usuario administrador inicial para poder iniciar sesión
-- Se usa estos datos en el primer login
INSERT INTO usuarios (nombre, email, rol, password) VALUES
    ('Administrador Principal', 'admin@abc.com', 'admin', 'admin123');
('Juan Perez', 'juan.perez@email.com', 'usuario', 'juan123'),
('Maria Garcia', 'maria.garcia@email.com', 'usuario', 'maria123');


-- ESTO ES DE LAS CLASES... OMITIR ESTO PORFA
-- Crear la tabla de productos
CREATE TABLE productos (
                           id SERIAL PRIMARY KEY,
                           nombre VARCHAR(255) NOT NULL,
                           descripcion TEXT,
                           precio NUMERIC(10, 2) NOT NULL,
                           stock INTEGER DEFAULT 0
);

-- Insertar algunos datos de prueba
INSERT INTO productos (nombre, descripcion, precio, stock) VALUES
                                                               ('Laptop HP', 'Laptop HP Pavilion 15 pulgadas, 8GB RAM, 512GB SSD', 899.99, 10),
                                                               ('Monitor LG', 'Monitor LG 24 pulgadas Full HD', 199.99, 15),
                                                               ('Teclado Mecánico', 'Teclado mecánico RGB retroiluminado', 79.99, 20),
                                                               ('Mouse Logitech', 'Mouse inalámbrico Logitech con sensor láser', 29.99, 30),
                                                               ('Impresora Epson', 'Impresora multifuncional Epson EcoTank', 299.99, 5);