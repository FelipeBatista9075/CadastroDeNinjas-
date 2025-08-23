---
# 🥷 Cadastro de Ninjas

Uma aplicação **Spring Boot** para gerenciamento de **Ninjas** e suas **Missões**, utilizando **PostgreSQL** como banco de dados e **Swagger** para documentação da API.

---

## 📌 Funcionalidades

* Cadastro de **Ninjas**

  * Nome, e-mail, idade, rank, imagem.
  * Associação de cada ninja a uma missão.

* Cadastro de **Missões**

  * Nome da missão.
  * Rank de dificuldade (`Muito fácil`, `Fácil`, `Média`, `Difícil`, `Muito difícil`, `Kage`).
  * Associação de múltiplos ninjas a uma missão.

* Operações disponíveis:

  * Criar, listar, editar e excluir ninjas.
  * Criar, listar, editar e excluir missões.
  * Relacionar ninjas às missões.

---

## ⚙️ Tecnologias Utilizadas

* **Java 17+**
* **Spring Boot 3**
* **Spring Data JPA / Hibernate**
* **PostgreSQL**
* **Swagger (OpenAPI)**
* **Lombok**
* **Maven**
* **Docker & Docker Compose**

---

## 📂 Estrutura do Projeto

```
src/main/java/dev/javalo10x/CadastroDeNinjas
│── Ninjas/
│   ├── Controller
│   ├── DTO
│   ├── Mapper
│   ├── Model
│   ├── Repository
│   └── Service
│
│── Missoes/
│   ├── Controller
│   ├── DTO
│   ├── Mapper
│   ├── Model (inclui Enum RankMissoes)
│   ├── Repository
│   └── Service
│
└── CadastroDeNinjasApplication.java
```

---

## 🗄️ Configuração do Banco de Dados

Arquivo `application.properties`:

```properties
spring.application.name=CadastroDeNinjas

spring.datasource.url=jdbc:postgresql://localhost:5432/cadastroDeNinjas
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.username=postgres
spring.datasource.password=postgres

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.h2.console.enabled=true
```

> ⚠️ Altere `username` e `password` conforme sua configuração local do PostgreSQL.

---

## ▶️ Como Executar

### Usando Maven

```bash
# Clonar o repositório
git clone https://github.com/FelipeBatista9075/CadastroDeNinjas-.git

# Entrar no diretório
cd CadastroDeNinjas-

# Compilar e rodar
./mvnw spring-boot:run
```

### Usando Docker

```bash
# Build da imagem
docker build -t cadastro-ninjas .

# Rodar com Docker Compose
docker-compose up
```

---

## 📖 Documentação da API

Após rodar a aplicação, acesse o Swagger:

👉 [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## 🔗 Exemplos de Endpoints

### Ninjas

* `GET /ninjas/ui/listar` → Listar todos os ninjas.
* `GET /ninjas/ui/listar/{id}` → Buscar ninja por ID.
* `POST /ninjas/ui/salvar` → Criar novo ninja.
* `GET /ninjas/ui/deletar/{id}` → Excluir ninja.

### Missões

* `GET /missoes/ui/listar` → Listar todas as missões.
* `GET /missoes/ui/listar/{id}` → Buscar missão por ID.
* `POST /missoes/ui/salvar` → Criar nova missão.
* `GET /missoes/ui/deletar/{id}` → Excluir missão.

---

## 👨‍💻 Autor

Projeto desenvolvido por **[Felipe Batista](https://github.com/FelipeBatista9075)** 

---
