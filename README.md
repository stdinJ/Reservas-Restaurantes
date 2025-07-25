# Sistema de Reservas de Restaurante

Sistema para gerenciamento de reservas em restaurante, permitindo controle eficiente de mesas, usuários e agendamento de horários.

## Tecnologias Utilizadas

- **Back-End:** Java Spring Boot
- **Banco de Dados:** PostgreSQL
- **Autenticação:** JWT (JSON Web Token)
- **Outras Ferramentas:** Docker, Docker Compose, Postman

## Como levantar a aplicação com Docker Compose

### Pré-requisitos

- Docker instalado e rodando na sua máquina
- Docker Compose instalado (geralmente já vem com Docker Desktop)
- Java e Maven para build (opcional se quiser usar o Docker apenas para rodar a aplicação já empacotada)

---

### Passos

1. **Clone o repositório**

```bash
git clone https://github.com/stdinJ/Reservas-Restaurantes.git
cd Reservas-Restaurantes
```

2. **Compile a aplicação Spring Boot**

```bash
./mvnw clean package -DskipTests
```

3. **Suba os containers com Docker Compose**

```bash
docker-compose up --build -d
```

---

### Acessar a aplicação

- Backend API: [http://localhost:8080](http://localhost:8080)
- pgAdmin: [http://localhost:15432](http://localhost:15432)
    - Email: `joao@email.com`
    - Senha: `12345`
    - Para configurar o servidor no pgAdmin, use:
        - Host: `db`
        - Porta: `5432`
        - Usuário: `postgres`
        - Senha: `postgres`

---
