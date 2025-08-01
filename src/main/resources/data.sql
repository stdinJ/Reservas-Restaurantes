-- Tabela: usuarios
CREATE TABLE usuarios (
    usuario_id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha TEXT NOT NULL,
    role VARCHAR(20) NOT NULL
);

-- Tabela: mesas
CREATE TABLE mesas (
    mesa_id SERIAL PRIMARY KEY,
    capacidade INTEGER NOT NULL CHECK (capacidade > 0),
    status VARCHAR(20) NOT NULL
);

-- Tabela: reservas
CREATE TABLE reservas (
    id SERIAL PRIMARY KEY,
    usuario_id INTEGER NOT NULL,
    mesa_id INTEGER NOT NULL,
    data_reserva TIMESTAMP NOT NULL,
    status VARCHAR(20) NOT NULL,
    CONSTRAINT unique_mesa_data_reserva UNIQUE (mesa_id, data_reserva),
    CONSTRAINT fk_usuario FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id) ON DELETE CASCADE,
    CONSTRAINT fk_mesa FOREIGN KEY (mesa_id) REFERENCES mesas(mesa_id) ON DELETE CASCADE
);