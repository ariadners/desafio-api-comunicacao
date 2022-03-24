## API de Comunicação

### 💻 Sobre o projeto

Este projeto é um desafio de construção de uma API de Comunicação.

### 🛠 Tecnologias

- Java 8
- Spring Boot
- JPA
- Hibernate
- JUnit 5
- Swagger

### ⚙️ Funcionalidades


- [x] Agendar uma comunicação
- [x] Cancelar uma comunicação
- [x] Consultar uma comunicação

### 🚀 Como executar o projeto

Este projeto consiste apenas no back-end e ele é necessário estar sendo executado para a utilização da API.

Recomenda-se utilizar o Postman para inserção e consulta através de JSON.

#### Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
- [GitHub](https://desktop.github.com/)
- [PostgreSQL](https://www.postgresql.org/)
- [Spring Tool Suite](https://spring.io/tools)
- [Swagger](https://swagger.io/tools/swagger-ui/download/)
- [Postman](https://www.postman.com/downloads/)


#### Configure o PostgreSQL

Crie uma base de dados com o nome ``desafio``. 

Abra o arquivo ``src/main/resources/application.properties`` e ajuste o spring datasource ``username`` e ``password`` pelo do usuário de sua instalação PostgreSQL.

#### Clone este repositório

https://github.com/ariadners/desafio-api-comunicacao

``` bash

# Na raíz do projeto digite o seguinte comando para executar a aplicação em modo de desenvolvimento
$ mvnw spring-boot:run

# Ou gere o arquivo jar e execute através dele
$ mvnw clean package
$ java -jar target/comunicacao-api-0.0.1-SNAPSHOT.jar

# O servidor inciará na porta:8080 - acesse http://localhost:8080

```

#### API

A documentação da API está disponível em http://localhost:8080/swagger-ui.html

Pode ser utilizado o Swagger ou o [Postman](https://www.postman.com/downloads/) para executar os testes na API.

### Autora

Ariadne Santos 

Link do projeto https://github.com/ariadners/desafio-api-comunicacao


### 📝 Licença

Este projeto esta sobe a licença [GNU General Public License v2.0](./LICENSE).

