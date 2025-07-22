-- Tabela: usuarios
CREATE TABLE usuarios (
    usuario_id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha TEXT NOT NULL,
    role VARCHAR(20) NOT NULL  -- exemplo: 'cliente', 'administrador'
);

-- Tabela: mesas
CREATE TABLE mesas (
    mesa_id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    capacidade INTEGER NOT NULL CHECK (capacidade > 0),
    status VARCHAR(20) NOT NULL  -- exemplo: 'disponível', 'reservada', 'inativa'
);

-- Tabela: reservas
CREATE TABLE reservas (
    id SERIAL PRIMARY KEY,
    usuario_id INTEGER NOT NULL,
    mesa_id INTEGER NOT NULL,
    data_reserva TIMESTAMP NOT NULL,
    status VARCHAR(20) NOT NULL,  -- exemplo: 'ativo', 'cancelado'

    CONSTRAINT fk_usuario
        FOREIGN KEY (usuario_id)
        REFERENCES usuarios(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_mesa
        FOREIGN KEY (mesa_id)
        REFERENCES mesas(id)
        ON DELETE CASCADE
);
