DROP TABLE IF EXISTS machine_services;
DROP TABLE IF EXISTS machines;
CREATE TABLE machines (
    id BIGINT AUTO_INCREMENT PRIMARY KEY, -- Identificador único
    name VARCHAR(255) NOT NULL,           -- Nombre de la máquina
    description TEXT,                     -- Descripción de la máquina
    state VARCHAR(50) NOT NULL, -- Estado actual
    type VARCHAR(255) NOT NULL,  --typo de maquina
    last_service DATE,                    -- Fecha del último mantenimiento realizado
    service_interval INT,                 -- Intervalo de mantenimiento en días
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Fecha de creación
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- Fecha de actualización
);

CREATE TABLE machine_services (
    id BIGINT AUTO_INCREMENT PRIMARY KEY, -- Identificador único
    machine_id BIGINT NOT NULL,           -- Identificador de la máquina asociada
    date DATE NOT NULL,                   -- Fecha del servicio
    description TEXT,                     -- Descripción del servicio realizado
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Fecha de creación
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- Fecha de actualización
    CONSTRAINT fk_machine FOREIGN KEY (machine_id) REFERENCES machines(id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO machines (name, description, state, type, last_service, service_interval) VALUES
('Treadmill', 'Máquina para correr, con velocidad y inclinación ajustables', 'Disponible', 'caminadora', '2024-01-01', 180),
('Stationary Bike', 'Bicicleta estática con control de resistencia', 'Ocupada', 'bicicleta', '2023-12-15', 120),
('Rowing Machine', 'Máquina de remo para ejercicios de cuerpo completo', 'En Mantenimiento', 'remo', '2024-01-05', 90),
('Elliptical Trainer', 'Máquina de entrenamiento elíptico, para bajo impacto en las articulaciones', 'Disponible', 'elíptica', '2023-11-20', 150),
('Leg Press', 'Máquina para el entrenamiento de las piernas, usando pesas ajustables', 'Ocupada', 'pesas', '2023-10-01', 180),
('Cable Machine', 'Máquina para ejercicios de tracción con poleas', 'En Mantenimiento', 'pesas', '2023-09-25', 120),
('Smith Machine', 'Máquina para ejercicios de levantamiento de pesas con barra guiada', 'Disponible', 'pesas', '2023-12-10', 180),
('Chest Press', 'Máquina para press de pecho, con pesos ajustables', 'Ocupada', 'pesas', '2023-08-15', 180),
('Lat Pulldown', 'Máquina para ejercicios de tracción vertical', 'En Mantenimiento', 'pesas', '2023-07-10', 120),
('Leg Curl', 'Máquina para entrenar los músculos isquiotibiales', 'Disponible', 'pesas', '2023-11-01', 150),
('Seated Row', 'Máquina para trabajar los músculos de la espalda', 'Ocupada', 'pesas', '2023-09-05', 120),
('Ab Crunch Machine', 'Máquina para abdominales, con resistencia ajustable', 'Disponible', 'pesas', '2024-01-02', 180),
('Hack Squat', 'Máquina para sentadillas con pesos ajustables', 'Ocupada', 'pesas', '2023-10-10', 180),
('Seated Leg Press', 'Máquina de press de piernas en posición sentada', 'Disponible', 'pesas', '2023-11-15', 180),
('Incline Bench Press', 'Banca para press de banca en inclinación', 'En Mantenimiento', 'banco', '2023-08-20', 120),
('Stepper', 'Máquina de escaleras para ejercicios cardiovasculares', 'Disponible', 'cardio', '2023-12-01', 150),
('Multi-Gym', 'Máquina de ejercicios multiusos con varios puntos de tracción', 'Ocupada', 'multiuso', '2023-07-25', 180),
('Fitness Bike', 'Bicicleta de spinning para entrenamientos intensivos', 'En Mantenimiento', 'bicicleta', '2023-11-30', 120),
('Rowing Machine 2', 'Máquina de remo con resistencia ajustable', 'Disponible', 'remo', '2023-10-05', 90),
('Incline Treadmill', 'Cinta de correr con inclinación automática', 'Disponible', 'caminadora', '2023-12-20', 180);


INSERT INTO machine_services (machine_id, date, description) VALUES
(1, '2024-01-01', 'Mantenimiento general, revisión del motor y lubricación de piezas móviles'),
(2, '2023-12-15', 'Revisión de sistema de resistencia y calibración de sensores de velocidad'),
(3, '2024-01-05', 'Inspección de correas, ajuste de resistencia y calibración del monitor'),
(4, '2023-11-20', 'Reemplazo de correas y revisión del sistema electrónico'),
(5, '2023-10-01', 'Inspección de sistema hidráulico, cambio de aceites y ajuste de presión'),
(6, '2023-09-25', 'Revisión de sistema de poleas y ajuste de cables de tracción'),
(7, '2023-12-10', 'Inspección y limpieza del sistema de guía de la barra'),
(8, '2023-08-15', 'Revisión de sistema hidráulico y ajuste de resistencia'),
(9, '2023-07-10', 'Reemplazo de cables de tracción y ajuste de poleas'),
(10, '2023-11-01', 'Lubricación de piezas móviles y revisión de la estructura'),
(11, '2023-09-05', 'Inspección de los rodillos y limpieza del sistema de tracción'),
(12, '2024-01-02', 'Mantenimiento preventivo, revisión de estructuras y piezas de desgaste'),
(13, '2023-10-10', 'Inspección de los mecanismos de seguridad y ajuste de pesos'),
(14, '2023-11-15', 'Revisión de las poleas y ajuste del sistema hidráulico'),
(15, '2023-08-20', 'Reemplazo de correas y revisión de los sensores de inclinación'),
(16, '2023-12-01', 'Revisión del sistema de escaleras y ajuste de velocidad'),
(17, '2023-07-25', 'Revisión de todos los sistemas de tracción y ajustes generales'),
(18, '2023-11-30', 'Mantenimiento general, revisión de la resistencia y el sistema de pedales'),
(19, '2023-10-05', 'Inspección de cables y ajuste de la resistencia de la máquina'),
(20, '2023-12-20', 'Revisión de la inclinación automática y calibración de velocidad');

SELECT * FROM machines;

SELECT * FROM machine_services;