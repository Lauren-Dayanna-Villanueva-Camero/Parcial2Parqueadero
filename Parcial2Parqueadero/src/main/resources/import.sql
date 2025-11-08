-- Insertar roles del sistema
INSERT INTO rol (nombre) VALUES ('ADMINISTRADOR');
INSERT INTO rol (nombre) VALUES ('ACOMODADOR');
INSERT INTO rol (nombre) VALUES ('CLIENTE');

-- Insertar usuarios (password: "1234" para todos - encriptado con BCrypt)

-- ADMINISTRADOR
INSERT INTO usuario (username, email, password, rol_id) VALUES (
    'admin1', 
    'admin@parqueadero.com', 
    '$2a$10$kReZUnYT0LU8fbSDwJjyQOYMfzipGL/CapXzldUVMkksQKaSVhEn6', 
    1
);

-- ACOMODADOR
INSERT INTO usuario (username, email, password, rol_id) VALUES (
    'acomodador1', 
    'acomodador@parqueadero.com', 
    '$2a$10$kReZUnYT0LU8fbSDwJjyQOYMfzipGL/CapXzldUVMkksQKaSVhEn6', 
    2
);

-- CLIENTE
INSERT INTO usuario (username, email, password, rol_id) VALUES (
    'cliente1', 
    'cliente@parqueadero.com', 
    '$2a$10$kReZUnYT0LU8fbSDwJjyQOYMfzipGL/CapXzldUVMkksQKaSVhEn6', 
    3
);

-- Insertar tipos de vehículo
INSERT INTO tipo_vehiculo (nombre_tipo, descripcion) VALUES ('Automóvil', 'Vehículo de 4 ruedas para transporte personal');
INSERT INTO tipo_vehiculo (nombre_tipo, descripcion) VALUES ('Motocicleta', 'Vehículo de 2 ruedas');
INSERT INTO tipo_vehiculo (nombre_tipo, descripcion) VALUES ('Camioneta', 'Vehículo utilitario para carga');
INSERT INTO tipo_vehiculo (nombre_tipo, descripcion) VALUES ('Bicicleta', 'Vehículo de 2 ruedas sin motor');

-- Insertar acomodador
INSERT INTO acomodador (usuario_id, nombre_acomodador, turno) VALUES (
    2, 
    'Carlos Rodríguez', 
    'Mañana'
);

-- Insertar cliente
INSERT INTO cliente (usuario_id, nombre_cliente, telefono) VALUES (
    3, 
    'María González', 
    '3001234567'
);

-- Insertar registros de parqueadero de ejemplo
INSERT INTO registro_parqueadero (placa_vehiculo, hora_entrada, hora_salida, ubicacion, tipo_vehiculo_id) VALUES (
    'ABC123', 
    '2024-01-15 08:30:00', 
    '2024-01-15 12:45:00', 
    'A-1', 
    1
);

INSERT INTO registro_parqueadero (placa_vehiculo, hora_entrada, ubicacion, tipo_vehiculo_id) VALUES (
    'XYZ789', 
    '2024-01-15 09:15:00', 
    'B-2', 
    2
);

INSERT INTO registro_parqueadero (placa_vehiculo, hora_entrada, hora_salida, ubicacion, tipo_vehiculo_id) VALUES (
    'DEF456', 
    '2024-01-15 10:00:00', 
    '2024-01-15 11:30:00', 
    'C-3', 
    1
);

INSERT INTO registro_parqueadero (placa_vehiculo, hora_entrada, ubicacion, tipo_vehiculo_id) VALUES (
    'GHI789', 
    '2024-01-15 14:20:00', 
    'A-4', 
    3
);

INSERT INTO registro_parqueadero (placa_vehiculo, hora_entrada, hora_salida, ubicacion, tipo_vehiculo_id) VALUES (
    'JKL012', 
    '2024-01-15 07:45:00', 
    '2024-01-15 17:30:00', 
    'B-5', 
    1
);